package com.ycl.bean.manager.user;

import com.ycl.common.bean.BaseBean;

/**
 * 用户表
 * @author Administrator
 *
 */
public class TUser extends BaseBean {

    /**
     * 
     */
    private static final long serialVersionUID = 59188447028589723L;

    /**
     * 用户id
     */
    private String cId;

    /**
     * 用户名称
     */
    private String cName;

    /**
     * 密码
     */
    private String cPassword;

    /**
     * 登录名
     */
    private String cLoginId;

    /**
     * 盐值
     */
    private String cSalt;

    /**
     * 状态
     */
    private Integer nState;

    /**
     * 
     */
    private Integer nValid;

    /**
     * 用户id
     * @return 用户id
     */
    public String getcId() {
        return cId;
    }

    /**
     * 用户id
     * @param cId 用户id
     */
    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    /**
     * 用户名称
     * @return 用户名称
     */
    public String getcName() {
        return cName;
    }

    /**
     * 用户名称
     * @param cName 用户名称
     */
    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    /**
     * 密码
     * @return 密码
     */
    public String getcPassword() {
        return cPassword;
    }

    /**
     * 密码
     * @param cPassword 密码
     */
    public void setcPassword(String cPassword) {
        this.cPassword = cPassword == null ? null : cPassword.trim();
    }

    /**
     * 登录名
     * @return 登录名
     */
    public String getcLoginId() {
        return cLoginId;
    }

    /**
     * 登录名
     * @param cLoginId 登录名
     */
    public void setcLoginId(String cLoginId) {
        this.cLoginId = cLoginId == null ? null : cLoginId.trim();
    }

    /**
     * 盐值
     * @return 盐值
     */
    public String getcSalt() {
        return cSalt;
    }

    /**
     * 盐值
     * @param cSalt 盐值
     */
    public void setcSalt(String cSalt) {
        this.cSalt = cSalt == null ? null : cSalt.trim();
    }

    /**
     * 状态
     * @return 状态
     */
    public Integer getnState() {
        return nState;
    }

    /**
     * 状态
     * @param nState 状态
     */
    public void setnState(Integer nState) {
        this.nState = nState;
    }

    /**
     * 是否有效
     * @return 是否有效
     */
    public Integer getnValid() {
        return nValid;
    }

    /**
     * 是否有效
     * @param nValid 是否有效
     */
    public void setnValid(Integer nValid) {
        this.nValid = nValid;
    }

}