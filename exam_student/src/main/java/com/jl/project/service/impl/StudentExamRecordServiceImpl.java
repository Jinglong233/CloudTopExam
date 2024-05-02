package com.jl.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.jl.project.entity.po.Exam;
import com.jl.project.entity.po.ExamRecord;
import com.jl.project.entity.po.User;
import com.jl.project.entity.query.ExamQuery;
import com.jl.project.entity.query.ExamRecordQuery;
import com.jl.project.entity.query.SimplePage;
import com.jl.project.entity.query.UserQuery;
import com.jl.project.entity.vo.AnsweredRecordVO;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.enums.ExamRecordStateType;
import com.jl.project.enums.PageSize;
import com.jl.project.exception.BusinessException;
import com.jl.project.mapper.ExamMapper;
import com.jl.project.mapper.ExamRecordMapper;
import com.jl.project.mapper.UserMapper;
import com.jl.project.service.StudentExamRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service("studentExamRecordService")
public class StudentExamRecordServiceImpl implements StudentExamRecordService {

    @Resource
    private ExamRecordMapper<ExamRecord, ExamRecordQuery> examRecordMapper;

    @Resource
    private UserMapper<User, UserQuery> userMapper;

    @Resource
    private ExamMapper<Exam, ExamQuery> examMapper;

    /**
     * 根据条件查询列表
     */
    public List<ExamRecord> findListByParam(ExamRecordQuery query) {
        return this.examRecordMapper.selectList(query);
    }

    /**
     * 根据条件查询数量
     */
    public Integer findCountByParam(ExamRecordQuery query) {
        return this.examRecordMapper.selectCount(query);
    }

    /**
     * 分页查询
     */
    public PaginationResultVO<ExamRecord> findListByPage(ExamRecordQuery query) {
        Integer count = this.findCountByParam(query);
        Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
        SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
        query.setSimplePage(page);
        List<ExamRecord> list = this.findListByParam(query);
        PaginationResultVO<ExamRecord> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
        return result;
    }


    @Override
    public PaginationResultVO<ExamRecord> getStudentExamRecord(ExamRecordQuery examRecordQuery) {
        return findListByPage(examRecordQuery);
    }

    @Override
    public Date startAnswer(ExamRecordQuery query) {
        if (query == null) {
            throw new BusinessException("缺少参数");
        }
        List<ExamRecord> list = examRecordMapper.selectList(query);
        if (list == null) {
            throw new BusinessException("系统出错（为创建考试记录）");
        }
        String examId = query.getExamId();
        if (examId == null) {
            throw new BusinessException("缺少参数");
        }
        ExamRecord examRecord = list.get(0);
        Date startTime = null;
        // 判断该考生是否已经开始考试
        Integer state = examRecord.getState();
        if (state.equals(ExamRecordStateType.NOREPLY.getValue())) { // 没有开始考试初始化考试记录信息
            // 设置开始作答时间
            startTime = new Date();
            examRecord.setStartTime(startTime);
            // 设置该考生的考试状态(未完成状态)
            examRecord.setState(ExamRecordStateType.UNCOMPLETED.getValue());
            Integer result = examRecordMapper.updateById(examRecord, examRecord.getId());
            if (result > 0) {
                return startTime;
            } else {
                throw new BusinessException("系统出错");
            }
        } else if (state.equals(ExamRecordStateType.UNCOMPLETED.getValue())) {
            // 如果是未完成状态，则还需判断是否超过作答时间
            Date date = new Date();
            Exam exam = examMapper.selectById(examId);
            if (exam == null) {
                throw new BusinessException("该场考试不存在");
            }
            if (date.after(exam.getEndTime())) {
                examRecord.setEndTime(exam.getEndTime());
                examRecord.setState(ExamRecordStateType.SUBMITTED.getValue());
                throw new BusinessException("考试结束");
            }
            return exam.getStartTime();
        } else {
            // 已提交就直接返回
            throw new BusinessException("已提交");
        }
    }

    @Override
    public List<AnsweredRecordVO> getAnsweredRecord(String userId) {
        User user = userMapper.selectById(userId);
        if (user == null) {
            throw new BusinessException("该用户不存在");
        }
        List<ExamRecord> list = new ArrayList<>();

        ExamRecordQuery examRecordQuery = new ExamRecordQuery();
        examRecordQuery.setUserId(userId);
        // 设置作答状态
        examRecordQuery.setState(1);
        list = examRecordMapper.selectList(examRecordQuery);

        // 继续查询已交卷的
        examRecordQuery.setState(2);
        list.addAll(examRecordMapper.selectList(examRecordQuery));
        List<AnsweredRecordVO> collect = null;
        if (list != null && list.size() != 0) {
            collect = list.stream().map(examRecord -> {
                AnsweredRecordVO answeredRecordVO = new AnsweredRecordVO();
                BeanUtil.copyProperties(examRecord, answeredRecordVO);
                answeredRecordVO.setUserName(user.getUserName());

                String examId = examRecord.getExamId();
                Exam exam = examMapper.selectById(examId);
                if (exam!=null){
                    answeredRecordVO.setTitle(exam.getTitle());
                }
                return answeredRecordVO;
            }).collect(Collectors.toList());
        }
        return collect;
    }
}
