package com.jl.project.controller;

import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.entity.po.GlQu;
import com.jl.project.entity.query.GlQuQuery;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.service.GlQuService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:大题题目关联表Controller
 * @author:jingLong
 * @date:2023/11/22
 */
@RestController
@RequestMapping("/glQu")
public class GlQuController extends ABaseController{

	@Resource
	private GlQuService glQuService;

	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("loadDataList")
	@GlobalInterceptor(checkLogin = true, checkParams = true)
	public ResponseVO loadDatalist(GlQuQuery query) {
		return getSuccessResponseVO(glQuService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("add")
	@GlobalInterceptor(checkLogin = true, checkParams = true)
	public ResponseVO add(GlQu bean) {
		return getSuccessResponseVO(this.glQuService.add(bean));
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("addBatch")
	@GlobalInterceptor(checkLogin = true, checkParams = true)
	public ResponseVO addBatch(@RequestBody List<GlQu> listBean) {
		return getSuccessResponseVO(this.glQuService.addBatch(listBean));
	}

	/**
	 * 批量新增或修改
	 */
	@RequestMapping("addOrUpdateBatch")
	@GlobalInterceptor(checkLogin = true, checkParams = true)
	public ResponseVO addOrUpdateBatch(@RequestBody List<GlQu> listBean) {
		return getSuccessResponseVO(this.glQuService.addOrUpdateBatch(listBean));
	}

	/**
	 * 根据Id查询
	 */

	@RequestMapping("getGlQuById")
	@GlobalInterceptor(checkLogin = true, checkParams = true)
	public ResponseVO getGlQuById(String id) {
		return getSuccessResponseVO(this.glQuService.getGlQuById(id));
	}

	/**
	 * 根据Id更新
	 */
	@RequestMapping("updateGlQuById")
	@GlobalInterceptor(checkLogin = true, checkParams = true)
	public ResponseVO updateGlQuById(GlQu bean, String id) {
		return getSuccessResponseVO(this.glQuService.updateGlQuById(bean, id));
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("deleteGlQuById")
	public ResponseVO deleteGlQuById(String id) {
		this.glQuService.deleteGlQuById(id);
		return getSuccessResponseVO(null);
	}

}