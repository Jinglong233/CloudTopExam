package com.jl.project.service.impl;

import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.po.TrainRecord;
import com.jl.project.entity.query.SimplePage;
import com.jl.project.entity.query.TrainRecordQuery;
import com.jl.project.enums.PageSize;
import com.jl.project.mapper.TrainRecordMapper;
import com.jl.project.service.TrainRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Description:训练详情记录表Service
 * @author:jingLong
 * @date:2023/11/22
 */
@Service("trainRecordService")
public class TrainRecordServiceImpl implements TrainRecordService {

	@Resource
	private TrainRecordMapper<TrainRecord,TrainRecordQuery> trainRecordMapper;

	/**
	 * 根据条件查询列表
	 */
	public List<TrainRecord> findListByParam(TrainRecordQuery query) {
		return this.trainRecordMapper.selectList(query);
	}

	/**
	 * 根据条件查询数量
	 */
	public Integer findCountByParam(TrainRecordQuery query) {
		return this.trainRecordMapper.selectCount(query);
	}

	/**
	 * 分页查询
	 */
	public PaginationResultVO<TrainRecord> findListByPage(TrainRecordQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<TrainRecord> list = this.findListByParam(query);
		PaginationResultVO<TrainRecord> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	public Integer add(TrainRecord bean) {
		return this.trainRecordMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	public Integer addBatch(List<TrainRecord> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.trainRecordMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或修改
	 */
	public Integer addOrUpdateBatch(List<TrainRecord> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.trainRecordMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 根据Id查询
	 */
	public TrainRecord getTrainRecordById(String id) {
		return this.trainRecordMapper.selectById(id);
	}

	/**
	 * 根据Id更新
	 */
	public Integer updateTrainRecordById(TrainRecord bean, String id) {
		return this.trainRecordMapper.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	public Integer deleteTrainRecordById(String id) {
		return this.trainRecordMapper.deleteById(id);
	}

}