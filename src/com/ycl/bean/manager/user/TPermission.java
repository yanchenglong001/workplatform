package com.ycl.bean.manager.user;

import com.ycl.common.bean.BaseBean;

/**
 * 权限表
 * @author Administrator
 *
 */
public class TPermission extends BaseBean {

    /**
     * 
     */
    private static final long serialVersionUID = -8597978798282903757L;

    /**
     * 权限id
     */
    private String cId;

    /**
     * 权限名称
     */
    private String cName;

    /**
     * 资源类型
     */
    private Integer nResourceType;

    /**
     * 资源路径
     */
    private String cUrl;

    /**
     * 权限字符串
     */
    private String cPermission;

    /**
     * 父权限编号
     */
    private String cParentId;

    /**
     * 是否有效
     */
    private Integer nValid;

    /**
     * 权限id
     * @return 权限id
     */
    public String getcId() {
        return cId;
    }

    /**
     * 权限id
     * @param cId 权限id
     */
    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    /**
     * 权限名称
     * @return 权限名称
     */
    public String getcName() {
        return cName;
    }

    /**
     * 权限名称
     * @param cName 权限名称
     */
    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    /**
     * 资源类型
     * @return 资源类型
     */
    public Integer getnResourceType() {
        return nResourceType;
    }

    /**
     * 资源类型
     * @param nResourceType 资源类型
     */
    public void setnResourceType(Integer nResourceType) {
        this.nResourceType = nResourceType;
    }

    /**
     * 资源路径
     * @return 资源路径
     */
    public String getcUrl() {
        return cUrl;
    }

    /**
     * 资源路径
     * @param cUrl 资源路径
     */
    public void setcUrl(String cUrl) {
        this.cUrl = cUrl == null ? null : cUrl.trim();
    }

    /**
     * 权限字符串
     * @return 权限字符串
     */
    public String getcPermission() {
        return cPermission;
    }

    /**
     * 权限字符串
     * @param cPermission 权限字符串
     */
    public void setcPermission(String cPermission) {
        this.cPermission = cPermission == null ? null : cPermission.trim();
    }

    /**
     * 父权限编号
     * @return 父权限编号
     */
    public String getcParentId() {
        return cParentId;
    }

    /**
     * 父权限编号
     * @param cParentId 父权限编号
     */
    public void setcParentId(String cParentId) {
        this.cParentId = cParentId == null ? null : cParentId.trim();
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