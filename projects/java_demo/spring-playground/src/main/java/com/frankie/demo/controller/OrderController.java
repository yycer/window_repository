package com.frankie.demo.controller;/*
 @author: Administrator
 @date: 2019/8/31-09:56
*/

import com.frankie.demo.model.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@RestController
public class OrderController {

    @GetMapping(value = "/v1/orders/{order_id}"/*, produces = {"application/toString", "application/json"}*/)
    public Order getOrder(@PathVariable("order_id") @NotBlank String orderId){


//        try {
//          int i = 2 / 0;
//        } catch (Exception e){
//            throw ServiceException.badRequest(ResultCode.INVALID_PARAMETER, e.getMessage());
//        }
        Order order = new Order();
        order.setOrderId(orderId);
        order.setTotal(new BigDecimal(20.00, new MathContext(2, RoundingMode.HALF_UP)));
        return order;
    }
}
