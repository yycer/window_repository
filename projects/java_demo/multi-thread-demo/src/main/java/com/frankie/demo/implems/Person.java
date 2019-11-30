package com.frankie.demo.implems;

import com.frankie.demo.interfaces.Party;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author: Yao Frankie
 * @date: 2019/11/30 15:39
 */
@Component
public class Person implements Party {

    @Bean(value = "personBean")
    public Person buildPersonForTest(){
        return new Person();
    }

    @Override
    public void printDefault(){
        System.out.println("Hi Person.");
    }
}
