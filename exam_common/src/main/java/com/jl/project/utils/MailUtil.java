package com.jl.project.utils;

import com.jl.project.entity.po.MailContent;
import com.jl.project.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 邮件工具类
 */
public class MailUtil {
    private static final Logger logger = LoggerFactory.getLogger(MailUtil.class);

    /**
     * 群发邮件
     *
     * @param mailContent
     */
    public static final void groupEmail(MailContent mailContent, JavaMailSender javaMailSender, String from) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(from);
            List<String> emailList = mailContent.getEmailList();
            String[] toEmail = emailList.toArray(new String[0]);
            // 接收者
            simpleMailMessage.setTo(toEmail);
            // 邮件标题
            simpleMailMessage.setSubject(mailContent.getSubject());
            // 邮件内容
            simpleMailMessage.setText(mailContent.getContext());
            // 发送
            simpleMailMessage.setSentDate(new Date());
            logger.info("开始群发邮件");
            javaMailSender.send(simpleMailMessage);
            logger.info("群发邮件结束");
        } catch (Throwable e) {
            String[] invalid = getInvalidAddresses(e);
            logger.info("群发失败：" + Arrays.asList(invalid));
            if (invalid != null) {
                List<String> excludeList = Arrays.asList(invalid);
                List<String> emailList = mailContent.getEmailList();
                // 开始单个发送
                if (emailList != null && !emailList.isEmpty()) {
                    logger.info("开始尝试单个发送");
                    for (String toEmail : emailList) {
                        boolean contains = excludeList.contains(toEmail);
                        if (!contains) {
                            mailContent.setToEmail(toEmail);
                            MailUtil.sendMail(mailContent, javaMailSender, from);
                            logger.info(from + " To " + toEmail + " 发送成功");
                        }

                    }
                }


            }

        }
    }

    /**
     * 单发邮件
     *
     * @param mailContent
     */
    public static void sendMail(MailContent mailContent, JavaMailSender javaMailSender, String from) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            // 发送者
            helper.setFrom(from);
            // 接收者
            helper.setTo(mailContent.getToEmail());
            // 邮件标题
            helper.setSubject(mailContent.getSubject());
            // 邮件内容
            helper.setText(mailContent.getContext());
            // 发送
            helper.setSentDate(new Date());
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new BusinessException("邮件发送失败");
        }

    }

    /**
     * 从异常获取无效地址
     *
     * @param e
     * @return
     */
    public static String[] getInvalidAddresses(Throwable e) {
        if (e == null) {
            return null;
        }
        if (e instanceof MailSendException) {
            System.out.println("e instanceof SendFailedException");
            Exception[] exceptions = ((MailSendException) e).getMessageExceptions();
            for (Exception exception : exceptions) {
                if (exception instanceof SendFailedException) {
                    return getStringAddress(((SendFailedException) exception).getInvalidAddresses());
                }
            }
        }
        if (e instanceof SendFailedException) {
            return getStringAddress(((SendFailedException) e).getInvalidAddresses());
        }
        return null;
    }

    /**
     * 将Address[]转成String[]
     *
     * @param address
     * @return
     */
    public static String[] getStringAddress(Address[] address) {
        List<String> invalid = new ArrayList<>();
        for (Address a : address) {
            String aa = ((InternetAddress) a).getAddress();
            if (!StringUtils.isEmpty(aa)) {
                invalid.add(aa);
            }
        }
        return invalid.stream().distinct().toArray(String[]::new);
    }
}
