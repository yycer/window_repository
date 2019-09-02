package com.frankie.demo;

import com.frankie.demo.reflection.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

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

    @Test
    public void getClassTest() throws ClassNotFoundException {
        // 方式1: 使用Class类的forName("全限定名")静态方法
        Class<?> person = Class.forName("com.frankie.demo.reflection.Person");

        // 方式2: 调用某个类的class属性
        Class<Person> person2 = Person.class;

        // 方式3: 调用某个对象的getClass()方法。
        Person p = new Person(2, "1");
        Class<? extends Person> person3 = p.getClass();
    }
}
