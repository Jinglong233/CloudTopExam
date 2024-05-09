package com.jl.project.controller;

import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.dto.*;
import com.jl.project.entity.po.User;
import com.jl.project.entity.query.UserQuery;
import com.jl.project.entity.vo.LoginResponseVo;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.exception.BusinessException;
import com.jl.project.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
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
public class UserController extends ABaseController {

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
    @GlobalInterceptor(checkParams = true, checkLogin = false)
    public ResponseVO login(@RequestBody @VerifyParam LoginDTO loginDTO) {
        LoginResponseVo result = userService.login(loginDTO);
        return getSuccessResponseVO(result, "登录成功");
    }

    /**
     * 退出登录
     *
     * @return
     */
    @ApiOperation(value = "管理员/教师退出登录")
    @RequestMapping("logout")
    @GlobalInterceptor(checkLogin = true)
    public ResponseVO logout() {
        Boolean result = userService.logout();
        return getSuccessResponseVO(result, "退出成功");
    }

    /**
     * 通过token获取登录用户信息
     *
     * @return
     */
    @ApiOperation(value = "通过token获取登录用户信息")
    @RequestMapping("info")
    @GlobalInterceptor(checkLogin = true)
    public ResponseVO getLoginUserInfo() throws BusinessException {
        LoginResponseVo result = userService.getLoginUserInfo();
        return getSuccessResponseVO(result);
    }

    /**
     * 新增（注册）
     */
    @ApiOperation(value = "注册")
    @RequestMapping("register")
    @GlobalInterceptor(checkLogin = true, checkAdmin = true, checkParams = true)
    public ResponseVO register(@RequestBody @VerifyParam AddUserDTO addUserDTO) throws BusinessException {
        Boolean result = userService.register(addUserDTO);
        return getSuccessResponseVO(result, "添加成功");
    }

    /**
     * 分页获取用户列表
     *
     * @param query
     * @return
     */
    @RequestMapping("loadUserList")
    @GlobalInterceptor(checkLogin = true, checkAdmin = true)
    public ResponseVO loadDatalist(@RequestBody UserQuery query) {
        return getSuccessResponseVO(userService.findListByPage(query));
    }


    /**
     * 分页获取部门人员
     *
     * @param query
     * @return
     */
    @ApiOperation(value = "分页获取部门人员")
    @RequestMapping("loadDeptUserList")
    @GlobalInterceptor(checkLogin = true, checkAdmin = true)
    public ResponseVO loadDeptUserList(@RequestBody UserQuery query) throws BusinessException {
        PaginationResultVO result = userService.loadDeptUserList(query);
        return getSuccessResponseVO(result, "获取成功");
    }

    /**
     * 根据Id更新用户信息
     */
    @ApiOperation(value = "更新用户信息")
    @RequestMapping("updateUserById")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO updateUserById(@RequestBody @VerifyParam UpdateUserDTO updateUserDTO) throws BusinessException {
        Boolean result = userService.updateUserById(updateUserDTO);
        return getSuccessResponseVO(result, "更新成功");
    }

    /**
     * 根据Id删除用户
     */
    @ApiOperation(value = "删除用户")
    @RequestMapping("deleteUserById")
    @GlobalInterceptor(checkLogin = true, checkAdmin = true, checkParams = true)
    public ResponseVO deleteUserById(@VerifyParam(require = true) @RequestBody String id) throws BusinessException {
        Boolean result = userService.deleteUserById(id);
        return getSuccessResponseVO(result, result ? "删除成功" : "删除失败");
    }


    /**
     * 头像上传
     *
     * @param file
     */
    @ApiOperation(value = "用户上传头像")
    @PostMapping("/upload/avatar")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO uploadAvatar(@RequestParam("file") @VerifyParam(require = true) MultipartFile file) throws BusinessException, IOException {
        Boolean result = userService.uploadAvatar(file);
        return getSuccessResponseVO(result);
    }

    /**
     * 根据Id查询用户信息
     */
    @ApiOperation(value = "根据Id查询用户信息")
    @RequestMapping("getUserById")
    @GlobalInterceptor(checkLogin = true, checkAdmin = true, checkParams = true)
    public ResponseVO getUserById(@RequestBody @VerifyParam(require = true) String id) {
        return getSuccessResponseVO(userService.getUserById(id));
    }

    /**
     * 获取用户总数
     *
     * @return
     */
    @ApiOperation(value = "获取用户总数")
    @RequestMapping("userCount")
    @GlobalInterceptor(checkLogin = true, checkAdmin = true, checkParams = true)
    public ResponseVO getUserCount(@RequestBody @VerifyParam(require = true) UserQuery userQuery) throws BusinessException {
        Integer result = userService.getUserCount(userQuery);
        return getSuccessResponseVO(result);
    }

    /**
     * 修改用户密码
     *
     * @return
     */
    @ApiOperation(value = "修改用户密码")
    @RequestMapping("updateUserPassword")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO updateUserPassword(@RequestBody @VerifyParam(require = true) UpdateUserPasswordDTO updateUserPasswordDTO) throws BusinessException {
        Boolean result = userService.updateUserPassword(updateUserPasswordDTO);
        return getSuccessResponseVO(result);
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
        Boolean result = userService.getRetrievePasswordCode(retrievePasswordDTO);
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
        Boolean result = userService.retrievePassword(retrievePasswordDTO);
        return getSuccessResponseVO(result);
    }

    // 下面未做

    /**
     * 批量新增
     */
    @ApiOperation(value = "批量导入用户信息接口（预留）")
    @RequestMapping("addBatch")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO addBatch(@RequestBody @VerifyParam List<User> listBean) {
        return getSuccessResponseVO(this.userService.addBatch(listBean));
    }

    /**
     * 批量新增或修改
     */
    @RequestMapping("addOrUpdateBatch")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO addOrUpdateBatch(@RequestBody @VerifyParam List<User> listBean) {
        return getSuccessResponseVO(this.userService.addOrUpdateBatch(listBean));
    }


}