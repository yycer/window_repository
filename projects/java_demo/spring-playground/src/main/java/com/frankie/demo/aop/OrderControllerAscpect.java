package com.frankie.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author: Yao Frankie
 * @date: 2019/9/2 16:31
 */
@Aspect
@Component
public class OrderControllerAscpect {

    @Pointcut("execution(public * com.frankie.demo.controller.OrderController+.*(..))")
    public void controllerPointCut(){

    }


    @Around("controllerPointCut()")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before xxxxxxxxxxxxxxxxx");

//        CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
//        String[] parameterNames = codeSignature.getParameterNames();
//        boolean hasOrderId = hasOrderId(parameterNames);

        Object[] args = joinPoint.getArgs();
        args[0] = "2";

        return joinPoint.proceed(args);
    }

    private boolean hasOrderId(String[] parameterNames) {
        boolean result = false;
        for(int i = 0; i < parameterNames.length; i++){
            if (parameterNames[i].equals("orderId")){
                result = true;
                break;
            }
        }
        return result;
    }
}
