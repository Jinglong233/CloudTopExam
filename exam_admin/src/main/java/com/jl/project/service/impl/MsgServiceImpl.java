package com.jl.project.service.impl;

;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.po.Msg;
import com.jl.project.entity.query.SimplePage;
import com.jl.project.entity.query.MsgQuery;
import com.jl.project.enums.PageSize;
import com.jl.project.mapper.MsgMapper;
import com.jl.project.service.MsgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Description:消息表Service
 * @author:jingLong
 * @date:2023/11/22
 */
@Service("msgService")
public class MsgServiceImpl implements MsgService {

	@Resource
	private MsgMapper<Msg,MsgQuery> msgMapper;

	/**
	 * 根据条件查询列表
	 */
	public List<Msg> findListByParam(MsgQuery query) {
		return this.msgMapper.selectList(query);
	}

	/**
	 * 根据条件查询数量
	 */
	public Integer findCountByParam(MsgQuery query) {
		return this.msgMapper.selectCount(query);
	}

	/**
	 * 分页查询
	 */
	public PaginationResultVO<Msg> findListByPage(MsgQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<Msg> list = this.findListByParam(query);
		PaginationResultVO<Msg> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	public Integer add(Msg bean) {
		return this.msgMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	public Integer addBatch(List<Msg> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.msgMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或修改
	 */
	public Integer addOrUpdateBatch(List<Msg> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.msgMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 根据Id查询
	 */
	public Msg getMsgById(String id) {
		return this.msgMapper.selectById(id);
	}

	/**
	 * 根据Id更新
	 */
	public Integer updateMsgById(Msg bean, String id) {
		return this.msgMapper.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	public Integer deleteMsgById(String id) {
		return this.msgMapper.deleteById(id);
	}

}