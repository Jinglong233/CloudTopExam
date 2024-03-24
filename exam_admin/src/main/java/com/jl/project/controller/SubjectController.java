package com.jl.project.controller;

import com.jl.project.entity.dto.AddSubjectDTO;
import com.jl.project.entity.dto.UpdateSubjectDTO;
import com.jl.project.entity.po.Subject;
import com.jl.project.entity.query.SubjectQuery;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.entity.vo.SubjectTreeVO;
import com.jl.project.exception.BusinessException;
import com.jl.project.service.SubjectService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:学科表Controller
 * @author:jingLong
 * @date:2023/11/22
 */
@RestController
@RequestMapping("/subject")
public class SubjectController extends ABaseController{

	@Resource
	private SubjectService subjectService;

	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("loadDataList")
	public ResponseVO loadDatalist(@RequestBody SubjectQuery query) {
		return getSuccessResponseVO(this.subjectService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("add")
	public ResponseVO add(@RequestBody AddSubjectDTO addSubjectDTO) throws BusinessException {
		Boolean result = subjectService.add(addSubjectDTO);
		return getSuccessResponseVO(result);
	}


	/**
	 * 获取学科树列表
	 */
	@RequestMapping("treeList")
	public ResponseVO treeList() throws BusinessException {
		List<SubjectTreeVO> result = subjectService.treeList();
		return getSuccessResponseVO(result);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("addBatch")
	public ResponseVO addBatch(@RequestBody List<Subject> listBean) {
		return getSuccessResponseVO(this.subjectService.addBatch(listBean));
	}

	/**
	 * 批量新增或修改
	 */
	@RequestMapping("addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<Subject> listBean) {
		return getSuccessResponseVO(this.subjectService.addOrUpdateBatch(listBean));
	}

	/**
	 * 根据Id查询
	 */

	@RequestMapping("getSubjectById")
	public ResponseVO getSubjectById(String id) {
		return getSuccessResponseVO(this.subjectService.getSubjectById(id));
	}

	/**
	 * 根据Id更新
	 */
	@RequestMapping("updateSubjectById")
	public ResponseVO updateSubjectById(@RequestBody UpdateSubjectDTO subjectDTO) throws BusinessException{
		Boolean result = subjectService.updateSubjectById(subjectDTO);
		return getSuccessResponseVO(result);
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("deleteSubjectById")
	public ResponseVO deleteSubjectById(@RequestBody String id) throws BusinessException{
		Boolean result = subjectService.deleteSubjectById(id);
		return getSuccessResponseVO(result);
	}

}