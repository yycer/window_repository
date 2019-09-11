package com.frankie.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author: Yao Frankie
 * @date: 2019/9/11 15:11
 */
@Aspect
@Component
@Slf4j
public class CostTimeAspect {

    @Pointcut("@annotation(com.frankie.demo.annotation.CostTime)")
    private void pointCut(){

    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        LocalDateTime startTime = LocalDateTime.now();
        joinPoint.proceed();
        LocalDateTime endTime = LocalDateTime.now();
        long result = Duration.between(startTime, endTime).toMillis();
        log.warn("cost time: " + result);
    }

}
