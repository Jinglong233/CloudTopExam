package com.jl.project.entity.po;

import java.io.Serializable;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;
import com.jl.project.enums.DateTimePatternEnum;
import com.jl.project.utils.DateUtils;

/**
 * @Description:考试记录表
 * @author:jingLong
 * @date:2023/12/29
 */
@Schema(description = "考试记录表")
public class ExamRecord implements Serializable{
	/**
	 * ID
	 */
	@Schema(description = "ID")
	private String id;

	/**
	 * 考试ID
	 */
	@Schema(description = "考试ID")
	private String examId;

	/**
	 * 用户ID
	 */
	@Schema(description = "用户ID")
	private String userId;

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

	/**
	 * 阅卷评语
	 */
	@Schema(description = "阅卷评语")
	private String reviewMsg;

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

	/**
	 * 处理状态0:未处理1:已处理
	 */
	@Schema(description = "处理状态0:未处理1:已处理")
	private Integer handState;

	/**
	 * 阅卷时间
	 */
	@Schema(description = "阅卷时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date reviewTime;

	/**
	 * 开始答卷时间
	 */
	@Schema(description = "开始答卷时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startTime;

	/**
	 * 结束答卷时间
	 */
	@Schema(description = "结束答卷时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endTime;

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

	@Override
	public String toString() {
		return "ID:" + (id == null ? "空" : id) + ",考试ID:" + (examId == null ? "空" : examId) + ",用户ID:" + (userId == null ? "空" : userId) + ",是否通过0:否1:是:" + (passed == null ? "空" : passed) + ",得分:" + (totalScore == null ? "空" : totalScore) + ",阅卷人:" + (reviewUser == null ? "空" : reviewUser) + ",阅卷评语:" + (reviewMsg == null ? "空" : reviewMsg) + ",异常状态:" + (exState == null ? "空" : exState) + ",异常信息:" + (exMsg == null ? "空" : exMsg) + ",处理状态0:未处理1:已处理:" + (handState == null ? "空" : handState) + ",阅卷时间:" + (reviewTime == null ? "空" : DateUtils.format(reviewTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_ss.getPattern())) + ",开始答卷时间:" + (startTime == null ? "空" : DateUtils.format(startTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_ss.getPattern())) + ",结束答卷时间:" + (endTime == null ? "空" : DateUtils.format(endTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_ss.getPattern())) + ",作答状态0:未作答1:未完成2:已交卷:" + (state == null ? "空" : state) ;
	}

}