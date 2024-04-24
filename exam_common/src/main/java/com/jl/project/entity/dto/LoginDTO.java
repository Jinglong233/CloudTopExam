package com.jl.project.entity.dto;

import com.jl.project.annotation.VerifyParam;
import com.jl.project.enums.VerifyRegexEnum;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 登录传输对象
 */
@Schema(description = "登录传输对象")
public class LoginDTO {
    /**
     * 用户名
     */
    @Schema(description = "用户名")
    @VerifyParam(require = true)
    private String userName;
    /**
     * 密码
     */
    @Schema(description = "密码")
    @VerifyParam(require = true)
    private String password;
    /**
     * 手机号
     */
    @Schema(description = "手机号")
    @VerifyParam(require = false, regex = VerifyRegexEnum.PHONE)
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
