package com.frankie.demo.controller;/*
 @author: Administrator
 @date: 2019/8/31-09:56
*/

import com.frankie.demo.exception.ResultCode;
import com.frankie.demo.exception.ServiceException;
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

        Order order = new Order();
        BigDecimal total = new BigDecimal(-1.00, new MathContext(2, RoundingMode.HALF_UP));

        if (total.compareTo(BigDecimal.ZERO) <= 0){
            throw ServiceException.badRequest(ResultCode.INVALID_PARAMETER,
                    "Total is less than zero!");
        }
        order.setOrderId(orderId);
        order.setTotal(total);
        return order;
    }

}
