package com.jl.project.service;

import com.jl.project.entity.dto.UpdateUserDTO;
import com.jl.project.entity.po.User;
import com.jl.project.entity.query.LoginQuery;
import com.jl.project.entity.query.UserQuery;
import com.jl.project.entity.vo.LoginResponseVo;
import com.jl.project.exception.BusinessException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @Description:管理用户Service
 * @author:jingLong
 * @date:2023/11/12
 */
public interface StudentService {

    /**
     * 根据条件查询列表
     */
    List<User> findListByParam(UserQuery query);


    /**
     * 新增（注册）
     */
    Boolean register(User bean) throws BusinessException;


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
    LoginResponseVo login(LoginQuery user) throws BusinessException;

    /**
     * 通过token获取登录用户信息
     *
     * @return
     */
    User getLoginUserInfo() throws BusinessException;


    /**
     * 头像上传
     *
     * @param file
     * @return
     */
    String uploadAvatar(MultipartFile file) throws BusinessException, IOException;

    /**
     * 退出登录
     *
     * @return
     */
    Boolean logout();


}