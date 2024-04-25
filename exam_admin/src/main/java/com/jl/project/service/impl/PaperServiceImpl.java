package com.jl.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.jl.project.entity.dto.AddGroupListDTO;
import com.jl.project.entity.dto.AddPaperDTO;
import com.jl.project.entity.dto.UpdatePaperAndQuDTO;
import com.jl.project.entity.po.Exam;
import com.jl.project.entity.po.GlQu;
import com.jl.project.entity.po.GroupList;
import com.jl.project.entity.po.Paper;
import com.jl.project.entity.query.*;
import com.jl.project.entity.vo.GroupListVO;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.vo.PaperAndQuVO;
import com.jl.project.entity.vo.QuAndAnswerVo;
import com.jl.project.enums.PageSize;
import com.jl.project.exception.BusinessException;
import com.jl.project.mapper.ExamMapper;
import com.jl.project.mapper.GlQuMapper;
import com.jl.project.mapper.GroupListMapper;
import com.jl.project.mapper.PaperMapper;
import com.jl.project.service.PaperService;
import com.jl.project.service.QuService;
import com.jl.project.service.UserService;
import com.jl.project.utils.CommonUtil;
import com.jl.project.utils.UserInfoUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @Description:试卷表Service
 * @author:jingLong
 * @date:2023/11/22
 */
@Service("paperService")
public class PaperServiceImpl implements PaperService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private PaperMapper<Paper, PaperQuery> paperMapper;

    @Resource
    private UserService userService;


    @Resource
    private GroupListMapper<GroupList, GroupListQuery> groupListMapper;

    @Resource
    private GlQuMapper<GlQu, GlQuQuery> glQuMapper;
    @Resource
    private QuService quService;


    @Resource
    private ExamMapper<Exam, ExamQuery> examMapper;


    /**
     * 根据条件查询列表
     */
    public List<Paper> findListByParam(PaperQuery query) {
        return this.paperMapper.selectList(query);
    }

    /**
     * 根据条件查询数量
     */
    public Integer findCountByParam(PaperQuery query) {
        return this.paperMapper.selectCount(query);
    }

    /**
     * 分页查询
     */
    public PaginationResultVO<Paper> findListByPage(PaperQuery query) {
        Integer count = this.findCountByParam(query);
        Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
        SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
        query.setSimplePage(page);
        List<Paper> list = this.findListByParam(query);
        PaginationResultVO<Paper> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
        return result;
    }

    /**
     * 新增
     */
    @Transactional
    public Boolean add(AddPaperDTO paperDTO) throws BusinessException {
        if (paperDTO == null) {
            throw new BusinessException("缺少参数");
        }
        String paperId = CommonUtil.getRandomId();
        Paper paper = new Paper();
        BeanUtil.copyProperties(paperDTO, paper);
        paper.setId(paperId);
        paper.setCreateTime(new Date());
        paper.setCreateBy(userService.getLoginUserInfo().getId());
        // 保存试卷
        Integer insert = paperMapper.insert(paper);
        if (insert <= 0) {
            throw new BusinessException("保存试卷失败");
        }

        List<AddGroupListDTO> groupLists = paperDTO.getGroupLists();
        if (groupLists == null || groupLists.size() == 0) {
            throw new BusinessException("试卷没有大题");
        }
        // 遍历大题列表，保存大题
        for (AddGroupListDTO groupList : groupLists) {
            String groupListId = CommonUtil.getRandomId();
            GroupList group = new GroupList();
            group.setId(groupListId);
            group.setPaperId(paperId);
            BeanUtil.copyProperties(groupList, group);
            Integer insert1 = groupListMapper.insert(group);
            if (insert1 <= 0) {
                throw new BusinessException("保存大题失败");
            }
            // 遍历题目列表
            List<QuAndAnswerVo> quList = groupList.getQuList();
            if (quList == null || quList.size() == 0) {
                throw new BusinessException("保存题目失败");
            }
            Integer sort = 1; // 题目排序
            for (QuAndAnswerVo quAndAnswerVo : quList) {
                // 获取每个题目的id和分数
                String quId = quAndAnswerVo.getId();
                Integer score = quAndAnswerVo.getScore();
                // 关联大题和题目
                GlQu glQu = new GlQu();
                glQu.setId(CommonUtil.getRandomId());
                glQu.setScore(score);
                glQu.setQuId(quId);
                glQu.setGlId(groupListId);
                glQu.setSort(sort++);
                Integer insert2 = glQuMapper.insert(glQu);
                if (insert2 <= 0) {
                    throw new BusinessException("关联大题和题目失败");
                }
            }
        }
        return true;
    }

    /**
     * 批量新增
     */
    public Integer addBatch(List<Paper> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.paperMapper.insertBatch(listBean);
    }

    /**
     * 批量新增或修改
     */
    public Integer addOrUpdateBatch(List<Paper> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.paperMapper.insertOrUpdateBatch(listBean);
    }

    /**
     * 根据Id查询
     */
    public Paper getPaperById(String id) {
        return this.paperMapper.selectById(id);
    }

    /**
     * 根据Id更新
     */
    @Transactional
    public Boolean updatePaperById(UpdatePaperAndQuDTO bean) throws BusinessException {
        String paperId = bean.getId();
        AddPaperDTO updatePaperDTO = bean.getAddPaperDTO();
        // 1. 更新试卷
        Paper paper = new Paper();
        BeanUtil.copyProperties(updatePaperDTO, paper);
        Integer paperUpdate = paperMapper.updateById(paper, paperId);
        if (paperUpdate <= 0) {
            throw new BusinessException("修改试卷信息失败");
        }
        // 2. 更新大题（删除重建）
        // 2.1 先删除该试卷关联的所有大题
        GroupListQuery groupListQuery = new GroupListQuery();
        groupListQuery.setPaperId(paperId);
        List<GroupList> groupLists = groupListMapper.selectList(groupListQuery);
        if (groupLists == null) {
            throw new BusinessException("获取大题信息失败");
        }
        for (GroupList groupList : groupLists) {
            // 删除所有大题
            String id = groupList.getId();
            Integer deleteGl = groupListMapper.deleteById(id);
            if (deleteGl <= 0) {
                throw new BusinessException("更新大题失败");
            }
            // 删除所有大题和题目的关联
            GlQuQuery glQuQuery = new GlQuQuery();
            glQuQuery.setGlId(id);
            List<GlQu> glQus = glQuMapper.selectList(glQuQuery);
            if (glQus == null) {
                throw new BusinessException("更新大题失败");
            }
            for (GlQu qus : glQus) {
                String id1 = qus.getId();
                Integer deleteGlQu = glQuMapper.deleteById(id1);
                if (deleteGlQu <= 0) {
                    throw new BusinessException("更新关联题目失败");
                }
            }
        }
        // 2.2 重新建立大题和题目之间的关系
        List<AddGroupListDTO> groupLists1 = updatePaperDTO.getGroupLists();
        if (groupLists1 == null) {
            throw new BusinessException("缺少大题信息");
        }
        // 遍历大题列表，保存大题
        for (AddGroupListDTO groupList : groupLists1) {
            String groupListId = CommonUtil.getRandomId();
            GroupList group = new GroupList();
            group.setId(groupListId);
            group.setPaperId(paperId);
            BeanUtil.copyProperties(groupList, group);
            Integer insert1 = groupListMapper.insert(group);
            if (insert1 <= 0) {
                throw new BusinessException("保存大题失败");
            }
            // 遍历题目列表
            List<QuAndAnswerVo> quList = groupList.getQuList();
            if (quList == null || quList.size() == 0) {
                throw new BusinessException("保存题目失败");
            }
            Integer sort = 1; // 题目排序
            for (QuAndAnswerVo quAndAnswerVo : quList) {
                // 获取每个题目的id和分数
                String quId = quAndAnswerVo.getId();
                Integer score = quAndAnswerVo.getScore();
                // 关联大题和题目
                GlQu glQu = new GlQu();
                glQu.setId(CommonUtil.getRandomId());
                glQu.setScore(score);
                glQu.setQuId(quId);
                glQu.setGlId(groupListId);
                glQu.setSort(sort++);
                Integer insert2 = glQuMapper.insert(glQu);
                if (insert2 <= 0) {
                    throw new BusinessException("关联大题和题目失败");
                }
            }
        }
        return true;
    }

    /**
     * 根据Id删除
     */
    @Transactional
    public Boolean deletePaperById(String paperId) {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        Boolean admin = UserInfoUtil.isAdmin(request, stringRedisTemplate);
        Paper paper = paperMapper.selectById(paperId);
        if (paper == null) {
            throw new BusinessException("试卷信息不存在");
        }

        Boolean mySelf = UserInfoUtil.isMySelf(request, stringRedisTemplate, paper.getCreateBy());

        if (!admin && !mySelf) {
            throw new BusinessException("无权限删除");
        }


        // 1. 查询试卷关联考试
        ExamQuery examQuery = new ExamQuery();
        examQuery.setPaperId(paperId);
        List<Exam> examList = examMapper.selectList(examQuery);
        if (examList != null && examList.size() != 0) {
            throw new BusinessException("该试卷有关联考试");
        }

        // 2. 删除试卷
        Integer deletePaper = paperMapper.deleteById(paperId);
        if (deletePaper <= 0) {
            throw new BusinessException("删除试卷失败");
        }
        // 3. 删除试卷关联的大题
        GroupListQuery groupListQuery = new GroupListQuery();
        groupListQuery.setPaperId(paperId);
        List<GroupList> groupLists = groupListMapper.selectList(groupListQuery);
        if (groupLists == null || groupLists.size() == 0) {
            throw new BusinessException("试卷关联大题为空");
        }
        for (GroupList groupList : groupLists) {
            String id = groupList.getId();
            Integer deleteGroupList = groupListMapper.deleteById(id);
            if (deleteGroupList <= 0) {
                throw new BusinessException("删除试卷关联大题失败");
            }
            // 4. 删除大题关联题目信息
            GlQuQuery glQuQuery = new GlQuQuery();
            glQuQuery.setGlId(id);
            List<GlQu> glQuList = glQuMapper.selectList(glQuQuery);
            if (glQuList == null) {
                throw new BusinessException("删除关联题目失败");
            }
            for (GlQu glQu : glQuList) {
                String glQuId = glQu.getId();
                Integer deleteGlQu = glQuMapper.deleteById(glQuId);
                if (deleteGlQu <= 0) {
                    throw new BusinessException("删除关联题目失败");
                }
            }
        }
        return true;
    }

    /**
     * 根据Id查询试卷详细信息
     *
     * @param id
     * @return
     */
    @Override
    public PaperAndQuVO getPaperDetailById(String id) throws BusinessException {
        String paperId = id;
        PaperAndQuVO paperAndQuVO = new PaperAndQuVO();
        // 1. 根据试卷ID获取试卷信息
        Paper paper = paperMapper.selectById(id);
        if (paper == null) {
            throw new BusinessException("试卷不存在");
        }
        BeanUtil.copyProperties(paper, paperAndQuVO);
        // 2. 根据试卷ID查询相关的大题
        GroupListQuery groupListQuery = new GroupListQuery();
        groupListQuery.setPaperId(paperId);
        List<GroupList> groupLists = groupListMapper.selectList(groupListQuery);
        if (groupLists == null || groupLists.size() == 0) {
            throw new BusinessException("试卷关联大题为空");
        }
        ArrayList<GroupListVO> groupListVOS = new ArrayList<>();
        for (GroupList groupList : groupLists) {
            GroupListVO groupListVO = new GroupListVO();
            BeanUtil.copyProperties(groupList, groupListVO);
            // 3. 根据大题ID获取对应的题目
            GlQuQuery glQuQuery = new GlQuQuery();
            glQuQuery.setGlId(groupList.getId());
            List<GlQu> glQuList = glQuMapper.selectList(glQuQuery);
            if (glQuList == null || glQuList.size() == 0) {
                throw new BusinessException("查找大题关联题目失败");
            }
            List<QuAndAnswerVo> quAndAnswerVos = new ArrayList<>();
            // 4. 按照题目sort排序
            glQuList = glQuList.stream().sorted(Comparator.comparing(GlQu::getSort)).collect(Collectors.toList());
            for (GlQu glQu : glQuList) {
                String quId = glQu.getQuId();
                // 根据题目ID获取详细信息（包括答案）
                QuAndAnswerVo quAndAnswerVo = quService.getQuById(quId);
                quAndAnswerVo.setScore(glQu.getScore());
                quAndAnswerVo.setSort(glQu.getSort());
                quAndAnswerVos.add(quAndAnswerVo);
                // 将题目放进对应的题目列表
                groupListVO.setQuList(quAndAnswerVos);
            }
            // 将大题添加进大题列表
            groupListVOS.add(groupListVO);
        }
        paperAndQuVO.setGroupLists(groupListVOS);

        return paperAndQuVO;
    }

    @Override
    public Integer getPaperCount(PaperQuery paperQuery) throws BusinessException {
        if (paperQuery == null) {
            throw new BusinessException("缺少参数");
        }
        Integer count = paperMapper.selectCount(paperQuery);
        return count;
    }

    /**
     * 根据条件分页查询
     *
     * @param query
     * @return
     */
    @Override
    public PaginationResultVO<Paper> loadDatalist(PaperQuery query) throws BusinessException {
        if (query == null) {
            throw new BusinessException("缺少参数");
        }
        return findListByPage(query);
    }


}