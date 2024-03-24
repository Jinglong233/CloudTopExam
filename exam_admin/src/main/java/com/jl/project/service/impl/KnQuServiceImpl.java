package com.jl.project.service.impl;

import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.po.KnQu;
import com.jl.project.entity.query.SimplePage;
import com.jl.project.entity.query.KnQuQuery;
import com.jl.project.enums.PageSize;
import com.jl.project.mapper.KnQuMapper;
import com.jl.project.service.KnQuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Description:题目知识点关联表Service
 * @author:jingLong
 * @date:2023/11/22
 */
@Service("knQuService")
public class KnQuServiceImpl implements KnQuService {

	@Resource
	private KnQuMapper<KnQu,KnQuQuery> knQuMapper;

	/**
	 * 根据条件查询列表
	 */
	public List<KnQu> findListByParam(KnQuQuery query) {
		return this.knQuMapper.selectList(query);
	}

	/**
	 * 根据条件查询数量
	 */
	public Integer findCountByParam(KnQuQuery query) {
		return this.knQuMapper.selectCount(query);
	}

	/**
	 * 分页查询
	 */
	public PaginationResultVO<KnQu> findListByPage(KnQuQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<KnQu> list = this.findListByParam(query);
		PaginationResultVO<KnQu> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	public Integer add(KnQu bean) {
		return this.knQuMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	public Integer addBatch(List<KnQu> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.knQuMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或修改
	 */
	public Integer addOrUpdateBatch(List<KnQu> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.knQuMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 根据Id查询
	 */
	public KnQu getKnQuById(String id) {
		return this.knQuMapper.selectById(id);
	}

	/**
	 * 根据Id更新
	 */
	public Integer updateKnQuById(KnQu bean, String id) {
		return this.knQuMapper.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	public Integer deleteKnQuById(String id) {
		return this.knQuMapper.deleteById(id);
	}

}