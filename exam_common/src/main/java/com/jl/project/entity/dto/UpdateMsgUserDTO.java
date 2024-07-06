package com.jl.project.entity.dto;

import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.po.MsgUser;

/**
 * @Author jingLong
 * @Date 2024-05-12 12:59
 **/
public class UpdateMsgUserDTO {

    @VerifyParam(require = true)
    private String id;
    @VerifyParam(require = true)
    private MsgUser msgUser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MsgUser getMsgUser() {
        return msgUser;
    }

    public void setMsgUser(MsgUser msgUser) {
        this.msgUser = msgUser;
    }
}
