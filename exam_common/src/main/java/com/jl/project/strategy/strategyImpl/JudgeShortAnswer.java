package com.jl.project.strategy.strategyImpl;

import com.jl.project.entity.po.QuAnswer;
import com.jl.project.entity.po.UserAnswer;
import com.jl.project.entity.query.UserAnswerQuery;
import com.jl.project.mapper.QuAnswerMapper;
import com.jl.project.mapper.UserAnswerMapper;
import com.jl.project.strategy.AbstractJudgeProblem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class JudgeShortAnswer extends AbstractJudgeProblem {





    @Override
    public Boolean judge(UserAnswer userAnswer, Integer score) {
        return null;
    }
}
