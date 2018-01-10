package com.ycl.bean.manager.user;

import java.util.Date;

public class TRolePermission {
    private String cId;

    private String cRoleId;

    private String cPermissionId;

    private Integer nValid;

    private String cCreateUser;

    private Date dCreateDate;

    private String cUpdateUser;

    private Date dUpdateDate;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcRoleId() {
        return cRoleId;
    }

    public void setcRoleId(String cRoleId) {
        this.cRoleId = cRoleId == null ? null : cRoleId.trim();
    }

    public String getcPermissionId() {
        return cPermissionId;
    }

    public void setcPermissionId(String cPermissionId) {
        this.cPermissionId = cPermissionId == null ? null : cPermissionId.trim();
    }

    public Integer getnValid() {
        return nValid;
    }

    public void setnValid(Integer nValid) {
        this.nValid = nValid;
    }

    public String getcCreateUser() {
        return cCreateUser;
    }

    public void setcCreateUser(String cCreateUser) {
        this.cCreateUser = cCreateUser == null ? null : cCreateUser.trim();
    }

    public Date getdCreateDate() {
        return dCreateDate;
    }

    public void setdCreateDate(Date dCreateDate) {
        this.dCreateDate = dCreateDate;
    }

    public String getcUpdateUser() {
        return cUpdateUser;
    }

    public void setcUpdateUser(String cUpdateUser) {
        this.cUpdateUser = cUpdateUser == null ? null : cUpdateUser.trim();
    }

    public Date getdUpdateDate() {
        return dUpdateDate;
    }

    public void setdUpdateDate(Date dUpdateDate) {
        this.dUpdateDate = dUpdateDate;
    }
}