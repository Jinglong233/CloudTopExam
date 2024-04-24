package com.jl.project.strategy.abstractStrategy.strategyImpl;

import com.jl.project.entity.po.QuAnswer;
import com.jl.project.entity.po.UserAnswer;
import com.jl.project.entity.query.QuAnswerQuery;
import com.jl.project.enums.QuType;
import com.jl.project.exception.BusinessException;
import com.jl.project.strategy.abstractStrategy.AbstractJudgeProblem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JudgeFill extends AbstractJudgeProblem {



    @Override
    public Boolean judge(UserAnswer userAnswer, Integer score) {

        if (userAnswer == null) {
            throw new BusinessException("缺少参数");
        }

        // 获取用户的答案（规定多个答案都用逗号隔开）
        String answer = userAnswer.getAnswer();
        List<String> answerContent = new ArrayList<>();
        if (answer != null) {
            String[] split = answer.split(",");
            if (split != null) {
                for (String s : split) {
                    if (s != null || !s.isEmpty()) {
                        answerContent.add(s);
                    }
                }
            }
        }

        // 获取该题目的正确答案
        QuAnswerQuery quAnswerQuery = new QuAnswerQuery();
        quAnswerQuery.setQuId(userAnswer.getQuId());
        quAnswerQuery.setIsRight(1);

        List<QuAnswer> trueQuAnswers = quAnswerMapper.selectList(quAnswerQuery);
        if (trueQuAnswers == null || trueQuAnswers.isEmpty()) {
            throw new BusinessException("该填空题没答案");
        }

        // 获取填空的正确答案
        List<String> trueContent = trueQuAnswers.stream().map(QuAnswer::getContent).collect(Collectors.toList());


        boolean isEqual = false;
        Integer myScore = 0;
        if (answerContent != null && !answerContent.isEmpty()) {
            // 部分给分
            // 判断题目是否作对(这里因为前边判断了用户答案id为空的情况，所以可以使用containsAll()。因为空集合是所有集合的子集)
            isEqual = trueContent.containsAll(answerContent);
            if (isEqual) { //部分答对
                // 获取选对的个数
                int min = Math.min(answerContent.size(), trueContent.size());
                myScore = (score / trueContent.size()) * min;
            }
        }


        userAnswer.setIsRight(isEqual ? 1 : 0);
        userAnswer.setScore(myScore);


        // 更新
        Integer result = userAnswerMapper.updateById(userAnswer, userAnswer.getId());


        return result > 0;
    }

    @Override
    public Boolean support(Integer quType) {
        return QuType.FILL.getValue().equals(quType);
    }
}
