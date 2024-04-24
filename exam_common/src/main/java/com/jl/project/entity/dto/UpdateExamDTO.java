package com.jl.project.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.po.User;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 更新考试DTO
 */
@Schema(description = "更新考试DTO")
public class UpdateExamDTO{

    /**
     * 考试Id
     */
    @Schema(description = "考试Id")
    @VerifyParam(require = true)
    private String id;
    /**
     * 试卷ID
     */
    @Schema(description = "试卷ID")
    private String paperId;

    /**
     * 考试标题
     */
    @Schema(description = "考试标题")
    @VerifyParam(require = true)
    private String title;

    /**
     * 考试部门编码
     */
    @Schema(description = "考试部门编码")
    private String deptCode;

    /**
     * 考试开始时间
     */
    @Schema(description = "考试开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 考试结束时间
     */
    @Schema(description = "考试结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;


    /**
     * 开放权限 0:完全公开 1:指定学生
     */
    @Schema(description = "开放权限 0:完全公开 1:指定学生")
    private Integer openType;

    /**
     * 考试时长
     */
    @Schema(description = "考试时长")
    private Integer duration;

    /**
     * 感谢语
     */
    @Schema(description = "感谢语")
    private String thanks;

    /**
     * 允许迟到时间
     */
    @Schema(description = "允许迟到时间")
    private Integer lateMax;

    /**
     * 最少答题时间
     */
    @Schema(description = "最少答题时间")
    private Integer handMin;

    /**
     * 结果显示类型（只显示分数/显示分数+答题详情/展示答题详情）
     */
    @Schema(description = "结果显示类型（只显示分数/显示分数+答题详情/展示答题详情）")
    private Integer resultType;

    /**
     * 及格分数
     */
    @Schema(description = "及格分数")
    @VerifyParam(require = true)
    private Integer qualifyScore;


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


    @Schema(hidden = true)
    private List<User> userList;


    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }


    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getOpenType() {
        return openType;
    }

    public void setOpenType(Integer openType) {
        this.openType = openType;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getThanks() {
        return thanks;
    }

    public void setThanks(String thanks) {
        this.thanks = thanks;
    }

    public Integer getLateMax() {
        return lateMax;
    }

    public void setLateMax(Integer lateMax) {
        this.lateMax = lateMax;
    }

    public Integer getHandMin() {
        return handMin;
    }

    public void setHandMin(Integer handMin) {
        this.handMin = handMin;
    }

    public Integer getResultType() {
        return resultType;
    }

    public void setResultType(Integer resultType) {
        this.resultType = resultType;
    }

    public Integer getQualifyScore() {
        return qualifyScore;
    }

    public void setQualifyScore(Integer qualifyScore) {
        this.qualifyScore = qualifyScore;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
