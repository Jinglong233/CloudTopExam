package com.jl.project.entity.po;

import java.io.Serializable;


/**
 * @Description:考试答案表
 * @author:jingLong
 * @date:2023/11/22
 */
public class ExamAnswer implements Serializable{
	/**
	 * ID
	 */
	private String id;

	/**
	 * 题目ID
	 */
	private String quId;

	/**
	 * 考试ID
	 */
	private String examId;

	/**
	 * 是否已答0:未答1:已答
	 */
	private Integer answered;

	/**
	 * 答案ID
	 */
	private String answerId;

	/**
	 * 回答是否正确0:错1:对
	 */
	private Integer isRight;

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

	public void setExamId(String examId) {
		this.examId = examId;
	}

	public String getExamId() {
		return this.examId;
	}

	public void setAnswered(Integer answered) {
		this.answered = answered;
	}

	public Integer getAnswered() {
		return this.answered;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	public String getAnswerId() {
		return this.answerId;
	}

	public void setIsRight(Integer isRight) {
		this.isRight = isRight;
	}

	public Integer getIsRight() {
		return this.isRight;
	}

	@Override
	public String toString() {
		return "ID:" + (id == null ? "空" : id) + ",题目ID:" + (quId == null ? "空" : quId) + ",考试ID:" + (examId == null ? "空" : examId) + ",是否已答0:未答1:已答:" + (answered == null ? "空" : answered) + ",答案ID:" + (answerId == null ? "空" : answerId) + ",回答是否正确0:错1:对:" + (isRight == null ? "空" : isRight) ;
	}

}