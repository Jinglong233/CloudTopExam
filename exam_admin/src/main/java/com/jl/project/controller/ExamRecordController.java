package com.jl.project.controller;

import com.jl.project.entity.dto.UpdateExamRecordDTO;
import com.jl.project.entity.po.ExamRecord;
import com.jl.project.entity.query.ExamRecordQuery;
import com.jl.project.entity.vo.CorrectUserExamUserVO;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.exception.BusinessException;
import com.jl.project.service.ExamRecordService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:考试记录表Controller
 * @author:jingLong
 * @date:2023/11/22
 */
@RestController
@RequestMapping("/examRecord")
public class ExamRecordController extends ABaseController {

    @Resource
    private ExamRecordService examRecordService;

    /**
     * 根据条件分页查询
     */
    @RequestMapping("loadDataList")
    public ResponseVO loadDatalist(@RequestBody ExamRecordQuery query) {
        return getSuccessResponseVO(examRecordService.findListByPage(query));
    }

    /**
     * 根据考试Id获取考试记录
     */
    @RequestMapping("getExamRecordByExamId")
    public ResponseVO getExamRecordByExamId(@RequestBody ExamRecordQuery examRecordQuery) {
        PaginationResultVO<CorrectUserExamUserVO> result = null;
        try {
            result = examRecordService.getExamRecordByExamId(examRecordQuery);
        } catch (BusinessException e) {
            return getErrorResponseVO(null, e.getCode(), e.getMessage());
        }
        return getSuccessResponseVO(result);
    }


    /**
     * 根据Id更新
     */
    @RequestMapping("updateExamRecordById")
    public ResponseVO updateExamRecordById(@RequestBody UpdateExamRecordDTO updateExamRecordDTO) {
        Boolean result = null;
        try {
            result = examRecordService.updateExamRecordById(updateExamRecordDTO);
        } catch (BusinessException e) {
            return getErrorResponseVO(null, e.getCode(), e.getMessage());
        }
        return getSuccessResponseVO(result);
    }


    /**
     * 新增
     */
    @RequestMapping("add")
    public ResponseVO add(ExamRecord bean) {
        return getSuccessResponseVO(this.examRecordService.add(bean));
    }

    /**
     * 批量新增
     */
    @RequestMapping("addBatch")
    public ResponseVO addBatch(@RequestBody List<ExamRecord> listBean) {
        return getSuccessResponseVO(this.examRecordService.addBatch(listBean));
    }

    /**
     * 批量新增或修改
     */
    @RequestMapping("addOrUpdateBatch")
    public ResponseVO addOrUpdateBatch(@RequestBody List<ExamRecord> listBean) {
        return getSuccessResponseVO(this.examRecordService.addOrUpdateBatch(listBean));
    }

    /**
     * 根据Id查询
     */

    @RequestMapping("getExamRecordById")
    public ResponseVO getExamRecordById(@RequestBody String id) {
        return getSuccessResponseVO(this.examRecordService.getExamRecordById(id));
    }


    /**
     * 根据Id删除
     */
    @RequestMapping("deleteExamRecordById")
    public ResponseVO deleteExamRecordById(String id) {
        this.examRecordService.deleteExamRecordById(id);
        return getSuccessResponseVO(null);
    }

}