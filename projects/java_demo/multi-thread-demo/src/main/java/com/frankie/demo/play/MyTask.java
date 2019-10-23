package com.frankie.demo.play;

/**
 * @author: Yao Frankie
 * @date: 2019/10/22 09:01
 */
public class MyTask extends Thread {

    @Override
    public void run(){
        ThreadUtils.printState("thread run() started", this);
        //doing something
        for (int i = 0; i < 100; i++) {
            Math.random();
        }
        ThreadUtils.printState("thread is finishing", this);
    }
}
