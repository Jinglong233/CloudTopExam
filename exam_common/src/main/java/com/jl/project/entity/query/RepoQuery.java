package com.jl.project.entity.query;

import java.util.Date;
/**
 * @Description:题库查询对象
 * @author:jingLong
 * @date:2023/12/04
 */
public class RepoQuery extends BaseQuery{
	/**
	 * ID
	 */
	private String id;

	private String idFuzzy;

	/**
	 * 部门编码（专业）
	 */
	private String deptCode;

	private String deptCodeFuzzy;

	/**
	 * 部门名称
	 */
	private String deptText;

	private String deptTextFuzzy;

	/**
	 * 学科ID
	 */
	private String subjectId;

	private String subjectIdFuzzy;

	/**
	 * 学科名称
	 */
	private String subjectText;

	private String subjectTextFuzzy;

	/**
	 * 总题数
	 */
	private Integer totalCount;

	/**
	 * 主观题数
	 */
	private Integer subCount;

	/**
	 * 客观题数
	 */
	private Integer objCount;

	/**
	 * 题库标题
	 */
	private String title;

	private String titleFuzzy;

	/**
	 * 是否用于考试
	 */
	private Integer isExam;

	/**
	 * 是否用于训练
	 */
	private Integer isTrain;

	/**
	 * 备注
	 */
	private String remark;

	private String remarkFuzzy;

	/**
	 * 创建时间
	 */
	private Date createTime;

	private String createTimeStart;

	private String createTimeEnd;

	/**
	 * 创建者
	 */
	private String createBy;

	private String createByFuzzy;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	private String updateTimeStart;

	private String updateTimeEnd;

	/**
	 * 更新者
	 */
	private String updateBy;

	private String updateByFuzzy;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
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

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectText(String subjectText) {
		this.subjectText = subjectText;
	}

	public String getSubjectText() {
		return this.subjectText;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalCount() {
		return this.totalCount;
	}

	public void setSubCount(Integer subCount) {
		this.subCount = subCount;
	}

	public Integer getSubCount() {
		return this.subCount;
	}

	public void setObjCount(Integer objCount) {
		this.objCount = objCount;
	}

	public Integer getObjCount() {
		return this.objCount;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setIsExam(Integer isExam) {
		this.isExam = isExam;
	}

	public Integer getIsExam() {
		return this.isExam;
	}

	public void setIsTrain(Integer isTrain) {
		this.isTrain = isTrain;
	}

	public Integer getIsTrain() {
		return this.isTrain;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return this.remark;
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

	public void setSubjectIdFuzzy(String subjectIdFuzzy) {
		this.subjectIdFuzzy = subjectIdFuzzy;
	}

	public String getSubjectIdFuzzy() {
		return this.subjectIdFuzzy;
	}

	public void setSubjectTextFuzzy(String subjectTextFuzzy) {
		this.subjectTextFuzzy = subjectTextFuzzy;
	}

	public String getSubjectTextFuzzy() {
		return this.subjectTextFuzzy;
	}

	public void setTitleFuzzy(String titleFuzzy) {
		this.titleFuzzy = titleFuzzy;
	}

	public String getTitleFuzzy() {
		return this.titleFuzzy;
	}

	public void setRemarkFuzzy(String remarkFuzzy) {
		this.remarkFuzzy = remarkFuzzy;
	}

	public String getRemarkFuzzy() {
		return this.remarkFuzzy;
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