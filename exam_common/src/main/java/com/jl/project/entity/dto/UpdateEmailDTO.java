package com.jl.project.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 更新绑定邮箱
 */
@Schema(description = "更新绑定邮箱")
public class UpdateEmailDTO {

    /**
     * 用户Id
     */
    @Schema(description = "用户Id")
    private String userId;


    /**
     * 邮箱
     */
    @Schema(description = "邮箱")
    private String email;

    /**
     * 验证码
     */
    @Schema(description = "验证码")
    private String code;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
