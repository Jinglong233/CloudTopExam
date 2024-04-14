package com.jl.project.service;

import com.jl.project.entity.dto.AddExamDTO;
import com.jl.project.entity.dto.UpdateExamDTO;
import com.jl.project.entity.po.Exam;
import com.jl.project.entity.query.ExamQuery;
import com.jl.project.entity.vo.CorrectExamVO;
import com.jl.project.entity.vo.ExamVO;
import com.jl.project.entity.vo.PaginationResultVO;

import java.util.Date;
import java.util.List;

;

/**
 * @Description:考试表Service
 * @author:jingLong
 * @date:2023/11/22
 */
public interface ExamService {

    /**
     * 根据条件查询列表
     */
    List<Exam> findListByParam(ExamQuery query);

    /**
     * 根据条件查询数量
     */
    Integer findCountByParam(ExamQuery param);

    /**
     * 分页查询
     */
    PaginationResultVO<Exam> findListByPage(ExamQuery query);

    /**
     * 新增
     */
    Boolean add(AddExamDTO addExamDTO);

    /**
     * 批量新增
     */
    Integer addBatch(List<Exam> listBean);

    /**
     * 批量新增或修改
     */
    Integer addOrUpdateBatch(List<Exam> listBean);

    /**
     * 根据Id查询
     */
    ExamVO getExamById(String id);

    /**
     * 根据Id更新
     */
    Boolean updateExamById(UpdateExamDTO updateExamDTO);

    /**
     * 根据Id删除
     */
    Boolean deleteExamById(String id);


    /**
     * 查询考试
     *
     * @param query
     * @return
     */
    PaginationResultVO<ExamVO> loadDatalist(ExamQuery query);

    /**
     * 获取服务端时间
     *
     * @return
     */
    Date getServerTime();

    List<ExamVO> getExamInfoByUserId(String userId);


    /**
     * 获取阅卷信息
     *
     * @param examId
     * @return
     */
    PaginationResultVO<CorrectExamVO> getCorrectExam(ExamQuery examQuery);

    List<CorrectExamVO> getCorrectExamByParam(ExamQuery query);
}