package com.frankie.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.HTMLWriter;
import java.time.LocalDateTime;

/**
 * @author: Yao Frankie
 * @date: 2019/10/26 09:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InterruptedTest {

    @Test
    public void testInterrupt() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start");
            while (!Thread.currentThread().isInterrupted()){
                System.out.println(Thread.currentThread().getName() + " is running. " + LocalDateTime.now());
            }
            System.out.println("Get " + Thread.currentThread().getName() +
                    " interrupted status is " + Thread.currentThread().isInterrupted() +
                    " using Thread.currentThread().isInterrupted()");
            System.out.println("Get " + Thread.currentThread().getName() +
                    " interrupted status is " + Thread.interrupted() +
                    " using Thread.interrupted()");
            System.out.println("Get " + Thread.currentThread().getName() +
                    " interrupted status is " + Thread.interrupted() +
                    " using Thread.interrupted()");

            System.out.println(Thread.currentThread().getName() + " end");
        }, "Thread1");

        thread1.start();
        Thread.sleep(5);
        thread1.interrupt();
        Thread.sleep(5);

        System.out.println("Get " + Thread.currentThread().getName() +
                " interrupted status is " + Thread.currentThread().isInterrupted() +
                " using Thread.currentThread().isInterrupted()");

//        Thread1 start
//        Thread1 is running. 2019-10-26T21:47:52.387901800
//        Get Thread1 interrupted status is true using Thread.currentThread().isInterrupted()
//        Get Thread1 interrupted status is true using Thread.interrupted()
//        Get Thread1 interrupted status is false using Thread.interrupted()
//        Thread1 end
//        Get main interrupted status is false using Thread.currentThread().isInterrupted()

    }
}
