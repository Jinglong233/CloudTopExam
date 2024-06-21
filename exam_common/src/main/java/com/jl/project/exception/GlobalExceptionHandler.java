package com.jl.project.exception;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import cn.dev33.satoken.exception.NotSafeException;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotLoginException.class)
    public SaResult handlerNotLoginException(NotLoginException nle) {
        // 不同异常返回不同状态码
        String message = "";
        if (nle.getType().equals(NotLoginException.NOT_TOKEN)) {
            message = "未提供Token";
        } else if (nle.getType().equals(NotLoginException.INVALID_TOKEN)) {
            message = "未提供有效的Token";
        } else if (nle.getType().equals(NotLoginException.TOKEN_TIMEOUT)) {
            message = "登录信息已过期，请重新登录";
        } else if (nle.getType().equals(NotLoginException.BE_REPLACED)) {
            message = "您的账户已在另一台设备上登录，如非本人操作，请立即修改密码";
        } else if (nle.getType().equals(NotLoginException.KICK_OUT)) {
            message = "已被系统强制下线";
        } else {
            message = "当前会话未登录";
        }
        return SaResult.error(message).setCode(401);
    }

    @ExceptionHandler
    public SaResult handlerNotRoleException(NotRoleException e) {
        return SaResult.error("无此角色：" + e.getRole()).setCode(403);
    }

    @ExceptionHandler
    public SaResult handlerNotPermissionException(NotPermissionException e) {
        return SaResult.error("无此权限：" + e.getCode()).setCode(403);
    }


    @ExceptionHandler
    public SaResult handlerNotSafeException(NotSafeException e) {
        return SaResult.error("二级认证异常：" + e.getMessage()).setCode(401);
    }


}
