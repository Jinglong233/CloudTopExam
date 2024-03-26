package com.jl.project.entity.dto;

import com.jl.project.entity.po.UserAnswer;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 更新用户答案DTO
 */
@Schema(description = "更新用户答案DTO")
public class UpdateUserAnswerDTO {
    /**
     * 用户答案
     */
    @Schema(description = "用户答案")
    private UserAnswer userAnswer;


    public UserAnswer getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(UserAnswer userAnswer) {
        this.userAnswer = userAnswer;
    }
}
