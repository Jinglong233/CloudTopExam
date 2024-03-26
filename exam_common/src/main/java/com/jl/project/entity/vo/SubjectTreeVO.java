package com.jl.project.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;
import java.util.List;


/**
 * 部门树
 */
@Schema(description = "部门树")
public class SubjectTreeVO {
    /**
     * ID
     */
    @Schema(description = "ID")
    private String id;

    /**
     * 父Id
     */
    @Schema(description = "父Id")
    private String parentId;


    /**
     * 学科名称
     */
    @Schema(description = "学科名称")
    private String title;

    /**
     * 所属部门
     */
    @Schema(description = "所属部门")
    private String deptCode;

    /**
     * 所属名称
     */
    @Schema(description = "所属名称")
    private String deptText;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private Date createTime;

    /**
     * 创建者
     */
    @Schema(description = "创建者")
    private String createBy;

    /**
     * 更新时间
     */
    @Schema(description = "更新时间")
    private Date updateTime;

    /**
     * 更新者
     */
    @Schema(description = "更新者")
    private String updateBy;

    /**
     * 备注
     */
    @Schema(description = "备注")
    private String description;

    /**
     * 子列表
     */
    @Schema(description = "子列表")
    private List<SubjectTreeVO> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SubjectTreeVO> getChildren() {
        return children;
    }

    public void setChildren(List<SubjectTreeVO> children) {
        this.children = children;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptText() {
        return deptText;
    }

    public void setDeptText(String deptText) {
        this.deptText = deptText;
    }
}
