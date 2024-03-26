package com.jl.project.entity.dto;

import com.jl.project.entity.po.Repo;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 更新题库DTO
 */
@Schema(description = "更新题库DTO")
public class UpdateRepoDTO {
    /**
     * 题库对象
     */
    @Schema(description = "题库对象")
    private Repo repo;
    /**
     * 题目Id
     */
    @Schema(description = "题目Id")
    private String id;

    public Repo getRepo() {
        return repo;
    }

    public void setRepo(Repo repo) {
        this.repo = repo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
