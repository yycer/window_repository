package com.frankie.demo.play;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * @author: Yao Frankie
 * @date: 2019/10/15 15:33
 */
@Slf4j
public class NewFixedThreadPoolCallable implements Callable {

    private int num;

    public NewFixedThreadPoolCallable(int num){
        this.num = num;
    }

    @Override
    public Object call() throws Exception {

        log.warn("Start Thread name is " + Thread.currentThread().getName() + ", thread id is " + Thread.currentThread().getId());

        try {
            if (num == 3){
                Thread.currentThread().interrupt();
            }
        } catch (Exception e){
            log.warn("Arithmetic Exception on purpose.");
        }

        log.warn("The num is " + num);

        log.warn("End Thread name is " + Thread.currentThread().getName() + ", thread id is " + Thread.currentThread().getId());
        return null;
    }
}
