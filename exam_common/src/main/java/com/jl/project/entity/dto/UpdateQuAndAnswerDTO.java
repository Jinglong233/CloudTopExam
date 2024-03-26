package com.jl.project.entity.dto;

import com.jl.project.entity.po.Qu;
import com.jl.project.entity.po.QuAnswer;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

/**
 * 更新问题及其答案DTO
 */
@Schema(description = "更新问题及其答案DTO")
public class UpdateQuAndAnswerDTO extends Qu {

    /**
     * 题目答案列表
     */
    @Schema(description = "题目答案列表")
    private List<QuAnswer> quAnswerList;

    public List<QuAnswer> getQuAnswerList() {
        return quAnswerList;
    }

    public void setQuAnswerList(List<QuAnswer> quAnswerList) {
        this.quAnswerList = quAnswerList;
    }
}
