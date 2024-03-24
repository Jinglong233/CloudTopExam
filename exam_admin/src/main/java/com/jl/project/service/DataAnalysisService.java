package com.jl.project.service;

import java.util.List;
import java.util.Map;

public interface DataAnalysisService {
    /**
     * 获取男女占比
     * @return
     */
    List<Map<String,Object>> getSexProportion();

    /**
     * 获取最近考试信息
     * @return
     */
    Map<String, List> getRecentExamInfo();
}
