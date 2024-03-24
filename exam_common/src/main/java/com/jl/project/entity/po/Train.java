package com.jl.project.entity.po;

import java.io.Serializable;


/**
 * @Description:训练表
 * @author:jingLong
 * @date:2023/11/22
 */
public class Train implements Serializable{
	/**
	 * ID
	 */
	private String id;

	/**
	 * 题库ID
	 */
	private String repoId;

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

	/**
	 * 训练模式
	 */
	private Integer mode;

	/**
	 * 训练进度
	 */
	private String percent;

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

	@Override
	public String toString() {
		return "ID:" + (id == null ? "空" : id) + ",题库ID:" + (repoId == null ? "空" : repoId) + ",回答数量:" + (answerCount == null ? "空" : answerCount) + ",正确数量:" + (rightCount == null ? "空" : rightCount) + ",训练者:" + (userId == null ? "空" : userId) + ",训练模式:" + (mode == null ? "空" : mode) + ",训练进度:" + (percent == null ? "空" : percent) + ",状态 0:未完成1:完成:" + (state == null ? "空" : state) ;
	}

}