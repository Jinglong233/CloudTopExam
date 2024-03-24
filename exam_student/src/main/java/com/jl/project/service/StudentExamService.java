package com.jl.project.service;

import com.jl.project.entity.dto.SubmitExamDTO;
import com.jl.project.entity.po.ExamRecord;
import com.jl.project.entity.query.ExamQuery;
import com.jl.project.entity.vo.ExamResultVO;
import com.jl.project.entity.vo.ExamVO;

import java.util.List;

public interface StudentExamService {

    public List<ExamVO> loadStudentExamList(String userId);

    Double submitExam(SubmitExamDTO submitExamDTO);

    ExamResultVO getExamResult(String examRecordId);
}
