package com.jl.project.entity.dto;

import com.jl.project.entity.vo.QuAndAnswerVo;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

/**
 * 大题添加类
 */
@Schema(description = "大题添加类")
public class AddGroupListDTO {

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

    /**
     * 题目列表
     */
    @Schema(description = "题目列表")
    private List<QuAndAnswerVo> quList;

    public Integer getQuType() {
        return quType;
    }

    public void setQuType(Integer quType) {
        this.quType = quType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getPerScore() {
        return perScore;
    }

    public void setPerScore(Integer perScore) {
        this.perScore = perScore;
    }

    public Integer getItemRand() {
        return itemRand;
    }

    public void setItemRand(Integer itemRand) {
        this.itemRand = itemRand;
    }

    public Integer getQuRand() {
        return quRand;
    }

    public void setQuRand(Integer quRand) {
        this.quRand = quRand;
    }

    public Integer getQuCount() {
        return quCount;
    }

    public void setQuCount(Integer quCount) {
        this.quCount = quCount;
    }

    public List<QuAndAnswerVo> getQuList() {
        return quList;
    }

    public void setQuList(List<QuAndAnswerVo> quList) {
        this.quList = quList;
    }
}
