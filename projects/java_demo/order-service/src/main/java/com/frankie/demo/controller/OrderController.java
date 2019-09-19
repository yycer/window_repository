package com.frankie.demo.controller;

import com.frankie.demo.domain.Order;
import com.frankie.demo.domain.Product;
import com.frankie.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author: Yao Frankie
 * @date: 2019/9/18 10:32
 */
@RestController
public class OrderController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/v1/order/{order_id}")
    public Order getOrder(@PathVariable("order_id") String orderId){
        Order order = new Order();
        Product product = productRepository.getProduct(String.valueOf(Math.random()));
        order.setProductName(product.getName());
        order.setTotal(new BigDecimal(10).setScale(2));
        return order;
    }
}
