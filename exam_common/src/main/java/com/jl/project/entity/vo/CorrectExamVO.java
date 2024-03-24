package com.jl.project.entity.vo;

import com.jl.project.entity.po.Exam;

public class CorrectExamVO {
    private Exam exam;
    /**
     * 考试人数
     */
    private Integer examTotal;

    /**
     * 待批阅人数
     */
    private Integer correctTotal;

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Integer getExamTotal() {
        return examTotal;
    }

    public void setExamTotal(Integer examTotal) {
        this.examTotal = examTotal;
    }

    public Integer getCorrectTotal() {
        return correctTotal;
    }

    public void setCorrectTotal(Integer correctTotal) {
        this.correctTotal = correctTotal;
    }
}
