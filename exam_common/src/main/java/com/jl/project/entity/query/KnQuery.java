package com.jl.project.entity.query;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;
/**
 * @Description:知识点表查询对象
 * @author:jingLong
 * @date:2023/11/22
 */
@Schema(description = "知识点表查询对象")
public class KnQuery extends BaseQuery{
	/**
	 * ID
	 */
	@Schema(description = "ID")
	private String id;

	@Schema(hidden = true)
	private String idFuzzy;

	/**
	 * 知识点内容
	 */
	@Schema(description = "知识点内容")
	private String content;

	@Schema(hidden = true)
	private String contentFuzzy;

	/**
	 * 关联的学科的ID
	 */
	@Schema(description = "关联的学科的ID")
	private String subjectId;

	@Schema(hidden = true)
	private String subjectIdFuzzy;

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

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectId() {
		return this.subjectId;
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

	public void setContentFuzzy(String contentFuzzy) {
		this.contentFuzzy = contentFuzzy;
	}

	public String getContentFuzzy() {
		return this.contentFuzzy;
	}

	public void setSubjectIdFuzzy(String subjectIdFuzzy) {
		this.subjectIdFuzzy = subjectIdFuzzy;
	}

	public String getSubjectIdFuzzy() {
		return this.subjectIdFuzzy;
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