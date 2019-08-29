package com.frankie.demo;

import com.frankie.demo.beanlifecycle.AwareBean;
import com.frankie.demo.beanlifecycle.Person;
import com.frankie.demo.soundsystem.DVDPlayer;
import com.frankie.demo.soundsystem.VCDPlayer;
import com.frankie.demo.soundsystemtraditianal.DVDPlayMissionImpossible;
import com.frankie.demo.soundsystemtraditianal.VCDPlayFurious;
import com.frankie.demo.vehicle.Car;
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

    @Autowired
    DVDPlayer dvdPlayer;

    @Autowired
    VCDPlayer vcdPlayer;

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

    // region DVD & VCD Dependency Injection.


    // Traditional Way.
    @Test
    public void dvdPlayerMissionImpossibleTest(){
        DVDPlayMissionImpossible missionImpossible = new DVDPlayMissionImpossible();
        missionImpossible.play();
    }

    @Test
    public void vcdPlayerFuriousTest(){
        VCDPlayFurious furious = new VCDPlayFurious();
        furious.play();
    }

    // DI Way.
    @Test
    public void dvdAndVcdPlayerTest(){
        dvdPlayer.play();
        vcdPlayer.play();
    }



    // endregion


}
