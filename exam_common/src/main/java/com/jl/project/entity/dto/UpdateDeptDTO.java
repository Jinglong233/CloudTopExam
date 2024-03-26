package com.jl.project.entity.dto;

import com.jl.project.entity.po.Department;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 更新部门信息DTO
 */
@Schema(description = "更新部门信息DTO")
public class UpdateDeptDTO {
    /**
     * 部门对象
     */
    @Schema(description = "部门对象")
    private Department department;
    /**
     * 部门id
     */
    @Schema(description = "部门id")
    private String id;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
