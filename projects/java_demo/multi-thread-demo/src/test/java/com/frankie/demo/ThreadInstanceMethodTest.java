package com.frankie.demo;

import com.frankie.demo.threads.MyThread03;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: Yao Frankie
 * @date: 2019/11/13 15:45
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ThreadInstanceMethodTest {

    @Test
    public void currentThreadTest(){
        MyThread03 myThread03 = new MyThread03();
        myThread03.start();

        System.out.println("currentThreadTest() method: Thread.currentThread().getName(): " + Thread.currentThread().getId()); // 1
    }
}
