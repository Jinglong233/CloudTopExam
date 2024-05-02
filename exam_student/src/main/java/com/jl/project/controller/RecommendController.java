package com.jl.project.controller;

import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.entity.vo.ResponseVO;
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
public class RecommendController extends ABaseController {
    @Resource
    private RecommendService recommendService;

    /**
     * getRecommendUserList
     * 推荐当前登录用户可关注的用户列表
     *
     * @return
     */
    @RequestMapping(value = "getRecommendQuList")
    @GlobalInterceptor(checkLogin = true, checkStudent = true)
    public ResponseVO getRecommendQuList() {
        List<String> result = recommendService.getRecommendQuList();
        return getSuccessResponseVO(result);
    }
}
