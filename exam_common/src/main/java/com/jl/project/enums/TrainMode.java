package com.jl.project.enums;

public enum TrainMode {

    INTELLIGENT("智能推荐", 0),


    SEQUENCE("顺序训练", 1),

    RANDOM("随机训练", 2),

    QUTYPE("指定题型训练", 3);

    private String type;
    private Integer value;

    TrainMode(String type, Integer value) {
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
