package com.jl.project.entity.query;

import com.jl.project.enums.PageSize;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 简单分页对象
 */
@Schema(description = "简单分页对象")
public class SimplePage {
    /**
     * 页码
     */
    @Schema(description = "页码")
    private Integer pageNo;
    /**
     * 总数据量
     */
    @Schema(description = "总数据量")
    private Integer countTotal;
    /**
     * 页码大小
     */
    @Schema(description = "页码大小")
    private Integer pageSize;
    /**
     * 总页数
     */
    @Schema(description = "总页数")
    private Integer pageTotal;
    /**
     * 起始页
     */
    @Schema(description = "起始页")
    private Integer start;
    /**
     * 结束页
     */
    @Schema(description = "结束页")
    private Integer end;

    public SimplePage() {
    }

    public SimplePage(Integer pageNo, Integer countTotal, Integer pageSize) {
        if (null == pageNo) {
            pageNo = 0;
        }
        this.pageNo = pageNo;
        this.countTotal = countTotal;
        this.pageSize = pageSize;
        action();
    }


    public SimplePage(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    public void action() {
        if (this.pageSize <= 0) {
            this.pageSize = PageSize.SIZE20.getSize();
        }
        if (this.countTotal > 0) {
            this.pageTotal = this.countTotal % this.pageSize == 0 ? this.countTotal / this.pageSize
                    : this.countTotal / this.pageSize + 1;
        } else {
            pageTotal = 1;
        }
        if (pageNo <= 1) {
            pageNo = 1;
        }
        if (pageNo > pageTotal) {
            pageNo = pageTotal;
        }
        this.start = (pageNo - 1) * pageSize;
        this.end = this.pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getCountTotal() {
        return countTotal;
    }

    public void setCountTotal(Integer countTotal) {
        this.countTotal = countTotal;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }
}
