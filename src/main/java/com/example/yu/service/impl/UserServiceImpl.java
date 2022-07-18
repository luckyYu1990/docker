package com.example.yu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.yu.controller.UserParams;
import com.example.yu.entities.User;
import com.example.yu.mapper.UserMapper;
import com.example.yu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    public static final String CACHE_KEY_USER = "user:";

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public IPage<User> getUserPageList(UserParams userParams) {
        Page<User> pageUser = new Page<>(userParams.getCurrentPage(), userParams.getPageSize());
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (userParams.getUserName() != null) {
            queryWrapper.like("username", userParams.getUserName());
        }
        return userMapper.selectPage(pageUser, queryWrapper);
    }

    @Override
    public User findUserById(Long id) {
        String key = CACHE_KEY_USER + id;
        User user = (User)redisTemplate.opsForValue().get(key);
        if (user != null) {
            return user;
        }
        User dbUser = userMapper.selectById(id);
        if (dbUser != null) {
            redisTemplate.opsForValue().set(key, dbUser);
        }
        return dbUser;
    }

    @Override
    public void addUser(User user) {
        int i = userMapper.insert(user);
        System.out.println(i);
        if (i > 0){
            String key = CACHE_KEY_USER + user.getId();
            redisTemplate.opsForValue().set(key, user);
            //redisTemplate.
        }

    }
}
