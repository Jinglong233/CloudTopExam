package com.jl.project.service.impl;

import com.jl.project.entity.po.Exam;
import com.jl.project.entity.po.ExamRecord;
import com.jl.project.entity.query.ExamQuery;
import com.jl.project.entity.query.ExamRecordQuery;
import com.jl.project.enums.ExamRecordStateType;
import com.jl.project.exception.BusinessException;
import com.jl.project.mapper.ExamMapper;
import com.jl.project.mapper.ExamRecordMapper;
import com.jl.project.service.StudentExamRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service("studentExamRecordService")
public class StudentExamRecordServiceImpl implements StudentExamRecordService {

    @Resource
    private ExamRecordMapper<ExamRecord, ExamRecordQuery> examRecordMapper;

    @Resource
    private ExamMapper<Exam, ExamQuery> examMapper;


    @Override
    public List<ExamRecord> getStudentExamRecord(ExamRecordQuery examRecordQuery) {
        if (examRecordQuery == null) {
            throw new BusinessException("参数为空");
        }
        List<ExamRecord> list = examRecordMapper.selectList(examRecordQuery);
        return list;
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
}
