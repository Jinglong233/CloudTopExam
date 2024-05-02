package com.jl.project.service;


import java.util.List;
import java.util.Map;

public interface StudentDataAnalyzesService {
    Integer getTrainCount();

    Integer getExamCount();

    Map<String, List> getMyRecentExam();
}
