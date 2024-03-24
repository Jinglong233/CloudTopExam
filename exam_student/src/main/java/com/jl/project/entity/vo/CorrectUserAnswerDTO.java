package com.jl.project.entity.vo;

import com.jl.project.entity.dto.UpdateUserAnswerDTO;

public class CorrectUserAnswerDTO extends UpdateUserAnswerDTO {
    private String glId;



    public String getGlId() {
        return glId;
    }

    public void setGlId(String glId) {
        this.glId = glId;
    }
}
