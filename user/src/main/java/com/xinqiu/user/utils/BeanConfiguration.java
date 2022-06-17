package com.xinqiu.user.utils;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// 配置类注解
@Configuration
public class BeanConfiguration {

    @Bean  //将 RestTemplate 注入到容器中
    @LoadBalanced  //在客户端使用 RestTemplate 请求服务端时，开启负载均衡（Ribbon）
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    // 添加IRule为随机策略
    @Bean
    public IRule myRule() {
        // RandomRule 为随机策略
        return  new RandomRule();
    }
}
