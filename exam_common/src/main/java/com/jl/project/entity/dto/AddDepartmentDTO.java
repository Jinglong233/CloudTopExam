package com.jl.project.entity.dto;

import com.jl.project.annotation.VerifyParam;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 添加部门DTO
 */
@Schema(description = "添加部门DTO")
public class AddDepartmentDTO {
    /**
     * 上层部门code
     */
    @Schema(description = "上层部门code")
    private String parentCode;

    /**
     * 部门层级
     */
    @Schema(description = "部门层级")
    private Integer deptLevel;


    /**
     * 部门名称
     */
    @Schema(description = "部门名称")
    @VerifyParam(require = true)
    private String deptName;

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public Integer getDeptLevel() {
        return deptLevel;
    }

    public void setDeptLevel(Integer deptLevel) {
        this.deptLevel = deptLevel;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
