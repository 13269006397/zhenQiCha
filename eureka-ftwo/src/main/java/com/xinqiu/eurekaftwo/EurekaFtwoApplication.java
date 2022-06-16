package com.xinqiu.eurekaftwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer //开启 Eureka server,接受其他微服务的注册
@SpringBootApplication
public class EurekaFtwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaFtwoApplication.class, args);
        System.out.println("---- eureka-ftwo服务启动 ----");
    }

}
