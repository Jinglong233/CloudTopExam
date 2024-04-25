package com.jl.project.entity.dto;

import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.po.Subject;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 更新学科DTO
 */
@Schema(description = "更新学科DTO")
public class UpdateSubjectDTO {
    /**
     * 学科Id
     */
    @Schema(description = "学科Id")
    @VerifyParam(require = true)
    private String id;
    /**
     * 学科对象
     */
    @Schema(description = "学科对象")
    @VerifyParam(require = true)
    private Subject subject;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
