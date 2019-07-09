package com.frankie.demo;/*
 @author: Administrator
 @date: 2019/6/5-21:26
*/

import java.util.Stack;

public class SortStack {

    public static Stack<Integer> doSortStack(Stack<Integer> initialStack){

        Stack<Integer> tmpStack = new Stack<>();

        while (!initialStack.isEmpty()){
            Integer initialPop = initialStack.pop();

            while (!tmpStack.isEmpty() && Sort.larger(tmpStack.peek(), initialPop)){
                initialStack.push(tmpStack.pop());
            }

            tmpStack.push(initialPop);
        }

        return tmpStack;
    }
}
