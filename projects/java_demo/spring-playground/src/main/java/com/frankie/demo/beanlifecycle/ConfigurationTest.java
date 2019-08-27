package com.frankie.demo.beanlifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component()
public class ConfigurationTest {

    @Bean
    public Foo foo(){
        Foo foo = new Foo();
        System.out.println(foo);
        return foo;
    }

    @Bean
    public Foo bar(){
        Foo foo = foo();
        System.out.println(foo);
        return foo;
    }
}
