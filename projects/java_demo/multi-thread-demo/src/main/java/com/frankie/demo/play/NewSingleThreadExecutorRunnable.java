package com.frankie.demo.play;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: Yao Frankie
 * @date: 2019/10/15 16:21
 */
@Slf4j
public class NewSingleThreadExecutorRunnable implements Runnable {

    private int count;

    public NewSingleThreadExecutorRunnable(int count){
        this.count = count;
    }

    @Override
    public void run() {
        log.warn("The current thread name is " + Thread.currentThread().getName() + " , count = " + count);
    }
}
