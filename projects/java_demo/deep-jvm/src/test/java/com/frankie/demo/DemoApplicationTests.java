package com.frankie.demo;

import com.frankie.demo.memorytest.ConstantPoolOOM;
import com.frankie.demo.memorytest.HeapOutOfMemory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    @Autowired
    VolatileTest volatileTest;


    @Test
    public void volatileTest() {
        LocalDateTime start = LocalDateTime.now();
        int count = volatileTest.doVolatileTest();
        System.out.println(count);
        LocalDateTime end = LocalDateTime.now();
        System.out.println(Duration.between(start, end).toMillis());

    }

    @Test
    public void heapOOMTest(){
        HeapOutOfMemory heap = new HeapOutOfMemory();
        heap.run();
    }

    @Test
    public void constantPoolOOMTest(){
        ConstantPoolOOM constantPool = new ConstantPoolOOM();
        constantPool.run();
    }

    @Test
    public void stringTest(){
        String java = new StringBuilder("ja").append("va").toString();
        boolean result = java.intern() == java;
        System.out.println(2);

    }
}
