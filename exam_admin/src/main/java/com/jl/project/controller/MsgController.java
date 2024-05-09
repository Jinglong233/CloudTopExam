package com.jl.project.controller;

import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.dto.SendMessageDTO;
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
	 * 发送消息
	 */
	@RequestMapping("sendMessage")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO sendMessage(@RequestBody @VerifyParam(require = true) SendMessageDTO sendMessageDTO) {
		Boolean result = msgService.sendMessage(sendMessageDTO);
		return getSuccessResponseVO(result);
	}

	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("loadDataList")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO loadDatalist(@RequestBody MsgQuery query) {
		return getSuccessResponseVO(msgService.findListByPage(query));
	}



	/**
	 * 批量新增
	 */
	@RequestMapping("addBatch")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO addBatch(@RequestBody List<Msg> listBean) {
		return getSuccessResponseVO(this.msgService.addBatch(listBean));
	}

	/**
	 * 批量新增或修改
	 */
	@RequestMapping("addOrUpdateBatch")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO addOrUpdateBatch(@RequestBody List<Msg> listBean) {
		return getSuccessResponseVO(this.msgService.addOrUpdateBatch(listBean));
	}

	/**
	 * 根据Id查询
	 */

	@RequestMapping("getMsgById")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO getMsgById(String id) {
		return getSuccessResponseVO(this.msgService.getMsgById(id));
	}

	/**
	 * 根据Id更新
	 */
	@RequestMapping("updateMsgById")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO updateMsgById(Msg bean, String id) {
		return getSuccessResponseVO(this.msgService.updateMsgById(bean, id));
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("deleteMsgById")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true, checkParams = true)
	public ResponseVO deleteMsgById(String id) {
		this.msgService.deleteMsgById(id);
		return getSuccessResponseVO(null);
	}

}