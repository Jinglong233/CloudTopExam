package com.jl.project.entity.vo;

import com.jl.project.entity.po.Msg;
import com.jl.project.entity.po.MsgUser;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 消息视图对象
 */
@Schema(description = "消息视图对象")
public class MsgVO extends Msg {
    /**
     * 消息-用户关联表
     */
    @Schema(description = "消息-用户关联表")
    private MsgUser msgUser;


    public MsgUser getMsgUser() {
        return msgUser;
    }

    public void setMsgUser(MsgUser msgUser) {
        this.msgUser = msgUser;
    }
}
