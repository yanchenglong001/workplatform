package com.ycl.mapper.user;

/**
 * 用户表字段名称
 * @author Administrator
 *
 */
public enum UserColumn {
    /** 用户id */
    C_ID("c_id"),
    /** 名称 */
    C_NAME("c_name"),
    /** 密码 */
    C_PASSWORD("c_password"),
    /** 登录名 */
    C_LOGIN_ID("c_login_id"),
    /** 盐值 */
    C_SALT("c_salt"),
    /** 状态 */
    N_STATE("n_state"),
    /** 是否有效（1：有效；0：无效） */
    N_VALID("n_valid"),
    /** 创建用户id */
    C_CREATE_USER("c_create_user"),
    /** 创建时间 */
    D_CREATE_DATE("d_create_date"),
    /** 更新用户id */
    C_UPDATE_USER("c_update_user"),
    /** 更新时间 */
    D_UPDATE_DATE("d_update_date");
    private String value;

    UserColumn(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
