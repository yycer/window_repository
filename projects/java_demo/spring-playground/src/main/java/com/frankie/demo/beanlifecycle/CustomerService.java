package com.frankie.demo.beanlifecycle;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Setter
@Getter
public class CustomerService {

    private String message;


    @PostConstruct
    public void init(){
        System.out.println("Customer service: PostConstruct ");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Customer service: PreDestroy");
    }
}
