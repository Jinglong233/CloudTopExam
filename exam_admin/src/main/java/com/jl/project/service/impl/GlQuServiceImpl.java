package com.jl.project.service.impl;

import com.jl.project.entity.po.GlQu;
import com.jl.project.entity.query.GlQuQuery;
import com.jl.project.entity.query.SimplePage;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.enums.PageSize;
import com.jl.project.mapper.GlQuMapper;
import com.jl.project.service.GlQuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Description:大题题目关联表Service
 * @author:jingLong
 * @date:2023/11/22
 */
@Service("glQuService")
public class GlQuServiceImpl implements GlQuService {

	@Resource
	private GlQuMapper<GlQu,GlQuQuery> glQuMapper;

	/**
	 * 根据条件查询列表
	 */
	public List<GlQu> findListByParam(GlQuQuery query) {
		return this.glQuMapper.selectList(query);
	}

	/**
	 * 根据条件查询数量
	 */
	public Integer findCountByParam(GlQuQuery query) {
		return this.glQuMapper.selectCount(query);
	}

	/**
	 * 分页查询
	 */
	public PaginationResultVO<GlQu> findListByPage(GlQuQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<GlQu> list = this.findListByParam(query);
		PaginationResultVO<GlQu> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	public Integer add(GlQu bean) {
		return this.glQuMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	public Integer addBatch(List<GlQu> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.glQuMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或修改
	 */
	public Integer addOrUpdateBatch(List<GlQu> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.glQuMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 根据Id查询
	 */
	public GlQu getGlQuById(String id) {
		return this.glQuMapper.selectById(id);
	}

	/**
	 * 根据Id更新
	 */
	public Integer updateGlQuById(GlQu bean, String id) {
		return this.glQuMapper.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	public Integer deleteGlQuById(String id) {
		return this.glQuMapper.deleteById(id);
	}

}