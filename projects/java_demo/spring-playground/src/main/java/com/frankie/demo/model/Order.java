package com.frankie.demo.model;/*
 @author: Administrator
 @date: 2019/8/31-09:58
*/

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
//@XmlRootElement
public class Order {
    private String     orderId;
    private BigDecimal total;

    @Override
    public String toString(){
        return "---Order{" +
                "orderId: " + orderId +
                ", total: " + total +
                "}---";
    }
}
