package com.frankie.demo.play;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;

/**
 * @author: Yao Frankie
 * @date: 2019/10/14 16:41
 */
@Slf4j
public class MyCallable1 implements Callable<Object> {

    private String tackNum;

    public  MyCallable1(String tackNum){
        this.tackNum = tackNum;
    }

    @Override
    public Object call() throws Exception {
        log.warn(">>> " + tackNum + " starts.");
        long startTime = System.currentTimeMillis();
        Thread.sleep(2000);
        long endTime = System.currentTimeMillis();
        log.warn(">>> " + tackNum + " ends.");
        return tackNum + "use " + (endTime - startTime) + "ms";
    }
}
