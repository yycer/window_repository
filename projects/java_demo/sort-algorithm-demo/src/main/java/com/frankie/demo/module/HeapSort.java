package com.frankie.demo.module;/*
 @author: Administrator
 @date: 2019/6/3-21:25
*/

import java.util.logging.Level;

public class HeapSort {

    public static void heapify(int[] a, int currentRootNode, int length){

        if(currentRootNode < length){
            // 左子树和右子树的位置
            int left = 2 * currentRootNode + 1;
            int right = 2 * currentRootNode + 2;

            // 将当前父节点位置看成是最大的
            int max = currentRootNode;

            if(left < length){
                if(Sort.larger(a[left], a[max])) max = left;
            }

            if(right < length){
                if(Sort.larger(a[right], a[max])) max = right;
            }

            if(max != currentRootNode){
                Sort.swap(a, max, currentRootNode);
                heapify(a, max, length);
            }
        }
    }

    /**
     * 完成一次建堆，最大值的堆的顶部（根节点）
     * @param a
     * @param length
     */
    public static void maxHeapify(int[] a, int length){

        // 数组的尾部开始，知道第一个元素
        for (int i = length - 1; i >= 0; i--){
            heapify(a, i, length);
        }
    }

    public static void heapSort(int[] a){

        for (int i = 0; i < a.length; i++){

            // 每次建堆(Build)就可以排除一个元素
            maxHeapify(a, a.length - i);

            // 交换(Swap)
            Sort.swap(a, 0, a.length - 1 - i);
        }
    }
}
