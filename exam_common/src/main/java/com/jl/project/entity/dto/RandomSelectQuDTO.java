package com.jl.project.entity.dto;

import com.jl.project.entity.po.ClassfiySelect;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

/**
 * 随机抽取题目DTO
 */
@Schema(description = "随机抽取题目DTO")
public class RandomSelectQuDTO {

    /**
     * 题目排除列表
     */
    @Schema(description = "题目排除列表")
    private List<String> excludes;

    /**
     * 题库ID
     */
    @Schema(description = "题库ID")
    private String repoId;

    /**
     * 分类列表
     */
    @Schema(description = "分类列表")
    private List<ClassfiySelect> levels;
    /**
     * 题型
     */
    @Schema(description = "题型")
    private Integer quType;

    public String getRepoId() {
        return repoId;
    }

    public void setRepoId(String repoId) {
        this.repoId = repoId;
    }

    public List<ClassfiySelect> getLevels() {
        return levels;
    }

    public void setLevels(List<ClassfiySelect> levels) {
        this.levels = levels;
    }

    public Integer getQuType() {
        return quType;
    }

    public void setQuType(Integer quType) {
        this.quType = quType;
    }

    public List<String> getExcludes() {
        return excludes;
    }

    public void setExcludes(List<String> excludes) {
        this.excludes = excludes;
    }
}


