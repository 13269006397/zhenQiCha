package com.xinqiu.user.controller;

import com.xinqiu.api.entity.User;
import com.xinqiu.user.service.userService;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户模块
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class userController {

    @Autowired
    private userService userService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/getUser")
    public User get(@RequestBody User user) {
        return userService.get(user.getId());
    }

    @PostMapping("/getUserList")
    public List<User> list() {
        return userService.getAllUser();
    }

}
