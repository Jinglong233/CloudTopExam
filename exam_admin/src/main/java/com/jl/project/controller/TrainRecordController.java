package com.jl.project.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.util.SaResult;
import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.po.TrainRecord;
import com.jl.project.entity.query.TrainRecordQuery;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.service.TrainRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:训练详情记录表Controller
 * @author:jingLong
 * @date:2023/11/22
 */
@Api(tags = "训练记录")
@RestController
@RequestMapping("/trainRecord")
@SaCheckLogin
@SaCheckRole("admin")
public class TrainRecordController {

    @Resource
    private TrainRecordService trainRecordService;

    /**
     * 根据条件分页查询
     */
    @ApiOperation("根据条件分页查询")
    @RequestMapping("loadDataList")
    @GlobalInterceptor(checkParams = true)
    public SaResult loadDatalist(@RequestBody @VerifyParam TrainRecordQuery query) {
        PaginationResultVO<TrainRecord> result = trainRecordService.findListByPage(query);
        return SaResult.ok().setData(result);
    }

    /**
     * 新增
     */
    @ApiOperation("新增")
    @RequestMapping("add")
    @GlobalInterceptor(checkParams = true)
    public SaResult add(@VerifyParam TrainRecord bean) {
        Integer result = this.trainRecordService.add(bean);
        return SaResult.ok(result > 0 ? "添加成功" : "添加失败").setData(result);

    }

    /**
     * 批量新增
     */
    @ApiOperation("批量新增")
    @RequestMapping("addBatch")
    @GlobalInterceptor(checkParams = true)
    public SaResult addBatch(@RequestBody List<TrainRecord> listBean) {
        Integer result = this.trainRecordService.addBatch(listBean);
        return SaResult.ok(result > 0 ? "批量添加成功" : "批量添加失败").setData(result);
    }

    /**
     * 批量新增或修改
     */
    @ApiOperation("批量新增或修改")
    @RequestMapping("addOrUpdateBatch")
    @GlobalInterceptor(checkParams = true)
    public SaResult addOrUpdateBatch(@RequestBody List<TrainRecord> listBean) {
        Integer result = this.trainRecordService.addOrUpdateBatch(listBean);
        return SaResult.ok(result > 0 ? "批量添加/更新成功" : "批量添加/更新失败").setData(result);

    }

    /**
     * 根据Id查询
     */
    @ApiOperation("根据Id查询")
    @RequestMapping("getTrainRecordById")
    @GlobalInterceptor(checkParams = true)
    public SaResult getTrainRecordById(String id) {
        TrainRecord result = this.trainRecordService.getTrainRecordById(id);
        return SaResult.ok().setData(result);
    }

    /**
     * 根据Id更新
     */
    @ApiOperation("根据Id更新")
    @RequestMapping("updateTrainRecordById")
    @GlobalInterceptor(checkParams = true)
    public SaResult updateTrainRecordById(TrainRecord bean, String id) {
        Integer result = this.trainRecordService.updateTrainRecordById(bean, id);
        return SaResult.ok(result > 0 ? "更新成功" : "更新失败");

    }

    /**
     * 根据Id删除
     */
    @ApiOperation("根据Id删除")
    @RequestMapping("deleteTrainRecordById")
    @GlobalInterceptor(checkParams = true)
    public SaResult deleteTrainRecordById(String id) {
        Integer result = this.trainRecordService.deleteTrainRecordById(id);
        return SaResult.ok(result > 0 ? "删除成功" : "删除失败");
    }

}