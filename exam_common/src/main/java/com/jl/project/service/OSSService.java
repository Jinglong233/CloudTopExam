package com.jl.project.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author huawei
 * @Date 2024-05-17 17:39
 **/
public interface OSSService {
    String uploadImage(MultipartFile file);

    void deleteImage(String url);

    void deleteBatchImage(List<String> urlList);
}
