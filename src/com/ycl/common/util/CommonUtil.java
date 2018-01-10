package com.ycl.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import com.ycl.common.constants.CommonConstants.CommonConstant;
import com.ycl.common.constants.CommonConstants.NumberConstant;
import com.ycl.mapper.user.UserColumn;

/**
 * 共通工具类
 * @author Administrator
 *
 */
public class CommonUtil {

    /**
     * 获取uuid
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 字符串转数字
     * @param value
     * @return
     */
    public static int str2int(String value) {
        return Integer.valueOf(value);
    }

    /**
     * 获取字段名sql
     * @param <T>
     * @return
     */
    public static <T> String getColumn(Class<T> clazz, String alias) {
        String tmpAlias = StringUtils.EMPTY;
        // 判断别名不为空添加.
        if (!StringUtils.isEmpty(alias)) {
            tmpAlias = String.format("%s%s", alias,
                CommonConstant.SIGN_COMMA.getValue());
        }

        StringBuilder column = new StringBuilder();
        if (clazz.isEnum()) {
            T[] ts = clazz.getEnumConstants();
            for (T t : ts) {
                Enum<?> tempEnum = (Enum<?>) t;
                column.append(String.format("        %s%s%s", tmpAlias,
                    tempEnum.name(), CommonConstant.SIGN_COMMA.getValue()));
            }
        }
        return column.toString().substring(NumberConstant.ZERO.getValue(),
            column.toString()
                    .lastIndexOf(CommonConstant.SIGN_COMMA.getValue()));
    }

    /**
     * 获取字段名sql
     * @param <T>
     * @return
     */
    public static <T> String[] getColumnNames(Class<T> clazz) {
        List<String> colNames = new ArrayList<String>();
        if (clazz.isEnum()) {
            T[] ts = clazz.getEnumConstants();
            for (T t : ts) {
                Enum<?> tempEnum = (Enum<?>) t;
                colNames.add(tempEnum.name());
            }
        }
        return colNames.toArray(new String[colNames.size()]);
    }

    /**
     * 判断是否为空
     * @param obj 
     * @return
     */
    public static boolean isNotNull(Object obj) {
        if (obj instanceof String) {
            return !StringUtils.isEmpty((String) obj);
        }
        if (obj == null) {
            return false;
        }
        return true;
    }

    /**
     * 判断是否为空
     * @param obj 
     * @return
     */
    public static boolean isNull(Object obj) {
        if (obj instanceof String) {
            return StringUtils.isEmpty((String) obj);
        }
        if (obj == null) {
            return true;
        }
        return false;
    }

    public static String getStrValue(Object value) {
        if (value instanceof Date) {
            DateFormat fmt = new SimpleDateFormat(
                    CommonConstant.YYYY_MM_DD.getValue());
            return fmt.format(value);
        }
        if (value instanceof Integer) {
            return String.valueOf(value);
        }

        if (value instanceof Long) {
            return String.valueOf(value);
        }

        return StringUtils.EMPTY;
    }

    public static void main(String[] args) {
        CommonUtil.getColumn(UserColumn.class, StringUtils.EMPTY);
        //        CommonUtil.str2int("");
    }

}
