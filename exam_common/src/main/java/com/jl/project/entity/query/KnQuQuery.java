package com.jl.project.entity.query;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @Description:题目知识点关联表查询对象
 * @author:jingLong
 * @date:2023/11/22
 */
@Schema(description = "题目知识点关联表查询对象")
public class KnQuQuery extends BaseQuery{
	/**
	 * ID
	 */
	@Schema(description = "ID")
	private String id;

	@Schema(hidden = true)
	private String idFuzzy;

	/**
	 * 知识点ID
	 */
	@Schema(description = "知识点ID")
	private String knId;

	@Schema(hidden = true)
	private String knIdFuzzy;

	/**
	 * 题目ID
	 */
	@Schema(description = "题目ID")
	private String quId;

	@Schema(hidden = true)
	private String quIdFuzzy;

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

	public void setIdFuzzy(String idFuzzy) {
		this.idFuzzy = idFuzzy;
	}

	public String getIdFuzzy() {
		return this.idFuzzy;
	}

	public void setKnIdFuzzy(String knIdFuzzy) {
		this.knIdFuzzy = knIdFuzzy;
	}

	public String getKnIdFuzzy() {
		return this.knIdFuzzy;
	}

	public void setQuIdFuzzy(String quIdFuzzy) {
		this.quIdFuzzy = quIdFuzzy;
	}

	public String getQuIdFuzzy() {
		return this.quIdFuzzy;
	}

}