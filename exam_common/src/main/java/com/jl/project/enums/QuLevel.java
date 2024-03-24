package com.jl.project.enums;

public enum QuLevel {
    HARD("困难", 1),
    EASY("简单", 0);
    private String level;
    private Integer value;

    QuLevel(String level, Integer value) {
        this.level = level;
        this.value = value;
    }

    public String getLevel() {
        return level;
    }

    public Integer getValue() {
        return value;
    }

}
