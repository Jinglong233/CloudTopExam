package com.jl.project.controller;

import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.exception.BusinessException;
import com.jl.project.service.DataAnalysisService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dataAnalysis")
public class DataAnalysisController extends ABaseController{

    @Resource
    private DataAnalysisService dataAnalysisService;

    /**
     * 获取男女占比
     * @return
     */
    @RequestMapping("sexProportion")
    public ResponseVO getSexProportion() {
        List<Map<String,Object>> result = null;
        try {
            result = dataAnalysisService.getSexProportion();
        } catch (BusinessException e) {
            return getErrorResponseVO(null,e.getCode(),e.getMessage());
        }
        return getSuccessResponseVO(result);
    }


    /**
     * 获取最近其他考试信息
     * @return
     */
    @RequestMapping("recentExamInfo")
    public ResponseVO getRecentExamInfo() {
        Map<String,List> result = null;
        try {
            result = dataAnalysisService.getRecentExamInfo();
        } catch (BusinessException e) {
            return getErrorResponseVO(null,e.getCode(),e.getMessage());
        }
        return getSuccessResponseVO(result);
    }
}
