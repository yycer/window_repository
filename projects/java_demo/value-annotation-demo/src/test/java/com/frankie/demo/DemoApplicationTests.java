package com.frankie.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.validator.ValidateWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    // Dollar
    @Value("${Order.stageId}")
    private String stageId;

    // Spring Expression Language(SpEL) - Hash
    @Value("#{order.orderTypeId}")
    private Integer orderTypeId;

    @Test
    public void dollarOrHashTest() {

        String stage = stageId;
        Integer orderId = orderTypeId;

        System.out.println(2);
    }

}
