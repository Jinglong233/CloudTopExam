package com.jl.project.service;

import com.jl.project.entity.dto.CheckEmailCodeDTO;
import com.jl.project.entity.po.Exam;
import com.jl.project.entity.po.Msg;

/**
 * @Description:邮箱验证码Service
 * @author:jingLong
 * @date:2023/09/07
 */
public interface EmailService {


    /**
     * 发送验证码
     *
     * @param email
     * @param type
     */
    Boolean sendEmailCode(String email);


    /**
     * 校验邮箱验证码
     *
     * @param email
     * @param emailCode
     * @return
     */
    Boolean checkCode(String email, String emailCode);

    Boolean getUnBindEmailCode();

    Boolean getBindEmailCode(String email);

    Boolean bindUserEmail(CheckEmailCodeDTO checkEmailCodeDTO);

    Boolean unBindUserEmail(CheckEmailCodeDTO checkEmailCodeDTO);

    /**
     * 发送通知
     *
     */
    void sendNotification(String toEmail, Msg msg);

}