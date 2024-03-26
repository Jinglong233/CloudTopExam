package com.jl.project.entity.po;

import java.io.Serializable;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;
import com.jl.project.enums.DateTimePatternEnum;
import com.jl.project.utils.DateUtils;

/**
 * @Description:考试表
 * @author:jingLong
 * @date:2023/12/07
 */
@Schema(description = "考试表")
public class Exam implements Serializable{
	/**
	 * ID
	 */
	@Schema(description = "ID")
	private String id;

	/**
	 * 试卷ID
	 */
	@Schema(description = "试卷ID")
	private String paperId;

	/**
	 * 考试标题
	 */
	@Schema(description = "考试标题")
	private String title;

	/**
	 * 考试部门编码
	 */
	@Schema(description = "考试部门编码")
	private String deptCode;

	/**
	 * 考试部门名称
	 */
	@Schema(description = "考试部门名称")
	private String deptText;

	/**
	 * 考试开始时间
	 */
	@Schema(description = "考试开始时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startTime;

	/**
	 * 考试结束时间
	 */
	@Schema(description = "考试结束时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endTime;

	/**
	 * 考试状态 0:未开始1:已开始2:已结束
	 */
	@Schema(description = "考试状态 0:未开始1:已开始2:已结束")
	private Integer statue;

	/**
	 * 开放权限 0:完全公开 1:指定学生
	 */
	@Schema(description = "开放权限 0:完全公开 1:指定学生")
	private Integer openType;

	/**
	 * 考试时长
	 */
	@Schema(description = "考试时长")
	private Integer duration;

	/**
	 * 感谢语
	 */
	@Schema(description = "感谢语")
	private String thanks;

	/**
	 * 允许迟到时间
	 */
	@Schema(description = "允许迟到时间")
	private Integer lateMax;

	/**
	 * 最少答题时间
	 */
	@Schema(description = "最少答题时间")
	private Integer handMin;

	/**
	 * 结果显示类型（只显示分数/显示分数+答题详情/展示答题详情）
	 */
	@Schema(description = "结果显示类型（只显示分数/显示分数+答题详情/展示答题详情）")
	private Integer resultType;

	/**
	 * 及格分数
	 */
	@Schema(description = "及格分数")
	private Integer qualifyScore;

	/**
	 * 是否需要阅卷0:不需要1:需要
	 */
	@Schema(description = "是否需要阅卷0:不需要1:需要")
	private Integer reviewQuire;

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

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public String getPaperId() {
		return this.paperId;
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

	public void setDeptText(String deptText) {
		this.deptText = deptText;
	}

	public String getDeptText() {
		return this.deptText;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setStatue(Integer statue) {
		this.statue = statue;
	}

	public Integer getStatue() {
		return this.statue;
	}

	public void setOpenType(Integer openType) {
		this.openType = openType;
	}

	public Integer getOpenType() {
		return this.openType;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getDuration() {
		return this.duration;
	}

	public void setThanks(String thanks) {
		this.thanks = thanks;
	}

	public String getThanks() {
		return this.thanks;
	}

	public void setLateMax(Integer lateMax) {
		this.lateMax = lateMax;
	}

	public Integer getLateMax() {
		return this.lateMax;
	}

	public void setHandMin(Integer handMin) {
		this.handMin = handMin;
	}

	public Integer getHandMin() {
		return this.handMin;
	}

	public void setResultType(Integer resultType) {
		this.resultType = resultType;
	}

	public Integer getResultType() {
		return this.resultType;
	}

	public void setQualifyScore(Integer qualifyScore) {
		this.qualifyScore = qualifyScore;
	}

	public Integer getQualifyScore() {
		return this.qualifyScore;
	}

	public void setReviewQuire(Integer reviewQuire) {
		this.reviewQuire = reviewQuire;
	}

	public Integer getReviewQuire() {
		return this.reviewQuire;
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
		return "ID:" + (id == null ? "空" : id) + ",试卷ID:" + (paperId == null ? "空" : paperId) + ",考试标题:" + (title == null ? "空" : title) + ",考试部门编码:" + (deptCode == null ? "空" : deptCode) + ",考试部门名称:" + (deptText == null ? "空" : deptText) + ",考试开始时间:" + (startTime == null ? "空" : DateUtils.format(startTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_ss.getPattern())) + ",考试结束时间:" + (endTime == null ? "空" : DateUtils.format(endTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_ss.getPattern())) + ",考试状态 0:未开始1:已开始2:已结束:" + (statue == null ? "空" : statue) + ",开放权限 0:完全公开 1:指定学生:" + (openType == null ? "空" : openType) + ",考试时长:" + (duration == null ? "空" : duration) + ",感谢语:" + (thanks == null ? "空" : thanks) + ",允许迟到时间:" + (lateMax == null ? "空" : lateMax) + ",最少答题时间:" + (handMin == null ? "空" : handMin) + ",结果显示类型（只显示分数/显示分数+答题详情/展示答题详情）:" + (resultType == null ? "空" : resultType) + ",及格分数:" + (qualifyScore == null ? "空" : qualifyScore) + ",是否需要阅卷0:不需要1:需要:" + (reviewQuire == null ? "空" : reviewQuire) + ",创建时间:" + (createTime == null ? "空" : DateUtils.format(createTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_ss.getPattern())) + ",创建者:" + (createBy == null ? "空" : createBy) + ",更新时间:" + (updateTime == null ? "空" : DateUtils.format(updateTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_ss.getPattern())) + ",更新者:" + (updateBy == null ? "空" : updateBy) ;
	}

}