package com.frankie.demo.data;/*
 @author: Administrator
 @date: 2019/5/5-10:20
*/

import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {
    public String retrieveSomething() {
        return "Dao1";
    }
}
