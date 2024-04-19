package com.jl.project.entity.query;

import java.util.Date;
/**
 * @Description:消息表查询对象
 * @author:jingLong
 * @date:2024/04/19
 */
public class MsgQuery extends BaseQuery{
	/**
	 * ID
	 */
	private String id;

	private String idFuzzy;

	/**
	 * 模板ID
	 */
	private String templId;

	private String templIdFuzzy;

	/**
	 * 标题
	 */
	private String title;

	private String titleFuzzy;

	/**
	 * 消息内容
	 */
	private String content;

	private String contentFuzzy;

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
	private Date sendTime;

	private String sendTimeStart;

	private String sendTimeEnd;

	/**
	 * 状态
	 */
	private Integer state;

	/**
	 * 发送人Id
	 */
	private String createUser;

	private String createUserFuzzy;

	/**
	 * 发送人姓名
	 */
	private String createUserText;

	private String createUserTextFuzzy;

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

	public void setIdFuzzy(String idFuzzy) {
		this.idFuzzy = idFuzzy;
	}

	public String getIdFuzzy() {
		return this.idFuzzy;
	}

	public void setTemplIdFuzzy(String templIdFuzzy) {
		this.templIdFuzzy = templIdFuzzy;
	}

	public String getTemplIdFuzzy() {
		return this.templIdFuzzy;
	}

	public void setTitleFuzzy(String titleFuzzy) {
		this.titleFuzzy = titleFuzzy;
	}

	public String getTitleFuzzy() {
		return this.titleFuzzy;
	}

	public void setContentFuzzy(String contentFuzzy) {
		this.contentFuzzy = contentFuzzy;
	}

	public String getContentFuzzy() {
		return this.contentFuzzy;
	}

	public void setSendTimeStart(String sendTimeStart) {
		this.sendTimeStart = sendTimeStart;
	}

	public String getSendTimeStart() {
		return this.sendTimeStart;
	}

	public void setSendTimeEnd(String sendTimeEnd) {
		this.sendTimeEnd = sendTimeEnd;
	}

	public String getSendTimeEnd() {
		return this.sendTimeEnd;
	}

	public void setCreateUserFuzzy(String createUserFuzzy) {
		this.createUserFuzzy = createUserFuzzy;
	}

	public String getCreateUserFuzzy() {
		return this.createUserFuzzy;
	}

	public void setCreateUserTextFuzzy(String createUserTextFuzzy) {
		this.createUserTextFuzzy = createUserTextFuzzy;
	}

	public String getCreateUserTextFuzzy() {
		return this.createUserTextFuzzy;
	}

}