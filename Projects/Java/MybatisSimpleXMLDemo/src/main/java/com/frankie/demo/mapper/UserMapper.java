package com.frankie.demo.mapper;/*
 @author: Administrator
 @date: 2019/4/13-16:00
*/

import com.frankie.demo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface UserMapper {

    void insertOne(UserInfo userInfo);

    void deleteOne(String userId);

    void updateOne(String userId, String realName);

    List<UserInfo> getOne(String userId);

}
