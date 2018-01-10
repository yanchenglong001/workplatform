package com.ycl.dao.user.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ycl.bean.manager.user.TUser;
import com.ycl.common.constants.CommonConstants.NumberConstant;
import com.ycl.common.dao.BaseDao;
import com.ycl.common.util.CommonUtil;
import com.ycl.dao.user.IUserDao;
import com.ycl.mapper.user.UserColumn;
import com.ycl.mapper.user.UserMapper;

/**
 * 用户dao
 * @author Administrator
 *
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDao implements IUserDao {

    @Autowired
    private UserMapper userMapper;

    /**
     * 返回user表字段名称
     * @param alias 表别名
     * @return
     */
    //    private static String getColumn(String alias) {
    //        // 判断别名不为空添加.
    //        if (!StringUtils.isEmpty(alias)) {
    //            alias = String.format("%s.", alias);
    //        }
    //        // 用户表字段
    //        StringBuilder column = new StringBuilder();
    //        for (UserColumn uc : UserColumn.values()) {
    //            column.append(String.format("        %s%s%s", alias, uc.getValue(),
    //                CommonConstant.SIGN_COMMA.getValue()));
    //        }
    //        return column.toString().substring(NumberConstant.ZERO.getValue(),
    //            column.toString()
    //                    .lastIndexOf(CommonConstant.SIGN_COMMA.getValue()));
    //    }

    @Override
    public TUser getUserById(String id) {
        StringBuilder sql = new StringBuilder();
        sql.append(" select ");
        sql.append(CommonUtil.getColumn(UserColumn.class, StringUtils.EMPTY));
        sql.append("   from t_user     ");
        sql.append(String.format("  where c_id = '%s' ", id));
        List<TUser> users = getJdbcTemplate().query(sql.toString(),
            new RowMapper<TUser>() {
                @Override
                public TUser mapRow(ResultSet rs,
                        int rowNum) throws SQLException {
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
            });
        if (users.isEmpty()) {
            return null;
        }
        return users.get(NumberConstant.ZERO.getValue());
    }

    @Override
    public List<TUser> getLoginUser(String loginId, String password) {
        StringBuilder sql = new StringBuilder();
        sql.append(" select ");
        sql.append(CommonUtil.getColumn(UserColumn.class, StringUtils.EMPTY));
        sql.append("   from t_user     ");
        sql.append("  where c_login_id = ? ");
        sql.append("    and c_password = ? ");
        Object[] args = { loginId, password };
        List<TUser> users = getJdbcTemplate().query(sql.toString(), args,
            new UserRowMapper<TUser>());
        //        users = userMapper.getLoginUser(loginId, password);

        return users;
    }

    @Override
    public TUser findByLoginName(String loginId) {
        TUser user = new TUser();
        user.setcLoginId(loginId);
        List<TUser> users = userMapper.getUserByUserBean(user);
        if (users.isEmpty()) {
            return null;
        }
        return users.get(NumberConstant.ZERO.getValue());
    }

    @Override
    public int addUser(TUser user) throws Exception {

        return userMapper.insert(user);

    }

    @Override
    public List<TUser> getAllUser() {

        return userMapper.getAllUser();
    }

    @Override
    public int updateUser(TUser user) throws Exception {
        return userMapper.update(user);
    }
}
