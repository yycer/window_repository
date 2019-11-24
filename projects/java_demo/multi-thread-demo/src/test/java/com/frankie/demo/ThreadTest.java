package com.frankie.demo;

import com.frankie.demo.play.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.PipedInputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

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

    @Test
    public void ExecutorServiceSubmitTest() throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        Future<Integer> future = singleThreadExecutor.submit(() -> 1);
        Integer result = future.get(5, TimeUnit.SECONDS);
        log.warn("result = " + result);
    }

    /**
     * 证明了什么？ 当使用shutdown()方法后，无法继续为该executorService添加新的task，否则就是抛RejectedExecutionException。
     * 同时，之前提交的task，仍会继续完成。
     * @throws InterruptedException
     */
    @Test
    public void shutdownTest() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable run = () -> {
          try {
              log.warn("isShutdown1 is " + executor.isShutdown());
              Thread.sleep(3000);
              log.warn("isShutdown2 is " + executor.isShutdown());
              log.warn("thread finished");
          } catch (InterruptedException e){
              e.printStackTrace();
          }
        };

        executor.execute(run);
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
//        executor.execute(run);
    }

    @Test
    public void shutdownNowTest() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

//        Runnable run = () -> {
//            try {
//                Thread.sleep(3000);
//                log.warn("thread finished");
//            } catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        };

        Runnable run = () -> {
            long num = 0;
            boolean flag = true;
            while (flag){
                num ++;
                if (num == Long.MAX_VALUE){
                    flag = false;
                }
            }
            log.warn("thread finished");
        };
        executor.execute(run);
        executor.shutdownNow();
//        executor.awaitTermination(2, TimeUnit.SECONDS);
//        executor.execute(run);
    }

    @Test
    public void daemonThreadTest(){
        Thread daemonThread = new Thread(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Daemon thread test.");
            }
        });
        daemonThread.setDaemon(true);
        daemonThread.start();
    }

    /**
     * 通知/等待机制
     */
    @Test
    public void waitNotifyTest() throws InterruptedException {
        Object  lock = new Object();
        AtomicBoolean flag = new AtomicBoolean(true);

        Thread waitThread = new Thread(() -> {
            synchronized (lock){
                while (flag.get()){
                    try {
                        System.out.println(Thread.currentThread() + " flag is true, wait() " + LocalDateTime.now());
                        lock.wait(); // threadA enters waiting queue, and releases the lock.
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + " flag is false, " + LocalDateTime.now());
                }
            }
        }, "thread1");

        Thread notifyThread = new Thread(() -> {
            synchronized (lock){
                System.out.println(Thread.currentThread() + " notifyAll() " + LocalDateTime.now());
                lock.notifyAll();
                flag.set(false);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread2");

        waitThread.start();
        Thread.sleep(1);
        notifyThread.start();
        Thread.sleep(6000);
    }

    @Test
    public void printNumsUsingWaitNotifyMechanismTest() throws InterruptedException {
        Object o = new Object();

        Thread threadA = new Thread(() -> {
            synchronized (o){
                for (int i = 1; i < 10; i += 2){
                    if (i != 1){
                        o.notify();
                    }
                    try {
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "threadA");

        Thread threadB = new Thread(() -> {
            synchronized (o){
                for (int i = 2; i <= 10; i += 2){
                    o.notify();
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "threadB");

        threadA.start();
        Thread.sleep(5);
        threadB.start();
    }

    public static volatile AtomicInteger count = new AtomicInteger(0);

    public static void increase(){
        count.incrementAndGet();
    }

    @Test
    public void countTest() throws InterruptedException {
        for (int i = 0; i < 10; i++){
            new Thread(() -> {
                for (int j = 0; j < 10000; j++){
                    increase();
                }
            }).start();
        }
        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println("count = " + count);

    }
}
