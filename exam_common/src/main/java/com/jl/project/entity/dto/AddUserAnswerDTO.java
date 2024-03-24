package com.jl.project.entity.dto;

import com.jl.project.entity.vo.PaperAndQuVO;

public class AddUserAnswerDTO {
    private PaperAndQuVO paperAndQuVO;
    /**
     * 考试记录Id
     */
    private String examRecordId;

    /**
     * 用户Id
     */
    private String userId;

    public PaperAndQuVO getPaperAndQuVO() {
        return paperAndQuVO;
    }

    public void setPaperAndQuVO(PaperAndQuVO paperAndQuVO) {
        this.paperAndQuVO = paperAndQuVO;
    }

    public String getExamRecordId() {
        return examRecordId;
    }

    public void setExamRecordId(String examRecordId) {
        this.examRecordId = examRecordId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
