package com.frankie.demo;/*
 @author: Administrator
 @date: 2019/8/11-09:17
*/

import com.frankie.demo.model.ThreePart;
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

    @Test
    public void numberOfOneBetween1AndNTest(){
        int x = 21345;
        ComprehensiveUtils cu = new ComprehensiveUtils();

        int count = 0;
        int i = 1;
        int high = x;

        while (high != 0){
            ThreePart threePart = cu.getThreePart(x, i);
            high = threePart.getHigh();
            int cur = threePart.getCur();
            int low = threePart.getLow();

            if (cur > 1){
                count += (high + 1) * (int) Math.pow(10, i - 1);
            }
            else if (cur < 1){
                count += high * (int) Math.pow(10, i - 1);
            }
            else {
                count += high * (int) Math.pow(10, i - 1) + low + 1;
            }
            i++;
        }
        Assert.assertEquals(count, 18821);
    }
}



















