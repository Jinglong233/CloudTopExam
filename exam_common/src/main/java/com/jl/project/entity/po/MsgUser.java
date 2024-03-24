package com.jl.project.entity.po;

import java.io.Serializable;


/**
 * @Description:用户消息关联表
 * @author:jingLong
 * @date:2023/11/22
 */
public class MsgUser implements Serializable{
	/**
	 * ID
	 */
	private String id;

	/**
	 * 消息ID
	 */
	private String msgId;

	/**
	 * 用户ID
	 */
	private String userId;

	/**
	 * 发送状态
	 */
	private Integer sendState;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getMsgId() {
		return this.msgId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setSendState(Integer sendState) {
		this.sendState = sendState;
	}

	public Integer getSendState() {
		return this.sendState;
	}

	@Override
	public String toString() {
		return "ID:" + (id == null ? "空" : id) + ",消息ID:" + (msgId == null ? "空" : msgId) + ",用户ID:" + (userId == null ? "空" : userId) + ",发送状态:" + (sendState == null ? "空" : sendState) ;
	}

}