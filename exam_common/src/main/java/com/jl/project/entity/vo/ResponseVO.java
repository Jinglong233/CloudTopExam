package com.jl.project.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

/**
 * 响应对象
 *
 * @param <T>
 */
@ApiResponse
@Schema(description = "响应对象")
public class ResponseVO<T> {
    /**
     * 状态
     */
    @Schema(description = "状态")
    private String status;
    /**
     * 响应码
     */
    @Schema(description = "响应码")
    private Integer code;
    /**
     * 响应信息
     */
    @Schema(description = "响应信息")
    private String info;
    /**
     * 响应对象
     */
    @Schema(description = "响应对象")
    private T data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {

        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
