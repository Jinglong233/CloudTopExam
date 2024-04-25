package com.jl.project.controller;

import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.entity.po.MsgUser;
import com.jl.project.entity.query.MsgUserQuery;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.service.MsgUserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:用户消息关联表Controller
 * @author:jingLong
 * @date:2023/11/22
 */
@RestController
@RequestMapping("/msgUser")
public class MsgUserController extends ABaseController{

	@Resource
	private MsgUserService msgUserService;

	/**
	 * 查询未读消息的数量
	 */
	@RequestMapping("getMyUnreadCount")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO getMyUnreadCount(@RequestBody MsgUserQuery query) {
		Integer result = msgUserService.getMyUnreadCount(query);
		return getSuccessResponseVO(result);
	}


	/**
	 * 分页查询消息
	 */
	@RequestMapping("loadDataList")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO loadDatalist(@RequestBody MsgUserQuery query) {
		PaginationResultVO result =  msgUserService.loadDatalist(query);
		return getSuccessResponseVO(result);
	}

	/**
	 * 新增
	 */
	@RequestMapping("add")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO add(MsgUser bean) {
		return getSuccessResponseVO(this.msgUserService.add(bean));
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("addBatch")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO addBatch(@RequestBody List<MsgUser> listBean) {
		return getSuccessResponseVO(this.msgUserService.addBatch(listBean));
	}

	/**
	 * 批量新增或修改
	 */
	@RequestMapping("addOrUpdateBatch")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO addOrUpdateBatch(@RequestBody List<MsgUser> listBean) {
		return getSuccessResponseVO(this.msgUserService.addOrUpdateBatch(listBean));
	}

	/**
	 * 根据Id查询
	 */

	@RequestMapping("getMsgUserById")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO getMsgUserById(String id) {
		return getSuccessResponseVO(this.msgUserService.getMsgUserById(id));
	}

	/**
	 * 根据Id更新
	 */
	@RequestMapping("updateMsgUserById")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO updateMsgUserById(MsgUser bean, String id) {
		return getSuccessResponseVO(this.msgUserService.updateMsgUserById(bean, id));
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("deleteMsgUserById")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO deleteMsgUserById(String id) {
		this.msgUserService.deleteMsgUserById(id);
		return getSuccessResponseVO(null);
	}

}