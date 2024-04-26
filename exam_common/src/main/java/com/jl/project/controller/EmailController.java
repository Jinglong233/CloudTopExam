package com.jl.project.controller;

import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.dto.CheckEmailCodeDTO;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.service.EmailService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 邮件相关接口
 */
@RestController
@RequestMapping("/email")
public class EmailController extends ABaseController{

    @Resource
    private EmailService emailService;

    @RequestMapping("checkCode")
    @GlobalInterceptor(checkLogin = false, checkParams = true)
    public ResponseVO checkCode(@RequestBody @VerifyParam CheckEmailCodeDTO emailCodeDTO) {
        Boolean result = emailService.checkCode(emailCodeDTO.getEmail(), emailCodeDTO.getCode());
        return getSuccessResponseVO(result);
    }


}
