package com.jl.project.entity.query;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;
/**
 * @Description:学科表查询对象
 * @author:jingLong
 * @date:2023/12/09
 */
@Schema(description = "学科表查询对象")
public class SubjectQuery extends BaseQuery{
	/**
	 * ID
	 */
	@Schema(description = "ID")
	private String id;

	@Schema(hidden = true)
	private String idFuzzy;

	/**
	 * 学科名称
	 */
	@Schema(description = "学科名称")
	private String title;

	@Schema(hidden = true)
	private String titleFuzzy;

	/**
	 * 描述/备注
	 */
	@Schema(description = "描述/备注")
	private String description;

	@Schema(hidden = true)
	private String descriptionFuzzy;

	/**
	 * 上层学科ID
	 */
	@Schema(description = "上层学科ID")
	private String parentId;

	@Schema(hidden = true)
	private String parentIdFuzzy;

	/**
	 * 所属部门（专业）
	 */
	@Schema(description = "所属部门（专业）")
	private String deptCode;

	@Schema(hidden = true)
	private String deptCodeFuzzy;

	/**
	 * 部门名称
	 */
	@Schema(description = "部门名称")
	private String deptText;

	@Schema(hidden = true)
	private String deptTextFuzzy;

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

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParentId() {
		return this.parentId;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptCode() {
		return this.deptCode;
	}

	public void setDeptText(String deptText) {
		this.deptText = deptText;
	}

	public String getDeptText() {
		return this.deptText;
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

	public void setIdFuzzy(String idFuzzy) {
		this.idFuzzy = idFuzzy;
	}

	public String getIdFuzzy() {
		return this.idFuzzy;
	}

	public void setTitleFuzzy(String titleFuzzy) {
		this.titleFuzzy = titleFuzzy;
	}

	public String getTitleFuzzy() {
		return this.titleFuzzy;
	}

	public void setDescriptionFuzzy(String descriptionFuzzy) {
		this.descriptionFuzzy = descriptionFuzzy;
	}

	public String getDescriptionFuzzy() {
		return this.descriptionFuzzy;
	}

	public void setParentIdFuzzy(String parentIdFuzzy) {
		this.parentIdFuzzy = parentIdFuzzy;
	}

	public String getParentIdFuzzy() {
		return this.parentIdFuzzy;
	}

	public void setDeptCodeFuzzy(String deptCodeFuzzy) {
		this.deptCodeFuzzy = deptCodeFuzzy;
	}

	public String getDeptCodeFuzzy() {
		return this.deptCodeFuzzy;
	}

	public void setDeptTextFuzzy(String deptTextFuzzy) {
		this.deptTextFuzzy = deptTextFuzzy;
	}

	public String getDeptTextFuzzy() {
		return this.deptTextFuzzy;
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

}