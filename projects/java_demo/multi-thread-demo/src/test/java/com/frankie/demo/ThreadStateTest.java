package com.frankie.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

/**
 * @author: Yao Frankie
 * @date: 2019/10/22 09:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadStateTest {

    @Test
    public void testNewState(){
        Thread thread = new Thread(() -> System.out.println("Thread is running."));
        thread.setName("Thread10");
        System.out.println("Thread name is " + thread.getName() + " , state is " + thread.getState());
        thread.start();
        System.out.println("Thread name is " + thread.getName() + " , state is " + thread.getState());

//        Thread name is Thread10 , state is NEW
//        Thread name is Thread10 , state is RUNNABLE
//        Thread is running.
    }


    @Test
    public void testTerminatedState() throws InterruptedException {
        Runnable run = () -> System.out.println("Thread is running.");

        Thread thread = new Thread(run);
        thread.setName("Thread10");
        thread.start();
        Thread.sleep(1000);
        System.out.println("Thread name is " + thread.getName() + " , state is " + thread.getState());

//        Thread is running.
//        Thread name is Thread10 , state is TERMINATED
    }

    /**
     * 线程1先执行完，线程2处于Waited_Timing状态。
     */
    @Test
    public void testTimedWaitingStateUsingSleep() throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " is running.");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "Thread is end.");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " is running.");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "Thread is end.");
        });

        thread1.setName("Thread1");
        thread2.setName("Thread2");
        thread1.start();
        thread2.start();
        Thread.sleep(150);  // The purpose is to let the thread1 finish running.
        System.out.println(thread2.getName() + " state is " + thread2.getState());
        Thread.sleep(1000); // The purpose is to let the thread2 finish running.

//        Thread2 is running.
//        Thread1 is running.
//        Thread1Thread is end.
//        Thread2 state is TIMED_WAITING
//        Thread2Thread is end.
    }

    /**
     * 在线程2通知线程1之前，线程1处于Waited_Timing状态。
     */
    @Test
    public void testTimedWaitingStateUsingWait() throws InterruptedException {
        Object o = new Object();

        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " is running.");
            try {
                synchronized (o){
                    o.wait(1000);
                    System.out.println(Thread.currentThread().getName() + " is doing something.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is end.");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " is running.");
            synchronized (o){
                o.notify();
            }
            System.out.println(Thread.currentThread().getName() + " is end.");
        });
        thread1.start();
        thread1.setName("Thread1");
        thread2.setName("Thread2");
        Thread.sleep(200);
        System.out.println("The state of " + thread1.getName() + " is " + thread1.getState());
        thread2.start();

//        Thread1 is running.
//        The state of Thread1 is TIMED_WAITING
//        Thread2 is running.
//        Thread2 is end.
//        Thread1 is doing something.
//        Thread1 is end.
    }


    @Test
    public void testWaitingStateUsingWait() throws InterruptedException {

        Object o = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (o){
                try {
                    System.out.println(Thread.currentThread().getName() + " is running.");
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (o){
                System.out.println(Thread.currentThread().getName() + " is running.");
                o.notify();
            }
        });

        thread1.setName("Thread1");
        thread2.setName("Thread2");
        thread1.start();
        Thread.sleep(10); // The purpose is to let the thread1 start to run.
        System.out.println("The state of " + thread1.getName() + " is " + thread1.getState());
        thread2.start();
        Thread.sleep(10); // The purpose is to let the thread2 start to run.
        System.out.println("The state of " + thread1.getName() + " is " + thread1.getState());

//        Thread1 is running.
//        The state of Thread1 is WAITING
//        Thread2 is running.
//        The state of Thread1 is TERMINATED
    }

    /**
     * Blocked状态出现在某个线程在等待锁资源的时候。
     * @throws InterruptedException
     */
    @Test
    public void testBlockedStateUsingSleep() throws InterruptedException {
        Object o = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (o){
                try {
                    System.out.println(Thread.currentThread().getName() + " is running.");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (o){
                System.out.println(Thread.currentThread().getName() + " is running.");
            }
        });

        thread1.setName("Thread1");
        thread2.setName("Thread2");
        thread1.start();
        Thread.sleep(10); // The purpose is to let the thread1 start to run.
        thread2.start();
        Thread.sleep(10); // The purpose is to let the thread2 start to run.
        System.out.println("The state of " + thread2.getName() + " is " + thread2.getState());

//        Thread1 is running.
//        The state of Thread2 is BLOCKED
    }

}
