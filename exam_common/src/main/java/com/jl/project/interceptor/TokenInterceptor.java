package com.jl.project.interceptor;

import com.jl.project.constant.Constant;
import com.jl.project.enums.ResponseCodeEnum;
import com.jl.project.exception.BusinessException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

import static com.jl.project.constant.UserConstant.TOKEN;
import static com.jl.project.constant.UserConstant.USER_PREFIX;

public class TokenInterceptor implements HandlerInterceptor {

    private StringRedisTemplate stringRedisTemplate;

    public TokenInterceptor(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 预请求得放行
        if ("OPTIONS".equals(request.getMethod())) {
            return true;
        }


        String path = request.getServletPath();
        if (path.matches("/student/login") || path.matches("api/user/login")) {
            //不需要的拦截直接过
            return true;
        }
        // 1. 获取token
        String token = request.getHeader("Authorization");
        if (token == null) {
            throw new BusinessException(ResponseCodeEnum.CODE_401);
        }
        // 2. 判断是否有效
        String result = stringRedisTemplate.opsForValue().get(USER_PREFIX + TOKEN + token);
        if (result == null) {
            throw new BusinessException(ResponseCodeEnum.CODE_401);
        }
        // 3. token续期
        stringRedisTemplate.opsForValue().set(USER_PREFIX + TOKEN + token, result, Constant.EXPIRED_30, TimeUnit.MINUTES);
        return true;
    }

}
