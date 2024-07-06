package com.jl.project.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.annotation.SaMode;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.OperationLog;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.dto.*;
import com.jl.project.entity.po.User;
import com.jl.project.entity.query.UserQuery;
import com.jl.project.entity.vo.LoginResponseVo;
import com.jl.project.enums.LogType;
import com.jl.project.exception.BusinessException;
import com.jl.project.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @Description:管理用户Controller
 * @author:jingLong
 * @date:2023/11/12
 */
@Api(tags = "管理员管理用户")
@RestController
@RequestMapping("/user")
@SaCheckLogin
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 登录
     *
     * @param loginDTO
     * @return
     */
    @ApiOperation(value = "管理员/教师登录")
    @RequestMapping("login")
    @GlobalInterceptor(checkParams = true)
    @OperationLog(logType = LogType.LOGIN_LOG)
    @SaIgnore
    @SaCheckRole("admin")
    public SaResult login(@RequestBody @VerifyParam LoginDTO loginDTO) {
        LoginResponseVo result = userService.login(loginDTO);
        return SaResult.ok("登录成功").setData(result);
    }

    /**
     * 退出登录
     *
     * @return
     */
    @ApiOperation(value = "管理员/教师退出登录")
    @RequestMapping("logout")
    @SaCheckRole(value = {"admin", "teacher"},mode = SaMode.OR)
    public SaResult logout() {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        String token = request.getHeader("Authorization");
        StpUtil.logoutByTokenValue(token);
        return SaResult.ok("退出成功");
    }

    /**
     * 通过token获取登录用户信息
     *
     * @return
     */
    @ApiOperation(value = "通过token获取登录用户信息")
    @RequestMapping("info")
    @SaCheckRole("admin")
    public SaResult getLoginUserInfo() throws BusinessException {
        LoginResponseVo result = userService.getLoginUserInfo();
        return SaResult.ok().setData(result);
    }

    /**
     * 新增（注册）
     * 本系统注册只有管理员才可以添加用户
     */
    @ApiOperation(value = "注册")
    @RequestMapping("register")
    @GlobalInterceptor(checkParams = true)
    @SaCheckRole("admin")
    public SaResult register(@RequestBody @VerifyParam AddUserDTO addUserDTO) throws BusinessException {
        Boolean result = userService.register(addUserDTO);
        return SaResult.ok().setData(result);
    }

    /**
     * 分页获取用户列表
     *
     * @param query
     * @return
     */
    @RequestMapping("loadUserList")
    @SaCheckRole("admin")
    public SaResult loadDatalist(@RequestBody UserQuery query) {
        return SaResult.ok().setData(userService.findListByPage(query));
    }


    /**
     * 分页获取部门人员
     *
     * @param query
     * @return
     */
    @ApiOperation(value = "分页获取部门人员")
    @RequestMapping("loadDeptUserList")
    @SaCheckRole("admin")
    public SaResult loadDeptUserList(@RequestBody UserQuery query) throws BusinessException {
        return SaResult.ok("获取成功").setData(userService.loadDeptUserList(query));
    }

    /**
     * 根据Id更新用户信息
     */
    @ApiOperation(value = "更新用户信息")
    @RequestMapping("updateUserById")
    @GlobalInterceptor(checkParams = true)
    @SaCheckRole("admin")
    public SaResult updateUserById(@RequestBody @VerifyParam UpdateUserDTO updateUserDTO) throws BusinessException {
        Boolean result = userService.updateUserById(updateUserDTO);
        return SaResult.ok("更新成功").setData(result);
    }

    /**
     * 根据Id删除用户
     */
    @ApiOperation(value = "删除用户")
    @RequestMapping("deleteUserById")
    @GlobalInterceptor( checkParams = true)
    @SaCheckRole("admin")
    public SaResult deleteUserById(@VerifyParam(require = true) @RequestBody String id) throws BusinessException {
        Boolean result = userService.deleteUserById(id);
        return SaResult.ok(result ? "删除成功" : "删除失败").setData(result);
    }


    /**
     * 头像上传
     *
     * @param file
     */
    @ApiOperation(value = "用户上传头像")
    @PostMapping("/upload/avatar")
    @GlobalInterceptor(checkParams = true)
    @SaCheckRole("admin")
    public SaResult uploadAvatar(@RequestParam("file") @VerifyParam(require = true) MultipartFile file) throws BusinessException, IOException {
        return SaResult.ok().setData(userService.uploadAvatar(file));
    }

    /**
     * 根据Id查询用户信息
     */
    @ApiOperation(value = "根据Id查询用户信息")
    @RequestMapping("getUserById")
    @GlobalInterceptor( checkParams = true)
    @SaCheckRole("admin")
    public SaResult getUserById(@RequestBody @VerifyParam(require = true) String id) {
        return SaResult.ok().setData(userService.getUserById(id));
    }

    /**
     * 获取用户总数
     *
     * @return
     */
    @ApiOperation(value = "获取用户总数")
    @RequestMapping("userCount")
    @GlobalInterceptor( checkParams = true)
    @SaCheckRole("admin")
    public SaResult getUserCount(@RequestBody @VerifyParam(require = true) UserQuery userQuery) throws BusinessException {
        Integer result = userService.getUserCount(userQuery);
        return SaResult.ok().setData(result);
    }

    /**
     * 修改用户密码
     *
     * @return
     */
    @ApiOperation(value = "修改用户密码")
    @RequestMapping("updateUserPassword")
    @GlobalInterceptor(checkParams = true)
    @SaCheckRole("admin")
    public SaResult updateUserPassword(@RequestBody @VerifyParam(require = true) UpdateUserPasswordDTO updateUserPasswordDTO) throws BusinessException {
        Boolean result = userService.updateUserPassword(updateUserPasswordDTO);
        return SaResult.ok().setData(result);
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
    @SaIgnore
    public SaResult getRetrievePasswordCode(@RequestBody @VerifyParam(require = true) RetrievePasswordDTO retrievePasswordDTO) throws BusinessException {
        Boolean result = userService.getRetrievePasswordCode(retrievePasswordDTO);
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
    @SaIgnore
    public SaResult retrievePassword(@RequestBody @VerifyParam(require = true) RetrievePasswordDTO retrievePasswordDTO) throws BusinessException {
        Boolean result = userService.retrievePassword(retrievePasswordDTO);
        return SaResult.ok().setData(result);
    }


    /**
     * 批量新增
     */
    @ApiOperation(value = "批量导入用户信息接口（预留）")
    @RequestMapping("addBatch")
    @GlobalInterceptor(checkParams = true)
    @SaCheckRole("admin")
    public SaResult addBatch(@RequestBody @VerifyParam List<User> listBean) {
        return SaResult.ok().setData(this.userService.addBatch(listBean));
    }

    /**
     * 批量新增或修改
     */
    @ApiOperation("批量新增或修改")
    @RequestMapping("addOrUpdateBatch")
    @GlobalInterceptor(checkParams = true)
    @SaCheckRole("admin")
    public SaResult addOrUpdateBatch(@RequestBody @VerifyParam List<User> listBean) {
        return SaResult.ok().setData(this.userService.addOrUpdateBatch(listBean));
    }


}