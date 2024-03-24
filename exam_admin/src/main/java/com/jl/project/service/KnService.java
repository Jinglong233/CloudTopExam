package com.jl.project.service;

;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.po.Kn;
import com.jl.project.entity.query.KnQuery;

import java.util.List;
/**
 * @Description:知识点表Service
 * @author:jingLong
 * @date:2023/11/22
 */
public interface KnService {

	/**
	 * 根据条件查询列表
	 */
	List<Kn> findListByParam(KnQuery query);

	/**
	 * 根据条件查询数量
	 */
	Integer findCountByParam(KnQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<Kn> findListByPage(KnQuery query);

	/**
	 * 新增
	 */
	Integer add(Kn bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<Kn> listBean);

	/**
	 * 批量新增或修改
	 */
	Integer addOrUpdateBatch(List<Kn> listBean);

	/**
	 * 根据Id查询
	 */
	Kn getKnById(String id);

	/**
	 * 根据Id更新
	 */
	Integer updateKnById(Kn bean, String id);

	/**
	 * 根据Id删除
	 */
	Integer deleteKnById(String id);

}