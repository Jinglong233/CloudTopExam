package com.jl.project.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.util.SaResult;
import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.dto.AddSubjectDTO;
import com.jl.project.entity.dto.UpdateSubjectDTO;
import com.jl.project.entity.po.Subject;
import com.jl.project.entity.query.SubjectQuery;
import com.jl.project.entity.vo.PaginationResultVO;
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
@SaCheckLogin
@SaCheckRole("admin")
public class SubjectController {

    @Resource
    private SubjectService subjectService;

    /**
     * 根据条件分页查询
     */
    @RequestMapping("loadDataList")
    @GlobalInterceptor(checkParams = true)
    public SaResult loadDatalist(@RequestBody SubjectQuery query) {
        PaginationResultVO<Subject> result = this.subjectService.findListByPage(query);
        return SaResult.ok().setData(result);
    }

    /**
     * 新增
     */
    @RequestMapping("add")
    @GlobalInterceptor(checkParams = true)
    public SaResult add(@RequestBody AddSubjectDTO addSubjectDTO) throws BusinessException {
        Boolean result = subjectService.add(addSubjectDTO);
        return SaResult.ok(result ? "添加成功" : "添加失败").setData(result);
    }


    /**
     * 获取学科树列表
     */
    @RequestMapping("treeList")
    @GlobalInterceptor(checkParams = true)
    public SaResult treeList() throws BusinessException {
        List<SubjectTreeVO> result = subjectService.treeList();
        return SaResult.ok().setData(result);
    }

    /**
     * 批量新增
     */
    @RequestMapping("addBatch")
    @GlobalInterceptor(checkParams = true)
    public SaResult addBatch(@RequestBody List<Subject> listBean) {
        Integer result = this.subjectService.addBatch(listBean);
        return SaResult.ok(result > 0 ? "批量添加成功" : "批量添加失败").setData(result);

    }

    /**
     * 批量新增或修改
     */
    @RequestMapping("addOrUpdateBatch")
    @GlobalInterceptor(checkParams = true)
    public SaResult addOrUpdateBatch(@RequestBody List<Subject> listBean) {
        Integer result = this.subjectService.addOrUpdateBatch(listBean);
        return SaResult.ok(result > 0 ? "批量添加/更新成功" : "批量添加/更新失败").setData(result);

    }

    /**
     * 根据Id查询
     */

    @RequestMapping("getSubjectById")
    @GlobalInterceptor(checkParams = true)
    public SaResult getSubjectById(String id) {
        Subject result = this.subjectService.getSubjectById(id);
        return SaResult.ok().setData(result);
    }

    /**
     * 根据Id更新
     */
    @RequestMapping("updateSubjectById")
    @GlobalInterceptor(checkParams = true)
    public SaResult updateSubjectById(@RequestBody @VerifyParam(require = true) UpdateSubjectDTO subjectDTO) throws BusinessException {
        Boolean result = subjectService.updateSubjectById(subjectDTO);
        return SaResult.ok(result ? "更新成功" : "更新失败");
    }

    /**
     * 根据Id删除
     */
    @RequestMapping("deleteSubjectById")
    @GlobalInterceptor(checkParams = true)
    public SaResult deleteSubjectById(@RequestBody @VerifyParam(require = true) String id) throws BusinessException {
        Boolean result = subjectService.deleteSubjectById(id);
        return SaResult.ok(result ? "删除成功" : "删除失败");
    }

}