package com.jl.project.entity.dto;

import com.jl.project.annotation.VerifyParam;
import com.jl.project.enums.VerifyRegexEnum;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 找回密码传输对象（用于发送验证）
 */
@Schema(description = "找回密码传输对象（用于发送验证）")
public class RetrievePasswordDTO {

    /**
     * 用户名
     */
    @Schema(description = "用户名")
    @VerifyParam(require = true)
    private String userName;

    /**
     * 邮箱
     */
    @Schema(description = "邮箱")
    @VerifyParam(require = true,regex = VerifyRegexEnum.EMAIL)
    private String email;

    /**
     * 验证码正确之后，该字段用于接收新密码
     */
    @Schema(description = "验证码正确之后，该字段用于接收新密码")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
