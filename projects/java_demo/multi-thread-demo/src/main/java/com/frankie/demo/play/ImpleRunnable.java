package com.frankie.demo.play;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: Yao Frankie
 * @date: 2019/10/14 15:38
 */
@Slf4j
public class ImpleRunnable implements Runnable{

    @Override
    public void run(){
        log.warn("The implemented runnable thread is running.");
    }
}
