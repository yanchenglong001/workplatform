package com.ycl.dbconnect;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * 生产数据库
 */
@Component
@Profile("devdb")
public class DevDBConnector implements DBConnector {
    @Override
    public void configure() {
        System.out.println("devdb");
    }
}