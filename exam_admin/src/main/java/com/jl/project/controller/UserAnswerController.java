package com.jl.project.controller;

import com.jl.project.entity.dto.UpdateUserAnswerDTO;
import com.jl.project.entity.po.UserAnswer;
import com.jl.project.entity.query.UserAnswerQuery;
import com.jl.project.entity.vo.ResponseVO;
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
public class UserAnswerController extends ABaseController {

    @Resource
    private UserAnswerService userAnswerService;


    /**
     * 新增
     */
    @RequestMapping("getDataList")
    public ResponseVO getDataList(@RequestBody UserAnswerQuery userAnswerQuery) {
        List<UserAnswer> result = null;
        try {
            result = userAnswerService.findListByParam(userAnswerQuery);
        } catch (BusinessException e) {
            return getErrorResponseVO(null, e.getCode(), e.getMessage());
        }
        return getSuccessResponseVO(result);
    }

    // 根据Id更新
    @RequestMapping("updateById")
    public ResponseVO updateById(@RequestBody UpdateUserAnswerDTO userAnswer) {
        Boolean result = null;
        try {
            result = userAnswerService.updateUserAnswerById(userAnswer);
        } catch (BusinessException e) {
            return getErrorResponseVO(null, e.getCode(), e.getMessage());
        }
        return getSuccessResponseVO(result);
    }


}