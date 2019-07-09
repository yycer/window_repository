package com.frankie.demo;

import com.frankie.demo.mapper.UserMapper;
import com.frankie.demo.model.UserInfo;
import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void insertOne() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(UUID.randomUUID().toString());
        userInfo.setRealName("pangzi");
        userInfo.setAge(23);
        userInfo.setCreatedDate(LocalDateTime.now());

        userMapper.insertOne(userInfo);
    }

    @Test
    public void deleteOne(){
        String userId = "6792240b-ad7b-4b93-958a-f90b7ce1957c";
        userMapper.deleteOne(userId);
    }


    @Test
    public void updateOne(){
        String userId = "a5a52375-8968-4959-afb5-520da433f366";
        String realName = "Qin";
        userMapper.updateOne(userId, realName);
    }


    @Test
    public void getOne(){
        String userId = "e47286d0-7131-41fa-b227-51ffb41b7d05";
        List<UserInfo> userInfoList = userMapper.getOne(userId);
    }

}
