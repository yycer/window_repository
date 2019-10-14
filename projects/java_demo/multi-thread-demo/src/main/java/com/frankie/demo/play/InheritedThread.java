package com.frankie.demo.play;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: Yao Frankie
 * @date: 2019/10/14 15:27
 */
@Slf4j
public class InheritedThread extends Thread{

    public void run(){
        log.warn("The inherited thread is running.");
    }
}
