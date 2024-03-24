package com.jl.project.entity.dto;

import com.jl.project.entity.po.Exam;
import com.jl.project.entity.po.User;

import java.util.List;

public class UpdateExamDTO extends Exam {
    private List<User> userList;


    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
