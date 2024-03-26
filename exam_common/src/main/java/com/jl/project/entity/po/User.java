package com.jl.project.entity.po;

import java.io.Serializable;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;
import com.jl.project.enums.DateTimePatternEnum;
import com.jl.project.utils.DateUtils;

/**
 * @Description:用户表
 * @author:jingLong
 * @date:2023/12/04
 */
@Schema(description = "用户表")
public class User implements Serializable{
	/**
	 * ID
	 */
	@Schema(description = "ID")
	private String id;

	/**
	 * 用户名
	 */
	@Schema(description = "用户名")
	private String userName;

	/**
	 * 头像
	 */
	@Schema(description = "头像")
	private String avatar;

	/**
	 * 邮箱
	 */
	@Schema(description = "邮箱")
	private String email;

	/**
	 * 部门编号
	 */
	@Schema(description = "部门编号")
	private String deptCode;

	/**
	 * 部门名称
	 */
	@Schema(description = "部门名称")
	private String deptText;

	/**
	 * 状态0:正常1:禁用
	 */
	@Schema(description = "状态0:正常1:禁用")
	private Integer state;

	/**
	 * 性别0:女1:男
	 */
	@Schema(description = "性别0:女1:男")
	private Integer sex;

	/**
	 * 手机
	 */
	@Schema(description = "手机")
	private String phone;

	/**
	 * 密码
	 */
	@Schema(description = "密码")
	private String password;

	/**
	 * 盐值
	 */
	@Schema(description = "盐值")
	private String salt;

	/**
	 * 真实姓名
	 */
	@Schema(description = "真实姓名")
	private String realName;

	/**
	 * 角色
	 */
	@Schema(description = "角色")
	private String role;

	/**
	 * 创建时间
	 */
	@Schema(description = "创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
	 * 创建者
	 */
	@Schema(description = "创建者")
	private String createBy;

	/**
	 * 更新时间
	 */
	@Schema(description = "更新时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

	/**
	 * 更新者
	 */
	@Schema(description = "更新者")
	private String updateBy;

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

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptCode() {
		return this.deptCode;
	}

	public void setDeptText(String deptText) {
		this.deptText = deptText;
	}

	public String getDeptText() {
		return this.deptText;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getState() {
		return this.state;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRole() {
		return this.role;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getUpdateBy() {
		return this.updateBy;
	}

	@Override
	public String toString() {
		return "ID:" + (id == null ? "空" : id) + ",用户名:" + (userName == null ? "空" : userName) + ",头像:" + (avatar == null ? "空" : avatar) + ",邮箱:" + (email == null ? "空" : email) + ",部门编号:" + (deptCode == null ? "空" : deptCode) + ",部门名称:" + (deptText == null ? "空" : deptText) + ",状态0:正常1:禁用:" + (state == null ? "空" : state) + ",性别0:女1:男:" + (sex == null ? "空" : sex) + ",手机:" + (phone == null ? "空" : phone) + ",密码:" + (password == null ? "空" : password) + ",盐值:" + (salt == null ? "空" : salt) + ",真实姓名:" + (realName == null ? "空" : realName) + ",角色:" + (role == null ? "空" : role) + ",创建时间:" + (createTime == null ? "空" : DateUtils.format(createTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_ss.getPattern())) + ",创建者:" + (createBy == null ? "空" : createBy) + ",更新时间:" + (updateTime == null ? "空" : DateUtils.format(updateTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_ss.getPattern())) + ",更新者:" + (updateBy == null ? "空" : updateBy) ;
	}

}