package com.jl.project.entity.query;

import java.util.Date;
/**
 * @Description:题目表查询对象
 * @author:jingLong
 * @date:2024/05/29
 */
public class QuQuery extends BaseQuery{
	/**
	 * ID
	 */
	private String id;

	private String idFuzzy;

	/**
	 * 所属题库的ID
	 */
	private String repoId;

	private String repoIdFuzzy;

	/**
	 * 关联题库标题
	 */
	private String repoText;

	private String repoTextFuzzy;

	/**
	 * 题目内容
	 */
	private String content;

	private String contentFuzzy;

	/**
	 * 题目图片
	 */
	private String image;

	private String imageFuzzy;

	/**
	 * 题目难度0:简单1:困难
	 */
	private Integer level;

	/**
	 * 题目分析
	 */
	private String analysis;

	private String analysisFuzzy;

	/**
	 * 创建时间
	 */
	private Date createTime;

	private String createTimeStart;

	private String createTimeEnd;

	/**
	 * 创建者
	 */
	private String createBy;

	private String createByFuzzy;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	private String updateTimeStart;

	private String updateTimeEnd;

	/**
	 * 更新者
	 */
	private String updateBy;

	private String updateByFuzzy;

	/**
	 * 题型
	 */
	private Integer quType;

	/**
	 * 知识点
	 */
	private String knowledge;

	private String knowledgeFuzzy;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setRepoId(String repoId) {
		this.repoId = repoId;
	}

	public String getRepoId() {
		return this.repoId;
	}

	public void setRepoText(String repoText) {
		this.repoText = repoText;
	}

	public String getRepoText() {
		return this.repoText;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImage() {
		return this.image;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public String getAnalysis() {
		return this.analysis;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setQuType(Integer quType) {
		this.quType = quType;
	}

	public Integer getQuType() {
		return this.quType;
	}

	public void setKnowledge(String knowledge) {
		this.knowledge = knowledge;
	}

	public String getKnowledge() {
		return this.knowledge;
	}

	public void setIdFuzzy(String idFuzzy) {
		this.idFuzzy = idFuzzy;
	}

	public String getIdFuzzy() {
		return this.idFuzzy;
	}

	public void setRepoIdFuzzy(String repoIdFuzzy) {
		this.repoIdFuzzy = repoIdFuzzy;
	}

	public String getRepoIdFuzzy() {
		return this.repoIdFuzzy;
	}

	public void setRepoTextFuzzy(String repoTextFuzzy) {
		this.repoTextFuzzy = repoTextFuzzy;
	}

	public String getRepoTextFuzzy() {
		return this.repoTextFuzzy;
	}

	public void setContentFuzzy(String contentFuzzy) {
		this.contentFuzzy = contentFuzzy;
	}

	public String getContentFuzzy() {
		return this.contentFuzzy;
	}

	public void setImageFuzzy(String imageFuzzy) {
		this.imageFuzzy = imageFuzzy;
	}

	public String getImageFuzzy() {
		return this.imageFuzzy;
	}

	public void setAnalysisFuzzy(String analysisFuzzy) {
		this.analysisFuzzy = analysisFuzzy;
	}

	public String getAnalysisFuzzy() {
		return this.analysisFuzzy;
	}

	public void setCreateTimeStart(String createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public String getCreateTimeStart() {
		return this.createTimeStart;
	}

	public void setCreateTimeEnd(String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public String getCreateTimeEnd() {
		return this.createTimeEnd;
	}

	public void setCreateByFuzzy(String createByFuzzy) {
		this.createByFuzzy = createByFuzzy;
	}

	public String getCreateByFuzzy() {
		return this.createByFuzzy;
	}

	public void setUpdateTimeStart(String updateTimeStart) {
		this.updateTimeStart = updateTimeStart;
	}

	public String getUpdateTimeStart() {
		return this.updateTimeStart;
	}

	public void setUpdateTimeEnd(String updateTimeEnd) {
		this.updateTimeEnd = updateTimeEnd;
	}

	public String getUpdateTimeEnd() {
		return this.updateTimeEnd;
	}

	public void setUpdateByFuzzy(String updateByFuzzy) {
		this.updateByFuzzy = updateByFuzzy;
	}

	public String getUpdateByFuzzy() {
		return this.updateByFuzzy;
	}

	public void setKnowledgeFuzzy(String knowledgeFuzzy) {
		this.knowledgeFuzzy = knowledgeFuzzy;
	}

	public String getKnowledgeFuzzy() {
		return this.knowledgeFuzzy;
	}

}