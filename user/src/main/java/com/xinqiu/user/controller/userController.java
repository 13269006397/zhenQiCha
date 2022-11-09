package com.xinqiu.user.controller;

import com.xinqiu.api.entity.Common;
import com.xinqiu.api.entity.User;
import com.xinqiu.user.service.userService;
import com.xinqiu.user.utils.RedisUtil;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    private RedisUtil redisUtil;

    private static final String COMPANY_REST_URL_PROVIDER_PREFIX = "http://companyServer";
    private static final String ORDER_REST_URL_PROVIDER_PREFIX = "http://orderServer";


    @PostMapping("/getUser")
    public String getUser(@RequestBody User user) {
        String name = (String) redisUtil.get(Common.USER + user.getId());
        if (StringUtil.isNullOrEmpty(name)){
            User resultUser = userService.get(user.getId());
            redisUtil.set(Common.USER + user.getId(), resultUser.getNickName());
            name = resultUser.getNickName();
        }
        return name;
    }

    @PostMapping("/getUserList")
    public List<User> getUserList() {
        List<User> allUser = userService.getAllUser();
        return allUser;

    }

    /**
     * user模块远程调用company模块
     * @return String
     */
    @GetMapping("/findCompanyByUser")
    public String findCompanyByUser() {
        return restTemplate.getForObject(COMPANY_REST_URL_PROVIDER_PREFIX + "/company/getCompanyList", String.class);
    }

    /**
     * user模块远程调用company模块
     * @return String
     */
    @PostMapping("/getOrder")
    public String getOrder() {
        return restTemplate.getForObject(ORDER_REST_URL_PROVIDER_PREFIX + "/order/getOrder", String.class);
    }

    @GetMapping("/getList")
    public String getList() {
        return "goodDay!";

    }





}
