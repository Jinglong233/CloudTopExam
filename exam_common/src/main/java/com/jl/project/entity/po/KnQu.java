package com.jl.project.entity.po;

import java.io.Serializable;


/**
 * @Description:题目知识点关联表
 * @author:jingLong
 * @date:2023/11/22
 */
public class KnQu implements Serializable{
	/**
	 * ID
	 */
	private String id;

	/**
	 * 知识点ID
	 */
	private String knId;

	/**
	 * 题目ID
	 */
	private String quId;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setKnId(String knId) {
		this.knId = knId;
	}

	public String getKnId() {
		return this.knId;
	}

	public void setQuId(String quId) {
		this.quId = quId;
	}

	public String getQuId() {
		return this.quId;
	}

	@Override
	public String toString() {
		return "ID:" + (id == null ? "空" : id) + ",知识点ID:" + (knId == null ? "空" : knId) + ",题目ID:" + (quId == null ? "空" : quId) ;
	}

}