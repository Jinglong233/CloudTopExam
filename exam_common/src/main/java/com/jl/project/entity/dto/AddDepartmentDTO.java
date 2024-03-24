package com.jl.project.entity.dto;

public class AddDepartmentDTO {
    /**
     * 上层部门code
     */
    private String parentCode;

    /**
     * 部门层级
     */
    private Integer deptLevel;


    /**
     * 部门名称
     */
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
