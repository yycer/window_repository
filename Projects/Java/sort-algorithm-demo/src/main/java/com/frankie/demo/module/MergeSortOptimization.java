package com.frankie.demo.module;

public class MergeSortOptimization {

    /**
     * int[] a = {9, 5, 6, 3, 7};
     */

    public static void mergeSort(int[] a){
        if(a.length <= 1) return;
        int r = a.length - 1;
        doMergeSort(a, 0, r);
    }


    public static void doMergeSort(int[] a, int l, int r){

        if(l >= r) return;
        int mid = (l + r) / 2;
        doMergeSort(a, l, mid);
        doMergeSort(a, mid + 1, r);
        merge(a, l, mid + 1, r);
    }

    /**
     *
     * @param a
     * @param l = 0
     * @param mid = (4-0)/2 = 2
     * @param r = 4
     */
    private static void merge(int[] a, int l, int mid, int r) {

        // Step1: 创建并填充左右有序临时数组
        int[] leftSortedArray = new int[mid - l];
        int[] rightSortedArray = new int[r - mid + 1];

        for (int i = l; i < mid; i++)
            leftSortedArray[i - l] = a[i];

        for (int j = mid; j <= r; j++)
            rightSortedArray[j - mid] = a[j];

        // Step2: 合并两个有序的数组
        int i = 0, j = 0, k = l;
        while (i < leftSortedArray.length && j < rightSortedArray.length){
            if(Sort.less(leftSortedArray[i], rightSortedArray[j])) a[k++] = leftSortedArray[i++];
            else a[k++] = rightSortedArray[j++];
        }
        while (i < leftSortedArray.length) a[k++] = leftSortedArray[i++];
        while (j < rightSortedArray.length) a[k++] = rightSortedArray[j++];
    }

}
