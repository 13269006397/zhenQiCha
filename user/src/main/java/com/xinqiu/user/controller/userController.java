package com.xinqiu.user.controller;

import com.xinqiu.api.entity.User;
import com.xinqiu.user.service.userService;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户模块
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private userService userService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private RestTemplate restTemplate;

    // 面向微服务编程，即通过微服务的名称来获取调用地址
    // 使用注册到 Spring Cloud Eureka 服务注册中心中的服务，即 application.name
    private static final String REST_URL_PROVIDER_PREFIX = "http://companyServer";

    @PostMapping("/getUser")
    public User getUser(@RequestBody User user) {
        return userService.get(user.getId());
    }

    @PostMapping("/getUserList")
    public List<User> getUserList() {
        return userService.getAllUser();
    }

    /**
     * user模块远程调用company模块
     * @return String
     */
    @PostMapping("/findCompanyByUser")
    public String findCompanyByUser() {
        return restTemplate.getForObject(REST_URL_PROVIDER_PREFIX + "/company/getCompanyList", String.class);
    }

}
