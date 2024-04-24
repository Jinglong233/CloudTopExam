package com.jl.project.entity.dto;

import com.jl.project.annotation.VerifyParam;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 添加用户DTO
 */
public class AddUserDTO {

    /**
     * 用户名
     */
    @Schema(description = "用户名")
    @VerifyParam(require = true)
    private String userName;


    /**
     * 部门编号
     */
    @Schema(description = "部门编号")
    @VerifyParam(require = true)
    private String deptCode;


    /**
     * 性别0:女1:男
     */
    @Schema(description = "性别0:女1:男")
    @VerifyParam(require = true)
    private Integer sex;

    /**
     * 手机
     */
    @Schema(description = "手机")
    private String phone;

    /**
     * 密码
     */
    @Schema(description = "密码")
    @VerifyParam(require = true)
    private String password;


    /**
     * 真实姓名
     */
    @Schema(description = "真实姓名")
    @VerifyParam(require = true)
    private String realName;

    /**
     * 角色
     */
    @Schema(description = "角色")
    @VerifyParam(require = true)
    private String role;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



}
