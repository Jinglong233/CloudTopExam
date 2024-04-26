package com.jl.project.entity.dto;

import com.jl.project.annotation.VerifyParam;
import com.jl.project.enums.VerifyRegexEnum;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 检验验证码传输对象
 */
@Schema(description = "检验验证码传输对象")
public class CheckEmailCodeDTO {
    /**
     * 邮箱
     */
    @Schema(description = "邮箱")
    @VerifyParam(require = true, regex = VerifyRegexEnum.EMAIL)
    private String email;
    /**
     * 验证码
     */
    @Schema(description = "验证码")
    @VerifyParam(require = true)
    private String code;

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
