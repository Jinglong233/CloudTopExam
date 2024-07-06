package com.jl.project.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.util.SaResult;
import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.dto.AddRepoDTO;
import com.jl.project.entity.dto.UpdateRepoDTO;
import com.jl.project.entity.po.Repo;
import com.jl.project.entity.query.RepoQuery;
import com.jl.project.entity.vo.ClassfiyByQuTypeVO;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.exception.BusinessException;
import com.jl.project.service.RepoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Description:题库Controller
 * @author:jingLong
 * @date:2023/11/22
 */
@Api(tags = "题库操作")
@RestController
@RequestMapping("/repo")
@SaCheckLogin
@SaCheckRole("admin")
public class RepoController {

    @Resource
    private RepoService repoService;

    /**
     * 添加题库
     */
    @ApiOperation("添加题库")
    @RequestMapping("add")
    @GlobalInterceptor(checkParams = true)
    public SaResult add(@RequestBody @VerifyParam AddRepoDTO repoDTO) throws BusinessException {
        Boolean result = repoService.add(repoDTO);
        return SaResult.ok(result ? "添加成功" : "添加失败").setData(result);
    }

    /**
     * 根据Id删除题库
     */
    @ApiOperation("根据Id删除题库")
    @RequestMapping("deleteRepoById")
    @GlobalInterceptor(checkParams = true)
    public SaResult deleteRepoById(@RequestBody @VerifyParam(require = true) String id) throws BusinessException {
        Boolean result = repoService.deleteRepoById(id);
        return SaResult.ok(result ? "删除成功" : "删除失败");
    }

    /**
     * 根据Id更新题库
     */
    @ApiOperation("根据Id更新题库")
    @RequestMapping("updateRepoById")
    @GlobalInterceptor(checkParams = true)
    public SaResult updateRepoById(@RequestBody @VerifyParam UpdateRepoDTO repoDTO) throws BusinessException {
        Boolean result = repoService.updateRepoById(repoDTO);
        return SaResult.ok(result ? "更新成功" : "更新失败");
    }

    /**
     * 根据id获取题库中对应题型的难度分类
     *
     * @return
     */
    @ApiOperation("根据id获取题库中对应题型的难度分类")
    @RequestMapping("classifyByQuType")
    public SaResult classifyByQuType(@RequestBody @VerifyParam Map<String, Object> request) throws BusinessException {
        String repoId = (String) request.get("repoId");
        Integer quType = (Integer) request.get("quType");
        ClassfiyByQuTypeVO result = repoService.classifyByQuType(repoId, quType);
        return SaResult.ok().setData(result);
    }

    /**
     * 根据Id查询题库信息
     */
    @ApiOperation("根据Id查询题库信息")
    @RequestMapping("getRepoById")
    public SaResult getRepoById(@RequestBody @VerifyParam(require = true) String id) {
        Repo result = repoService.getRepoById(id);
        return SaResult.ok().setData(result);
    }


    /**
     * 根据条件查询
     */
    @ApiOperation("根据条件查询")
    @RequestMapping("loadRepoList")
    public SaResult loadRepoList(@RequestBody RepoQuery query) throws BusinessException {
        PaginationResultVO<Repo> result = repoService.loadRepoList(query);
        return SaResult.ok().setData(result);
    }

    /**
     * 批量新增
     */
    @ApiOperation("批量新增")
    @RequestMapping("addBatch")
    public SaResult addBatch(@RequestBody List<Repo> listBean) {
        Integer result = this.repoService.addBatch(listBean);
        return SaResult.ok(result > 0 ? "批量添加成功" : "批量添加失败").setData(result);
    }

    /**
     * 批量新增或修改
     */
    @ApiOperation("批量新增或修改")
    @RequestMapping("addOrUpdateBatch")
    public SaResult addOrUpdateBatch(@RequestBody List<Repo> listBean) {
        Integer result = this.repoService.addOrUpdateBatch(listBean);
        return SaResult.ok(result > 0 ? "批量添加/更新成功" : "批量添加/更新失败").setData(result);

    }


}