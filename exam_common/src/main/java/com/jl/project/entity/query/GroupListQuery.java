package com.jl.project.entity.query;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @Description:大题表查询对象
 * @author:jingLong
 * @date:2023/11/22
 */
@Schema(description = "大题表查询对象")
public class GroupListQuery extends BaseQuery{
	/**
	 * ID
	 */
	@Schema(description = "ID")
	private String id;

	@Schema(hidden = true)
	private String idFuzzy;

	/**
	 * 所属试卷ID
	 */
	@Schema(description = "所属试卷ID")
	private String paperId;

	@Schema(hidden = true)
	private String paperIdFuzzy;

	/**
	 * 题型
	 */
	@Schema(description = "题型")
	private Integer quType;

	/**
	 * 标题
	 */
	@Schema(description = "标题")
	private String title;

	@Schema(hidden = true)
	private String titleFuzzy;

	/**
	 * 总分
	 */
	@Schema(description = "总分")
	private Integer totalScore;

	/**
	 * 每个小题的分数
	 */
	@Schema(description = "每个小题的分数")
	private Integer perScore;

	/**
	 * 选项是否乱序0:否1:是
	 */
	@Schema(description = "选项是否乱序0:否1:是")
	private Integer itemRand;

	/**
	 * 题目是否乱序0:否1:是
	 */
	@Schema(description = "题目是否乱序0:否1:是")
	private Integer quRand;

	/**
	 * 题目总数
	 */
	@Schema(description = "题目总数")
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

	public void setIdFuzzy(String idFuzzy) {
		this.idFuzzy = idFuzzy;
	}

	public String getIdFuzzy() {
		return this.idFuzzy;
	}

	public void setPaperIdFuzzy(String paperIdFuzzy) {
		this.paperIdFuzzy = paperIdFuzzy;
	}

	public String getPaperIdFuzzy() {
		return this.paperIdFuzzy;
	}

	public void setTitleFuzzy(String titleFuzzy) {
		this.titleFuzzy = titleFuzzy;
	}

	public String getTitleFuzzy() {
		return this.titleFuzzy;
	}

}