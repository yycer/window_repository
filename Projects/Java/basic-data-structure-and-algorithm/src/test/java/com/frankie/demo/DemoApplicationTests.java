package com.frankie.demo;

import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    int[] a = {3, 2, 3, 6, 2};

    @Test
    public void findMinElement(){
        int min = a[0];
        for (int i = 1; i < a.length; i++){
            if(Sort.less(a[i], min)) min = a[i];
        }

        System.out.println(min);
    }

    @Test
    public void findSecondMinimumElement(){

        int secondMinElement = ArrayPlayground.getSecondMinElement(a);
    }

    @Test
    public void findSecondMinElement2(){
        int secondMin = ArrayPlayground.getSecondMinElementOptimization(a);
    }

    @Test
    public void findFirstNonRepeatingEle(){

        int firstNonRepeatingElem = ArrayPlayground.getFirstNonRepeatingElem(a);
        System.out.println(firstNonRepeatingElem);
    }

    @Test
    public void findFirstNonRepeatingElemUsingHashMap(){
        int result = ArrayPlayground.getFirstNonRepeatingElemUsingHashMap(a);
        System.out.println(result);
    }
}
