package com.frankie.demo;

public class SortUtils {

    public static void swap(int[] a, int x, int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
