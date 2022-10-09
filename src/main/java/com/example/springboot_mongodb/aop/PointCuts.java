package com.example.springboot_mongodb.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCuts {

    @Pointcut("execution(* com.example.springboot_mongodb.controller.OwnerController.*(..))")
    public void inControllerLayer() {};
}
