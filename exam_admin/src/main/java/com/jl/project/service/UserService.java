package com.jl.project.service;

import com.jl.project.entity.dto.*;
import com.jl.project.entity.po.User;
import com.jl.project.entity.query.UserQuery;
import com.jl.project.entity.vo.LoginResponseVo;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.exception.BusinessException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @Description:管理用户Service
 * @author:jingLong
 * @date:2023/11/12
 */
public interface UserService {

    /**
     * 根据条件查询列表
     */
    List<User> findListByParam(UserQuery query);

    /**
     * 根据条件查询数量
     */
    Integer findCountByParam(UserQuery param);

    /**
     * 分页查询
     */
    PaginationResultVO<User> findListByPage(UserQuery query);

    /**
     * 新增（注册）
     */
    Boolean register(AddUserDTO addUserDTO) throws BusinessException;

    /**
     * 批量新增
     */
    Integer addBatch(List<User> listBean);

    /**
     * 批量新增或修改
     */
    Integer addOrUpdateBatch(List<User> listBean);

    /**
     * 根据Id查询
     */
    User getUserById(String id);

    /**
     * 根据Id更新
     */
    Boolean updateUserById(UpdateUserDTO updateUserDTO) throws BusinessException;

    /**
     * 根据Id删除
     */
    Boolean deleteUserById(String id) throws BusinessException;


    /**
     * 登录
     *
     * @param user
     * @return
     * @throws BusinessException
     */
    LoginResponseVo login(LoginDTO user) throws BusinessException;

    /**
     * 通过token获取登录用户信息
     *
     * @return
     */
    LoginResponseVo getLoginUserInfo() throws BusinessException;

    /**
     * 获取部门所有人员
     *
     * @param query
     * @return
     */
    PaginationResultVO loadDeptUserList(UserQuery query) throws BusinessException;

    /**
     * 头像上传
     *
     * @param file
     * @return
     */
    Boolean uploadAvatar(MultipartFile file) throws BusinessException, IOException;

    /**
     * 退出登录
     *
     * @return
     */
    Boolean logout();

    /**
     * 获取用户总数
     *
     * @return
     */
    Integer getUserCount(UserQuery userQuery);

    Boolean updateUserPassword(UpdateUserPasswordDTO updateUserPasswordDTO);


    Boolean retrievePassword(RetrievePasswordDTO retrievePasswordDTO);


    Boolean getRetrievePasswordCode(RetrievePasswordDTO retrievePasswordDTO);
}