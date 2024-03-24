package com.jl.project.entity.vo;

import com.jl.project.entity.po.Paper;

import java.util.List;

public class PaperAndQuVO extends Paper {


    /**
     * 大题列表
     */
    private List<GroupListVO> groupLists;

    public List<GroupListVO> getGroupLists() {
        return groupLists;
    }

    public void setGroupLists(List<GroupListVO> groupLists) {
        this.groupLists = groupLists;
    }
}
