package com.jl.project.enums;

/**
 * @Author jingLong
 * @Date 2024-06-21 16:00
 **/
public enum QuerySort {
    ASC("升序","ASC"),
    DESC("降序","DESC");


    private String name;
    private String value;

    QuerySort(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
