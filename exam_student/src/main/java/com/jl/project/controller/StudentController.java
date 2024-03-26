package com.jl.project.controller;

import com.jl.project.entity.dto.UpdateUserDTO;
import com.jl.project.entity.po.User;
import com.jl.project.entity.query.LoginQuery;
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
    public ResponseVO login(@RequestBody LoginQuery user) throws BusinessException {
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
    public ResponseVO getLoginUserInfo() {
        User result = null;
        try {
            result = studentService.getLoginUserInfo();
        } catch (BusinessException e) {
            return getErrorResponseVO(null, e.getCode(), e.getMessage());
        }
        return getSuccessResponseVO(result);
    }

    /**
     * 新增（注册）
     */
    @ApiOperation(value = "学生注册（预留）")
    @RequestMapping("register")
    public ResponseVO register(@RequestBody User bean) throws BusinessException {
        Boolean result = this.studentService.register(bean);
        return getSuccessResponseVO(result, "添加成功");
    }

    /**
     * 根据Id更新
     */
    @ApiOperation(value = "学生更新个人信息")
    @RequestMapping("updateUserById")
    public ResponseVO updateUserById(@RequestBody UpdateUserDTO updateUserDTO) throws BusinessException {
        Boolean result = studentService.updateUserById(updateUserDTO);
        return getSuccessResponseVO(result, "更新成功");
    }

    /**
     * 根据Id删除
     */
    @ApiOperation(value = "学生注销账户")
    @RequestMapping("deleteUserById")
    public ResponseVO deleteUserById(@RequestBody String id) throws BusinessException {
        Boolean result = studentService.deleteUserById(id);
        return getSuccessResponseVO(result, result ? "删除成功" : "删除失败");
    }

    /**
     * 头像上传
     *
     * @param file
     */
    @ApiOperation(value = "学生头像上传")
    @PostMapping("/upload/avatar")
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