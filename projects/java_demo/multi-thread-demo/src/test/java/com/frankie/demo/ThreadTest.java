package com.frankie.demo;

import com.frankie.demo.play.*;
import javafx.concurrent.Task;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bytecode.StackSize;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.annotation.Retention;
import java.time.LocalDateTime;
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
        InheritedThread inheritedThread = new InheritedThread();
        inheritedThread.start();

        // Creating thread by implementing Runnable.
        ImpleRunnable impleRunnable = new ImpleRunnable();
        Thread impleThread = new Thread(impleRunnable);
        impleThread.start();

        // Creating thread by implementing Runnable using lambda.
        Thread impleThreadUsingLambda = new Thread(() -> {
            log.warn("The implemented runnable thread using lambda is running.");
        });
        impleThreadUsingLambda.start();


        // Creating thread by Callable interface, ExecutorService and Future.
        int a = 1;
        int b = 2;
        int c = 0;
        Callable<Integer> callable1 = new ImpleCallable(a, b);
        Callable<Integer> callable2 = new ImpleCallable(a, c);


        ExecutorService exec = Executors.newFixedThreadPool(3);
        Future<Integer> future1 = exec.submit(callable1);
        Future<Integer> future2 = exec.submit(callable2);
        try {
            Integer result1 = future1.get();
            Integer result2 = future2.get();
            log.warn("The result1 = " + result1);
            log.warn("The result2 = " + result2);

        } catch (Exception e){
            log.warn("The error is " + e);
        }
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


        ScheduledExecutorService scheduledService = Executors.newScheduledThreadPool(3);
    }

    @Test
    public void raceConditionTest() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Counter counter = new Counter();
        for(int i = 0; i < 10000; i++){
            executorService.submit(() -> counter.increment());
        }
        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);
        log.warn("The final result is " + counter.getCount());
    }

    private static boolean sayHello = false;

    @Test
    public void memoryConsistencyErrorTest() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while(!sayHello) {
            }

            System.out.println("Hello World!");

            while(sayHello) {
            }

            System.out.println("Good Bye!");
        });

        thread.start();

        Thread.sleep(1000);
        System.out.println("Say Hello..");
        sayHello = true;

        Thread.sleep(1000);
        System.out.println("Say Bye..");
        sayHello = false;
    }


    @Test
    public void newFixedThreadPoolTest() throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for( int i = 0; i < 10; i++){
            Future future = executorService.submit(new NewFixedThreadPoolCallable(i));
            future.get();
        }
        executorService.shutdown();
    }

    @Test
    public void newSingleThreadExecutorTest(){

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(int i = 0; i < 3; i++){
            executorService.execute(new NewSingleThreadExecutorRunnable(i));
        }
    }

    @Test
    public void newCachedThreadPoolTest(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < 3; i++){
            executorService.execute(new NewSingleThreadExecutorRunnable(i));
        }
    }

    @Test
    public void newScheduledThreadPoolTest() throws InterruptedException {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(10);

//        log.warn("Start " + LocalDateTime.now());
//        Runnable task1 = () -> log.warn("task1 " + LocalDateTime.now());
//        scheduledThreadPool.schedule(task1, 2, TimeUnit.SECONDS);
//        log.warn("End   " + LocalDateTime.now());
//        Thread.sleep(3000);
////        scheduledThreadPool.awaitTermination(10, TimeUnit.SECONDS);
//        scheduledThreadPool.shutdown();


//        log.warn("Start " + LocalDateTime.now());
////        Runnable task2 = () -> log.warn("task2 " + LocalDateTime.now());
////        scheduledThreadPool.scheduleAtFixedRate(task2, 3, 5, TimeUnit.SECONDS);
////        log.warn("End   " + LocalDateTime.now());
//////        Thread.sleep(3000);
////        scheduledThreadPool.awaitTermination(30, TimeUnit.SECONDS);
////        scheduledThreadPool.shutdown();


        log.warn("Start " + LocalDateTime.now());
        Runnable task2 = () -> log.warn("task3 " + LocalDateTime.now());
        scheduledThreadPool.scheduleWithFixedDelay(task2, 3, 5, TimeUnit.SECONDS);
        log.warn("End   " + LocalDateTime.now());
//        Thread.sleep(3000);
        scheduledThreadPool.awaitTermination(10, TimeUnit.SECONDS);
        scheduledThreadPool.shutdown();
    }

}
