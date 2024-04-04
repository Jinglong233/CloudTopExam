package com.jl.project.entity.query;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;
/**
 * @Description:训练表查询对象
 * @author:jingLong
 * @date:2024/04/03
 */
@Schema(description = "训练表查询对象")
public class TrainQuery extends BaseQuery{
	/**
	 * ID
	 */
	@Schema(description = "ID")
	private String id;

	@Schema(hidden = true)
	private String idFuzzy;

	/**
	 * 题库ID
	 */
	@Schema(description = "题库ID")
	private String repoId;

	@Schema(hidden = true)
	private String repoIdFuzzy;

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

	@Schema(hidden = true)
	private String userIdFuzzy;

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

	@Schema(hidden = true)
	private String percentFuzzy;

	/**
	 * 状态 0:未完成1:完成
	 */
	@Schema(description = "状态 0:未完成1:完成")
	private Integer state;

	/**
	 * 最近训练时间
	 */
	@Schema(description = "最近训练时间")
	private Date trainTime;

	@Schema(hidden = true)
	private String trainTimeStart;

	@Schema(hidden = true)
	private String trainTimeEnd;

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

	public void setIdFuzzy(String idFuzzy) {
		this.idFuzzy = idFuzzy;
	}

	public String getIdFuzzy() {
		return this.idFuzzy;
	}

	public void setRepoIdFuzzy(String repoIdFuzzy) {
		this.repoIdFuzzy = repoIdFuzzy;
	}

	public String getRepoIdFuzzy() {
		return this.repoIdFuzzy;
	}

	public void setUserIdFuzzy(String userIdFuzzy) {
		this.userIdFuzzy = userIdFuzzy;
	}

	public String getUserIdFuzzy() {
		return this.userIdFuzzy;
	}

	public void setPercentFuzzy(String percentFuzzy) {
		this.percentFuzzy = percentFuzzy;
	}

	public String getPercentFuzzy() {
		return this.percentFuzzy;
	}

	public void setTrainTimeStart(String trainTimeStart) {
		this.trainTimeStart = trainTimeStart;
	}

	public String getTrainTimeStart() {
		return this.trainTimeStart;
	}

	public void setTrainTimeEnd(String trainTimeEnd) {
		this.trainTimeEnd = trainTimeEnd;
	}

	public String getTrainTimeEnd() {
		return this.trainTimeEnd;
	}

}