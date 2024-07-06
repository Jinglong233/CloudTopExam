package com.jl.project.utils;

import cn.hutool.core.io.FileUtil;
import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.DeleteObjectsRequest;
import com.aliyun.oss.model.DeleteObjectsResult;
import com.aliyun.oss.model.ObjectMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 阿里云OSS对象存储文件上传工具类
 *
 * @Author jingLong
 * @Date 2024-05-17 17:26
 **/
public class OSSUploadUtil {

    private static final Logger logger = LoggerFactory.getLogger(OSSUploadUtil.class);
    /**
     * 上传图片
     *
     * @param ossClient
     * @param env
     * @param file
     * @param fileName
     * @return
     * @throws IOException
     */
    public static String uploadImage(OSSClient ossClient, Environment env, MultipartFile file, String fileName) throws IOException {
        //1、创建oss客户端连接
        //2、获取文件输入流
        InputStream inputStream = file.getInputStream();
        //3、获取原始文件名
        String originFileName = file.getOriginalFilename();

        // 4. 获取后缀名
        String extName = FileUtil.extName(originFileName);


        // 使用统一的后缀
        // 5. 拼接文件名
        String realFileName = fileName + "." + "jpg";


        // 6. 拼接dir根目录
        String dirFileName = env.getProperty("aliyun.oss.dir.prefix") + realFileName;

        // 创建上传对象的元数据（MetaData）
        com.aliyun.oss.model.ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(inputStream.available());
        objectMetadata.setCacheControl("no-cache");
        objectMetadata.setHeader("Pragma", "no-cache");
        objectMetadata.setContentType(getContentType(realFileName
                .substring(realFileName.lastIndexOf("."))));


        // 7. 创建oss请求，传入三个参数
        try {
            ossClient.putObject(env.getProperty("aliyun.oss.bucketName"), dirFileName, inputStream, objectMetadata);
        } catch (OSSException e) {
            throw new RuntimeException("上传失败");
        } catch (ClientException e) {
            throw new RuntimeException("上传失败");
        }

        // 8. 拼接url
        return "https://" + env.getProperty("aliyun.oss.bucketName") + "." + env.getProperty("aliyun.oss.endpoint") + "/" + dirFileName;

    }

    /**
     * 删除图片
     *
     * @param ossClient
     * @param env
     * @param url
     * @return
     * @throws IOException
     */
    public static void deleteImage(OSSClient ossClient, Environment env, String url) {
        // 截取文件名
        url = url.replace("https://avatar-store.oss-cn-beijing.aliyuncs.com/", "");
        ossClient.deleteObject(env.getProperty("aliyun.oss.bucketName"), url);
    }


    /**
     * 批量删除图片
     *
     * @param ossClient
     * @param env
     * @param urlList
     */
    public static void deleteBatchImage(OSSClient ossClient, Environment env, List<String> urlList) {
        // 填写需要删除的多个文件完整路径。文件完整路径中不能包含Bucket名称。
        List<String> keys = new ArrayList<String>();
        if (urlList != null && urlList.size() != 0) {
            for (String url : urlList) {
                // 截取文件名
                url = url.replace("https://avatar-store.oss-cn-beijing.aliyuncs.com/", "");
                keys.add(url);
            }
            DeleteObjectsResult deleteObjectsResult = ossClient.deleteObjects(
                    new DeleteObjectsRequest(
                            env.getProperty("aliyun.oss.bucketName")
                    ).withKeys(keys).withEncodingType("url"));
            List<String> deletedObjects = deleteObjectsResult.getDeletedObjects();
            try {
                for (String obj : deletedObjects) {
                    String deleteObj = URLDecoder.decode(obj, "UTF-8");
                    logger.info("批量删除OSS图片:{}",deleteObj);
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * 获取上传文件类型
     *
     * @param FilenameExtension
     * @return
     */
    private static String getContentType(String FilenameExtension) {
        if (FilenameExtension.equalsIgnoreCase(".bmp")) {
            return "image/bmp";
        }
        if (FilenameExtension.equalsIgnoreCase(".gif")) {
            return "image/gif";
        }
        if (FilenameExtension.equalsIgnoreCase(".jpeg") ||
                FilenameExtension.equalsIgnoreCase(".jpg") ||
                FilenameExtension.equalsIgnoreCase(".png")) {
            return "image/jpg";
        }
        if (FilenameExtension.equalsIgnoreCase(".html")) {
            return "text/html";
        }
        if (FilenameExtension.equalsIgnoreCase(".txt")) {
            return "text/plain";
        }
        if (FilenameExtension.equalsIgnoreCase(".vsd")) {
            return "application/vnd.visio";
        }
        if (FilenameExtension.equalsIgnoreCase(".pptx") ||
                FilenameExtension.equalsIgnoreCase(".ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (FilenameExtension.equalsIgnoreCase(".docx") ||
                FilenameExtension.equalsIgnoreCase(".doc")) {
            return "application/msword";
        }
        if (FilenameExtension.equalsIgnoreCase(".xml")) {
            return "text/xml";
        }
        return "image/jpg";
    }
}
