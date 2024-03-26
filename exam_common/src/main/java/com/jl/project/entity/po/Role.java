package com.jl.project.entity.po;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;


/**
 * @Description:角色表
 * @author:jingLong
 * @date:2023/11/22
 */
@Schema(description = "角色表")
public class Role implements Serializable{
	/**
	 * ID
	 */
	@Schema(description = "ID")
	private String id;

	/**
	 * 角色名称
	 */
	@Schema(description = "角色名称")
	private String roleName;

	/**
	 * 备注
	 */
	@Schema(description = "备注")
	private String remark;

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

	@Override
	public String toString() {
		return "ID:" + (id == null ? "空" : id) + ",角色名称:" + (roleName == null ? "空" : roleName) + ",备注:" + (remark == null ? "空" : remark) ;
	}

}