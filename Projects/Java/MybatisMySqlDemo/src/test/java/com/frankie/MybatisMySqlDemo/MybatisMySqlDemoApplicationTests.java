package com.frankie.MybatisMySqlDemo;

import com.frankie.MybatisMySqlDemo.Model.Users;
import com.frankie.MybatisMySqlDemo.mapper.UsersMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisMySqlDemoApplicationTests {


	@Autowired
	private UsersMapper usersMapper;

	@Test
	public void Insert(){
		Users users = new Users();
		users.setUserId(UUID.randomUUID().toString());
		users.setRealName("Yao Frankie");
		users.setAge(24);
		usersMapper.insertOne(users);
	}

	@Test
	public void update(){
		String userId = "aa5c5a5a-ab6b-4402-ab71-33184c0fea2c";
		String realName = "yyc";
		usersMapper.updateUsersInfo(userId, realName);
	}

	@Test
	public void getOne(){

		String userId = "a5a52375-8968-4959-afb5-520da433f366";
		List<Users> users = usersMapper.findOne(userId);

	}

}
