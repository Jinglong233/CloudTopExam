package com.jl.project.entity.dto;

import com.jl.project.entity.po.ExamRecord;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 更新考试记录DTO
 */
@Schema(description = "更新考试记录DTO")
public class UpdateExamRecordDTO{

    // 考试记录
    @Schema(description = "考试记录")
    private ExamRecord examRecord;

    // 考试记录的Id
    @Schema(description = "考试记录的Id")
    private String id;

    public ExamRecord getExamRecord() {
        return examRecord;
    }

    public void setExamRecord(ExamRecord examRecord) {
        this.examRecord = examRecord;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
