package com.jl.project.strategy.abstractStrategy.strategyImpl;

import cn.hutool.core.util.StrUtil;
import com.jl.project.entity.po.UserAnswer;
import com.jl.project.enums.QuType;
import com.jl.project.exception.BusinessException;
import com.jl.project.strategy.abstractStrategy.AbstractJudgeProblem;
import org.springframework.stereotype.Component;


@Component
public class JudgeShortAnswer extends AbstractJudgeProblem {


    @Override
    public Boolean judge(UserAnswer userAnswer, Integer score) {
        if (userAnswer == null) {
            throw new BusinessException("缺少参数");
        }
        // 获取简答题答案
        String answer = userAnswer.getAnswer();

        // 判断是否作答(简答题)
        if (StrUtil.isEmpty(answer)) {
            userAnswer.setAnswered(0);
        } else {
            userAnswer.setAnswered(1);
        }

        // TODO: 2024-05-01 之后考虑使用相似度API来判题
        // 更新
        Integer result = userAnswerMapper.updateById(userAnswer, userAnswer.getId());
        return result > 0;
    }

    @Override
    public Boolean support(Integer quType) {
        return QuType.SHORTANSWER.getValue().equals(quType);
    }
}
