package com.jl.project.service.impl;

import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.po.WrongAnswer;
import com.jl.project.entity.query.SimplePage;
import com.jl.project.entity.query.WrongAnswerQuery;
import com.jl.project.enums.PageSize;
import com.jl.project.mapper.WrongAnswerMapper;
import com.jl.project.service.WrongAnswerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Description:错题答案表Service
 * @author:jingLong
 * @date:2024/05/29
 */
@Service("wrongAnswerService")
public class WrongAnswerServiceImpl implements WrongAnswerService {

	@Resource
	private WrongAnswerMapper<WrongAnswer,WrongAnswerQuery> wrongAnswerMapper;

	/**
	 * 根据条件查询列表
	 */
	public List<WrongAnswer> findListByParam(WrongAnswerQuery query) {
		return this.wrongAnswerMapper.selectList(query);
	}

	/**
	 * 根据条件查询数量
	 */
	public Integer findCountByParam(WrongAnswerQuery query) {
		return this.wrongAnswerMapper.selectCount(query);
	}

	/**
	 * 分页查询
	 */
	public PaginationResultVO<WrongAnswer> findListByPage(WrongAnswerQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<WrongAnswer> list = this.findListByParam(query);
		PaginationResultVO<WrongAnswer> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	public Integer add(WrongAnswer bean) {
		return this.wrongAnswerMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	public Integer addBatch(List<WrongAnswer> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.wrongAnswerMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或修改
	 */
	public Integer addOrUpdateBatch(List<WrongAnswer> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.wrongAnswerMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 根据Id查询
	 */
	public WrongAnswer getWrongAnswerById(Integer id) {
		return this.wrongAnswerMapper.selectById(id);
	}

	/**
	 * 根据Id更新
	 */
	public Integer updateWrongAnswerById(WrongAnswer bean, Integer id) {
		return this.wrongAnswerMapper.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	public Integer deleteWrongAnswerById(Integer id) {
		return this.wrongAnswerMapper.deleteById(id);
	}

}