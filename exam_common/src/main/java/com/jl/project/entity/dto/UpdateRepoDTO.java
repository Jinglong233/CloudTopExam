package com.jl.project.entity.dto;

import com.jl.project.entity.po.Repo;

public class UpdateRepoDTO {
    private Repo repo;
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
