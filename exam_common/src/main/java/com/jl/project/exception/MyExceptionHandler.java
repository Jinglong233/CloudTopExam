package com.jl.project.exception;

import com.jl.project.controller.ABaseController;
import com.jl.project.entity.vo.ResponseVO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.jl.project.enums.ResponseCodeEnum.CODE_500;

/**
 * 全局异常处理器
 */
@ControllerAdvice
public class MyExceptionHandler extends ABaseController {

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ResponseVO exceptionHandler(BusinessException e) {
        return getErrorResponseVO(null, e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseVO globalHandler(Exception e) {
        return getErrorResponseVO(null, CODE_500.getCode(), CODE_500.getMsg());
    }
}
