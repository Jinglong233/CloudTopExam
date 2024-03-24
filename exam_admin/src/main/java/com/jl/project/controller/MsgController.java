package com.jl.project.controller;

import com.jl.project.entity.po.Msg;
import com.jl.project.entity.query.MsgQuery;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.service.MsgService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:消息表Controller
 * @author:jingLong
 * @date:2023/11/22
 */
@RestController
@RequestMapping("/msg")
public class MsgController extends ABaseController{

	@Resource
	private MsgService msgService;

	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("loadDataList")
	public ResponseVO loadDatalist(MsgQuery query) {
		return getSuccessResponseVO(msgService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("add")
	public ResponseVO add(Msg bean) {
		return getSuccessResponseVO(this.msgService.add(bean));
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("addBatch")
	public ResponseVO addBatch(@RequestBody List<Msg> listBean) {
		return getSuccessResponseVO(this.msgService.addBatch(listBean));
	}

	/**
	 * 批量新增或修改
	 */
	@RequestMapping("addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<Msg> listBean) {
		return getSuccessResponseVO(this.msgService.addOrUpdateBatch(listBean));
	}

	/**
	 * 根据Id查询
	 */

	@RequestMapping("getMsgById")
	public ResponseVO getMsgById(String id) {
		return getSuccessResponseVO(this.msgService.getMsgById(id));
	}

	/**
	 * 根据Id更新
	 */
	@RequestMapping("updateMsgById")
	public ResponseVO updateMsgById(Msg bean, String id) {
		return getSuccessResponseVO(this.msgService.updateMsgById(bean, id));
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("deleteMsgById")
	public ResponseVO deleteMsgById(String id) {
		this.msgService.deleteMsgById(id);
		return getSuccessResponseVO(null);
	}

}