package com.ycl.common.constants;

/**
 * 常量定义类
 * @author Administrator
 *
 */
public class CommonConstants {

    /** 公用常量  */
    public static enum CommonConstant {
        /** tomcat端口号 8099  */
        TOMCAT_PORT("8099"),
        /** 日期格式 yyyy-MM-dd  */
        YYYY_MM_DD("yyyy-MM-dd"),
        /** 日期格式 yyyy-MM-dd HH:mm:ss  */
        YYYY_MM_DD_HH_MM_SS("yyyy-MM-dd HH:mm:ss"),
        /** 逗号  , */
        SIGN_COMMA(",");

        private final String value;

        CommonConstant(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    /** 密码加密方式 */
    public static enum HashAlgorithmName {
        /** 当前登录用户session key currentUser */
        MD5("MD5");
        private final String value;

        HashAlgorithmName(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * session key
     * @author Administrator
     *
     */
    public static enum SessionKey {
        /** 当前登录用户session key currentUser */
        CURRENT_USER("currentUser");
        private final String value;

        SessionKey(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * sql符号
     * @author Administrator
     *
     */
    public static enum SqlCondition {
        /** 等于 */
        EQUAL("="),
        /** like */
        LIKE("like");
        private final String value;

        SqlCondition(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    /** 用户状态 */
    public static enum UserState {
        /** 未认证 0 */
        UNAUTHORIZED(0),
        /** 正常 1 */
        NORMAL(1),
        /** 锁定 2 */
        LOCK(2);

        private final int value;

        UserState(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /** 有效无效 */
    public static enum NValid {
        /** 有效 1 */
        VALID(1),
        /** 无效 0 */
        INVALID(0);

        private final int value;

        NValid(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /** 数字常量  */
    public static enum NumberConstant {
        /** 负一 -1  */
        MINUS_ONE(-1),
        /** 零 0  */
        ZERO(0),
        /** 一 1  */
        ONE(1),
        /** 二 2  */
        TWO(2),
        /** 三 3  */
        THREE(3),
        /** 四 4  */
        FOUR(4),
        /** 五 5  */
        FIVE(5),
        /** 六 6  */
        SIX(6),
        /** 七 7  */
        SEVEN(7),
        /** 八 8  */
        EIGHT(8),
        /** 九 9  */
        NINE(9),
        /** 一百 100  */
        HUNDARD(100);

        private final int value;

        NumberConstant(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
