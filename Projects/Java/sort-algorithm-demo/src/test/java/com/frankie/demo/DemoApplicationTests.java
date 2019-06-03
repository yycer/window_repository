package com.frankie.demo;

import com.frankie.demo.module.HeapSort;
import com.frankie.demo.module.MergeSort;
import com.frankie.demo.module.QuickSort;
import com.frankie.demo.module.Sort;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    /**
     * 比较次数：5+4+3+2+1 = 15 - n(n-1)/2
     * 交换次数：1+0+1+1+1 = 4
     */
    @Test
    public void selectionSmallestSort() {
        int[] ints = {1, 3, 5, 10, 10, 7};

        for (int i = 0; i < ints.length - 1; i++){
            Integer min = i;
            for (int j = i + 1; j < ints.length; j++){
                if(ints[j] < ints[min]) min = j;
            }

            if(ints[i] != ints[min]){
                int tmp = ints[i];
                ints[i] = ints[min];
                ints[min] = tmp;
            }
        }
    }


    /**
     * 比较次数：5+4+3+2+1 = 15
     * 交换次数：2+2+2+1+1 = 8
     */
    @Test
    public void selectionSmallestSortTest1(){
        int[] a = {8, 5, 7, 3, 9, 6};

        for (int i = 0; i < a.length - 1; i++){
            for (int j = i + 1; j < a.length; j++){
                if(a[j] < a[i]) Sort.swap(a, j, i);
            }
        }

    }


    @Test
    public void selectionLargestSort(){

        int[] ints = {8, 5, 7, 3, 9, 6};

        for (int i = 0; i < ints.length - 1; i++){
            int max = i;
            for (int j = i + 1; j < ints.length; j++){
                if(ints[j] > ints[max]) max = j;
            }
            if(ints[i] != ints[max]){
                int tmp = ints[i];
                ints[i] = ints[max];
                ints[max] = tmp;
            }
        }
    }


    @Test
    public void selectionSortSmallestUseModule(){
        int[] a = {8, 5, 7, 3, 9, 6};

        for (int i = 0; i < a.length - 1; i++){
            int min = i;
            for (int j = i + 1; j < a.length; j++){
                if(Sort.less(a[j], a[min])) min = j;
            }
            if(min != i) Sort.swap(a, i, min);
        }
    }


    @Test
    public void selectionLargestSortUseModule(){
        int[] a = {8, 5, 7, 3, 9, 6};

        for (int i = 0; i < a.length - 1; i++){
            int max = i;
            for (int j = i + 1; j < a.length; j++){
                if(Sort.larger(a[j], a[max])) max = j;
            }
            if(max != i) Sort.swap(a, max, i);
        }
    }


    @Test
    public void insertionSort(){
        int[] a = {8, 5, 7, 3, 9, 6};

        for (int i = 1; i < a.length; i++){
            int insertedEle = a[i];
            int j = i - 1;
            while(j >= 0 && Sort.less(insertedEle, a[j])){
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = insertedEle;
        }
    }


    /**
     * 比较次数：1+2+3+1 = 7
     * 交换次数：1+1+3+0 = 5
     */
    // Insertion sort optimization by Algorithm 4.
    @Test
    public void insertSortOptimization(){
        int[] a = {8, 5, 7, 3, 9, 6};
        for (int i = 1; i < a.length; i++){
            for (int j = i; j > 0 && Sort.less(a[j], a[j - 1]); j--){
                Sort.swap(a, j, j - 1);
            }
        }
    }


    // 希尔排序的本质还是插入排序，只是多了递减增量。
    @Test
    public void shellSort(){
        int[] ints = {8, 5, 7, 3, 9, 6};
        int gap = ints.length / 2;
        int i, j, insertedElement;
        while(gap >= 1){
            for (i = gap; i < ints.length; i++){
                insertedElement = ints[i];
                j = i - gap;
                while(j >= 0 && insertedElement < ints[j]){
                    ints[j + gap] = ints[j];
                    j = j - gap;
                }
                ints[j + gap] = insertedElement;
            }
            gap = gap / 2;
        }
    }


    /**
     * 比较次数：(1+1)+(1+2+3+1+4) = 2+11 = 13
     * 交换次数：(0+0)+(1+1+3+0+3) = 0+8  = 8
     * 稳定性： 稳定
     */
    @Test
    public void shellSortOptimize(){
        int[] a = {8, 5, 7, 3, 9, 6};

        int length = a.length;
        int gap = 1;
        while(gap < length / 3) gap = 3 * gap + 1;
        while(gap >= 1){
            for (int i = gap; i < length; i++){
                for (int j = i; j > 0 && Sort.less(a[j], a[j - gap]); j = j - gap){
                    Sort.swap(a, j, j - 1);
                }
            }
            gap = gap / 3;
        }
    }


    @Test
    public void test222(){

        int[] a = {8, 5, 7, 3, 9, 6};
        QuickSort.doQuickSort(a);

        System.out.println(2);
    }

    // region Deliberate exercise.

    @Test
    public void test1(){
        int[] a = {9, 5, 6, 3, 7, 4};
        MergeSort.doMergeSort(a);
        System.out.println(2);

    }

    @Test
    public void quickSortTest(){
        int[] a = {6, 3, 5, 2, 8, 1, 4};

        QuickSort.quick3(a, 0, 6);

    }


    @Test
    public void heapSort(){
        int[] a = {1, 6, 7, 2, 3, 4, 5};
        HeapSort.heapSort(a);
    }
    // endregion

}
