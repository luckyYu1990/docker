package com.example.yu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.yu.controller.UserParams;
import com.example.yu.entities.User;

public interface UserService {
    IPage<User> getUserPageList(UserParams userParams);

    User findUserById(Long id);

    void addUser(User user);
}
