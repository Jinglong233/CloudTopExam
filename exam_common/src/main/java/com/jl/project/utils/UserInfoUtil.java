package com.jl.project.utils;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.google.gson.Gson;
import com.jl.project.entity.po.User;
import com.jl.project.entity.vo.LoginResponseVo;
import com.jl.project.enums.ResponseCodeEnum;
import com.jl.project.exception.BusinessException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import static com.jl.project.constant.UserConstant.USER_PREFIX;

@Repository
public class UserInfoUtil {

    /**
     * 获取登录用户的信息
     *
     * @param request
     * @param redisTemplate
     * @return
     */
    public static LoginResponseVo getLoginUserInfo(StringRedisTemplate redisTemplate) {
        Gson gson = new Gson();
        Object loginId = StpUtil.getLoginId();
        String jsonUser = redisTemplate.opsForValue().get(USER_PREFIX + loginId.toString());
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
    public static String getLoginUserRole( StringRedisTemplate redisTemplate) {
        LoginResponseVo loginUserInfo = getLoginUserInfo(redisTemplate);
        if (StrUtil.isEmpty(loginUserInfo.getRole())) {
            throw new BusinessException("当前用户身份缺失，请联系管理员");
        }
        return loginUserInfo.getRole();
    }



    /**
     * 对比传入的用户Id和当前登录的用户Id是否相同
     *
     * @param redisTemplate
     * @param userId （对比的UserId）
     * @return
     */
    public static Boolean isMySelf(String userId) {
        Object loginId = StpUtil.getLoginId();
        if (loginId.toString().equals(userId)) {
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
    public static void refreshRedisUserInfo(StringRedisTemplate redisTemplate, User user) {
        Object loginId = StpUtil.getLoginId();
        String tokenValue = StpUtil.getTokenValue();
        LoginResponseVo loginResponseVo = new LoginResponseVo();
        BeanUtil.copyProperties(user,loginResponseVo);
        loginResponseVo.setToken(tokenValue);
        // 更新该登录用户缓存的信息
        Gson gson = new Gson();
        String userJson = gson.toJson(user);
        redisTemplate.opsForValue().set(USER_PREFIX + loginId.toString(), userJson);
    }
}
