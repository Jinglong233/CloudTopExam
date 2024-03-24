package com.jl.project.entity.po;

import java.io.Serializable;


/**
 * @Description:消息模板表
 * @author:jingLong
 * @date:2023/11/22
 */
public class Tmpl implements Serializable{
	/**
	 * ID
	 */
	private String id;

	/**
	 * 模板标题
	 */
	private String title;

	/**
	 * 模板内容
	 */
	private String content;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}

	@Override
	public String toString() {
		return "ID:" + (id == null ? "空" : id) + ",模板标题:" + (title == null ? "空" : title) + ",模板内容:" + (content == null ? "空" : content) ;
	}

}