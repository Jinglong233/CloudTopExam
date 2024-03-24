package com.jl.project.controller;

import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.enums.ResponseCodeEnum;
import org.springframework.stereotype.Repository;

public class ABaseController {
    protected static final String STATUC_SUCCESS = "success";
    protected static final String STATUC_ERROR = "error";

    protected <T> ResponseVO getSuccessResponseVO(T t) {
        ResponseVO<T> responseVO = new ResponseVO<>();
        responseVO.setStatus(STATUC_SUCCESS);
        responseVO.setCode(ResponseCodeEnum.CODE_200.getCode());
        responseVO.setInfo(ResponseCodeEnum.CODE_200.getMsg());
        responseVO.setData(t);
        return responseVO;
    }

    protected <T> ResponseVO getSuccessResponseVO(T t, String message) {
        ResponseVO<T> responseVO = new ResponseVO<>();
        responseVO.setStatus(STATUC_SUCCESS);
        responseVO.setCode(ResponseCodeEnum.CODE_200.getCode());
        responseVO.setInfo(message);
        responseVO.setData(t);
        return responseVO;
    }

    protected <T> ResponseVO getErrorResponseVO(T t, Integer code, String message) {
        ResponseVO<T> responseVO = new ResponseVO<>();
        responseVO.setStatus(STATUC_ERROR);
        responseVO.setCode(code);
        responseVO.setInfo(message);
        responseVO.setData(t);
        return responseVO;
    }
}
