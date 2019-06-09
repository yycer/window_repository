package com.frankie.demo;/*
 @author: Administrator
 @date: 2019/6/9-10:48
*/

public class DigitUtils {

    /**
     * Convert a integer to binary number.
     * @param x
     * @return
     */
    public static String number2Binary(int x){

        String result = "";

        if (x == 0) return "0";
        while (x > 0){
            result = (x % 2 == 0 ? "0" : "1") + result;
            x /= 2;
        }
        return result;
    }
}
