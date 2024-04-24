package com.jl.project.strategy.abstractStrategy.strategyImpl;

import com.jl.project.entity.po.UserAnswer;
import com.jl.project.enums.QuType;
import com.jl.project.strategy.abstractStrategy.AbstractJudgeProblem;
import org.springframework.stereotype.Component;


@Component
public class JudgeShortAnswer extends AbstractJudgeProblem {


    @Override
    public Boolean judge(UserAnswer userAnswer, Integer score) {
        return null;
    }

    @Override
    public Boolean support(Integer quType) {
        return QuType.SHORTANSWER.getValue().equals(quType);
    }
}
