package com.frankie.MybatisMySqlDemo.resource;/*
 @author: Administrator
 @date: 2019/4/10-20:48
*/

import com.frankie.MybatisMySqlDemo.Model.Users;
import com.frankie.MybatisMySqlDemo.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class UsersResource {

    @Autowired
    private UsersMapper usersMapper;

    public void insertOne(Users user){
        usersMapper.insertOne(user);
    }

    public void deleteOne(String userId){
        usersMapper.deleteOne(userId);
    }


    public void updateOne(String userId, String realName){
        usersMapper.updateUsersInfo(userId, realName);
    }

    public List<Users> getOne(String userId){
        return usersMapper.findOne(userId);
    }

    public List<Users> getAll(){
        return usersMapper.findAll();
    }


}
