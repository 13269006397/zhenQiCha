package com.xinqiu.user.utils;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogServer {

    @Before("execution(public * com.xinqiu.user.controller..*.*(..))")
    public void doBefore() {
        System.out.println("---- 执行日志 ----");
    }
}
