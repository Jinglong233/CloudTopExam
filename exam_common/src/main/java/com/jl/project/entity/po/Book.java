package com.jl.project.entity.po;

import java.io.Serializable;


/**
 * @Description:错题本
 * @author:jingLong
 * @date:2024/05/29
 */
public class Book implements Serializable{
	/**
	 * ID
	 */
	private String id;

	/**
	 * 用户ID
	 */
	private String userId;

	/**
	 * 题目ID
	 */
	private String quId;

	/**
	 * 题目内容
	 */
	private String quContent;

	/**
	 * 学科id
	 */
	private String subjectId;

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

	@Override
	public String toString() {
		return "ID:" + (id == null ? "空" : id) + ",用户ID:" + (userId == null ? "空" : userId) + ",题目ID:" + (quId == null ? "空" : quId) + ",题目内容:" + (quContent == null ? "空" : quContent) + ",学科id:" + (subjectId == null ? "空" : subjectId) + ",答错次数:" + (wrongCount == null ? "空" : wrongCount) + ",题型:" + (quType == null ? "空" : quType) + ",知识点内容:" + (knContent == null ? "空" : knContent) ;
	}

}