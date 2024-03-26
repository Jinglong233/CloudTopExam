package com.jl.project.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

/**
 * 试卷添加类
 */
@Schema(description = "试卷添加类")
public class AddPaperDTO {

    /**
     * 关联学科ID
     */
    @Schema(description = "关联学科ID")
    private String subjectId;

    /**
     * 试卷标题
     */
    @Schema(description = "试卷标题")
    private String title;

    /**
     * 所属部门（专业）编码
     */
    @Schema(description = "所属部门（专业）编码")
    private String deptCode;

    /**
     * 组卷方式0:题库抽取1:指定选题 其余预留
     */
    @Schema(description = "组卷方式0:题库抽取1:指定选题 其余预留")
    private Integer joinType;

    /**
     * 题目总数
     */
    @Schema(description = "题目总数")
    private Integer quCount;

    /**
     * 试卷总分
     */
    @Schema(description = "试卷总分")
    private Integer totalCount;

    /**
     * 大题列表
     */
    @Schema(description = "大题列表")
    private List<AddGroupListDTO> groupLists;

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public Integer getJoinType() {
        return joinType;
    }

    public void setJoinType(Integer joinType) {
        this.joinType = joinType;
    }

    public Integer getQuCount() {
        return quCount;
    }

    public void setQuCount(Integer quCount) {
        this.quCount = quCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<AddGroupListDTO> getGroupLists() {
        return groupLists;
    }

    public void setGroupLists(List<AddGroupListDTO> groupLists) {
        this.groupLists = groupLists;
    }
}

