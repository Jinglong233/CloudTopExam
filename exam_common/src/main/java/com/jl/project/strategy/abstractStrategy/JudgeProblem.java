package com.jl.project.strategy.abstractStrategy;

import com.jl.project.entity.po.UserAnswer;

public interface JudgeProblem {


    public Boolean judge(UserAnswer userAnswer, Integer score);

    public Boolean support(Integer quType);
}
