package com.jl.project.entity.po;

import java.io.Serializable;


/**
 * @Description:训练详情记录表
 * @author:jingLong
 * @date:2023/11/22
 */
public class TrainRecord implements Serializable{
	/**
	 * ID
	 */
	private String id;

	/**
	 * 题目ID
	 */
	private String quId;

	/**
	 * 训练ID
	 */
	private String trainId;

	/**
	 * 回答是否正确
	 */
	private Integer isRight;

	/**
	 * 答案ID
	 */
	private String answerId;

	/**
	 * 是否回答0:未答1:已答
	 */
	private Integer answered;

	/**
	 * 主观题的答案
	 */
	private String answer;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setQuId(String quId) {
		this.quId = quId;
	}

	public String getQuId() {
		return this.quId;
	}

	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}

	public String getTrainId() {
		return this.trainId;
	}

	public void setIsRight(Integer isRight) {
		this.isRight = isRight;
	}

	public Integer getIsRight() {
		return this.isRight;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	public String getAnswerId() {
		return this.answerId;
	}

	public void setAnswered(Integer answered) {
		this.answered = answered;
	}

	public Integer getAnswered() {
		return this.answered;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnswer() {
		return this.answer;
	}

	@Override
	public String toString() {
		return "ID:" + (id == null ? "空" : id) + ",题目ID:" + (quId == null ? "空" : quId) + ",训练ID:" + (trainId == null ? "空" : trainId) + ",回答是否正确:" + (isRight == null ? "空" : isRight) + ",答案ID:" + (answerId == null ? "空" : answerId) + ",是否回答0:未答1:已答:" + (answered == null ? "空" : answered) + ",主观题的答案:" + (answer == null ? "空" : answer) ;
	}

}