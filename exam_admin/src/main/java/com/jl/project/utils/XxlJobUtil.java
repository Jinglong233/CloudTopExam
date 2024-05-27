package com.jl.project.utils;

import com.jl.project.constant.Constant;
import com.jl.project.exception.BusinessException;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;

public class XxlJobUtil {
    @Resource
    private ResourceLoader resourceLoader;

    private static MultiValueMap<String, String> getBaseXxlJobArg() {
        MultiValueMap<String, String> mulmap = new LinkedMultiValueMap<>();
        mulmap.add("author", "bread");
        mulmap.add("alarmEmail", "");
        mulmap.add("scheduleType", "CRON");
        mulmap.add("glueType", "BEAN");
        mulmap.add("executorRouteStrategy", "CONSISTENT_HASH");
        mulmap.add("misfireStrategy", "DO_NOTHING");
        mulmap.add("executorBlockStrategy", "SERIAL_EXECUTION");
        mulmap.add("executorTimeout", "0");
        mulmap.add("executorFailRetryCount", "0");
        mulmap.add("glueRemark", "GLUE代码初始化");
        mulmap.add("triggerStatus", "1");
        return mulmap;
    }


    public static ResponseEntity<String> addExamXxlJob(String title, String group, Date startTime, String examId, String handle) {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> xxlJobArg = getBaseXxlJobArg();
        xxlJobArg.add("jobGroup", group);
        xxlJobArg.add("jobDesc", title);
        xxlJobArg.add("scheduleConf", CommonUtil.getCron(startTime));
        xxlJobArg.add("cronGen_display", CommonUtil.getCron(startTime));
        xxlJobArg.add("schedule_conf_CRON", CommonUtil.getCron(startTime));
        xxlJobArg.add("executorHandler", handle);
        xxlJobArg.add("executorParam", examId);
        HttpHeaders headers = new HttpHeaders();
        headers.put("Auth-Token", Collections.singletonList("token"));
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(xxlJobArg, headers);
        ResponseEntity<String> response = null;
        try {
            response = restTemplate.exchange(Constant.ADD_JOB_URL, HttpMethod.POST, request, String.class);
        } catch (Exception ex) {
            throw new BusinessException("创建开始考试任务失败");
        }
        return response;
    }


    public static ResponseEntity<String> updateXxlJob(Integer jobId, String group, String jobDesc, String examId, Date time, String handle) {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> xxlJobArg = getBaseXxlJobArg();
        xxlJobArg.add("id", jobId + "");
        xxlJobArg.add("jobGroup", group);
        xxlJobArg.add("jobDesc", jobDesc);
        xxlJobArg.add("executorParam", examId);
        xxlJobArg.add("scheduleConf", CommonUtil.getCron(time));
        xxlJobArg.add("cronGen_display", CommonUtil.getCron(time));
        xxlJobArg.add("schedule_conf_CRON", CommonUtil.getCron(time));
        xxlJobArg.add("executorHandler", handle);
        HttpHeaders headers = new HttpHeaders();
        headers.put("Auth-Token", Collections.singletonList("token"));
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(xxlJobArg, headers);
        ResponseEntity<String> response = null;
        try {
            response = restTemplate.exchange(Constant.UPDATE_JOB_URL, HttpMethod.POST, request, String.class);
        } catch (Exception ex) {
            throw new BusinessException("更新XXL-JOB任务失败");
        }
        return response;
    }

    public static ResponseEntity<String> deleteXxlJob(Integer jobId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, String> xxlJobArg = new LinkedMultiValueMap<>();
        xxlJobArg.set("id", jobId + "");
        headers.put("Auth-Token", Collections.singletonList("token"));
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(xxlJobArg, headers);
        ResponseEntity<String> response = null;
        try {
            response = restTemplate.exchange(Constant.DELETE_JOB_URL, HttpMethod.POST, request, String.class);
        } catch (Exception ex) {
            throw new BusinessException("删除XXL-JOB任务失败");
        }
        return response;
    }


}
