package com.jl.project.entity.query;

import java.util.Date;
/**
 * @Description:考试表查询对象
 * @author:jingLong
 * @date:2023/12/07
 */
public class ExamQuery extends BaseQuery{
	/**
	 * ID
	 */
	private String id;

	private String idFuzzy;

	/**
	 * 试卷ID
	 */
	private String paperId;

	private String paperIdFuzzy;

	/**
	 * 考试标题
	 */
	private String title;

	private String titleFuzzy;

	/**
	 * 考试部门编码
	 */
	private String deptCode;

	private String deptCodeFuzzy;

	/**
	 * 考试部门名称
	 */
	private String deptText;

	private String deptTextFuzzy;

	/**
	 * 考试开始时间
	 */
	private Date startTime;

	private String startTimeStart;

	private String startTimeEnd;

	/**
	 * 考试结束时间
	 */
	private Date endTime;

	private String endTimeStart;

	private String endTimeEnd;

	/**
	 * 考试状态 0:未开始1:已开始2:已结束
	 */
	private Integer statue;

	/**
	 * 开放权限 0:完全公开 1:指定学生
	 */
	private Integer openType;

	/**
	 * 考试时长
	 */
	private Integer duration;

	/**
	 * 感谢语
	 */
	private String thanks;

	private String thanksFuzzy;

	/**
	 * 允许迟到时间
	 */
	private Integer lateMax;

	/**
	 * 最少答题时间
	 */
	private Integer handMin;

	/**
	 * 结果显示类型（只显示分数/显示分数+答题详情/展示答题详情）
	 */
	private Integer resultType;

	/**
	 * 及格分数
	 */
	private Integer qualifyScore;

	/**
	 * 是否需要阅卷0:不需要1:需要
	 */
	private Integer reviewQuire;

	/**
	 * 创建时间
	 */
	private Date createTime;

	private String createTimeStart;

	private String createTimeEnd;

	/**
	 * 创建者
	 */
	private String createBy;

	private String createByFuzzy;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	private String updateTimeStart;

	private String updateTimeEnd;

	/**
	 * 更新者
	 */
	private String updateBy;

	private String updateByFuzzy;

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

	public void setIdFuzzy(String idFuzzy) {
		this.idFuzzy = idFuzzy;
	}

	public String getIdFuzzy() {
		return this.idFuzzy;
	}

	public void setPaperIdFuzzy(String paperIdFuzzy) {
		this.paperIdFuzzy = paperIdFuzzy;
	}

	public String getPaperIdFuzzy() {
		return this.paperIdFuzzy;
	}

	public void setTitleFuzzy(String titleFuzzy) {
		this.titleFuzzy = titleFuzzy;
	}

	public String getTitleFuzzy() {
		return this.titleFuzzy;
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

	public void setStartTimeStart(String startTimeStart) {
		this.startTimeStart = startTimeStart;
	}

	public String getStartTimeStart() {
		return this.startTimeStart;
	}

	public void setStartTimeEnd(String startTimeEnd) {
		this.startTimeEnd = startTimeEnd;
	}

	public String getStartTimeEnd() {
		return this.startTimeEnd;
	}

	public void setEndTimeStart(String endTimeStart) {
		this.endTimeStart = endTimeStart;
	}

	public String getEndTimeStart() {
		return this.endTimeStart;
	}

	public void setEndTimeEnd(String endTimeEnd) {
		this.endTimeEnd = endTimeEnd;
	}

	public String getEndTimeEnd() {
		return this.endTimeEnd;
	}

	public void setThanksFuzzy(String thanksFuzzy) {
		this.thanksFuzzy = thanksFuzzy;
	}

	public String getThanksFuzzy() {
		return this.thanksFuzzy;
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