package com.frankie.demo.model;/*
 @author: Administrator
 @date: 2019/4/14-17:36
*/

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
public class UsersInfo {

    private Integer age;
    private String realName;
    private String userId;
    private Timestamp createdDate;
}