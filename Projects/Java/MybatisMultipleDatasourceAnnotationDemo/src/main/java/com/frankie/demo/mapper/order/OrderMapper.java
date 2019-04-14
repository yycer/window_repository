package com.frankie.demo.mapper.order;/*
 @author: Administrator
 @date: 2019/4/14-17:35
*/

import com.frankie.demo.model.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface OrderMapper {

    @Select("select * from order_tracker where basket_order_id = #{basketOrderId}")
    Order getOne(String basketOrderId);

    @Insert("insert into order_tracker(basket_order_id, stage, created_date, user_id) values(#{basketOrderId}, #{stage}, #{createdDate}, #{userId})")
    void insertOne(Order order);
}
