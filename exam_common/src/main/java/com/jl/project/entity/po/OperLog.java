package com.jl.project.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jl.project.enums.DateTimePatternEnum;
import com.jl.project.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

;

/**
 * @Description:操作日志表
 * @author:jingLong
 * @date:2024/05/13
 */
public class OperLog implements Serializable{
	/**
	 * ID
	 */
	private Integer id;

	/**
	 * 操作人员名称
	 */
	private String userName;

	/**
	 * 请求地址
	 */
	private String url;

	/**
	 * 用户IP
	 */
	private String ip;

	/**
	 * 操作地点
	 */
	private String operAddress;

	/**
	 * 是否成功
	 */
	private Integer success;

	/**
	 * 操作时间
	 */
	@JsonFormat(pattern = "yyyy_MM_dd HH:mm:ss",timezone="GMT+8")
	@DateTimeFormat(pattern = "yyyy_MM_dd HH:mm:ss")
	private Date operTime;

	/**
	 * 请求方式（get、post...）
	 */
	private String requestMode;

	/**
	 * 操作方法（哪个方法处理的）
	 */
	private String operationMethod;

	/**
	 * 请求参数
	 */
	private String requestArg;

	/**
	 * 返回参数
	 */
	private String returnArg;

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

	@Override
	public String toString() {
		return "ID:" + (id == null ? "空" : id) + ",操作人员名称:" + (userName == null ? "空" : userName) + ",请求地址:" + (url == null ? "空" : url) + ",用户IP:" + (ip == null ? "空" : ip) + ",操作地点:" + (operAddress == null ? "空" : operAddress) + ",是否成功:" + (success == null ? "空" : success) + ",操作时间:" + (operTime == null ? "空" : DateUtils.format(operTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_ss.getPattern())) + ",请求方式（get、post...）:" + (requestMode == null ? "空" : requestMode) + ",操作方法（哪个方法处理的）:" + (operationMethod == null ? "空" : operationMethod) + ",请求参数:" + (requestArg == null ? "空" : requestArg) + ",返回参数:" + (returnArg == null ? "空" : returnArg) + ",操作类型（增删改查...）:" + (operType == null ? "空" : operType) ;
	}

}