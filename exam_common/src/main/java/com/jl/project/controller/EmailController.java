package com.jl.project.controller;

import cn.dev33.satoken.util.SaResult;
import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.dto.CheckEmailCodeDTO;
import com.jl.project.enums.VerifyRegexEnum;
import com.jl.project.exception.BusinessException;
import com.jl.project.service.EmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 邮件相关接口
 */
@Api(tags = "邮件发送相关")
@RestController
@RequestMapping("/email")
public class EmailController {

    @Resource
    private EmailService emailService;

    /**
     * 检查验证码
     *
     * @param emailCodeDTO
     * @return
     */
    @ApiOperation("检查验证码")
    @RequestMapping("checkCode")
    @GlobalInterceptor( checkParams = true)
    public SaResult checkCode(@RequestBody @VerifyParam CheckEmailCodeDTO emailCodeDTO) {
        Boolean result = emailService.checkCode(emailCodeDTO.getEmail(), emailCodeDTO.getCode());
        return SaResult.ok().setData(result);
    }


    /**
     * 获取邮箱验证码
     *
     * @return
     */
    @ApiOperation(value = "获取解绑邮箱验证码")
    @RequestMapping("getUnBindEmailCode")
    @GlobalInterceptor(checkParams = true)
    public SaResult getUnBindEmailCode() throws BusinessException {
        Boolean result = emailService.getUnBindEmailCode();
        return SaResult.ok().setData(result);
    }

    /**
     * 获取绑定邮箱验证码
     *
     * @return
     */
    @ApiOperation(value = "获取绑定邮箱验证码")
    @RequestMapping("getBindEmailCode")
    @GlobalInterceptor(checkParams = true)
    public SaResult getBindEmailCode(@RequestBody @VerifyParam(require = true, regex = VerifyRegexEnum.EMAIL) String email) throws BusinessException {
        Boolean result = emailService.getBindEmailCode(email);
        return SaResult.ok().setData(result);
    }


    /**
     * 绑定邮箱
     *
     * @return
     */
    @ApiOperation(value = "绑定邮箱操作")
    @RequestMapping("bindUserEmail")
    @GlobalInterceptor(checkParams = true)
    public SaResult bindUserEmail(@RequestBody @VerifyParam CheckEmailCodeDTO checkEmailCodeDTO) throws BusinessException {
        Boolean result = emailService.bindUserEmail(checkEmailCodeDTO);
        return SaResult.ok().setData(result);
    }

    /**
     * 解绑邮箱操作
     *
     * @return
     */
    @ApiOperation(value = "解绑邮箱操作")
    @RequestMapping("unBindUserEmail")
    @GlobalInterceptor(checkParams = true)
    public SaResult unBindUserEmail(@RequestBody @VerifyParam CheckEmailCodeDTO checkEmailCodeDTO) throws BusinessException {
        Boolean result = emailService.unBindUserEmail(checkEmailCodeDTO);
        return SaResult.ok().setData(result);
    }


}
