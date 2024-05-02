package com.jl.project.entity.vo;

import com.jl.project.entity.po.ExamRecord;

/**
 * 已作答的考试记录
 */
public class AnsweredRecordVO extends ExamRecord {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 考试名称
     */
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
