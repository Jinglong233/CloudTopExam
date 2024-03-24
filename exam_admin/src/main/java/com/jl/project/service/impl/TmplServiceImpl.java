package com.jl.project.service.impl;

import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.po.Tmpl;
import com.jl.project.entity.query.SimplePage;
import com.jl.project.entity.query.TmplQuery;
import com.jl.project.enums.PageSize;
import com.jl.project.mapper.TmplMapper;
import com.jl.project.service.TmplService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Description:消息模板表Service
 * @author:jingLong
 * @date:2023/11/22
 */
@Service("tmplService")
public class TmplServiceImpl implements TmplService {

	@Resource
	private TmplMapper<Tmpl,TmplQuery> tmplMapper;

	/**
	 * 根据条件查询列表
	 */
	public List<Tmpl> findListByParam(TmplQuery query) {
		return this.tmplMapper.selectList(query);
	}

	/**
	 * 根据条件查询数量
	 */
	public Integer findCountByParam(TmplQuery query) {
		return this.tmplMapper.selectCount(query);
	}

	/**
	 * 分页查询
	 */
	public PaginationResultVO<Tmpl> findListByPage(TmplQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<Tmpl> list = this.findListByParam(query);
		PaginationResultVO<Tmpl> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	public Integer add(Tmpl bean) {
		return this.tmplMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	public Integer addBatch(List<Tmpl> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.tmplMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或修改
	 */
	public Integer addOrUpdateBatch(List<Tmpl> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.tmplMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 根据Id查询
	 */
	public Tmpl getTmplById(String id) {
		return this.tmplMapper.selectById(id);
	}

	/**
	 * 根据Id更新
	 */
	public Integer updateTmplById(Tmpl bean, String id) {
		return this.tmplMapper.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	public Integer deleteTmplById(String id) {
		return this.tmplMapper.deleteById(id);
	}

}