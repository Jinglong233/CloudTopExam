package com.jl.project.entity.dto;

import com.jl.project.entity.po.Exam;
import com.jl.project.entity.po.User;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

/**
 * 创建考试DTO
 */

@Schema(description = "创建考试DTO")
public class AddExamDTO extends Exam {

    /**
     * 试卷Id
     */
    @Schema(description = "试卷Id")
    private String id;
    @Schema(description = "用户列表")
    private List<User> userList;


    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

}
