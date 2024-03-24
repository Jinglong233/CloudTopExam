package com.jl.project.entity.query;

/**
 * @Description:考试答案表查询对象
 * @author:jingLong
 * @date:2023/11/22
 */
public class ExamAnswerQuery extends BaseQuery{
	/**
	 * ID
	 */
	private String id;

	private String idFuzzy;

	/**
	 * 题目ID
	 */
	private String quId;

	private String quIdFuzzy;

	/**
	 * 考试ID
	 */
	private String examId;

	private String examIdFuzzy;

	/**
	 * 是否已答0:未答1:已答
	 */
	private Integer answered;

	/**
	 * 答案ID
	 */
	private String answerId;

	private String answerIdFuzzy;

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

	public void setIdFuzzy(String idFuzzy) {
		this.idFuzzy = idFuzzy;
	}

	public String getIdFuzzy() {
		return this.idFuzzy;
	}

	public void setQuIdFuzzy(String quIdFuzzy) {
		this.quIdFuzzy = quIdFuzzy;
	}

	public String getQuIdFuzzy() {
		return this.quIdFuzzy;
	}

	public void setExamIdFuzzy(String examIdFuzzy) {
		this.examIdFuzzy = examIdFuzzy;
	}

	public String getExamIdFuzzy() {
		return this.examIdFuzzy;
	}

	public void setAnswerIdFuzzy(String answerIdFuzzy) {
		this.answerIdFuzzy = answerIdFuzzy;
	}

	public String getAnswerIdFuzzy() {
		return this.answerIdFuzzy;
	}

}