package com.jl.project.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 添加学科DTO
 */
@Schema(description = "添加学科DTO")
public class AddSubjectDTO {


    /**
     * 父学科Id
     */
    @Schema(description = "父学科Id")
    private String parentId;
    /**
     * 学科标题
     */
    @Schema(description = "学科标题")
    private String title;
    /**
     * 部门编码
     */
    @Schema(description = "部门编码")
    private String deptCode;
    /**
     * 描述
     */
    @Schema(description = "描述")
    private String description;

    /**
     * 创建者
     */
    @Schema(description = "创建者")
    private String createBy;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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


    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
