package com.jl.project.controller;

import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.dto.UpdateMsgUserDTO;
import com.jl.project.entity.po.Msg;
import com.jl.project.entity.po.MsgUser;
import com.jl.project.entity.query.MsgUserQuery;
import com.jl.project.entity.query.SimplePage;
import com.jl.project.entity.vo.MsgVO;
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
public class MsgUserController extends ABaseController {

    @Resource
    private MsgUserService msgUserService;

    /**
     * 查询未读消息的数量
     */
    @RequestMapping("getMyUnreadCount")
    @GlobalInterceptor(checkLogin = true)
    public ResponseVO getMyUnreadCount() {
        Integer result = msgUserService.getMyUnreadCount();
        return getSuccessResponseVO(result);
    }

    /**
     * 获取通知
     */
    @RequestMapping("getNotification")
    @GlobalInterceptor(checkLogin = true)
    public ResponseVO getNotification(@RequestBody SimplePage simplePage) {
        PaginationResultVO<MsgVO> result = msgUserService.getNotification(simplePage);
        return getSuccessResponseVO(result);
    }

    /**
     * 获取已读通知
     */
    @RequestMapping("getReadNotification")
    @GlobalInterceptor(checkLogin = true)
    public ResponseVO getReadNotification(@RequestBody SimplePage simplePage) {
        PaginationResultVO<MsgVO> result = msgUserService.getReadNotification(simplePage);
        return getSuccessResponseVO(result);
    }

    /**
     * 获取未读通知
     */
    @RequestMapping("getUnReadNotification")
    @GlobalInterceptor(checkLogin = true)
    public ResponseVO getUnReadNotification(@RequestBody SimplePage simplePage) {
        PaginationResultVO<MsgVO> result = msgUserService.getUnReadNotification(simplePage);
        return getSuccessResponseVO(result);
    }

    /**
     * 获取公告
     */
    @RequestMapping("getAnnouncement")
    @GlobalInterceptor(checkLogin = true)
    public ResponseVO getAnnouncement() {
        List<Msg> result = msgUserService.getAnnouncement();
        return getSuccessResponseVO(result);
    }


    /**
     * 分页查询消息
     */
    @RequestMapping("loadDataList")
    @GlobalInterceptor(checkLogin = true, checkAdmin = true, checkParams = true)
    public ResponseVO loadDatalist(@RequestBody MsgUserQuery query) {
        PaginationResultVO result = msgUserService.loadDatalist(query);
        return getSuccessResponseVO(result);
    }

    /**
     * 新增
     */
    @RequestMapping("add")
    @GlobalInterceptor(checkLogin = true, checkAdmin = true, checkParams = true)
    public ResponseVO add(MsgUser bean) {
        return getSuccessResponseVO(this.msgUserService.add(bean));
    }

    /**
     * 批量新增
     */
    @RequestMapping("addBatch")
    @GlobalInterceptor(checkLogin = true, checkAdmin = true, checkParams = true)
    public ResponseVO addBatch(@RequestBody List<MsgUser> listBean) {
        return getSuccessResponseVO(this.msgUserService.addBatch(listBean));
    }

    /**
     * 批量新增或修改
     */
    @RequestMapping("addOrUpdateBatch")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO addOrUpdateBatch(@RequestBody List<MsgUser> listBean) {
        return getSuccessResponseVO(this.msgUserService.addOrUpdateBatch(listBean));
    }

    /**
     * 根据Id查询
     */

    @RequestMapping("getMsgUserById")
    @GlobalInterceptor(checkLogin = true, checkAdmin = true, checkParams = true)
    public ResponseVO getMsgUserById(String id) {
        return getSuccessResponseVO(this.msgUserService.getMsgUserById(id));
    }

    /**
     * 根据Id更新
     */
    @RequestMapping("updateMsgUserById")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO updateMsgUserById(@RequestBody @VerifyParam(require = true) UpdateMsgUserDTO updateMsgUserDTO) {
        Integer result = msgUserService.updateMsgUserById(updateMsgUserDTO.getMsgUser(), updateMsgUserDTO.getId());
        return getSuccessResponseVO(result > 0);
    }

    /**
     * 根据Id删除
     */
    @RequestMapping("deleteMsgUserById")
    @GlobalInterceptor(checkLogin = true, checkAdmin = true, checkParams = true)
    public ResponseVO deleteMsgUserById(String id) {
        this.msgUserService.deleteMsgUserById(id);
        return getSuccessResponseVO(null);
    }

}