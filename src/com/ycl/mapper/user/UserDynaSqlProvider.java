package com.ycl.mapper.user;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import com.ycl.bean.manager.user.TUser;
import com.ycl.common.util.CommonUtil;

/**
 * mybatis 动态语句代理
 * @author Administrator
 *
 */
public class UserDynaSqlProvider {
    private final String tableName = "t_user";
    //    public String getUserByUserBean(User user) {
    //        StringBuilder sql = new StringBuilder();
    //        sql.append(" select ");
    //        sql.append(CommonUtil.getColumn(UserColumn.class, StringUtils.EMPTY));
    //        sql.append(" from t_user ");
    //        StringBuilder whereSql = new StringBuilder();
    //        if (user != null) {
    //            String and = StringUtils.EMPTY;
    //            if (CommonUtil.isNotNull(user.getcId())) {
    //                whereSql.append(appendSql(and, UserColumn.C_ID.getValue(),
    //                    SqlCondition.EQUAL.getValue(), user.getcId()));
    //            }
    //            if (CommonUtil.isNotNull(user.getcLoginId())) {
    //                whereSql.append(appendSql(and, UserColumn.C_LOGIN_ID.getValue(),
    //                    SqlCondition.EQUAL.getValue(), user.getcLoginId()));
    //            }
    //            if (CommonUtil.isNotNull(user.getcName())) {
    //                whereSql.append(appendSql(and, UserColumn.C_NAME.getValue(),
    //                    SqlCondition.LIKE.getValue(), user.getcName()));
    //            }
    //            if (CommonUtil.isNotNull(user.getcPassword())) {
    //                whereSql.append(appendSql(and, UserColumn.C_PASSWORD.getValue(),
    //                    SqlCondition.EQUAL.getValue(), user.getcPassword()));
    //            }
    //            if (CommonUtil.isNotNull(user.getnValid())) {
    //                whereSql.append(appendSql(and, UserColumn.N_VALID.getValue(),
    //                    SqlCondition.EQUAL.getValue(), user.getnValid()));
    //            }
    //            if (CommonUtil.isNotNull(user.getcCreateUser())) {
    //                whereSql.append(
    //                    appendSql(and, UserColumn.C_CREATE_USER.getValue(),
    //                        SqlCondition.EQUAL.getValue(), user.getcCreateUser()));
    //            }
    //            if (CommonUtil.isNotNull(user.getdCreateDate())) {
    //                whereSql.append(
    //                    appendSql(and, UserColumn.D_CREATE_DATE.getValue(),
    //                        SqlCondition.EQUAL.getValue(), user.getdCreateDate()));
    //            }
    //            if (CommonUtil.isNotNull(user.getcUpdateUser())) {
    //                whereSql.append(
    //                    appendSql(and, UserColumn.C_UPDATE_USER.getValue(),
    //                        SqlCondition.EQUAL.getValue(), user.getcUpdateUser()));
    //            }
    //            if (CommonUtil.isNotNull(user.getdUpdateDate())) {
    //                whereSql.append(
    //                    appendSql(and, UserColumn.D_UPDATE_DATE.getValue(),
    //                        SqlCondition.EQUAL.getValue(), user.getdUpdateDate()));
    //            }
    //        }
    //
    //        if (!whereSql.toString().isEmpty()) {
    //            sql.append(" where ").append(whereSql.toString());
    //        }
    //
    //        return sql.toString();
    //    }
    //
    //    private String appendSql(String and, String col, String condition,
    //            Object value) {
    //        String strValue = CommonUtil.getStrValue(value);
    //
    //        String fmt = " %s %s %s %s ";
    //        if (SqlCondition.LIKE.getValue().equals(condition)) {
    //            fmt = " %s %s %s %%%s%% ";
    //        }
    //        String sql = String.format(fmt, and, col, condition, strValue);
    //        if (CommonUtil.isNull(and)) {
    //            and = "and";
    //        }
    //        return sql;
    //    }

    public String getUserByUserBean(final TUser user) {
        //        return new SQL() {
        //            {
        //                SELECT(
        //                    CommonUtil.getColumn(UserColumn.class, StringUtils.EMPTY));
        //                FROM("t_user");
        //                WHERE("d_create_date=#{dCreateDate}");
        //            }
        //        }.toString();

        String sql = new SQL() {
            {
                SELECT(
                    CommonUtil.getColumn(UserColumn.class, StringUtils.EMPTY));
                FROM(tableName);
                if (!StringUtils.isEmpty(user.getcId())) {
                    WHERE(
                        String.format("%s=#{cId}", UserColumn.C_ID.getValue()));
                }
                if (!StringUtils.isEmpty(user.getcLoginId())) {
                    WHERE(String.format("%s=#{cLoginId}",
                        UserColumn.C_LOGIN_ID.getValue()));
                }
                if (!StringUtils.isEmpty(user.getcPassword())) {
                    WHERE(String.format("%s=#{cPassword}",
                        UserColumn.C_PASSWORD.getValue()));
                }
                if (!StringUtils.isEmpty(user.getcName())) {
                    WHERE(String.format("%s=#{cName}",
                        UserColumn.C_NAME.getValue()));
                }
                if (user.getnState() != null) {
                    WHERE(String.format("%s=#{nState}",
                        UserColumn.N_STATE.getValue()));
                }
                if (user.getnValid() != null) {
                    WHERE(String.format("%s=#{nValid}",
                        UserColumn.N_VALID.getValue()));
                }
                if (!StringUtils.isEmpty(user.getcCreateUser())) {
                    WHERE(String.format("%s=#{cCreateUser}",
                        UserColumn.C_CREATE_USER.getValue()));
                }
                if (user.getdCreateDate() != null) {
                    WHERE(String.format("%s=#{dCreateDate}",
                        UserColumn.D_CREATE_DATE.getValue()));
                }
                if (!StringUtils.isEmpty(user.getcUpdateUser())) {
                    WHERE(String.format("%s=#{cUpdateUser}",
                        UserColumn.C_UPDATE_USER.getValue()));
                }
                if (user.getdUpdateDate() != null) {
                    WHERE(String.format("%s=#{dUpdateDate}",
                        UserColumn.D_UPDATE_DATE.getValue()));
                }
            }
        }.toString();
        return sql;
    }

    /**
     * 查询用户
     * @param cLoginId 用户登录id
     * @param cName 用户名
     * @param nState 状态
     * @param nValid 是否有效
     * @return
     */
    public String getUserByCondition(final String cLoginId, final String cName,
            final String nState, final String nValid) {
        String sql = new SQL() {
            {
                SELECT(
                    CommonUtil.getColumn(UserColumn.class, StringUtils.EMPTY));
                FROM(tableName);

                if (!StringUtils.isEmpty(cLoginId)) {
                    WHERE(String.format("%s=#{cLoginId}",
                        UserColumn.C_LOGIN_ID.getValue()));
                }
                if (!StringUtils.isEmpty(cName)) {
                    WHERE(String.format("%s=#{cName}",
                        UserColumn.C_NAME.getValue()));
                }
                if (!StringUtils.isEmpty(nState)) {
                    WHERE(String.format("%s in (#{nState})",
                        UserColumn.N_STATE.getValue()));
                }
                if (!StringUtils.isEmpty(nValid)) {
                    WHERE(String.format("%s in (#{nValid})",
                        UserColumn.N_VALID.getValue()));
                }
            }
        }.toString();
        return sql;
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public String updateUserSql(final TUser user) {
        return new SQL() {
            {
                UPDATE(tableName);
                if (StringUtils.isEmpty(user.getcLoginId())) {
                    SET(String.format("%s=#{cLoginId}",
                        UserColumn.C_LOGIN_ID.getValue()));
                }
                if (StringUtils.isEmpty(user.getcPassword())) {
                    SET(String.format("%s=#{cPassword}",
                        UserColumn.C_PASSWORD.getValue()));
                }
                if (StringUtils.isEmpty(user.getcName())) {
                    SET(String.format("%s=#{cName}",
                        UserColumn.C_NAME.getValue()));
                }
                if (user.getnState() != null) {
                    SET(String.format("%s=#{nState}",
                        UserColumn.N_STATE.getValue()));
                }
                if (user.getnValid() != null) {
                    SET(String.format("%s=#{nValid}",
                        UserColumn.N_VALID.getValue()));
                }
                if (!StringUtils.isEmpty(user.getcCreateUser())) {
                    SET(String.format("%s=#{cCreateUser}",
                        UserColumn.C_CREATE_USER.getValue()));
                }
                if (user.getdCreateDate() != null) {
                    SET(String.format("%s=#{dCreateDate}",
                        UserColumn.D_CREATE_DATE.getValue()));
                }
                if (!StringUtils.isEmpty(user.getcUpdateUser())) {
                    SET(String.format("%s=#{cUpdateUser}",
                        UserColumn.C_UPDATE_USER.getValue()));
                }
                if (user.getdUpdateDate() != null) {
                    SET(String.format("%s=#{dUpdateDate}",
                        UserColumn.D_UPDATE_DATE.getValue()));
                }
                WHERE(String.format("%s=#{cId}", UserColumn.C_ID.getValue()));
            }
        }.toString();
    }
}
