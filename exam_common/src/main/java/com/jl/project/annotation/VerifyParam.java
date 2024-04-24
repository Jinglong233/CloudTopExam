package com.jl.project.annotation;

import com.jl.project.enums.VerifyRegexEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface VerifyParam {
    int min() default -1;

    int max() default -1;

    boolean require() default false;

    /**
     * 正则校验
     *
     * @return
     */
    VerifyRegexEnum regex() default VerifyRegexEnum.NO;

}
