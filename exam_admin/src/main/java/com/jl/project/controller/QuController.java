package com.jl.project.controller;

import com.jl.project.entity.dto.AddQuAndAnswerDTO;
import com.jl.project.entity.dto.RandomSelectQuDTO;
import com.jl.project.entity.dto.UpdateQuAndAnswerDTO;
import com.jl.project.entity.po.Qu;
import com.jl.project.entity.query.QuExcludeQuery;
import com.jl.project.entity.query.QuQuery;
import com.jl.project.entity.vo.QuAndAnswerVo;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.exception.BusinessException;
import com.jl.project.service.QuService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description:题目表Controller
 * @author:jingLong
 * @date:2023/11/22
 */
@RestController
@RequestMapping("/qu")
public class QuController extends ABaseController {

    @Resource
    private QuService quService;

    /**
     * 根据条件分页查询
     */
    @RequestMapping("loadDataList")
    public ResponseVO loadDatalist(@RequestBody QuQuery query) {
        return getSuccessResponseVO(quService.findListByPage(query));
    }

    /**
     * 获取详细题目列表
     */
    @RequestMapping("loadDetailDataList")
    public ResponseVO loadDetailDataList(@RequestBody QuQuery query) throws BusinessException {
        List<QuAndAnswerVo> result = quService.loadDetailDataList(query);
        return getSuccessResponseVO(result);
    }


    /**
     * 获取详细题目列表(排除之后的)
     *
     * @param query
     * @return
     * @throws BusinessException
     */
    @RequestMapping("loadExcludeDataList")
    public ResponseVO loadExcludeDataList(@RequestBody QuExcludeQuery query) throws BusinessException {
        List<QuAndAnswerVo> result = quService.loadExcludeDataList(query);
        return getSuccessResponseVO(result);
    }

    /**
     * 新增题目和选项
     */
    @RequestMapping("add")
    public ResponseVO add(@RequestBody AddQuAndAnswerDTO bean) throws BusinessException {
        Boolean result = quService.add(bean);
        return getSuccessResponseVO(result);
    }

    /**
     * 根据题目Id更新题目和关联选项
     */
    @RequestMapping("updateQuById")
    public ResponseVO updateQuById(@RequestBody UpdateQuAndAnswerDTO bean) throws BusinessException {
        Boolean result = quService.updateQuById(bean);
        return getSuccessResponseVO(result);
    }

    /**
     * 随机抽题题目
     */
    @RequestMapping("randomSelectQu")
    public ResponseVO randomSelectQu(@RequestBody RandomSelectQuDTO selectQuDTO) throws BusinessException {
        List<QuAndAnswerVo> result = quService.randomSelectQu(selectQuDTO);
        return getSuccessResponseVO(result);
    }


    /**
     * 根据Id查询
     */
    @RequestMapping("getQuById")
    public ResponseVO getQuById(@RequestBody String id) throws BusinessException {
        QuAndAnswerVo result = quService.getQuById(id);
        return getSuccessResponseVO(result);
    }


    /**
     * 根据Id删除
     */
    @RequestMapping("deleteQuById")
    public ResponseVO deleteQuById(@RequestBody String id) throws BusinessException {
        Boolean result = quService.deleteQuById(id);
        return getSuccessResponseVO(result);
    }


    /**
     * 批量新增
     */
    @RequestMapping("addBatch")
    public ResponseVO addBatch(@RequestBody List<Qu> listBean) {
        return getSuccessResponseVO(this.quService.addBatch(listBean));
    }


    /**
     * 批量新增或修改
     */
    @RequestMapping("addOrUpdateBatch")
    public ResponseVO addOrUpdateBatch(@RequestBody List<Qu> listBean) {
        return getSuccessResponseVO(this.quService.addOrUpdateBatch(listBean));
    }

    /**
     * 获取题目数量
     */
    @RequestMapping("quCount")
    public ResponseVO getQuCount(@RequestBody QuQuery query) throws BusinessException {
        Integer result = quService.getQuCount(query);
        return getSuccessResponseVO(result);
    }


    /**
     * 导出
     */
    @RequestMapping("export")
    public void getQuCount(HttpServletResponse response) throws BusinessException, IOException {
        quService.export(response);
    }

    /**
     * 导入题库
     */
    @RequestMapping("importQu")
    public ResponseVO importQuestions(@RequestPart("file") MultipartFile file,@RequestPart("repoId") String repoId) throws BusinessException, IOException {
        Boolean result = null;
        try {
            result = quService.importQuestions(file,repoId);
        } catch (BusinessException e) {
            return getErrorResponseVO(null, e.getCode(), e.getMessage());
        }
        return getSuccessResponseVO(result);
    }


}