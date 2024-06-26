package com.jl.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.jl.project.constant.MailConstant;
import com.jl.project.entity.dto.AddExamDTO;
import com.jl.project.entity.dto.UpdateExamDTO;
import com.jl.project.entity.po.*;
import com.jl.project.entity.query.*;
import com.jl.project.entity.vo.*;
import com.jl.project.enums.*;
import com.jl.project.exception.BusinessException;
import com.jl.project.mapper.*;
import com.jl.project.observer.correctObserver.ReviewSubject;
import com.jl.project.service.ExamService;
import com.jl.project.service.PaperService;
import com.jl.project.service.UserService;
import com.jl.project.utils.CommonUtil;
import com.jl.project.utils.MailUtil;
import com.jl.project.utils.UserInfoUtil;
import com.jl.project.utils.XxlJobUtil;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


/**
 * @Description:考试表Service
 * @author:jingLong
 * @date:2023/11/22
 */
@Service("examService")
public class ExamServiceImpl implements ExamService {

    private static final Logger logger = LoggerFactory.getLogger(ExamServiceImpl.class);

    @Value("${spring.mail.username}")
    private String from;


    @Resource
    private ApplicationContext applicationContext;

    @Resource
    private JavaMailSender javaMailSender;


    @Resource
    private ReviewSubject reviewSubject;
    @Resource
    private ExamMapper<Exam, ExamQuery> examMapper;

    @Resource
    private UserMapper<User, UserQuery> userMapper;

    @Resource
    private BookMapper<Book, BookQuery> bookMapper;


    @Resource
    private UserAnswerMapper<UserAnswer, UserAnswerQuery> userAnswerMapper;

    @Resource
    private ExamRecordMapper<ExamRecord, ExamRecordQuery> examRecordMapper;

    @Resource
    private PaperMapper<Paper, PaperQuery> paperMapper;

    @Resource
    private GroupListMapper<GroupList, GroupListQuery> groupListMapper;


    @Resource
    private DepartmentMapper<Department, DepartmentQuery> departmentMapper;


    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private UserService userService;


    @Resource
    private PaperService paperService;
    @Resource
    private TmplMapper<Tmpl, TmplQuery> tmplMapper;
    @Resource
    private MsgMapper<Msg, MsgQuery> msgMapper;

    @Resource
    private MsgUserMapper<MsgUser, MsgUserQuery> msgUserMapper;


    /**
     * 根据条件查询列表
     */
    public List<Exam> findListByParam(ExamQuery query) {
        return this.examMapper.selectList(query);
    }

    /**
     * 根据条件查询数量
     */
    public Integer findCountByParam(ExamQuery query) {
        return this.examMapper.selectCount(query);
    }

    /**
     * 分页查询
     */
    public PaginationResultVO<Exam> findListByPage(ExamQuery query) {
        Integer count = this.findCountByParam(query);
        Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
        SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
        query.setSimplePage(page);
        List<Exam> list = this.findListByParam(query);
        PaginationResultVO<Exam> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
        return result;
    }

    /**
     * 新增
     */
    @Transactional
    public Boolean add(AddExamDTO addExamDTO) throws BusinessException {
        // 1. 添加考试信息
        Exam exam = new Exam();
        String examId = CommonUtil.getRandomId();
        BeanUtil.copyProperties(addExamDTO, exam);
        exam.setId(examId);
        exam.setCreateTime(new Date());
        exam.setStatue(0);
        // 获取相关试卷，要是没有客观题，则reviewQuire为0
        String paperId = addExamDTO.getPaperId();
        if (paperId == null || "".equals(paperId)) {
            throw new BusinessException("关联试卷为空");
        }
        Paper paper = paperMapper.selectById(paperId);
        if (paper == null) {
            throw new BusinessException("关联试卷为空");
        }
        // 获取该试卷对应的大题
        GroupListQuery groupListQuery = new GroupListQuery();
        groupListQuery.setPaperId(paperId);
        List<GroupList> list = groupListMapper.selectList(groupListQuery);
        if (list == null) {
            throw new BusinessException("没有关联的大题");
        }
        for (GroupList groupList : list) {
            if (groupList.getQuType() == QuType.SHORTANSWER.getValue()) {
                exam.setReviewQuire(1);
                break;
            }
        }

        // 获取部分编号（如果有）
        String deptCode = addExamDTO.getDeptCode();
        if (deptCode != null) {
            // 获取对应的部门名称
            DepartmentQuery departmentQuery = new DepartmentQuery();
            departmentQuery.setDeptCode(deptCode);
            List<Department> departments = departmentMapper.selectList(departmentQuery);
            if (departments != null && departments.size() != 0) {
                Department department = departments.get(0);
                exam.setDeptText(department.getDeptName());
            }
        }

        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginResponseVo loginUserInfo = UserInfoUtil.getLoginUserInfo(stringRedisTemplate);
        exam.setCreateBy(loginUserInfo.getId());
        exam.setCreateTime(new Date());
        Integer addExamResult = examMapper.insert(exam);
        if (addExamResult <= 0) {
            throw new BusinessException("创建考试失败");
        }
        // 2. 查看开放权限
        Integer openType = addExamDTO.getOpenType();
        if (OpenType.FULLOPEN.getValue() == openType) { // 完全开放
            // 给所有用户创建考试
            List<User> allUserList = userMapper.selectList(new UserQuery());
            if (allUserList == null || allUserList.size() == 0) {
                throw new BusinessException("用户为空");
            }
            for (User user : allUserList) {
                ExamRecord examRecord = new ExamRecord();
                String examRecordId = CommonUtil.getRandomId();
                examRecord.setId(examRecordId);
                examRecord.setExamId(examId);
                examRecord.setUserId(user.getId());
                examRecord.setReviewUser(addExamDTO.getCreateBy());
                Integer addExamRecordResult = examRecordMapper.insert(examRecord);
                if (addExamRecordResult <= 0) {
                    throw new BusinessException("创建用户考试记录失败");
                }
            }
        } else if (OpenType.MEMBER.getValue() == openType) { // 指定人员
            // 获取指定人员列表，添加考试记录
            List<String> userList = addExamDTO.getUserList();
            if (userList == null || userList.size() == 0) {
                throw new BusinessException("指定人员列表为空");
            }
            for (String userId : userList) {
                ExamRecord examRecord = new ExamRecord();
                String examRecordId = CommonUtil.getRandomId();
                examRecord.setId(examRecordId);
                examRecord.setExamId(examId);
                examRecord.setUserId(userId);
                examRecord.setReviewUser(userId);
                Integer addExamRecordResult = examRecordMapper.insert(examRecord);
                if (addExamRecordResult <= 0) {
                    throw new BusinessException("创建用户考试记录失败");
                }
            }
        } else if (OpenType.DEPARTMENT.getValue() == openType) { // 指定部门
            // 获取指定部门Code
            if (deptCode == null) {
                throw new BusinessException("指定部门编码为空");
            }
            // 查询部门下的所有用户
            UserQuery userQuery = new UserQuery();
            userQuery.setDeptCodeFuzzy(deptCode);
            PaginationResultVO resultVO = userService.loadDeptUserList(userQuery);
            List<User> userList = resultVO.getList();
            if (userList == null || userList.size() == 0) {
                throw new BusinessException("该部门下没用户");
            }
            for (User user : userList) {
                ExamRecord examRecord = new ExamRecord();
                String examRecordId = CommonUtil.getRandomId();
                examRecord.setId(examRecordId);
                examRecord.setExamId(examId);
                examRecord.setUserId(user.getId());
                examRecord.setReviewUser(user.getId());
                Integer addExamRecordResult = examRecordMapper.insert(examRecord);
                if (addExamRecordResult <= 0) {
                    throw new BusinessException("创建用户考试记录失败");
                }
            }
        }
        String title = addExamDTO.getTitle();
        Date startTime = addExamDTO.getStartTime();
        if (startTime == null || startTime.before(new Date())) {
            throw new BusinessException("考试开始时间为空/考试开始时间应该小于了当前时间");
        }
        Date endTime = addExamDTO.getEndTime();
        if (endTime == null || !endTime.after(startTime)) {
            throw new BusinessException("考试结束时间为空/考试结束时间应大于开始时间");
        }

        // 发送邮件考试通知
        sendExamMailNotifie(exam);
        // 站内通知
        sendExamNotifie(exam);

        // 创建开始考试任务
        createExamTask(examId, title, startTime, endTime);
        return true;
    }

    /**
     * 批量新增
     */
    public Integer addBatch(List<Exam> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.examMapper.insertBatch(listBean);
    }

    /**
     * 批量新增或修改
     */
    public Integer addOrUpdateBatch(List<Exam> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.examMapper.insertOrUpdateBatch(listBean);
    }

    /**
     * 根据Id查询
     */
    public ExamVO getExamById(String id) throws BusinessException {
        Exam exam = examMapper.selectById(id);
        if (exam == null) {
            throw new BusinessException("考试信息为空");
        }
        String paperId = exam.getPaperId();
        if (paperId == null || "".equals(paperId)) {
            throw new BusinessException("关联试卷信息为空");
        }
        Paper paper = paperMapper.selectById(paperId);
        if (paper == null) {
            throw new BusinessException("关联试卷信息为空");
        }
        ExamVO examVO = new ExamVO();
        BeanUtil.copyProperties(exam, examVO);
        examVO.setTotalCount(paper.getTotalCount());
        return examVO;
    }

    /**
     * 根据Id更新
     */
    @Transactional
    public Boolean updateExamById(UpdateExamDTO updateExamDTO) throws BusinessException {
        String examId = updateExamDTO.getId();

        // 获取未更新前的考试数据
        Exam oladExam = examMapper.selectById(examId);
        Date oldStartTime = oladExam.getStartTime();
        Date oldEndTime = oladExam.getEndTime();

        // 1. 添加考试信息
        Exam exam = new Exam();
        BeanUtil.copyProperties(updateExamDTO, exam);
        exam.setUpdateTime(new Date());
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginResponseVo loginUserInfo = UserInfoUtil.getLoginUserInfo(stringRedisTemplate);
        exam.setUpdateBy(loginUserInfo.getId());


        Date updateStartTime = updateExamDTO.getStartTime();
        Date updateEndTime = updateExamDTO.getEndTime();
        // 判断考试是否已经开始
        if (updateStartTime != null) {
            boolean before = oldStartTime.before(new Date());
            // 判断考试是否已经开始
            if (before) {
                throw new BusinessException("开始已经开始禁止修改");
            }
            // 判断新的开始时间和结束时间是否合法
            if (updateEndTime == null || updateEndTime.before(updateStartTime)) {
                throw new BusinessException("结束时间不合法");
            }
        }


        // 更新考试信息
        Integer updateExamResult = examMapper.updateById(exam, examId);
        if (updateExamResult <= 0) {
            throw new BusinessException("更新考试失败");
        }


        // 2. 先删除所有关联用户的此次考试记录
        ExamRecordQuery examRecordQuery = new ExamRecordQuery();
        examRecordQuery.setExamId(examId);
        List<ExamRecord> examRecords = examRecordMapper.selectList(examRecordQuery);
        if (examRecords != null && examRecords.size() != 0) {
            for (ExamRecord examRecord : examRecords) {
                String examRecordId = examRecord.getId();
                if (StrUtil.isEmpty(examRecordId)) {
                    throw new BusinessException("更新考试记录失败");
                }
                Integer deleteResult = examRecordMapper.deleteById(examRecordId);
                if (deleteResult <= 0) {
                    throw new BusinessException("更新考试记录失败");
                }
            }
        }
        // 重新插入
        // 3. 查看开放权限
        Integer openType = updateExamDTO.getOpenType();
        if (OpenType.FULLOPEN.getValue() == openType) { // 完全开放
            // 给所有用户创建考试
            List<User> allUserList = userMapper.selectList(new UserQuery());
            if (allUserList == null || allUserList.size() == 0) {
                throw new BusinessException("用户为空");
            }
            for (User user : allUserList) {
                ExamRecord examRecord = new ExamRecord();
                String examRecordId = CommonUtil.getRandomId();
                examRecord.setId(examRecordId);
                examRecord.setExamId(examId);
                examRecord.setUserId(user.getId());
                Integer addExamRecordResult = examRecordMapper.insert(examRecord);
                if (addExamRecordResult <= 0) {
                    throw new BusinessException("创建用户考试记录失败");
                }
            }
        } else if (OpenType.MEMBER.getValue() == openType) { // 指定人员
            // 获取指定人员列表，添加考试记录
            List<String> userList = updateExamDTO.getUserList();
            if (userList == null || userList.size() == 0) {
                throw new BusinessException("指定人员列表为空");
            }
            for (String userId : userList) {
                ExamRecord examRecord = new ExamRecord();
                String examRecordId = CommonUtil.getRandomId();
                examRecord.setId(examRecordId);
                examRecord.setExamId(examId);
                examRecord.setUserId(userId);
                examRecord.setReviewUser(userId);
                Integer addExamRecordResult = examRecordMapper.insert(examRecord);
                if (addExamRecordResult <= 0) {
                    throw new BusinessException("创建用户考试记录失败");
                }
            }
        } else if (OpenType.DEPARTMENT.getValue() == openType) { // 指定部门
            // 获取指定部门Code
            String deptCode = updateExamDTO.getDeptCode();
            if (deptCode == null) {
                throw new BusinessException("指定部门编码为空");
            }
            // 查询部门下的所有用户
            UserQuery userQuery = new UserQuery();
            userQuery.setDeptCode(deptCode);
            PaginationResultVO resultVO = userService.loadDeptUserList(userQuery);
            List<User> userList = resultVO.getList();
            if (userList == null || userList.size() == 0) {
                throw new BusinessException("该部门下没用户");
            }
            for (User user : userList) {
                ExamRecord examRecord = new ExamRecord();
                String examRecordId = CommonUtil.getRandomId();
                examRecord.setId(examRecordId);
                examRecord.setExamId(examId);
                examRecord.setUserId(user.getId());
                examRecord.setReviewUser(user.getId());
                Integer addExamRecordResult = examRecordMapper.insert(examRecord);
                if (addExamRecordResult <= 0) {
                    throw new BusinessException("创建用户考试记录失败");
                }
            }
        }
        String title = updateExamDTO.getTitle();
        if (StrUtil.isEmpty(title)) {
            throw new BusinessException("考试标题为空");
        }

        Date startTime = updateExamDTO.getStartTime();
        if (startTime == null || startTime.before(new Date())) {
            throw new BusinessException("考试开始时间为空/考试开始时间应该小于了当前时间");
        }


        Date endTime = updateExamDTO.getEndTime();
        if (endTime == null || !endTime.after(startTime)) {
            throw new BusinessException("考试结束时间为空/考试结束时间应大于开始时间");
        }


        // 判断考试是否开始
        if (new Date().after(oldStartTime)) {
            throw new BusinessException("考试已开始，禁止修改");
        }
        // 更新考试调度任务
        ResponseEntity<String> response = XxlJobUtil.updateXxlJob(oladExam.getStartJobId(), "2", examId, title, startTime, "startExam");
        ResponseEntity<String> response1 = XxlJobUtil.updateXxlJob(oladExam.getStopJobId(), "3", examId, title, endTime, "stopExam");
        return true;
    }

    /**
     * 开启考试任务（调用XXL-JOB）
     *
     * @param examId
     * @param title
     * @param startTime
     * @param endTime
     */
    private void createExamTask(String examId, String title, Date startTime, Date endTime) {
        // 创建开始考试任务
        ResponseEntity<String> startResp = XxlJobUtil.addExamXxlJob(title, "2", startTime, examId, "startExam");
        JSONObject startRespObject = JSONUtil.parseObj(startResp.getBody());
        Integer code = (Integer) startRespObject.get("code");
        if (code != 200) {
            throw new BusinessException("创建考试开始任务失败");
        }
        // 创建结束考试任务
        ResponseEntity<String> endResp = XxlJobUtil.addExamXxlJob(title, "3", endTime, examId, "stopExam");
        JSONObject endRespObject = JSONUtil.parseObj(endResp.getBody());
        code = (Integer) endRespObject.get("code");
        if (code != 200) {
            throw new BusinessException("创建考试结束任务失败");
        }

        // 更新考试开始、结束任务Id
        Exam exam = examMapper.selectById(examId);
        exam.setStartJobId(Integer.valueOf(startRespObject.get("content", String.class)));
        exam.setStopJobId(Integer.valueOf(endRespObject.get("content", String.class)));
        Integer update = examMapper.updateById(exam, examId);
        if (update <= 0) {
            throw new BusinessException("创建考试失败");
        }
        logger.info("创建开始考试任务：" + title + "  " + startRespObject);
        logger.info("创建结束考试人数：" + title + "  " + endRespObject);
    }

    /**
     * 根据Id删除
     */
    @Transactional
    public Boolean deleteExamById(String examId) throws BusinessException {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginResponseVo loginUserInfo = UserInfoUtil.getLoginUserInfo(stringRedisTemplate);

        // 1. 查询考试信息
        Exam exam = examMapper.selectById(examId);
        if (exam == null) {
            throw new BusinessException("考试信息不存在");
        }

        // 判断是否是自己创建的考试
        if (!loginUserInfo.getId().equals(exam.getCreateBy())) {
            // 判断是否是管理员
            if (!"admin".equals(loginUserInfo.getRole())) {
                throw new BusinessException("无权限删除");
            }
        }


        // 2. 判断考试是否开始或结束
        Date startTime = exam.getStartTime();
        Date endTime = exam.getEndTime();
        if (new Date().after(endTime)) {
            throw new BusinessException("考试已经结束，不可删除");
        }
        if (new Date().after(startTime)) {
            throw new BusinessException("考试已经开始，不可删除");
        }
        // 3. 删除考试
        Integer deleteExamResult = examMapper.deleteById(examId);
        if (deleteExamResult <= 0) {
            throw new BusinessException("删除考试失败");
        }
        // 4. 删除考试记录
        ExamRecordQuery examRecordQuery = new ExamRecordQuery();
        examRecordQuery.setExamId(examId);
        List<ExamRecord> records = examRecordMapper.selectList(examRecordQuery);
        if (records != null && records.size() != 0) {
            for (ExamRecord record : records) {
                String recordId = record.getId();
                Integer deleteRecordResult = examRecordMapper.deleteById(recordId);
                if (deleteRecordResult <= 0) {
                    throw new BusinessException("删除关联考试记录失败");
                }
            }
        }


        // 5. 删除考试任务
        ResponseEntity<String> response = XxlJobUtil.deleteXxlJob(exam.getStartJobId());
        ResponseEntity<String> response1 = XxlJobUtil.deleteXxlJob(exam.getStopJobId());
        return true;
    }

    /**
     * 查询考试
     *
     * @param query
     * @return
     */
    @Override
    public PaginationResultVO<ExamVO> loadExamList(ExamQuery query) throws BusinessException {
        // 1. 查询相关考试
        PaginationResultVO<Exam> pageList = findListByPage(query);

        PaginationResultVO<ExamVO> examVoList = new PaginationResultVO<>();

        List<Exam> list = pageList.getList();
        if (list == null || list.size() == 0) {
            BeanUtil.copyProperties(pageList, examVoList);
            examVoList.setList(new ArrayList<ExamVO>());
            return examVoList;
        }
        List<ExamVO> examVOS = new ArrayList<>();
        for (Exam exam : list) {
            ExamVO examVO = new ExamVO();
            BeanUtil.copyProperties(exam, examVO);
            // 2. 查询关联试卷
            String paperId = exam.getPaperId();
            if (paperId == null || "".equals(paperId)) {
                throw new BusinessException("关联试卷信息为空");
            }
            Paper paper = paperMapper.selectById(paperId);
            if (paper == null) {
                throw new BusinessException("关联试卷信息为空");
            }
            examVO.setTotalCount(paper.getTotalCount());
            examVOS.add(examVO);
        }

        BeanUtil.copyProperties(pageList, examVoList);
        examVoList.setList(examVOS);
        return examVoList;
    }


    /**
     * 获取服务端时间
     *
     * @return
     */
    @Override
    public Date getServerTime() {
        return new Date();
    }

    @Override
    public List<ExamVO> getExamInfoByUserId(String userId) throws BusinessException {
        // 1. 先查询创建的考试记录
        ExamRecordQuery examRecordQuery = new ExamRecordQuery();
        examRecordQuery.setUserId(userId);
        List<ExamRecord> list = examRecordMapper.selectList(examRecordQuery);
        if (list == null) {
            return Collections.emptyList();
        }

        // 2. 再查询对应的考试信息
        List<ExamVO> examVOList = new ArrayList<>();
        for (ExamRecord examRecord : list) {
            String examId = examRecord.getExamId();
            ExamQuery examQuery = new ExamQuery();
            examQuery.setId(examId);
            PaginationResultVO<ExamVO> examVOPaginationResultVO = loadExamList(examQuery);
            List<ExamVO> examVOS = examVOPaginationResultVO.getList();
            examVOList.addAll(examVOS);
        }
        return examVOList;
    }

    /**
     * 获取批阅试卷列表
     *
     * @param examQuery
     * @return
     */
    @Override
    public PaginationResultVO<CorrectExamVO> getCorrectExam(ExamQuery examQuery) {
        String createBy = examQuery.getCreateBy();
        if (createBy == null || "".equals(createBy)) {
            throw new BusinessException("缺少参数");
        }

        PaginationResultVO<CorrectExamVO> resultVO = new PaginationResultVO<>();


        // 1. 查询该管理员或教师发布的考试
        PaginationResultVO<Exam> paginationResultVO = findListByPage(examQuery);
        List<Exam> examList = paginationResultVO.getList();

        List<CorrectExamVO> correctExamVOS = new ArrayList<>();
        // 2. 查看有多少人应该考试
        if (examList != null) {
            for (Exam exam : examList) {
                CorrectExamVO correctExamVO = new CorrectExamVO();
                correctExamVO.setExam(exam);
                // 3. 查看对应的考试记录，统计有多少人考试
                String examId = exam.getId();
                ExamRecordQuery examRecordQuery = new ExamRecordQuery();
                examRecordQuery.setExamId(examId);
                List<ExamRecord> examRecordList = examRecordMapper.selectList(examRecordQuery);
                // 设置考试人数
                correctExamVO.setExamTotal(examRecordList.size());
                // 设置待批阅的人数(查看该试卷是否需要批阅)
                Integer reviewQuire = exam.getReviewQuire();
                if (reviewQuire == 0) { // 不需要阅卷
                    correctExamVO.setCorrectTotal(0);
                } else { // 需要阅卷
                    // 查看考试记录的处理状态
                    Integer count = 0;
                    if (examRecordList != null) {
                        for (ExamRecord examRecord : examRecordList) {
                            if (examRecord.getHandState() == 0) {
                                count++;
                            }
                        }
                    }
                    correctExamVO.setCorrectTotal(count);
                }
                correctExamVOS.add(correctExamVO);
            }
        }
        BeanUtil.copyProperties(paginationResultVO, resultVO);
        resultVO.setList(correctExamVOS);
        return resultVO;
    }

    @Override
    public List<CorrectExamVO> getCorrectExamByParam(ExamQuery query) {
        // 1. 查询符合条件的考试
        ExamQuery examQuery = new ExamQuery();
        BeanUtil.copyProperties(query, examQuery);
        List<Exam> examList = examMapper.selectList(examQuery);
        List<CorrectExamVO> correctExamVOS = new ArrayList<>();
        // 2. 查看有多少人应该考试
        if (examList != null) {
            for (Exam exam : examList) {
                CorrectExamVO correctExamVO = new CorrectExamVO();
                correctExamVO.setExam(exam);
                // 3. 查看对应的考试记录，统计有多少人考试
                String examId = exam.getId();
                ExamRecordQuery examRecordQuery = new ExamRecordQuery();
                examRecordQuery.setExamId(examId);
                List<ExamRecord> examRecordList = examRecordMapper.selectList(examRecordQuery);
                // 设置考试人数
                correctExamVO.setExamTotal(examRecordList.size());
                // 设置待批阅的人数(查看该试卷是否需要批阅)
                Integer reviewQuire = exam.getReviewQuire();
                if (reviewQuire == 0) { // 不需要阅卷
                    correctExamVO.setCorrectTotal(0);
                } else { // 需要阅卷
                    // 查看考试记录的处理状态
                    Integer count = 0;
                    if (examRecordList != null) {
                        for (ExamRecord examRecord : examRecordList) {
                            if (examRecord.getHandState() == 0) {
                                count++;
                            }
                        }
                    }
                    correctExamVO.setCorrectTotal(count);
                }
                correctExamVOS.add(correctExamVO);
            }

        }
        return correctExamVOS;
    }


    /**
     * 开始考试
     */
    @XxlJob(value = "startExam")
    public void startExam() {
        String examId = XxlJobHelper.getJobParam();
        if (examId == null || "".equals(examId)) {
            throw new BusinessException("考试Id为空");
        }
        // 1. 获取考试
        Exam exam = new Exam();
        // 修改考试状态
        exam.setStatue(1);
        // 2. 更新考试信息
        Integer integer = examMapper.updateById(exam, examId);
        if (integer <= 0) {
            System.out.println("更改考试状态失败");
        } else {
            System.out.println("更改考试状态成功");
        }
    }

    /**
     * 结束考试
     */
    @XxlJob(value = "stopExam")
    @Transactional
    public void stopExam() {
        String examId = XxlJobHelper.getJobParam();
        if (StrUtil.isEmpty(examId)) {
            throw new BusinessException("考试Id为空");
        }
        // 1. 获取考试
        Exam exam = new Exam();
        // 修改考试状态
        exam.setStatue(2);
        // 2. 更新考试信息
        Integer integer = examMapper.updateById(exam, examId);
        if (integer <= 0) {
            logger.info("更改考试状态失败");
        } else {
            logger.info("更改考试状态成功");
            // 3. 获取该考试考生的一些考试记录信息
            ExamRecordQuery examRecordQuery = new ExamRecordQuery();
            examRecordQuery.setExamId(examId);
            List<ExamRecord> examRecords = examRecordMapper.selectList(examRecordQuery);
            if (examRecords != null && examRecords.size() != 0) {
                for (ExamRecord examRecord : examRecords) {
                    if (examRecord.getState() == ExamRecordStateType.NOREPLY.getValue()) { // 未作答状态
                        // 3.1 如果没有作答直接将批阅处理状态改为已处理
                        examRecord.setHandState(1);
                        // 3.2 通过状态改为未通过
                        examRecord.setPassed(0);
                        // 3.3 修改批阅时间
                        examRecord.setReviewTime(new Date());
                        // 3.4 总分改为0
                        examRecord.setTotalScore(0);
                        // 更新
                        Integer result = examRecordMapper.updateById(examRecord, examRecord.getId());
                        if (result <= 0) {
                            throw new BusinessException("更新考试记录失败");
                        }
                    } else if (examRecord.getState() == ExamRecordStateType.UNCOMPLETED.getValue()) { // 未完成状态
                        // 判断试卷是否需要批阅
                        Integer reviewQuire = exam.getReviewQuire();
                        // 只处理不需要批阅的
                        if (reviewQuire == 0) {
                            List<UserAnswer> wrongList = null;
                            // 设置已处理状态
                            examRecord.setHandState(1);
                            UserAnswerQuery userAnswerQuery = new UserAnswerQuery();
                            userAnswerQuery.setUserId(examRecord.getUserId());
                            userAnswerQuery.setExamRecordId(examRecord.getId());
                            List<UserAnswer> list = userAnswerMapper.selectList(userAnswerQuery);
                            Integer totalScore = 0;
                            if (list != null && list.size() != 0) {
                                wrongList = new ArrayList<>();
                                for (UserAnswer userAnswer : list) {
                                    // 获取得分
                                    totalScore += userAnswer.getScore();
                                    // 判断是否答对
                                    Integer isRight = userAnswer.getIsRight();
                                    if (isRight == 0) {
                                        // 搜集错题
                                        wrongList.add(userAnswer);
                                    }
                                }
                            }
                            examRecord.setTotalScore(totalScore);
                            // 判断是否通过
                            Integer qualifyScore = exam.getQualifyScore();
                            if (qualifyScore < totalScore) {
                                examRecord.setPassed(1);
                            } else {
                                examRecord.setPassed(0);
                            }
                            // 修改批阅时间
                            examRecord.setReviewTime(new Date());

                            // 更新
                            Integer result = examRecordMapper.updateById(examRecord, examRecord.getId());
                            if (result <= 0) {
                                throw new BusinessException("更新考试记录失败");
                            }

                            // 搜集错题
                            reviewSubject.notifyBookUpdate(wrongList);
                        }
                    }
                }
            }
        }
    }

    /**
     * 根据用户答案更新错题本数据
     *
     * @param userAnswer
     */
    private void updateBookData(UserAnswer userAnswer) {
        // 答错更新错题本数据
        BookQuery bookQuery = new BookQuery();
        bookQuery.setQuId(userAnswer.getQuId());
        bookQuery.setUserId(userAnswer.getUserId());
        List<Book> bookList = bookMapper.selectList(bookQuery);
        if (bookList != null && bookList.size() != 0) {
            // 存在，则直接进行更改
            Book book = bookList.get(0);
            book.setWrongCount(book.getWrongCount() + 1);
            Integer update = bookMapper.updateById(book, book.getId());
            if (update <= 0) {
                throw new BusinessException("更新错题表失败");
            }
        } else {
            Book book = new Book();
            book.setId(CommonUtil.getRandomId());
            book.setQuId(userAnswer.getQuId());
            book.setUserId(userAnswer.getUserId());
            book.setWrongCount(1);
            Integer insert = bookMapper.insert(book);
            if (insert <= 0) {
                throw new BusinessException("更新错题表失败");
            }
        }
    }

    @Override
    public List<WrongQuVO> getExamQuAnalyse(String examId) throws BusinessException {
        Exam exam = examMapper.selectById(examId);
        if (exam == null) {
            throw new BusinessException("该考试不存在");
        }
        String paperId = exam.getPaperId();

        // 获取考试关联试卷
        if (StrUtil.isEmpty(paperId)) {
            throw new BusinessException("考试未关联试卷");
        }

        PaperAndQuVO paperDetail = paperService.getPaperDetailById(paperId);
        if (paperDetail == null) {
            throw new BusinessException("试卷详细信息缺失");
        }

        List<WrongQuVO> result = new ArrayList<>();

        // 计算每道题的分析
        List<GroupListVO> groupLists = paperDetail.getGroupLists();
        if (groupLists != null) {
            for (GroupListVO groupList : groupLists) {
                List<QuAndAnswerVo> quList = groupList.getQuList();
                if (quList != null && quList.size() != 0) {
                    // 遍历每道题目
                    for (QuAndAnswerVo quAndAnswerVo : quList) {
                        WrongQuVO wrongQuVO = new WrongQuVO();
                        wrongQuVO.setQuAndAnswerVo(quAndAnswerVo);
                        // 获取该场考试对应的考试记录
                        ExamRecordQuery examRecordQuery = new ExamRecordQuery();
                        examRecordQuery.setExamId(examId);
                        List<ExamRecord> examRecords = examRecordMapper.selectList(examRecordQuery);
                        if (examRecords != null && examRecords.size() != 0) {
                            Integer rightCount = 0;
                            for (ExamRecord examRecord : examRecords) {
                                // 获取该题目的正确率等信息（quId+examRecordId 获取到该场考试该道题目的对错信息）
                                String quId = quAndAnswerVo.getId();
                                String recordId = examRecord.getId();
                                UserAnswerQuery userAnswerQuery = new UserAnswerQuery();
                                userAnswerQuery.setQuId(quId);
                                userAnswerQuery.setExamRecordId(recordId);
                                userAnswerQuery.setIsRight(1);
                                rightCount += userAnswerMapper.selectCount(userAnswerQuery);
                            }
                            // 一共有几个考试记录，则有几道题目
                            wrongQuVO.setRightCount(rightCount);
                            wrongQuVO.setErrorCount(examRecords.size() - rightCount);
                            // 正确率计算
                            DecimalFormat df = new DecimalFormat("0.00%");
                            String rate = df.format((double) rightCount / (double) examRecords.size());
                            wrongQuVO.setRightRate(rate);
                        }
                        result.add(wrongQuVO);
                    }
                }
            }
        }
        return result;
    }

    @Override
    public List<WrongQuVO> getPaperQuAnalyse(String paperId) throws BusinessException {
        // 1. 获取试卷信息
        Paper paper = paperMapper.selectById(paperId);
        if (paper == null) {
            throw new BusinessException("试卷不存在");
        }

        // 2. 获取试卷的详细信息
        PaperAndQuVO paperDetail = paperService.getPaperDetailById(paperId);
        if (paperDetail == null) {
            throw new BusinessException("试卷详情为空");
        }


        // 3. 获取试卷关联的考试信息
        ExamQuery examQuery = new ExamQuery();
        examQuery.setPaperId(paperId);
        List<Exam> examList = examMapper.selectList(examQuery);
        if (examList == null || examList.isEmpty()) {
            throw new BusinessException("未曾使用过该试卷发布考试");
        }
        List<WrongQuVO> result = new ArrayList<>();

        // 计算每道题的分析
        List<GroupListVO> groupLists = paperDetail.getGroupLists();
        if (groupLists != null) {
            for (GroupListVO groupList : groupLists) {
                List<QuAndAnswerVo> quList = groupList.getQuList();
                if (quList != null && quList.size() != 0) {
                    // 遍历每道题目
                    for (QuAndAnswerVo quAndAnswerVo : quList) {
                        // 总记录数（相当于一道题目有多少个人做）
                        Integer totalCount = 0;
                        // 作对的人数
                        Integer rightCount = 0;
                        WrongQuVO wrongQuVO = new WrongQuVO();
                        wrongQuVO.setQuAndAnswerVo(quAndAnswerVo);
                        // 4.遍历考试
                        if (!examList.isEmpty()) {
                            for (Exam exam : examList) {
                                String examId = exam.getId();
                                // 获取该场考试对应的考试记录
                                ExamRecordQuery examRecordQuery = new ExamRecordQuery();
                                examRecordQuery.setExamId(examId);
                                List<ExamRecord> examRecords = examRecordMapper.selectList(examRecordQuery);
                                if (examRecords != null && examRecords.size() != 0) {
                                    totalCount += examRecords.size();
                                    for (ExamRecord examRecord : examRecords) {
                                        // 获取该题目的正确率等信息（quId+examRecordId 获取到该场考试该道题目的对错信息）
                                        String quId = quAndAnswerVo.getId();
                                        String recordId = examRecord.getId();
                                        UserAnswerQuery userAnswerQuery = new UserAnswerQuery();
                                        userAnswerQuery.setQuId(quId);
                                        userAnswerQuery.setExamRecordId(recordId);
                                        userAnswerQuery.setIsRight(1);
                                        rightCount += userAnswerMapper.selectCount(userAnswerQuery);
                                    }
                                }
                            }
                            // 一共有几个考试记录，则有几道题目
                            wrongQuVO.setRightCount(rightCount);
                            wrongQuVO.setErrorCount(totalCount - rightCount);
                            // 正确率计算
                            DecimalFormat df = new DecimalFormat("0.00%");
                            String rate = df.format((double) rightCount / (double) totalCount);
                            wrongQuVO.setRightRate(rate);
                        }
                        result.add(wrongQuVO);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 发送考试通知（邮件通知）
     *
     * @param exam
     */
    public void sendExamMailNotifie(Exam exam) {
        MailContent mailContent = new MailContent();
        Tmpl tmpl = tmplMapper.selectById(MailConstant.NOTIFICATION_TMPL.toString());
        String title = tmpl.getTitle();
        mailContent.setSubject(title);
        String tmplContent = tmpl.getContent();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTime = simpleDateFormat.format(exam.getStartTime());
        String endTime = simpleDateFormat.format(exam.getEndTime());
        String mailContext = String.format(tmplContent, exam.getTitle(), startTime, endTime);
        mailContent.setContext(mailContext);

        // 查询该场考试关联的所有考生
        ExamRecordQuery examRecordQuery = new ExamRecordQuery();
        examRecordQuery.setExamId(exam.getId());
        List<ExamRecord> examRecords = examRecordMapper.selectList(examRecordQuery);

        List<String> userEmailList = new ArrayList<>();
        // 生成MsgId
        String msgId = CommonUtil.getRandomId();
        if (examRecords != null && !examRecords.isEmpty()) {
            List<MsgUser> msgUsers = new ArrayList<>();
            for (ExamRecord examRecord : examRecords) {
                String userId = examRecord.getUserId();
                User user = userMapper.selectById(userId);
                if (user != null) { // 有邮箱才发送邮件通知
                    String toEmail = user.getEmail();
                    if (toEmail != null && !"".equals(toEmail.trim())) {
                        userEmailList.add(toEmail);
                        MsgUser msgUser = new MsgUser();
                        msgUser.setId(CommonUtil.getRandomId());
                        msgUser.setMsgId(msgId);
                        // 未读状态
                        msgUser.setState(0);
                        msgUser.setUserId(userId);
                        msgUsers.add(msgUser);
                    }
                }
            }

            // 批量插入
            // 插入消息考试关联表
            Integer insert = msgUserMapper.insertBatch(msgUsers);
            if (insert <= 0) {
                logger.warn("消息保存失败");
            }

            // 发送邮件通知
            mailContent.setEmailList(userEmailList);
            MailUtil.groupEmail(mailContent, javaMailSender, from);

            // 插入考试消息记录
            Msg msg = new Msg();
            msg.setId(msgId);
            msg.setContent(mailContext);
            msg.setState(1);
            msg.setReadCount(0);
            msg.setTemplId(tmpl.getId());
            msg.setSendCount(examRecords.size());
            msg.setSendTime(new Date());
            msg.setTitle(tmpl.getTitle());
            msg.setMsgType(MsgType.EMAIL.getValue());
            msg.setCreateUser(exam.getCreateBy());
            User user = userMapper.selectById(exam.getCreateBy());
            if (user == null) {
                throw new BusinessException("创建考试用户不存在");
            }
            msg.setCreateUserText(user.getUserName());
            insert = msgMapper.insert(msg);
            if (insert <= 0) {
                throw new BusinessException("考试通知失败(邮件通知)");
            }
        }
    }


    /**
     * 发送考试通知（站内通知）
     *
     * @param exam
     */
    public void sendExamNotifie(Exam exam) {
        Tmpl tmpl = tmplMapper.selectById(MailConstant.NOTIFICATION_TMPL.toString());
        String tmplContent = tmpl.getContent();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTime = simpleDateFormat.format(exam.getStartTime());
        String endTime = simpleDateFormat.format(exam.getEndTime());
        String msgContext = String.format(tmplContent, exam.getTitle(), startTime, endTime);

        // 查询该场考试关联的所有考生
        ExamRecordQuery examRecordQuery = new ExamRecordQuery();
        examRecordQuery.setExamId(exam.getId());
        List<ExamRecord> examRecords = examRecordMapper.selectList(examRecordQuery);

        // 生成MsgId
        String msgId = CommonUtil.getRandomId();
        if (examRecords != null && !examRecords.isEmpty()) {
            List<MsgUser> msgUsers = new ArrayList<>();
            for (ExamRecord examRecord : examRecords) {
                String userId = examRecord.getUserId();
                User user = userMapper.selectById(userId);
                if (user != null) {
                    MsgUser msgUser = new MsgUser();
                    msgUser.setId(CommonUtil.getRandomId());
                    msgUser.setMsgId(msgId);
                    // 未读状态
                    msgUser.setState(0);
                    msgUser.setUserId(userId);
                    msgUsers.add(msgUser);
                }
            }

            // 批量插入
            // 插入消息考试关联表
            Integer insert = msgUserMapper.insertBatch(msgUsers);
            if (insert <= 0) {
                logger.warn("消息保存失败");
            }

            // 插入考试消息记录
            Msg msg = new Msg();
            msg.setId(msgId);
            msg.setContent(msgContext);
            msg.setState(1);
            msg.setReadCount(0);
            msg.setTemplId(tmpl.getId());
            msg.setSendCount(examRecords.size());
            msg.setSendTime(new Date());
            msg.setTitle(tmpl.getTitle());
            msg.setMsgType(MsgType.NOTIFICATION.getValue());
            msg.setCreateUser(exam.getCreateBy());
            User user = userMapper.selectById(exam.getCreateBy());
            if (user == null) {
                throw new BusinessException("创建考试用户不存在");
            }
            msg.setCreateUserText(user.getUserName());
            insert = msgMapper.insert(msg);
            if (insert <= 0) {
                throw new BusinessException("考试通知失败(站内通知)");
            }
        }
    }

}