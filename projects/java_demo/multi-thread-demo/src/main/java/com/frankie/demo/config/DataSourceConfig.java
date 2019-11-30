package com.frankie.demo.config;

import com.frankie.demo.implems.MongoDataSource;
import com.frankie.demo.implems.MysqlDataSource;
import com.frankie.demo.interfaces.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author: Yao Frankie
 * @date: 2019/11/30 14:15
 */
@Component
public class DataSourceConfig {

    @Bean(name = "MongoDataSource")
    public DataSource createMongoDataSource(){
        return new MongoDataSource();
    }

    @Bean(name = "MysqlDataSource")
    public DataSource createMysqlDataSource(){
        return new MysqlDataSource();
    }

}
