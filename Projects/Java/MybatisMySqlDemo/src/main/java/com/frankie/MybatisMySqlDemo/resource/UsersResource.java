package com.frankie.MybatisMySqlDemo.resource;/*
 @author: Administrator
 @date: 2019/4/10-20:48
*/

import com.frankie.MybatisMySqlDemo.Model.Users;
import com.frankie.MybatisMySqlDemo.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/mybatis/users")
public class UsersResource {

    @Autowired
    private UsersMapper usersMapper;

    @GetMapping("/insert")
    public void insertOne(){
        Users users = new Users();
        users.setRealName("Qin");
        users.setAge(25);
        users.setUserId(UUID.randomUUID().toString());

        usersMapper.insertOne(users);
    }

    @GetMapping("/delete")
    public void deleteOne(){
        usersMapper.deleteOne("34c6a254-5bee-11e9-84f8-00ff7b45dafa");
    }

//    public void updateOne(){
//
//    }

    @GetMapping("/get")
    public List<Users> getAll(){
        return usersMapper.findAll();
    }


}
