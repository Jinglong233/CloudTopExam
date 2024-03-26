package com.jl.project.entity.po;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;


/**
 * @Description:题目答案表
 * @author:jingLong
 * @date:2023/11/27
 */
@Schema(description = "题目答案表")
public class QuAnswer implements Serializable{
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
	 * 选项内容
	 */
	@Schema(description = "选项内容")
	private String content;

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

	/**
	 * 选项图片
	 */
	@Schema(description = "选项图片")
	private String image;

	/**
	 * 选项标签
	 */
	@Schema(description = "选项标签")
	private String tag;

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

	@Override
	public String toString() {
		return "QuAnswer{" +
				"id='" + id + '\'' +
				", quId='" + quId + '\'' +
				", content='" + content + '\'' +
				", isRight=" + isRight +
				", analysis='" + analysis + '\'' +
				", image='" + image + '\'' +
				", tag='" + tag + '\'' +
				'}';
	}
}