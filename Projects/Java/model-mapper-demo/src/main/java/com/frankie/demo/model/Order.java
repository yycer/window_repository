package com.frankie.demo.model;/*
 @author: Administrator
 @date: 2019/4/24-08:03
*/

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class Order {

    private String basketOrderId;
    private List<Product> productInfo;
    private LocalDateTime createdDate;
}
