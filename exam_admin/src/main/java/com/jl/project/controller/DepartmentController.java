package com.jl.project.controller;

import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
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
    @GlobalInterceptor(checkLogin = true,checkAdmin = true,checkParams = true)
    public ResponseVO add(@RequestBody @VerifyParam AddDepartmentDTO bean) throws BusinessException {
        Boolean result = departmentService.add(bean);
        return getSuccessResponseVO(result);
    }

    /**
     * 获取树状列表
     *
     * @return
     */
    @RequestMapping("/treeList")
    @GlobalInterceptor(checkLogin = true,checkAdmin = true,checkParams = true)
    public ResponseVO getTreeList()  throws BusinessException{
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
    @GlobalInterceptor(checkLogin = true,checkAdmin = true,checkParams = true)
    public ResponseVO departmentSort(@RequestBody @VerifyParam UpdateDeptSortDTO sort) throws BusinessException {
        Boolean result = departmentService.departmentSort(sort);
        return getSuccessResponseVO(result);

    }

    /**
     * 根据Id更新
     */
    @RequestMapping("updateDepartmentById")
    @GlobalInterceptor(checkLogin = true,checkAdmin = true,checkParams = true)
    public ResponseVO updateDepartmentById(@RequestBody @VerifyParam UpdateDeptDTO updateDeptDTO) throws BusinessException {
        Boolean result = departmentService.updateDepartmentById(updateDeptDTO);
        return getSuccessResponseVO(result);
    }


    /**
     * 根据Id删除
     */
    @RequestMapping("deleteDepartmentById")
    @GlobalInterceptor(checkLogin = true,checkAdmin = true,checkParams = true)
    public ResponseVO deleteDepartmentById(@RequestBody @VerifyParam(require = true) String id) throws BusinessException {
        Boolean result = departmentService.deleteDepartmentById(id);
        return getSuccessResponseVO(result);
    }

    /**
     * 根据条件分页查询
     */
    @RequestMapping("loadDataList")
    @GlobalInterceptor(checkLogin = true,checkParams = true)
    public ResponseVO loadDatalist(@RequestBody @VerifyParam DepartmentQuery query) {
        return getSuccessResponseVO(departmentService.findListByPage(query));
    }

    /**
     * 根据Id返回所有的子部门Id（包括自己）
     */
    @RequestMapping("getChildDeptById")
    @GlobalInterceptor(checkLogin = true,checkParams = true)
    public ResponseVO getChildDeptById(@RequestBody @VerifyParam(require = true) String parentId) {
        List<String> result = departmentService.getChildDeptById(parentId);
        return getSuccessResponseVO(result);
    }



    /**
     * 根据Id查询
     */
    @RequestMapping("getDepartmentById")
    @GlobalInterceptor(checkLogin = true,checkParams = true)
    public ResponseVO getDepartmentById(@RequestBody @VerifyParam(require = true) String id) {
        return getSuccessResponseVO(departmentService.getDepartmentById(id));
    }

    /**
     * 获取部门数量
     */
    @RequestMapping("deptCount")
    @GlobalInterceptor(checkLogin = true,checkParams = true)
    public ResponseVO getDeptCount(@RequestBody @VerifyParam DepartmentQuery departmentQuery) throws BusinessException {
        Integer result = departmentService.getDeptCount(departmentQuery);
        return getSuccessResponseVO(result);
    }


    /**
     * 获取专业
     */

    @RequestMapping("profession")
    @GlobalInterceptor(checkLogin = true,checkParams = true)
    public ResponseVO getProfession() throws BusinessException {
        List<DepartmentTreeVO> result = departmentService.getProfession();
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

}