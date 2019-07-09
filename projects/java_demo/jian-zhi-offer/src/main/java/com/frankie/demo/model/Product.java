package com.frankie.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class Product {

    private String name;
    private String retailPrice;
    private LocalDateTime startDate;

    public Product(String name, String price, LocalDateTime dateTime){
        this.name = name;
        this.retailPrice = price;
        this.startDate = dateTime;
    }
}