package com.jl.project.strategy.strategyImpl;

import cn.hutool.core.collection.CollUtil;
import com.google.gson.Gson;
import com.jl.project.entity.po.QuAnswer;
import com.jl.project.entity.po.UserAnswer;
import com.jl.project.entity.query.QuAnswerQuery;
import com.jl.project.entity.query.UserAnswerQuery;
import com.jl.project.exception.BusinessException;
import com.jl.project.mapper.QuAnswerMapper;
import com.jl.project.mapper.UserAnswerMapper;
import com.jl.project.strategy.AbstractJudgeProblem;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class JudgeRadio extends AbstractJudgeProblem {


    @Override
    public Boolean judge(UserAnswer userAnswer, Integer score) {
        if (userAnswer == null) {
            throw new BusinessException("缺少参数");
        }

        String jsonAnswerId = userAnswer.getAnswerId();
        // 将Json字符串转换为数组
        Gson gson = new Gson();
        List<String> answerIdList = gson.fromJson(jsonAnswerId, List.class);

        // 判断是否作答(非简答题)
        if (answerIdList == null || answerIdList.isEmpty()) {
            userAnswer.setAnswered(0);
        } else {
            userAnswer.setAnswered(1);
        }

        // 获取该题目的正确答案
        QuAnswerQuery quAnswerQuery = new QuAnswerQuery();
        quAnswerQuery.setQuId(userAnswer.getQuId());
        quAnswerQuery.setIsRight(1);

        List<QuAnswer> trueQuAnswers = quAnswerMapper.selectList(quAnswerQuery);
        if (trueQuAnswers == null || trueQuAnswers.isEmpty()) {
            throw new BusinessException("该单选题没答案");
        }

        List<String> trueAnswerIdList = new ArrayList<>();
        if (trueQuAnswers == null || trueQuAnswers.isEmpty()) {
            throw new BusinessException("该题目无答案");
        } else {
            // 只抽取正确答案的Id
            trueAnswerIdList = trueQuAnswers.stream()
                    .map(QuAnswer::getId).collect(Collectors.toList());
        }

        // 判断题目是否作对
        boolean isEqual = CollUtil.isEqualList(trueAnswerIdList, answerIdList);

        // 设置得分
        Integer myScore = 0;
        if (isEqual) {
            myScore = score;
        }


        userAnswer.setIsRight(isEqual ? 1 : 0);
        userAnswer.setScore(myScore);
        // 更新
        Integer result = userAnswerMapper.updateById(userAnswer, userAnswer.getId());


        return result > 0;
    }
}
