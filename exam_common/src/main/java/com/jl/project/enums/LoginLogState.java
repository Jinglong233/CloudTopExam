package com.jl.project.enums;


public enum LoginLogState {

    SUCCESS("登录成功", 1),
    FAIL("登录失败", 0);

    private final String type;
    private final Integer value;

    LoginLogState(String type, Integer value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }


    public Integer getValue() {
        return value;
    }

}
