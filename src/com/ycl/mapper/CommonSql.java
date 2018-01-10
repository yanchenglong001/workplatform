package com.ycl.mapper;

import com.ycl.common.constants.CommonConstants;

/**
 * 共通用sql
 * @author huayu
 *
 */
public class CommonSql {

    /**
     * 共通inser语句
     * @param table
     * @param column
     * @return
     */
    public static String insert(String table, String[] columns) {

        StringBuilder sql = new StringBuilder();
        sql.append(" INSERT INTO ");
        sql.append(" ( ");
        sql.append(getColumnSql(columns, false));
        sql.append(" ) ");
        sql.append(" VALUES ");
        sql.append(" ( ");
        sql.append(getColumnSql(columns, true));
        sql.append(" ) ");
        return sql.toString();
    }

    /**
     * 设置字段sql或字段值sql
     * @param columns
     * @param isValue
     * @return
     */
    private static String getColumnSql(String[] columns, boolean isValue) {
        int index = CommonConstants.NumberConstant.ZERO.getValue();
        String fmt = "%s";
        if (isValue) {
            fmt = "#{%s}";
        }
        StringBuilder colSql = new StringBuilder();
        for (String column : columns) {

            colSql.append(String.format(fmt, column));
            if (index < columns.length) {
                colSql.append(",");
            }
            index++;
        }
        return colSql.toString();
    }

}
