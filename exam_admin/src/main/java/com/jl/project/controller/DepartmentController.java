package com.jl.project.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.util.SaResult;
import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.dto.AddDepartmentDTO;
import com.jl.project.entity.dto.UpdateDeptDTO;
import com.jl.project.entity.dto.UpdateDeptSortDTO;
import com.jl.project.entity.po.Department;
import com.jl.project.entity.query.DepartmentQuery;
import com.jl.project.entity.vo.DepartmentTreeVO;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.exception.BusinessException;
import com.jl.project.service.DepartmentService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:部门表Controller
 * @author:jingLong
 * @date:2023/11/22
 */
@RestController
@RequestMapping("/department")
@SaCheckLogin
@SaCheckRole("admin")
public class DepartmentController{

    @Resource
    private DepartmentService departmentService;


    /**
     * 新增
     */
    @RequestMapping("add")
    @GlobalInterceptor(checkParams = true)
    public SaResult add(@RequestBody @VerifyParam AddDepartmentDTO bean) throws BusinessException {
        Boolean result = departmentService.add(bean);
        return SaResult.ok().setData(result);
    }

    /**
     * 获取树状列表
     *
     * @return
     */
    @RequestMapping("/treeList")
    @GlobalInterceptor(checkParams = true)
    public SaResult getTreeList()  throws BusinessException{
        List<DepartmentTreeVO> result = departmentService.getTreeList();
        return SaResult.ok().setData(result);
    }

    /**
     * 部门排序
     *
     * @param sort
     * @return
     */
    @RequestMapping("/sort")
    @GlobalInterceptor(checkParams = true)
    public SaResult departmentSort(@RequestBody @VerifyParam UpdateDeptSortDTO sort) throws BusinessException {
        Boolean result = departmentService.departmentSort(sort);
        return SaResult.ok().setData(result);

    }

    /**
     * 根据Id更新
     */
    @RequestMapping("updateDepartmentById")
    @GlobalInterceptor(checkParams = true)
    public SaResult updateDepartmentById(@RequestBody @VerifyParam UpdateDeptDTO updateDeptDTO) throws BusinessException {
        Boolean result = departmentService.updateDepartmentById(updateDeptDTO);
        return SaResult.ok().setData(result);
    }


    /**
     * 根据Id删除
     */
    @RequestMapping("deleteDepartmentById")
    @GlobalInterceptor(checkParams = true)
    public SaResult deleteDepartmentById(@RequestBody @VerifyParam(require = true) String id) throws BusinessException {
        Boolean result = departmentService.deleteDepartmentById(id);
        return SaResult.ok().setData(result);
    }

    /**
     * 根据条件分页查询
     */
    @RequestMapping("loadDataList")
    @GlobalInterceptor(checkParams = true)
    public SaResult loadDatalist(@RequestBody @VerifyParam DepartmentQuery query) {
        PaginationResultVO<Department> result = departmentService.findListByPage(query);
        return SaResult.ok().setData(result);
    }

    /**
     * 根据Id返回所有的子部门Id（包括自己）
     */
    @RequestMapping("getChildDeptById")
    @GlobalInterceptor(checkParams = true)
    public SaResult getChildDeptById(@RequestBody @VerifyParam(require = true) String parentId) {
        List<String> result = departmentService.getChildDeptById(parentId);
        return SaResult.ok().setData(result);
    }



    /**
     * 根据Id查询
     */
    @RequestMapping("getDepartmentById")
    @GlobalInterceptor(checkParams = true)
    public SaResult getDepartmentById(@RequestBody @VerifyParam(require = true) String id) {
        Department result = departmentService.getDepartmentById(id);
        return SaResult.ok().setData(result);
    }

    /**
     * 获取部门数量
     */
    @RequestMapping("deptCount")
    @GlobalInterceptor(checkParams = true)
    public SaResult getDeptCount(@RequestBody @VerifyParam DepartmentQuery departmentQuery) throws BusinessException {
        Integer result = departmentService.getDeptCount(departmentQuery);
        return SaResult.ok().setData(result);
    }


    /**
     * 获取专业
     */
    @RequestMapping("profession")
    @GlobalInterceptor(checkParams = true)
    public SaResult getProfession() throws BusinessException {
        List<DepartmentTreeVO> result = departmentService.getProfession();
        return SaResult.ok().setData(result);
    }



    /**
     * 批量新增
     */
    @RequestMapping("addBatch")
    public SaResult addBatch(@RequestBody List<Department> listBean) {
        Integer result = this.departmentService.addBatch(listBean);
        return SaResult.ok().setData(result);
    }

    /**
     * 批量新增或修改
     */
    @RequestMapping("addOrUpdateBatch")
    public SaResult addOrUpdateBatch(@RequestBody List<Department> listBean) {
        Integer result = this.departmentService.addOrUpdateBatch(listBean);
        return SaResult.ok().setData(result);

    }

}