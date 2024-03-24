package com.jl.project.entity.dto;

import com.jl.project.entity.po.ExamRecord;

public class UpdateExamRecordDTO{

    // 考试记录
    private ExamRecord examRecord;

    // 考试记录的Id
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
