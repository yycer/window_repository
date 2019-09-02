package com.frankie.demo.exception;

import org.springframework.stereotype.Component;

@Component
public class ExceptionDemo {

    /**
     * 为什么不建议在finally语句中添加return或throw语句？
     */
    public String finallyExecSequence(){

        String name;

        try {
            name = "--- try ---";
            return name;
        } finally {
            name = "--- finally ---";
            return name;
        }
    }
}
