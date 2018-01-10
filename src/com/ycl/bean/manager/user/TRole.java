package com.ycl.bean.manager.user;

import com.ycl.common.bean.BaseBean;

/**
 * 角色表
 * @author Administrator
 *
 */
public class TRole extends BaseBean {

    /**
     * 
     */
    private static final long serialVersionUID = -7516267155508992790L;

    /**
     * 角色名称
     */
    private String cId;

    /**
     * 角色名称
     */
    private String cName;

    /**
     * 是否有效
     */
    private Integer nValid;

    /**
     * 角色名称
     * @return 角色名称
     */
    public String getcId() {
        return cId;
    }

    /**
     * 角色名称
     * @param cId 角色名称
     */
    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    /**
     * 角色名称
     * @return 角色名称
     */
    public String getcName() {
        return cName;
    }

    /**
     * 角色名称
     * @param cName 角色名称
     */
    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
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