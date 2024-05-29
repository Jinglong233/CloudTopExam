package com.jl.project.observer.correctObserver;

import com.jl.project.entity.po.UserAnswer;

import java.util.List;

/**
 * 错题搜集 观察者抽象类
 */
public interface CorrectObserver {


    /**
     * 插入或者更新错题
     * @param wrongList 错题列表
     * @param userId
     */
    void insertErrorCollection(List<UserAnswer> wrongList);
}
