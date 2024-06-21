package com.jl.project.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.util.SaResult;
import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.dto.SendMessageDTO;
import com.jl.project.entity.po.Msg;
import com.jl.project.entity.query.MsgQuery;
import com.jl.project.entity.vo.PaginationResultVO;
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
@SaCheckLogin
public class MsgController {

    @Resource
    private MsgService msgService;

    /**
     * 发送消息
     */
    @RequestMapping("sendMessage")
    @GlobalInterceptor(checkParams = true)
    @SaCheckRole("admin")
    public SaResult sendMessage(@RequestBody @VerifyParam(require = true) SendMessageDTO sendMessageDTO) {
        Boolean result = msgService.sendMessage(sendMessageDTO);
        return SaResult.ok(result ? "发送成功" : "发送失败").setData(result);
    }

    /**
     * 根据条件分页查询
     */
    @RequestMapping("loadDataList")
    @GlobalInterceptor(checkParams = true)
    @SaCheckRole("admin")
    public SaResult loadDatalist(@RequestBody MsgQuery query) {
        PaginationResultVO<Msg> result = msgService.findListByPage(query);
        return SaResult.ok().setData(result);

    }


    /**
     * 批量新增
     */
    @RequestMapping("addBatch")
    @GlobalInterceptor(checkParams = true)
    public SaResult addBatch(@RequestBody List<Msg> listBean) {
        Integer result = this.msgService.addBatch(listBean);
        return SaResult.ok(result > 0 ? "批量添加成功" : "批量添加失败").setData(result);
    }

    /**
     * 批量新增或修改
     */
    @RequestMapping("addOrUpdateBatch")
    @GlobalInterceptor(checkParams = true)
    public SaResult addOrUpdateBatch(@RequestBody List<Msg> listBean) {
        Integer result = this.msgService.addOrUpdateBatch(listBean);
        return SaResult.ok(result > 0 ? "批量添加/更新成功" : "批量添加/更新失败").setData(result);
    }

    /**
     * 根据Id查询
     */

    @RequestMapping("getMsgById")
    @GlobalInterceptor(checkParams = true)
    public SaResult getMsgById(String id) {
        Msg result = this.msgService.getMsgById(id);
        return SaResult.ok().setData(result);
    }

    /**
     * 根据Id更新
     */
    @RequestMapping("updateMsgById")
    @GlobalInterceptor(checkParams = true)
    public SaResult updateMsgById(Msg bean, String id) {
        Integer result = this.msgService.updateMsgById(bean, id);
        return SaResult.ok(result > 0 ? "更新成功" : "更新失败");

    }

    /**
     * 根据Id删除
     */
    @RequestMapping("deleteMsgById")
    @GlobalInterceptor(checkParams = true)
    public SaResult deleteMsgById(String id) {
        Integer result = this.msgService.deleteMsgById(id);
        return SaResult.ok(result > 0 ? "删除成功" : "删除失败");
    }

}