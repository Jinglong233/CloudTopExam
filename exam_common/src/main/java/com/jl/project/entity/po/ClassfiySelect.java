package com.jl.project.entity.po;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 分类选择题目类
 */
@Schema(description = "分类选择题目类")
public class ClassfiySelect {
    /**
     * 题目难度
     */
    @Schema(description = "题目难度")
    private Integer level;
    /**
     * 题目数量
     */
    @Schema(description = "题目数量")
    private Integer quCount;
    /**
     * 选取的题目数量
     */
    @Schema(description = "选取的题目数量")
    private Integer num;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getQuCount() {
        return quCount;
    }

    public void setQuCount(Integer quCount) {
        this.quCount = quCount;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}