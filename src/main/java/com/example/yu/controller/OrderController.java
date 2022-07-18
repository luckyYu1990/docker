package com.example.yu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.yu.entities.User;
import com.example.yu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("order")
public class OrderController {

    @Value("${server.port}")
    private String port;
    @Autowired
    private UserService userService;

    @RequestMapping("docker")
    public String helloDocker() {
        return "hello docker" + "\t" + port + "\t" + UUID.randomUUID().toString();
    }

    @RequestMapping("index")
    public String index() {
        return "端口号：" + "\t" + port + "\t" +UUID.randomUUID().toString();
    }

    @PostMapping("usersPageList")
    public IPage<User> getUsers(@RequestBody UserParams userParams) {
        IPage<User> userPageList = userService.getUserPageList(userParams);
        return userPageList;
    }

    @GetMapping("user/{id}")
    public User findUser(@PathVariable Long id) {
        return userService.findUserById(id);
    }
}
