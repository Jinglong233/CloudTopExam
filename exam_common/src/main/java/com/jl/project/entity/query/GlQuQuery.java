package com.jl.project.entity.query;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @Description:大题题目关联表查询对象
 * @author:jingLong
 * @date:2023/11/29
 */
@Schema(description = "大题题目关联表查询对象")
public class GlQuQuery extends BaseQuery{
	/**
	 * ID
	 */
	@Schema(description = "ID")
	private String id;

	@Schema(hidden = true)
	private String idFuzzy;

	/**
	 * 题目ID
	 */
	@Schema(description = "题目ID")
	private String quId;

	@Schema(hidden = true)
	private String quIdFuzzy;

	/**
	 * 大题ID
	 */
	@Schema(description = "大题ID")
	private String glId;

	@Schema(hidden = true)
	private String glIdFuzzy;

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

	public void setGlIdFuzzy(String glIdFuzzy) {
		this.glIdFuzzy = glIdFuzzy;
	}

	public String getGlIdFuzzy() {
		return this.glIdFuzzy;
	}

}