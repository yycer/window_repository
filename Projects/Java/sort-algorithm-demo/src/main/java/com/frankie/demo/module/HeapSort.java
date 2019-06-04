package com.frankie.demo.module;

public class HeapSort {

    public static void heapSort(int[] a){

        int length = a.length;

        for (int i = length / 2 - 1; i >= 0; i--){
            heapify(a, length, i);
        }

        for (int i = length - 1; i >= 0; i--){
            Sort.swap(a, i, 0);
            heapify(a, i, 0);
        }
    }

    private static void heapify(int[] a, int length, int currentRootNode) {

        int max = currentRootNode;
        int left = 2 * currentRootNode + 1;
        int right = 2 * currentRootNode + 2;

        if (Sort.less(left, length) && Sort.larger(a[left], a[max])) max = left;
        if (Sort.less(right, length) && Sort.larger(a[right], a[max])) max = right;
        if (max != currentRootNode){
            Sort.swap(a, max, currentRootNode);
            heapify(a, length, max);
        }
    }

}
