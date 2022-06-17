package com.xinqiu.companyfone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // Spring cloud Eureka 客户端，自动将本服务注册到 Eureka Server 注册中心中
public class CompanyFoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanyFoneApplication.class, args);
        System.out.println("---- company-fone服务启动 ----");
    }

}
