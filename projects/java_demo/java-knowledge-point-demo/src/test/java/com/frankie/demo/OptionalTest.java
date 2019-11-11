package com.frankie.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.frankie.demo.optional.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author: Yao Frankie
 * @date: 2019/11/10 09:32
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OptionalTest {

    @Test
    public void getVersionTest(){
        Computer computer = new Computer();
        SoundCard soundCard = new SoundCard();
        Usb usb = new Usb();
        usb.setVersion("10.18");
        soundCard.setUsb(Optional.ofNullable(usb));
        computer.setSoundCard(Optional.ofNullable(soundCard));

        Optional<Computer> optionalComputer = Optional.ofNullable(computer);
        String version = optionalComputer
                .flatMap(Computer::getSoundCard)
                .flatMap(SoundCard::getUsb)
                .map(Usb::getVersion)
                .orElse("UNKNOWN");

        System.out.println(version);
    }

    @Test
    public void checkCityTest(){
        Person person = new Person("frankie", "male", 23);
        String city = Optional.ofNullable(person)
                .map(Person::getLocation)
                .map(Location::getCity)
                .map(String::toLowerCase)
                .orElse("nowhere");
        System.out.println(city);

    }

    @Test
    public void serializeOptionalTest() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        Computer computer = new Computer();
        SoundCard soundCard = new SoundCard();
        Usb usb = new Usb();
        usb.setVersion("10.18");
        soundCard.setUsb(Optional.ofNullable(usb));
        computer.setSoundCard(Optional.ofNullable(soundCard));

        String result = mapper.writeValueAsString(computer);
        System.out.println(result);
    }

    static String B(){
        System.out.println("B()...");
        return "B";
    }

    @Test
    public void orElseAndOrElseGetTest(){

        // Step1: does not contain value.
//        System.out.println(Optional.empty().orElse(B()));
//        System.out.println(Optional.empty().orElseGet(() -> B()));

//        B()...
//        B
//        B()...
//        B

        // Step2: contain value.
        System.out.println(Optional.of("A").orElse(B()));
        System.out.println(Optional.of("A").orElseGet(() -> B()));

//        B()...
//        A
//        A

    }

//    --------------------------------------------------
    @Test
    public void orElseAndOrElseThrowTest(){
        Order order       = new Order();
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("20004001234");
        order.setOrderId(UUID.randomUUID().toString());

        Optional<Order> optOrder = Optional.ofNullable(order);

        // Get avatar
        String avatar = optOrder
                .map(Order::getUserInfo)
                .map(UserInfo::getAvatar)
                .orElse("");

        System.out.println("The avatar is " + avatar + " .");
        
        // Get total
        BigDecimal total = optOrder
                .map(Order::getTotal)
                .orElseThrow(() -> new RuntimeException("Failed to get total!"));

        System.out.println("The total is " + total + " .");
    }
}
