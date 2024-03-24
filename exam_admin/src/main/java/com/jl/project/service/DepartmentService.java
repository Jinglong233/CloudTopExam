package com.jl.project.service;

import com.jl.project.entity.dto.AddDepartmentDTO;
import com.jl.project.entity.dto.UpdateDeptDTO;
import com.jl.project.entity.dto.UpdateDeptSortDTO;
import com.jl.project.entity.po.Department;
import com.jl.project.entity.query.DepartmentQuery;
import com.jl.project.entity.vo.DepartmentTreeVO;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.exception.BusinessException;

import java.util.List;

;

/**
 * @Description:部门表Service
 * @author:jingLong
 * @date:2023/11/22
 */
public interface DepartmentService {

    /**
     * 根据条件查询列表
     */
    List<Department> findListByParam(DepartmentQuery query);

    /**
     * 根据条件查询数量
     */
    Integer findCountByParam(DepartmentQuery param);

    /**
     * 分页查询
     */
    PaginationResultVO<Department> findListByPage(DepartmentQuery query);

    /**
     * 新增
     */
    Boolean add(AddDepartmentDTO bean) throws BusinessException;

    /**
     * 批量新增
     */
    Integer addBatch(List<Department> listBean);

    /**
     * 批量新增或修改
     */
    Integer addOrUpdateBatch(List<Department> listBean);

    /**
     * 根据Id查询
     */
    Department getDepartmentById(String id);

    /**
     * 根据Id更新
     */
    Boolean updateDepartmentById(UpdateDeptDTO updateDeptDTO) throws BusinessException;

    /**
     * 根据Id删除
     */
    Boolean deleteDepartmentById(String id) throws BusinessException;

    /**
     * 获取树状列表
     *
     * @return
     */
    List<DepartmentTreeVO> getTreeList();

    /**
     * 部门排序
     *
     * @param sort
     * @return
     */
    Boolean departmentSort(UpdateDeptSortDTO sort) throws BusinessException;

    /**
     * 根据Id返回所有的子部门Id（包括自己）
     *
     * @param parentId
     * @return
     */
    List<String> getChildDeptById(String parentId);

    /**
     * 根据父Code获取子部门编码列表(不包括自己)
     *
     * @param result
     * @param parentCode
     * @return
     */
    void getChildrenDeptCode(List<String> result, String parentCode);

    /**
     * 获取部门数量
     * @param departmentQuery
     * @return
     */
    Integer getDeptCount(DepartmentQuery departmentQuery);


    /**
     * 获取专业
     * @return
     */
    List<DepartmentTreeVO> getProfession();
}