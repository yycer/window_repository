package com.frankie.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.Inet4Address;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    int[] a = {2, 3, 7, 9};
    int[] b = {3, 6, 9, 12};

    @Test
    public void findMinElement(){
        int min = a[0];
        for (int i = 1; i < a.length; i++){
            if(Sort.less(a[i], min)) min = a[i];
        }

        System.out.println(min);
    }

    @Test
    public void findSecondMinimumElement(){

        int secondMinElement = ArrayPlayground.getSecondMinElement(a);
    }

    @Test
    public void findSecondMinElement2(){
        int secondMin = ArrayPlayground.getSecondMinElementOptimization(a);
    }

    @Test
    public void findFirstNonRepeatingEle(){

        int firstNonRepeatingElem = ArrayPlayground.getFirstNonRepeatingElem(a);
        System.out.println(firstNonRepeatingElem);
    }

    @Test
    public void findFirstNonRepeatingElemUsingHashMap(){
        int result = ArrayPlayground.getFirstNonRepeatingElemUsingHashMap(a);
        System.out.println(result);
    }

    @Test
    public void mergeTwoSortedArray(){
        int[] result = ArrayPlayground.mergeTwoSortedArray(a, b);
        System.out.println(result);
    }

    @Test
    public void sortStack(){
        Stack<Integer> input = new Stack<>();
        input.add(4);
        input.add(9);
        input.add(7);
        input.add(3);
        input.add(5);

        Stack<Integer> sortstack = SortStack.doSortStack(input);
    }

    @Test
    public void implStackUsingAQueue(){

        CustomStack customStack = new CustomStack();
        customStack.push(2);
        customStack.push(8);
        customStack.push(5);

        int pop1 = customStack.pop();
        int pop2 = customStack.pop();
        int pop3 = customStack.pop();
        int pop4 = customStack.pop();
    }

    @Test
    public void removePollPeek(){

        Queue q = new LinkedList<>();
        q.add(2);
        q.add(6);
        q.add(5);
        q.add(9);

        Integer x = (Integer) q.remove(); // 2
        System.out.println(q); // {6, 5, 9}

        Integer y = (Integer) q.poll(); // 6
        System.out.println(q); // {5, 9}

        Integer z = (Integer) q.peek(); // 5
        System.out.println(q); // {5, 9}

//        Integer x1 = (Integer) q.remove();
//        Integer x2 = (Integer) q.remove();
//        Integer x3 = (Integer) q.remove(); // NoSuchElementException

//        Integer y1 = (Integer) q.poll();
//        Integer y2 = (Integer) q.poll();
//        Integer y3 = (Integer) q.poll(); // null


    }
}
