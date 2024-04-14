package com.jl.project.service;

;
import com.jl.project.entity.dto.AddRepoDTO;
import com.jl.project.entity.dto.UpdateRepoDTO;
import com.jl.project.entity.vo.ClassfiyByQuTypeVO;
import com.jl.project.exception.BusinessException;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.po.Repo;
import com.jl.project.entity.query.RepoQuery;

import java.util.List;
/**
 * @Description:题库Service
 * @author:jingLong
 * @date:2023/11/22
 */
public interface RepoService {

	/**
	 * 根据条件查询列表
	 */
	List<Repo> findListByParam(RepoQuery query);

	/**
	 * 根据条件查询数量
	 */
	Integer findCountByParam(RepoQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<Repo> findListByPage(RepoQuery query);

	/**
	 * 新增
	 */
	Boolean add(AddRepoDTO repoDTO) throws BusinessException;

	/**
	 * 批量新增
	 */
	Integer addBatch(List<Repo> listBean);

	/**
	 * 批量新增或修改
	 */
	Integer addOrUpdateBatch(List<Repo> listBean);

	/**
	 * 根据Id查询
	 */
	Repo getRepoById(String id);

	/**
	 * 根据Id更新
	 */
	Boolean updateRepoById(UpdateRepoDTO repoDTO) throws BusinessException;

	/**
	 * 根据Id删除
	 */
	Boolean deleteRepoById(String id) throws BusinessException;

	/**
	 * 根据id获取题库中对应题型的难度分类
	 * @param repoId
	 * @param quType
	 * @return
	 */
    ClassfiyByQuTypeVO classifyByQuType(String repoId, Integer quType) throws BusinessException;

	PaginationResultVO<Repo> loadDatalist(RepoQuery query);
}