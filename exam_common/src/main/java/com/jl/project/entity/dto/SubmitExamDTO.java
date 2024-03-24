package com.jl.project.entity.dto;

import com.jl.project.entity.po.Qu;

import java.util.List;

public class SubmitExamDTO {
    private String examRecordId;
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
