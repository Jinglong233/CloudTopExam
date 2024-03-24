package com.jl.project.entity.vo;

import com.jl.project.entity.po.ExamRecord;
import com.jl.project.entity.po.Paper;

/**
 * 批改用户试卷视图（考试对应人员的答卷记录）
 */
public class CorrectUserExamUserVO{
    private String userName;
    private Paper paper;
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
