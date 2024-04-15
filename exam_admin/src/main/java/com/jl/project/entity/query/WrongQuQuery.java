package com.jl.project.entity.query;

import com.jl.project.entity.po.Qu;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 错题查询对象
 */
@Schema(description = "错题查询对象")
public class WrongQuQuery extends Qu {
    /**
     * 部门编号
     */
    @Schema(description = "部门编号")
    private String deptCode;

    /**
     * 试卷Id
     */
    @Schema(description = "试卷Id")
    private String paperId;


    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }
}
