package com.jl.project.service.impl;

;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.po.Log;
import com.jl.project.entity.query.SimplePage;
import com.jl.project.entity.query.LogQuery;
import com.jl.project.enums.PageSize;
import com.jl.project.mapper.LogMapper;
import com.jl.project.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Description:日志表Service
 * @author:jingLong
 * @date:2023/11/22
 */
@Service("logService")
public class LogServiceImpl implements LogService {

	@Resource
	private LogMapper<Log,LogQuery> logMapper;

	/**
	 * 根据条件查询列表
	 */
	public List<Log> findListByParam(LogQuery query) {
		return this.logMapper.selectList(query);
	}

	/**
	 * 根据条件查询数量
	 */
	public Integer findCountByParam(LogQuery query) {
		return this.logMapper.selectCount(query);
	}

	/**
	 * 分页查询
	 */
	public PaginationResultVO<Log> findListByPage(LogQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<Log> list = this.findListByParam(query);
		PaginationResultVO<Log> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	public Integer add(Log bean) {
		return this.logMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	public Integer addBatch(List<Log> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.logMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或修改
	 */
	public Integer addOrUpdateBatch(List<Log> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.logMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 根据Id查询
	 */
	public Log getLogById(String id) {
		return this.logMapper.selectById(id);
	}

	/**
	 * 根据Id更新
	 */
	public Integer updateLogById(Log bean, String id) {
		return this.logMapper.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	public Integer deleteLogById(String id) {
		return this.logMapper.deleteById(id);
	}

}