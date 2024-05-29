package com.jl.project.entity.dto;

import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.po.QuAnswer;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

/**
 * 更新问题及其答案DTO
 */
@Schema(description = "更新问题及其答案DTO")
public class UpdateQuAndAnswerDTO{

    /**
     * ID
     */
    @Schema(description = "ID")
    @VerifyParam(require = true)
    private String id;

    /**
     * 所属题库的ID
     */
    @Schema(description = "所属题库的ID")
    private String repoId;


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
     * 题型
     */
    @Schema(description = "题型")
    private Integer quType;

    /**
     * 知识点
     */
    @Schema(description = "知识点")
    private String knowledge;


    /**
     * 题目答案列表
     */
    @Schema(description = "题目答案列表")
    private List<QuAnswer> quAnswerList;

    public List<QuAnswer> getQuAnswerList() {
        return quAnswerList;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    public void setQuAnswerList(List<QuAnswer> quAnswerList) {
        this.quAnswerList = quAnswerList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRepoId() {
        return repoId;
    }

    public void setRepoId(String repoId) {
        this.repoId = repoId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public Integer getQuType() {
        return quType;
    }

    public void setQuType(Integer quType) {
        this.quType = quType;
    }
}
