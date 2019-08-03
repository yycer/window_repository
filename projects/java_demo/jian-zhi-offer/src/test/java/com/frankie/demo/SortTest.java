package com.frankie.demo;/*
 @author: Administrator
 @date: 2019/8/3-18:44
*/

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SortTest {

    @Test
    public void selectionSortTest(){
        int[] a = {1, 5, 4, 6, 2};
        int[] result = Sort.selectionSort(a);
        Assert.assertEquals(Arrays.toString(result), "[1, 2, 4, 5, 6]");
    }

    @Test
    public void insertionSortTest(){
        int[] a = {5, 1, 4, 6, 2};
        int[] b = {5, 1, 4, 6, 2};
        int[] r1 = Sort.insertionSort(a);
        int[] r2 = Sort.insertionOptimization(b);
        Assert.assertEquals(Arrays.toString(r1), "[1, 2, 4, 5, 6]");
        Assert.assertEquals(Arrays.toString(r2), "[1, 2, 4, 5, 6]");
    }
}
