package com.jl.project.controller;

import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.dto.LoginDTO;
import com.jl.project.entity.dto.RetrievePasswordDTO;
import com.jl.project.entity.dto.UpdateUserDTO;
import com.jl.project.entity.dto.UpdateUserPasswordDTO;
import com.jl.project.entity.po.User;
import com.jl.project.entity.vo.LoginResponseVo;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.exception.BusinessException;
import com.jl.project.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Description:学生Controller
 * @author:jingLong
 * @date:2023/11/12
 */
@Api(tags = "学生登录、登出相关")
@RestController
@RequestMapping("/student")
public class StudentController extends ABaseController {
    @Resource
    private StudentService studentService;


    /**
     * 登录
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "学生登录")
    @RequestMapping("login")
    @GlobalInterceptor(checkLogin = false, checkParams = true)
    public ResponseVO login(@RequestBody @VerifyParam LoginDTO user) throws BusinessException {
        LoginResponseVo result = studentService.login(user);
        return getSuccessResponseVO(result, "登录成功");
    }

    /**
     * 退出登录
     *
     * @return
     */
    @ApiOperation(value = "学生退出登录")
    @RequestMapping("logout")
    @GlobalInterceptor(checkLogin = true)
    public ResponseVO logout() {
        Boolean result = studentService.logout();
        return getSuccessResponseVO(result, "退出成功");
    }

    /**
     * 通过token获取登录用户信息
     *
     * @return
     */
    @ApiOperation(value = "学生获取个人信息")
    @RequestMapping("info")
    @GlobalInterceptor(checkLogin = true, checkStudent = true)
    public ResponseVO getLoginUserInfo() {
        User result = studentService.getLoginUserInfo();
        return getSuccessResponseVO(result);
    }


    /**
     * 根据Id更新
     */
    @ApiOperation(value = "学生更新个人信息")
    @RequestMapping("updateUserById")
    @GlobalInterceptor(checkLogin = true, checkParams = true, checkStudent = true)
    public ResponseVO updateUserById(@RequestBody @VerifyParam UpdateUserDTO updateUserDTO) throws BusinessException {
        Boolean result = studentService.updateUserById(updateUserDTO);
        return getSuccessResponseVO(result, "更新成功");
    }


    /**
     * 修改密码
     *
     * @return
     */
    @ApiOperation(value = "修改密码")
    @RequestMapping("updateUserPassword")
    @GlobalInterceptor(checkLogin = true, checkStudent = true, checkParams = true)
    public ResponseVO updateUserPassword(@RequestBody @VerifyParam(require = true) UpdateUserPasswordDTO updateUserPasswordDTO) throws BusinessException {
        Boolean result = studentService.updateUserPassword(updateUserPasswordDTO);
        return getSuccessResponseVO(result);
    }


    /**
     * 根据Id删除
     */
    @ApiOperation(value = "学生注销账户(预留)")
    @RequestMapping("deleteUserById")
    @GlobalInterceptor(checkLogin = true, checkStudent = true, checkParams = true)
    public ResponseVO deleteUserById(@RequestBody @VerifyParam(require = true) String id) throws BusinessException {
        Boolean result = studentService.deleteUserById(id);
        return getSuccessResponseVO(result, result ? "删除成功" : "删除失败");
    }


    /**
     * 获取找回密码邮箱验证码
     *
     * @param retrievePasswordDTO
     * @return
     * @throws BusinessException
     */
    @ApiOperation(value = "获取找回密码邮箱验证码")
    @RequestMapping("getRetrievePasswordCode")
    @GlobalInterceptor(checkLogin = false, checkParams = true)
    public ResponseVO getRetrievePasswordCode(@RequestBody @VerifyParam(require = true) RetrievePasswordDTO retrievePasswordDTO) throws BusinessException {
        Boolean result = studentService.getRetrievePasswordCode(retrievePasswordDTO);
        return getSuccessResponseVO(result);
    }


    /**
     * 找回密码
     *
     * @return
     */
    @ApiOperation(value = "找回密码")
    @RequestMapping("retrievePassword")
    @GlobalInterceptor(checkLogin = false, checkParams = true)
    public ResponseVO retrievePassword(@RequestBody @VerifyParam(require = true) RetrievePasswordDTO retrievePasswordDTO) throws BusinessException {
        Boolean result = studentService.retrievePassword(retrievePasswordDTO);
        return getSuccessResponseVO(result);
    }


    /**
     * 头像上传
     *
     * @param file
     */
    @ApiOperation(value = "学生头像上传")
    @PostMapping("/upload/avatar")
    @GlobalInterceptor(checkLogin = true, checkStudent = true, checkParams = true)
    public ResponseVO uploadAvatar(@RequestParam("file") MultipartFile file) {
        String result = null;
        try {
            result = studentService.uploadAvatar(file);
        } catch (IOException | BusinessException e) {
            return getErrorResponseVO("上传出错", 400, e.getMessage());
        }
        return getSuccessResponseVO(result);
    }


}