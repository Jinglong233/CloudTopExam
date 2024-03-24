package com.jl.project.controller;

import com.jl.project.entity.dto.AddDepartmentDTO;
import com.jl.project.entity.dto.UpdateDeptDTO;
import com.jl.project.entity.dto.UpdateDeptSortDTO;
import com.jl.project.entity.po.Department;
import com.jl.project.entity.query.DepartmentQuery;
import com.jl.project.entity.vo.DepartmentTreeVO;
import com.jl.project.entity.vo.ResponseVO;
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
public class DepartmentController extends ABaseController {

    @Resource
    private DepartmentService departmentService;


    /**
     * 新增
     */
    @RequestMapping("add")
    public ResponseVO add(@RequestBody AddDepartmentDTO bean) throws BusinessException {
        Boolean result = departmentService.add(bean);
        return getSuccessResponseVO(result);
    }

    /**
     * 获取树状列表
     *
     * @return
     */
    @RequestMapping("/treeList")
    public ResponseVO getTreeList() {
        List<DepartmentTreeVO> result = departmentService.getTreeList();
        return getSuccessResponseVO(result);
    }

    /**
     * 部门排序
     *
     * @param sort
     * @return
     */
    @RequestMapping("/sort")
    public ResponseVO departmentSort(@RequestBody UpdateDeptSortDTO sort) throws BusinessException {
        Boolean result = departmentService.departmentSort(sort);
        return getSuccessResponseVO(result);

    }

    /**
     * 根据Id更新
     */
    @RequestMapping("updateDepartmentById")
    public ResponseVO updateDepartmentById(@RequestBody UpdateDeptDTO updateDeptDTO) throws BusinessException {
        Boolean result = departmentService.updateDepartmentById(updateDeptDTO);
        return getSuccessResponseVO(result);
    }


    /**
     * 根据Id删除
     */
    @RequestMapping("deleteDepartmentById")
    public ResponseVO deleteDepartmentById(@RequestBody String id) throws BusinessException {
        Boolean result = departmentService.deleteDepartmentById(id);
        return getSuccessResponseVO(result);
    }

    /**
     * 根据条件分页查询
     */
    @RequestMapping("loadDataList")
    public ResponseVO loadDatalist(@RequestBody DepartmentQuery query) {
        return getSuccessResponseVO(departmentService.findListByPage(query));
    }

    /**
     * 根据Id返回所有的子部门Id（包括自己）
     */
    @RequestMapping("getChildDeptById")
    public ResponseVO getChildDeptById(@RequestBody String parentId) {
        List<String> result = departmentService.getChildDeptById(parentId);
        return getSuccessResponseVO(result);
    }


    /**
     * 批量新增
     */
    @RequestMapping("addBatch")
    public ResponseVO addBatch(@RequestBody List<Department> listBean) {
        return getSuccessResponseVO(this.departmentService.addBatch(listBean));
    }

    /**
     * 批量新增或修改
     */
    @RequestMapping("addOrUpdateBatch")
    public ResponseVO addOrUpdateBatch(@RequestBody List<Department> listBean) {

        return getSuccessResponseVO(this.departmentService.addOrUpdateBatch(listBean));
    }

    /**
     * 根据Id查询
     */

    @RequestMapping("getDepartmentById")
    public ResponseVO getDepartmentById(String id) {
        return getSuccessResponseVO(this.departmentService.getDepartmentById(id));
    }

    /**
     * 获取部门数量
     */

    @RequestMapping("deptCount")
    public ResponseVO getDeptCount(@RequestBody DepartmentQuery departmentQuery) throws BusinessException {
        Integer result = departmentService.getDeptCount(departmentQuery);
        return getSuccessResponseVO(result);
    }


    /**
     * 获取专业
     */

    @RequestMapping("profession")
    public ResponseVO getProfession() throws BusinessException {
        List<DepartmentTreeVO> result = departmentService.getProfession();
        return getSuccessResponseVO(result);
    }

}