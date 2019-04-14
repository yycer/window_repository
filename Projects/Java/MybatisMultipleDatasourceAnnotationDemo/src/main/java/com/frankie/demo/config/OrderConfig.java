package com.frankie.demo.config;/*
 @author: Administrator
 @date: 2019/4/14-17:17
*/

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.frankie.demo.mapper.order", sqlSessionTemplateRef = "orderSqlSessionTemplate")
public class OrderConfig {

    @Bean(name = "orderDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.order")
    public DataSource orderDataSource(){
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "orderSqlSessionFactory")
    public SqlSessionFactory orderSqlSessionFactory(
            @Qualifier("orderDataSource") DataSource dataSource) throws Exception {

        return Extraction.createSqlSessionFactor(dataSource);
    }

    @Bean(name = "orderTransactionManager")
    public DataSourceTransactionManager orderTransactionManager(
            @Qualifier("orderDataSource") DataSource dataSource){

        return new DataSourceTransactionManager(dataSource);
    }


    @Bean(name = "orderSqlSessionTemplate")
    public SqlSessionTemplate orderSqlSessionTemplate(
            @Qualifier("orderSqlSessionFactory") SqlSessionFactory sqlSessionFactory){

        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
