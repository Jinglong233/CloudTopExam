package com.jl.project.controller;


import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
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
	@GlobalInterceptor(checkLogin = true,checkAdmin = true,checkParams = true)
	public ResponseVO loadDatalist(@RequestBody SubjectQuery query) {
		return getSuccessResponseVO(this.subjectService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("add")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true,checkParams = true)
	public ResponseVO add(@RequestBody AddSubjectDTO addSubjectDTO) throws BusinessException {
		Boolean result = subjectService.add(addSubjectDTO);
		return getSuccessResponseVO(result);
	}


	/**
	 * 获取学科树列表
	 */
	@RequestMapping("treeList")
	@GlobalInterceptor(checkLogin = true,checkParams = true)
	public ResponseVO treeList() throws BusinessException {
		List<SubjectTreeVO> result = subjectService.treeList();
		return getSuccessResponseVO(result);
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("addBatch")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true,checkParams = true)
	public ResponseVO addBatch(@RequestBody List<Subject> listBean) {
		return getSuccessResponseVO(this.subjectService.addBatch(listBean));
	}

	/**
	 * 批量新增或修改
	 */
	@RequestMapping("addOrUpdateBatch")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true,checkParams = true)
	public ResponseVO addOrUpdateBatch(@RequestBody List<Subject> listBean) {
		return getSuccessResponseVO(this.subjectService.addOrUpdateBatch(listBean));
	}

	/**
	 * 根据Id查询
	 */

	@RequestMapping("getSubjectById")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true,checkParams = true)
	public ResponseVO getSubjectById(String id) {
		return getSuccessResponseVO(this.subjectService.getSubjectById(id));
	}

	/**
	 * 根据Id更新
	 */
	@RequestMapping("updateSubjectById")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true,checkParams = true)
	public ResponseVO updateSubjectById(@RequestBody @VerifyParam(require = true) UpdateSubjectDTO subjectDTO) throws BusinessException{
		Boolean result = subjectService.updateSubjectById(subjectDTO);
		return getSuccessResponseVO(result);
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("deleteSubjectById")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true,checkParams = true)
	public ResponseVO deleteSubjectById(@RequestBody @VerifyParam(require = true) String id) throws BusinessException{
		Boolean result = subjectService.deleteSubjectById(id);
		return getSuccessResponseVO(result);
	}

}