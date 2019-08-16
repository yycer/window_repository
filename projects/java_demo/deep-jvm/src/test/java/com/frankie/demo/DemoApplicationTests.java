package com.frankie.demo;

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
}
