package com.jl.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.jl.project.entity.po.Qu;
import com.jl.project.entity.po.QuAnswer;
import com.jl.project.entity.query.QuAnswerQuery;
import com.jl.project.entity.query.QuQuery;
import com.jl.project.entity.query.SimplePage;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.vo.QuAndAnswerVo;
import com.jl.project.enums.PageSize;
import com.jl.project.enums.QuType;
import com.jl.project.exception.BusinessException;
import com.jl.project.mapper.QuAnswerMapper;
import com.jl.project.mapper.QuMapper;
import com.jl.project.service.QuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

;

/**
 * @Description:题目表Service
 * @author:jingLong
 * @date:2023/11/22
 */
@Service("quService")
public class QuServiceImpl implements QuService {

    @Resource
    private QuMapper<Qu, QuQuery> quMapper;

    @Resource
    private QuAnswerMapper<QuAnswer, QuAnswerQuery> quAnswerMapper;


    /**
     * 根据条件查询列表
     */
    public List<Qu> findListByParam(QuQuery query) {
        return this.quMapper.selectList(query);
    }

    /**
     * 根据条件查询数量
     */
    public Integer findCountByParam(QuQuery query) {
        return this.quMapper.selectCount(query);
    }

    /**
     * 分页查询
     */
    @Override
    public PaginationResultVO<Qu> findListByPage(QuQuery query) {
        Integer count = this.findCountByParam(query);
        Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
        SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
        query.setSimplePage(page);
        List<Qu> list = this.findListByParam(query);
        PaginationResultVO<Qu> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
        return result;
    }


    /**
     * 根据Id查询
     */
    public QuAndAnswerVo getQuById(String id) throws BusinessException {
        if (id == null) {
            throw new BusinessException("缺少参数");
        }
        QuAndAnswerVo quAndAnswerVo = new QuAndAnswerVo();
        Qu qu = quMapper.selectById(id);
        if (qu == null) {
            throw new BusinessException("题目不存在");
        }
        BeanUtil.copyProperties(qu, quAndAnswerVo);
        String quId = qu.getId();
        // 获取关联选项(根据tag保证顺序)
        QuAnswerQuery quAnswerQuery = new QuAnswerQuery();
        quAnswerQuery.setQuId(quId);
        List<QuAnswer> quAnswerList = quAnswerMapper.selectList(quAnswerQuery);
        if (quAnswerList != null && quAnswerList.size() != 0) {
            if (qu.getQuType().equals(QuType.RADIO.getValue()) ||
                    qu.getQuType().equals(QuType.MULTI.getValue())) {
                quAnswerList = quAnswerList.stream()
                        .sorted(Comparator.comparing(QuAnswer::getTag))
                        .collect(Collectors.toList());
            }

            quAndAnswerVo.setQuAnswerList(quAnswerList);
        }
        return quAndAnswerVo;
    }


}