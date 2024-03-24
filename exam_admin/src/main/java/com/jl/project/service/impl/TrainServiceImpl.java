package com.jl.project.service.impl;

import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.po.Train;
import com.jl.project.entity.query.SimplePage;
import com.jl.project.entity.query.TrainQuery;
import com.jl.project.enums.PageSize;
import com.jl.project.mapper.TrainMapper;
import com.jl.project.service.TrainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Description:训练表Service
 * @author:jingLong
 * @date:2023/11/22
 */
@Service("trainService")
public class TrainServiceImpl implements TrainService {

	@Resource
	private TrainMapper<Train,TrainQuery> trainMapper;

	/**
	 * 根据条件查询列表
	 */
	public List<Train> findListByParam(TrainQuery query) {
		return this.trainMapper.selectList(query);
	}

	/**
	 * 根据条件查询数量
	 */
	public Integer findCountByParam(TrainQuery query) {
		return this.trainMapper.selectCount(query);
	}

	/**
	 * 分页查询
	 */
	public PaginationResultVO<Train> findListByPage(TrainQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<Train> list = this.findListByParam(query);
		PaginationResultVO<Train> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	public Integer add(Train bean) {
		return this.trainMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	public Integer addBatch(List<Train> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.trainMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或修改
	 */
	public Integer addOrUpdateBatch(List<Train> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.trainMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 根据Id查询
	 */
	public Train getTrainById(String id) {
		return this.trainMapper.selectById(id);
	}

	/**
	 * 根据Id更新
	 */
	public Integer updateTrainById(Train bean, String id) {
		return this.trainMapper.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	public Integer deleteTrainById(String id) {
		return this.trainMapper.deleteById(id);
	}

}