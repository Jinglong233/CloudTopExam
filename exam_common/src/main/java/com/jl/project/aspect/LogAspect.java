package com.jl.project.aspect;

import cn.dev33.satoken.util.SaResult;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.StrUtil;
import com.google.gson.Gson;
import com.jl.project.annotation.OperationLog;
import com.jl.project.entity.dto.LoginDTO;
import com.jl.project.entity.po.LoginLog;
import com.jl.project.entity.po.OperLog;
import com.jl.project.entity.query.LoginLogQuery;
import com.jl.project.entity.query.OperLogQuery;
import com.jl.project.entity.vo.LoginResponseVo;
import com.jl.project.enums.LogType;
import com.jl.project.enums.LoginLogState;
import com.jl.project.exception.BusinessException;
import com.jl.project.mapper.LoginLogMapper;
import com.jl.project.mapper.OperLogMapper;
import com.jl.project.utils.AddressUtil;
import com.jl.project.utils.UserInfoUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.concurrent.ExecutionException;

@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);


    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private OperLogMapper<OperLog, OperLogQuery> operLogMapper;

    @Resource
    private LoginLogMapper<LoginLog, LoginLogQuery> loginLogMapper;

    @Around("@annotation(operationLog)")
    public SaResult doAround(ProceedingJoinPoint joinPoint, OperationLog operationLog) throws Throwable {
        int logType = operationLog.logType().getValue();
        // 操作日志
        if (LogType.OPERATION_LOG.getValue().equals(logType)) {
            return handleOperationLog(joinPoint, operationLog);
        } else if (LogType.LOGIN_LOG.getValue().equals(logType)) {
            // 登录日志
            return handleLoginLog(joinPoint, operationLog);
        }

        return null;
    }


    /**
     * 处理登录日志
     */
    private SaResult handleLoginLog(ProceedingJoinPoint joinPoint, OperationLog operationLog) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        LoginLog log = new LoginLog();
        Object[] args = joinPoint.getArgs();
        if (args != null) {
            for (Object arg : args) {
                if (arg instanceof LoginDTO) {
                    LoginDTO loginDTO = (LoginDTO) arg;
                    String loginUserName = loginDTO.getUserName();
                    // 设置姓名
                    log.setUserName(loginUserName);
                }
            }
        }

        //操作人IP
        String ip = request.getRemoteAddr();
        SaResult result = null;
        log.setId(null);

        // 设置IP
        log.setIp(ip);


        // 设置登录时间
        log.setLoginTime(new Date());

        // 设置登录地址
        log.setLoginAddress(AddressUtil.getRealAddressByIp(ip));

        try {
            result = (SaResult) joinPoint.proceed();
            log.setOperMsg(LoginLogState.SUCCESS.getType());
            log.setLoginState(LoginLogState.SUCCESS.getValue());
            return result;
        } catch (Throwable e) {
            log.setOperMsg(StrUtil.isEmpty(e.getMessage()) ? LoginLogState.FAIL.getType() : e.getMessage());
            log.setLoginState(LoginLogState.FAIL.getValue());
            throw new BusinessException(e.getMessage());
        } finally {
            Integer insert = ThreadUtil.execAsync(() -> {
                return loginLogMapper.insert(log);
            }).get();
            if (insert <= 0) {
                logger.info("登录日志插入失败");
            } else {
                logger.info("登录日志插入成功");
            }
        }
    }


    /**
     * 处理操作日志
     */
    private SaResult handleOperationLog(ProceedingJoinPoint joinPoint, OperationLog operationLog) throws ExecutionException, InterruptedException {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();

        // 操作人
        LoginResponseVo loginUserInfo = UserInfoUtil.getLoginUserInfo(stringRedisTemplate);
        String username = loginUserInfo.getUserName();


        SaResult result = null;
        OperLog log = new OperLog();

        // 操作人姓名
        log.setUserName(username);

        // 请求的URL
        String requestURI = request.getRequestURL().toString();
        log.setUrl(requestURI);

        //操作人IP
        String ip = request.getRemoteAddr();


        // 请求地址（IP）
        log.setIp(ip);
        // 设置请求地址
        log.setOperAddress(AddressUtil.getRealAddressByIp(ip));

        // 操作时间
        log.setOperTime(new Date());

        // 请求接口地址
        log.setOperationMethod(request.getRequestURI());
        // 请求参数
        // 获取所有请求参数
        StringBuilder params = new StringBuilder();
        request.getParameterMap().forEach((key, value) -> {
            params.append(key).append(": ").append(value[0]).append(", ");
        });
        // 请求的方法
        log.setRequestArg(params.toString());
        // 请求方式
        log.setRequestMode(request.getMethod());
        // 操作类型
        log.setOperType(operationLog.oper().getValue());
        try {
            result = (SaResult) joinPoint.proceed();
            Gson gson = new Gson();
            log.setReturnArg(gson.toJson(result));
            log.setSuccess(1);
            return result;
        } catch (Throwable e) {
            log.setSuccess(0);
            throw new BusinessException(e.getMessage());
        } finally {
            Integer insert = ThreadUtil.execAsync(() -> {
                return operLogMapper.insert(log);
            }).get();
            if (insert <= 0) {
                logger.info("操作日志插入失败");
            } else {
                logger.info("操作日志插入成功");
            }
        }
    }
}
