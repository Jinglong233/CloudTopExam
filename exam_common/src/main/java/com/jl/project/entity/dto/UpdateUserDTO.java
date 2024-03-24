package com.jl.project.entity.dto;

import com.jl.project.entity.po.User;

public class UpdateUserDTO {
    private User user;
    private String id;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
