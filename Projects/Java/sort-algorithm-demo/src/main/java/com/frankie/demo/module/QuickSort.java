package com.frankie.demo.module;/*
 @author: Administrator
 @date: 2019/5/24-21:07
*/

import java.io.OutputStream;

public class QuickSort {

   public static void quickSort(int[] a){

       int length = a.length;
       if(length < 1) return;

       doQuickSort(a, 0, length - 1);
   }

    private static void doQuickSort(int[] a, int l, int r) {

       if(l >= r) return;
        int j = partition(a, l, r);
        doQuickSort(a, l , j - 1);
        doQuickSort(a, j + 1 , r);
    }

    private static int partition(int[] a, int l, int r) {

       int i = l, j = r + 1;
       int pivot = a[l];

       while(true){
           while (Sort.less(a[++i], pivot)) if (i == r) break;
           while (Sort.less(pivot, a[--j])) if (j == l) break;
           if(i >= j) break;
           Sort.swap(a, i, j);
       }
       Sort.swap(a, l, j);
       return j;
    }

    public static void quick3(int[] a, int l, int r){

       if(l >= r) return;
       int lt = l, i = l + 1, gt = r;
       int pivot = a[l];

       while (i <= gt){
           if (a[i] < pivot) Sort.swap(a, lt++, i++);
           else if(a[i] > pivot) Sort.swap(a, i, gt--);
           else i++;
       }
       quick3(a, l, lt - 1);
       quick3(a, gt + 1, r);
    }
}
