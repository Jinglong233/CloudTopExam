package com.jl.project.service;

import com.jl.project.entity.dto.AddUserAnswerDTO;
import com.jl.project.entity.po.UserAnswer;
import com.jl.project.entity.query.BookQuery;
import com.jl.project.entity.query.UserAnswerQuery;
import com.jl.project.entity.vo.CorrectUserAnswerDTO;
import com.jl.project.entity.vo.ErrorVO;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.vo.WrongKnowledgeVO;

import java.util.List;

/**
 * @Description:用户答案表Service
 * @author:jingLong
 * @date:2023/12/11
 */
public interface StudentAnswerService {

    /**
     * 根据条件查询列表
     */
    List<UserAnswer> findListByParam(UserAnswerQuery query);

    /**
     * 根据条件查询数量
     */
    Integer findCountByParam(UserAnswerQuery param);

    /**
     * 分页查询
     */
    PaginationResultVO<UserAnswer> findListByPage(UserAnswerQuery query);

    /**
     * 新增
     */
    List<UserAnswer> add(AddUserAnswerDTO addUserAnswerDTO);

    /**
     * 批量新增
     */
    Integer addBatch(List<UserAnswer> listBean);

    /**
     * 批量新增或修改
     */
    Integer addOrUpdateBatch(List<UserAnswer> listBean);

    /**
     * 根据Id查询
     */
    UserAnswer getUserAnswerById(String id);

    /**
     * 根据Id更新
     */
    List<UserAnswer> updateUserAnswerById(CorrectUserAnswerDTO correctUserAnswerDTO);

    /**
     * 根据Id删除
     */
    Integer deleteUserAnswerById(String id);

    PaginationResultVO<ErrorVO> errorCount(BookQuery bookQuery);

    WrongKnowledgeVO getErrorKnowledge();
}