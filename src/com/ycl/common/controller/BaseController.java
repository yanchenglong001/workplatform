package com.ycl.common.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;

import com.ycl.bean.manager.user.TUser;
import com.ycl.common.util.DateUtil;

/**
 * 基础控制器
 * @author huayu
 *
 */
public class BaseController {
    /**
     * 返回成功失败标识
     * @author huayu
     *
     */
    static enum RtFlag {
        /** 成功key */
        SUCCESS("success"),
        /** 失败key */
        FAIL("fail"),
        /**msg 信息key*/
        MSG("msg");
        private final String value;

        RtFlag(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * 
     * @Title: getCurrentDate
     * @Description: TODO(获取本地当前时间)
     * @param locale
     * @return
     * @throws
     */
    protected String getCurrentLocaleDate(Locale locale) {
        return DateUtil.getCurrentLocaleDate(locale);
    }

    /**
     * 
     * @Title: log
     * @Description: TODO(日志)
     * @param logger
     * @param user
     * @param locale
     * @param controlle
     * r
     * @param method
     * @throws
     */
    protected void log(Logger logger, Locale locale, String user,
            String controller, String method) {
        logger.info(
            String.format(" at %s user[%s] exec Controller[%s] method [%s] ",
                user, getCurrentLocaleDate(locale), controller, method));
    }

    /**获取错误消息map
     * 
     * @param msg
     * @return
     */
    protected Map<String, Object> getErrorMap(String msg) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(RtFlag.FAIL.getValue(), false);
        map.put(RtFlag.MSG.getValue(), msg);
        return map;
    }

    /**
     * 设置当前登录用户信息
     * @param user
     */
    protected void setCurrentUser(TUser user) {
        SecurityUtils.getSubject().getSession().setAttribute("currentUser",
            user);
    }

    /**
     * 获取当前登录用户信息
     * @return
     */
    protected TUser getCurrentUser() {
        TUser user = (TUser) SecurityUtils.getSubject().getSession()
                .getAttribute("currentUser");
        return user;
    }

}
