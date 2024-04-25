package com.jl.project.controller;

import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.po.QuAnswer;
import com.jl.project.entity.query.QuAnswerQuery;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.service.QuAnswerService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:题目答案表Controller
 * @author:jingLong
 * @date:2023/11/22
 */
@RestController
@RequestMapping("/quAnswer")
public class QuAnswerController extends ABaseController{

	@Resource
	private QuAnswerService quAnswerService;

	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("loadDataList")
	@GlobalInterceptor(checkLogin = true,checkParams = true)
	public ResponseVO loadDatalist(@RequestBody QuAnswerQuery query) {
		return getSuccessResponseVO(quAnswerService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("add")
	@GlobalInterceptor(checkLogin = true,checkParams = true)
	public ResponseVO add(@RequestBody QuAnswer bean) {
		return getSuccessResponseVO(this.quAnswerService.add(bean));
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("addBatch")
	@GlobalInterceptor(checkLogin = true,checkParams = true)
	public ResponseVO addBatch(@RequestBody List<QuAnswer> listBean) {
		return getSuccessResponseVO(this.quAnswerService.addBatch(listBean));
	}

	/**
	 * 批量新增或修改
	 */
	@RequestMapping("addOrUpdateBatch")
	@GlobalInterceptor(checkLogin = true,checkParams = true)
	public ResponseVO addOrUpdateBatch(@RequestBody List<QuAnswer> listBean) {
		return getSuccessResponseVO(this.quAnswerService.addOrUpdateBatch(listBean));
	}

	/**
	 * 根据Id查询
	 */

	@RequestMapping("getQuAnswerById")
	@GlobalInterceptor(checkLogin = true,checkParams = true)
	public ResponseVO getQuAnswerById(String id) {
		return getSuccessResponseVO(this.quAnswerService.getQuAnswerById(id));
	}

	/**
	 * 根据Id更新
	 */
	@RequestMapping("updateQuAnswerById")
	@GlobalInterceptor(checkLogin = true,checkParams = true)
	public ResponseVO updateQuAnswerById(QuAnswer bean, String id) {
		return getSuccessResponseVO(this.quAnswerService.updateQuAnswerById(bean, id));
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("deleteQuAnswerById")
	@GlobalInterceptor(checkLogin = true,checkParams = true)
	public ResponseVO deleteQuAnswerById(@RequestBody @VerifyParam(require = true) String id) {
		this.quAnswerService.deleteQuAnswerById(id);
		return getSuccessResponseVO(null);
	}

}