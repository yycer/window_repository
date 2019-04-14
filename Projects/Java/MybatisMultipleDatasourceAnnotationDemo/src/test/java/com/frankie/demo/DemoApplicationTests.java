package com.frankie.demo;

import com.frankie.demo.mapper.invoice.InvoiceMapper;
import com.frankie.demo.mapper.order.OrderMapper;
import com.frankie.demo.model.Order;
import com.frankie.demo.model.UsersInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private InvoiceMapper invoiceMapper;

    @Autowired
    private OrderMapper orderMapper;


    @Test
    public void getInvoice() {
        String userId = "b93a5ec4-1450-4775-956a-1b1ef2c6a412";
        UsersInfo userInfo = invoiceMapper.getOne(userId);
    }

    @Test
    public void insertInvoice(){
        UsersInfo usersInfo = new UsersInfo();
        usersInfo.setUserId(UUID.randomUUID().toString());
        usersInfo.setRealName("yyc");
        usersInfo.setAge(24);
        usersInfo.setCreatedDate(new Timestamp(System.currentTimeMillis()));

        invoiceMapper.insertOne(usersInfo);
    }


    @Test
    public void getOrder(){
        String baskerOrderId = "3430623f-c8df-46f8-86d2-9d83fe4216dc";
        Order order = orderMapper.getOne(baskerOrderId);
    }


    @Test
    public void insertOrder(){
        Order order = new Order();
        order.setBasketOrderId(UUID.randomUUID().toString());
        order.setStage(10130);
        order.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        order.setUserId("1002");

        orderMapper.insertOne(order);
    }
}
