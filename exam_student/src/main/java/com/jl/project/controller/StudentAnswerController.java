package com.jl.project.controller;

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
    public ResponseVO getDataList(@RequestBody UserAnswerQuery userAnswerQuery) {
        List<UserAnswer> result = null;
        try {
            result = studentAnswerService.findListByParam(userAnswerQuery);
        } catch (BusinessException e) {
            return getErrorResponseVO(null, e.getCode(), e.getMessage());
        }
        return getSuccessResponseVO(result);
    }


    /**
     * 新增
     */
    @RequestMapping("add")
    public ResponseVO add(@RequestBody AddUserAnswerDTO addUserAnswerDTO) {

        List<UserAnswer> result = null;
        try {
            result = studentAnswerService.add(addUserAnswerDTO);
        } catch (BusinessException e) {
            return getErrorResponseVO("添加失败", e.getCode(), e.getMessage());
        }
        return getSuccessResponseVO(result);
    }

    /**
     * 根据Id更新
     */
    @RequestMapping("updateStudentAnswerById")
    public ResponseVO updateUserAnswerById(@RequestBody CorrectUserAnswerDTO correctUserAnswerDTO) {
        List<UserAnswer> result = null;
        try {
            result = studentAnswerService.updateUserAnswerById(correctUserAnswerDTO);
        } catch (BusinessException e) {
            return getErrorResponseVO(null, e.getCode(), e.getMessage());
        }
        return getSuccessResponseVO(result);
    }


    /**
     * 根据条件分页查询
     */
    @RequestMapping("loadDataList")
    public ResponseVO loadDatalist(UserAnswerQuery query) {
        return getSuccessResponseVO(studentAnswerService.findListByPage(query));
    }


    /**
     * 批量新增
     */
    @RequestMapping("addBatch")
    public ResponseVO addBatch(@RequestBody List<UserAnswer> listBean) {

        return getSuccessResponseVO(studentAnswerService.addBatch(listBean));
    }

    /**
     * 批量新增或修改
     */
    @RequestMapping("addOrUpdateBatch")
    public ResponseVO addOrUpdateBatch(@RequestBody List<UserAnswer> listBean) {
        return getSuccessResponseVO(this.studentAnswerService.addOrUpdateBatch(listBean));
    }

    /**
     * 根据Id查询
     */

    @RequestMapping("getUserAnswerById")
    public ResponseVO getUserAnswerById(String id) {
        return getSuccessResponseVO(this.studentAnswerService.getUserAnswerById(id));
    }


    /**
     * 根据Id删除
     */
    @RequestMapping("deleteUserAnswerById")
    public ResponseVO deleteUserAnswerById(String id) {
        this.studentAnswerService.deleteUserAnswerById(id);
        return getSuccessResponseVO(null);
    }


    /**
     * 获取错题统计
     *
     * @param userId
     * @return
     */
    @RequestMapping("errorCount")
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