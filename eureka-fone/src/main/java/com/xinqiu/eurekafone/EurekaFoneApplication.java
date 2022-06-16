package com.xinqiu.eurekafone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer //开启 Eureka server,接受其他微服务的注册
@SpringBootApplication
public class EurekaFoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaFoneApplication.class, args);
        System.out.println("---- eureka-fone服务启动 ----");
    }

}
