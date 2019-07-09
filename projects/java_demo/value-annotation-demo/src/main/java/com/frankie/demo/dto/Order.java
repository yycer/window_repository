package com.frankie.demo.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
public class Order {

    @Value("${Order.type}")
    private Integer orderTypeId;
}
