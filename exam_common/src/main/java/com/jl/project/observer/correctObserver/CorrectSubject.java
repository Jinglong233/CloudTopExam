package com.jl.project.observer.correctObserver;

import java.util.List;

/**
 * 错题搜集 抽象被观察者
 */
public interface CorrectSubject {
    void attach();


    void detach();
    // 发送更新通知
    void notifyBookUpdate(List<String> quList, String userId);
}
