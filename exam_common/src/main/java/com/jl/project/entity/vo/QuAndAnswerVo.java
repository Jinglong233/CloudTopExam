package com.jl.project.entity.vo;

import com.jl.project.entity.po.Qu;
import com.jl.project.entity.po.QuAnswer;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

/**
 * 问题及其对应答案VO
 */
@Schema(description = "问题及其对应答案VO")
public class QuAndAnswerVo extends Qu {
    /**
     * 问题选项列表
     */
    @Schema(description = "问题选项列表")
    private List<QuAnswer> quAnswerList;

    public List<QuAnswer> getQuAnswerList() {
        return quAnswerList;
    }

    public void setQuAnswerList(List<QuAnswer> quAnswerList) {
        this.quAnswerList = quAnswerList;
    }
}
