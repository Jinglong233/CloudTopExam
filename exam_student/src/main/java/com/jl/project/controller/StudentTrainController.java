package com.jl.project.controller;

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
import com.jl.project.entity.vo.ResponseVO;
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
public class StudentTrainController extends ABaseController {
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
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO getTrain(@RequestBody @VerifyParam TrainQuery trainQuery) throws BusinessException {
        PaginationResultVO<Train> result = null;
        try {
            result = studentTrainService.getTrain(trainQuery);
        } catch (BusinessException e) {
            return getErrorResponseVO(null, e.getCode(), e.getMessage());
        }
        return getSuccessResponseVO(result);
    }


    /**
     * 通过Id获取训练记录
     *
     * @param trainId
     * @return
     */
    @ApiOperation(value = "通过Id获取训练记录")
    @RequestMapping("getTrainById")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO getTrainById(@RequestBody @VerifyParam(require = true) String trainId) throws BusinessException {
        Train result = studentTrainService.getTrainById(trainId);
        return getSuccessResponseVO(result);
    }


    /**
     * 获取训练题库
     *
     * @param repoQuery
     * @return
     */
    @ApiOperation(value = "获取训练题库")
    @RequestMapping("repoList")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO getRepoList(@RequestBody @VerifyParam RepoQuery repoQuery) throws BusinessException {
        List<Repo> result = studentTrainService.getRepoList(repoQuery);
        return getSuccessResponseVO(result);
    }

    /**
     * 根据题库Id获取各种题型数量
     *
     * @param repoId
     * @return
     */
    @ApiOperation(value = "根据题库Id获取各种题型数量")
    @RequestMapping("getQuTypeClassifyByRepoId")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO getQuTypeClassifyByRepoId(@RequestBody @VerifyParam(require = true) String repoId) throws BusinessException {
        Map<Integer, Long> result = studentTrainService.getQuTypeClassifyByRepoId(repoId);
        return getSuccessResponseVO(result);
    }


    /**
     * 开始训练
     *
     * @param startTrainDTO
     * @return
     */
    @ApiOperation(value = "开始训练")
    @RequestMapping("startTrain")
    @GlobalInterceptor(checkLogin = true, checkStudent = true, checkParams = true)
    public ResponseVO startTrain(@RequestBody @VerifyParam StartTrainDTO startTrainDTO) throws BusinessException {
        String result = studentTrainService.startTrain(startTrainDTO);
        return getSuccessResponseVO(result);
    }

    /**
     * 根据Id获取训练记录
     *
     * @param trainId
     * @return 返回的是一个题目总数
     */
    @ApiOperation(value = "根据Id获取训练记录")
    @RequestMapping("getTrainRecordById")
    @GlobalInterceptor(checkLogin = true, checkStudent = true, checkParams = true)
    public ResponseVO getTrainRecordById(@RequestBody @VerifyParam(require = true) String trainId) throws BusinessException {
        Integer result  = studentTrainService.getTrainRecordById(trainId);
        return getSuccessResponseVO(result);
    }

    /**
     * 根据sort+获取训练记录Id 获取题目信息
     *
     * @param trainRecordQuQuery
     * @return
     */
    @ApiOperation(value = "根据sort+获取训练记录Id 获取题目信息")
    @RequestMapping("getTrainRecordQu")
    @GlobalInterceptor(checkLogin = true, checkStudent = true, checkParams = true)
    public ResponseVO getTrainRecordQu(@RequestBody @VerifyParam TrainRecordQuQuery trainRecordQuQuery) throws BusinessException {
        TrainRecordQuVO result  = studentTrainService.getTrainRecordQu(trainRecordQuQuery);
        return getSuccessResponseVO(result);
    }


    /**
     * 更新作答记录
     *
     * @param trainRecord
     * @return
     */
    @ApiOperation(value = "更新作答记录")
    @RequestMapping("updateTrainRecord")
    @GlobalInterceptor(checkLogin = true, checkStudent = true, checkParams = true)
    public ResponseVO updateTrainRecord(@RequestBody @VerifyParam TrainRecord trainRecord) throws BusinessException {
        Boolean result = studentTrainService.updateTrainRecord(trainRecord);
        return getSuccessResponseVO(result);
    }


    /**
     * 结束训练
     *
     * @param trainId
     * @return
     */
    @ApiOperation(value = "结束训练")
    @RequestMapping("stopTrain")
    @GlobalInterceptor(checkLogin = true, checkStudent = true, checkParams = true)
    public ResponseVO stopTrain(@RequestBody @VerifyParam(require = true) String trainId) throws BusinessException {
        Boolean result  = studentTrainService.stopTrain(trainId);
        return getSuccessResponseVO(result);
    }

}