package com.jl.project.entity.query;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;
/**
 * @Description:部门表查询对象
 * @author:jingLong
 * @date:2023/11/23
 */
@Schema(description = "部门表查询对象")
public class DepartmentQuery extends BaseQuery{
	/**
	 * ID
	 */
	@Schema(description = "ID")
	private String id;

	@Schema(hidden = true)
	private String idFuzzy;

	/**
	 * 上层部门code
	 */
	@Schema(description = "上层部门code")
	private String parentCode;

	@Schema(hidden = true)
	private String parentCodeFuzzy;

	/**
	 * 部门编码
	 */
	@Schema(description = "部门编码")
	private String deptCode;

	@Schema(hidden = true)
	private String deptCodeFuzzy;

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

	@Schema(hidden = true)
	private String deptTypeFuzzy;

	/**
	 * 部门名称
	 */
	@Schema(description = "部门名称")
	private String deptName;

	@Schema(hidden = true)
	private String deptNameFuzzy;

	/**
	 * 创建时间
	 */
	@Schema(description = "创建时间")
	private Date createTime;

	@Schema(hidden = true)
	private String createTimeStart;

	@Schema(hidden = true)
	private String createTimeEnd;

	/**
	 * 创建者
	 */
	@Schema(description = "创建者")
	private String createBy;

	@Schema(hidden = true)
	private String createByFuzzy;

	/**
	 * 更新时间
	 */
	@Schema(description = "更新时间")
	private Date updateTime;

	@Schema(hidden = true)
	private String updateTimeStart;

	@Schema(hidden = true)
	private String updateTimeEnd;

	/**
	 * 更新者
	 */
	@Schema(description = "更新者")
	private String updateBy;

	@Schema(hidden = true)
	private String updateByFuzzy;

	/**
	 * 备注
	 */
	@Schema(description = "备注")
	private String remark;

	@Schema(hidden = true)
	private String remarkFuzzy;

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

	public void setIdFuzzy(String idFuzzy) {
		this.idFuzzy = idFuzzy;
	}

	public String getIdFuzzy() {
		return this.idFuzzy;
	}

	public void setParentCodeFuzzy(String parentCodeFuzzy) {
		this.parentCodeFuzzy = parentCodeFuzzy;
	}

	public String getParentCodeFuzzy() {
		return this.parentCodeFuzzy;
	}

	public void setDeptCodeFuzzy(String deptCodeFuzzy) {
		this.deptCodeFuzzy = deptCodeFuzzy;
	}

	public String getDeptCodeFuzzy() {
		return this.deptCodeFuzzy;
	}

	public void setDeptTypeFuzzy(String deptTypeFuzzy) {
		this.deptTypeFuzzy = deptTypeFuzzy;
	}

	public String getDeptTypeFuzzy() {
		return this.deptTypeFuzzy;
	}

	public void setDeptNameFuzzy(String deptNameFuzzy) {
		this.deptNameFuzzy = deptNameFuzzy;
	}

	public String getDeptNameFuzzy() {
		return this.deptNameFuzzy;
	}

	public void setCreateTimeStart(String createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public String getCreateTimeStart() {
		return this.createTimeStart;
	}

	public void setCreateTimeEnd(String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public String getCreateTimeEnd() {
		return this.createTimeEnd;
	}

	public void setCreateByFuzzy(String createByFuzzy) {
		this.createByFuzzy = createByFuzzy;
	}

	public String getCreateByFuzzy() {
		return this.createByFuzzy;
	}

	public void setUpdateTimeStart(String updateTimeStart) {
		this.updateTimeStart = updateTimeStart;
	}

	public String getUpdateTimeStart() {
		return this.updateTimeStart;
	}

	public void setUpdateTimeEnd(String updateTimeEnd) {
		this.updateTimeEnd = updateTimeEnd;
	}

	public String getUpdateTimeEnd() {
		return this.updateTimeEnd;
	}

	public void setUpdateByFuzzy(String updateByFuzzy) {
		this.updateByFuzzy = updateByFuzzy;
	}

	public String getUpdateByFuzzy() {
		return this.updateByFuzzy;
	}

	public void setRemarkFuzzy(String remarkFuzzy) {
		this.remarkFuzzy = remarkFuzzy;
	}

	public String getRemarkFuzzy() {
		return this.remarkFuzzy;
	}

}