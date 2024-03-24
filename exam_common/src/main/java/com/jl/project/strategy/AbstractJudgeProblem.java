package com.jl.project.strategy;

import com.jl.project.entity.po.QuAnswer;
import com.jl.project.entity.po.UserAnswer;
import com.jl.project.entity.query.UserAnswerQuery;
import com.jl.project.mapper.QuAnswerMapper;
import com.jl.project.mapper.UserAnswerMapper;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

public abstract class AbstractJudgeProblem implements JudgeProblem {
    @Resource
    protected UserAnswerMapper<UserAnswer, UserAnswerQuery> userAnswerMapper;

    @Resource
    protected QuAnswerMapper<QuAnswer, QuAnswerMapper> quAnswerMapper;





}
