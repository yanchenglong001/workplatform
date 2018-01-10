package com.ycl.common.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Administrator
 *
 */
public class BaseBean implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 8354607087268620195L;

    private String cCreateUser;

    private Date dCreateDate;

    private String cUpdateUser;

    private Date dUpdateDate;

    public String getcCreateUser() {
        return cCreateUser;
    }

    public void setcCreateUser(String cCreateUser) {
        this.cCreateUser = cCreateUser;
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
        this.cUpdateUser = cUpdateUser;
    }

    public Date getdUpdateDate() {
        return dUpdateDate;
    }

    public void setdUpdateDate(Date dUpdateDate) {
        this.dUpdateDate = dUpdateDate;
    }
}
