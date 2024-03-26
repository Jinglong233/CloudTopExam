package com.jl.project.entity.vo;

import com.jl.project.entity.po.ExamRecord;
import com.jl.project.entity.po.Paper;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 批改用户试卷视图（考试对应人员的答卷记录）
 */
@Schema(description = "批改用户试卷视图（考试对应人员的答卷记录）")
public class CorrectUserExamUserVO{
    /**
     * 用户名
     */
    @Schema(description = "用户名")
    private String userName;
    /**
     * 试卷对象
     */
    @Schema(description = "试卷对象")
    private Paper paper;
    /**
     * 考试记录对象
     */
    @Schema(description = "考试记录对象")
    private ExamRecord examRecord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public ExamRecord getExamRecord() {
        return examRecord;
    }

    public void setExamRecord(ExamRecord examRecord) {
        this.examRecord = examRecord;
    }
}
