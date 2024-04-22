package com.jl.project.service;

import com.jl.project.entity.vo.QuAndAnswerVo;

;

/**
 * @Description:题目表Service
 * @author:jingLong
 * @date:2023/11/22
 */
public interface QuService {


    /**
     * 根据Id查询
     */
    QuAndAnswerVo getQuById(String id);
}