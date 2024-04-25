package com.jl.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.jl.project.entity.dto.AddSubjectDTO;
import com.jl.project.entity.dto.UpdateSubjectDTO;
import com.jl.project.entity.po.Department;
import com.jl.project.entity.po.Subject;
import com.jl.project.entity.query.DepartmentQuery;
import com.jl.project.entity.query.SimplePage;
import com.jl.project.entity.query.SubjectQuery;
import com.jl.project.entity.vo.LoginResponseVo;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.vo.SubjectTreeVO;
import com.jl.project.enums.PageSize;
import com.jl.project.exception.BusinessException;
import com.jl.project.mapper.DepartmentMapper;
import com.jl.project.mapper.SubjectMapper;
import com.jl.project.service.SubjectService;
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
 * @Description:学科表Service
 * @author:jingLong
 * @date:2023/11/22
 */
@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private SubjectMapper<Subject, SubjectQuery> subjectMapper;

    @Resource
    private DepartmentMapper<Department, DepartmentQuery> departmentMapper;

    /**
     * 根据条件查询列表
     */
    public List<Subject> findListByParam(SubjectQuery query) {
        return this.subjectMapper.selectList(query);
    }

    /**
     * 根据条件查询数量
     */
    public Integer findCountByParam(SubjectQuery query) {
        return this.subjectMapper.selectCount(query);
    }

    /**
     * 分页查询
     */
    public PaginationResultVO<Subject> findListByPage(SubjectQuery query) {
        Integer count = this.findCountByParam(query);
        Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
        SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
        query.setSimplePage(page);
        List<Subject> list = this.findListByParam(query);
        PaginationResultVO<Subject> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
        return result;
    }

    /**
     * 新增
     */
    public Boolean add(AddSubjectDTO addSubjectDTO) throws BusinessException {
        if (addSubjectDTO == null) {
            throw new BusinessException("缺少参数");
        }
        String subjectId = CommonUtil.getRandomId();
        Subject subject = new Subject();
        BeanUtil.copyProperties(addSubjectDTO, subject);
        subject.setId(subjectId);
        subject.setCreateTime(new Date());

        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginResponseVo loginUserInfo = UserInfoUtil.getLoginUserInfo(request, stringRedisTemplate);
        subject.setCreateBy(loginUserInfo.getId());

        String parentId = addSubjectDTO.getParentId();
        // 如果没有parentId，则说明是添加顶层学科
        if (parentId == null || "".equals(parentId)) {
            subject.setParentId("0");
        }

        // 判断是否同级有同名学科
        String title = subject.getTitle();
        if (title == null || "".equals(title)) {
            throw new BusinessException("缺少学科名称");
        }
        // 这里不加判断，因为上边已经给parentId赋了值
        SubjectQuery subjectQuery = new SubjectQuery();
        subjectQuery.setParentId(parentId);
        List<Subject> subjectList = findListByParam(subjectQuery);
        if (subjectList != null && subjectList.size() != 0) {
            for (Subject subject1 : subjectList) {
                if (subject1.getTitle().equals(title)) {
                    throw new BusinessException("同级存在同级学科");
                }
            }
        }

        // 设置部门名称
        DepartmentQuery departmentQuery = new DepartmentQuery();
        departmentQuery.setDeptCode(subject.getDeptCode());
        List<Department> list = departmentMapper.selectList(departmentQuery);
        if (list == null || list.size() == 0) {
            throw new BusinessException("选择部门信息出错");
        }
        String deptName = list.get(0).getDeptName();
        subject.setDeptText(deptName);
        Integer addResult = subjectMapper.insert(subject);
        if (addResult <= 0) {
            throw new BusinessException("添加失败");
        }
        return true;
    }

    /**
     * 批量新增
     */
    public Integer addBatch(List<Subject> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.subjectMapper.insertBatch(listBean);
    }

    /**
     * 批量新增或修改
     */
    public Integer addOrUpdateBatch(List<Subject> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.subjectMapper.insertOrUpdateBatch(listBean);
    }

    /**
     * 根据Id查询
     */
    public Subject getSubjectById(String id) {
        return this.subjectMapper.selectById(id);
    }

    /**
     * 根据Id更新
     */
    public Boolean updateSubjectById(UpdateSubjectDTO updateSubjectDTO) throws BusinessException {
        Subject subject = updateSubjectDTO.getSubject();
        String subjectId = updateSubjectDTO.getId();
        subject.setUpdateTime(new Date());
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginResponseVo loginUserInfo = UserInfoUtil.getLoginUserInfo(request, stringRedisTemplate);
        subject.setUpdateBy(loginUserInfo.getId());

        // 判断是否同级有同名学科
        String title = subject.getTitle();
        String parentId = subject.getParentId();
        SubjectQuery subjectQuery = new SubjectQuery();
        subjectQuery.setParentId(parentId);
        List<Subject> subjectList = findListByParam(subjectQuery);
        if (subjectList != null && subjectList.size() != 0) {
            for (Subject subject1 : subjectList) {
                if (subject1.getTitle().equals(title) && !subject1.getId().equals(subject.getId())) {
                    throw new BusinessException("同级存在同级学科");
                }
            }
        }


        // 获取部门信息
        String deptCode = subject.getDeptCode();
        DepartmentQuery departmentQuery = new DepartmentQuery();
        departmentQuery.setDeptCode(deptCode);
        List<Department> list = departmentMapper.selectList(departmentQuery);
        if (list == null || list.size() == 0) {
            throw new BusinessException("关联部门信息出错");
        }
        String deptName = list.get(0).getDeptName();
        subject.setDeptText(deptName);
        Integer updateResult = subjectMapper.updateById(subject, subjectId);
        if (updateResult <= 0) {
            throw new BusinessException("更新失败");
        }

        return true;
    }

    /**
     * 根据Id删除
     */
    public Boolean deleteSubjectById(String id) throws BusinessException {
        if (id == null || "".equals(id)) {
            throw new BusinessException("缺少参数");
        }

        // 判断该部门下时候还有部门
        SubjectQuery subjectQuery = new SubjectQuery();
        subjectQuery.setParentId(id);
        List<Subject> subjectList = findListByParam(subjectQuery);
        if (subjectList != null && subjectList.size() != 0) {
            throw new BusinessException("请先删除子部门");
        }
        Integer deleteResult = subjectMapper.deleteById(id);
        if (deleteResult <= 0) {
            throw new BusinessException("删除失败");
        }
        return true;
    }

    /**
     * 获取学科树列表
     *
     * @return
     */
    @Override
    public List<SubjectTreeVO> treeList() {
        List<Subject> subjects = findListByParam(new SubjectQuery());
        List<SubjectTreeVO> subjectTreeVOS = buildSubjectTree(subjects);
        return subjectTreeVOS;
    }


    /**
     * 构建学科树
     *
     * @return
     */
    private List<SubjectTreeVO> buildSubjectTree(List<Subject> subjectList) {
        if (subjectList == null || subjectList.size() == 0) {
            return Collections.emptyList();
        }


        // 1. 先将所有entity转换为VO
        List<SubjectTreeVO> subjectTreeVOList = subjectList.stream().map(subject -> {
            SubjectTreeVO subjectTreeVO = new SubjectTreeVO();
            BeanUtil.copyProperties(subject, subjectTreeVO);
            return subjectTreeVO;
        }).collect(Collectors.toList());

        // 1. 获取所有学科的Id
        Set<String> set = new HashSet<>();
        for (Subject subject : subjectList) {
            String subjectId = subject.getId();
            set.add(subjectId);
        }

        ArrayList<SubjectTreeVO> parentList = new ArrayList<>();
        // 2. 找出顶层Id
        for (SubjectTreeVO subjectTreeVO : subjectTreeVOList) {
            String parentId = subjectTreeVO.getParentId();
            if (!set.contains(parentId)) {
                parentList.add(subjectTreeVO);
            }
        }


        // 3. 递归查找子学科
        if (parentList != null) {
            for (SubjectTreeVO subjectTreeVO : parentList) {
                recursionBuild(subjectTreeVOList, subjectTreeVO);
            }
        }
        return parentList;
    }


    /**
     * 递归查找子学科
     */
    private void recursionBuild(List<SubjectTreeVO> subjectTreeVOList, SubjectTreeVO subjectTreeVO) {
        // 得到子节点列表
        List<SubjectTreeVO> childList = getChildren(subjectTreeVOList, subjectTreeVO);
        subjectTreeVO.setChildren(childList);
        // 继续找子节点的子节点
        for (SubjectTreeVO child : childList) {
            if (hasChild(subjectTreeVOList, child)) {
                recursionBuild(subjectTreeVOList, child);
            }
        }

    }

    /**
     * 获取对应学科下的子学科
     */
    private List<SubjectTreeVO> getChildren(List<SubjectTreeVO> subjectTreeVOList, SubjectTreeVO subjectTreeVO) {
        List<SubjectTreeVO> collect = subjectTreeVOList.stream().filter((subjectTreeVO1) ->
                subjectTreeVO.getId().equals(subjectTreeVO1.getParentId())
        ).collect(Collectors.toList());
        return collect;
    }

    /**
     * 判断对应节点下时候还有学科
     *
     * @return
     */
    private Boolean hasChild(List<SubjectTreeVO> subjectTreeVOList, SubjectTreeVO subjectTreeVO) {
        List<SubjectTreeVO> children = getChildren(subjectTreeVOList, subjectTreeVO);
        return !children.isEmpty();
    }

}