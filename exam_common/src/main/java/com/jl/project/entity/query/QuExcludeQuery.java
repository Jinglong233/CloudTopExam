package com.jl.project.entity.query;

import java.util.List;

public class QuExcludeQuery extends QuQuery{
    private List<String> excludes;

    public List<String> getExcludes() {
        return excludes;
    }

    public void setExcludes(List<String> excludes) {
        this.excludes = excludes;
    }
}
