package com.jl.project.entity.query;

/**
 * @Description:训练详情记录表查询对象
 * @author:jingLong
 * @date:2023/11/22
 */
public class TrainRecordQuery extends BaseQuery{
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
	 * 训练ID
	 */
	private String trainId;

	private String trainIdFuzzy;

	/**
	 * 回答是否正确
	 */
	private Integer isRight;

	/**
	 * 答案ID
	 */
	private String answerId;

	private String answerIdFuzzy;

	/**
	 * 是否回答0:未答1:已答
	 */
	private Integer answered;

	/**
	 * 主观题的答案
	 */
	private String answer;

	private String answerFuzzy;

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

	public void setTrainIdFuzzy(String trainIdFuzzy) {
		this.trainIdFuzzy = trainIdFuzzy;
	}

	public String getTrainIdFuzzy() {
		return this.trainIdFuzzy;
	}

	public void setAnswerIdFuzzy(String answerIdFuzzy) {
		this.answerIdFuzzy = answerIdFuzzy;
	}

	public String getAnswerIdFuzzy() {
		return this.answerIdFuzzy;
	}

	public void setAnswerFuzzy(String answerFuzzy) {
		this.answerFuzzy = answerFuzzy;
	}

	public String getAnswerFuzzy() {
		return this.answerFuzzy;
	}

}