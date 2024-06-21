package com.jl.project.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.util.SaResult;
import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.dto.LoginDTO;
import com.jl.project.entity.dto.RetrievePasswordDTO;
import com.jl.project.entity.dto.UpdateUserDTO;
import com.jl.project.entity.dto.UpdateUserPasswordDTO;
import com.jl.project.entity.po.User;
import com.jl.project.entity.vo.LoginResponseVo;
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

public class StudentController {
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
    @GlobalInterceptor(checkParams = true)
    @SaIgnore
    @SaCheckLogin
    public SaResult login(@RequestBody @VerifyParam LoginDTO user) throws BusinessException {
        LoginResponseVo result = studentService.login(user);
        return SaResult.ok("登录成功").setData(result);
    }

    /**
     * 退出登录
     *
     * @return
     */
    @ApiOperation(value = "学生退出登录")
    @RequestMapping("logout")
    @SaCheckRole("student")
    public SaResult logout() {
        Boolean result = studentService.logout();
        return SaResult.ok(result?"登出成功":"登出失败").setData(result);
    }

    /**
     * 通过token获取登录用户信息
     *
     * @return
     */
    @ApiOperation(value = "学生获取个人信息")
    @RequestMapping("info")
    @SaCheckLogin
    @SaCheckRole("student")
    public SaResult getLoginUserInfo() {
        User result = studentService.getLoginUserInfo();
        return SaResult.ok().setData(result);
    }


    /**
     * 根据Id更新
     */
    @ApiOperation(value = "学生更新个人信息")
    @RequestMapping("updateUserById")
    @GlobalInterceptor(checkParams = true)
    @SaCheckLogin
    @SaCheckRole("student")
    public SaResult updateUserById(@RequestBody @VerifyParam UpdateUserDTO updateUserDTO) throws BusinessException {
        Boolean result = studentService.updateUserById(updateUserDTO);
        return SaResult.ok(result?"更新成功":"更新失败").setData(result);
        
    }


    /**
     * 修改密码
     *
     * @return
     */
    @ApiOperation(value = "修改密码")
    @RequestMapping("updateUserPassword")
    @GlobalInterceptor(checkParams = true)
    @SaCheckLogin
    @SaCheckRole("student")
    public SaResult updateUserPassword(@RequestBody @VerifyParam(require = true) UpdateUserPasswordDTO updateUserPasswordDTO) throws BusinessException {
        Boolean result = studentService.updateUserPassword(updateUserPasswordDTO);
        return SaResult.ok().setData(result);
    }


    /**
     * 根据Id删除
     */
    @ApiOperation(value = "学生注销账户(预留)")
    @RequestMapping("deleteUserById")
    @GlobalInterceptor(checkParams = true)
    @SaCheckLogin
    @SaCheckRole("student")
    public SaResult deleteUserById(@RequestBody @VerifyParam(require = true) String id) throws BusinessException {
        Boolean result = studentService.deleteUserById(id);
        return SaResult.ok(result ? "删除成功" : "删除失败").setData(result);
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
    @GlobalInterceptor(checkParams = true)
    public SaResult getRetrievePasswordCode(@RequestBody @VerifyParam(require = true) RetrievePasswordDTO retrievePasswordDTO) throws BusinessException {
        Boolean result = studentService.getRetrievePasswordCode(retrievePasswordDTO);
        return SaResult.ok().setData(result);
    }


    /**
     * 找回密码
     *
     * @return
     */
    @ApiOperation(value = "找回密码")
    @RequestMapping("retrievePassword")
    @GlobalInterceptor(checkParams = true)
    public SaResult retrievePassword(@RequestBody @VerifyParam(require = true) RetrievePasswordDTO retrievePasswordDTO) throws BusinessException {
        Boolean result = studentService.retrievePassword(retrievePasswordDTO);
        return SaResult.ok().setData(result);
    }


    /**
     * 头像上传
     *
     * @param file
     */
    @ApiOperation(value = "学生头像上传")
    @PostMapping("/upload/avatar")
    @GlobalInterceptor(checkParams = true)
    @SaCheckLogin
    @SaCheckRole("student")
    public SaResult uploadAvatar(@RequestParam("file") @VerifyParam(require = true) MultipartFile file) throws IOException {
        Boolean result  = studentService.uploadAvatar(file);
        return SaResult.ok().setData(result);
    }


}