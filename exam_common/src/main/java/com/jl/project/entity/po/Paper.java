package com.jl.project.entity.po;

import java.io.Serializable;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;;
import org.springframework.format.annotation.DateTimeFormat;
import com.jl.project.enums.DateTimePatternEnum;
import com.jl.project.utils.DateUtils;

/**
 * @Description:试卷表
 * @author:jingLong
 * @date:2023/11/22
 */
public class Paper implements Serializable{
	/**
	 * 试卷ID
	 */
	private String id;

	/**
	 * 关联学科ID
	 */
	private String subjectId;

	/**
	 * 试卷标题
	 */
	private String title;

	/**
	 * 所属部门（专业）编码
	 */
	private String deptCode;

	/**
	 * 组卷方式0:题库抽取1:指定选题 其余预留
	 */
	private Integer joinType;

	/**
	 * 题目总数
	 */
	private Integer quCount;

	/**
	 * 试卷总分
	 */
	private Integer totalCount;

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

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectId() {
		return this.subjectId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptCode() {
		return this.deptCode;
	}

	public void setJoinType(Integer joinType) {
		this.joinType = joinType;
	}

	public Integer getJoinType() {
		return this.joinType;
	}

	public void setQuCount(Integer quCount) {
		this.quCount = quCount;
	}

	public Integer getQuCount() {
		return this.quCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalCount() {
		return this.totalCount;
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
		return "试卷ID:" + (id == null ? "空" : id) + ",关联学科ID:" + (subjectId == null ? "空" : subjectId) + ",试卷标题:" + (title == null ? "空" : title) + ",所属部门（专业）编码:" + (deptCode == null ? "空" : deptCode) + ",组卷方式0:题库抽取1:指定选题 其余预留:" + (joinType == null ? "空" : joinType) + ",题目总数:" + (quCount == null ? "空" : quCount) + ",试卷总分:" + (totalCount == null ? "空" : totalCount) + ",创建时间:" + (createTime == null ? "空" : DateUtils.format(createTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_ss.getPattern())) + ",创建者:" + (createBy == null ? "空" : createBy) + ",更新时间:" + (updateTime == null ? "空" : DateUtils.format(updateTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_ss.getPattern())) + ",更新者:" + (updateBy == null ? "空" : updateBy) ;
	}

}