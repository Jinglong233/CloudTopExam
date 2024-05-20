package com.jl.project.controller;

import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.po.LoginLog;
import com.jl.project.entity.query.LoginLogQuery;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.service.LoginLogService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:登录日志表Controller
 * @author:jingLong
 * @date:2024/05/13
 */
@RestController
@RequestMapping("/loginLog")
public class LoginLogController extends ABaseController{

	@Resource
	private LoginLogService loginLogService;

	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("loadDataList")
	@GlobalInterceptor(checkLogin = true,checkParams = true,checkAdmin = true)
	public ResponseVO loadDatalist(@RequestBody @VerifyParam(require = true) LoginLogQuery query) {
		return getSuccessResponseVO(loginLogService.findListByPage(query));
	}


	/**
	 * 批量删除
	 */
	@RequestMapping("deleteBatch")
	@GlobalInterceptor(checkLogin = true,checkParams = true,checkAdmin = true)
	public ResponseVO deleteLoginLogBatchById(@RequestBody List<Integer> deleteList) {
		Boolean result = loginLogService.deleteLoginLogBatchById(deleteList);
		return getSuccessResponseVO(result);
	}


	/**
	 * 新增
	 */
	@RequestMapping("add")
	public ResponseVO add(LoginLog bean) {
		return getSuccessResponseVO(this.loginLogService.add(bean));
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("addBatch")
	public ResponseVO addBatch(@RequestBody List<LoginLog> listBean) {
		return getSuccessResponseVO(this.loginLogService.addBatch(listBean));
	}

	/**
	 * 批量新增或修改
	 */
	@RequestMapping("addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<LoginLog> listBean) {
		return getSuccessResponseVO(this.loginLogService.addOrUpdateBatch(listBean));
	}

	/**
	 * 根据Id查询
	 */

	@RequestMapping("getLoginLogById")
	public ResponseVO getLoginLogById(Integer id) {
		return getSuccessResponseVO(this.loginLogService.getLoginLogById(id));
	}

	/**
	 * 根据Id更新
	 */
	@RequestMapping("updateLoginLogById")
	public ResponseVO updateLoginLogById(LoginLog bean, Integer id) {
		return getSuccessResponseVO(this.loginLogService.updateLoginLogById(bean, id));
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("deleteLoginLogById")
	public ResponseVO deleteLoginLogById(@RequestBody Integer id) {
		this.loginLogService.deleteLoginLogById(id);
		return getSuccessResponseVO(null);
	}

	@RequestMapping("test")
	public ResponseVO test() {
		loginLogService.test(123);
		return getSuccessResponseVO(null);
	}

}