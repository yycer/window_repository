package com.frankie.demo.play;

import java.util.concurrent.Callable;

/**
 * @author: Yao Frankie
 * @date: 2019/10/14 16:07
 */
public class ImpleCallable implements Callable<Integer> {

    private int a, b;

    public ImpleCallable(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer call() throws Exception {
        try {
            return this.a / this.b;
        } catch (Exception e){
            System.out.println(e.getMessage());
            throw new Exception();
        }
    }
}
