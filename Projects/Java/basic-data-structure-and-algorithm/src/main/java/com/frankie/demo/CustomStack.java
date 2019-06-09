package com.frankie.demo;/*
 @author: Administrator
 @date: 2019/6/9-07:58
*/

import java.util.LinkedList;
import java.util.Queue;

public class CustomStack {

    Queue<Integer> queue = new LinkedList<>();

    public void push(int val){

        int oldSize = queue.size();
        queue.add(val);

        for (int i = 0; i < oldSize; i++){
            int x = queue.remove();
            queue.add(x);
        }
    }

    public int pop(){

        if (queue.isEmpty()){
            return -1;
        }

        return queue.remove();
    }
}
