package com.jl.project.entity.dto;

import com.jl.project.entity.po.Qu;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

/**
 * 提交答卷DTO
 */
@Schema(description = "提交答卷DTO")
public class SubmitExamDTO {
    /**
     * 考试记录Id
     */
    @Schema(description = "考试记录Id")
    private String examRecordId;
    /**
     * 题目列表
     */
    @Schema(description = "题目列表")
    private List<Qu> quList;

    public String getExamRecordId() {
        return examRecordId;
    }

    public void setExamRecordId(String examRecordId) {
        this.examRecordId = examRecordId;
    }

    public List<Qu> getQuList() {
        return quList;
    }

    public void setQuList(List<Qu> quList) {
        this.quList = quList;
    }
}
