package com.jl.project.aspect;

import com.jl.project.annotation.OperationLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

//@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);


    @Resource
    private StringRedisTemplate stringRedisTemplate;



    @Around("@annotation(operationLog)")
    public Object doAround(ProceedingJoinPoint joinPoint, OperationLog operationLog) throws Throwable {
       /* String logDescription = operationLog.description();
        int logType = operationLog.logType().getValue();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        // 操作人
        LoginResponseVo loginUserInfo = UserInfoUtil.getLoginUserInfo(request, stringRedisTemplate);
        String username = loginUserInfo.getUserName();
        //操作人IP
        String ip = request.getRemoteAddr();
        ResponseVO result = null;
        Log log = new Log();
        log.setUserName(username);
        log.setLogType(log.getLogType());
        log.setDescription(logDescription);
        log.setIp(ip);
        log.setCreateTime(new Date());
        // 日志类型
        log.setLogType(logType);
        // 请求接口地址
        log.setOperationMethod(request.getRequestURI());
        // 请求参数
        // 获取所有请求参数
        StringBuilder params = new StringBuilder();
        request.getParameterMap().forEach((key, value) -> {
            params.append(key).append(": ").append(value[0]).append(", ");
        });
        log.setRequestArg(params.toString());
        log.setRequestMode(request.getMethod());
        try {
            result = (ResponseVO) joinPoint.proceed();
            Gson gson = new Gson();
            log.setReturnArg(gson.toJson(result));
            ThreadUtil.execAsync(() -> {
                log.setSuccess(1);
                logService.add(log);
            });
            return result;
        } catch (Throwable e) {
            ThreadUtil.execAsync(() -> {
                log.setSuccess(0);
                logService.add(log);
            });
            throw new RuntimeException(e);
        }*/
        return null;
    }
}
