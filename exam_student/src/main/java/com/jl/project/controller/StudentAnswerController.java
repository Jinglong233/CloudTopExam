package com.jl.project.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.util.SaResult;
import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.dto.AddUserAnswerDTO;
import com.jl.project.entity.po.UserAnswer;
import com.jl.project.entity.query.BookQuery;
import com.jl.project.entity.query.UserAnswerQuery;
import com.jl.project.entity.vo.CorrectUserAnswerDTO;
import com.jl.project.entity.vo.ErrorVO;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.vo.WrongKnowledgeVO;
import com.jl.project.service.StudentAnswerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "学生答案操作")
@RestController
@RequestMapping("/studentAnswer")
@SaCheckLogin
@SaCheckRole("student")
public class StudentAnswerController {

    @Resource
    private StudentAnswerService studentAnswerService;


    /**
     * 获取用户作答列表
     */
    @ApiOperation("获取用户作答列表")
    @RequestMapping("getDataList")
    @GlobalInterceptor(checkParams = true)
    public SaResult getDataList(@RequestBody @VerifyParam UserAnswerQuery userAnswerQuery) {
        List<UserAnswer> result = studentAnswerService.findListByParam(userAnswerQuery);
        return SaResult.ok().setData(result);
    }


    /**
     * 新增
     */
    @ApiOperation("新增")
    @RequestMapping("add")
    @GlobalInterceptor(checkParams = true)
    public SaResult add(@RequestBody @VerifyParam AddUserAnswerDTO addUserAnswerDTO) {
        List<UserAnswer> result = studentAnswerService.add(addUserAnswerDTO);
        return SaResult.ok().setData(result);
    }

    /**
     * 根据Id更新
     */
    @ApiOperation("根据Id更新")
    @RequestMapping("updateStudentAnswerById")
    @GlobalInterceptor(checkParams = true)
    public SaResult updateUserAnswerById(@RequestBody @VerifyParam CorrectUserAnswerDTO correctUserAnswerDTO) {
        List<UserAnswer> result = studentAnswerService.updateUserAnswerById(correctUserAnswerDTO);
        return SaResult.ok().setData(result);
    }

    /**
     * 获取错题统计
     *
     * @param bookQuery
     * @return
     */
    @ApiOperation("获取错题统计")
    @RequestMapping("errorCount")
    @GlobalInterceptor(checkParams = true)
    public SaResult errorCount(@RequestBody BookQuery bookQuery) {
        PaginationResultVO<ErrorVO>
                result = studentAnswerService.errorCount(bookQuery);
        return SaResult.ok().setData(result);

    }


    /**
     * 获取错题知识点列表数量
     *
     * @return
     */
    @ApiOperation("获取错题知识点列表数量")
    @RequestMapping("errorKnowledge")
    @GlobalInterceptor(checkParams = true)
    public SaResult getErrorKnowledge() {
        WrongKnowledgeVO
                result = studentAnswerService.getErrorKnowledge();
        return SaResult.ok().setData(result);

    }

}