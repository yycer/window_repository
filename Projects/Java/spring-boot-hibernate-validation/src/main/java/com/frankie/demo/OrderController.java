package com.frankie.demo;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.UUID;

@RestController
public class OrderController {


    @PostMapping("orders")
    public Order getOrder(@RequestBody OrderDto orderDto){
        Order order = new Order();
        order.setBasketOrderId(UUID.randomUUID().toString());
        order.setTotal(new BigDecimal(10.2).setScale(2, RoundingMode.HALF_UP));
        order.setCreatedDate(LocalDateTime.now());

        return order;
    }
}
