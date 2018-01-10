package com.ycl.bean.manager.user;

import com.ycl.common.bean.BaseBean;

/**
 * 用户权限表
 * @author Administrator
 *
 */
public class TUserPermission extends BaseBean {

    /**
     * 
     */
    private static final long serialVersionUID = -4272123526354096538L;

    /**
     * 用户权限id
     */
    private String cId;

    /**
     * 用户id
     */
    private String cUserId;

    /**
     * 权限id
     */
    private String cPermissionId;

    /**
     * 是否有效
     */
    private Integer nValid;

    /**
     * 用户权限id
     * @return 用户权限id
     */
    public String getcId() {
        return cId;
    }

    /**
     * 用户权限id
     * @param cId 用户权限id
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
     * 权限id
     * @return 权限id
     */
    public String getcPermissionId() {
        return cPermissionId;
    }

    /**
     * 权限id
     * @param cPermissionId 权限id
     */
    public void setcPermissionId(String cPermissionId) {
        this.cPermissionId = cPermissionId == null ? null
                : cPermissionId.trim();
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