package com.frankie.demo;

import com.frankie.demo.exception.ExceptionDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ExceptionTest {

    @Autowired
    ExceptionDemo exceptionDemo;

    @Test
    public void nullPointerExceptionTest(){
    }

    @Test
    public void finallyTest(){
        String result = exceptionDemo.finallyExecSequence();
        System.out.println(result);
    }

    /**
     * 为什么那么多类需要实现Closeable或AutoCloseable接口？
     */
    @Test
    public void printTextTest(){
        try (BufferedReader reader = new BufferedReader(
                new FileReader("D:/Playground/spring-playground/src/main/resources/a.txt"))){

            System.out.println(reader.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
