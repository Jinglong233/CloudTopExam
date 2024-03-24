package com.jl.project.entity.po;

import java.io.Serializable;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;;
import org.springframework.format.annotation.DateTimeFormat;
import com.jl.project.enums.DateTimePatternEnum;
import com.jl.project.utils.DateUtils;

/**
 * @Description:消息表
 * @author:jingLong
 * @date:2023/11/22
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
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date sendTime;

	/**
	 * 状态
	 */
	private Integer state;

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

	@Override
	public String toString() {
		return "ID:" + (id == null ? "空" : id) + ",模板ID:" + (templId == null ? "空" : templId) + ",标题:" + (title == null ? "空" : title) + ",消息内容:" + (content == null ? "空" : content) + ",发送人数:" + (sendCount == null ? "空" : sendCount) + ",已读人数:" + (readCount == null ? "空" : readCount) + ",发送时间:" + (sendTime == null ? "空" : DateUtils.format(sendTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_ss.getPattern())) + ",状态:" + (state == null ? "空" : state) ;
	}

}