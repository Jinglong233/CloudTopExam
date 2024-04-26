package com.jl.project.service.impl;

import com.jl.project.constant.MailConstant;
import com.jl.project.entity.po.*;
import com.jl.project.entity.query.*;
import com.jl.project.exception.BusinessException;
import com.jl.project.mapper.*;
import com.jl.project.service.EmailService;
import com.jl.project.utils.CommonUtil;
import com.jl.project.utils.MailUtil;
import com.jl.project.utils.StringTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.jl.project.utils.MailUtil.sendMail;


/**
 * 邮箱发送消息Service
 */
@Service("emailService")
public class EmailServiceImpl implements EmailService {
    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);


    @Resource
    private UserMapper<User, UserQuery> userMapper;

    @Resource
    private MsgMapper<Msg, MsgQuery> msgMapper;

    @Resource
    private MsgUserMapper<MsgUser, MsgUserQuery> msgUserMapper;


    @Resource
    private ExamRecordMapper<ExamRecord, ExamRecordQuery> examRecordMapper;

    @Resource
    private JavaMailSender javaMailSender;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private TmplMapper<Tmpl, TmplQuery> tmplMapper;


    @Value("${spring.mail.username}")
    private String from;


    @Override
    @Transactional
    public Boolean sendEmailCode(String email) {
        // 验证码（不用做持久化，时间到了就销毁）
        String code = StringTools.getRandomNumber(MailConstant.LENGTH_5);
        MailContent mailContent = new MailContent();
        // 使用验证码模板
        Tmpl tmpl = tmplMapper.selectById(MailConstant.CODE_TMPL.toString());
        String title = tmpl.getTitle();
        mailContent.setSubject(title);
        String content = tmpl.getContent();
        // code是验证码，第三个参数是验证码有效时间（时间单位是分钟）
        mailContent.setContext(String.format(content, code, 1));
        mailContent.setToEmail(email);

        // 需要将此验证码存到redis
        Boolean ifAbsent = stringRedisTemplate.opsForValue().setIfAbsent(MailConstant.CODE_PREFIX + email, code, 1, TimeUnit.MINUTES);
        if (!ifAbsent) {
            throw new BusinessException("验证码已发送");
        }
        // 发送验证码
        sendMail(mailContent, javaMailSender, from);
        return true;
    }


    @Transactional
    @Override
    public void setExamNotification(Exam exam) {

        MailContent mailContent = new MailContent();
        // 使用考试通知验证码
        Tmpl tmpl = tmplMapper.selectById(MailConstant.NOTIFICATION_TMPL.toString());
        String title = tmpl.getTitle();
        mailContent.setSubject(title);
        String tmplContent = tmpl.getContent();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String startTime = simpleDateFormat.format(exam.getStartTime());
        String endTime = simpleDateFormat.format(exam.getEndTime());
        String mailContext = String.format(tmplContent, exam.getTitle(), startTime, endTime);
        mailContent.setContext(mailContext);

        // 查询该场考试关联的所有考生
        ExamRecordQuery examRecordQuery = new ExamRecordQuery();
        examRecordQuery.setExamId(exam.getId());
        List<ExamRecord> examRecords = examRecordMapper.selectList(examRecordQuery);

        List<String> userEmailList = new ArrayList<>();
        // 生成MsgId
        String msgId = CommonUtil.getRandomId();
        if (examRecords != null && !examRecords.isEmpty()) {
            // 发送通知成功总数
            Integer successCount = 0;
            for (ExamRecord examRecord : examRecords) {
                String userId = examRecord.getUserId();
                User user = userMapper.selectById(userId);
                if (user != null) { // 有邮箱才发送邮件通知
                    String toEmail = user.getEmail();
                    if (toEmail != null && !"".equals(toEmail.trim())) {
                        userEmailList.add(toEmail);
                       /* mailContent.setToEmail(toEmail);
                        // 发送邮件
                        MailUtil.sendMail(mailContent,javaMailSender,from);*/
                        // 存储发送考试通知消息记录
                        MsgUser msgUser = new MsgUser();
                        msgUser.setId(CommonUtil.getRandomId());
                        msgUser.setMsgId(msgId);
                        // 未读状态
                        msgUser.setState(0);
                        msgUser.setUserId(userId);
                        // 插入消息考试关联表
                        Integer insert = msgUserMapper.insert(msgUser);
                        if (insert <= 0) {
                            throw new BusinessException("消息保存失败");
                        }
                    }
                }
            }

            // 发送邮件通知
            mailContent.setEmailList(userEmailList);
            MailUtil.groupEmail(mailContent, javaMailSender, from);

            // 插入考试消息记录
            Msg msg = new Msg();
            msg.setId(msgId);
            msg.setContent(mailContext);
            msg.setState(1);
            msg.setReadCount(0);
            msg.setTemplId(tmpl.getId());
            msg.setSendCount(examRecords.size());
            msg.setSendTime(new Date());
            msg.setTitle(tmpl.getTitle());
            msg.setCreateUser(exam.getCreateBy());
            User user = userMapper.selectById(exam.getCreateBy());
            if (user == null) {
                throw new BusinessException("创建考试用户不存在");
            }
            msg.setCreateUserText(user.getUserName());
            Integer insert = msgMapper.insert(msg);
            if (insert <= 0) {
                throw new BusinessException("考试通知失败");
            }
        }
    }

    @Override
    public Boolean checkCode(String email, String code) {
        String rightCode = stringRedisTemplate.opsForValue().get(MailConstant.CODE_PREFIX + email);
        if(rightCode==null){
            throw new BusinessException("验证码失效");
        }
        if (!rightCode.equals(code)) {
            throw new BusinessException("邮箱验证码不正确");
        }
        // 移除该验证码
        stringRedisTemplate.delete(MailConstant.CODE_PREFIX + email);
        return true;
    }


}