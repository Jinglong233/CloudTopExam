package com.jl.project.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jl.project.enums.DateTimePatternEnum;
import com.jl.project.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

;

/**
 * @Description:消息表
 * @author:jingLong
 * @date:2024/05/08
 */
public class Msg implements Serializable{
	/**
	 * ID
	 */
	private String id;

	/**
	 * 模板ID
	 */
	private String templId;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 消息内容
	 */
	private String content;

	/**
	 * 消息类型 0：公告1：通知2：邮件
	 */
	private Integer msgType;

	/**
	 * 发送人数
	 */
	private Integer sendCount;

	/**
	 * 已读人数
	 */
	private Integer readCount;

	/**
	 * 发送时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date sendTime;

	/**
	 * 状态
	 */
	private Integer state;

	/**
	 * 发送人Id
	 */
	private String createUser;

	/**
	 * 发送人姓名
	 */
	private String createUserText;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setTemplId(String templId) {
		this.templId = templId;
	}

	public String getTemplId() {
		return this.templId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}

	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}

	public Integer getMsgType() {
		return this.msgType;
	}

	public void setSendCount(Integer sendCount) {
		this.sendCount = sendCount;
	}

	public Integer getSendCount() {
		return this.sendCount;
	}

	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}

	public Integer getReadCount() {
		return this.readCount;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Date getSendTime() {
		return this.sendTime;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getState() {
		return this.state;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUserText(String createUserText) {
		this.createUserText = createUserText;
	}

	public String getCreateUserText() {
		return this.createUserText;
	}

	@Override
	public String toString() {
		return "ID:" + (id == null ? "空" : id) + ",模板ID:" + (templId == null ? "空" : templId) + ",标题:" + (title == null ? "空" : title) + ",消息内容:" + (content == null ? "空" : content) + ",消息类型 0：公告1：通知2：邮件:" + (msgType == null ? "空" : msgType) + ",发送人数:" + (sendCount == null ? "空" : sendCount) + ",已读人数:" + (readCount == null ? "空" : readCount) + ",发送时间:" + (sendTime == null ? "空" : DateUtils.format(sendTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_ss.getPattern())) + ",状态:" + (state == null ? "空" : state) + ",发送人Id:" + (createUser == null ? "空" : createUser) + ",发送人姓名:" + (createUserText == null ? "空" : createUserText) ;
	}

}