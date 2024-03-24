package com.jl.project.controller;

import com.jl.project.entity.dto.AddRepoDTO;
import com.jl.project.entity.dto.UpdateRepoDTO;
import com.jl.project.entity.po.Repo;
import com.jl.project.entity.query.RepoQuery;
import com.jl.project.entity.vo.ClassfiyByQuTypeVO;
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
     * 新增
     */
    @RequestMapping("add")
    public ResponseVO add(@RequestBody AddRepoDTO repoDTO) throws BusinessException {
        Boolean result = repoService.add(repoDTO);
        return getSuccessResponseVO(result);
    }

    /**
     * 根据Id删除
     */
    @RequestMapping("deleteRepoById")
    public ResponseVO deleteRepoById(@RequestBody String id) throws BusinessException {
        Boolean result = repoService.deleteRepoById(id);
        return getSuccessResponseVO(result);
    }

    /**
     * 根据Id更新
     */
    @RequestMapping("updateRepoById")
    public ResponseVO updateRepoById(@RequestBody UpdateRepoDTO repoDTO) throws BusinessException {
        Boolean result = repoService.updateRepoById(repoDTO);
        return getSuccessResponseVO(result);
    }

    /**
     * 根据id获取题库中对应题型的难度分类
     *
     * @return
     */
    @RequestMapping("classifyByQuType")
    public ResponseVO classifyByQuType(@RequestBody Map<String, Object> request) throws BusinessException {
        String repoId = (String) request.get("repoId");
        Integer quType = (Integer) request.get("quType");
        ClassfiyByQuTypeVO result = repoService.classifyByQuType(repoId,quType);
        return getSuccessResponseVO(result);
    }

    /**
     * 根据条件分页查询
     */
    @RequestMapping("loadDataList")
    public ResponseVO loadDatalist(@RequestBody RepoQuery query) throws BusinessException{
        List<Repo> result = repoService.loadDatalist(query);
        return getSuccessResponseVO(result);
    }

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

    /**
     * 根据Id查询
     */
    @RequestMapping("getRepoById")
    public ResponseVO getRepoById(String id) {
        return getSuccessResponseVO(this.repoService.getRepoById(id));
    }


}