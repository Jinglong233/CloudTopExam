package com.jl.project.entity.query;

/**
 * @Description:训练表查询对象
 * @author:jingLong
 * @date:2023/11/22
 */
public class TrainQuery extends BaseQuery{
	/**
	 * ID
	 */
	private String id;

	private String idFuzzy;

	/**
	 * 题库ID
	 */
	private String repoId;

	private String repoIdFuzzy;

	/**
	 * 回答数量
	 */
	private Integer answerCount;

	/**
	 * 正确数量
	 */
	private Integer rightCount;

	/**
	 * 训练者
	 */
	private String userId;

	private String userIdFuzzy;

	/**
	 * 训练模式
	 */
	private Integer mode;

	/**
	 * 训练进度
	 */
	private String percent;

	private String percentFuzzy;

	/**
	 * 状态 0:未完成1:完成
	 */
	private Integer state;

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

}