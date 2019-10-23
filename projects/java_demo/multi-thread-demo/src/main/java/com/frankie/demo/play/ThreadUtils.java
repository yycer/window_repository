package com.frankie.demo.play;

/**
 * @author: Yao Frankie
 * @date: 2019/10/22 09:02
 */
public class ThreadUtils {

    public static void printState(String msg, Thread t){
        System.out.println("msg: " + msg + " , " + t.getName() + " state is " + t.getState());
    }
}
