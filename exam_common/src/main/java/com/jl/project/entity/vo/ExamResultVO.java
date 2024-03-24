package com.jl.project.entity.vo;

public class ExamResultVO {
    /**
     * 是否需要阅卷
     */
    private Integer reviewQuire;

    /**
     * 得分
     */
    private Double totalScore;

    /**
     * 是否已经处理
     */
    private Integer isHandle;

    public Integer getReviewQuire() {
        return reviewQuire;
    }

    public void setReviewQuire(Integer reviewQuire) {
        this.reviewQuire = reviewQuire;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getIsHandle() {
        return isHandle;
    }

    public void setIsHandle(Integer isHandle) {
        this.isHandle = isHandle;
    }
}
