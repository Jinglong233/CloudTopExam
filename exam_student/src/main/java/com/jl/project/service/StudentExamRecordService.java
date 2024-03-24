package com.jl.project.service;

import com.jl.project.entity.po.ExamRecord;
import com.jl.project.entity.query.ExamRecordQuery;

import java.util.Date;
import java.util.List;

public interface StudentExamRecordService {

    /**
     * 获取学生的考试记录
     * @param examRecordQuery
     * @return
     */
    public List<ExamRecord> getStudentExamRecord(ExamRecordQuery examRecordQuery);

    /**
     * 开始考试
     * @param query
     * @return
     */
    Date startAnswer(ExamRecordQuery query);
}
