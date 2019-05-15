package com.frankie.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.event.MouseInputListener;
import java.util.Arrays;
import java.util.List;

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
    public void insertionSort(){

        int[] ints = {8, 5, 7, 3, 9, 6};
        for (int i = 1; i < ints.length; i++){
            for (int j = i - 1; j >= 0; j--){
                if(ints[i] < ints[j]){
                    int tmp = ints[j];
                    ints[j] = ints[i];
                    ints[i] = tmp;
                }
            }
        }
    }
}
