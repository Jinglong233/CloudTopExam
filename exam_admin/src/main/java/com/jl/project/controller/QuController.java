package com.jl.project.controller;


import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.OperationLog;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.dto.AddQuAndAnswerDTO;
import com.jl.project.entity.dto.RandomSelectQuDTO;
import com.jl.project.entity.dto.UpdateQuAndAnswerDTO;
import com.jl.project.entity.po.Qu;
import com.jl.project.entity.query.QuExcludeQuery;
import com.jl.project.entity.query.QuQuery;
import com.jl.project.entity.vo.QuAndAnswerVo;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.enums.LogType;
import com.jl.project.enums.OperationType;
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
    @RequestMapping("loadQuList")
    @GlobalInterceptor(checkLogin = true,checkParams = true)
    public ResponseVO loadQuList(@RequestBody @VerifyParam QuQuery query) {
        return getSuccessResponseVO(quService.findListByPage(query));
    }

    /**
     * 获取题目+选项列表
     */
    @RequestMapping("loadQuAndAnswerList")
    @GlobalInterceptor(checkLogin = true,checkParams = true)
    public ResponseVO loadQuAndAnswerList(@RequestBody QuQuery query) throws BusinessException {
        List<QuAndAnswerVo> result = quService.loadQuAndAnswerList(query);
        return getSuccessResponseVO(result);
    }


    /**
     * 过滤指定题目之后的题目和选项列表
     *
     * @param query
     * @return
     * @throws BusinessException
     */
    @RequestMapping("loadExcludeQuAnAnswerList")
    @GlobalInterceptor(checkLogin = true,checkParams = true)
    public ResponseVO loadExcludeQuAnAnswerList(@RequestBody @VerifyParam QuExcludeQuery query) throws BusinessException {
        List<QuAndAnswerVo> result = quService.loadExcludeQuAnAnswerList(query);
        return getSuccessResponseVO(result);
    }

    /**
     * 新增题目和选项
     */
    @RequestMapping("add")
    @GlobalInterceptor(checkLogin = true,checkParams = true)
    @OperationLog(logType = LogType.OPERATION_LOG,oper = OperationType.ADD)
    public ResponseVO add(@RequestBody @VerifyParam AddQuAndAnswerDTO bean) throws BusinessException {
        Boolean result = quService.add(bean);
        return getSuccessResponseVO(result);
    }

    /**
     * 根据题目Id更新题目和关联选项
     */
    @RequestMapping("updateQuById")
    @GlobalInterceptor(checkLogin = true,checkParams = true)
    public ResponseVO updateQuById(@RequestBody @VerifyParam UpdateQuAndAnswerDTO bean) throws BusinessException {
        Boolean result = quService.updateQuById(bean);
        return getSuccessResponseVO(result);
    }

    /**
     * 随机抽题题目
     */
    @RequestMapping("randomSelectQu")
    @GlobalInterceptor(checkLogin = true,checkParams = true)
    public ResponseVO randomSelectQu(@RequestBody @VerifyParam RandomSelectQuDTO selectQuDTO) throws BusinessException {
        List<QuAndAnswerVo> result = quService.randomSelectQu(selectQuDTO);
        return getSuccessResponseVO(result);
    }


    /**
     * 根据Id查询题目和对应选项的信息
     */
    @RequestMapping("getQuById")
    @GlobalInterceptor(checkLogin = true,checkParams = true)
    public ResponseVO getQuById(@RequestBody @VerifyParam(require = true) String id) throws BusinessException {
        QuAndAnswerVo result = quService.getQuById(id);
        return getSuccessResponseVO(result);
    }


    /**
     * 根据Id删除
     */
    @RequestMapping("deleteQuById")
    @GlobalInterceptor(checkLogin = true,checkParams = true)
    public ResponseVO deleteQuById(@RequestBody @VerifyParam(require = true) String id) throws BusinessException {
        Boolean result = quService.deleteQuById(id);
        return getSuccessResponseVO(result);
    }


    /**
     * 获取题目数量
     */
    @RequestMapping("quCount")
    @GlobalInterceptor(checkLogin = true,checkParams = true)
    public ResponseVO getQuCount(@RequestBody @VerifyParam QuQuery query) throws BusinessException {
        Integer result = quService.getQuCount(query);
        return getSuccessResponseVO(result);
    }

//    以下接口未测试

    /**
     * 导出
     */
    @RequestMapping("export")
    @GlobalInterceptor(checkLogin = true,checkParams = true)
    public void getQuCount(HttpServletResponse response) throws BusinessException, IOException {
        quService.export(response);
    }

    /**
     * 导入题库
     */
    @RequestMapping("importQu")
    @GlobalInterceptor(checkLogin = true,checkParams = true)
    public ResponseVO importQuestions(@RequestPart("file") MultipartFile file, @RequestPart("repoId") String repoId) throws BusinessException, IOException {
        Boolean result = quService.importQuestions(file, repoId);
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


}