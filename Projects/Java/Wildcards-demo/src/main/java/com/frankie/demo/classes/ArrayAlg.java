package com.frankie.demo.classes;/*
 @author: Administrator
 @date: 2019/5/2-15:19
*/

import java.util.Collection;

public class ArrayAlg {
    // Generic method.
    // <T extends Comparable> represents type variable(类型变量).
    public static <T extends Comparable> Pair<T> minmax(T[] a){
        if(a == null || a.length == 0) return null;
        T min = a[0];
        T max = a[0];
        for (T s: a){
            if(min.compareTo(s) > 0 ) min = s;
            if(max.compareTo(s) < 0) max = s;
        }
        return new Pair<>(min, max);
    }

    public static double sum(Collection<? extends Number> nums){
        double result = 0.0;
        for (Number n: nums){
            result += n.doubleValue();
        }
        return result;
    }

    public static void count(Collection<? super Integer> ints, int n){
        for (int i = 0; i < n; i++){
            ints.add(i);
        }
    }
}

