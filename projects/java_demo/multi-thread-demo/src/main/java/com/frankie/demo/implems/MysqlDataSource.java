package com.frankie.demo.implems;

import com.frankie.demo.interfaces.DataSource;

/**
 * @author: Yao Frankie
 * @date: 2019/11/30 14:17
 */
public class MysqlDataSource implements DataSource {
    @Override
    public void connect() {
        System.out.println("l am trying to connect MySQL.");
    }
}
