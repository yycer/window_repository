package com.frankie.demo.reflection;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author: Yao Frankie
 * @date: 2019/9/1 13:37
 */
@Setter
@Getter
public class Person extends Creature{

    public static String ancestor = "女娲";

    public Person(){}

    private Person(String name){}

    public Person(int id, String name){
        this.id   = id;
        this.name = name;
    }

    private int    id;
    private String name;


    public String getName(int id){
        return "Yao Frankie";
    }

    private void info(String str, List<Integer> list){
        System.out.println("无参数方法");
    }

    class Inner{

    }

}
