package com.jl.project.controller;


import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.dto.AddRepoDTO;
import com.jl.project.entity.dto.UpdateRepoDTO;
import com.jl.project.entity.po.Repo;
import com.jl.project.entity.query.RepoQuery;
import com.jl.project.entity.vo.ClassfiyByQuTypeVO;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.exception.BusinessException;
import com.jl.project.service.RepoService;
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
@RestController
@RequestMapping("/repo")
public class RepoController extends ABaseController {

    @Resource
    private RepoService repoService;

    /**
     * 添加题库
     */
    @RequestMapping("add")
    @GlobalInterceptor(checkLogin = true, checkAdmin = true, checkParams = true)
    public ResponseVO add(@RequestBody @VerifyParam AddRepoDTO repoDTO) throws BusinessException {
        Boolean result = repoService.add(repoDTO);
        return getSuccessResponseVO(result);
    }

    /**
     * 根据Id删除题库
     */
    @RequestMapping("deleteRepoById")
    @GlobalInterceptor(checkLogin = true, checkAdmin = true, checkParams = true)
    public ResponseVO deleteRepoById(@RequestBody @VerifyParam(require = true) String id) throws BusinessException {
        Boolean result = repoService.deleteRepoById(id);
        return getSuccessResponseVO(result);
    }

    /**
     * 根据Id更新题库
     */
    @RequestMapping("updateRepoById")
    @GlobalInterceptor(checkLogin = true, checkAdmin = true, checkParams = true)
    public ResponseVO updateRepoById(@RequestBody @VerifyParam UpdateRepoDTO repoDTO) throws BusinessException {
        Boolean result = repoService.updateRepoById(repoDTO);
        return getSuccessResponseVO(result);
    }

    /**
     * 根据id获取题库中对应题型的难度分类
     *
     * @return
     */
    @RequestMapping("classifyByQuType")
    @GlobalInterceptor(checkLogin = true)
    public ResponseVO classifyByQuType(@RequestBody @VerifyParam Map<String, Object> request) throws BusinessException {
        String repoId = (String) request.get("repoId");
        Integer quType = (Integer) request.get("quType");
        ClassfiyByQuTypeVO result = repoService.classifyByQuType(repoId, quType);
        return getSuccessResponseVO(result);
    }

    /**
     * 根据Id查询题库信息
     */
    @RequestMapping("getRepoById")
    public ResponseVO getRepoById(@RequestBody @VerifyParam(require = true) String id) {
        return getSuccessResponseVO(repoService.getRepoById(id));
    }


    /**
     * 根据条件查询
     */
    @RequestMapping("loadRepoList")
    public ResponseVO loadRepoList(@RequestBody RepoQuery query) throws BusinessException {
        PaginationResultVO<Repo> result = repoService.loadRepoList(query);
        return getSuccessResponseVO(result);
    }
//    下面接口未测试

    /**
     * 批量新增
     */
    @RequestMapping("addBatch")
    public ResponseVO addBatch(@RequestBody List<Repo> listBean) {
        return getSuccessResponseVO(this.repoService.addBatch(listBean));
    }

    /**
     * 批量新增或修改
     */
    @RequestMapping("addOrUpdateBatch")
    public ResponseVO addOrUpdateBatch(@RequestBody List<Repo> listBean) {
        return getSuccessResponseVO(this.repoService.addOrUpdateBatch(listBean));
    }


}