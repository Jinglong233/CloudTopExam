package com.jl.project.controller;

import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.service.OSSService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author huawei
 * @Date 2024-05-17 17:37
 **/
@RestController
@RequestMapping("/oss")
public class OSSController extends ABaseController {
    @Resource
    private OSSService ossService;


    /**
     * 上传图片
     *
     * @param file
     * @return
     */
    @RequestMapping("upload/image")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO uploadImage(@RequestParam("file") @VerifyParam(require = true) MultipartFile file) {
        String result = ossService.uploadImage(file);
        return getSuccessResponseVO(result);
    }

    /**
     * 删除图片
     * @param url
     */
    @RequestMapping("delete/image")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO deleteImage(@RequestBody @VerifyParam(require = true) String url) {
        ossService.deleteImage(url);
        return getSuccessResponseVO(true);
    }

    /**
     * 批量删除图片
     * @param urlList
     */
    @RequestMapping("deleteBatch/image")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO deleteBatchImage(@RequestBody List<String> urlList) {
        ossService.deleteBatchImage(urlList);
        return getSuccessResponseVO(true);
    }


}
