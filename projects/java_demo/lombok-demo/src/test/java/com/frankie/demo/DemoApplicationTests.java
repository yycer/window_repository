package com.frankie.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void toStringTest() {
        Order order = new Order();
        order.setBasketOrderId(UUID.randomUUID().toString());
        order.setRetailPrice(new BigDecimal(10.20).setScale(2, RoundingMode.HALF_UP));
        order.setCreatedDate(LocalDateTime.now());

        String result = order.toString();

        System.out.println(2);
    }

    @Test
    public void equalsAndHashcodeTest(){
        String orderId = UUID.randomUUID().toString();
        LocalDateTime now = LocalDateTime.now();

        Order order1 = new Order();
        order1.setBasketOrderId(orderId);
        order1.setRetailPrice(new BigDecimal(10.20).setScale(2, RoundingMode.HALF_UP));
        order1.setCreatedDate(now);

        Order order2 = new Order();
        order2.setBasketOrderId(orderId);
        order2.setRetailPrice(new BigDecimal(10.20).setScale(2, RoundingMode.HALF_UP));
        order2.setCreatedDate(now);

        boolean equals = order1.equals(order2);
        boolean canEqual = order1.canEqual(order2);

        System.out.println(2);

    }
}
