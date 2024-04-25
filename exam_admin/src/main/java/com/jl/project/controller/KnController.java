package com.jl.project.controller;

import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.entity.po.Kn;
import com.jl.project.entity.query.KnQuery;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.service.KnService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:知识点表Controller
 * @author:jingLong
 * @date:2023/11/22
 */
@RestController
@RequestMapping("/kn")
public class KnController extends ABaseController{

	@Resource
	private KnService knService;

	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("loadDataList")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO loadDatalist(KnQuery query) {
		return getSuccessResponseVO(knService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("add")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO add(Kn bean) {
		return getSuccessResponseVO(this.knService.add(bean));
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("addBatch")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO addBatch(@RequestBody List<Kn> listBean) {
		return getSuccessResponseVO(this.knService.addBatch(listBean));
	}

	/**
	 * 批量新增或修改
	 */
	@RequestMapping("addOrUpdateBatch")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO addOrUpdateBatch(@RequestBody List<Kn> listBean) {
		return getSuccessResponseVO(this.knService.addOrUpdateBatch(listBean));
	}

	/**
	 * 根据Id查询
	 */

	@RequestMapping("getKnById")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO getKnById(String id) {
		return getSuccessResponseVO(this.knService.getKnById(id));
	}

	/**
	 * 根据Id更新
	 */
	@RequestMapping("updateKnById")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO updateKnById(Kn bean, String id) {
		return getSuccessResponseVO(this.knService.updateKnById(bean, id));
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("deleteKnById")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO deleteKnById(String id) {
		this.knService.deleteKnById(id);
		return getSuccessResponseVO(null);
	}

}