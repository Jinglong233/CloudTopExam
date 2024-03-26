package com.jl.project.entity.query;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;
/**
 * @Description:消息表查询对象
 * @author:jingLong
 * @date:2023/11/22
 */
@Schema(description = "消息表查询对象")
public class MsgQuery extends BaseQuery{
	/**
	 * ID
	 */
	@Schema(description = "ID")
	private String id;

	@Schema(hidden = true)
	private String idFuzzy;

	/**
	 * 模板ID
	 */
	@Schema(description = "模板ID")
	private String templId;

	@Schema(hidden = true)
	private String templIdFuzzy;

	/**
	 * 标题
	 */
	@Schema(description = "标题")
	private String title;

	@Schema(hidden = true)
	private String titleFuzzy;

	/**
	 * 消息内容
	 */
	@Schema(description = "消息内容")
	private String content;

	@Schema(hidden = true)
	private String contentFuzzy;

	/**
	 * 发送人数
	 */
	@Schema(description = "发送人数")
	private Integer sendCount;

	/**
	 * 已读人数
	 */
	@Schema(description = "已读人数")
	private Integer readCount;

	/**
	 * 发送时间
	 */
	@Schema(description = "发送时间")
	private Date sendTime;

	@Schema(hidden = true)
	private String sendTimeStart;

	@Schema(hidden = true)
	private String sendTimeEnd;

	/**
	 * 状态
	 */
	@Schema(description = "状态")
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

}