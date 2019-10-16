package com.frankie.demo.play;

/**
 * @author: Yao Frankie
 * @date: 2019/10/15 13:46
 */
public class Counter {

    private int count = 0;

    public void increment(){
        count = count + 1;
    }

    public int getCount(){
        return count;
    }
}
