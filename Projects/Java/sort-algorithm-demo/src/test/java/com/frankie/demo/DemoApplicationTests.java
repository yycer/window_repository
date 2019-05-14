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

}
