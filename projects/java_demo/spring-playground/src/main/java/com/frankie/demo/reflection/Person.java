package com.frankie.demo.reflection;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: Yao Frankie
 * @date: 2019/9/1 13:37
 */
@Setter
@Getter
public class Person {

    public static String ancestor = "女娲";

    private Person(){}

    public Person(int id, String name){
        this.id   = id;
        this.name = name;
    }

    private int    id;
    private String name;


    public String getName(int id){
        return "Yao Frankie";
    }

    private void info(){
        System.out.println("无参数方法");
    }

    class Inner{

    }

}
