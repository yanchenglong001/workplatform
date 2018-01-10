package com.ycl.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 读取config类
 * @author Administrator
 *
 */
@ConfigurationProperties(prefix = "com.common")
public class ConfigBean {

    /**
     * uuid
     */
    private String uuid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户名
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * 用户名
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 唯一值UUID
     * @return
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 唯一值UUID
     * @param uuid 唯一值UUID
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
