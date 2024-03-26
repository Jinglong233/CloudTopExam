package com.jl.project.entity.query;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @Description:角色表查询对象
 * @author:jingLong
 * @date:2023/11/22
 */
@Schema(description = "角色表查询对象")
public class RoleQuery extends BaseQuery{
	/**
	 * ID
	 */
	@Schema(description = "ID")
	private String id;

	@Schema(hidden = true)
	private String idFuzzy;

	/**
	 * 角色名称
	 */
	@Schema(description = "角色名称")
	private String roleName;

	@Schema(hidden = true)
	private String roleNameFuzzy;

	/**
	 * 备注
	 */
	@Schema(description = "备注")
	private String remark;

	@Schema(hidden = true)
	private String remarkFuzzy;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setIdFuzzy(String idFuzzy) {
		this.idFuzzy = idFuzzy;
	}

	public String getIdFuzzy() {
		return this.idFuzzy;
	}

	public void setRoleNameFuzzy(String roleNameFuzzy) {
		this.roleNameFuzzy = roleNameFuzzy;
	}

	public String getRoleNameFuzzy() {
		return this.roleNameFuzzy;
	}

	public void setRemarkFuzzy(String remarkFuzzy) {
		this.remarkFuzzy = remarkFuzzy;
	}

	public String getRemarkFuzzy() {
		return this.remarkFuzzy;
	}

}