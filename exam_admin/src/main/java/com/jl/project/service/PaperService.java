package com.jl.project.service;

import com.jl.project.entity.dto.AddPaperDTO;
import com.jl.project.entity.dto.UpdatePaperAndQuDTO;
import com.jl.project.entity.po.Paper;
import com.jl.project.entity.query.PaperQuery;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.vo.PaperAndQuVO;
import com.jl.project.exception.BusinessException;

import java.util.List;


/**
 * @Description:试卷表Service
 * @author:jingLong
 * @date:2023/11/22
 */
public interface PaperService {

    /**
     * 根据条件查询列表
     */
    List<Paper> findListByParam(PaperQuery query);

    /**
     * 根据条件查询数量
     */
    Integer findCountByParam(PaperQuery param);

    /**
     * 分页查询
     */
    PaginationResultVO<Paper> findListByPage(PaperQuery query);

    /**
     * 新增
     */
    Boolean add(AddPaperDTO paperDTO) throws BusinessException;

    /**
     * 批量新增
     */
    Integer addBatch(List<Paper> listBean);

    /**
     * 批量新增或修改
     */
    Integer addOrUpdateBatch(List<Paper> listBean);

    /**
     * 根据Id查询
     */
    Paper getPaperById(String id);

    /**
     * 根据Id更新
     */
    Boolean updatePaperById(UpdatePaperAndQuDTO bean);

    /**
     * 根据Id删除
     */
    Boolean deletePaperById(String id);

    /**
     * 根据Id查询试卷详细信息
     * @param id
     * @return
     */
    PaperAndQuVO getPaperDetailById(String id);

    /**
     * 获取试卷总数
     * @param paperQuery
     * @return
     */
    Integer getPaperCount(PaperQuery paperQuery);

    /**
     * 根据条件分页查询
     * @param query
     * @return
     */
    PaginationResultVO<Paper> loadDatalist(PaperQuery query);

}