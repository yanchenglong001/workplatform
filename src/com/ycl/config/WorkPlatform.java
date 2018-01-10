package com.ycl.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * 读取自定义config类
 * @author Administrator
 *
 */
@ConfigurationProperties(prefix = "random")
@PropertySource("classpath:workplatform.properties")
public class WorkPlatform {

    /**
     * 机密
     */
    private String secret;

    /**
     * 
     */
    private String number;

    /**
     * 
     */
    private String bignumber;

    /**
     * 
     */
    private String uuid;

    /**
     * 
     */
    private String lessThenTen;

    /**
     * 
     */
    private String inRange;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBignumber() {
        return bignumber;
    }

    public void setBignumber(String bignumber) {
        this.bignumber = bignumber;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getLessThenTen() {
        return lessThenTen;
    }

    public void setLessThenTen(String lessThenTen) {
        this.lessThenTen = lessThenTen;
    }

    public String getInRange() {
        return inRange;
    }

    public void setInRange(String inRange) {
        this.inRange = inRange;
    }

}
