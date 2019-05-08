package com.frankie.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void jsonPropertyTest() throws JsonProcessingException {
        Order order = new Order();
        order.setBasketOrderId(UUID.randomUUID().toString());
        String s = new ObjectMapper().writeValueAsString(order);
        System.out.println(22);
    }

}
