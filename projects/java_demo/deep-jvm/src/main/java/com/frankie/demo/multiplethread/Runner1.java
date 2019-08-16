package com.frankie.demo.multiplethread;

public class Runner1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            System.out.println("进入Runner1: " + i);
        }
    }
}
