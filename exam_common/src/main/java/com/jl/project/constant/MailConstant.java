package com.jl.project.constant;

/**
 * 邮件通用变量
 */
public class MailConstant {
    /**
     * 默认使用验证码模板（此模板id是0）
     */
    public static final Integer CODE_TMPL = 0;

    /**
     * 默认使用考试通知模板（此模板id是1）
     */
    public static final Integer NOTIFICATION_TMPL = 1;

    /**
     * 验证码长度
     */
    public static final Integer LENGTH_5 = 5;

    /**
     * redis保存验证码前缀
     */
    public static final String CODE_PREFIX = "user:code:";


}
