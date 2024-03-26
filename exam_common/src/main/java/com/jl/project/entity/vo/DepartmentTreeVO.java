package com.jl.project.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;
import java.util.List;

/**
 * 部分树VO
 */
@Schema(description = "部分树VO")
public class DepartmentTreeVO {
    /**
     * ID
     */
    @Schema(description = "ID")
    private String id;

    /**
     * 上层部门code
     */
    @Schema(description = "上层部门code")
    private String parentCode;

    /**
     * 部门编码
     */
    @Schema(description = "部门编码")
    private String deptCode;

    /**
     * 部门层级
     */
    @Schema(description = "部门层级")
    private Integer deptLevel;

    /**
     * 部门类型（预留）
     */
    @Schema(description = "部门类型（预留）")
    private String deptType;

    /**
     * 部门名称
     */
    @Schema(description = "部门名称")
    private String deptName;

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
    private String remark;

    /**
     * 排序
     */
    @Schema(description = "排序")
    private Integer sort;

    /**
     * 子列表
     */
    @Schema(description = "子列表")
    private List<DepartmentTreeVO> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public Integer getDeptLevel() {
        return deptLevel;
    }

    public void setDeptLevel(Integer deptLevel) {
        this.deptLevel = deptLevel;
    }

    public String getDeptType() {
        return deptType;
    }

    public void setDeptType(String deptType) {
        this.deptType = deptType;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<DepartmentTreeVO> getChildren() {
        return children;
    }

    public void setChildren(List<DepartmentTreeVO> children) {
        this.children = children;
    }
}
