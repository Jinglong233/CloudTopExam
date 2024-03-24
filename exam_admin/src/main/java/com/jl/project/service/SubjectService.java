package com.jl.project.service;

;
import com.jl.project.entity.dto.AddSubjectDTO;
import com.jl.project.entity.dto.UpdateSubjectDTO;
import com.jl.project.entity.vo.SubjectTreeVO;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.po.Subject;
import com.jl.project.entity.query.SubjectQuery;

import java.util.List;
/**
 * @Description:学科表Service
 * @author:jingLong
 * @date:2023/11/22
 */
public interface SubjectService {

	/**
	 * 根据条件查询列表
	 */
	List<Subject> findListByParam(SubjectQuery query);

	/**
	 * 根据条件查询数量
	 */
	Integer findCountByParam(SubjectQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<Subject> findListByPage(SubjectQuery query);

	/**
	 * 新增
	 */
	Boolean add( AddSubjectDTO addSubjectDTO);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<Subject> listBean);

	/**
	 * 批量新增或修改
	 */
	Integer addOrUpdateBatch(List<Subject> listBean);

	/**
	 * 根据Id查询
	 */
	Subject getSubjectById(String id);

	/**
	 * 根据Id更新
	 */
	Boolean updateSubjectById(UpdateSubjectDTO updateSubjectDTO);

	/**
	 * 根据Id删除
	 */
	Boolean deleteSubjectById(String id);

	/**
	 * 获取学科树列表
	 * @return
	 */
	List<SubjectTreeVO> treeList();

}