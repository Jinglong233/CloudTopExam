package com.jl.project.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jl.project.enums.DateTimePatternEnum;
import com.jl.project.utils.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

;

/**
 * @Description:题目表
 * @author:jingLong
 * @date:2024/05/29
 */
@Schema(description = ":题目表")
public class Qu implements Serializable {
    /**
     * ID
     */
    @Schema(description = "ID")
    private String id;

    /**
     * 所属题库的ID
     */
    @Schema(description = "所属题库的ID")
    private String repoId;

    /**
     * 关联题库标题
     */
    @Schema(description = "关联题库标题")
    private String repoText;

    /**
     * 题目内容
     */
    @Schema(description = "题目内容")
    private String content;

    /**
     * 题目图片
     */
    @Schema(description = "题目图片")
    private String image;

    /**
     * 题目难度0:简单1:困难
     */
    @Schema(description = "题目难度0:简单1:困难")
    private Integer level;

    /**
     * 题目分析
     */
    @Schema(description = "题目分析")
    private String analysis;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 创建者
     */
    @Schema(description = "创建者")
    private String createBy;

    /**
     * 更新时间
     */
    @Schema(description = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 更新者
     */
    @Schema(description = "更新者")
    private String updateBy;

    /**
     * 题型
     */
    @Schema(description = "题型")
    private Integer quType;

    /**
     * 分值（从其他表获取）
     */
    @Schema(description = "分值（从其他表获取）")
    private Integer score;

    /**
     * 排序（从其他表获取）
     */
    @Schema(description = "排序（从其他表获取）")
    private Integer sort;

    /**
     * 知识点
     */
    @Schema(description = "知识点")
    private String knowledge;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

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

    @Override
    public String toString() {
        return "ID:" + (id == null ? "空" : id) + ",所属题库的ID:" + (repoId == null ? "空" : repoId) + ",关联题库标题:" + (repoText == null ? "空" : repoText) + ",题目内容:" + (content == null ? "空" : content) + ",题目图片:" + (image == null ? "空" : image) + ",题目难度0:简单1:困难:" + (level == null ? "空" : level) + ",题目分析:" + (analysis == null ? "空" : analysis) + ",创建时间:" + (createTime == null ? "空" : DateUtils.format(createTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_ss.getPattern())) + ",创建者:" + (createBy == null ? "空" : createBy) + ",更新时间:" + (updateTime == null ? "空" : DateUtils.format(updateTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_ss.getPattern())) + ",更新者:" + (updateBy == null ? "空" : updateBy) + ",题型:" + (quType == null ? "空" : quType) + ",知识点:" + (knowledge == null ? "空" : knowledge);
    }

}