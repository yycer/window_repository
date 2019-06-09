package com.frankie.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.filter.TypeExcludeFilters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.w3c.dom.Node;

import java.net.Inet4Address;
import java.util.ArrayList;
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

    @Test
    public void reverseFirstKElementOfQueue(){
        Queue<Integer> q = new LinkedList<>();
        int k = 3;
        q.add(2);
        q.add(6);
        q.add(5);
        q.add(9);
        q.add(7);

        // Step1: 将队列中前n个元素以相同排序顺序插入一个栈中。
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++){
            stack.push(q.remove());
        }

        // Step2: 将前n个元素以相反的顺序插入之前的队列。
        while (!stack.isEmpty()){
            q.add(stack.pop());
        }

        // Step3: 将其余的元素以相同的顺序转移到原来的位置。
        for (int i = 0; i < q.size() - k; i++){
            q.add(q.remove());
        }
    }

    @Test
    public void convertNumber2Binary(){
        int x = 1;

        String s = "";
        while (x > 0){
            s = (x % 2 == 0 ? "0" : "1") + s;
            x /= 2;
        }
        System.out.println(s);
    }

    @Test
    public void generateBinaryNumber(){
        int k = 4;
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i <= k; i++){
            result.add(DigitUtils.number2Binary(i));
        }
        System.out.println(result);
    }

    @Test
    public void reverseALinkedList(){
        MyLinkedList.doReverse();
    }

    @Test
    public void removeDuplicateFromALinkedList(){
        MyLinkedList.removeDuplicate();
    }
}



























