package com.jl.project.entity.query;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;
/**
 * @Description:考试记录表查询对象
 * @author:jingLong
 * @date:2023/12/29
 */
@Schema(description = "考试记录表查询对象")
public class ExamRecordQuery extends BaseQuery{
	/**
	 * ID
	 */
	@Schema(description = "ID")
	private String id;

	@Schema(hidden = true)
	private String idFuzzy;

	/**
	 * 考试ID
	 */
	@Schema(description = "考试ID")
	private String examId;

	@Schema(hidden = true)
	private String examIdFuzzy;

	/**
	 * 用户ID
	 */
	@Schema(description = "用户ID")
	private String userId;

	@Schema(hidden = true)
	private String userIdFuzzy;

	/**
	 * 是否通过0:否1:是
	 */
	@Schema(description = "是否通过0:否1:是")
	private Integer passed;

	/**
	 * 得分
	 */
	@Schema(description = "得分")
	private Integer totalScore;

	/**
	 * 阅卷人
	 */
	@Schema(description = "阅卷人")
	private String reviewUser;

	@Schema(hidden = true)
	private String reviewUserFuzzy;

	/**
	 * 阅卷评语
	 */
	@Schema(description = "阅卷评语")
	private String reviewMsg;

	@Schema(hidden = true)
	private String reviewMsgFuzzy;

	/**
	 * 异常状态
	 */
	@Schema(description = "异常状态")
	private Integer exState;

	/**
	 * 异常信息
	 */
	@Schema(description = "异常信息")
	private String exMsg;

	@Schema(hidden = true)
	private String exMsgFuzzy;

	/**
	 * 处理状态0:未处理1:已处理
	 */
	@Schema(description = "处理状态0:未处理1:已处理")
	private Integer handState;

	/**
	 * 阅卷时间
	 */
	@Schema(description = "阅卷时间")
	private Date reviewTime;

	@Schema(hidden = true)
	private String reviewTimeStart;

	@Schema(hidden = true)
	private String reviewTimeEnd;

	/**
	 * 开始答卷时间
	 */
	@Schema(description = "开始答卷时间")
	private Date startTime;

	@Schema(hidden = true)
	private String startTimeStart;

	@Schema(hidden = true)
	private String startTimeEnd;

	/**
	 * 结束答卷时间
	 */
	@Schema(description = "结束答卷时间")
	private Date endTime;

	@Schema(hidden = true)
	private String endTimeStart;

	@Schema(hidden = true)
	private String endTimeEnd;

	/**
	 * 作答状态0:未作答1:未完成2:已交卷
	 */
	@Schema(description = "作答状态0:未作答1:未完成2:已交卷")
	private Integer state;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setExamId(String examId) {
		this.examId = examId;
	}

	public String getExamId() {
		return this.examId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setPassed(Integer passed) {
		this.passed = passed;
	}

	public Integer getPassed() {
		return this.passed;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

	public Integer getTotalScore() {
		return this.totalScore;
	}

	public void setReviewUser(String reviewUser) {
		this.reviewUser = reviewUser;
	}

	public String getReviewUser() {
		return this.reviewUser;
	}

	public void setReviewMsg(String reviewMsg) {
		this.reviewMsg = reviewMsg;
	}

	public String getReviewMsg() {
		return this.reviewMsg;
	}

	public void setExState(Integer exState) {
		this.exState = exState;
	}

	public Integer getExState() {
		return this.exState;
	}

	public void setExMsg(String exMsg) {
		this.exMsg = exMsg;
	}

	public String getExMsg() {
		return this.exMsg;
	}

	public void setHandState(Integer handState) {
		this.handState = handState;
	}

	public Integer getHandState() {
		return this.handState;
	}

	public void setReviewTime(Date reviewTime) {
		this.reviewTime = reviewTime;
	}

	public Date getReviewTime() {
		return this.reviewTime;
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

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getState() {
		return this.state;
	}

	public void setIdFuzzy(String idFuzzy) {
		this.idFuzzy = idFuzzy;
	}

	public String getIdFuzzy() {
		return this.idFuzzy;
	}

	public void setExamIdFuzzy(String examIdFuzzy) {
		this.examIdFuzzy = examIdFuzzy;
	}

	public String getExamIdFuzzy() {
		return this.examIdFuzzy;
	}

	public void setUserIdFuzzy(String userIdFuzzy) {
		this.userIdFuzzy = userIdFuzzy;
	}

	public String getUserIdFuzzy() {
		return this.userIdFuzzy;
	}

	public void setReviewUserFuzzy(String reviewUserFuzzy) {
		this.reviewUserFuzzy = reviewUserFuzzy;
	}

	public String getReviewUserFuzzy() {
		return this.reviewUserFuzzy;
	}

	public void setReviewMsgFuzzy(String reviewMsgFuzzy) {
		this.reviewMsgFuzzy = reviewMsgFuzzy;
	}

	public String getReviewMsgFuzzy() {
		return this.reviewMsgFuzzy;
	}

	public void setExMsgFuzzy(String exMsgFuzzy) {
		this.exMsgFuzzy = exMsgFuzzy;
	}

	public String getExMsgFuzzy() {
		return this.exMsgFuzzy;
	}

	public void setReviewTimeStart(String reviewTimeStart) {
		this.reviewTimeStart = reviewTimeStart;
	}

	public String getReviewTimeStart() {
		return this.reviewTimeStart;
	}

	public void setReviewTimeEnd(String reviewTimeEnd) {
		this.reviewTimeEnd = reviewTimeEnd;
	}

	public String getReviewTimeEnd() {
		return this.reviewTimeEnd;
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

}