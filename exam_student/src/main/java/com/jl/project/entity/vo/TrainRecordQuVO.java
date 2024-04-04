package com.jl.project.entity.vo;

import com.jl.project.entity.po.TrainRecord;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "训练题目VO")
public class TrainRecordQuVO {
    @Schema(description = "题目答案VO")
    private QuAndAnswerVo quAndAnswerVo;
    @Schema(description = "题目训练记录")
    private TrainRecord trainRecord;

    public QuAndAnswerVo getQuAndAnswerVo() {
        return quAndAnswerVo;
    }

    public void setQuAndAnswerVo(QuAndAnswerVo quAndAnswerVo) {
        this.quAndAnswerVo = quAndAnswerVo;
    }

    public TrainRecord getTrainRecord() {
        return trainRecord;
    }

    public void setTrainRecord(TrainRecord trainRecord) {
        this.trainRecord = trainRecord;
    }
}
