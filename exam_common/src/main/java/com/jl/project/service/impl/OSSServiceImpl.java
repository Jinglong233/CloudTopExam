package com.jl.project.service.impl;

import com.aliyun.oss.OSSClient;
import com.jl.project.exception.BusinessException;
import com.jl.project.service.OSSService;
import com.jl.project.utils.CommonUtil;
import com.jl.project.utils.OSSUploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @Author jingLong
 * @Date 2024-05-17 17:39
 **/
@Service("ossService")
@Slf4j
public class OSSServiceImpl implements OSSService {

    @Resource
    private OSSClient ossClient;

    @Resource
    private Environment env;

    @Override
    public String uploadImage(MultipartFile file) {

        // 为了防止同名图片覆盖，这里使用UUID
        try {
            return OSSUploadUtil.uploadImage(ossClient, env, file, CommonUtil.getRandomId());
        } catch (IOException e) {
            throw new BusinessException("上传失败");
        }
    }

    @Override
    public void deleteImage(String url) {
        try {
            OSSUploadUtil.deleteImage(ossClient, env, url);
        } catch (Exception e) {
            log.warn("删除图片失败");
        }
    }

    @Override
    public void deleteBatchImage(List<String> urlList) {
        try {
            OSSUploadUtil.deleteBatchImage(ossClient, env, urlList);
        } catch (Exception e) {
            log.warn("删除图片失败");
        }
    }
}
