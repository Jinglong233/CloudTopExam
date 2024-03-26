package com.jl.project.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 更新试卷及其关联题目DTO
 */
@Schema(description = "更新试卷及其关联题目DTO")
public class UpdatePaperAndQuDTO {

    /**
     * 添加试卷对象DTO
     */
    @Schema(description = "添加试卷对象DTO")
    private AddPaperDTO addPaperDTO;

    /**
     * id
     */
    @Schema(description = "id")
    private String id;

    public AddPaperDTO getAddPaperDTO() {
        return addPaperDTO;
    }

    public void setAddPaperDTO(AddPaperDTO addPaperDTO) {
        this.addPaperDTO = addPaperDTO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
