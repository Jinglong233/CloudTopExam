package com.jl.project.controller;

import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.entity.po.Log;
import com.jl.project.entity.query.LogQuery;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.service.LogService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:日志表Controller
 * @author:jingLong
 * @date:2023/11/22
 */
@RestController
@RequestMapping("/log")
public class LogController extends ABaseController{

	@Resource
	private LogService logService;

	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("loadDataList")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO loadDatalist(LogQuery query) {
		return getSuccessResponseVO(logService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("add")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO add(Log bean) {
		return getSuccessResponseVO(this.logService.add(bean));
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("addBatch")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO addBatch(@RequestBody List<Log> listBean) {
		return getSuccessResponseVO(this.logService.addBatch(listBean));
	}

	/**
	 * 批量新增或修改
	 */
	@RequestMapping("addOrUpdateBatch")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO addOrUpdateBatch(@RequestBody List<Log> listBean) {
		return getSuccessResponseVO(this.logService.addOrUpdateBatch(listBean));
	}

	/**
	 * 根据Id查询
	 */

	@RequestMapping("getLogById")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO getLogById(String id) {
		return getSuccessResponseVO(this.logService.getLogById(id));
	}

	/**
	 * 根据Id更新
	 */
	@RequestMapping("updateLogById")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO updateLogById(Log bean, String id) {
		return getSuccessResponseVO(this.logService.updateLogById(bean, id));
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("deleteLogById")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO deleteLogById(String id) {
		this.logService.deleteLogById(id);
		return getSuccessResponseVO(null);
	}

}