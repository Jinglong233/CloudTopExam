package com.jl.project.entity.vo;

import com.jl.project.entity.dto.AddGroupListDTO;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 大题VO
 */
@Schema(description = "大题VO")
public class GroupListVO extends AddGroupListDTO {
    /**
     * 此Glid可以帮助用户答案定位到具体题目，获取该题目在具体考试中的题目分数
     */
    @Schema(description = "此Glid可以帮助用户答案定位到具体题目，获取该题目在具体考试中的题目分数")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
