package com.jl.project.entity.dto;

import com.jl.project.entity.po.Subject;

public class UpdateSubjectDTO {
    private String id;
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
