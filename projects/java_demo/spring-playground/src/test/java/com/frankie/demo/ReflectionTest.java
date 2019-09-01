package com.frankie.demo;

import com.frankie.demo.reflection.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: Yao Frankie
 * @date: 2019/9/1 13:40
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ReflectionTest {

    @Test
    public void getClassInfoTest(){
        Person frankie = new Person(10, "frankie");
        Class<? extends Person> aClass = frankie.getClass();
        System.out.println(2);
    }


    @Test
    public void getAncestorByMethod1(){
        Person.ancestor = "黄帝";
        System.out.println(Person.ancestor);
    }

    @Test
    public void getAncestorByMethod2(){
        System.out.println(Person.ancestor);
    }
}
