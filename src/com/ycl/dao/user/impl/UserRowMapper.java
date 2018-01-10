package com.ycl.dao.user.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ycl.bean.manager.user.TUser;

public class UserRowMapper<T extends TUser> implements RowMapper<TUser> {

    @Override
    public TUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        TUser user = new TUser();
        user.setcId(rs.getString("c_id"));
        user.setcName(rs.getString("c_name"));
        user.setcPassword(rs.getString("c_password"));
        user.setcLoginId(rs.getString("c_login_id"));
        user.setnValid(rs.getInt("n_valid"));
        user.setcCreateUser(rs.getString("c_create_user"));
        user.setdCreateDate(rs.getDate("d_create_date"));
        user.setcUpdateUser(rs.getString("c_update_user"));
        user.setdUpdateDate(rs.getDate("d_update_date"));
        return user;
    }

}
