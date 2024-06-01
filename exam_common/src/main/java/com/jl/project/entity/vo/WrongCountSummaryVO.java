package com.jl.project.entity.vo;

/**
 * @Author huawei
 * @Date 2024-05-31 16:36
 **/
public class WrongCountSummaryVO {
    /**
     * 题型
     */
    private Integer quType;
    /**
     * 知识点
     */
    private String knContent;

    /**
     * 总数
     */
    private Integer totalWrongCount;

    public WrongCountSummaryVO() {
    }

    public WrongCountSummaryVO(Integer quType, String knContent, Integer totalWrongCount) {
        this.quType = quType;
        this.knContent = knContent;
        this.totalWrongCount = totalWrongCount;
    }

    public String getKnContent() {
        return knContent;
    }

    public void setKnContent(String knContent) {
        this.knContent = knContent;
    }

    public Integer getQuType() {
        return quType;
    }

    public void setQuType(Integer quType) {
        this.quType = quType;
    }



    public Integer getTotalWrongCount() {
        return totalWrongCount;
    }

    public void setTotalWrongCount(Integer totalWrongCount) {
        this.totalWrongCount = totalWrongCount;
    }
}
