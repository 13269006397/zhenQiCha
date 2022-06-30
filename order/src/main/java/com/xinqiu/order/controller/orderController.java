package com.xinqiu.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 订单模块
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class orderController {

    @Autowired
    private RestTemplate restTemplate;

    // 面向微服务编程，即通过微服务的名称来获取调用地址
    // 使用注册到 Spring Cloud Eureka 服务注册中心中的服务，即 application.name
    private static final String COMPANY_REST_URL_PROVIDER_PREFIX = "http://companyServer";

    @RequestMapping("/getOrder")
    public String getOrder(){
        System.out.println("---- order服务我被调用了 ----");
        System.out.println("---- 我现在要找company服务 ----");
        return restTemplate.getForObject(COMPANY_REST_URL_PROVIDER_PREFIX + "/company/getCompanyList", String.class);
        /*return "Hello World";*/
    }


    /**
     * order模块远程调用company模块
     * @return String
     */
    @PostMapping("/findCompanyByOrder")
    public String findCompanyByOrder() {
        return restTemplate.getForObject(COMPANY_REST_URL_PROVIDER_PREFIX + "/company/getCompanyList", String.class);
    }

}
