package com.frankie.demo.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Order {

    private String productName;
    private String productRetailPrice;
    private String productStartDate;

    public Order(String name, String price){
        this.productName = name;
        this.productRetailPrice = price;
    }
}
