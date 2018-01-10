package com.ycl.mapper.user;

import com.ycl.common.util.CommonUtil;
import com.ycl.mapper.CommonSql;

/**
 * 用户语句表
 * @author huayu
 *
 */
public class UserSql {
    /** 用户表名称  */
    private static String TABLE_NAME = "T_USER";

    /**
     * 新增用户表数据
     * @return
     */
    public static String insert() {
        String[] colNames = CommonUtil.getColumnNames(UserColumn.class);
        return CommonSql.insert(TABLE_NAME, colNames);
    }

}
