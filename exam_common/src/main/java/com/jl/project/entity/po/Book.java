package com.jl.project.entity.po;

import java.io.Serializable;


/**
 * @Description:错题本
 * @author:jingLong
 * @date:2023/11/22
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
	 * 答错次数
	 */
	private Integer wrongCount;

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

	public void setWrongCount(Integer wrongCount) {
		this.wrongCount = wrongCount;
	}

	public Integer getWrongCount() {
		return this.wrongCount;
	}

	@Override
	public String toString() {
		return "ID:" + (id == null ? "空" : id) + ",用户ID:" + (userId == null ? "空" : userId) + ",题目ID:" + (quId == null ? "空" : quId) + ",答错次数:" + (wrongCount == null ? "空" : wrongCount) ;
	}

}