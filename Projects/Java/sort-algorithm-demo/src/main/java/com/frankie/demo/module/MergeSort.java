package com.frankie.demo.module;/*
 @author: Administrator
 @date: 2019/5/19-22:06
*/

public class MergeSort {

    public static void doMergeSort(int[] a){
        if(a.length < 1) return;

        mergeSort(a, 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int l, int r) {
        if(l >= r) return;

        int mid = (l + r) / 2;
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);
        merge(a, l, mid + 1, r);
    }

    private static void merge(int[] a, int l, int mid, int r) {

        int[] leftArray = new int[mid - l];
        int[] rightArray = new int[r - mid + 1];

        for (int i = l; i < mid; i++){
            leftArray[i - l] = a[i];
        }

        for (int j = mid; j <= r; j++){
            rightArray[j - mid] = a[j];
        }

        int i = 0, j = 0, k = l;
        while(i < leftArray.length && j < rightArray.length){
            if (Sort.less(leftArray[i], rightArray[j])){
                a[k++] = leftArray[i++];
            }else {
               a[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) a[k++] = leftArray[i++];
        while (j < rightArray.length) a[k++] = rightArray[j++];
    }

}
