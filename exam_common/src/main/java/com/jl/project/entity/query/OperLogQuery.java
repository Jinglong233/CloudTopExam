package com.jl.project.entity.query;

import java.util.Date;
/**
 * @Description:操作日志表查询对象
 * @author:jingLong
 * @date:2024/05/13
 */
public class OperLogQuery extends BaseQuery{
	/**
	 * ID
	 */
	private Integer id;

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
	 * 操作地点
	 */
	private String operAddress;

	private String operAddressFuzzy;

	/**
	 * 是否成功
	 */
	private Integer success;

	/**
	 * 操作时间
	 */
	private Date operTime;

	private String operTimeStart;

	private String operTimeEnd;

	/**
	 * 请求方式（get、post...）
	 */
	private String requestMode;

	private String requestModeFuzzy;

	/**
	 * 操作方法（哪个方法处理的）
	 */
	private String operationMethod;

	private String operationMethodFuzzy;

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
	 * 操作类型（增删改查...）
	 */
	private Integer operType;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
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

	public void setOperAddress(String operAddress) {
		this.operAddress = operAddress;
	}

	public String getOperAddress() {
		return this.operAddress;
	}

	public void setSuccess(Integer success) {
		this.success = success;
	}

	public Integer getSuccess() {
		return this.success;
	}

	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}

	public Date getOperTime() {
		return this.operTime;
	}

	public void setRequestMode(String requestMode) {
		this.requestMode = requestMode;
	}

	public String getRequestMode() {
		return this.requestMode;
	}

	public void setOperationMethod(String operationMethod) {
		this.operationMethod = operationMethod;
	}

	public String getOperationMethod() {
		return this.operationMethod;
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

	public void setOperType(Integer operType) {
		this.operType = operType;
	}

	public Integer getOperType() {
		return this.operType;
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

	public void setOperAddressFuzzy(String operAddressFuzzy) {
		this.operAddressFuzzy = operAddressFuzzy;
	}

	public String getOperAddressFuzzy() {
		return this.operAddressFuzzy;
	}

	public void setOperTimeStart(String operTimeStart) {
		this.operTimeStart = operTimeStart;
	}

	public String getOperTimeStart() {
		return this.operTimeStart;
	}

	public void setOperTimeEnd(String operTimeEnd) {
		this.operTimeEnd = operTimeEnd;
	}

	public String getOperTimeEnd() {
		return this.operTimeEnd;
	}

	public void setRequestModeFuzzy(String requestModeFuzzy) {
		this.requestModeFuzzy = requestModeFuzzy;
	}

	public String getRequestModeFuzzy() {
		return this.requestModeFuzzy;
	}

	public void setOperationMethodFuzzy(String operationMethodFuzzy) {
		this.operationMethodFuzzy = operationMethodFuzzy;
	}

	public String getOperationMethodFuzzy() {
		return this.operationMethodFuzzy;
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

}