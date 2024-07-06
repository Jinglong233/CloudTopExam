package com.jl.project.enums;

/**
 * @Author jingLong
 * @Date 2024-05-13 12:58
 **/
public enum OperationType {


    NULL("无操作", -1),
    ADD("新增操作", 0),
    DELETE("删除操作", 1),
    UPDATE("更新操作", 2);

    /**
     * 操作类型
     */
    private String type;
    /**
     * 对应的值
     */
    private Integer value;

    OperationType(String type, Integer value) {
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
