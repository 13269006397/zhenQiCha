package com.xinqiu.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单模块
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class orderController {


    @RequestMapping("/getOrder")
    public String getOrder(){
        System.out.println("被调用了");
        return "Hello World";
    }

}
