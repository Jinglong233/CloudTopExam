package com.jl.project.enums;

public enum ExamRecordStateType {
    NOREPLY("未作答", 0),
    UNCOMPLETED("未完成", 1),
    SUBMITTED("已提交", 2);

    private String type;
    private Integer value;

    ExamRecordStateType(String type, Integer value) {
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
