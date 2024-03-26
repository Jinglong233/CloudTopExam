package com.jl.project.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 展示考试结果VO
 */
@Schema(description = "展示考试结果VO")
public class ExamResultVO {
    /**
     * 是否需要阅卷
     */
    @Schema(description = "是否需要阅卷")
    private Integer reviewQuire;

    /**
     * 得分
     */
    @Schema(description = "得分")
    private Double totalScore;

    /**
     * 是否已经处理
     */
    @Schema(description = "是否已经处理")
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
