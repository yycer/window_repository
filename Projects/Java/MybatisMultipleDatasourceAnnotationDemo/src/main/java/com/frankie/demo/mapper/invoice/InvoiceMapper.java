package com.frankie.demo.mapper.invoice;/*
 @author: Administrator
 @date: 2019/4/14-17:35
*/

import com.frankie.demo.model.UsersInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


public interface InvoiceMapper {

    @Select("select * from users_info where user_id = #{userId}")
    UsersInfo getOne(String userId);

    @Insert("insert into users_info(user_id, real_name, age, created_date) values(#{userId}, #{realName}, #{age}, #{createdDate})")
    void insertOne(UsersInfo usersInfo);
}
