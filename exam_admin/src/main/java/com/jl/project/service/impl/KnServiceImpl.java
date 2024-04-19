package com.jl.project.service.impl;

import com.jl.project.entity.po.Kn;
import com.jl.project.entity.query.KnQuery;
import com.jl.project.entity.query.SimplePage;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.enums.PageSize;
import com.jl.project.mapper.KnMapper;
import com.jl.project.service.KnService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

;
/**
 * @Description:知识点表Service
 * @author:jingLong
 * @date:2023/11/22
 */
@Service("knService")
public class KnServiceImpl implements KnService {

	@Resource
	private KnMapper<Kn,KnQuery> knMapper;

	/**
	 * 根据条件查询列表
	 */
	public List<Kn> findListByParam(KnQuery query) {
		return this.knMapper.selectList(query);
	}

	/**
	 * 根据条件查询数量
	 */
	public Integer findCountByParam(KnQuery query) {
		return this.knMapper.selectCount(query);
	}

	/**
	 * 分页查询
	 */
	public PaginationResultVO<Kn> findListByPage(KnQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<Kn> list = this.findListByParam(query);
		PaginationResultVO<Kn> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	public Integer add(Kn bean) {
		return this.knMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	public Integer addBatch(List<Kn> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.knMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或修改
	 */
	public Integer addOrUpdateBatch(List<Kn> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.knMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 根据Id查询
	 */
	public Kn getKnById(String id) {
		return this.knMapper.selectById(id);
	}

	/**
	 * 根据Id更新
	 */
	public Integer updateKnById(Kn bean, String id) {
		return this.knMapper.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	public Integer deleteKnById(String id) {
		return this.knMapper.deleteById(id);
	}

}