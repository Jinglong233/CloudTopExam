package com.jl.project.entity.dto;

import com.jl.project.entity.vo.PaperAndQuVO;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 添加用户答案DTO
 */
@Schema(description = "添加用户答案DTO")
public class AddUserAnswerDTO {
    @Schema(hidden = true)
    private PaperAndQuVO paperAndQuVO;
    /**
     * 考试记录Id
     */
    @Schema(description = "考试记录Id")
    private String examRecordId;

    /**
     * 用户Id
     */
    @Schema(description = "用户Id")
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
