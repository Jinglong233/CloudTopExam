package com.jl.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.google.gson.Gson;
import com.jl.project.constant.Constant;
import com.jl.project.entity.dto.UpdateUserDTO;
import com.jl.project.entity.po.Department;
import com.jl.project.entity.po.User;
import com.jl.project.entity.query.DepartmentQuery;
import com.jl.project.entity.query.LoginQuery;
import com.jl.project.entity.query.UserQuery;
import com.jl.project.entity.vo.LoginResponseVo;
import com.jl.project.enums.ResponseCodeEnum;
import com.jl.project.enums.RoleType;
import com.jl.project.exception.BusinessException;
import com.jl.project.mapper.DepartmentMapper;
import com.jl.project.mapper.UserMapper;
import com.jl.project.service.StudentService;
import com.jl.project.utils.MD5Util;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.StringRedisTemplate;
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

import static com.jl.project.constant.UserConstant.TOKEN;
import static com.jl.project.constant.UserConstant.USER_PREFIX;


/**
 * @Description:管理用户Service
 * @author:jingLong
 * @date:2023/11/12
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

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


    /**
     * 根据条件查询列表
     */
    public List<User> findListByParam(UserQuery query) {
        return this.userMapper.selectList(query);
    }


    /**
     * 新增
     */
    @Override
    public Boolean register(User bean) throws BusinessException {
        // 1. 判断是否存在同名用户
        UserQuery userQuery = new UserQuery();
        userQuery.setUserName(bean.getUserName());
        List<User> list = findListByParam(userQuery);
        if (!list.isEmpty()) {
            throw new BusinessException("用户名已存在");
        }
        // 2. 生成随机ID
        bean.setId(IdUtil.simpleUUID().toString());

        // 3. 处理密码相关（盐 + 密码）
        String password = bean.getPassword();
        String salt = MD5Util.getSalt(password);
        String saltPassword = MD5Util.getMD5Encode(password, salt);
        bean.setCreateTime(new Date());
        bean.setPassword(saltPassword);
        bean.setSalt(salt);

        bean.setRole("student");

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
        String deptName = department.getDeptName();
        bean.setDeptText(deptName);

        // todo 角色未设定
        Integer result = userMapper.insert(bean);
        return result > 0;
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
        if (updateDeptDTO == null || id == null || updateDeptDTO.getUser() == null) {
            throw new BusinessException("缺少参数");
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
        if (id == null) {
            throw new BusinessException("缺少参数");
        }
        Integer result = userMapper.deleteById(id);
        return result > 0;
    }

    /**
     * 登录
     *
     * @param user
     * @return
     * @throws BusinessException
     */
    @Override
    public LoginResponseVo login(LoginQuery user) throws BusinessException {
        if (user == null) {
            throw new BusinessException("参数错误");
        }
        // 1. 根据用户名查询用户
        UserQuery userQuery = new UserQuery();
        userQuery.setUserName(user.getUserName());

        // 添加学生身份的判断查询
        userQuery.setRole(RoleType.STUDENT.getValue());

        List<User> list = findListByParam(userQuery);
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
     * 通过token获取登录用户信息
     *
     * @return
     */
    @Override
    public User getLoginUserInfo() throws BusinessException {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        String token = request.getHeader("Authorization");
        if (token == null) {
            throw new BusinessException(ResponseCodeEnum.CODE_401);
        }
        Gson gson = new Gson();
        String jsonUser = stringRedisTemplate.opsForValue().get(USER_PREFIX + TOKEN + token);
        User user = gson.fromJson(jsonUser, User.class);
        if (user == null) {
            throw new BusinessException(ResponseCodeEnum.CODE_401);
        }
        return user;
    }


    /**
     * 头像上传
     *
     * @param file
     * @return
     */
    @Override
    public String uploadAvatar(MultipartFile file) throws BusinessException, IOException {
        if (file == null) {
            throw new BusinessException("文件为空");
        }

        // 获取登录用户
        User loginUserInfo = getLoginUserInfo();
        if (loginUserInfo == null) {
            throw new BusinessException("请重新登录");
        }

        String userId = loginUserInfo.getId();
        if (userId == null) {
            throw new BusinessException("无登录状态，请重新登里");
        }

        //1、创建oss客户端连接
        String url = null;
        //2、获取文件输入流
        InputStream inputStream = file.getInputStream();
        //3、获取原始文件名
        String originFileName = file.getOriginalFilename();

        // 4. 获取后缀名
        String extName = FileUtil.extName(originFileName);

        // 5. 拼接文件名
        String realFileName = userId + "." + extName;


        // 6. 拼接dir根目录
        String dirFileName = env.getProperty("aliyun.oss.dir.prefix") + realFileName;

        // 创建上传对象的元数据（MetaData）
        ObjectMetadata objectMetadata = new ObjectMetadata();
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