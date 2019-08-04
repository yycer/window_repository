package com.frankie.demo;

public class SortUtils {

    public static void swap(int[] a, int x, int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    public static boolean greater(Comparable a, Comparable b){
        return a.compareTo(b) > 0;
    }
}
