package com.jl.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.jl.project.entity.dto.AddDepartmentDTO;
import com.jl.project.entity.dto.UpdateDeptDTO;
import com.jl.project.entity.dto.UpdateDeptSortDTO;
import com.jl.project.entity.po.Department;
import com.jl.project.entity.query.DepartmentQuery;
import com.jl.project.entity.query.SimplePage;
import com.jl.project.entity.vo.DepartmentTreeVO;
import com.jl.project.entity.vo.LoginResponseVo;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.enums.PageSize;
import com.jl.project.exception.BusinessException;
import com.jl.project.mapper.DepartmentMapper;
import com.jl.project.service.DepartmentService;
import com.jl.project.utils.CommonUtil;
import com.jl.project.utils.UserInfoUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;


/**
 * @Description:部门表Service
 * @author:jingLong
 * @date:2023/11/22
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentMapper<Department, DepartmentQuery> departmentMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private static final String START_CHAR = "A";


    /**
     * 获取树状列表
     *
     * @return
     */
    @Override
    public List<DepartmentTreeVO> getTreeList() {
        List<Department> depts = findListByParam(new DepartmentQuery());
        List<DepartmentTreeVO> deptTrees = buildDeptTree(depts);
        return deptTrees;
    }


    /**
     * 部门排序
     *
     * @param sort
     * @return
     */
    @Override
    public Boolean departmentSort(UpdateDeptSortDTO sort) throws BusinessException {
        if (sort == null) {
            throw new BusinessException("缺少参数");
        }
        // 1. 获取该部门的信息
        Department department = getDepartmentById(sort.getDeptId());
        if (department == null) {
            throw new BusinessException("获取部门信息错误");
        }
        // 2. 获取该部门的同级部门
        String parentCode = department.getParentCode();
        Integer deptLevel = department.getDeptLevel();
        DepartmentQuery query = new DepartmentQuery();
        query.setParentCode(parentCode);
        query.setDeptLevel(deptLevel);
        List<Department> list = findListByParam(query);
        if (list == null) {
            throw new BusinessException("相关部门列表为空");
        }
        // 3. 更新同级列表的排序
        Integer s = sort.getSort();
        if (s == null) {
            throw new BusinessException("缺少排序规则");
        }
        int size = list.size();
        if (s == 1) { // 上移
            list = list.stream().map(dept -> {
                dept.setSort(((dept.getSort() - 2 + size) % size) + 1);
                return dept;
            }).collect(Collectors.toList());
        } else if (s == 0) { // 下移
            list = list.stream().map(dept -> {
                dept.setSort(((dept.getSort() + size) % size) + 1);
                return dept;
            }).collect(Collectors.toList());
        }
        Integer integer = addOrUpdateBatch(list);

        return integer > 0;
    }

    /**
     * 根据Id返回所有的子部门Id（包括自己）
     *
     * @param parentId
     * @return
     */
    @Override
    public List<String> getChildDeptById(String parentId) {
        // 1. 获取该部门的Code
        Department department = departmentMapper.selectById(parentId);
        if (department == null) {
            throw new BusinessException("没有该部门信息");
        }
        List<String> list = new ArrayList<>();
        String deptCode = department.getDeptCode();
        list.add(deptCode);
        // 2. 查找改部门的子部门
        getChildrenDeptCode(list, deptCode);
        return list;
    }

    /**
     * 生成部门树
     *
     * @param departments
     * @return
     */
    private List<DepartmentTreeVO> buildDeptTree(List<Department> departments) {
        // 1. 先将所有entity转换为VO
        List<DepartmentTreeVO> departmentTreeVOS = departments.stream().map(department -> {
            DepartmentTreeVO departmentTreeVO = new DepartmentTreeVO();
            BeanUtil.copyProperties(department, departmentTreeVO);
            return departmentTreeVO;
        }).collect(Collectors.toList());

        List<DepartmentTreeVO> resultList = new ArrayList<>();
        // 2. 获取所有部门的编码
        List<String> tempList = new ArrayList<String>();
        for (Department department : departments) {
            tempList.add(department.getDeptCode());
        }
        // 3. 构建树
        for (DepartmentTreeVO departmentTreeVO : departmentTreeVOS) {
            // 如果是顶级节点,遍历该节点下的所有子节点。
            if (!tempList.contains(departmentTreeVO.getParentCode())) {
                recursionBuild(departmentTreeVOS, departmentTreeVO);
                resultList.add(departmentTreeVO);
            }
        }
        // 4. 排序顶层树
        resultList = resultList.stream().sorted(Comparator.comparing(DepartmentTreeVO::getSort))
                .collect(Collectors.toList());
        return resultList;
    }

    /**
     * 递归构建相关的子节点
     *
     * @param list
     * @param t
     */
    private void recursionBuild(List<DepartmentTreeVO> list, DepartmentTreeVO t) {
        // 得到子节点列表
        List<DepartmentTreeVO> childList = getChildren(list, t);
        t.setChildren(childList);
        for (DepartmentTreeVO child : childList) {
            if (hasChild(list, child)) {
                recursionBuild(list, child);
            }
        }
    }

    /**
     * 获取子列表
     *
     * @param list
     * @param t
     * @return
     */
    private List<DepartmentTreeVO> getChildren(List<DepartmentTreeVO> list, DepartmentTreeVO t) {
        // 获取当前部门下的所有子部门
        List<DepartmentTreeVO> collect = list.stream().filter(departmentTreeVO ->
                        t.getDeptCode().equals(departmentTreeVO.getParentCode()))
                .sorted(Comparator.comparing(DepartmentTreeVO::getSort)) // 子节点排序
                .collect(Collectors.toList());
        return collect;
    }

    /**
     * 根据父Code获取子部门编码列表
     *
     * @param result
     * @param parentCode
     * @return
     */
    public void getChildrenDeptCode(List<String> result, String parentCode) {
        // 得到子节点列表
        DepartmentQuery departmentQuery = new DepartmentQuery();
        departmentQuery.setParentCode(parentCode);
        List<Department> list = departmentMapper.selectList(departmentQuery);
        if (list != null && list.size() != 0) {
            for (Department department : list) {
                String deptCode = department.getDeptCode();
                result.add(deptCode);
                getChildrenDeptCode(result, deptCode);
            }
        }
    }

    /**
     * 获取部门数量
     *
     * @param departmentQuery
     * @return
     */
    @Override
    public Integer getDeptCount(DepartmentQuery departmentQuery) throws BusinessException {
        Integer count = departmentMapper.selectCount(departmentQuery);
        return count;
    }

    /**
     * 获取专业
     *
     * @return
     */
    @Override
    public List<DepartmentTreeVO> getProfession() {
        // 1. 获取所有专业
        DepartmentQuery departmentQuery = new DepartmentQuery();
        departmentQuery.setDeptLevel(1);
        List<Department> departmentList = departmentMapper.selectList(departmentQuery);
        if (departmentList == null || departmentList.size() == 0) {
            return Collections.emptyList();
        }
        List<DepartmentTreeVO> collect = departmentList.stream().map(department -> {
            DepartmentTreeVO departmentTreeVO = new DepartmentTreeVO();
            BeanUtil.copyProperties(department, departmentTreeVO);
            return departmentTreeVO;
        }).collect(Collectors.toList());
        return collect;
    }


    /**
     * 判断当前部门是否还有子部门
     *
     * @param list
     * @param t
     * @return
     */
    private Boolean hasChild(List<DepartmentTreeVO> list, DepartmentTreeVO t) {
        // 获取当前部门下的所有子部门
        List<DepartmentTreeVO> collect = list.stream().filter(departmentTreeVO -> t.getDeptCode().equals(departmentTreeVO.getParentCode())).collect(Collectors.toList());
        return !collect.isEmpty();
    }

    /**
     * 新增
     */
    @Override
    public Boolean add(AddDepartmentDTO bean) throws BusinessException {
        if (bean == null) {
            throw new BusinessException("缺少参数");
        }
        String deptName = bean.getDeptName();
        String parentCode = bean.getParentCode();
        String deptLevel = bean.getDeptLevel().toString();
        // 排除同名部门
        List<Department> departments = getCurrentLevelList(parentCode, deptLevel);
        for (Department department : departments) {
            if (department.getDeptName().equals(deptName)) {
                throw new BusinessException("同级部门不能重名");
            }
        }

        // 创建添加对象
        Department department = new Department();
        BeanUtil.copyProperties(bean, department);
        department.setId(CommonUtil.getRandomId());
        department.setDeptCode(generateDeptCode(parentCode, deptLevel));
        department.setDeptName(bean.getDeptName());
        department.setSort(generateDeptSort(parentCode, deptLevel));
        // todo 前端传递
        department.setCreateBy("xxx");
        department.setCreateTime(new Date());
        return departmentMapper.insert(department) > 0;
    }

    /**
     * 根据条件查询列表
     */
    public List<Department> findListByParam(DepartmentQuery query) {
        return this.departmentMapper.selectList(query);
    }

    /**
     * 根据条件查询数量
     */
    public Integer findCountByParam(DepartmentQuery query) {
        return this.departmentMapper.selectCount(query);
    }

    /**
     * 分页查询
     */
    public PaginationResultVO<Department> findListByPage(DepartmentQuery query) {
        Integer count = this.findCountByParam(query);
        Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
        SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
        query.setSimplePage(page);
        List<Department> list = this.findListByParam(query);
        PaginationResultVO<Department> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
        return result;
    }


    /**
     * 批量新增
     */
    public Integer addBatch(List<Department> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.departmentMapper.insertBatch(listBean);
    }

    /**
     * 批量新增或修改
     */
    public Integer addOrUpdateBatch(List<Department> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.departmentMapper.insertOrUpdateBatch(listBean);
    }

    /**
     * 根据Id查询
     */
    public Department getDepartmentById(String id) {
        return this.departmentMapper.selectById(id);
    }

    /**
     * 根据Id更新
     */
    public Boolean updateDepartmentById(UpdateDeptDTO updateDeptDTO) throws BusinessException {
        Department department = updateDeptDTO.getDepartment();
        department.setUpdateTime(new Date());
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginResponseVo loginUserInfo = UserInfoUtil.getLoginUserInfo(stringRedisTemplate);
        department.setUpdateBy(loginUserInfo.getId());
        Integer integer = departmentMapper.updateById(department, updateDeptDTO.getId());
        return integer > 0;
    }

    /**
     * 根据Id删除
     */
    public Boolean deleteDepartmentById(String id) throws BusinessException {
        // 1. 获取该部门的编码
        Department department = getDepartmentById(id);
        String deptCode = department.getDeptCode();
        // 2. 判断该部门下是否有子部门
        DepartmentQuery query = new DepartmentQuery();
        query.setParentCode(deptCode);
        Integer count = findCountByParam(query);
        if (count > 0) {
            throw new BusinessException("请先删除子部门");
        }
        Integer integer = departmentMapper.deleteById(id);
        return integer > 0;
    }


    /**
     * 获取当前层级下部门列表
     *
     * @param parentCode
     * @return
     */
    private List<Department> getCurrentLevelList(String parentCode, String deptLevel) {
        // 1. 根据parentCode模糊匹配
        if (!"0".equals(parentCode)) {
            parentCode = parentCode + START_CHAR;
        } else {
            parentCode = START_CHAR;
        }
        // 2. 获取当前层级序号列表
        Integer length = (Integer.valueOf(deptLevel) + 1) * 3;
        List<Department> result = departmentMapper.getCurrentLevelNumList(parentCode, length.toString());
        return result;
    }

    /**
     * 生成部门编码
     *
     * @param parentCode
     * @return
     */
    private String generateDeptCode(String parentCode, String deptLevel) {
        List<Department> list = getCurrentLevelList(parentCode, deptLevel);
        if (!"0".equals(parentCode)) {
            parentCode = parentCode + START_CHAR;
        } else {
            parentCode = START_CHAR;
        }
        Integer max = 0;
        // 获取编号列表
        if (list != null && list.size() != 0) {
            List<Integer> collect = list.stream().map(department -> {
                String deptCode = department.getDeptCode();
                String num = deptCode.substring(deptCode.length() - 2);
                return Integer.valueOf(num);
            }).collect(Collectors.toList());
            max = Collections.max(collect);
        }

        String code = String.format("%02d", max + 1);
        return parentCode + code;
    }

    /**
     * 生成新增部门排序(部门排序从1开始)
     *
     * @param parentCode
     * @return
     */
    private Integer generateDeptSort(String parentCode, String deptLevel) {
        List<Department> list = getCurrentLevelList(parentCode, deptLevel);
        return list.size() + 1;
    }
}