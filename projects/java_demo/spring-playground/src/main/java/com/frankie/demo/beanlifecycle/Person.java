package com.frankie.demo.beanlifecycle;/*
 @author: Administrator
 @date: 2019/8/26-07:48
*/

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Setter
@Getter
public class Person implements InitializingBean, DisposableBean {

    private String name;

    public Person(){
        System.out.println("Constructor of people is called.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroy method of person is called.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet method of person is called.");
    }
}
