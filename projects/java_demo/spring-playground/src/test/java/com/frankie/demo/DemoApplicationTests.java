package com.frankie.demo;

import com.frankie.demo.beanlifecycle.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void personBeanTest() {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("D:\\Playground\\spring-playground\\src\\main\\java\\com\\frankie\\demo\\beanlifecycle\\PersonBeanConfig.xml");
        Person person = (Person) context.getBean("personBean");
        String name = person.getName();
        System.out.println(name);
    }

}
