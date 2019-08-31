package com.frankie.demo.exception;

import java.io.*;

/**
 * @author: Yao Frankie
 * @date: 2019/8/31 21:41
 */
public class ExceptionTest {
    public static void readFile(){
        try(BufferedReader bufferedReader = new BufferedReader(
                new FileReader("justForTest.txt")))
        {
            System.out.println(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
