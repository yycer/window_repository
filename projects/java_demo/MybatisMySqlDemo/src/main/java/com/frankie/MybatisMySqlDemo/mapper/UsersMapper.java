package com.frankie.MybatisMySqlDemo.mapper;/*
 @author: Administrator
 @date: 2019/4/10-20:56
*/

import com.frankie.MybatisMySqlDemo.Model.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Mapper指的是MySQL与Java的数据映射
 */
@Mapper
public interface UsersMapper {

    @Insert("insert into users_info(real_name, age, user_id) values(#{realName}, #{age}, #{userId})")
    void insertOne(Users users);

    @Delete("delete from users_info where user_id = #{user_id}")
    void deleteOne(@Param("user_id") String userId);

    @Update("update users_info set real_name = #{realName} where user_id = #{userId}")
    void updateUsersInfo(String userId, String realName);

    @Select("select * from users_info")
    List<Users> findAll();

//    @Results({
//            @Result(property = "userId", column = "user_id"),
//            @Result(property = "realName", column = "real_name")
//    })
//    @Select("select * from users_info where user_id = '${userId}'")
//    List<Users> findOne(@Param("userId") String userId);

    @Select("select * from users_info where user_id = #{userId}")
    List<Users> findOne(String userId);
}
