package com.jl.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.jl.project.entity.po.Repo;
import com.jl.project.entity.query.RepoQuery;
import com.jl.project.exception.BusinessException;
import com.jl.project.mapper.RepoMapper;
import com.jl.project.service.StudentTrainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("studentTrainService")
public class StudentTrainServiceImpl implements StudentTrainService {

    @Resource
    private RepoMapper<Repo, RepoQuery> repoMapper;


    @Override
    public List<Repo> getRepoList(RepoQuery repoQuery) {
        if (repoQuery == null) {
            throw new BusinessException("缺少参数");
        }
        List<Repo> repos = repoMapper.selectList(repoQuery);
        return repos;
    }
}