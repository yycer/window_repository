package com.frankie.demo.play;

/**
 * @author: Yao Frankie
 * @date: 2019/10/21 16:03
 */
public class ChildThread extends Thread {

    @Override
    public void run(){
        System.out.println("The running thread name is " + Thread.currentThread().getName());
    }
}
