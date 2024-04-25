package com.jl.project.controller;

import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.entity.po.KnQu;
import com.jl.project.entity.query.KnQuQuery;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.service.KnQuService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:题目知识点关联表Controller
 * @author:jingLong
 * @date:2023/11/22
 */
@RestController
@RequestMapping("/knQu")
public class KnQuController extends ABaseController{

	@Resource
	private KnQuService knQuService;

	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("loadDataList")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO loadDatalist(KnQuQuery query) {
		return getSuccessResponseVO(knQuService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("add")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO add(KnQu bean) {
		return getSuccessResponseVO(this.knQuService.add(bean));
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("addBatch")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO addBatch(@RequestBody List<KnQu> listBean) {
		return getSuccessResponseVO(this.knQuService.addBatch(listBean));
	}

	/**
	 * 批量新增或修改
	 */
	@RequestMapping("addOrUpdateBatch")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO addOrUpdateBatch(@RequestBody List<KnQu> listBean) {
		return getSuccessResponseVO(this.knQuService.addOrUpdateBatch(listBean));
	}

	/**
	 * 根据Id查询
	 */

	@RequestMapping("getKnQuById")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO getKnQuById(String id) {
		return getSuccessResponseVO(this.knQuService.getKnQuById(id));
	}

	/**
	 * 根据Id更新
	 */
	@RequestMapping("updateKnQuById")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO updateKnQuById(KnQu bean, String id) {
		return getSuccessResponseVO(this.knQuService.updateKnQuById(bean, id));
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("deleteKnQuById")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO deleteKnQuById(String id) {
		this.knQuService.deleteKnQuById(id);
		return getSuccessResponseVO(null);
	}

}