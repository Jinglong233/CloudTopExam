package com.jl.project.entity.query;

/**
 * @Description:用户消息关联表查询对象
 * @author:jingLong
 * @date:2023/11/22
 */
public class MsgUserQuery extends BaseQuery{
	/**
	 * ID
	 */
	private String id;

	private String idFuzzy;

	/**
	 * 消息ID
	 */
	private String msgId;

	private String msgIdFuzzy;

	/**
	 * 用户ID
	 */
	private String userId;

	private String userIdFuzzy;

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

	public void setIdFuzzy(String idFuzzy) {
		this.idFuzzy = idFuzzy;
	}

	public String getIdFuzzy() {
		return this.idFuzzy;
	}

	public void setMsgIdFuzzy(String msgIdFuzzy) {
		this.msgIdFuzzy = msgIdFuzzy;
	}

	public String getMsgIdFuzzy() {
		return this.msgIdFuzzy;
	}

	public void setUserIdFuzzy(String userIdFuzzy) {
		this.userIdFuzzy = userIdFuzzy;
	}

	public String getUserIdFuzzy() {
		return this.userIdFuzzy;
	}

}