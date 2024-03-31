package com.jl.project.controller;

import com.jl.project.entity.dto.UpdateUserDTO;
import com.jl.project.entity.po.Repo;
import com.jl.project.entity.po.User;
import com.jl.project.entity.query.LoginQuery;
import com.jl.project.entity.query.RepoQuery;
import com.jl.project.entity.vo.LoginResponseVo;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.exception.BusinessException;
import com.jl.project.service.StudentService;
import com.jl.project.service.StudentTrainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @Description:学生Controller
 * @author:jingLong
 * @date:2023/11/12
 */
@Api(tags = "学生训练相关")
@RestController
@RequestMapping("/studentTrain")
public class StudentTrainController extends ABaseController {
    @Resource
    private StudentTrainService studentTrainService;


    /**
     * 获取训练题库
     *
     * @param repo
     * @return
     */
    @ApiOperation(value = "获取训练题库")
    @RequestMapping("repoList")
    public ResponseVO getRepoList(@RequestBody RepoQuery repoQuery) throws BusinessException {
        List<Repo> result = null;
        try {
            result = studentTrainService.getRepoList(repoQuery);
        } catch (BusinessException e) {
            return getErrorResponseVO(null,e.getCode(),e.getMessage());
        }
        return getSuccessResponseVO(result);
    }





}