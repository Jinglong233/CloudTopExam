package com.jl.project.entity.po;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;


/**
 * @Description:用户消息关联表
 * @author:jingLong
 * @date:2023/11/22
 */
@Schema(description = "用户消息关联表")
public class MsgUser implements Serializable{
	/**
	 * ID
	 */
	@Schema(description = "ID")
	private String id;

	/**
	 * 消息ID
	 */
	@Schema(description = "消息ID")
	private String msgId;

	/**
	 * 用户ID
	 */
	@Schema(description = "用户ID")
	private String userId;

	/**
	 * 发送状态
	 */
	@Schema(description = "发送状态")
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