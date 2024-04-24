package com.jl.project.strategy;

import com.jl.project.entity.po.UserAnswer;
import com.jl.project.exception.BusinessException;
import com.jl.project.strategy.abstractStrategy.JudgeProblem;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class JudeProblemStrategyContext {

    @Resource
    private List<JudgeProblem> list;


    public Boolean isAnswer(UserAnswer userAnswer, Integer quType, Integer score) {
        JudgeProblem strategy = getStrategy(quType);
        return strategy.judge(userAnswer, score);
    }

    private JudgeProblem getStrategy(Integer quType) {
        if (quType == null) {
            throw new BusinessException("缺少题型参数");
        }
        for (JudgeProblem judgeProblem : list) {
            if (judgeProblem.support(quType)) {
                return judgeProblem;
            }
        }
        throw new BusinessException("没有该题型");
    }
}
