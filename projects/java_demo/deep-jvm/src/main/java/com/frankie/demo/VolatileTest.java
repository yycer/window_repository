package com.frankie.demo;/*
 @author: Administrator
 @date: 2019/7/6-22:44
*/

import org.springframework.stereotype.Repository;

@Repository
public class VolatileTest {

    private static volatile int count = 0;
    private static final int THREAD_COUNT = 20;

    public int doVolatileTest(){

        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread[] threads = new Thread[THREAD_COUNT];
            threads[i] = new Thread(() -> {
                synchronized (this){
                    for(int j = 0; j < 10000; j++){
                        count++;
                    }
                }
            });
            threads[i].start();
        }

        // 等待所有线程结束。
        while (Thread.activeCount() > 2){
            Thread.yield();
        }

        return count;
    }

}
