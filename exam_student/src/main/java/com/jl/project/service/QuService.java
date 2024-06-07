package com.jl.project.service;

import com.jl.project.entity.po.Qu;
import com.jl.project.entity.query.QuQuery;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.vo.QuAndAnswerVo;

;

/**
 * @Description:题目表Service
 * @author:jingLong
 * @date:2023/11/22
 */
public interface QuService {


    PaginationResultVO<Qu> findListByPage(QuQuery query);

    /**
     * 根据Id查询
     */
    QuAndAnswerVo getQuById(String id);
}