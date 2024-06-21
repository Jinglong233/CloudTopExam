package com.jl.project.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.util.SaResult;
import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.dto.UpdateMsgUserDTO;
import com.jl.project.entity.po.Msg;
import com.jl.project.entity.po.MsgUser;
import com.jl.project.entity.query.MsgUserQuery;
import com.jl.project.entity.query.SimplePage;
import com.jl.project.entity.vo.MsgVO;
import com.jl.project.entity.vo.PaginationResultVO;
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
@SaCheckLogin
public class MsgUserController {

    @Resource
    private MsgUserService msgUserService;

    /**
     * 查询未读消息的数量
     */
    @RequestMapping("getMyUnreadCount")
public SaResult getMyUnreadCount() {
        Integer result = msgUserService.getMyUnreadCount();
        return SaResult.ok().setData(result);
    }

    /**
     * 获取通知
     */
    @RequestMapping("getNotification")

public SaResult getNotification(@RequestBody SimplePage simplePage) {
        PaginationResultVO<MsgVO> result = msgUserService.getNotification(simplePage);
        return SaResult.ok().setData(result);
    }

    /**
     * 获取已读通知
     */
    @RequestMapping("getReadNotification")
public SaResult getReadNotification(@RequestBody SimplePage simplePage) {
        PaginationResultVO<MsgVO> result = msgUserService.getReadNotification(simplePage);
        return SaResult.ok().setData(result);
    }

    /**
     * 获取未读通知
     */
    @RequestMapping("getUnReadNotification")
public SaResult getUnReadNotification(@RequestBody SimplePage simplePage) {
        PaginationResultVO<MsgVO> result = msgUserService.getUnReadNotification(simplePage);
        return SaResult.ok().setData(result);
    }

    /**
     * 获取公告
     */
    @RequestMapping("getAnnouncement")
public SaResult getAnnouncement() {
        List<Msg> result = msgUserService.getAnnouncement();
        return SaResult.ok().setData(result);
    }


    /**
     * 分页查询消息
     */
    @RequestMapping("loadDataList")
    @GlobalInterceptor(checkParams = true)
public SaResult loadDatalist(@RequestBody MsgUserQuery query) {
        PaginationResultVO result = msgUserService.loadDatalist(query);
        return SaResult.ok().setData(result);
    }

    /**
     * 新增
     */
    @RequestMapping("add")
    @GlobalInterceptor(checkParams = true)
public SaResult add(MsgUser bean) {
        Integer result = this.msgUserService.add(bean);
        return SaResult.ok(result > 0 ? "添加成功" : "添加失败").setData(result);
    }

    /**
     * 批量新增
     */
    @RequestMapping("addBatch")
    @GlobalInterceptor(checkParams = true)
public SaResult addBatch(@RequestBody List<MsgUser> listBean) {
        Integer result = this.msgUserService.addBatch(listBean);
        return SaResult.ok(result > 0 ? "批量添加成功" : "批量添加失败").setData(result);
    }

    /**
     * 批量新增或修改
     */
    @RequestMapping("addOrUpdateBatch")
    @GlobalInterceptor(checkParams = true)
public SaResult addOrUpdateBatch(@RequestBody List<MsgUser> listBean) {
        Integer result = this.msgUserService.addOrUpdateBatch(listBean);
        return SaResult.ok(result > 0 ? "批量添加/更新成功" : "批量添加/更新失败").setData(result);

    }

    /**
     * 根据Id查询
     */

    @RequestMapping("getMsgUserById")
    @GlobalInterceptor(checkParams = true)
public SaResult getMsgUserById(String id) {
        MsgUser result = this.msgUserService.getMsgUserById(id);
        return SaResult.ok().setData(result);
    }

    /**
     * 根据Id更新
     */
    @RequestMapping("updateMsgUserById")
    @GlobalInterceptor(checkParams = true)
public SaResult updateMsgUserById(@RequestBody @VerifyParam(require = true) UpdateMsgUserDTO updateMsgUserDTO) {
        Integer result = msgUserService.updateMsgUserById(updateMsgUserDTO.getMsgUser(), updateMsgUserDTO.getId());
        return SaResult.ok(result > 0 ? "更新成功" : "更新失败");
    }

    /**
     * 根据Id删除
     */
    @RequestMapping("deleteMsgUserById")
    @GlobalInterceptor(checkParams = true)
public SaResult deleteMsgUserById(String id) {
        Integer result = this.msgUserService.deleteMsgUserById(id);
        return SaResult.ok(result > 0 ? "删除成功" : "删除失败");
    }

}