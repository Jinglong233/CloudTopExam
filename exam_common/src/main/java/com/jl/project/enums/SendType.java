package com.jl.project.enums;

/**
 * 发送类型
 *
 * @Author huawei
 * @Date 2024-05-08 20:04
 **/
public enum SendType {
    FULLOPEN("完全开放", 0),
    MEMBER("指定成员", 1),
    DEPARTMENT("指定部门", 2);

    private String type;
    private int value;

    SendType(String type, int value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
}
