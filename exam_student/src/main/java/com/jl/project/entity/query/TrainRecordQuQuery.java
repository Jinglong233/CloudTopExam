package com.jl.project.entity.query;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "训练题目查询对象")
public class TrainRecordQuQuery {
    @Schema(description = "排序")
    private Integer sort;
    @Schema(description = "训练Id")
    private String trainId;

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }
}
