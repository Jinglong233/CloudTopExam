package com.jl.project.entity.po;

import java.io.Serializable;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;
import com.jl.project.enums.DateTimePatternEnum;
import com.jl.project.utils.DateUtils;

/**
 * @Description:题库
 * @author:jingLong
 * @date:2023/12/04
 */
@Schema(description = "题库")
public class Repo implements Serializable{
	/**
	 * ID
	 */
	@Schema(description = "ID")
	private String id;

	/**
	 * 部门编码（专业）
	 */
	@Schema(description = "部门编码（专业）")
	private String deptCode;

	/**
	 * 部门名称
	 */
	@Schema(description = "部门名称")
	private String deptText;

	/**
	 * 学科ID
	 */
	@Schema(description = "学科ID")
	private String subjectId;

	/**
	 * 学科名称
	 */
	@Schema(description = "学科名称")
	private String subjectText;

	/**
	 * 总题数
	 */
	@Schema(description = "总题数")
	private Integer totalCount;

	/**
	 * 主观题数
	 */
	@Schema(description = "主观题数")
	private Integer subCount;

	/**
	 * 客观题数
	 */
	@Schema(description = "客观题数")
	private Integer objCount;

	/**
	 * 题库标题
	 */
	@Schema(description = "题库标题")
	private String title;

	/**
	 * 是否用于考试
	 */
	@Schema(description = "是否用于考试")
	private Integer isExam;

	/**
	 * 是否用于训练
	 */
	@Schema(description = "是否用于训练")
	private Integer isTrain;

	/**
	 * 备注
	 */
	@Schema(description = "备注")
	private String remark;

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

	@Override
	public String toString() {
		return "ID:" + (id == null ? "空" : id) + ",部门编码（专业）:" + (deptCode == null ? "空" : deptCode) + ",部门名称:" + (deptText == null ? "空" : deptText) + ",学科ID:" + (subjectId == null ? "空" : subjectId) + ",学科名称:" + (subjectText == null ? "空" : subjectText) + ",总题数:" + (totalCount == null ? "空" : totalCount) + ",主观题数:" + (subCount == null ? "空" : subCount) + ",客观题数:" + (objCount == null ? "空" : objCount) + ",题库标题:" + (title == null ? "空" : title) + ",是否用于考试:" + (isExam == null ? "空" : isExam) + ",是否用于训练:" + (isTrain == null ? "空" : isTrain) + ",备注:" + (remark == null ? "空" : remark) + ",创建时间:" + (createTime == null ? "空" : DateUtils.format(createTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_ss.getPattern())) + ",创建者:" + (createBy == null ? "空" : createBy) + ",更新时间:" + (updateTime == null ? "空" : DateUtils.format(updateTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_ss.getPattern())) + ",更新者:" + (updateBy == null ? "空" : updateBy) ;
	}

}