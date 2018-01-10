package com.ycl.dbconnect;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * 测试数据库
 */
@Component
@Profile("testdb")
public class TestDBConnector implements DBConnector {
    @Override
    public void configure() {
        System.out.println("testdb");
    }
}