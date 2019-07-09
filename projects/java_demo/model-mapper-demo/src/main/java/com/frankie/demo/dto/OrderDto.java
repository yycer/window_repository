package com.frankie.demo.dto;/*
 @author: Administrator
 @date: 2019/4/24-08:01
*/

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Setter
@Getter
public class OrderDto {
    private String orderId;
    private List<ProductDto> product;
    private LocalDateTime createdDate;
}
