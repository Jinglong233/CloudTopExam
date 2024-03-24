package com.jl.project.controller;

import com.jl.project.entity.po.MsgUser;
import com.jl.project.entity.query.MsgUserQuery;
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
	 * 根据条件分页查询
	 */
	@RequestMapping("loadDataList")
	public ResponseVO loadDatalist(MsgUserQuery query) {
		return getSuccessResponseVO(msgUserService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("add")
	public ResponseVO add(MsgUser bean) {
		return getSuccessResponseVO(this.msgUserService.add(bean));
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("addBatch")
	public ResponseVO addBatch(@RequestBody List<MsgUser> listBean) {
		return getSuccessResponseVO(this.msgUserService.addBatch(listBean));
	}

	/**
	 * 批量新增或修改
	 */
	@RequestMapping("addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<MsgUser> listBean) {
		return getSuccessResponseVO(this.msgUserService.addOrUpdateBatch(listBean));
	}

	/**
	 * 根据Id查询
	 */

	@RequestMapping("getMsgUserById")
	public ResponseVO getMsgUserById(String id) {
		return getSuccessResponseVO(this.msgUserService.getMsgUserById(id));
	}

	/**
	 * 根据Id更新
	 */
	@RequestMapping("updateMsgUserById")
	public ResponseVO updateMsgUserById(MsgUser bean, String id) {
		return getSuccessResponseVO(this.msgUserService.updateMsgUserById(bean, id));
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("deleteMsgUserById")
	public ResponseVO deleteMsgUserById(String id) {
		this.msgUserService.deleteMsgUserById(id);
		return getSuccessResponseVO(null);
	}

}