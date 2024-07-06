package com.jl.project.entity.vo;

import java.util.Date;
import java.util.List;

/**
 * @Author jingLong
 * @Date 2024-06-07 15:47
 **/
public class WrongKnowledgeVO {
    List<ChartVO> chartData;

    /**
     * 总数量
     */
    Integer count;

    /**
     * 统计时间
     */
    Date statisticalTime;

    public WrongKnowledgeVO() {
    }

    public WrongKnowledgeVO(List<ChartVO> chartData, Integer count, Date statisticalTime) {
        this.chartData = chartData;
        this.count = count;
        this.statisticalTime = statisticalTime;
    }

    public List<ChartVO> getChartData() {
        return chartData;
    }

    public void setChartData(List<ChartVO> chartData) {
        this.chartData = chartData;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getStatisticalTime() {
        return statisticalTime;
    }

    public void setStatisticalTime(Date statisticalTime) {
        this.statisticalTime = statisticalTime;
    }
}
