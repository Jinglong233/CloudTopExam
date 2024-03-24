package com.jl.project.entity.vo;

/**
 * 题库中题型和难度分类
 */
public class ClassfiyByQuTypeVO {

    /**
     * 题库ID
     */
    private String repoId;

    /**
     * 题型
     */
    private Integer quType;

    /**
     * 简单题型数量
     */
    private Integer easyCount;

    /**
     * 困难题型数量
     */
    private Integer hardCount;

    public ClassfiyByQuTypeVO() {
        // 默认都为0
        hardCount = 0;
        easyCount = 0;
    }

    public Integer getEasyCount() {
        return easyCount;
    }

    public void setEasyCount(Integer easyCount) {
        this.easyCount = easyCount;
    }

    public Integer getHardCount() {
        return hardCount;
    }

    public void setHardCount(Integer hardCount) {
        this.hardCount = hardCount;
    }

    public Integer getQuType() {
        return quType;
    }

    public void setQuType(Integer quType) {
        this.quType = quType;
    }

    public String getRepoId() {
        return repoId;
    }

    public void setRepoId(String repoId) {
        this.repoId = repoId;
    }
}

