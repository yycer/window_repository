package com.frankie.demo.beanlifecycle;/*
 @author: Administrator
 @date: 2019/8/26-22:08
*/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
//@Component
public class AppConfig {

    @Bean
    public Foo foo(){
        return new Foo();
    }

    public Bar bar(){
        return new Bar();
    }

}
