package com.jl.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.jl.project.constant.MailConstant;
import com.jl.project.entity.dto.CheckEmailCodeDTO;
import com.jl.project.entity.po.*;
import com.jl.project.entity.query.*;
import com.jl.project.entity.vo.LoginResponseVo;
import com.jl.project.exception.BusinessException;
import com.jl.project.mapper.*;
import com.jl.project.service.EmailService;
import com.jl.project.utils.MailUtil;
import com.jl.project.utils.StringTools;
import com.jl.project.utils.UserInfoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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



    @Override
    public Boolean checkCode(String email, String code) {
        String rightCode = stringRedisTemplate.opsForValue().get(MailConstant.CODE_PREFIX + email);
        if (rightCode == null) {
            throw new BusinessException("验证码失效");
        }
        if (!rightCode.equals(code)) {
            throw new BusinessException("邮箱验证码不正确");
        }
        // 移除该验证码
        stringRedisTemplate.delete(MailConstant.CODE_PREFIX + email);
        return true;
    }


    @Override
    public Boolean getUnBindEmailCode() throws BusinessException {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginResponseVo loginUserInfo = UserInfoUtil.getLoginUserInfo(request, stringRedisTemplate);
        sendEmailCode(loginUserInfo.getEmail());
        return true;
    }

    @Override
    public Boolean getBindEmailCode(String email) throws BusinessException {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();

        LoginResponseVo loginUserInfo = UserInfoUtil.getLoginUserInfo(request, stringRedisTemplate);
        // 检验登录用户是否已经绑定邮箱
        UserQuery userQuery = new UserQuery();
        userQuery.setEmail(email);
        User user = userMapper.selectById(loginUserInfo.getId());
        if (user == null) {
            throw new BusinessException("该用户信息有误，请联系管理员");
        }

        String oldEmail = user.getEmail();
        if (!StrUtil.isEmpty(oldEmail)) {
            throw new BusinessException("您已绑定邮箱");
        }


        // 查询该邮箱是否被注册过
        userQuery.setEmail(email);
        List<User> list = userMapper.selectList(userQuery);
        if (list != null && list.size() != 0) {
            throw new BusinessException("该邮箱已被绑定");
        }

        // 发送验证码
        return sendEmailCode(email);
    }


    @Override
    public Boolean bindUserEmail(CheckEmailCodeDTO checkEmailCodeDTO) {
        Boolean isRight = checkCode(checkEmailCodeDTO.getEmail(), checkEmailCodeDTO.getCode());
        if (!isRight) {
            throw new BusinessException("验证码错误");
        }

        // 更新该用户的邮箱
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginResponseVo loginUserInfo = UserInfoUtil.getLoginUserInfo(request, stringRedisTemplate);
        String userId = loginUserInfo.getId();
        User user = userMapper.selectById(userId);
        if (user == null) {
            throw new BusinessException("当前登录用户信息有误");
        }
        user.setEmail(checkEmailCodeDTO.getEmail());

        Integer result = userMapper.updateById(user, userId);
        if (result <= 0) {
            throw new BusinessException("邮箱绑定失败");
        }

        LoginResponseVo loginResponseVo = new LoginResponseVo();
        BeanUtil.copyProperties(user, loginResponseVo);
        UserInfoUtil.refreshRedisUserInfo(request, stringRedisTemplate, loginResponseVo);

        return true;
    }


    @Override
    public Boolean unBindUserEmail(CheckEmailCodeDTO checkEmailCodeDTO) {
        Boolean isRight = checkCode(checkEmailCodeDTO.getEmail(), checkEmailCodeDTO.getCode());
        if (!isRight) {
            throw new BusinessException("验证码错误");
        }

        // 更新该用户的邮箱
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginResponseVo loginUserInfo = UserInfoUtil.getLoginUserInfo(request, stringRedisTemplate);
        String userId = loginUserInfo.getId();
        User user = userMapper.selectById(userId);
        if (user == null) {
            throw new BusinessException("当前登录用户信息有误");
        }
        user.setEmail("");

        Integer result = userMapper.updateById(user, userId);
        if (result <= 0) {
            throw new BusinessException("邮箱解绑失败");
        }
        LoginResponseVo loginResponseVo = new LoginResponseVo();
        BeanUtil.copyProperties(user, loginResponseVo);
        UserInfoUtil.refreshRedisUserInfo(request, stringRedisTemplate, loginResponseVo);

        return true;
    }

    @Override
    public void sendNotification(String toEmail, Msg msg) {
        MailContent mailContent = new MailContent();
        mailContent.setSubject(msg.getTemplId());
        mailContent.setContext(msg.getContent());
        mailContent.setToEmail(toEmail);
        // 发送邮件通知
        MailUtil.sendMail(mailContent, javaMailSender, from);
    }

}