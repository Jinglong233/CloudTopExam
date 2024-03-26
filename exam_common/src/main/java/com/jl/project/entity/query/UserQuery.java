package com.jl.project.entity.query;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;
/**
 * @Description:用户表查询对象
 * @author:jingLong
 * @date:2023/12/04
 */
@Schema(description = "用户表查询对象")
public class UserQuery extends BaseQuery{
	/**
	 * ID
	 */
	@Schema(description = "ID")
	private String id;

	@Schema(hidden = true)
	private String idFuzzy;

	/**
	 * 用户名
	 */
	@Schema(description = "用户名")
	private String userName;

	@Schema(hidden = true)
	private String userNameFuzzy;

	/**
	 * 头像
	 */
	@Schema(description = "头像")
	private String avatar;

	@Schema(hidden = true)
	private String avatarFuzzy;

	/**
	 * 邮箱
	 */
	@Schema(description = "邮箱")
	private String email;

	@Schema(hidden = true)
	private String emailFuzzy;

	/**
	 * 部门编号
	 */
	@Schema(description = "部门编号")
	private String deptCode;

	@Schema(hidden = true)
	private String deptCodeFuzzy;

	/**
	 * 部门名称
	 */
	@Schema(description = "部门名称")
	private String deptText;

	@Schema(hidden = true)
	private String deptTextFuzzy;

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

	@Schema(hidden = true)
	private String phoneFuzzy;

	/**
	 * 密码
	 */
	@Schema(description = "密码")
	private String password;

	@Schema(hidden = true)
	private String passwordFuzzy;

	/**
	 * 盐值
	 */
	@Schema(description = "盐值")
	private String salt;

	@Schema(hidden = true)
	private String saltFuzzy;

	/**
	 * 真实姓名
	 */
	@Schema(description = "真实姓名")
	private String realName;

	@Schema(hidden = true)
	private String realNameFuzzy;

	/**
	 * 角色
	 */
	@Schema(description = "角色")
	private String role;

	@Schema(hidden = true)
	private String roleFuzzy;

	/**
	 * 创建时间
	 */
	@Schema(description = "创建时间")
	private Date createTime;

	@Schema(hidden = true)
	private String createTimeStart;

	@Schema(hidden = true)
	private String createTimeEnd;

	/**
	 * 创建者
	 */
	@Schema(description = "创建者")
	private String createBy;

	@Schema(hidden = true)
	private String createByFuzzy;

	/**
	 * 更新时间
	 */
	@Schema(description = "更新时间")
	private Date updateTime;

	@Schema(hidden = true)
	private String updateTimeStart;

	@Schema(hidden = true)
	private String updateTimeEnd;

	/**
	 * 更新者
	 */
	@Schema(description = "更新者")
	private String updateBy;

	@Schema(hidden = true)
	private String updateByFuzzy;

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

	public void setAvatarFuzzy(String avatarFuzzy) {
		this.avatarFuzzy = avatarFuzzy;
	}

	public String getAvatarFuzzy() {
		return this.avatarFuzzy;
	}

	public void setEmailFuzzy(String emailFuzzy) {
		this.emailFuzzy = emailFuzzy;
	}

	public String getEmailFuzzy() {
		return this.emailFuzzy;
	}

	public void setDeptCodeFuzzy(String deptCodeFuzzy) {
		this.deptCodeFuzzy = deptCodeFuzzy;
	}

	public String getDeptCodeFuzzy() {
		return this.deptCodeFuzzy;
	}

	public void setDeptTextFuzzy(String deptTextFuzzy) {
		this.deptTextFuzzy = deptTextFuzzy;
	}

	public String getDeptTextFuzzy() {
		return this.deptTextFuzzy;
	}

	public void setPhoneFuzzy(String phoneFuzzy) {
		this.phoneFuzzy = phoneFuzzy;
	}

	public String getPhoneFuzzy() {
		return this.phoneFuzzy;
	}

	public void setPasswordFuzzy(String passwordFuzzy) {
		this.passwordFuzzy = passwordFuzzy;
	}

	public String getPasswordFuzzy() {
		return this.passwordFuzzy;
	}

	public void setSaltFuzzy(String saltFuzzy) {
		this.saltFuzzy = saltFuzzy;
	}

	public String getSaltFuzzy() {
		return this.saltFuzzy;
	}

	public void setRealNameFuzzy(String realNameFuzzy) {
		this.realNameFuzzy = realNameFuzzy;
	}

	public String getRealNameFuzzy() {
		return this.realNameFuzzy;
	}

	public void setRoleFuzzy(String roleFuzzy) {
		this.roleFuzzy = roleFuzzy;
	}

	public String getRoleFuzzy() {
		return this.roleFuzzy;
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

	public void setCreateByFuzzy(String createByFuzzy) {
		this.createByFuzzy = createByFuzzy;
	}

	public String getCreateByFuzzy() {
		return this.createByFuzzy;
	}

	public void setUpdateTimeStart(String updateTimeStart) {
		this.updateTimeStart = updateTimeStart;
	}

	public String getUpdateTimeStart() {
		return this.updateTimeStart;
	}

	public void setUpdateTimeEnd(String updateTimeEnd) {
		this.updateTimeEnd = updateTimeEnd;
	}

	public String getUpdateTimeEnd() {
		return this.updateTimeEnd;
	}

	public void setUpdateByFuzzy(String updateByFuzzy) {
		this.updateByFuzzy = updateByFuzzy;
	}

	public String getUpdateByFuzzy() {
		return this.updateByFuzzy;
	}

}