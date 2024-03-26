package com.jl.project.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 添加题库DTO
 */
@Schema(description = "添加题库DTO")
public class AddRepoDTO {

    /**
     * 题库标题
     */
    @Schema(description = "题库标题")
    private String title;
    /**
     * 部门编码（专业）
     */
    @Schema(description = "部门编码（专业）")
    private String deptCode;

    /**
     * 学科ID
     */
    @Schema(description = "学科ID")
    private String subjectId;

    /**
     * 是否用于考试
     */
    @Schema(description = "是否用于考试")
    private Integer isExam;

    /**
     * 是否用于训练
     */
    @Schema(description = "是否用于训练")
    private Integer isTrain;

    /**
     * 备注
     */
    @Schema(description = "备注")
    private String remark;

    /**
     * 创建者
     */
    @Schema(description = "创建者")
    private String createBy;

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getIsExam() {
        return isExam;
    }

    public void setIsExam(Integer isExam) {
        this.isExam = isExam;
    }

    public Integer getIsTrain() {
        return isTrain;
    }

    public void setIsTrain(Integer isTrain) {
        this.isTrain = isTrain;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
