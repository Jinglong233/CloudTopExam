package com.jl.project.controller;

import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.dto.AddUserAnswerDTO;
import com.jl.project.entity.po.UserAnswer;
import com.jl.project.entity.query.UserAnswerQuery;
import com.jl.project.entity.vo.CorrectUserAnswerDTO;
import com.jl.project.entity.vo.ErrorVO;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.exception.BusinessException;
import com.jl.project.service.StudentAnswerService;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "用户答案表Controller", description = "用户答案表Controller")
@RestController
@RequestMapping("/studentAnswer")
public class StudentAnswerController extends ABaseController {

    @Resource
    private StudentAnswerService studentAnswerService;


    /**
     * 新增
     */
    @RequestMapping("getDataList")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO getDataList(@RequestBody @VerifyParam UserAnswerQuery userAnswerQuery) {
        List<UserAnswer> result = studentAnswerService.findListByParam(userAnswerQuery);
        return getSuccessResponseVO(result);
    }


    /**
     * 新增
     */
    @RequestMapping("add")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO add(@RequestBody @VerifyParam AddUserAnswerDTO addUserAnswerDTO) {
        List<UserAnswer> result = studentAnswerService.add(addUserAnswerDTO);
        return getSuccessResponseVO(result);
    }

    /**
     * 根据Id更新
     */
    @RequestMapping("updateStudentAnswerById")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO updateUserAnswerById(@RequestBody @VerifyParam CorrectUserAnswerDTO correctUserAnswerDTO) {
        List<UserAnswer> result = studentAnswerService.updateUserAnswerById(correctUserAnswerDTO);
        return getSuccessResponseVO(result);
    }

    /**
     * 获取错题统计
     *
     * @param userId
     * @return
     */
    @RequestMapping("errorCount")
    @GlobalInterceptor(checkLogin = true, checkStudent = true, checkParams = true)
    public ResponseVO errorCount(@RequestBody String userId) {
        List<ErrorVO> result = null;
        try {
            result = studentAnswerService.errorCount(userId);
        } catch (BusinessException e) {
            return getErrorResponseVO(null, e.getCode(), e.getMessage());
        }
        return getSuccessResponseVO(result);
    }


}