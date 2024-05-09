package com.jl.project.entity.query;

import java.util.Date;
/**
 * @Description:登录日志表查询对象
 * @author:jingLong
 * @date:2024/05/08
 */
public class LoginLogQuery extends BaseQuery{
	/**
	 * ID
	 */
	private Integer id;

	/**
	 * 登录用户名
	 */
	private String userName;

	private String userNameFuzzy;

	/**
	 * 用户IP
	 */
	private String ip;

	private String ipFuzzy;

	/**
	 * 登录状态
	 */
	private Integer loginState;

	/**
	 * 登录时间
	 */
	private Date loginTime;

	private String loginTimeStart;

	private String loginTimeEnd;

	/**
	 * 操作信息
	 */
	private String operMsg;

	private String operMsgFuzzy;

	/**
	 * 登录地址
	 */
	private String loginAddress;

	private String loginAddressFuzzy;

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

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIp() {
		return this.ip;
	}

	public void setLoginState(Integer loginState) {
		this.loginState = loginState;
	}

	public Integer getLoginState() {
		return this.loginState;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Date getLoginTime() {
		return this.loginTime;
	}

	public void setOperMsg(String operMsg) {
		this.operMsg = operMsg;
	}

	public String getOperMsg() {
		return this.operMsg;
	}

	public void setLoginAddress(String loginAddress) {
		this.loginAddress = loginAddress;
	}

	public String getLoginAddress() {
		return this.loginAddress;
	}

	public void setUserNameFuzzy(String userNameFuzzy) {
		this.userNameFuzzy = userNameFuzzy;
	}

	public String getUserNameFuzzy() {
		return this.userNameFuzzy;
	}

	public void setIpFuzzy(String ipFuzzy) {
		this.ipFuzzy = ipFuzzy;
	}

	public String getIpFuzzy() {
		return this.ipFuzzy;
	}

	public void setLoginTimeStart(String loginTimeStart) {
		this.loginTimeStart = loginTimeStart;
	}

	public String getLoginTimeStart() {
		return this.loginTimeStart;
	}

	public void setLoginTimeEnd(String loginTimeEnd) {
		this.loginTimeEnd = loginTimeEnd;
	}

	public String getLoginTimeEnd() {
		return this.loginTimeEnd;
	}

	public void setOperMsgFuzzy(String operMsgFuzzy) {
		this.operMsgFuzzy = operMsgFuzzy;
	}

	public String getOperMsgFuzzy() {
		return this.operMsgFuzzy;
	}

	public void setLoginAddressFuzzy(String loginAddressFuzzy) {
		this.loginAddressFuzzy = loginAddressFuzzy;
	}

	public String getLoginAddressFuzzy() {
		return this.loginAddressFuzzy;
	}

}