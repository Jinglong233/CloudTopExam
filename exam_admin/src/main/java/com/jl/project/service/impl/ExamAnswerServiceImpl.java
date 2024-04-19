package com.jl.project.service.impl;

import com.jl.project.entity.po.ExamAnswer;
import com.jl.project.entity.query.ExamAnswerQuery;
import com.jl.project.entity.query.SimplePage;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.enums.PageSize;
import com.jl.project.mapper.ExamAnswerMapper;
import com.jl.project.service.ExamAnswerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Description:考试答案表Service
 * @author:jingLong
 * @date:2023/11/22
 */
@Service("examAnswerService")
public class ExamAnswerServiceImpl implements ExamAnswerService {

	@Resource
	private ExamAnswerMapper<ExamAnswer,ExamAnswerQuery> examAnswerMapper;

	/**
	 * 根据条件查询列表
	 */
	public List<ExamAnswer> findListByParam(ExamAnswerQuery query) {
		return this.examAnswerMapper.selectList(query);
	}

	/**
	 * 根据条件查询数量
	 */
	public Integer findCountByParam(ExamAnswerQuery query) {
		return this.examAnswerMapper.selectCount(query);
	}

	/**
	 * 分页查询
	 */
	public PaginationResultVO<ExamAnswer> findListByPage(ExamAnswerQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<ExamAnswer> list = this.findListByParam(query);
		PaginationResultVO<ExamAnswer> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	public Integer add(ExamAnswer bean) {
		return this.examAnswerMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	public Integer addBatch(List<ExamAnswer> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.examAnswerMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或修改
	 */
	public Integer addOrUpdateBatch(List<ExamAnswer> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.examAnswerMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 根据Id查询
	 */
	public ExamAnswer getExamAnswerById(String id) {
		return this.examAnswerMapper.selectById(id);
	}

	/**
	 * 根据Id更新
	 */
	public Integer updateExamAnswerById(ExamAnswer bean, String id) {
		return this.examAnswerMapper.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	public Integer deleteExamAnswerById(String id) {
		return this.examAnswerMapper.deleteById(id);
	}

}