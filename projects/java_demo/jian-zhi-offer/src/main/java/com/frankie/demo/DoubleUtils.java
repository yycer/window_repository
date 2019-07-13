package com.frankie.demo;/*
 @author: Administrator
 @date: 2019/7/13-17:06
*/

public class DoubleUtils {

    public static boolean equals(double x, double y){
        if (Math.abs(x - y) < 0.000001) {
            return true;
        } else {
            return false;
        }
    }
}
