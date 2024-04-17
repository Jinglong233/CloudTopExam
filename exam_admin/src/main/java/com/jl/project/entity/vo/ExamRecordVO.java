package com.jl.project.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 考试记录视图对象
 */
@Schema(description = "考试记录视图对象")
public class ExamRecordVO {
    /**
     * 用户名
     */
    @Schema(description = "用户名")
    private String userName;
    /**
     * 是否通过
     */
    @Schema(description = "是否通过")
    private Integer passed;
    /**
     * 得分
     */
    @Schema(description = "得分")
    private Integer totalScore;

    /**
     * 异常状态
     */
    @Schema(description = "异常状态")
    private Integer exState;
    /**
     * 异常信息
     */
    @Schema(description = "异常信息")
    private String exMsg;
    /**
     * 作答状态
     */
    @Schema(description = "作答状态")
    private Integer state;
    /**
     * 答卷时长
     */
    @Schema(description = "答卷时长")
    private Long answerTime;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getPassed() {
        return passed;
    }

    public void setPassed(Integer passed) {
        this.passed = passed;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getExState() {
        return exState;
    }

    public void setExState(Integer exState) {
        this.exState = exState;
    }

    public String getExMsg() {
        return exMsg;
    }

    public void setExMsg(String exMsg) {
        this.exMsg = exMsg;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Long answerTime) {
        this.answerTime = answerTime;
    }
}
