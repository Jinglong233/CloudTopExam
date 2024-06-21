package com.jl.project.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.util.SaResult;
import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.dto.StartTrainDTO;
import com.jl.project.entity.po.Repo;
import com.jl.project.entity.po.Train;
import com.jl.project.entity.po.TrainRecord;
import com.jl.project.entity.query.RepoQuery;
import com.jl.project.entity.query.TrainQuery;
import com.jl.project.entity.query.TrainRecordQuQuery;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.vo.TrainRecordQuVO;
import com.jl.project.exception.BusinessException;
import com.jl.project.service.StudentTrainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Description:学生Controller
 * @author:jingLong
 * @date:2023/11/12
 */
@Api(tags = "学生训练相关")
@RestController
@RequestMapping("/studentTrain")
@SaCheckLogin
@SaCheckRole("student")
public class StudentTrainController {
    @Resource
    private StudentTrainService studentTrainService;


    /**
     * 条件查询训练记录
     *
     * @param trainQuery
     * @return
     */
    @ApiOperation(value = "条件查询训练记录")
    @RequestMapping("getTrain")
    @GlobalInterceptor(checkParams = true)
    public SaResult getTrain(@RequestBody @VerifyParam TrainQuery trainQuery) throws BusinessException {
        PaginationResultVO<Train> result = studentTrainService.getTrain(trainQuery);
        return SaResult.ok().setData(result);
    }


    /**
     * 通过Id获取训练记录
     *
     * @param trainId
     * @return
     */
    @ApiOperation(value = "通过Id获取训练记录")
    @RequestMapping("getTrainById")
    @GlobalInterceptor(checkParams = true)
    public SaResult getTrainById(@RequestBody @VerifyParam(require = true) String trainId) throws BusinessException {
        Train result = studentTrainService.getTrainById(trainId);
        return SaResult.ok().setData(result);
    }


    /**
     * 获取训练题库
     *
     * @param repoQuery
     * @return
     */
    @ApiOperation(value = "获取训练题库")
    @RequestMapping("repoList")
    @GlobalInterceptor(checkParams = true)
    public SaResult getRepoList(@RequestBody @VerifyParam RepoQuery repoQuery) throws BusinessException {
        List<Repo> result = studentTrainService.getRepoList(repoQuery);
        return SaResult.ok().setData(result);
    }

    /**
     * 根据题库Id获取各种题型数量
     *
     * @param repoId
     * @return
     */
    @ApiOperation(value = "根据题库Id获取各种题型数量")
    @RequestMapping("getQuTypeClassifyByRepoId")
    @GlobalInterceptor(checkParams = true)
    public SaResult getQuTypeClassifyByRepoId(@RequestBody @VerifyParam(require = true) String repoId) throws BusinessException {
        Map<Integer, Long> result = studentTrainService.getQuTypeClassifyByRepoId(repoId);
        return SaResult.ok().setData(result);
    }


    /**
     * 开始训练
     *
     * @param startTrainDTO
     * @return
     */
    @ApiOperation(value = "开始训练")
    @RequestMapping("startTrain")
    @GlobalInterceptor(checkParams = true)
    public SaResult startTrain(@RequestBody @VerifyParam StartTrainDTO startTrainDTO) throws BusinessException {
        String result = studentTrainService.startTrain(startTrainDTO);
        return SaResult.ok().setData(result);
    }

    /**
     * 根据Id获取训练记录
     *
     * @param trainId
     * @return 返回的是一个题目总数
     */
    @ApiOperation(value = "根据Id获取训练记录")
    @RequestMapping("getTrainRecordById")
    @GlobalInterceptor(checkParams = true)
    public SaResult getTrainRecordById(@RequestBody @VerifyParam(require = true) String trainId) throws BusinessException {
        Integer result = studentTrainService.getTrainRecordById(trainId);
        return SaResult.ok().setData(result);
    }

    /**
     * 根据sort+获取训练记录Id 获取题目信息
     *
     * @param trainRecordQuQuery
     * @return
     */
    @ApiOperation(value = "根据sort+获取训练记录Id 获取题目信息")
    @RequestMapping("getTrainRecordQu")
    @GlobalInterceptor(checkParams = true)
    public SaResult getTrainRecordQu(@RequestBody @VerifyParam TrainRecordQuQuery trainRecordQuQuery) throws BusinessException {
        TrainRecordQuVO result = studentTrainService.getTrainRecordQu(trainRecordQuQuery);
        return SaResult.ok().setData(result);
    }


    /**
     * 更新作答记录
     *
     * @param trainRecord
     * @return
     */
    @ApiOperation(value = "更新作答记录")
    @RequestMapping("updateTrainRecord")
    @GlobalInterceptor(checkParams = true)
    public SaResult updateTrainRecord(@RequestBody @VerifyParam TrainRecord trainRecord) throws BusinessException {
        Boolean result = studentTrainService.updateTrainRecord(trainRecord);
        return SaResult.ok().setData(result);
    }


    /**
     * 结束训练
     *
     * @param trainId
     * @return
     */
    @ApiOperation(value = "结束训练")
    @RequestMapping("stopTrain")
    @GlobalInterceptor(checkParams = true)
    public SaResult stopTrain(@RequestBody @VerifyParam(require = true) String trainId) throws BusinessException {
        Boolean result = studentTrainService.stopTrain(trainId);
        return SaResult.ok().setData(result);
    }

}