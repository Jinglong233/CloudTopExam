package com.jl.project.entity.dto;

import com.jl.project.annotation.VerifyParam;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 更新部门排序DTO
 */
@Schema(description = "更新部门排序DTO")
public class UpdateDeptSortDTO {
    /**
     * 部门ID
     */
    @Schema(description = "部门ID")
    @VerifyParam(require = true)
    String deptId;

    /**
     * 排序方式（1：上移 0：下移）
     */
    @Schema(description = "排序方式（1：上移 0：下移）")
    @VerifyParam(require = true)
    Integer sort;

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
