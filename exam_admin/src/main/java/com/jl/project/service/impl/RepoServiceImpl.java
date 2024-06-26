package com.jl.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.jl.project.entity.dto.AddRepoDTO;
import com.jl.project.entity.dto.UpdateRepoDTO;
import com.jl.project.entity.po.Department;
import com.jl.project.entity.po.Qu;
import com.jl.project.entity.po.Repo;
import com.jl.project.entity.po.Subject;
import com.jl.project.entity.query.*;
import com.jl.project.entity.vo.ClassfiyByQuTypeVO;
import com.jl.project.entity.vo.LoginResponseVo;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.enums.PageSize;
import com.jl.project.enums.QuLevel;
import com.jl.project.exception.BusinessException;
import com.jl.project.mapper.DepartmentMapper;
import com.jl.project.mapper.QuMapper;
import com.jl.project.mapper.RepoMapper;
import com.jl.project.mapper.SubjectMapper;
import com.jl.project.service.RepoService;
import com.jl.project.service.UserService;
import com.jl.project.utils.CommonUtil;
import com.jl.project.utils.UserInfoUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @Description:题库Service
 * @author:jingLong
 * @date:2023/11/22
 */
@Service("repoService")
public class RepoServiceImpl implements RepoService {

    @Resource
    private RepoMapper<Repo, RepoQuery> repoMapper;

    @Resource
    private QuMapper<Qu, QuQuery> quMapper;

    @Resource
    private DepartmentMapper<Department, DepartmentQuery> departmentMapper;


    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private SubjectMapper<Subject, SubjectQuery> subjectMapper;
    @Resource
    private UserService userService;

    /**
     * 新增
     */
    public Boolean add(AddRepoDTO repoDTO) throws BusinessException {
        Repo repo = new Repo();
        BeanUtil.copyProperties(repoDTO, repo);
        repo.setId(CommonUtil.getRandomId());
        // 1. 获取部门名称
        String deptCode = repoDTO.getDeptCode();

        DepartmentQuery departmentQuery = new DepartmentQuery();
        departmentQuery.setDeptCode(deptCode);
        List<Department> departmentList = departmentMapper.selectList(departmentQuery);
        if (departmentList == null || departmentList.size() == 0) {
            throw new BusinessException("关联部门信息错误");
        }
        Department department = departmentList.get(0);
        // 设置题库所属部分名称
        repo.setDeptText(department.getDeptName());

        // 2. 获取学科名称
        String subjectId = repoDTO.getSubjectId();
        Subject subject = subjectMapper.selectById(subjectId);
        if (subject == null) {
            throw new BusinessException("关联学科信息错误");
        }
        repo.setSubjectText(subject.getTitle());
        repo.setCreateTime(new Date());


        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginResponseVo loginUserInfo = UserInfoUtil.getLoginUserInfo(stringRedisTemplate);
        repo.setCreateBy(loginUserInfo.getId());

        Integer result = repoMapper.insert(repo);
        return result > 0;
    }

    /**
     * 根据Id删除
     */
    public Boolean deleteRepoById(String id) throws BusinessException {
        Integer result = repoMapper.deleteById(id);
        return result > 0;
    }

    /**
     * 根据id获取题库中对应题型的难度分类
     *
     * @param repoId
     * @param quType
     * @return
     */
    @Override
    public ClassfiyByQuTypeVO classifyByQuType(String repoId, Integer quType) throws BusinessException {
        if (repoId == null || quType == null) {
            throw new BusinessException("缺少参数");
        }
        // 获取题库
        Repo repo = repoMapper.selectById(repoId);
        if (repo == null) {
            throw new BusinessException("获取题库失败");
        }
        // 获取题库中的题目
        QuQuery quQuery = new QuQuery();
        quQuery.setQuType(quType);
        quQuery.setRepoId(repoId);
        List<Qu> quList = (List<Qu>) quMapper.selectList(quQuery);
        ClassfiyByQuTypeVO classfiyByQuTypeVO = new ClassfiyByQuTypeVO();
        classfiyByQuTypeVO.setQuType(quType);
        classfiyByQuTypeVO.setRepoId(repoId);
        if (quList == null || quList.size() == 0) {
            return classfiyByQuTypeVO;
        }
        // 对题目进行分类
        Map<String, List<Qu>> map = quList.stream().collect(Collectors.groupingBy(qu -> {
            if (qu.getLevel() == QuLevel.EASY.getValue()) {
                return QuLevel.EASY.getLevel();
            } else if (qu.getLevel() == QuLevel.HARD.getValue()) {
                return QuLevel.HARD.getLevel();
            } else {
                return "";
            }
        }));
        List<Qu> easyList = map.get(QuLevel.EASY.getLevel());
        if (easyList != null) {
            classfiyByQuTypeVO.setEasyCount(easyList.size());
        }
        List<Qu> hardList = map.get(QuLevel.HARD.getLevel());
        if (hardList != null) {
            classfiyByQuTypeVO.setHardCount(hardList.size());
        }
        return classfiyByQuTypeVO;
    }

    /**
     * 根据条件分页查询
     *
     * @param query
     * @return
     */
    @Override
    public PaginationResultVO<Repo> loadRepoList(RepoQuery query) throws BusinessException {
        PaginationResultVO<Repo> repos = findListByPage(query);
        return repos;
    }

    /**
     * 根据条件查询列表
     */
    public List<Repo> findListByParam(RepoQuery query) {
        return this.repoMapper.selectList(query);
    }

    /**
     * 根据条件查询数量
     */
    public Integer findCountByParam(RepoQuery query) {
        return this.repoMapper.selectCount(query);
    }

    /**
     * 分页查询
     */
    public PaginationResultVO<Repo> findListByPage(RepoQuery query) {
        Integer count = this.findCountByParam(query);
        Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
        SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
        query.setSimplePage(page);
        List<Repo> list = this.findListByParam(query);
        PaginationResultVO<Repo> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
        return result;
    }

    /**
     * 批量新增
     */
    public Integer addBatch(List<Repo> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.repoMapper.insertBatch(listBean);
    }

    /**
     * 批量新增或修改
     */
    public Integer addOrUpdateBatch(List<Repo> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.repoMapper.insertOrUpdateBatch(listBean);
    }

    /**
     * 根据Id查询
     */
    public Repo getRepoById(String id) {
        return repoMapper.selectById(id);
    }

    /**
     * 根据Id更新
     */
    public Boolean updateRepoById(UpdateRepoDTO repoDTO) throws BusinessException {
        Repo repo = repoDTO.getRepo();
        String id = repoDTO.getId();
        Repo oldRepo = repoMapper.selectById(id);

        String newDeptCode = repo.getDeptCode();

        // 判断是否修改部门
        String oldDeptCode = oldRepo.getDeptCode();
        if (!StrUtil.isEmpty(newDeptCode) && oldDeptCode != newDeptCode) {
            // 更新题库所属部门
            DepartmentQuery departmentQuery = new DepartmentQuery();
            departmentQuery.setDeptCode(newDeptCode);
            List<Department> list = departmentMapper.selectList(departmentQuery);
            if (list == null || list.size() == 0) {
                throw new BusinessException("部门信息错误");
            }
            Department department = list.get(0);
            repo.setDeptText(department.getDeptName());
        }


        // 2. 获取学科名称
        String newSubjectId = repo.getSubjectId();
        String oldSubject = oldRepo.getSubjectId();
        if (!StrUtil.isEmpty(newSubjectId) && newSubjectId != oldSubject) {
            Subject subject = subjectMapper.selectById(newSubjectId);
            if (subject == null) {
                throw new BusinessException("关联的学科信息不存在");
            }
            repo.setSubjectText(subject.getTitle());
        }


        HttpServletRequest request =
                ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();

        LoginResponseVo loginUserInfo = UserInfoUtil.getLoginUserInfo(stringRedisTemplate);
        repo.setUpdateBy(loginUserInfo.getId());
        repo.setUpdateTime(new Date());

        Integer result = repoMapper.updateById(repo, id);
        return result > 0;
    }


}