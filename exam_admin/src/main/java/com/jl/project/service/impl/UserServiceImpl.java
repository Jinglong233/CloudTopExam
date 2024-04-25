package com.jl.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.google.gson.Gson;
import com.jl.project.constant.Constant;
import com.jl.project.entity.dto.*;
import com.jl.project.entity.po.Department;
import com.jl.project.entity.po.Tmpl;
import com.jl.project.entity.po.User;
import com.jl.project.entity.query.DepartmentQuery;
import com.jl.project.entity.query.SimplePage;
import com.jl.project.entity.query.TmplQuery;
import com.jl.project.entity.query.UserQuery;
import com.jl.project.entity.vo.LoginResponseVo;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.enums.PageSize;
import com.jl.project.enums.RoleType;
import com.jl.project.exception.BusinessException;
import com.jl.project.mapper.DepartmentMapper;
import com.jl.project.mapper.TmplMapper;
import com.jl.project.mapper.UserMapper;
import com.jl.project.service.DepartmentService;
import com.jl.project.service.EmailService;
import com.jl.project.service.UserService;
import com.jl.project.utils.MD5Util;
import com.jl.project.utils.UserInfoUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.jl.project.constant.UserConstant.TOKEN;
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
    private DepartmentService departmentService;

    @Resource
    private OSSClient ossClient;
    @Resource
    private Environment env;

    @Resource
    private JavaMailSender javaMailSender;


    @Resource
    private EmailService emailService;


    @Resource
    private TmplMapper<Tmpl, TmplQuery> tmplMapper;


    @Value("${spring.mail.username}")
    private String from;

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

        // 4. 生成token
        Gson gson = new Gson();
        String token = UUID.randomUUID().toString();

        // 使用两对k-v保证同一账号一地登录。通过token获取用户信息
        // token格式：user前缀 + userId + token
        // 5. 判断是否已经登录
        String oldToken = stringRedisTemplate.opsForValue().get(USER_PREFIX + resultUser.getId());
        if (oldToken != null) { // 已经登录
            // 删除原来的登录token
            stringRedisTemplate.delete(USER_PREFIX + TOKEN + oldToken);
        }
        stringRedisTemplate.opsForValue().set(USER_PREFIX + resultUser.getId(), token);
        stringRedisTemplate.opsForValue().set(USER_PREFIX + TOKEN + token, gson.toJson(resultUser), Constant.EXPIRED_30, TimeUnit.MINUTES);

        LoginResponseVo loginResponseVo = new LoginResponseVo();
        BeanUtil.copyProperties(resultUser, loginResponseVo);
        loginResponseVo.setToken(token);

        return loginResponseVo;
    }


    /**
     * 退出登录
     *
     * @return
     */
    @Override
    public Boolean logout() {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        String authorization = request.getHeader("Authorization");
        if (authorization == null) {
            return true;
        }
        // 清除token缓存
        Boolean delete = stringRedisTemplate.delete(USER_PREFIX + TOKEN + authorization);
        return delete;
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
        String userId = IdUtil.simpleUUID().toString();


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


        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();

        LoginResponseVo createUserInfo = UserInfoUtil.getLoginUserInfo(request, stringRedisTemplate);
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
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();

        String id = updateDeptDTO.getId();

        // 判断是否是本人
        LoginResponseVo loginUserInfo = UserInfoUtil.getLoginUserInfo(request, stringRedisTemplate);
        if (!id.equals(loginUserInfo.getId())) {
            // 如果不是本人，再次得判断是否是管理员
            String role = UserInfoUtil.getLoginUserRole(request, stringRedisTemplate);
            if (!"admin".equals(role)) {
                throw new BusinessException("无权限修改");
            }
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

        // 5. 更改缓存中的用户信息
        String token = stringRedisTemplate.opsForValue().get(USER_PREFIX + id);
        if (token != null) {
            // 更新该登录用户缓存的信息
            Gson gson = new Gson();
            User afterUpdate = userMapper.selectById(id);
            String json = gson.toJson(afterUpdate);
            stringRedisTemplate.opsForValue().set(USER_PREFIX + TOKEN + token, json);
        }
        return result > 0;
    }

    /**
     * 根据Id删除
     */
    public Boolean deleteUserById(String id) throws BusinessException {
        User user = userMapper.selectById(id);
        if(user!=null){
            // 判断要删除的用户是否是管理员
            if("admin".equals(user.getRole())){
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
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        return UserInfoUtil.getLoginUserInfo(request, stringRedisTemplate);
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
    public String uploadAvatar(MultipartFile file) throws BusinessException, IOException {
        // 获取登录用户
        LoginResponseVo loginUserInfo = getLoginUserInfo();

        String userId = loginUserInfo.getId();
        if (userId == null) {
            throw new BusinessException("登录状态错误，请尝试重新登录");
        }

        //1、创建oss客户端连接
        String url = null;
        //2、获取文件输入流
        InputStream inputStream = file.getInputStream();
        //3、获取原始文件名
        String originFileName = file.getOriginalFilename();

        // 4. 获取后缀名
        String extName = FileUtil.extName(originFileName);

        // 使用统一的后缀
        // 5. 拼接文件名
        String realFileName = userId + "." + "jpg";


        // 6. 拼接dir根目录
        String dirFileName = env.getProperty("aliyun.oss.dir.prefix") + realFileName;

        // 创建上传对象的元数据（MetaData）
        com.aliyun.oss.model.ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(inputStream.available());
        objectMetadata.setCacheControl("no-cache");
        objectMetadata.setHeader("Pragma", "no-cache");
        objectMetadata.setContentType(getContentType(realFileName
                .substring(realFileName.lastIndexOf("."))));


        // 7. 创建oss请求，传入三个参数
        ossClient.putObject(env.getProperty("aliyun.oss.bucketName"), dirFileName, inputStream, objectMetadata);

        // 8. 拼接图片url路径，方便后续入库
        url = "https://" + env.getProperty("aliyun.oss.bucketName") + "." + env.getProperty("aliyun.oss.endpoint") + "/" + dirFileName;


        // 9. 文件路径保存到数据库
        User user = new User();
        user.setAvatar(url);
        Integer result = userMapper.updateById(user, userId);
        return url;
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
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();

        LoginResponseVo loginUserInfo = UserInfoUtil.getLoginUserInfo(request, stringRedisTemplate);
        // 判断是否是原用户
        if (!updateUserPasswordDTO.getUserId().equals(loginUserInfo.getId())) {
            // 判断是否是管理员
            if (!"admin".equals(loginUserInfo.getRole())) {
                throw new BusinessException("无权限修改");
            }
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

        //  删除redis中缓存的信息（如果有）
        stringRedisTemplate.delete(USER_PREFIX + TOKEN + loginUserInfo.getToken());

        Integer result = userMapper.updateById(user, userId);
        return result > 0;
    }

    @Override
    public Boolean getEmailCode(String email) throws BusinessException {
        emailService.sendEmailCode(email);
        return true;
    }

    @Override
    public Boolean updateUserEmail(UpdateEmailDTO updateEmailDTO) throws BusinessException {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();

        String userId = updateEmailDTO.getUserId();
        // 检测是否是本人
        LoginResponseVo loginUserInfo = UserInfoUtil.getLoginUserInfo(request, stringRedisTemplate);
        if (!userId.equals(loginUserInfo.getId())) {
            throw new BusinessException("无权限操作");
        }
        String email = updateEmailDTO.getEmail();
        String code = updateEmailDTO.getCode();

        // 获取验证码
        Boolean isRight = emailService.checkCode(email, code);

        if (!isRight) {
            throw new BusinessException("验证码错误");
        }

        // 查询该邮箱是否被注册过
        UserQuery userQuery = new UserQuery();
        userQuery.setEmail(email);
        List<User> list = userMapper.selectList(userQuery);
        if (!list.isEmpty()) {
            throw new BusinessException("该邮箱已被绑定");
        }
        User user = new User();
        user.setId(userId);
        user.setEmail(email);
        Integer result = userMapper.updateById(user, userId);
        return result > 0;
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

    /**
     * 获取上传文件类型
     *
     * @param FilenameExtension
     * @return
     */
    private String getContentType(String FilenameExtension) {
        if (FilenameExtension.equalsIgnoreCase(".bmp")) {
            return "image/bmp";
        }
        if (FilenameExtension.equalsIgnoreCase(".gif")) {
            return "image/gif";
        }
        if (FilenameExtension.equalsIgnoreCase(".jpeg") ||
                FilenameExtension.equalsIgnoreCase(".jpg") ||
                FilenameExtension.equalsIgnoreCase(".png")) {
            return "image/jpg";
        }
        if (FilenameExtension.equalsIgnoreCase(".html")) {
            return "text/html";
        }
        if (FilenameExtension.equalsIgnoreCase(".txt")) {
            return "text/plain";
        }
        if (FilenameExtension.equalsIgnoreCase(".vsd")) {
            return "application/vnd.visio";
        }
        if (FilenameExtension.equalsIgnoreCase(".pptx") ||
                FilenameExtension.equalsIgnoreCase(".ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (FilenameExtension.equalsIgnoreCase(".docx") ||
                FilenameExtension.equalsIgnoreCase(".doc")) {
            return "application/msword";
        }
        if (FilenameExtension.equalsIgnoreCase(".xml")) {
            return "text/xml";
        }
        return "image/jpg";
    }


}