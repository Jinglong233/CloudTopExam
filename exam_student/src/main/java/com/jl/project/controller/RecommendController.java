package com.jl.project.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.util.SaResult;
import com.jl.project.service.RecommendService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 推荐器请求API
 */
@RestController
@RequestMapping("/recommend")
@SaCheckLogin
@SaCheckRole("student")
public class RecommendController{
    @Resource
    private RecommendService recommendService;

    /**
     * getRecommendUserList
     * 推荐当前登录用户可关注的用户列表
     *
     * @return
     */
    @RequestMapping(value = "getRecommendQuList")
    public SaResult getRecommendQuList() {
        List<String> result = recommendService.getRecommendQuList();
        return SaResult.ok().setData(result);
    }
}
