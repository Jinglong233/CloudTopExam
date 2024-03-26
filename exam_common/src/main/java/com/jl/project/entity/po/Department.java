package com.jl.project.entity.po;

import java.io.Serializable;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;
import com.jl.project.enums.DateTimePatternEnum;
import com.jl.project.utils.DateUtils;

/**
 * @Description:部门表
 * @author:jingLong
 * @date:2023/11/23
 */
@Schema(description = "部门表")
public class Department implements Serializable{
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
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getParentCode() {
		return this.parentCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptCode() {
		return this.deptCode;
	}

	public void setDeptLevel(Integer deptLevel) {
		this.deptLevel = deptLevel;
	}

	public Integer getDeptLevel() {
		return this.deptLevel;
	}

	public void setDeptType(String deptType) {
		this.deptType = deptType;
	}

	public String getDeptType() {
		return this.deptType;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSort() {
		return this.sort;
	}

	@Override
	public String toString() {
		return "ID:" + (id == null ? "空" : id) + ",上层部门code:" + (parentCode == null ? "空" : parentCode) + ",部门编码:" + (deptCode == null ? "空" : deptCode) + ",部门层级:" + (deptLevel == null ? "空" : deptLevel) + ",部门类型（预留）:" + (deptType == null ? "空" : deptType) + ",部门名称:" + (deptName == null ? "空" : deptName) + ",创建时间:" + (createTime == null ? "空" : DateUtils.format(createTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_ss.getPattern())) + ",创建者:" + (createBy == null ? "空" : createBy) + ",更新时间:" + (updateTime == null ? "空" : DateUtils.format(updateTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_ss.getPattern())) + ",更新者:" + (updateBy == null ? "空" : updateBy) + ",备注:" + (remark == null ? "空" : remark) + ",排序:" + (sort == null ? "空" : sort) ;
	}

}