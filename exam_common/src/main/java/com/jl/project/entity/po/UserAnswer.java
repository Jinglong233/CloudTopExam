package com.jl.project.entity.po;

import java.io.Serializable;


/**
 * @Description:用户答案表
 * @author:jingLong
 * @date:2024/03/16
 */
public class UserAnswer implements Serializable{
	/**
	 * id
	 */
	private String id;

	/**
	 * 是否已答0:未答1:已答
	 */
	private Integer answered;

	/**
	 * 关联的题目Id
	 */
	private String quId;

	/**
	 * 答案Id
	 */
	private String answerId;

	/**
	 * 所属记录Id
	 */
	private String examRecordId;

	/**
	 * 是否答对0:错1:对
	 */
	private Integer isRight;

	/**
	 * 用户id
	 */
	private String userId;

	/**
	 * 题目排序（只在乱序的时候生效）
	 */
	private String sort;

	/**
	 * 得分
	 */
	private Integer score;

	/**
	 * 填空，主观题答案
	 */
	private String answer;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setAnswered(Integer answered) {
		this.answered = answered;
	}

	public Integer getAnswered() {
		return this.answered;
	}

	public void setQuId(String quId) {
		this.quId = quId;
	}

	public String getQuId() {
		return this.quId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	public String getAnswerId() {
		return this.answerId;
	}

	public void setExamRecordId(String examRecordId) {
		this.examRecordId = examRecordId;
	}

	public String getExamRecordId() {
		return this.examRecordId;
	}

	public void setIsRight(Integer isRight) {
		this.isRight = isRight;
	}

	public Integer getIsRight() {
		return this.isRight;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getSort() {
		return this.sort;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnswer() {
		return this.answer;
	}

	@Override
	public String toString() {
		return "id:" + (id == null ? "空" : id) + ",是否已答0:未答1:已答:" + (answered == null ? "空" : answered) + ",关联的题目Id:" + (quId == null ? "空" : quId) + ",答案Id:" + (answerId == null ? "空" : answerId) + ",所属记录Id:" + (examRecordId == null ? "空" : examRecordId) + ",是否答对0:错1:对:" + (isRight == null ? "空" : isRight) + ",用户id:" + (userId == null ? "空" : userId) + ",题目排序（只在乱序的时候生效）:" + (sort == null ? "空" : sort) + ",得分:" + (score == null ? "空" : score) + ",填空，主观题答案:" + (answer == null ? "空" : answer) ;
	}

}