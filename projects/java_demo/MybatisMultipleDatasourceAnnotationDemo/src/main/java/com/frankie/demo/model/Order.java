package com.frankie.demo.model;/*
 @author: Administrator
 @date: 2019/4/14-17:37
*/

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
public class Order {

    private String basketOrderId;
    private Integer stage;
    private String userId;
    private Timestamp createdDate;
}
