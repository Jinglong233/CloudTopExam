package com.jl.project.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.aliyun.oss.OSSClient;
import com.google.gson.Gson;
import com.jl.project.entity.dto.*;
import com.jl.project.entity.po.Department;
import com.jl.project.entity.po.User;
import com.jl.project.entity.query.DepartmentQuery;
import com.jl.project.entity.query.SimplePage;
import com.jl.project.entity.query.UserQuery;
import com.jl.project.entity.vo.LoginResponseVo;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.enums.PageSize;
import com.jl.project.enums.RoleType;
import com.jl.project.exception.BusinessException;
import com.jl.project.mapper.DepartmentMapper;
import com.jl.project.mapper.UserMapper;
import com.jl.project.service.EmailService;
import com.jl.project.service.UserService;
import com.jl.project.utils.MD5Util;
import com.jl.project.utils.OSSUploadUtil;
import com.jl.project.utils.UserInfoUtil;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.jl.project.constant.UserConstant.USER_PREFIX;


/**
 * @Description:管理用户Service
 * @author:jingLong
 * @date:2023/11/12
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private UserMapper<User, UserQuery> userMapper;

    @Resource
    private DepartmentMapper<Department, DepartmentQuery> departmentMapper;


    @Resource
    private OSSClient ossClient;
    @Resource
    private Environment env;


    @Resource
    private EmailService emailService;


    /**
     * 登录
     *
     * @param user
     * @return
     * @throws BusinessException
     */
    @Override
    public LoginResponseVo login(LoginDTO user) throws BusinessException {
        // 1. 根据用户名查询用户
        UserQuery userQuery = new UserQuery();
        userQuery.setUserName(user.getUserName());

        List<User> list = findListByParam(userQuery);
        if (!list.isEmpty()) {
            // 如果是学生就移出
            // 查询教师/管理员()
            list = list.stream().filter(u -> u.getRole().equals(RoleType.TEACHER.getValue())
                    || u.getRole().equals(RoleType.ADMIN.getValue())
            ).collect(Collectors.toList());
        }

        if (list.isEmpty()) {
            throw new BusinessException("用户不存在");
        }

        User resultUser = list.get(0);
        // 2. 加密
        String encryptPassword = MD5Util.getMD5Encode(user.getPassword(), resultUser.getSalt());

        // 3. 判断加密之后字符串是否相等
        if (!encryptPassword.equals(resultUser.getPassword())) {
            throw new BusinessException("密码错误");
        }

        // 判断该用户是否被禁用
        if (resultUser.getState() == 1) {
            throw new BusinessException("该用户被禁用");
        }

        // 登录
        StpUtil.login(resultUser.getId());

        Gson gson = new Gson();

        stringRedisTemplate.opsForValue().set(USER_PREFIX + resultUser.getId(), gson.toJson(resultUser));

        LoginResponseVo loginResponseVo = new LoginResponseVo();
        BeanUtil.copyProperties(resultUser, loginResponseVo);
        // 4. 设置token
        loginResponseVo.setToken(StpUtil.getTokenValue());
        return loginResponseVo;
    }


    /**
     * 根据条件查询列表
     */
    public List<User> findListByParam(UserQuery query) {
        return this.userMapper.selectList(query);
    }

    /**
     * 根据条件查询数量
     */
    public Integer findCountByParam(UserQuery query) {
        return this.userMapper.selectCount(query);
    }

    /**
     * 分页查询
     */
    public PaginationResultVO<User> findListByPage(UserQuery query) {
        Integer count = this.findCountByParam(query);
        Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
        SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
        query.setSimplePage(page);
        List<User> list = this.findListByParam(query);
        PaginationResultVO<User> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
        return result;
    }

    /**
     * 新增
     */
    @Override
    public Boolean register(AddUserDTO bean) throws BusinessException {
        // 1. 判断是否存在同名用户
        UserQuery userQuery = new UserQuery();
        userQuery.setUserName(bean.getUserName());
        List<User> list = findListByParam(userQuery);
        if (!list.isEmpty()) {
            throw new BusinessException("用户名已存在");
        }
        // 2. 生成随机ID
        String userId = IdUtil.simpleUUID();


        // 3. 处理密码相关（盐 + 密码）
        String password = bean.getPassword();
        String salt = MD5Util.getSalt(password);
        String saltPassword = MD5Util.getMD5Encode(password, salt);
        // 这里的密码是加密之后的
        bean.setPassword(saltPassword);


        // 4. 查询部门信息
        String deptCode = bean.getDeptCode();
        if (deptCode == null || "".equals(deptCode)) {
            throw new BusinessException("部门信息不存在");
        }
        DepartmentQuery departmentQuery = new DepartmentQuery();
        departmentQuery.setDeptCode(deptCode);
        List<Department> departments = departmentMapper.selectList(departmentQuery);
        if (departments == null || departments.size() == 0) {
            throw new BusinessException("部门信息不存在");
        }
        Department department = departments.get(0);
        String deptText = department.getDeptName();


        User user = new User();
        BeanUtil.copyProperties(bean, user);
        user.setId(userId);
        user.setSalt(salt);
        user.setDeptText(deptText);
        user.setCreateTime(new Date());


        LoginResponseVo createUserInfo = UserInfoUtil.getLoginUserInfo(stringRedisTemplate);
        if (createUserInfo == null) {
            throw new BusinessException("缺少创建者信息");
        }
        user.setCreateBy(createUserInfo.getId());

        Integer result = userMapper.insert(user);
        return result > 0;
    }

    /**
     * 批量新增
     */
    public Integer addBatch(List<User> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.userMapper.insertBatch(listBean);
    }

    /**
     * 批量新增或修改
     */
    public Integer addOrUpdateBatch(List<User> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.userMapper.insertOrUpdateBatch(listBean);
    }

    /**
     * 根据Id查询
     */
    public User getUserById(String id) {
        return this.userMapper.selectById(id);
    }

    /**
     * 根据Id更新
     */
    public Boolean updateUserById(UpdateUserDTO updateDeptDTO) throws BusinessException {

        String id = updateDeptDTO.getId();

        // 判断是否是本人
        LoginResponseVo loginUserInfo = UserInfoUtil.getLoginUserInfo(stringRedisTemplate);
        if (!UserInfoUtil.isMySelf(id)) {
            // 如果不是本人，再次得判断是否是管理员
            StpUtil.checkRole("admin");
        }

        // 1. 获取用户的信息
        User user = updateDeptDTO.getUser();
        String password = user.getPassword();
        // 2. 判断是否需要修改密码
        if (password != null && !"".equals(password.trim())) {
            // 2.1 获取密码盐
            User temp = userMapper.selectById(id);
            if (temp == null) {
                throw new BusinessException("更新失败");
            }
            String salt = temp.getSalt();
            String encodePwd = MD5Util.getMD5Encode(password, salt);
            // 2.2 修改密码
            user.setPassword(encodePwd);
        }

        // 判断是否修改部门
        User oldUser = userMapper.selectById(id);
        String oldDeptCode = oldUser.getDeptCode();
        String newDeptCode = user.getDeptCode();
        if (oldDeptCode != newDeptCode) {
            // 更新用户所属部门
            DepartmentQuery departmentQuery = new DepartmentQuery();
            departmentQuery.setDeptCode(newDeptCode);
            List<Department> list = departmentMapper.selectList(departmentQuery);
            if (list == null || list.size() == 0) {
                throw new BusinessException("部门信息错误");
            }
            Department department = list.get(0);
            user.setDeptText(department.getDeptName());
        }

        // 3. 添加更新日期
        user.setUpdateTime(new Date());

        user.setUpdateBy(loginUserInfo.getId());

        // 4. 更新
        Integer result = userMapper.updateById(user, id);

        //  更新redis中缓存的信息
        user = userMapper.selectById(id);
        UserInfoUtil.refreshRedisUserInfo(stringRedisTemplate, user);
        return result > 0;
    }

    /**
     * 根据Id删除
     */
    public Boolean deleteUserById(String id) throws BusinessException {
        User user = userMapper.selectById(id);
        if (user != null) {
            // 判断要删除的用户是否是管理员
            if ("admin".equals(user.getRole())) {
                throw new BusinessException("无权限删除管理员");
            }
        }
        Integer result = userMapper.deleteById(id);
        return result > 0;
    }


    /**
     * 通过token获取登录用户信息
     *
     * @return
     */
    @Override
    public LoginResponseVo getLoginUserInfo() throws BusinessException {
        return UserInfoUtil.getLoginUserInfo(stringRedisTemplate);
    }

    /**
     * 获取部门所有人员
     *
     * @param query
     * @return
     */
    @Override
    public PaginationResultVO loadDeptUserList(UserQuery query) throws BusinessException {
        // 获取当前部门编号（注意：这里使用右模糊查询）
        String deptCode = query.getDeptCodeFuzzy();
        if (deptCode == null) {
            return findListByPage(query);
        }
        UserQuery userQuery = new UserQuery();
        BeanUtil.copyProperties(query, userQuery);
        userQuery.setDeptCode("");
        userQuery.setDeptCodeFuzzy(deptCode);
        return findListByPage(userQuery);
    }

    /**
     * 头像上传
     *
     * @param file
     * @return
     */
    @Override
    public Boolean uploadAvatar(MultipartFile file) throws BusinessException, IOException {
        // 获取登录用户
        LoginResponseVo loginUserInfo = UserInfoUtil.getLoginUserInfo(stringRedisTemplate);

        String userId = loginUserInfo.getId();
        if (userId == null) {
            throw new BusinessException("登录状态错误，请尝试重新登录");
        }

        String url = OSSUploadUtil.uploadImage(ossClient, env, file, userId);

        // 9. 文件路径保存到数据库
        User user = new User();
        user.setAvatar(url);
        Integer result = userMapper.updateById(user, userId);

        if (result <= 0) {
            throw new RuntimeException("上传失败");
        }


        // 刷新用户缓存信息
        user = userMapper.selectById(userId);
        UserInfoUtil.refreshRedisUserInfo(stringRedisTemplate, user);
        return true;
    }


    /**
     * 获取用户总数
     *
     * @return
     */
    @Override
    public Integer getUserCount(UserQuery userQuery) throws BusinessException {
        Integer count = userMapper.selectCount(userQuery);
        return count;
    }

    @Override
    public Boolean updateUserPassword(UpdateUserPasswordDTO updateUserPasswordDTO) throws BusinessException {

        LoginResponseVo loginUserInfo = UserInfoUtil.getLoginUserInfo(stringRedisTemplate);
        // 判断是否是原用户

        if (!UserInfoUtil.isMySelf(updateUserPasswordDTO.getUserId())) {
            // 判断是否是管理员
            StpUtil.checkRole("admin");
        }


        String oldPassword = updateUserPasswordDTO.getOldPassword();
        if (oldPassword == null || "".equals(oldPassword.trim())) {
            throw new BusinessException("原密码错误");
        }

        String userId = updateUserPasswordDTO.getUserId();
        if (userId == null || "".equals(userId.trim())) {
            throw new BusinessException("缺少必要参数");
        }

        User user = userMapper.selectById(userId);
        if (user == null) {
            throw new BusinessException("用户信息不存在");
        }

        // 对比密码
        String rightPassword = user.getPassword();
        String mixPassword = MD5Util.getMD5Encode(oldPassword, user.getSalt());
        if (!rightPassword.equals(mixPassword)) {
            throw new BusinessException("密码错误");
        }

        String newPassword = updateUserPasswordDTO.getNewPassword();
        if (newPassword == null || "".equals(newPassword.trim())) {
            throw new BusinessException("缺少新密码");
        }

        // 更新密码
        String newMIxPassword = MD5Util.getMD5Encode(newPassword, user.getSalt());
        user.setPassword(newMIxPassword);
        user.setUpdateTime(new Date());
        user.setUpdateBy(loginUserInfo.getId());


        //  更新redis中缓存的信息
        user = userMapper.selectById(userId);
        UserInfoUtil.refreshRedisUserInfo(stringRedisTemplate, user);

        Integer result = userMapper.updateById(user, userId);
        return result > 0;
    }


    @Override
    public Boolean retrievePassword(RetrievePasswordDTO retrievePasswordDTO) {
        String password = retrievePasswordDTO.getPassword();
        if (StrUtil.isEmpty(password)) {
            throw new BusinessException("密码为空");
        }
        // 获取邮箱+用户名（唯一凭证）
        String email = retrievePasswordDTO.getEmail();
        if (StrUtil.isEmpty(email)) {
            throw new BusinessException("邮箱信息为空，请尝试重新操作");
        }
        String userName = retrievePasswordDTO.getUserName();
        if (StrUtil.isEmpty(userName)) {
            throw new BusinessException("用户名为空，请尝试重新操作");
        }

        UserQuery userQuery = new UserQuery();
        userQuery.setEmail(email);
        userQuery.setUserName(userName);
        List<User> userList = userMapper.selectList(userQuery);
        if (userList == null || userList.size() == 0) {
            throw new BusinessException("用户信息不存在");
        }
        User user = userList.get(0);
        String newPassword = MD5Util.getMD5Encode(password, user.getSalt());
        user.setPassword(newPassword);
        Integer result = userMapper.updateById(user, user.getId());
        if (result <= 0) {
            throw new BusinessException("更新密码失败");
        }
        //  更新redis中缓存的信息
        user = userMapper.selectById(user.getId());
        UserInfoUtil.refreshRedisUserInfo(stringRedisTemplate, user);
        return true;
    }


    @Override
    public Boolean getRetrievePasswordCode(RetrievePasswordDTO retrievePasswordDTO) {
        // 校验用户
        String userName = retrievePasswordDTO.getUserName();
        UserQuery userQuery = new UserQuery();
        userQuery.setUserName(userName);
        userQuery.setRole(RoleType.ADMIN.getValue());
        List<User> list = userMapper.selectList(userQuery);
        if (list == null || list.size() == 0) {
            // 管理员身份不存在的时候，继续使用教师身份找
            userQuery.setRole(RoleType.TEACHER.getValue());
            list = userMapper.selectList(userQuery);
            if (list == null || list.size() == 0) {
                throw new BusinessException("该用户不存在");
            }
        }


        // 校验邮箱
        User user = list.get(0);
        String email = user.getEmail();
        if (StrUtil.isEmpty(email)) {
            throw new BusinessException("该用户没有绑定邮箱");
        }
        String toEmail = retrievePasswordDTO.getEmail();
        if (!toEmail.equals(email)) {
            throw new BusinessException("输入的邮箱有误");
        }
        // 发送验证码
        return emailService.sendEmailCode(email);
    }


    /**
     * 获取部门下的所有用户（包括子部门）
     *
     * @param code
     * @param userList
     */
    private void getDeptUserList(String code, UserQuery userQuery, List<User> userList) {
        if (code == "" || code == null) {
            return;
        }
        DepartmentQuery query = new DepartmentQuery();
        query.setParentCode(code);
        List<Department> departmentList = departmentMapper.selectList(query);
        for (Department department : departmentList) {
            String deptCode = department.getDeptCode();
            // 将该部门下的所有用户加入列表
            userQuery.setDeptCode(deptCode);
            List<User> list = findListByParam(userQuery);
            userList.addAll(list);
            getDeptUserList(deptCode, userQuery, userList);
        }
    }


}