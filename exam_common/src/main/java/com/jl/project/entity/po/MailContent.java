package com.jl.project.entity.po;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 邮件主体
 */
@Schema(description = "邮件主体")
public class MailContent {
    /**
     * 邮件标题
     */
    @Schema(description = "邮件标题")
    private String subject;

    /**
     * 邮件内容
     */
    @Schema(description = "邮件内容")
    private String context;

    /**
     * 邮件接收者
     */
    @Schema(description = "邮件接收者")
    private String toEmail;


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }
}
