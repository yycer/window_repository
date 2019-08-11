package com.frankie.demo;/*
 @author: Administrator
 @date: 2019/8/11-09:17
*/

import org.junit.Assert;
import org.junit.Test;

public class JustForTest {
    @Test
    public void numberOfOneTest(){
        int x = 7;
        int count = 0;
        while (x != 0){
            x = x & (x - 1);
            count++;
        }
        System.out.println(count);
    }

    @Test
    public void firstOneTest(){
        int x = 12;
        int count = 0;
        while ((x & 0x1) != 1){
            x = (x >> 1);
            count++;
        }
        Assert.assertEquals(count, 2);
    }
}
