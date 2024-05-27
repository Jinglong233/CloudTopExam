package com.jl.project.observer.correctObserver;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author huawei
 * @Date 2024-05-26 22:38
 * @Description 训练完成 被观察者
 **/
@Repository
public class TrainSubject implements CorrectSubject {
    @Resource
    List<CorrectObserver> correctObservers;

    @Override
    public void attach() {

    }

    @Override
    public void detach() {

    }

    @Override
    public void notifyBookUpdate(List<String> wrongList, String userId) {
        for (CorrectObserver correctObserver : correctObservers) {
            correctObserver.insertErrorCollection(wrongList, userId);
        }
    }
}
