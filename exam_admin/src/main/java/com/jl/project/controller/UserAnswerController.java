package com.jl.project.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.util.SaResult;
import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.dto.UpdateUserAnswerDTO;
import com.jl.project.entity.po.UserAnswer;
import com.jl.project.entity.query.UserAnswerQuery;
import com.jl.project.exception.BusinessException;
import com.jl.project.service.UserAnswerService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:用户答案表Controller
 * @author:jingLong
 * @date:2023/12/11
 */
@RestController
@RequestMapping("/userAnswer")
@SaCheckLogin
@SaCheckRole("admin")
public class UserAnswerController {

    @Resource
    private UserAnswerService userAnswerService;


    /**
     * 获取用户答案
     */
    @RequestMapping("getDataList")
    @GlobalInterceptor(checkParams = true)
    public SaResult getDataList(@RequestBody @VerifyParam UserAnswerQuery userAnswerQuery) throws BusinessException {
        List<UserAnswer> result = userAnswerService.findListByParam(userAnswerQuery);
        return SaResult.ok().setData(result);
    }

    // 根据Id更新
    @RequestMapping("updateById")
    @GlobalInterceptor(checkParams = true)
    public SaResult updateById(@RequestBody UpdateUserAnswerDTO userAnswer) {
        Boolean result = userAnswerService.updateUserAnswerById(userAnswer);

        return SaResult.ok(result ? "更新成功" : "更新失败");
    }


}