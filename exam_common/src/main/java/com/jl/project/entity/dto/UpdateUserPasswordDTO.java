package com.jl.project.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 修改用户密码DTO
 */
@Schema(description = "修改用户密码DTO")
public class UpdateUserPasswordDTO {

    /**
     * 用户Id
     */
    @Schema(description = "用户Id")
    private String userId;

    /**
     * 原密码
     */
    @Schema(description = "原密码")
    private String oldPassword;

    /**
     * 新密码
     */
    @Schema(description = "新密码")
    private String newPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
