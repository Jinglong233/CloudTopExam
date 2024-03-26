package com.jl.project.config;

import com.jl.project.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Bean
    public TokenInterceptor tokenInterceptor() {
        return new TokenInterceptor(stringRedisTemplate);
    }


    //定义排除swagger访问的路径配置
    String[] swaggerExcludes = new String[]{"/swagger-ui.html", "/swagger-resources/**", "/webjars/**","/v3/api-docs/**"};

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // todo 拦截器有问题
        registry.addInterceptor(tokenInterceptor())
                .addPathPatterns("/**", "/api/student/login")
                .excludePathPatterns("/user/register", "/user/login")
                .excludePathPatterns("/**.html")
                .excludePathPatterns(swaggerExcludes);

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置拦截器访问静态资源
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/favicon.ico").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        // 文件静态资源放行
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/", "file:static/");

    }
}
