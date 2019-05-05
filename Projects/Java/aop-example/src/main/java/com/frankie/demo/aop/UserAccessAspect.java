package com.frankie.demo.aop;/*
 @author: Administrator
 @date: 2019/5/5-10:19
*/

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect // 切面
@Configuration // 对切面的Spring Bean配置
public class UserAccessAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // PointCut(切点表达式): "execution(* com.frankie.demo.data.*.*(..))"
    @Before("execution(* com.frankie.demo.data.*.*(..))")
    public void before(JoinPoint joinPoint) {
        //Advice
        logger.info(" Check for user access ");
        logger.info(" Allowed execution for {}", joinPoint);
    }
}
