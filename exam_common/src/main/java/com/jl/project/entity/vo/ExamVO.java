package com.jl.project.entity.vo;

import com.jl.project.entity.po.Exam;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 考试VO
 */
@Schema(description = "考试VO")
public class ExamVO extends Exam {
    /**
     * 试卷总分
     */
    @Schema(description = "试卷总分")
    private Integer totalCount;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
