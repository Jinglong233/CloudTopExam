package com.jl.project.enums;

public enum OpenType {
    FULLOPEN("完全开放", 0),
    MEMBER("指定成员", 1),
    DEPARTMENT("指定部门", 2);

    private String type;
    private Integer value;

    OpenType(String type, Integer value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


}
