package com.jl.project.entity.query;

import java.util.Date;
/**
 * @Description:日志表查询对象
 * @author:jingLong
 * @date:2024/05/06
 */
public class LogQuery extends BaseQuery{
	/**
	 * ID
	 */
	private String id;

	private String idFuzzy;

	/**
	 * 操作人员名称
	 */
	private String userName;

	private String userNameFuzzy;

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
	 * 日志类型 0：登录日志1：操作日志
	 */
	private Integer logType;

	/**
	 * 请求方式
	 */
	private String requestMode;

	private String requestModeFuzzy;

	/**
	 * 操作方法
	 */
	private String OperationMethod;

	private String operationMethogFuzzy;

	/**
	 * 请求参数
	 */
	private String requestArg;

	private String requestArgFuzzy;

	/**
	 * 返回参数
	 */
	private String returnArg;

	private String returnArgFuzzy;

	/**
	 * 操作描述
	 */
	private String description;

	private String descriptionFuzzy;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return this.userName;
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

	public void setLogType(Integer logType) {
		this.logType = logType;
	}

	public Integer getLogType() {
		return this.logType;
	}

	public void setRequestMode(String requestMode) {
		this.requestMode = requestMode;
	}

	public String getRequestMode() {
		return this.requestMode;
	}

	public void setOperationMethod(String OperationMethod) {
		this.OperationMethod = OperationMethod;
	}

	public String getOperationMethog() {
		return this.OperationMethod;
	}

	public void setRequestArg(String requestArg) {
		this.requestArg = requestArg;
	}

	public String getRequestArg() {
		return this.requestArg;
	}

	public void setReturnArg(String returnArg) {
		this.returnArg = returnArg;
	}

	public String getReturnArg() {
		return this.returnArg;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	public void setIdFuzzy(String idFuzzy) {
		this.idFuzzy = idFuzzy;
	}

	public String getIdFuzzy() {
		return this.idFuzzy;
	}

	public void setUserNameFuzzy(String userNameFuzzy) {
		this.userNameFuzzy = userNameFuzzy;
	}

	public String getUserNameFuzzy() {
		return this.userNameFuzzy;
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

	public void setRequestModeFuzzy(String requestModeFuzzy) {
		this.requestModeFuzzy = requestModeFuzzy;
	}

	public String getRequestModeFuzzy() {
		return this.requestModeFuzzy;
	}

	public void setOperationMethogFuzzy(String operationMethogFuzzy) {
		this.operationMethogFuzzy = operationMethogFuzzy;
	}

	public String getOperationMethogFuzzy() {
		return this.operationMethogFuzzy;
	}

	public void setRequestArgFuzzy(String requestArgFuzzy) {
		this.requestArgFuzzy = requestArgFuzzy;
	}

	public String getRequestArgFuzzy() {
		return this.requestArgFuzzy;
	}

	public void setReturnArgFuzzy(String returnArgFuzzy) {
		this.returnArgFuzzy = returnArgFuzzy;
	}

	public String getReturnArgFuzzy() {
		return this.returnArgFuzzy;
	}

	public void setDescriptionFuzzy(String descriptionFuzzy) {
		this.descriptionFuzzy = descriptionFuzzy;
	}

	public String getDescriptionFuzzy() {
		return this.descriptionFuzzy;
	}

}