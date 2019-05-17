package com.frankie.demo;

import com.frankie.demo.module.Sort;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    @Test
    public void selectionSmallestSort() {
        int[] ints = {8, 5, 7, 3, 9, 6};

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

        int[] ints = {8, 5, 7, 3, 9, 6};

        for (int i = 0; i < ints.length; i++){
            int min = i; // 预计最小值的索引
            for (int j = i + 1; j < ints.length; j++){
                if(ints[j] < ints[min]) min = j; // 实际最小值的索引
            }
            if(i != min){
                Sort.exch(ints, i, min);
            }
        }
    }

    @Test
    public void selectionLargestSortUseModule(){
        int[] ints = {8, 5, 7, 3, 9, 6};

        for (int i = 0; i < ints.length; i++){
            int max = i;
            for (int j = i + 1; j < ints.length; j++){
                if(ints[j] > ints[max]) max = j;
            }
            if(i != max){
                Sort.exch(ints, i, max);
            }
        }
    }

    @Test
    public void insertionSort(){

        int[] ints = {8, 5, 7, 3, 9, 6};
        for (int i = 1; i < ints.length; i++){
            int currentElement = ints[i];
            int j = i - 1;
            while(j >= 0 && currentElement < ints[j]){
                ints[j + 1] = ints[j];
                j--;
            }
            ints[j + 1] = currentElement;
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

}
