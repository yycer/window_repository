package com.frankie.demo;

import com.frankie.demo.dto.OrderDto;
import com.frankie.demo.model.Order;
import com.frankie.demo.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.ModelMap;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyPermission;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Test
    public void model2Dto(){
        List products = new ArrayList<Product>();
        Product product1 = new Product();
        product1.setName("滋润霜");
        product1.setPrice("25.30");

        Product product2 = new Product();
        product2.setName("护手霜");
        product2.setPrice("13.20");

        products.add(product1);
        products.add(product2);

        Order order = new Order();
        order.setProduct(products);
        order.setOrderId(UUID.randomUUID().toString());
        order.setCreatedDate(LocalDateTime.now());

        ModelMapper modelMapper = new ModelMapper();
        OrderDto orderDto = modelMapper.map(order, OrderDto.class);

        System.out.println(2);
    }
}
