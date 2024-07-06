package com.jl.project.entity.dto;

import com.jl.project.annotation.VerifyParam;

import java.util.List;

/**
 * @Author jingLong
 * @Date 2024-05-08 19:59
 **/
public class SendMessageDTO {
    /**
     * 发送类型
     */
    private Integer sendType;

    /**
     * 消息类型
     */
    @VerifyParam(require = true)
    private List<Integer> msgType;

    /**
     * 部门编码
     */
    private String deptCode;

    /**
     * 用户列表
     */
    private List<String> userList;

    /**
     * 消息标题
     */
    @VerifyParam(require = true)
    private String msgTitle;

    /**
     * 消息内容
     */
    @VerifyParam(require = true)
    private String msgContent;

    public Integer getSendType() {
        return sendType;
    }

    public void setSendType(Integer sendType) {
        this.sendType = sendType;
    }



    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public List<Integer> getMsgType() {
        return msgType;
    }

    public void setMsgType(List<Integer> msgType) {
        this.msgType = msgType;
    }

    public List<String> getUserList() {
        return userList;
    }

    public void setUserList(List<String> userList) {
        this.userList = userList;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }
}
