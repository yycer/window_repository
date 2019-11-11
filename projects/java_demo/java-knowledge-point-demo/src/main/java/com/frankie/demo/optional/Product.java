package com.frankie.demo.optional;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author: Yao Frankie
 * @date: 2019/11/11 21:17
 */
@Setter
@Getter
public class Product {

    public Product(String sku, int quantity, BigDecimal price){
        this.sku      = sku;
        this.quantity = quantity;
        this.price    = price;
    }

    public String     sku;
    public int        quantity;
    public BigDecimal price;
}
