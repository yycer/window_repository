package com.frankie.demo.module;

public class HeapSort {

    public static void heapSort(int[] a){
        int length = a.length;

        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(a, length, i);
        }

        for (int i = length - 1; i >= 0; i--){
            Sort.swap(a, 0, i);
            heapify(a, i, 0);
        }
    }

    private static void heapify(int[] a, int length, int i) {

        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if (left < length && Sort.larger(a[left], a[max])) max = left;

        if (right < length && Sort.larger(a[right], a[max])) max = right;

        if (max != i){
            Sort.swap(a, i, max);
            heapify(a, length, max);
        }
    }


}
