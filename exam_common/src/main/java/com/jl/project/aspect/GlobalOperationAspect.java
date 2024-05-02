package com.jl.project.aspect;

import cn.hutool.core.util.StrUtil;
import com.google.gson.Gson;
import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.constant.Constant;
import com.jl.project.entity.po.User;
import com.jl.project.enums.ResponseCodeEnum;
import com.jl.project.exception.BusinessException;
import com.jl.project.utils.VerifyUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.concurrent.TimeUnit;

import static com.jl.project.constant.UserConstant.TOKEN;
import static com.jl.project.constant.UserConstant.USER_PREFIX;

@Aspect
@Component
public class GlobalOperationAspect {

    private static final Logger logger = LoggerFactory.getLogger(GlobalOperationAspect.class);

    private static final String TYPE_STRING = "java.lang.String";

    private static final String TYPE_INTEGER = "java.lang.Integer";
    private static final String TYPE_LONG = "java.lang.Long";

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Pointcut("@annotation(com.jl.project.annotation.GlobalInterceptor)")
    private void requestInterceptor() {

    }

    @Before("requestInterceptor()")
    public void interceptorDo(JoinPoint point) throws BusinessException {
        try {
            Object target = point.getTarget();
            Object[] arguments = point.getArgs();
            String methodName = point.getSignature().getName();
            Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
            Method method = target.getClass().getMethod(methodName, parameterTypes);
            GlobalInterceptor interceptor = method.getAnnotation(GlobalInterceptor.class);
            if (null == interceptor) {
                return;
            }


            // 校验登录（同时也检测了管理员、学生）
            if (interceptor.checkLogin() || interceptor.checkAdmin() || interceptor.checkStudent()) {
                checkLogin(interceptor.checkAdmin(),interceptor.checkStudent());
            }

            // 校验参数
            if (interceptor.checkParams()) {
                validateParams(method, arguments);
            }
        } catch (BusinessException e) {
            logger.error("全局拦截器异常", e);
            throw e;
        } catch (Exception e) {
            logger.error("全局拦截器异常", e);
            throw new BusinessException(ResponseCodeEnum.CODE_500);
        } catch (Throwable e) {
            logger.error("全局拦截器异常", e);
            throw new BusinessException(ResponseCodeEnum.CODE_500);
        }
    }

    /**
     * 检查是否登录
     *
     * @param checkAdmin   是否需要管理员身份
     * @param checkStudent 是否需要学生身份
     * @throws BusinessException
     */
    private void checkLogin(Boolean checkAdmin, Boolean checkStudent) throws BusinessException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization");
        if (StrUtil.isEmpty(token)) {
            throw new BusinessException(ResponseCodeEnum.CODE_401);
        }
        // 获取redis中缓存的登录凭证
        String result = stringRedisTemplate.opsForValue().get(USER_PREFIX + TOKEN + token);
        if (result == null) {
            throw new BusinessException(ResponseCodeEnum.CODE_901);
        }

        // token续期
        stringRedisTemplate.opsForValue().set(USER_PREFIX + TOKEN + token, result, Constant.EXPIRED_30, TimeUnit.MINUTES);

        // 通过token继续获取userInfo
        String userInfoStr = stringRedisTemplate.opsForValue().get(USER_PREFIX + TOKEN + token);
        if (StrUtil.isEmpty(userInfoStr)) {
            throw new BusinessException(ResponseCodeEnum.CODE_901);
        }
        Gson gson = new Gson();
        User user = gson.fromJson(userInfoStr, User.class);
        // 检验是否需要管理员权限
        if (checkAdmin && !"admin".equals(user.getRole())) {
            throw new BusinessException(ResponseCodeEnum.CODE_404);
        }

        // 检验是否需要学生身份
        if (checkStudent && !"student".equals(user.getRole())) {
            throw new BusinessException(ResponseCodeEnum.CODE_404);
        }
    }


    /**
     * 校验参数
     *
     * @param m
     * @param arguments
     * @throws BusinessException
     */
    private void validateParams(Method m, Object[] arguments) throws BusinessException {
        Parameter[] parameters = m.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            Object value = arguments[i];
            VerifyParam verifyParam = parameter.getAnnotation(VerifyParam.class);
            if (verifyParam == null) {
                continue;
            }
            if (TYPE_STRING.equals(parameter.getParameterizedType().getTypeName()) ||
                    TYPE_LONG.equals(parameter.getParameterizedType().getTypeName())) {
                //基本数据类型
                checkValue(value, verifyParam);
            } else {
                //如果传递的是对象
                checkObjValue(parameter, value);
            }
        }
    }

    /**
     * 校验对象数据类型
     *
     * @param parameter
     * @param value
     */
    private void checkObjValue(Parameter parameter, Object value) {
        try {
            String typeName = parameter.getParameterizedType().getTypeName();
            Class classz = Class.forName(typeName);
            Field[] fields = classz.getDeclaredFields();
            for (Field field : fields) {
                VerifyParam fieldVerifyParam = field.getAnnotation(VerifyParam.class);
                if (fieldVerifyParam == null) {
                    continue;
                }

                field.setAccessible(true);
                Object resultValue = field.get(value);
                checkValue(resultValue, fieldVerifyParam);
            }
        } catch (BusinessException e) {
            logger.error("校验参数失败", e);
            throw e;
        } catch (Exception e) {
            logger.error("校验参数失败", e);
            throw new BusinessException(ResponseCodeEnum.CODE_600);
        }
    }

    /**
     * 校验基本数据类型参数
     *
     * @param value
     * @param verifyParam 是否校验
     * @throws BusinessException
     */
    private void checkValue(Object value, VerifyParam verifyParam) throws BusinessException {
        Boolean isEmpty = value == null || StrUtil.isEmpty(value.toString());
        Integer length = value == null ? 0 : value.toString().length();

        // 校验空
        if (isEmpty && verifyParam.require()) {
            throw new BusinessException(ResponseCodeEnum.CODE_600);
        }

        // 校验长度
        if (!isEmpty && (verifyParam.max() != -1 && verifyParam.max() < length
                || verifyParam.min() != -1 && verifyParam.min() > length)) {
            throw new BusinessException(ResponseCodeEnum.CODE_600);
        }
        // 校验正则
        if (!isEmpty && !StrUtil.isEmpty(verifyParam.regex().getRegex()) && !VerifyUtils.verify(verifyParam.regex(), String.valueOf(value))) {
            throw new BusinessException(ResponseCodeEnum.CODE_600);
        }
    }
}
