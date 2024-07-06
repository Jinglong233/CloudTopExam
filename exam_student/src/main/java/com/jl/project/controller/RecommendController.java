package com.jl.project.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.util.SaResult;
import com.jl.project.service.RecommendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description: 题目推荐请Controller
 * author: jingLong
 * date: 2023/11/22
 */
@Api(tags = "题目推荐")
@RestController
@RequestMapping("/recommend")
@SaCheckLogin
@SaCheckRole("student")
public class RecommendController{
    @Resource
    private RecommendService recommendService;

    /**
     * getRecommendUserList
     * 推荐当前登录用户可训练题目id
     *
     * @return
     */
    @ApiOperation("推荐当前登录用户可训练题目id")
    @RequestMapping(value = "getRecommendQuList")
    public SaResult getRecommendQuList() {
        List<String> result = recommendService.getRecommendQuList();
        return SaResult.ok().setData(result);
    }
}
