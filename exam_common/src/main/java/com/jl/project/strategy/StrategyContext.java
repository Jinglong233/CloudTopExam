package com.jl.project.strategy;

import com.jl.project.entity.po.UserAnswer;
import com.jl.project.enums.QuType;
import com.jl.project.exception.BusinessException;
import com.jl.project.strategy.strategyImpl.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class StrategyContext {

    @Resource
    private JudgeFill judgeFill;

    @Resource
    private JudgeRadio judgeRadio;

    @Resource
    private JudgeMulti judgeMulti;

    @Resource
    private JudgeShortAnswer judgeShortAnswer;

    @Resource
    private JudgeDecide judgeDecide;


    public Boolean isAnswer(UserAnswer userAnswer, Integer quType, Integer score) {
        JudgeProblem strategy = getStrategy(quType);
        return strategy.judge(userAnswer, score);
    }

    private JudgeProblem getStrategy(Integer quType) {
        if (quType == null) {
            throw new BusinessException("缺少题型参数");
        }
        if (quType.equals(QuType.JUDGE.getValue())) {
            return judgeDecide;
        } else if (quType.equals(QuType.RADIO.getValue())) {
            return judgeRadio;
        } else if (quType.equals(QuType.MULTI.getValue())) {
            return judgeMulti;
        } else if (quType.equals(QuType.FILL.getValue())) {
            return judgeFill;
        } else if (quType.equals(QuType.SHORTANSWER.getValue())) {
            return judgeShortAnswer;
        } else {
            throw new BusinessException("没有该题型");
        }

    }
}
