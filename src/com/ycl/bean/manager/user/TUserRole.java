package com.ycl.bean.manager.user;

import com.ycl.common.bean.BaseBean;

/**
 * 用户角色表
 * @author Administrator
 *
 */
public class TUserRole extends BaseBean {

    /**
     * 
     */
    private static final long serialVersionUID = 3542310199975555415L;

    /**
     * 用户角色id
     */
    private String cId;

    /**
     * 用户id
     */
    private String cUserId;

    /**
     * 角色id
     */
    private String cRoleId;

    /**
     * 是否有效
     */
    private Integer nValid;

    /**
     * 用户角色id
     * @return 用户角色id
     */
    public String getcId() {
        return cId;
    }

    /**
     * 用户角色id
     * @param cId 用户角色id
     */
    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    /**
     * 用户id
     * @return 用户id
     */
    public String getcUserId() {
        return cUserId;
    }

    /**
     * 用户id
     * @param cUserId 用户id
     */
    public void setcUserId(String cUserId) {
        this.cUserId = cUserId == null ? null : cUserId.trim();
    }

    /**
     * 角色id
     * @return 角色id
     */
    public String getcRoleId() {
        return cRoleId;
    }

    /**
     * 角色id
     * @param cRoleId 角色id
     */
    public void setcRoleId(String cRoleId) {
        this.cRoleId = cRoleId == null ? null : cRoleId.trim();
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