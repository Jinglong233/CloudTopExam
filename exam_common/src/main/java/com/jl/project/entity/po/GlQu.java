package com.jl.project.entity.po;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;


/**
 * @Description:大题题目关联表
 * @author:jingLong
 * @date:2023/11/29
 */
@Schema(description = "大题题目关联表")
public class GlQu implements Serializable{
	/**
	 * ID
	 */
	@Schema(description = "ID")
	private String id;

	/**
	 * 题目ID
	 */
	@Schema(description = "题目ID")
	private String quId;

	/**
	 * 大题ID
	 */
	@Schema(description = "大题ID")
	private String glId;

	/**
	 * 题目在大题中的排序
	 */
	@Schema(description = "题目在大题中的排序")
	private Integer sort;

	/**
	 * 题目对应的分数
	 */
	@Schema(description = "题目对应的分数")
	private Integer score;

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

	public void setGlId(String glId) {
		this.glId = glId;
	}

	public String getGlId() {
		return this.glId;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getScore() {
		return this.score;
	}

	@Override
	public String toString() {
		return "ID:" + (id == null ? "空" : id) + ",题目ID:" + (quId == null ? "空" : quId) + ",大题ID:" + (glId == null ? "空" : glId) + ",题目在大题中的排序:" + (sort == null ? "空" : sort) + ",题目对应的分数:" + (score == null ? "空" : score) ;
	}

}