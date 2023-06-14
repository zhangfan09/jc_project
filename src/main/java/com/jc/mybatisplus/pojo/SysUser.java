package com.jc.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author jc
 * @since 2023-06-12
 */
@TableName("sys_user")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value="pk_user")//设置指定表中的设置。
    private String pkUser;

    @TableField("cuserid")
    private String cuserid;

    /**
     * 用户编码
     */
    @TableField("user_code")
    private String userCode;

    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;

    @TableField("operat_time")
    private String operatTime;

    @TableField("operat_date")
    private String operatDate;

    @TableField("pk_role")
    private String pkRole;

    @TableField("pk_dept")
    private String pkDept;

    public String getPkUser() {
        return pkUser;
    }

    public void setPkUser(String pkUser) {
        this.pkUser = pkUser;
    }
    public String getCuserid() {
        return cuserid;
    }

    public void setCuserid(String cuserid) {
        this.cuserid = cuserid;
    }
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getOperatTime() {
        return operatTime;
    }

    public void setOperatTime(String operatTime) {
        this.operatTime = operatTime;
    }
    public String getOperatDate() {
        return operatDate;
    }

    public void setOperatDate(String operatDate) {
        this.operatDate = operatDate;
    }
    public String getPkRole() {
        return pkRole;
    }

    public void setPkRole(String pkRole) {
        this.pkRole = pkRole;
    }
    public String getPkDept() {
        return pkDept;
    }

    public void setPkDept(String pkDept) {
        this.pkDept = pkDept;
    }

    @Override
    public String toString() {
        return "SysUser{" +
            "pkUser=" + pkUser +
            ", cuserid=" + cuserid +
            ", userCode=" + userCode +
            ", userName=" + userName +
            ", operatTime=" + operatTime +
            ", operatDate=" + operatDate +
            ", pkRole=" + pkRole +
            ", pkDept=" + pkDept +
        "}";
    }
}
