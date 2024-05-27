package com.jl.project.service;

import com.jl.project.entity.dto.SubmitExamDTO;
import com.jl.project.entity.vo.ExamResultVO;
import com.jl.project.entity.vo.ExamVO;

import java.util.List;

public interface StudentExamService {

    public List<ExamVO> loadStudentExamList(String userId);

    Boolean submitExam(SubmitExamDTO submitExamDTO);

    ExamResultVO getExamResult(String examRecordId);
}
