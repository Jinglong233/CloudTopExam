package com.jl.project.entity.vo;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页查询VO
 *
 * @param <T>
 */
@Schema(description = "分页查询VO")
public class PaginationResultVO<T> {
    /**
     * 总数量
     */
    @Schema(description = "总数量")
    private Integer totalCount;
    /**
     * 页面大小
     */
    @Schema(description = "页面大小")
    private Integer pageSize;
    /**
     * 页码
     */
    @Schema(description = "页码")
    private Integer pageNo;
    /**
     * 总页数
     */
    @Schema(description = "总页数")
    private Integer pageTotal;
    @Schema(hidden = true)
    private List<T> list = new ArrayList<T>();

    public PaginationResultVO(Integer totalCount, Integer pageSize, Integer pageNo, List<T> list) {
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.pageNo = pageNo;
        this.list = list;
    }

    public PaginationResultVO(Integer totalCount, Integer pageSize, Integer pageNo, Integer pageTotal, List<T> list) {
        if (pageNo == 0) {
            pageNo = 1;
        }
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.pageNo = pageNo;
        this.pageTotal = pageTotal;
        this.list = list;
    }

    public PaginationResultVO(List<T> list) {
        this.list = list;
    }

    public PaginationResultVO() {
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
