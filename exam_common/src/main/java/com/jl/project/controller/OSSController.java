package com.jl.project.controller;

import cn.dev33.satoken.util.SaResult;
import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.service.OSSService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author jingLong
 * @Date 2024-05-17 17:37
 **/
@Api(tags = "OSS操作相关")
@RestController
@RequestMapping("/oss")
public class OSSController {
    @Resource
    private OSSService ossService;


    /**
     * 上传图片
     *
     * @param file
     * @return
     */
    @ApiOperation("上传图片")
    @RequestMapping("upload/image")
    @GlobalInterceptor(checkParams = true)
    public SaResult uploadImage(@RequestParam("file") @VerifyParam(require = true) MultipartFile file) {
        String result = ossService.uploadImage(file);
        return SaResult.ok().setData(result);
    }

    /**
     * 删除图片
     * @param url
     */
    @ApiOperation("删除图片")
    @RequestMapping("delete/image")
    @GlobalInterceptor(checkParams = true)
    public SaResult deleteImage(@RequestBody @VerifyParam(require = true) String url) {
        ossService.deleteImage(url);
        return SaResult.ok().setData(true);
    }

    /**
     * 批量删除图片
     * @param urlList
     */
    @ApiOperation("批量删除图片")
    @RequestMapping("deleteBatch/image")
    @GlobalInterceptor(checkParams = true)
    public SaResult deleteBatchImage(@RequestBody List<String> urlList) {
        ossService.deleteBatchImage(urlList);
        return SaResult.ok().setData(true);
    }


}
