package com.jl.project.utils;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.PageUtil;
import com.jl.project.entity.query.SimplePage;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.enums.PageSize;
import com.jl.project.enums.QuLevel;
import com.jl.project.enums.QuType;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CommonUtil {

    /**
     * 分页方法
     *
     * @param list
     * @param page
     * @param <T>
     * @return
     */
    public static <T> PaginationResultVO<T> paginate(List<T> list, SimplePage page) {
        if (page.getPageNo() <= 0 || page.getPageNo() > list.size()) {
            page.setPageNo(1);
        }
        if (page.getPageSize() == null || page.getPageSize() <= 0) {
            page.setPageSize(PageSize.SIZE15.getSize());
        }
        PaginationResultVO<T> result = new PaginationResultVO<>();
        int startIndex = (page.getPageNo() - 1) * page.getPageSize();
        int endIndex = Math.min(startIndex + page.getPageSize(), list.size());
        result.setList(list.subList(startIndex, endIndex));
        result.setPageNo(page.getPageNo());
        result.setPageSize(page.getPageSize());
        result.setTotalCount(list.size());
        result.setPageTotal(PageUtil.totalPage(list.size(), page.getPageSize()));
        return result;
    }

    public static String getRandomId() {
        return IdUtil.simpleUUID();
    }

    /**
     * 将日期转换为Cron表达式
     *
     * @param date
     * @return
     */
    public static String getCron(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);                    //放入Date类型数据

        int month = calendar.get(Calendar.MONTH) + 1;                    //获取月份
        int day = calendar.get(Calendar.DATE);                    //获取日

        int hour = calendar.get(Calendar.HOUR_OF_DAY);                //时（24小时制）
        int minute = calendar.get(Calendar.MINUTE);                    //分
        int second = calendar.get(Calendar.SECOND);                    //秒
        StringBuffer cron = new StringBuffer();
        cron.append(second).append(" ")
                .append(minute).append(" ")
                .append(hour).append(" ")
                .append(day).append(" ")
                .append(month).append(" ")
                .append("?");
        return cron.toString();
    }


    /**
     * 判断题型是否合法
     *
     * @param quType
     * @return
     */
    public static Boolean isValidQuestionType(Integer quType) {
        for (QuType type : QuType.values()) {
            if (type.getValue().equals(quType)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断题目难度是否合法
     *
     * @param level
     * @return
     */
    public static Boolean isValidLevelType(Integer level) {
        for (QuLevel type : QuLevel.values()) {
            if (type.getValue().equals(level)) {
                return true;
            }
        }
        return false;
    }
}
