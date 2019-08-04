package com.frankie.demo;/*
 @author: Administrator
 @date: 2019/8/3-18:34
*/

import java.util.UnknownFormatConversionException;

public class Sort {

    /**
     * 冒泡排序的缺点
     * 1. 时间复杂度O(n^2)
     * 2. 两个元素之间交换的频率太高。
     */
    public static int[] bubbleSort(int[] a){
        int length = a.length;
        if (length < 1){
            return null;
        }
        for (int i = 0; i < length - 1; i++){
            for (int j = length - 1; j > i; j--){
                if (a[j] < a[j - 1]){
                    SortUtils.swap(a, j, j - 1);
                }
            }
        }
        return a;
    }

    /**
     * 选择排序(选择剩下元素中最小的)。
     * 1. 缺点: 时间复杂度O(n^2)
     */
    public static int[] selectionSort(int[] a){
        int length = a.length;
        if (length < 1){
            return null;
        }

        for (int i = 0; i < length - 1; i++){
            int minIndex = i;
            for (int j = i + 1; j < length; j++){
                if (a[j] < a[minIndex]){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                SortUtils.swap(a, minIndex, i);
            }
        }
        return a;
    }


    /**
     * 插入排序(不能影响第一重遍历中的i)。
     */
    public static int[] insertionSort(int[] a){
        int length = a.length;
        if (length < 1){
            return null;
        }

        for (int i = 1; i < length; i++){
            int j = i - 1;
            while (j >= 0){
                if (a[j + 1] < a[j]){
                    SortUtils.swap(a, j, j + 1);
                }
                j--;
            }
        }
        return  a;
    }

    /**
     * 插入排序优化版
     */
    public static int[] insertionOptimization(int[] a){
        int length = a.length;
        if (length < 1){
            return null;
        }

        for (int i = 1; i < length; i++){
            for (int j = i; j > 0 && SortUtils.less(a[j], a[j - 1]); j--){
                SortUtils.swap(a, j, j - 1);
            }
        }
        return a;
    }

    /**
     * 希尔排序(关键是gap)。
     */
    public static int[] shellSort(int[] a){
        int length = a.length;
        if (length < 1){
            return null;
        }

        int gap = length >> 1;
        while (gap >= 1){
            for (int i = gap; i < length; i++){
                for (int j = i; j >= gap && SortUtils.less(a[j], a[j - gap]); j -= gap){
                    SortUtils.swap(a, j, j - gap);
                }
            }
            gap >>= 1;
        }
        return a;
    }
}
