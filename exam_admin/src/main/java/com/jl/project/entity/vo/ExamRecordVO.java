package com.jl.project.entity.vo;

import com.jl.project.entity.po.ExamRecord;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 考试记录视图对象
 */
@Schema(description = "考试记录视图对象")
public class ExamRecordVO extends ExamRecord {


    /**
     * 用户名
     */
    @Schema(description = "用户名")
    private String userName;

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

    public Long getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Long answerTime) {
        this.answerTime = answerTime;
    }
}
