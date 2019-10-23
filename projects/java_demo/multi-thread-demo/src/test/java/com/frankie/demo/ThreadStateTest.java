package com.frankie.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: Yao Frankie
 * @date: 2019/10/22 09:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadStateTest {

    @Test
    public void newStateTest(){
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
    public void terminatedStateTest() throws InterruptedException {
        Runnable run = () -> System.out.println("Thread is running.");

        Thread thread = new Thread(run);
        thread.setName("Thread10");
        thread.start();
        Thread.sleep(1000);
        System.out.println("Thread name is " + thread.getName() + " , state is " + thread.getState());

//        Thread is running.
//        Thread name is Thread10 , state is TERMINATED
    }

    @Test
    public void timedWaitingStateUsingSleepTest() throws InterruptedException {

        Thread thread = new Thread(() -> {
            System.out.println("Thread is running.");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread is end.");
        });
        thread.start();
        Thread.sleep(500);
        System.out.println("Thread name is " + thread.getName() + " , state is " + thread.getState());

//    Thread is running.
//    Thread name is Thread-2 , state is TIMED_WAITING
    }

    @Test
    public void timedWaitingStateUsingWaitTest() throws InterruptedException {
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
        Thread.sleep(200);
        System.out.println("The state of " + thread1.getName() + " is " + thread1.getState());
        thread2.start();
        thread2.setName("Thread2");

//        Thread1 is running.
//        The state of Thread1 is TIMED_WAITING
//        Thread2 is running.
//        Thread1 is doing something.
//        Thread1 is end.
//        Thread2 is end.
    }


    @Test
    public void timedWaitingStateUsingJoinTest() throws InterruptedException {

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++){
                try {
                    Thread.sleep(1000);
                    System.out.println("Thread2 state is " + thread2.getState());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " is running.");
            }
        });

        thread1.setName("Thread1");
        thread2.setName("Thread2");

        thread1.start();
        thread2.start();
        thread1.join(3000);

//        Thread2 state is TIMED_WAITING
//        Thread1 is running.
//        Thread2 state is TIMED_WAITING
//        Thread1 is running.
//        Thread2 state is TERMINATED
//        Thread1 is running.
    }

}
