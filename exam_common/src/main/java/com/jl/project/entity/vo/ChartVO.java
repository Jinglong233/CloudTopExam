package com.jl.project.entity.vo;

/**
 * @description 图表数据类型
 * @Author huawei
 * @Date 2024-05-30 17:32
 **/
public class ChartVO {
    /**
     * 题型名称
     */
    private String name;
    /**
     * 题型数量
     */
    private Integer value;

    public ChartVO() {
    }

    public ChartVO(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
