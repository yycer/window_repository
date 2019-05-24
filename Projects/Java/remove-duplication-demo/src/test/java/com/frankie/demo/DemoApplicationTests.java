package com.frankie.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void removeDuplicationTest1() {
        List<Integer> a = Arrays.asList(1, 3, 9, 7, 3, 2);

        List<Integer> result = new ArrayList();

        for (int i: a){
            if(!result.contains(i)) result.add(i);
        }
        System.out.println(2);
    }

    @Test
    public void removeDupUsingSet(){
        int[] a = {1, 3, 9, 7, 3, 2};

        HashSet<Integer> intSet = new HashSet<>();
        for (int i: a){
            intSet.add(i);
        }

        System.out.println(intSet);

    }

}
