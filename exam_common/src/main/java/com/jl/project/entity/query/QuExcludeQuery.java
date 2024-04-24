package com.jl.project.entity.query;

import com.jl.project.annotation.VerifyParam;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

/**
 * 问题排除查询对象
 */
@Schema(description = "问题排除查询对象")
public class QuExcludeQuery extends QuQuery{
    /**
     * 需要排除的题目Id
     */
    @Schema(description = "需要排除的题目Id")
    @VerifyParam(require = true)
    private List<String> excludes;

    public List<String> getExcludes() {
        return excludes;
    }

    public void setExcludes(List<String> excludes) {
        this.excludes = excludes;
    }
}
