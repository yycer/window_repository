package com.frankie.demo;/*
 @author: Administrator
 @date: 2019/8/11-09:17
*/

import com.frankie.demo.model.ThreePart;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.assertj.core.data.MapEntry;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void isUglyTest(){
        int x = 10;
//        int x2 = 5270;

        while (x % 2 == 0){
            x /= 2;
        }
        while (x % 3 == 0){
            x /= 3;
        }
        while (x % 5 == 0){
            x /= 5;
        }
        boolean isUgly = x == 1;
        Assert.assertTrue(isUgly);
    }

    @Test
    public void firstNotRepeatingCharTest(){
        String s = "abcyabcs";
        char result = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c: chars){
            if (map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }
            else{
                map.put(c, 1);
            }
        }

        for (char c: chars){
            if (map.get(c) == 1){
                result = c;
                // 防止被s覆盖。
                break;
            }
        }
        Assert.assertEquals(result, 'y');
    }

    @Test
    public void getUglyOptimizationTest(){
        int x = 10;
        ComprehensiveUtils cu = new ComprehensiveUtils();

        int[] uglyArray = new int[x];
        uglyArray[0] = 1;

        int x2 = 0;
        int x3 = 0;
        int x5 = 0;
        int i  = 1;

        while (i < x){
            int min = cu.getMinAmongThreeElement(2 * uglyArray[x2], 3 * uglyArray[x3], 5 * uglyArray[x5]);
            uglyArray[i] = min;

            if (uglyArray[x2] * 2 <= min){
                x2++;
            }
            if (uglyArray[x3] * 3 <= min){
                x3++;
            }
            if (uglyArray[x5] * 5 <= min){
                x5++;
            }
            i++;
        }
        System.out.println(uglyArray[x - 1]);
    }
}



















