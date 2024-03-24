package com.jl.project.entity.vo;

import com.jl.project.entity.po.Exam;

public class ExamVO extends Exam {
    /**
     * 试卷总分
     */
    private Integer totalCount;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
