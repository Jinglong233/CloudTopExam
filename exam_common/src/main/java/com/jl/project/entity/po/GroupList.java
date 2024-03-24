package com.jl.project.entity.po;

import java.io.Serializable;


/**
 * @Description:大题表
 * @author:jingLong
 * @date:2023/11/22
 */
public class GroupList implements Serializable{
	/**
	 * ID
	 */
	private String id;

	/**
	 * 所属试卷ID
	 */
	private String paperId;

	/**
	 * 题型
	 */
	private Integer quType;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 总分
	 */
	private Integer totalScore;

	/**
	 * 每个小题的分数
	 */
	private Integer perScore;

	/**
	 * 选项是否乱序0:否1:是
	 */
	private Integer itemRand;

	/**
	 * 题目是否乱序0:否1:是
	 */
	private Integer quRand;

	/**
	 * 题目总数
	 */
	private Integer quCount;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public String getPaperId() {
		return this.paperId;
	}

	public void setQuType(Integer quType) {
		this.quType = quType;
	}

	public Integer getQuType() {
		return this.quType;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

	public Integer getTotalScore() {
		return this.totalScore;
	}

	public void setPerScore(Integer perScore) {
		this.perScore = perScore;
	}

	public Integer getPerScore() {
		return this.perScore;
	}

	public void setItemRand(Integer itemRand) {
		this.itemRand = itemRand;
	}

	public Integer getItemRand() {
		return this.itemRand;
	}

	public void setQuRand(Integer quRand) {
		this.quRand = quRand;
	}

	public Integer getQuRand() {
		return this.quRand;
	}

	public void setQuCount(Integer quCount) {
		this.quCount = quCount;
	}

	public Integer getQuCount() {
		return this.quCount;
	}

	@Override
	public String toString() {
		return "ID:" + (id == null ? "空" : id) + ",所属试卷ID:" + (paperId == null ? "空" : paperId) + ",题型:" + (quType == null ? "空" : quType) + ",标题:" + (title == null ? "空" : title) + ",总分:" + (totalScore == null ? "空" : totalScore) + ",每个小题的分数:" + (perScore == null ? "空" : perScore) + ",选项是否乱序0:否1:是:" + (itemRand == null ? "空" : itemRand) + ",题目是否乱序0:否1:是:" + (quRand == null ? "空" : quRand) + ",题目总数:" + (quCount == null ? "空" : quCount) ;
	}

}