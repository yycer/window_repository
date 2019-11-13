package com.frankie.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.frankie.demo.optional.*;
import com.frankie.demo.utils.UserUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import javax.swing.text.html.Option;
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


    @Autowired
    private UserUtils userUtils;

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


//    --------------------------------------------------

    @Test
    public void optionalBasicTest(){
        String def  = "default";
        String name = "frankie";
        Optional<String> optName = Optional.of(name);

        String pet = null;
        Optional<String> optPet = Optional.ofNullable(pet);

        String name2 = optName.orElse(def);
        String pet2  = optPet.orElse(def);
    }

    @Test
    public void orElseAndOrElseThrowTest(){
        Order order       = new Order();
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("20004001234");
        order.setOrderId(UUID.randomUUID().toString());
        order.setUserInfo(userInfo);

        Optional<Order> optOrder = Optional.ofNullable(order);

        // Get avatar
        String avatar = optOrder
                .map(Order::getUserInfo)
                .map(UserInfo::getAvatar)
                .orElse("");

        // The avatar is  .
        System.out.println("The avatar is " + avatar + " .");
        
        // Get total
        BigDecimal total = optOrder
                .map(Order::getTotal)
                .orElseThrow(() -> new RuntimeException("Failed to get total!"));

        // java.lang.RuntimeException: Failed to get total!
        System.out.println("The total is " + total + " .");
    }

    @Test
    public void testDifferenceBetweenMapAndFlatMap(){
        // Illustrate the data structure of class Computer, SoundCard and Usb.
        Computer computer   = new Computer();
        SoundCard soundCard = new SoundCard();
        Usb usb             = new Usb();

        usb.setVersion("10.18");
        soundCard.setUsb(Optional.ofNullable(usb));
        computer.setSoundCard(Optional.ofNullable(soundCard));

        Optional<Computer> optionalComputer = Optional.ofNullable(computer);

        // If your function already returns an optional,
        // flatMap() is bit smarter,
        // and does not double wrapper it, returning Optional<U>.
        Optional<SoundCard> optSoundCard1 = optionalComputer
                .flatMap(Computer::getSoundCard);

        Optional<Usb> optUsb1 = optSoundCard1
                .flatMap(SoundCard::getUsb);

        Optional<String> optVersion1 = optUsb1
                .map(Usb::getVersion);

        Optional<Optional<SoundCard>> optSoundCard2 = optionalComputer
                .map(Computer::getSoundCard);

        String version = optVersion1
                .orElse("UNKNOWN");

        System.out.println(version); // 10.18
    }

    static String B(){
        System.out.println("B()...");
        return "B";
    }

    @Test
    public void orElseAndOrElseGetTest(){

//      Situation1: If the optional object is empty, the corresponding methods will be executed.
        System.out.println(Optional.empty().orElse(B()));
//      B()...
//      B

        System.out.println(Optional.empty().orElseGet(() -> B()));
//      B()...
//      B

//      Situation2: If the optional object has a value,
//      orElse() will still execute the corresponding method, but orElse() will not.
        System.out.println(Optional.of("A").orElse(B()));
//      B()...
//      A

        System.out.println(Optional.of("A").orElseGet(() -> B()));
//      A
    }

    @Test
    public void getUserIdTest(){
        String userId1 = null;
        String userId2 = "";
        String userId3 = "20004001000";

// ---------------------------- Using traditional way ----------------------------
//        java.lang.RuntimeException: Failed to get userId.
        System.out.println("Calling getUserId using traditional way: " + userUtils.getUserId(userId1));

//        java.lang.RuntimeException: Failed to get userId.
        System.out.println("Calling getUserId using traditional way: " + userUtils.getUserId(userId2));

//        Calling getUserId using traditional way: 20004001000
        System.out.println("Calling getUserId using traditional way: " + userUtils.getUserId(userId3));


// ---------------------------- Using Optional way ----------------------------
//        java.lang.RuntimeException: Failed to get userId.
        System.out.println("Calling getUserId using optional way: " + userUtils.getUserIdUsingOptional(userId1));

//        java.lang.RuntimeException: Failed to get userId.
        System.out.println("Calling getUserId using optional way: " + userUtils.getUserIdUsingOptional(userId2));

//        Calling getUserId using optional way: 20004001000
        System.out.println("Calling getUserId using optional way: " + userUtils.getUserIdUsingOptional(userId3));
    }
    
}
