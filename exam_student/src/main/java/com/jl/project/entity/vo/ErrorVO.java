package com.jl.project.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 错题集合
 */
@Schema(description = "错题集合")
public class ErrorVO {

    /**
     * 题目信息
     */
    @Schema(description = "题目信息")
    private QuAndAnswerVo quAndAnswerVo;
    /**
     * 正确次数
     */
    @Schema(description = "正确次数")
    private Integer rightCount;
    /**
     * 错误次数
     */
    @Schema(description = "错误次数")
    private Integer wrongCount;
    /**
     * 总回答次数
     */
    @Schema(description = "总回答次数")
    private Integer totalCount;

    public QuAndAnswerVo getQuAndAnswerVo() {
        return quAndAnswerVo;
    }

    public void setQuAndAnswerVo(QuAndAnswerVo quAndAnswerVo) {
        this.quAndAnswerVo = quAndAnswerVo;
    }

    public Integer getRightCount() {
        return rightCount;
    }

    public void setRightCount(Integer rightCount) {
        this.rightCount = rightCount;
    }

    public Integer getWrongCount() {
        return wrongCount;
    }

    public void setWrongCount(Integer wrongCount) {
        this.wrongCount = wrongCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
