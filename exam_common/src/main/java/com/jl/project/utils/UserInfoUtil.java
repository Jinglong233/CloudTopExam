package com.jl.project.utils;

import cn.hutool.core.util.StrUtil;
import com.google.gson.Gson;
import com.jl.project.entity.vo.LoginResponseVo;
import com.jl.project.enums.ResponseCodeEnum;
import com.jl.project.enums.RoleType;
import com.jl.project.exception.BusinessException;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.http.HttpServletRequest;

import static com.jl.project.constant.UserConstant.TOKEN;
import static com.jl.project.constant.UserConstant.USER_PREFIX;

public class UserInfoUtil {


    /**
     * 获取登录用户的信息
     *
     * @param request
     * @param redisTemplate
     * @return
     */
    public static LoginResponseVo getLoginUserInfo(HttpServletRequest request, StringRedisTemplate redisTemplate) {
        String token = request.getHeader("Authorization");
        Gson gson = new Gson();
        String jsonUser = redisTemplate.opsForValue().get(USER_PREFIX + TOKEN + token);
        LoginResponseVo user = gson.fromJson(jsonUser, LoginResponseVo.class);
        if (user == null) {
            throw new BusinessException(ResponseCodeEnum.CODE_401);
        }
        return user;
    }

    /**
     * 获取用户的角色
     *
     * @param request
     * @param redisTemplate
     * @return
     */
    public static String getLoginUserRole(HttpServletRequest request, StringRedisTemplate redisTemplate) {
        LoginResponseVo loginUserInfo = getLoginUserInfo(request, redisTemplate);
        if (StrUtil.isEmpty(loginUserInfo.getRole())) {
            throw new BusinessException("当前用户身份缺失，请联系管理员");
        }
        return loginUserInfo.getRole();
    }

    /**
     * 判断当前用户是否是管理员
     *
     * @param request
     * @param redisTemplate
     * @return
     */
    public static Boolean isAdmin(HttpServletRequest request, StringRedisTemplate redisTemplate) {
        String loginUserRole = getLoginUserRole(request, redisTemplate);
        return RoleType.ADMIN.getValue().equals(loginUserRole);
    }


    /**
     * 判断当前用户是否是教师
     *
     * @param request
     * @param redisTemplate
     * @return
     */
    public static Boolean isTeacher(HttpServletRequest request, StringRedisTemplate redisTemplate) {
        String loginUserRole = getLoginUserRole(request, redisTemplate);
        return "teacher".equals(loginUserRole);
    }


    /**
     * 对比传入的用户Id和当前登录的用户Id是否相同
     *
     * @param request
     * @param redisTemplate
     * @param userId
     * @return
     */
    public static Boolean isMySelf(HttpServletRequest request, StringRedisTemplate redisTemplate, String userId) {
        LoginResponseVo loginUserInfo = getLoginUserInfo(request, redisTemplate);
        if (loginUserInfo.getId().equals(userId)) {
            return true;
        }
        return false;
    }


    /**
     * 更新redis中当前登录用户的信息
     *
     * @param request
     * @param redisTemplate
     * @param user
     */
    public static void refreshRedisUserInfo(HttpServletRequest request, StringRedisTemplate redisTemplate, LoginResponseVo user) {
        String token = request.getHeader("Authorization");
        user.setToken(token);
        // 更新该登录用户缓存的信息
        Gson gson = new Gson();
        String json = gson.toJson(user);
        redisTemplate.opsForValue().set(USER_PREFIX + TOKEN + token, json);
    }
}
