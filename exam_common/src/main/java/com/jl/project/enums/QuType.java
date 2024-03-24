package com.jl.project.enums;

public enum QuType {
    RADIO("单选题", 1),
    MULTI("多选题", 2),
    JUDGE("判断题", 3),
    FILL("填空题", 4),
    SHORTANSWER("简答题", 5);

    private String type;
    private Integer value;

    QuType(String type, Integer value) {
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
