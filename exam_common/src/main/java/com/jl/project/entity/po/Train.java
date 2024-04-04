package com.jl.project.entity.po;

import java.io.Serializable;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;
import com.jl.project.enums.DateTimePatternEnum;
import com.jl.project.utils.DateUtils;

/**
 * @Description:训练表
 * @author:jingLong
 * @date:2024/04/03
 */
@Schema(description = "训练表")
public class Train implements Serializable{
	/**
	 * ID
	 */
	@Schema(description = "ID")
	private String id;

	/**
	 * 题库ID
	 */
	@Schema(description = "题库ID")
	private String repoId;

	/**
	 * 回答数量
	 */
	@Schema(description = "回答数量")
	private Integer answerCount;

	/**
	 * 正确数量
	 */
	@Schema(description = "正确数量")
	private Integer rightCount;

	/**
	 * 总题目数量
	 */
	@Schema(description = "总题目数量")
	private Integer totalCount;

	/**
	 * 训练者
	 */
	@Schema(description = "训练者")
	private String userId;

	/**
	 * 训练模式
	 */
	@Schema(description = "训练模式")
	private Integer mode;

	/**
	 * 训练进度
	 */
	@Schema(description = "训练进度")
	private String percent;

	/**
	 * 状态 0:未完成1:完成
	 */
	@Schema(description = "状态 0:未完成1:完成")
	private Integer state;

	/**
	 * 最近训练时间
	 */
	@Schema(description = "最近训练时间")
	@JsonFormat(pattern = "yyyy_MM_dd HH:mm:ss",timezone="GMT+8")
	@DateTimeFormat(pattern = "yyyy_MM_dd HH:mm:ss")
	private Date trainTime;

	/**
	 * 题型（mode为3的时候需要）
	 */
	@Schema(description = "题型（mode为3的时候需要）")
	private Integer quType;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setRepoId(String repoId) {
		this.repoId = repoId;
	}

	public String getRepoId() {
		return this.repoId;
	}

	public void setAnswerCount(Integer answerCount) {
		this.answerCount = answerCount;
	}

	public Integer getAnswerCount() {
		return this.answerCount;
	}

	public void setRightCount(Integer rightCount) {
		this.rightCount = rightCount;
	}

	public Integer getRightCount() {
		return this.rightCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalCount() {
		return this.totalCount;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setMode(Integer mode) {
		this.mode = mode;
	}

	public Integer getMode() {
		return this.mode;
	}

	public void setPercent(String percent) {
		this.percent = percent;
	}

	public String getPercent() {
		return this.percent;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getState() {
		return this.state;
	}

	public void setTrainTime(Date trainTime) {
		this.trainTime = trainTime;
	}

	public Date getTrainTime() {
		return this.trainTime;
	}

	public void setQuType(Integer quType) {
		this.quType = quType;
	}

	public Integer getQuType() {
		return this.quType;
	}

	@Override
	public String toString() {
		return "ID:" + (id == null ? "空" : id) + ",题库ID:" + (repoId == null ? "空" : repoId) + ",回答数量:" + (answerCount == null ? "空" : answerCount) + ",正确数量:" + (rightCount == null ? "空" : rightCount) + ",总题目数量:" + (totalCount == null ? "空" : totalCount) + ",训练者:" + (userId == null ? "空" : userId) + ",训练模式:" + (mode == null ? "空" : mode) + ",训练进度:" + (percent == null ? "空" : percent) + ",状态 0:未完成1:完成:" + (state == null ? "空" : state) + ",最近训练时间:" + (trainTime == null ? "空" : DateUtils.format(trainTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_ss.getPattern())) + ",题型（mode为3的时候需要）:" + (quType == null ? "空" : quType) ;
	}

}