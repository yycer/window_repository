package com.frankie.demo;


public class Sort {

    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    public static boolean larger(Comparable a, Comparable b){
        return a.compareTo(b) > 0;
    }

}
