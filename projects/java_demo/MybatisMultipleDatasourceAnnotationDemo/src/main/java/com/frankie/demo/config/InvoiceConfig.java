package com.frankie.demo.config;/*
 @author: Administrator
 @date: 2019/4/14-17:17
*/

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.frankie.demo.mapper.invoice", sqlSessionTemplateRef = "invoiceSqlSessionTemplate")
public class InvoiceConfig {


    @Bean(name = "invoiceDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.invoice")
    @Primary
    public DataSource invoiceDataSource(){

        return DataSourceBuilder.create().build();
    }


    @Bean(name = "invoiceSqlSessionFactory")
    @Primary
    public SqlSessionFactory invoiceSqlSessionFactory(
            @Qualifier("invoiceDataSource") DataSource dataSource) throws Exception {

        return Extraction.createSqlSessionFactor(dataSource);
    }

    @Bean(name = "invoiceTransactionManager")
    @Primary
    public DataSourceTransactionManager invoiceTransactionManager(
            @Qualifier("invoiceDataSource") DataSource dataSource) {

        return new DataSourceTransactionManager(dataSource);
    }


    @Bean(name = "invoiceSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate invoiceSqlSessionTemplate(
            @Qualifier("invoiceSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {

        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
