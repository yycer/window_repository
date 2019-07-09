package com.frankie.demo;/*
 @author: Administrator
 @date: 2019/7/6-22:44
*/

public class VolatileTest {
    public static volatile int count = 0;

    public static void increase(){
        count++;
    }
}
