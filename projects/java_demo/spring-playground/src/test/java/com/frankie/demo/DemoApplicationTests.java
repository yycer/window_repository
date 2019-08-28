package com.frankie.demo;

import com.frankie.demo.beanlifecycle.AwareBean;
import com.frankie.demo.beanlifecycle.Person;
import com.frankie.demo.soundsystem.CDPlayer;
import com.frankie.demo.soundsystem.MissionImpossible;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

//    @Autowired
//    MissonImpossible missonImpossible;

    @Autowired
    CDPlayer cdPlayer;

    @Test
    public void personBeanTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("AsanBean.xml");
        Person person = (Person) context.getBean("personBean");
        String name = person.getName();
        System.out.println(name);
        context.registerShutdownHook();
    }

    @Test
    public void awareBeanTest(){
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("AwareBean.xml");
        AwareBean awareBean = (AwareBean) context.getBean("awareBean");
        context.registerShutdownHook();
    }

    @Test
    public void DependencyInjectionWay(){
        cdPlayer.play();
    }

    @Test
    public void traditionalWay(){
//        MissionImpossible mi = new MissionImpossible();
//        CDPlayer cdPlayer = new CDPlayer();
//        cdPlayer.play();
    }


}
