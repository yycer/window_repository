package com.frankie.MybatisMySqlDemo;

import com.frankie.MybatisMySqlDemo.Model.Users;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.frankie.MybatisMySqlDemo.mapper")
@MappedTypes(Users.class)
public class MybatisMySqlDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisMySqlDemoApplication.class, args);
	}

}
