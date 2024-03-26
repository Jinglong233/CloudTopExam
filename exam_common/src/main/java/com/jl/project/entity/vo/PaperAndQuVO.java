package com.jl.project.entity.vo;

import com.jl.project.entity.po.Paper;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

/**
 * 试卷及其对应问题Vo
 */
@Schema(description = "试卷及其对应问题Vo")
public class PaperAndQuVO extends Paper {


    /**
     * 大题列表
     */
    @Schema(description = "大题列表")
    private List<GroupListVO> groupLists;

    public List<GroupListVO> getGroupLists() {
        return groupLists;
    }

    public void setGroupLists(List<GroupListVO> groupLists) {
        this.groupLists = groupLists;
    }
}
