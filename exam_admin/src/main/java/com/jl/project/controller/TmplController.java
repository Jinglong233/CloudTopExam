package com.jl.project.controller;

import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.entity.po.Tmpl;
import com.jl.project.entity.query.TmplQuery;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.service.TmplService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:消息模板表Controller
 * @author:jingLong
 * @date:2023/11/22
 */
@RestController
@RequestMapping("/tmpl")
public class TmplController extends ABaseController{

	@Resource
	private TmplService tmplService;

	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("loadDataList")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true,checkParams = true)
	public ResponseVO loadDatalist(TmplQuery query) {
		return getSuccessResponseVO(tmplService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("add")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true,checkParams = true)
	public ResponseVO add(Tmpl bean) {
		return getSuccessResponseVO(this.tmplService.add(bean));
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("addBatch")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true,checkParams = true)
	public ResponseVO addBatch(@RequestBody List<Tmpl> listBean) {
		return getSuccessResponseVO(this.tmplService.addBatch(listBean));
	}

	/**
	 * 批量新增或修改
	 */
	@RequestMapping("addOrUpdateBatch")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true,checkParams = true)
	public ResponseVO addOrUpdateBatch(@RequestBody List<Tmpl> listBean) {
		return getSuccessResponseVO(this.tmplService.addOrUpdateBatch(listBean));
	}

	/**
	 * 根据Id查询
	 */

	@RequestMapping("getTmplById")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true,checkParams = true)
	public ResponseVO getTmplById(String id) {
		return getSuccessResponseVO(this.tmplService.getTmplById(id));
	}

	/**
	 * 根据Id更新
	 */
	@RequestMapping("updateTmplById")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true,checkParams = true)
	public ResponseVO updateTmplById(Tmpl bean, String id) {
		return getSuccessResponseVO(this.tmplService.updateTmplById(bean, id));
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("deleteTmplById")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true,checkParams = true)
	public ResponseVO deleteTmplById(String id) {
		this.tmplService.deleteTmplById(id);
		return getSuccessResponseVO(null);
	}

}