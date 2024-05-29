package com.jl.project.entity.po;

import java.io.Serializable;


/**
 * @Description:错题答案表
 * @author:jingLong
 * @date:2024/05/29
 */
public class WrongAnswer implements Serializable{
	/**
	 * ID
	 */
	private Integer id;

	/**
	 * 错题id（非题目id）
	 */
	private String bookId;

	/**
	 * 选项id
	 */
	private String answerId;

	/**
	 * 选项次数
	 */
	private Integer wrongCount;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookId() {
		return this.bookId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	public String getAnswerId() {
		return this.answerId;
	}

	public void setWrongCount(Integer wrongCount) {
		this.wrongCount = wrongCount;
	}

	public Integer getWrongCount() {
		return this.wrongCount;
	}

	@Override
	public String toString() {
		return "ID:" + (id == null ? "空" : id) + ",错题id（非题目id）:" + (bookId == null ? "空" : bookId) + ",选项id:" + (answerId == null ? "空" : answerId) + ",选项次数:" + (wrongCount == null ? "空" : wrongCount) ;
	}

}