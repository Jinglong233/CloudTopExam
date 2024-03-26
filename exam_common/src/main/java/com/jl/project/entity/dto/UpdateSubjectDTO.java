package com.jl.project.entity.dto;

import com.jl.project.entity.po.Subject;

/**
 * 更新学科DTO
 */
public class UpdateSubjectDTO {
    /**
     * 学科Id
     */
    private String id;
    /**
     * 学科对象
     */
    private Subject subject;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
