package com.jl.project.utils;

import com.google.gson.Gson;
import com.jl.project.entity.vo.LoginResponseVo;
import com.jl.project.enums.ResponseCodeEnum;
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
        return loginUserInfo.getRole();
    }

}
