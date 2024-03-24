package com.jl.project.entity.query;

import java.util.Date;
/**
 * @Description:日志表查询对象
 * @author:jingLong
 * @date:2023/11/22
 */
public class LogQuery extends BaseQuery{
	/**
	 * ID
	 */
	private String id;

	private String idFuzzy;

	/**
	 * 用户ID
	 */
	private String userId;

	private String userIdFuzzy;

	/**
	 * 用户请求数据
	 */
	private String data;

	private String dataFuzzy;

	/**
	 * 请求地址
	 */
	private String url;

	private String urlFuzzy;

	/**
	 * 用户IP
	 */
	private String ip;

	private String ipFuzzy;

	/**
	 * 是否成功
	 */
	private Integer success;

	/**
	 * 创建时间
	 */
	private Date createTime;

	private String createTimeStart;

	private String createTimeEnd;

	/**
	 * 日志类型
	 */
	private String logType;

	private String logTypeFuzzy;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getData() {
		return this.data;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return this.url;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIp() {
		return this.ip;
	}

	public void setSuccess(Integer success) {
		this.success = success;
	}

	public Integer getSuccess() {
		return this.success;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	public String getLogType() {
		return this.logType;
	}

	public void setIdFuzzy(String idFuzzy) {
		this.idFuzzy = idFuzzy;
	}

	public String getIdFuzzy() {
		return this.idFuzzy;
	}

	public void setUserIdFuzzy(String userIdFuzzy) {
		this.userIdFuzzy = userIdFuzzy;
	}

	public String getUserIdFuzzy() {
		return this.userIdFuzzy;
	}

	public void setDataFuzzy(String dataFuzzy) {
		this.dataFuzzy = dataFuzzy;
	}

	public String getDataFuzzy() {
		return this.dataFuzzy;
	}

	public void setUrlFuzzy(String urlFuzzy) {
		this.urlFuzzy = urlFuzzy;
	}

	public String getUrlFuzzy() {
		return this.urlFuzzy;
	}

	public void setIpFuzzy(String ipFuzzy) {
		this.ipFuzzy = ipFuzzy;
	}

	public String getIpFuzzy() {
		return this.ipFuzzy;
	}

	public void setCreateTimeStart(String createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public String getCreateTimeStart() {
		return this.createTimeStart;
	}

	public void setCreateTimeEnd(String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public String getCreateTimeEnd() {
		return this.createTimeEnd;
	}

	public void setLogTypeFuzzy(String logTypeFuzzy) {
		this.logTypeFuzzy = logTypeFuzzy;
	}

	public String getLogTypeFuzzy() {
		return this.logTypeFuzzy;
	}

}