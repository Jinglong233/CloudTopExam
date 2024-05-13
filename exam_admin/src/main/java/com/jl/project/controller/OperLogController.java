package com.jl.project.controller;

import com.jl.project.entity.po.OperLog;
import com.jl.project.entity.query.OperLogQuery;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.service.OperLogService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:操作日志表Controller
 * @author:jingLong
 * @date:2024/05/13
 */
@RestController
@RequestMapping("/operLog")
public class OperLogController extends ABaseController{

	@Resource
	private OperLogService operLogService;

	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("loadDataList")
	public ResponseVO loadDatalist(OperLogQuery query) {
		return getSuccessResponseVO(operLogService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("add")
	public ResponseVO add(OperLog bean) {
		return getSuccessResponseVO(this.operLogService.add(bean));
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("addBatch")
	public ResponseVO addBatch(@RequestBody List<OperLog> listBean) {
		return getSuccessResponseVO(this.operLogService.addBatch(listBean));
	}

	/**
	 * 批量新增或修改
	 */
	@RequestMapping("addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<OperLog> listBean) {
		return getSuccessResponseVO(this.operLogService.addOrUpdateBatch(listBean));
	}

	/**
	 * 根据Id查询
	 */

	@RequestMapping("getOperLogById")
	public ResponseVO getOperLogById(Integer id) {
		return getSuccessResponseVO(this.operLogService.getOperLogById(id));
	}

	/**
	 * 根据Id更新
	 */
	@RequestMapping("updateOperLogById")
	public ResponseVO updateOperLogById(OperLog bean, Integer id) {
		return getSuccessResponseVO(this.operLogService.updateOperLogById(bean, id));
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("deleteOperLogById")
	public ResponseVO deleteOperLogById(Integer id) {
		this.operLogService.deleteOperLogById(id);
		return getSuccessResponseVO(null);
	}

}