package com.jl.project.annotation;

import com.jl.project.enums.LoginLogState;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperationLog {
    /**
     * 操作信息
     *
     * @return
     */
    String description();

    /**
     * 日志类型（默认是操作日志）
     *
     * @return
     */
    LoginLogState logType();
}
