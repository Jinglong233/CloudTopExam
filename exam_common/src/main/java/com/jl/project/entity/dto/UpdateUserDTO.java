package com.jl.project.entity.dto;

import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.po.User;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 更新用户信息DTO
 */
@Schema(description = "更新用户信息DTO")
public class UpdateUserDTO {
    /**
     * 用户对象
     */
    @Schema(description = "用户对象")
    private User user;
    /**
     * 用户Id
     */
    @Schema(description = "用户Id")
    @VerifyParam(require = true)
    private String id;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
