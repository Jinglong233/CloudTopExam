package com.jl.project.entity.po;

import java.io.Serializable;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;;
import org.springframework.format.annotation.DateTimeFormat;
import com.jl.project.enums.DateTimePatternEnum;
import com.jl.project.utils.DateUtils;

/**
 * @Description:登录日志表
 * @author:jingLong
 * @date:2024/05/08
 */
public class LoginLog implements Serializable{
	/**
	 * ID
	 */
	private Integer id;

	/**
	 * 登录用户名
	 */
	private String userName;

	/**
	 * 用户IP
	 */
	private String ip;

	/**
	 * 登录状态
	 */
	private Integer loginState;

	/**
	 * 登录时间
	 */
	@JsonFormat(pattern = "yyyy_MM_dd HH:mm:ss",timezone="GMT+8")
	@DateTimeFormat(pattern = "yyyy_MM_dd HH:mm:ss")
	private Date loginTime;

	/**
	 * 操作信息
	 */
	private String operMsg;

	/**
	 * 登录地址
	 */
	private String loginAddress;

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

	@Override
	public String toString() {
		return "ID:" + (id == null ? "空" : id) + ",登录用户名:" + (userName == null ? "空" : userName) + ",用户IP:" + (ip == null ? "空" : ip) + ",登录状态:" + (loginState == null ? "空" : loginState) + ",登录时间:" + (loginTime == null ? "空" : DateUtils.format(loginTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_ss.getPattern())) + ",操作信息:" + (operMsg == null ? "空" : operMsg) + ",登录地址:" + (loginAddress == null ? "空" : loginAddress) ;
	}

}