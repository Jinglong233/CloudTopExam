package com.jl.project.controller;

import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.dto.CheckEmailCodeDTO;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.enums.VerifyRegexEnum;
import com.jl.project.exception.BusinessException;
import com.jl.project.service.EmailService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 邮件相关接口
 */
@RestController
@RequestMapping("/email")
public class EmailController extends ABaseController {

    @Resource
    private EmailService emailService;

    /**
     * 检查验证码
     *
     * @param emailCodeDTO
     * @return
     */
    @RequestMapping("checkCode")
    @GlobalInterceptor(checkLogin = false, checkParams = true)
    public ResponseVO checkCode(@RequestBody @VerifyParam CheckEmailCodeDTO emailCodeDTO) {
        Boolean result = emailService.checkCode(emailCodeDTO.getEmail(), emailCodeDTO.getCode());
        return getSuccessResponseVO(result);
    }


    /**
     * 获取邮箱验证码
     *
     * @return
     */
    @ApiOperation(value = "获取解绑邮箱验证码")
    @RequestMapping("getUnBindEmailCode")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO getUnBindEmailCode() throws BusinessException {
        Boolean result = emailService.getUnBindEmailCode();
        return getSuccessResponseVO(result);
    }

    /**
     * 获取绑定邮箱验证码
     *
     * @return
     */
    @ApiOperation(value = "获取绑定邮箱验证码")
    @RequestMapping("getBindEmailCode")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO getBindEmailCode(@RequestBody @VerifyParam(require = true, regex = VerifyRegexEnum.EMAIL) String email) throws BusinessException {
        Boolean result = emailService.getBindEmailCode(email);
        return getSuccessResponseVO(result);
    }


    /**
     * 绑定邮箱
     *
     * @return
     */
    @ApiOperation(value = "绑定邮箱操作")
    @RequestMapping("bindUserEmail")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO bindUserEmail(@RequestBody @VerifyParam CheckEmailCodeDTO checkEmailCodeDTO) throws BusinessException {
        Boolean result = emailService.bindUserEmail(checkEmailCodeDTO);
        return getSuccessResponseVO(result);
    }

    /**
     * 解绑邮箱操作
     *
     * @return
     */
    @ApiOperation(value = "解绑邮箱操作")
    @RequestMapping("unBindUserEmail")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO unBindUserEmail(@RequestBody @VerifyParam CheckEmailCodeDTO checkEmailCodeDTO) throws BusinessException {
        Boolean result = emailService.unBindUserEmail(checkEmailCodeDTO);
        return getSuccessResponseVO(result);
    }


}
