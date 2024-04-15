package com.jl.project.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 错题视图对象
 */
@Schema(description = "错题视图对象")
public class WrongQuVO {

    /**
     * 题目和对应选项列表
     */
    @Schema(description = "题目和对应选项列表")
    private QuAndAnswerVo quAndAnswerVo;
    /**
     * 答对人数
     */
    @Schema(description = "答对人数")
    private Integer rightCount;

    /**
     * 答错人数
     */
    @Schema(description = "答错人数")
    private Integer errorCount;

    /**
     * 正确率
     */
    @Schema(description = "正确率")
    private String rightRate;

    public Integer getRightCount() {
        return rightCount;
    }

    public void setRightCount(Integer rightCount) {
        this.rightCount = rightCount;
    }

    public Integer getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(Integer errorCount) {
        this.errorCount = errorCount;
    }

    public String getRightRate() {
        return rightRate;
    }

    public void setRightRate(String rightRate) {
        this.rightRate = rightRate;
    }

    public QuAndAnswerVo getQuAndAnswerVo() {
        return quAndAnswerVo;
    }

    public void setQuAndAnswerVo(QuAndAnswerVo quAndAnswerVo) {
        this.quAndAnswerVo = quAndAnswerVo;
    }
}
