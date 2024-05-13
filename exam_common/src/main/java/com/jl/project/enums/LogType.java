package com.jl.project.enums;

/**
 * @Author huawei
 * @Date 2024-05-13 10:47
 **/
public enum LogType {

    LOGIN_LOG("登录日志", 0),
    OPERATION_LOG("操作日志", 1);

    /**
     * 日志类型
     */
    private String type;
    /**
     * 对应的值
     */
    private Integer value;

    LogType(String type, Integer value) {
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
