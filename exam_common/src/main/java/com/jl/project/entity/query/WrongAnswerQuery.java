package com.jl.project.entity.query;

/**
 * @Description:错题答案表查询对象
 * @author:jingLong
 * @date:2024/05/29
 */
public class WrongAnswerQuery extends BaseQuery{
	/**
	 * ID
	 */
	private Integer id;

	/**
	 * 错题id（非题目id）
	 */
	private String bookId;

	private String bookIdFuzzy;

	/**
	 * 选项id
	 */
	private String answerId;

	private String answerIdFuzzy;

	/**
	 * 选项次数
	 */
	private Integer wrongCount;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookId() {
		return this.bookId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	public String getAnswerId() {
		return this.answerId;
	}

	public void setWrongCount(Integer wrongCount) {
		this.wrongCount = wrongCount;
	}

	public Integer getWrongCount() {
		return this.wrongCount;
	}

	public void setBookIdFuzzy(String bookIdFuzzy) {
		this.bookIdFuzzy = bookIdFuzzy;
	}

	public String getBookIdFuzzy() {
		return this.bookIdFuzzy;
	}

	public void setAnswerIdFuzzy(String answerIdFuzzy) {
		this.answerIdFuzzy = answerIdFuzzy;
	}

	public String getAnswerIdFuzzy() {
		return this.answerIdFuzzy;
	}

}