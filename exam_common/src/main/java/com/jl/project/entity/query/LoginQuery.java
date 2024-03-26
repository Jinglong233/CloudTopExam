package com.jl.project.entity.query;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 登录查询对象
 */
@Schema(description = "登录查询对象")
public class LoginQuery {
    /**
     * 用户名
     */
    @Schema(description = "用户名")
    private String userName;
    /**
     * 密码
     */
    @Schema(description = "密码")
    private String password;
    /**
     * 手机号
     */
    @Schema(description = "手机号")
    private String phone;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
