package com.frankie.demo.module;/*
 @author: Administrator
 @date: 2019/5/17-07:55
*/

import org.springframework.stereotype.Service;

@Service
public class Sort {

    public static boolean less(Comparable x, Comparable y){
        return x.compareTo(y) < 0;
    }

    public static void exch(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
