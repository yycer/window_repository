package com.frankie.demo.model;/*
 @author: Administrator
 @date: 2019/4/13-16:00
*/

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class UserInfo {
    private String userId;
    private String realName;
    private Integer age;
    private LocalDateTime createdDate;
}
