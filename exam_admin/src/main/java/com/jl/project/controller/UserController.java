package com.jl.project.controller;

import com.jl.project.entity.dto.UpdateEmailDTO;
import com.jl.project.entity.dto.UpdateUserDTO;
import com.jl.project.entity.dto.UpdateUserPasswordDTO;
import com.jl.project.entity.po.User;
import com.jl.project.entity.query.LoginQuery;
import com.jl.project.entity.query.UserQuery;
import com.jl.project.entity.vo.LoginResponseVo;
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
     * @param user
     * @return
     */
    @ApiOperation(value = "管理员/教师登录")
    @RequestMapping("login")
    public ResponseVO login(@RequestBody LoginQuery user) throws BusinessException {
        LoginResponseVo result = userService.login(user);
        return getSuccessResponseVO(result, "登录成功");
    }

    /**
     * 退出登录
     *
     * @return
     */
    @ApiOperation(value = "管理员/教师退出登录")
    @RequestMapping("logout")
    public ResponseVO logout() {
        Boolean result = userService.logout();
        return getSuccessResponseVO(result, "退出成功");
    }

    /**
     * 通过token获取登录用户信息
     *
     * @return
     */
    @ApiOperation(value = "管理员/教师获取个人信息")
    @RequestMapping("info")
    public ResponseVO getLoginUserInfo() {
        User result = null;
        try {
            result = userService.getLoginUserInfo();
        } catch (BusinessException e) {
            return getErrorResponseVO(null, e.getCode(), e.getMessage());
        }
        return getSuccessResponseVO(result);
    }

    /**
     * 新增（注册）
     */
    @ApiOperation(value = "管理员添加用户")
    @RequestMapping("register")
    public ResponseVO register(@RequestBody User bean) throws BusinessException {
        Boolean result = this.userService.register(bean);
        return getSuccessResponseVO(result, "添加成功");
    }

    /**
     * 获取部门所有人员
     *
     * @param query
     * @return
     */
    @ApiOperation(value = "管理员获取部分人员列表")
    @RequestMapping("loadDeptUserList")
    public ResponseVO loadDeptUserList(@RequestBody UserQuery query) {
        List<User> result = null;
        try {
            result = userService.loadDeptUserList(query);
        } catch (BusinessException e) {
            return getErrorResponseVO(null, e.getCode(), e.getMessage());
        }
        return getSuccessResponseVO(result, "获取成功");
    }

    /**
     * 根据Id更新
     */
    @ApiOperation(value = "管理员更新用户信息")
    @RequestMapping("updateUserById")
    public ResponseVO updateUserById(@RequestBody UpdateUserDTO updateUserDTO) throws BusinessException {
        Boolean result = userService.updateUserById(updateUserDTO);
        return getSuccessResponseVO(result, "更新成功");
    }

    /**
     * 根据Id删除
     */
    @ApiOperation(value = "管理员删除用户")
    @RequestMapping("deleteUserById")
    public ResponseVO deleteUserById(@RequestBody String id) throws BusinessException {
        Boolean result = userService.deleteUserById(id);
        return getSuccessResponseVO(result, result ? "删除成功" : "删除失败");
    }


    /**
     * 头像上传
     *
     * @param file
     */
    @ApiOperation(value = "管理员/教师上传头像")
    @PostMapping("/upload/avatar")
    public ResponseVO uploadAvatar(@RequestParam("file") MultipartFile file) throws BusinessException, IOException {
        String result = userService.uploadAvatar(file);
        return getSuccessResponseVO(result);
    }

    /**
     * 根据条件分页查询
     */
    @RequestMapping("loadDataList")
    public ResponseVO loadDatalist(@RequestBody UserQuery query) {
        return getSuccessResponseVO(userService.findListByPage(query));
    }


    /**
     * 批量新增
     */
    @ApiOperation(value = "批量导入用户信息接口（预留）")
    @RequestMapping("addBatch")
    public ResponseVO addBatch(@RequestBody List<User> listBean) {
        return getSuccessResponseVO(this.userService.addBatch(listBean));
    }

    /**
     * 批量新增或修改
     */
    @RequestMapping("addOrUpdateBatch")
    public ResponseVO addOrUpdateBatch(@RequestBody List<User> listBean) {
        return getSuccessResponseVO(this.userService.addOrUpdateBatch(listBean));
    }

    /**
     * 根据Id查询
     */
    @ApiOperation(value = "根据用户Id查询用户信息")
    @RequestMapping("getUserById")
    public ResponseVO getUserById(String id) {
        return getSuccessResponseVO(this.userService.getUserById(id));
    }


    /**
     * 获取用户总数
     *
     * @return
     */
    @ApiOperation(value = "获取用户总数")
    @RequestMapping("userCount")
    public ResponseVO getUserCount(@RequestBody UserQuery userQuery) throws BusinessException {
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
    public ResponseVO updateUserPassword(@RequestBody UpdateUserPasswordDTO updateUserPasswordDTO) {
        Boolean result = null;
        try {
            result = userService.updateUserPassword(updateUserPasswordDTO);
        } catch (BusinessException e) {
            return getErrorResponseVO(false, e.getCode(), e.getMessage());
        }
        return getSuccessResponseVO(result);
    }

    /**
     * 获取邮箱验证码
     *
     * @return
     */
    @ApiOperation(value = "获取邮箱验证码")
    @RequestMapping("getEmailCode")
    public ResponseVO getEmailCode(@RequestBody String email) {
        Boolean result = null;
        try {
            result = userService.getEmailCode(email);
        } catch (BusinessException e) {
            return getErrorResponseVO(false, e.getCode(), e.getMessage());
        }
        return getSuccessResponseVO(result);
    }

    /**
     * 更新/绑定邮箱
     *
     * @return
     */
    @ApiOperation(value = "更新/绑定邮箱")
    @RequestMapping("updateUserEmail")
    public ResponseVO updateUserEmail(@RequestBody UpdateEmailDTO updateEmailDTO) {
        Boolean result = null;
        try {
            result = userService.updateUserEmail(updateEmailDTO);
        } catch (BusinessException e) {
            return getErrorResponseVO("更新/绑定失败", e.getCode(), e.getMessage());
        }
        return getSuccessResponseVO(result);
    }


}