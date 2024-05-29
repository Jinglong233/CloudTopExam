package com.jl.project.entity.query;

/**
 * @Description:错题本查询对象
 * @author:jingLong
 * @date:2024/05/29
 */
public class BookQuery extends BaseQuery{
	/**
	 * ID
	 */
	private String id;

	private String idFuzzy;

	/**
	 * 用户ID
	 */
	private String userId;

	private String userIdFuzzy;

	/**
	 * 题目ID
	 */
	private String quId;

	private String quIdFuzzy;

	/**
	 * 题目内容
	 */
	private String quContent;

	private String quContentFuzzy;

	/**
	 * 学科id
	 */
	private String subjectId;

	private String subjectIdFuzzy;

	/**
	 * 答错次数
	 */
	private Integer wrongCount;

	/**
	 * 题型
	 */
	private Integer quType;

	/**
	 * 知识点内容
	 */
	private String knContent;

	private String knContentFuzzy;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setQuId(String quId) {
		this.quId = quId;
	}

	public String getQuId() {
		return this.quId;
	}

	public void setQuContent(String quContent) {
		this.quContent = quContent;
	}

	public String getQuContent() {
		return this.quContent;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectId() {
		return this.subjectId;
	}

	public void setWrongCount(Integer wrongCount) {
		this.wrongCount = wrongCount;
	}

	public Integer getWrongCount() {
		return this.wrongCount;
	}

	public void setQuType(Integer quType) {
		this.quType = quType;
	}

	public Integer getQuType() {
		return this.quType;
	}

	public void setKnContent(String knContent) {
		this.knContent = knContent;
	}

	public String getKnContent() {
		return this.knContent;
	}

	public void setIdFuzzy(String idFuzzy) {
		this.idFuzzy = idFuzzy;
	}

	public String getIdFuzzy() {
		return this.idFuzzy;
	}

	public void setUserIdFuzzy(String userIdFuzzy) {
		this.userIdFuzzy = userIdFuzzy;
	}

	public String getUserIdFuzzy() {
		return this.userIdFuzzy;
	}

	public void setQuIdFuzzy(String quIdFuzzy) {
		this.quIdFuzzy = quIdFuzzy;
	}

	public String getQuIdFuzzy() {
		return this.quIdFuzzy;
	}

	public void setQuContentFuzzy(String quContentFuzzy) {
		this.quContentFuzzy = quContentFuzzy;
	}

	public String getQuContentFuzzy() {
		return this.quContentFuzzy;
	}

	public void setSubjectIdFuzzy(String subjectIdFuzzy) {
		this.subjectIdFuzzy = subjectIdFuzzy;
	}

	public String getSubjectIdFuzzy() {
		return this.subjectIdFuzzy;
	}

	public void setKnContentFuzzy(String knContentFuzzy) {
		this.knContentFuzzy = knContentFuzzy;
	}

	public String getKnContentFuzzy() {
		return this.knContentFuzzy;
	}

}