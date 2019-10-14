package com.frankie.demo;

import com.frankie.demo.play.ImpleCallable;
import com.frankie.demo.play.ImpleRunnable;
import com.frankie.demo.play.InheritedThread;
import com.frankie.demo.play.MyCallable1;
import javafx.concurrent.Task;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bytecode.StackSize;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.*;

/**
 * @author: Yao Frankie
 * @date: 2019/10/14 15:29
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ThreadTest {

    @Test
    public void createThreadTest(){
        // Creating thread by inheriting Thread class.
//        InheritedThread inheritedThread = new InheritedThread();
//        inheritedThread.start();

        // Creating thread by implementing Runnable.
        ImpleRunnable impleRunnable = new ImpleRunnable();
        Thread impleThread = new Thread(impleRunnable);
        impleThread.start();

//        // Creating thread by implementing Runnable using lambda.
//        Thread impleThreadUsingLambda = new Thread(() -> {
//            log.warn("The implemented runnable thread using lambda is running.");
//        });
//        impleThreadUsingLambda.start();
//
//
//        // Creating thread by Callable interface, ExecutorService and Future.
//        int a = 1;
//        int b = 2;
//        int c = 0;
//        Callable<Integer> callable1 = new ImpleCallable(a, b);
//        Callable<Integer> callable2 = new ImpleCallable(a, c);
//
//
//        ExecutorService exec = Executors.newFixedThreadPool(3);
//        Future<Integer> future1 = exec.submit(callable1);
//        Future<Integer> future2 = exec.submit(callable2);
//        try {
//            Integer result1 = future1.get();
//            Integer result2 = future2.get();
//            log.warn("The result1 = " + result1);
//            log.warn("The result2 = " + result2);
//
//        } catch (Exception e){
//            log.warn("The error is " + e);
//        }
    }

    @Test
    public void myCallable1Test() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        int taskSize = 5;
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        ArrayList<Future> futureList = new ArrayList<>();

        for( int i = taskSize; i > 0; i--){
            MyCallable1 callable = new MyCallable1(i + " ");
            Future<Object> future = pool.submit(callable);
            futureList.add(future);
        }

        pool.shutdown();

        for(Future f: futureList){
            log.warn(">>> "+ f.get().toString());
        }
        long endTime = System.currentTimeMillis();
        log.warn("All execution time = " + (endTime - startTime) + "ms");

    }
}
