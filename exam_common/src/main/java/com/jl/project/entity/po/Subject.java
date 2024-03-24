package com.jl.project.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jl.project.enums.DateTimePatternEnum;
import com.jl.project.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

;

/**
 * @Description:学科表
 * @author:jingLong
 * @date:2023/12/09
 */
public class Subject implements Serializable{
	/**
	 * ID
	 */
	private String id;

	/**
	 * 学科名称
	 */
	private String title;

	/**
	 * 描述/备注
	 */
	private String description;

	/**
	 * 上层学科ID
	 */
	private String parentId;

	/**
	 * 所属部门（专业）
	 */
	private String deptCode;

	/**
	 * 部门名称
	 */
	private String deptText;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
	 * 创建者
	 */
	private String createBy;

	/**
	 * 更新时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

	/**
	 * 更新者
	 */
	private String updateBy;

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



	@Override
	public String toString() {
		return "ID:" + (id == null ? "空" : id) + ",学科名称:" + (title == null ? "空" : title) + ",描述/备注:" + (description == null ? "空" : description) + ",上层学科ID:" + (parentId == null ? "空" : parentId) + ",所属部门（专业）:" + (deptCode == null ? "空" : deptCode) + ",部门名称:" + (deptText == null ? "空" : deptText) + ",创建时间:" + (createTime == null ? "空" : DateUtils.format(createTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_ss.getPattern())) + ",创建者:" + (createBy == null ? "空" : createBy) + ",更新时间:" + (updateTime == null ? "空" : DateUtils.format(updateTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_ss.getPattern())) + ",更新者:" + (updateBy == null ? "空" : updateBy) ;
	}

}