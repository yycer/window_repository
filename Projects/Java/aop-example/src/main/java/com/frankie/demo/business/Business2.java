package com.frankie.demo.business;/*
 @author: Administrator
 @date: 2019/5/5-10:20
*/

import com.frankie.demo.data.Dao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Business2 {
    @Autowired
    private Dao2 dao2;

    public String calculateSomething() {
        //Business Logic
        return dao2.retrieveSomething();
    }
}
