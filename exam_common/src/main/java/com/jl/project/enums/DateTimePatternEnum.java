package com.jl.project.enums;

public enum DateTimePatternEnum {
    YYYY_MM_DD_HH_MM_ss ("yyyy-MM-dd HH:mm:ss"),
    YYYY_MM_DD ("yyyy-MM-dd");
    private String pattern;
    DateTimePatternEnum(String pattern) {
        this.pattern = pattern;
    }
    public String getPattern(){
        return pattern;
    }
}
