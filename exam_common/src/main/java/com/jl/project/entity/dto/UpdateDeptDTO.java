package com.jl.project.entity.dto;

import com.jl.project.entity.po.Department;

public class UpdateDeptDTO {
    private Department department;
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
