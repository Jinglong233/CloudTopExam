package com.jl.project.entity.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 开始考试DTO
 */
@Schema(description = "开始考试DTO")
public class StartTrainDTO {
    /**
     * 题库Id
     */
    @Schema(description = "题库Id")
    private String repoId;
    /**
     * 训练模式
     */
    @Schema(description = "训练模式")
    private Integer mode;

    /**
     * 题型
     */
    @Schema(description = "题型")
    private Integer quType;

    /**
     * 用户Id
     */
    @Schema(description = "用户Id")
    private String userId;

    /**
     * 开始训练时间
     */
    @Schema(description = "开始训练时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRepoId() {
        return repoId;
    }

    public void setRepoId(String repoId) {
        this.repoId = repoId;
    }

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }

    public Integer getQuType() {
        return quType;
    }

    public void setQuType(Integer quType) {
        this.quType = quType;
    }
}
