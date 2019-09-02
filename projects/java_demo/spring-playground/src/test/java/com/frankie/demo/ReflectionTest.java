package com.frankie.demo;

import com.frankie.demo.reflection.ObjectPoolFactory;
import com.frankie.demo.reflection.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * 如何获得方法参数？
     */
    @Test
    public void getMethodParametersTest() throws NoSuchMethodException {
        Class<Person> personClass = Person.class;
        Method info = personClass.getDeclaredMethod("info", String.class, List.class);
        System.out.println("Person.info()方法中形参个数: " + info.getParameterCount());

        Parameter[] parameters = info.getParameters();
        int index = 1;
        for (Parameter p: parameters){
            System.out.println("---第" + index++ + "个参数信息---");
            System.out.println("参数名:   " + p.getName());
            System.out.println("参数类型: " + p.getType());
            System.out.println("泛型类型: " + p.getParameterizedType());
        }
    }

    @Test
    public void initObjectPoolTest()
            throws ClassNotFoundException, NoSuchMethodException,
                   InstantiationException, IllegalAccessException, InvocationTargetException {
        ObjectPoolFactory factory = new ObjectPoolFactory();
        factory.initPool("D:/Playground/spring-playground/src/main/resources/a.txt");
        factory.setNameUsingReflection("a", "frankie");
        Person person = (Person) factory.getObject("a");
//        person.setName("frankie");
        System.out.println(person.getName());
    }
}
