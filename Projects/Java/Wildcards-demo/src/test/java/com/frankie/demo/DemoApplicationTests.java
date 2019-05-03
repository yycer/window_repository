package com.frankie.demo;

import com.frankie.demo.classes.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.font.NumericShaper;
import java.sql.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
        Plate<? extends Fruit> applePlate = new Plate<Apple>(new Apple());
    }


    @Test
    public void test1(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("frankie");
        String name1 = (String) arrayList.get(0);

        ArrayList<String> strings = new ArrayList<>();
        strings.add("asan");
        String name2 = strings.get(0);

    }


    @Test
    public void genericClassTest(){
//        String[] words = {"Frankie", "has", "a", "interesting", "book"};
        LocalDateTime[] births = {
                LocalDateTime.of(1996, 8, 17, 10, 20),
                LocalDateTime.of(1995, 10, 1, 10, 10),
                LocalDateTime.of(2000, 1, 10, 2, 50)
        };

        Pair<LocalDateTime> minmax = ArrayAlg.minmax(births);
        System.out.println("min = " + minmax.getFirst());
        System.out.println("max = " + minmax.getSecond());
    }

    @Test
    public void extendTest(){
        List<Integer> integers = Arrays.asList(1, 2, 3);
        assert ArrayAlg.sum(integers) == 6.0;

        List<Double> doubles = Arrays.asList(2.78, 3.14);
        assert ArrayAlg.sum(doubles) == 5.92;

        List<Double> nums = Arrays.asList(1.2, 2.3, 3.4);
        assert ArrayAlg.sum(nums) == 6.9;

        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(3);

        List<? extends Number> num2 = ints;
        // add (capture <? extends java.lang.Number>) in List cannot be applied.
        // num2.add(4);

        System.out.println(num2.toString());
    }


    @Test
    public void superTest(){
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayAlg.count(integers, 5);

        ArrayList<Number> numbers = new ArrayList<>();
        ArrayAlg.count(numbers, 5);
        numbers.add(5.0);

        ArrayList<Object> objects = new ArrayList<>();
        ArrayAlg.count(objects, 5);
        objects.add("five");


        List<Object> objects2 = Arrays.asList(1, "two");
        List<? super Integer> ints = objects2;
        String str = "";
        for (Object o: ints) str += o.toString();

        System.out.println(2);

    }
}
