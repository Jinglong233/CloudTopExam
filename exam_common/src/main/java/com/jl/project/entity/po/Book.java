package com.jl.project.entity.po;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;


/**
 * @Description:错题本
 * @author:jingLong
 * @date:2023/11/22
 */
@Schema(description = "错题本")
public class Book implements Serializable{
	/**
	 * ID
	 */
	@Schema(description = "ID")
	private String id;

	/**
	 * 用户ID
	 */
	@Schema(description = "用户ID")
	private String userId;

	/**
	 * 题目ID
	 */
	@Schema(description = "题目ID")
	private String quId;

	/**
	 * 答错次数
	 */
	@Schema(description = "答错次数")
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