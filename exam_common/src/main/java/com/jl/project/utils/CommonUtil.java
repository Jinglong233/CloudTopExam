package com.jl.project.utils;

import cn.hutool.core.util.IdUtil;
import com.jl.project.enums.QuLevel;
import com.jl.project.enums.QuType;

import java.util.Calendar;
import java.util.Date;

public class CommonUtil {
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
