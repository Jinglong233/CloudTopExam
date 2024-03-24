package com.jl.project.utils;

import com.jl.project.constant.Constant;
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


    private static MultiValueMap<String, String> getXxlJobArg(String title, Date startTime, String examId,String handle) {
        MultiValueMap<String, String> mulmap = new LinkedMultiValueMap<>();
        mulmap.add("jobGroup", "2");
        mulmap.add("jobDesc", title);
        mulmap.add("author", "bread");
        mulmap.add("alarmEmail", "");
        mulmap.add("scheduleType", "CRON");
        mulmap.add("scheduleConf", CommonUtil.getCron(startTime));
        mulmap.add("cronGen_display", CommonUtil.getCron(startTime));
        mulmap.add("schedule_conf_CRON", CommonUtil.getCron(startTime));
        mulmap.add("glueType", "BEAN");
        mulmap.add("executorHandler", handle);
        mulmap.add("executorRouteStrategy", "CONSISTENT_HASH");
        mulmap.add("misfireStrategy", "DO_NOTHING");
        mulmap.add("executorBlockStrategy", "SERIAL_EXECUTION");
        mulmap.add("executorTimeout", "0");
        mulmap.add("executorParam", examId);
        mulmap.add("executorFailRetryCount", "0");
        mulmap.add("glueRemark", "GLUE代码初始化");
        mulmap.add("triggerStatus", "1");
        return mulmap;
    }


    public static ResponseEntity<String> addXxlJob(String title, Date startTime, String examId,String handle) {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> xxlJobArg = getXxlJobArg(title, startTime, examId,handle);
        HttpHeaders headers = new HttpHeaders();
        headers.put("Auth-Token", Collections.singletonList("token"));
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(xxlJobArg, headers);
        ResponseEntity<String> response = null;
        try {
            response = restTemplate.exchange(Constant.ADD_JOB_URL, HttpMethod.POST, request, String.class);
        } catch (org.springframework.web.client.ResourceAccessException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }


}
