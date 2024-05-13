package com.jl.project.utils;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.net.Ipv4Util;
import cn.hutool.core.util.StrUtil;
import com.jl.project.exception.BusinessException;
import org.lionsoul.ip2region.xdb.Searcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import java.io.IOException;

/**
 * @Author huawei
 * @Date 2024-05-13 11:43
 **/
public class AddressUtil {
    private static final Logger log = LoggerFactory.getLogger(AddressUtil.class);
    protected static Searcher searcher;

    static {
        try {
            searcher = Searcher.newWithBuffer(new ClassPathResource("ip2region/ip2region.xdb").readBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getRealAddressByIp(String ip) {
        if("0:0:0:0:0:0:0:1".equals(ip)){
            return "本地IP";
        }

        StopWatch stopWatch = new StopWatch("解fip");
        stopWatch.start();
        if (Ipv4Util.isInnerIP(ip)) {
            return "内网IP:" + ip;
        }
        String[] obj;
        try {
            String result = searcher.search(ip);
            if (StrUtil.isBlank(result)) {
                log.error("获取地理位置失败:{}", ip);
                return "XX-XX-XX";
            }
            obj = result.split("\\|");
        } catch (Exception e) {
            log.error("获取地理位置异常", e);
            throw new BusinessException("获取地理位置失败");
        } finally {
            IoUtil.closeIfPosible(searcher);
        }
        stopWatch.stop();
        log.info("{}耗时:{}ms", stopWatch.getId(), stopWatch.getTotalTimeMillis());
        return String.format("%s-%s-%s", obj[0], obj[2], obj[3]);
    }
}

