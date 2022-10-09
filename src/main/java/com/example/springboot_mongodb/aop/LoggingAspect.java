package com.example.springboot_mongodb.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;


@Aspect
@Component
@Slf4j
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);


    @Around("com.example.springboot_mongodb.aop.PointCuts.inControllerLayer()")
    public Object logEndpointPerformance(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        Long startTime = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        Long duration = System.currentTimeMillis() - startTime;

        log.info("This endpoint took " + duration + " ms");

        return result;
    }
}
