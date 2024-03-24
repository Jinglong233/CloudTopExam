package com.jl.project.strategy;

import com.jl.project.entity.po.UserAnswer;

public interface JudgeProblem {


    public Boolean judge(UserAnswer userAnswer, Integer score);
}
