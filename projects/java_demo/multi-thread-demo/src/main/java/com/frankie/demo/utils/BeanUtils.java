package com.frankie.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Yao Frankie
 * @date: 2019/11/30 14:20
 */
@Component
public class BeanUtils {

    @Autowired
    private ApplicationContext applicationContext;

    public void printAllBeanNames(){
        String beanNames = Arrays.toString(applicationContext.getBeanDefinitionNames());
        String result = beanNames.replaceAll(",", "\n");
        System.out.println(result);
    }
}
