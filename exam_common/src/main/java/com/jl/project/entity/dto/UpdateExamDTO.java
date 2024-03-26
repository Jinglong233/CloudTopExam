package com.jl.project.entity.dto;

import com.jl.project.entity.po.Exam;
import com.jl.project.entity.po.User;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

/**
 * 更新考试DTO
 */
@Schema(description = "更新考试DTO")
public class UpdateExamDTO extends Exam {
    /**
     * 关联的用户列表
     */
    @Schema(description = "关联的用户列表")
    private List<User> userList;


    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
