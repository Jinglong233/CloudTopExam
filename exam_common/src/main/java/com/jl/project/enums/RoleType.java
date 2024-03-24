package com.jl.project.enums;

public enum RoleType {
    STUDENT("学生", "student"),
    TEACHER("老师", "teacher"),
    ADMIN("管理员", "admin");

    private String type;
    private String value;

    RoleType(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
