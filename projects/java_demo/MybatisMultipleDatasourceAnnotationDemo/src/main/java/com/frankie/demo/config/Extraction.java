package com.frankie.demo.config;/*
 @author: Administrator
 @date: 2019/4/14-20:04
*/

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;

import javax.sql.DataSource;

public class Extraction {

    public static SqlSessionFactory createSqlSessionFactor(DataSource dataSource) throws Exception {

        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);

        // 多数据源 - mapUnderScoreToCamelCase = true
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        bean.setConfiguration(configuration);

        return bean.getObject();
    }
}
