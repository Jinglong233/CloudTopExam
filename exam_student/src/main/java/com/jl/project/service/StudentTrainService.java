package com.jl.project.service;

import com.jl.project.entity.po.Repo;
import com.jl.project.entity.query.RepoQuery;

import java.util.List;

public interface StudentTrainService {
    public List<Repo> getRepoList(RepoQuery repoQuery);
}
