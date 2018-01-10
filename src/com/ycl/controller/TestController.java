package com.ycl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ycl.config.ConfigBean;
import com.ycl.config.WorkPlatform;
import com.ycl.dbconnect.DBConnector;

/**
 * 测试controller
 * @author Administrator
 *
 */
@RestController
public class TestController {
    @Autowired
    ConfigBean configBean;

    @Autowired
    WorkPlatform workplatform;

    @Autowired
    DBConnector connector;

    @RequestMapping("/test")
    public String index() {
        StringBuilder text = new StringBuilder();
        text.append(String.format("Config:uuid[%s]", configBean.getUuid()))
                .append("<br/>");
        text.append(String.format("CustomConfig:random.secret[%s]",
            workplatform.getSecret())).append("<br/>");
        text.append(String.format("CustomConfig:random.number[%s]",
            workplatform.getNumber())).append("<br/>");
        text.append(String.format("CustomConfig:random.bignumber[%s]",
            workplatform.getBignumber())).append("<br/>");
        text.append(String.format("CustomConfig:random.uuid[%s]",
            workplatform.getUuid())).append("<br/>");
        text.append(
            String.format("CustomConfig:random.number.less.than.ten[%s]",
                workplatform.getLessThenTen())).append("<br/>");
        text.append(String.format("CustomConfig:random.number.in.range[%s]",
            workplatform.getInRange())).append("<br/>");
        connector.configure();
        return text.toString();
    }
}
