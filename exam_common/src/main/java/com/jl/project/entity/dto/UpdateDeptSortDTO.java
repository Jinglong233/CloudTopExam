package com.jl.project.entity.dto;

public class UpdateDeptSortDTO {
    /**
     * 部门ID
     */
    String deptId;

    /**
     * 排序方式（1：上移 0：下移）
     */
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
