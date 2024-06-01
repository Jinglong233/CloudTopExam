package com.jl.project.service;

import com.jl.project.entity.query.ErrorCountQuery;
import com.jl.project.entity.vo.ErrorVO;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.vo.WrongCountSummaryVO;
import com.jl.project.entity.vo.WrongDeptCommon;

import java.util.List;
import java.util.Map;

public interface DataAnalysisService {
    /**
     * 获取男女占比
     *
     * @return
     */
    List<Map<String, Object>> getSexProportion();

    /**
     * 获取最近考试信息
     *
     * @return
     */
    Map<String, List> getRecentExamInfo();

    WrongDeptCommon getQuTypeProportion();

    WrongDeptCommon getTopFiveWrongTopics();

    WrongDeptCommon getTemporalErrorAnalysis();

    List<WrongCountSummaryVO> getWrongCountSummary();

    List<String> getKnowledgeList();

    WrongDeptCommon getWrongDeptWrongKn(String deptCode);

    WrongDeptCommon getWrongDeptSubject(String deptCode);

    PaginationResultVO<ErrorVO> errorCount(ErrorCountQuery errorCountQuery);
}
