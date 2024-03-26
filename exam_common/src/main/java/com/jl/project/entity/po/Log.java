package com.jl.project.entity.po;

import java.io.Serializable;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;
import com.jl.project.enums.DateTimePatternEnum;
import com.jl.project.utils.DateUtils;

/**
 * @Description:日志表
 * @author:jingLong
 * @date:2023/11/22
 */
@Schema(description = "日志表")
public class Log implements Serializable{
	/**
	 * ID
	 */
	@Schema(description = "ID")
	private String id;

	/**
	 * 用户ID
	 */
	@Schema(description = "用户ID")
	private String userId;

	/**
	 * 用户请求数据
	 */
	@Schema(description = "用户请求数据")
	private String data;

	/**
	 * 请求地址
	 */
	@Schema(description = "请求地址")
	private String url;

	/**
	 * 用户IP
	 */
	@Schema(description = "用户IP")
	private String ip;

	/**
	 * 是否成功
	 */
	@Schema(description = "是否成功")
	private Integer success;

	/**
	 * 创建时间
	 */
	@Schema(description = "创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
	 * 日志类型
	 */
	@Schema(description = "日志类型")
	private String logType;

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

	@Override
	public String toString() {
		return "ID:" + (id == null ? "空" : id) + ",用户ID:" + (userId == null ? "空" : userId) + ",用户请求数据:" + (data == null ? "空" : data) + ",请求地址:" + (url == null ? "空" : url) + ",用户IP:" + (ip == null ? "空" : ip) + ",是否成功:" + (success == null ? "空" : success) + ",创建时间:" + (createTime == null ? "空" : DateUtils.format(createTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_ss.getPattern())) + ",日志类型:" + (logType == null ? "空" : logType) ;
	}

}