package com.jl.project.controller;

import com.jl.project.entity.vo.QuAndAnswerVo;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.exception.BusinessException;
import com.jl.project.service.QuService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:题目表Controller
 * @author:jingLong
 * @date:2023/11/22
 */
@RestController
@RequestMapping("/student")
public class QuController extends ABaseController {

    @Resource
    private QuService quService;


    /**
     * 根据Id查询
     */
    @RequestMapping("getQuById")
    public ResponseVO getQuById(@RequestBody String id) throws BusinessException {
        QuAndAnswerVo result = quService.getQuById(id);
        return getSuccessResponseVO(result);
    }


}