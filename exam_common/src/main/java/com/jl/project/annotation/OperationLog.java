package com.jl.project.annotation;

import com.jl.project.enums.LogType;
import com.jl.project.enums.OperationType;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperationLog {


    /**
     * 日志类型（默认是操作日志）
     *
     * @return
     */
    LogType logType();

    /**
     * 操作类型
     *
     * @return
     */
    OperationType oper() default OperationType.NULL;


}
