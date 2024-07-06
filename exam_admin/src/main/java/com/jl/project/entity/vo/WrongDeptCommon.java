package com.jl.project.entity.vo;

import java.util.Date;
import java.util.List;

/**
 * @Description 错题知识点占比
 * @Author jingLong
 * @Date 2024-06-01 10:54
 **/
public class WrongDeptCommon {
    List<ChartVO> chartData;

    /**
     * 总数量
     */
    Integer count;

    /**
     * 统计时间
     */
    Date statisticalTime;

    public WrongDeptCommon() {
    }

    public WrongDeptCommon(List<ChartVO> chartData, Integer count, Date statisticalTime) {
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

    public Date getStatisticalTime() {
        return statisticalTime;
    }

    public void setStatisticalTime(Date statisticalTime) {
        this.statisticalTime = statisticalTime;
    }


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
