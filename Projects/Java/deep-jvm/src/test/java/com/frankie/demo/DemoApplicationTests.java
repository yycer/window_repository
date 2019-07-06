package com.frankie.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void volatileTest() {
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++){
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++){
                    VolatileTest.increase();
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount() > 2){
//            for (Map.Entry<Thread, StackTraceElement[]> entry: Thread.getAllStackTraces().entrySet()){
//                System.out.println("========" + entry.getKey());
//            }
            Thread.yield();
        }
        // 126618
        // 145078
        // 172259
        System.out.println(VolatileTest.count);
    }

}
