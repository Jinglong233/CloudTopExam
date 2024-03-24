package com.jl.project.service.impl;

import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.po.QuAnswer;
import com.jl.project.entity.query.SimplePage;
import com.jl.project.entity.query.QuAnswerQuery;
import com.jl.project.enums.PageSize;
import com.jl.project.mapper.QuAnswerMapper;
import com.jl.project.service.QuAnswerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Description:题目答案表Service
 * @author:jingLong
 * @date:2023/11/22
 */
@Service("quAnswerService")
public class QuAnswerServiceImpl implements QuAnswerService {

	@Resource
	private QuAnswerMapper<QuAnswer,QuAnswerQuery> quAnswerMapper;

	/**
	 * 根据条件查询列表
	 */
	public List<QuAnswer> findListByParam(QuAnswerQuery query) {
		return this.quAnswerMapper.selectList(query);
	}

	/**
	 * 根据条件查询数量
	 */
	public Integer findCountByParam(QuAnswerQuery query) {
		return this.quAnswerMapper.selectCount(query);
	}

	/**
	 * 分页查询
	 */
	public PaginationResultVO<QuAnswer> findListByPage(QuAnswerQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<QuAnswer> list = this.findListByParam(query);
		PaginationResultVO<QuAnswer> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	public Integer add(QuAnswer bean) {
		return this.quAnswerMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	public Integer addBatch(List<QuAnswer> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.quAnswerMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或修改
	 */
	public Integer addOrUpdateBatch(List<QuAnswer> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.quAnswerMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 根据Id查询
	 */
	public QuAnswer getQuAnswerById(String id) {
		return this.quAnswerMapper.selectById(id);
	}

	/**
	 * 根据Id更新
	 */
	public Integer updateQuAnswerById(QuAnswer bean, String id) {
		return this.quAnswerMapper.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	public Integer deleteQuAnswerById(String id) {
		return this.quAnswerMapper.deleteById(id);
	}

}