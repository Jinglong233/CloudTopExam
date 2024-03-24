package com.jl.project.entity.query;

/**
 * @Description:题目知识点关联表查询对象
 * @author:jingLong
 * @date:2023/11/22
 */
public class KnQuQuery extends BaseQuery{
	/**
	 * ID
	 */
	private String id;

	private String idFuzzy;

	/**
	 * 知识点ID
	 */
	private String knId;

	private String knIdFuzzy;

	/**
	 * 题目ID
	 */
	private String quId;

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