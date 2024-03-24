package com.jl.project.controller;

import com.jl.project.entity.po.ExamAnswer;
import com.jl.project.entity.query.ExamAnswerQuery;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.service.ExamAnswerService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:考试答案表Controller
 * @author:jingLong
 * @date:2023/11/22
 */
@RestController
@RequestMapping("/examAnswer")
public class ExamAnswerController extends ABaseController{

	@Resource
	private ExamAnswerService examAnswerService;

	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("loadDataList")
	public ResponseVO loadDatalist(ExamAnswerQuery query) {
		return getSuccessResponseVO(examAnswerService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("add")
	public ResponseVO add(ExamAnswer bean) {
		return getSuccessResponseVO(this.examAnswerService.add(bean));
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("addBatch")
	public ResponseVO addBatch(@RequestBody List<ExamAnswer> listBean) {
		return getSuccessResponseVO(this.examAnswerService.addBatch(listBean));
	}

	/**
	 * 批量新增或修改
	 */
	@RequestMapping("addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<ExamAnswer> listBean) {
		return getSuccessResponseVO(this.examAnswerService.addOrUpdateBatch(listBean));
	}

	/**
	 * 根据Id查询
	 */

	@RequestMapping("getExamAnswerById")
	public ResponseVO getExamAnswerById(String id) {
		return getSuccessResponseVO(this.examAnswerService.getExamAnswerById(id));
	}

	/**
	 * 根据Id更新
	 */
	@RequestMapping("updateExamAnswerById")
	public ResponseVO updateExamAnswerById(ExamAnswer bean, String id) {
		return getSuccessResponseVO(this.examAnswerService.updateExamAnswerById(bean, id));
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("deleteExamAnswerById")
	public ResponseVO deleteExamAnswerById(String id) {
		this.examAnswerService.deleteExamAnswerById(id);
		return getSuccessResponseVO(null);
	}

}