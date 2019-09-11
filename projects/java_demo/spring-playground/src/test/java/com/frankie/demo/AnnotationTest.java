package com.frankie.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author: Yao Frankie
 * @date: 2019/9/11 15:16
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class AnnotationTest {

    @Test
    public void timestampTest() throws InterruptedException {
        LocalDateTime startTime = LocalDateTime.now();
        Thread.sleep(100);
        LocalDateTime endTime = LocalDateTime.now();
        long result = Duration.between(startTime, endTime).toMillis();
        log.warn("cost time: " + String.valueOf(result));

    }
}
