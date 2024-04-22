package com.jl.project.service;

import com.jl.project.entity.po.Exam;

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
     * 发送考试通知
     *
     * @param email
     */
    void setExamNotification(Exam exam);

    /**
     * 校验邮箱验证码
     *
     * @param email
     * @param emailCode
     * @return
     */
    Boolean checkCode(String email, String emailCode);
}