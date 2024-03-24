package com.jl.project.entity.vo;

import com.jl.project.entity.po.Qu;
import com.jl.project.entity.po.QuAnswer;

import java.util.List;

public class QuAndAnswerVo extends Qu {
    private List<QuAnswer> quAnswerList;

    public List<QuAnswer> getQuAnswerList() {
        return quAnswerList;
    }

    public void setQuAnswerList(List<QuAnswer> quAnswerList) {
        this.quAnswerList = quAnswerList;
    }
}
