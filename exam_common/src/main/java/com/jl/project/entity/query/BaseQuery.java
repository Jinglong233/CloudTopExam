package com.jl.project.entity.query;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 基础查询条件
 */
@Schema(description = "基础查询条件")
public class BaseQuery {
    /**
     * 简单分页对象
     */
    @Schema(description = "简单分页对象")
    private SimplePage simplePage;
    /**
     * 页码
     */
    @Schema(description = "页码")
    private Integer pageNo;
    /**
     * 页面大小
     */
    @Schema(description = "页面大小")
    private Integer pageSize;
    /**
     * 页面排序
     */
    @Schema(description = "页面排序")
    private String orderBy;

    public SimplePage getSimplePage() {
        return simplePage;
    }

    public void setSimplePage(SimplePage simplePage) {
        this.simplePage = simplePage;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
