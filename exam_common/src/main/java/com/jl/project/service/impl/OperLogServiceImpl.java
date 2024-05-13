package com.jl.project.service.impl;

import com.jl.project.entity.po.OperLog;
import com.jl.project.entity.query.OperLogQuery;
import com.jl.project.entity.query.SimplePage;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.enums.PageSize;
import com.jl.project.mapper.OperLogMapper;
import com.jl.project.service.OperLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

;
/**
 * @Description:操作日志表Service
 * @author:jingLong
 * @date:2024/05/08
 */
@Service("operLogService")
public class OperLogServiceImpl implements OperLogService {

	@Resource
	private OperLogMapper<OperLog,OperLogQuery> operLogMapper;

	/**
	 * 根据条件查询列表
	 */
	public List<OperLog> findListByParam(OperLogQuery query) {
		return this.operLogMapper.selectList(query);
	}

	/**
	 * 根据条件查询数量
	 */
	public Integer findCountByParam(OperLogQuery query) {
		return this.operLogMapper.selectCount(query);
	}

	/**
	 * 分页查询
	 */
	public PaginationResultVO<OperLog> findListByPage(OperLogQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<OperLog> list = this.findListByParam(query);
		PaginationResultVO<OperLog> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	public Integer add(OperLog bean) {
		return this.operLogMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	public Integer addBatch(List<OperLog> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.operLogMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或修改
	 */
	public Integer addOrUpdateBatch(List<OperLog> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.operLogMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 根据Id查询
	 */
	public OperLog getOperLogById(Integer id) {
		return this.operLogMapper.selectById(id);
	}

	/**
	 * 根据Id更新
	 */
	public Integer updateOperLogById(OperLog bean, Integer id) {
		return this.operLogMapper.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	public Integer deleteOperLogById(Integer id) {
		return this.operLogMapper.deleteById(id);
	}

}