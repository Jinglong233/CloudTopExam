package com.jl.project.entity.query;

/**
 * @Description:用户答案表查询对象
 * @author:jingLong
 * @date:2024/03/16
 */
public class UserAnswerQuery extends BaseQuery{
	/**
	 * id
	 */
	private String id;

	private String idFuzzy;

	/**
	 * 是否已答0:未答1:已答
	 */
	private Integer answered;

	/**
	 * 关联的题目Id
	 */
	private String quId;

	private String quIdFuzzy;

	/**
	 * 答案Id
	 */
	private String answerId;

	private String answerIdFuzzy;

	/**
	 * 所属记录Id
	 */
	private String examRecordId;

	private String examRecordIdFuzzy;

	/**
	 * 是否答对0:错1:对
	 */
	private Integer isRight;

	/**
	 * 用户id
	 */
	private String userId;

	private String userIdFuzzy;

	/**
	 * 题目排序（只在乱序的时候生效）
	 */
	private String sort;

	private String sortFuzzy;

	/**
	 * 得分
	 */
	private Integer score;

	/**
	 * 填空，主观题答案
	 */
	private String answer;

	private String answerFuzzy;

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

	public void setAnswerIdFuzzy(String answerIdFuzzy) {
		this.answerIdFuzzy = answerIdFuzzy;
	}

	public String getAnswerIdFuzzy() {
		return this.answerIdFuzzy;
	}

	public void setExamRecordIdFuzzy(String examRecordIdFuzzy) {
		this.examRecordIdFuzzy = examRecordIdFuzzy;
	}

	public String getExamRecordIdFuzzy() {
		return this.examRecordIdFuzzy;
	}

	public void setUserIdFuzzy(String userIdFuzzy) {
		this.userIdFuzzy = userIdFuzzy;
	}

	public String getUserIdFuzzy() {
		return this.userIdFuzzy;
	}

	public void setSortFuzzy(String sortFuzzy) {
		this.sortFuzzy = sortFuzzy;
	}

	public String getSortFuzzy() {
		return this.sortFuzzy;
	}

	public void setAnswerFuzzy(String answerFuzzy) {
		this.answerFuzzy = answerFuzzy;
	}

	public String getAnswerFuzzy() {
		return this.answerFuzzy;
	}

}