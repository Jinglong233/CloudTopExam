package com.jl.project.entity.query;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @Description:题目答案表查询对象
 * @author:jingLong
 * @date:2023/11/27
 */
@Schema(description = "题目答案表查询对象")
public class QuAnswerQuery extends BaseQuery{
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
	 * 题目内容
	 */
	@Schema(description = "题目内容")
	private String content;

	@Schema(hidden = true)
	private String contentFuzzy;

	/**
	 * 是否是答案0:不是1:是
	 */
	@Schema(description = "是否是答案0:不是1:是")
	private Integer isRight;

	/**
	 * 选项分析
	 */
	@Schema(description = "选项分析")
	private String analysis;

	@Schema(hidden = true)
	private String analysisFuzzy;

	/**
	 * 选项图片
	 */
	@Schema(description = "选项图片")
	private String image;

	@Schema(hidden = true)
	private String imageFuzzy;

	/**
	 * 选项标签
	 */
	@Schema(description = "选项标签")
	private String tag;

	@Schema(hidden = true)
	private String tagFuzzy;

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

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}

	public void setIsRight(Integer isRight) {
		this.isRight = isRight;
	}

	public Integer getIsRight() {
		return this.isRight;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public String getAnalysis() {
		return this.analysis;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImage() {
		return this.image;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTag() {
		return this.tag;
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

	public void setContentFuzzy(String contentFuzzy) {
		this.contentFuzzy = contentFuzzy;
	}

	public String getContentFuzzy() {
		return this.contentFuzzy;
	}

	public void setAnalysisFuzzy(String analysisFuzzy) {
		this.analysisFuzzy = analysisFuzzy;
	}

	public String getAnalysisFuzzy() {
		return this.analysisFuzzy;
	}

	public void setImageFuzzy(String imageFuzzy) {
		this.imageFuzzy = imageFuzzy;
	}

	public String getImageFuzzy() {
		return this.imageFuzzy;
	}

	public void setTagFuzzy(String tagFuzzy) {
		this.tagFuzzy = tagFuzzy;
	}

	public String getTagFuzzy() {
		return this.tagFuzzy;
	}

}