package com.jl.project.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.util.SaResult;
import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.po.Train;
import com.jl.project.entity.query.TrainQuery;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.service.TrainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:训练表Controller
 * @author:jingLong
 * @date:2023/11/22
 */
@RestController
@RequestMapping("/train")
@SaCheckLogin
@SaCheckRole("admin")
@Api(tags = "训练")
public class TrainController {

    @Resource
    private TrainService trainService;

    /**
     * 根据条件分页查询
     */
    @ApiOperation("根据条件分页查询")
    @RequestMapping("loadDataList")
    @GlobalInterceptor(checkParams = true)
    public SaResult loadDatalist(TrainQuery query) {
        PaginationResultVO<Train> result = trainService.findListByPage(query);
        return SaResult.ok().setData(result);
    }

    /**
     * 新增
     */
    @ApiOperation("新增")
    @RequestMapping("add")
    @GlobalInterceptor(checkParams = true)
    public SaResult add(Train bean) {
        Integer result = this.trainService.add(bean);
        return SaResult.ok(result > 0 ? "添加成功" : "添加失败").setData(result);
    }

    /**
     * 批量新增
     */
    @ApiOperation("批量新增")
    @RequestMapping("addBatch")
    @GlobalInterceptor(checkParams = true)
    public SaResult addBatch(@RequestBody List<Train> listBean) {
        Integer result = this.trainService.addBatch(listBean);
        return SaResult.ok(result > 0 ? "批量添加成功" : "批量添加失败").setData(result);
    }

    /**
     * 批量新增或修改
     */
    @ApiOperation("批量新增或修改")
    @RequestMapping("addOrUpdateBatch")
    @GlobalInterceptor(checkParams = true)
    public SaResult addOrUpdateBatch(@RequestBody List<Train> listBean) {
        Integer result = this.trainService.addOrUpdateBatch(listBean);
        return SaResult.ok(result > 0 ? "批量添加/更新成功" : "批量添加/更新失败").setData(result);
    }

    /**
     * 根据Id查询
     */
    @ApiOperation("根据Id查询")
    @RequestMapping("getTrainById")
    @GlobalInterceptor(checkParams = true)
    public SaResult getTrainById(String id) {
        Train result = this.trainService.getTrainById(id);
        return SaResult.ok().setData(result);
    }

    /**
     * 根据Id更新
     */
    @ApiOperation("根据Id更新")
    @RequestMapping("updateTrainById")
    @GlobalInterceptor(checkParams = true)
    public SaResult updateTrainById(Train bean, String id) {
        Integer result = this.trainService.updateTrainById(bean, id);
        return SaResult.ok(result > 0 ? "更新成功" : "更新失败");
    }

    /**
     * 根据Id删除
     */
    @ApiOperation("根据Id删除")
    @RequestMapping("deleteTrainById")
    @GlobalInterceptor(checkParams = true)
    public SaResult deleteTrainById(@RequestBody @VerifyParam(require = true) String id) {
        Integer result = this.trainService.deleteTrainById(id);
        return SaResult.ok(result > 0 ? "删除成功" : "删除失败");
    }

}