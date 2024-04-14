package com.jl.project.controller;

import com.jl.project.entity.dto.AddPaperDTO;
import com.jl.project.entity.dto.UpdatePaperAndQuDTO;
import com.jl.project.entity.po.Paper;
import com.jl.project.entity.query.PaperQuery;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.vo.PaperAndQuVO;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.exception.BusinessException;
import com.jl.project.service.PaperService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:试卷表Controller
 * @author:jingLong
 * @date:2023/11/22
 */
@RestController
@RequestMapping("/paper")
public class PaperController extends ABaseController {

    @Resource
    private PaperService paperService;

    /**
     * 根据Id查询试卷详细信息
     */
    @RequestMapping("getPaperDetailById")
    public ResponseVO getPaperDetailById(@RequestBody String id) {
        PaperAndQuVO result = paperService.getPaperDetailById(id);
        return getSuccessResponseVO(result);
    }


    /**
     * 根据Id更新
     */
    @RequestMapping("updatePaperById")
    public ResponseVO updatePaperById(@RequestBody UpdatePaperAndQuDTO bean) throws BusinessException {
        Boolean result = paperService.updatePaperById(bean);
        return getSuccessResponseVO(result);
    }

    /**
     * 根据Id删除
     */
    @RequestMapping("deletePaperById")
    public ResponseVO deletePaperById(@RequestBody String id) {
        Boolean result = paperService.deletePaperById(id);
        return getSuccessResponseVO(result);
    }


    /**
     * 新增
     */
    @RequestMapping("add")
    public ResponseVO add(@RequestBody AddPaperDTO paperDTO) throws BusinessException {
        Boolean result = paperService.add(paperDTO);
        return getSuccessResponseVO(result);
    }


    /**
     * 根据条件分页查询
     */
    @RequestMapping("loadDataList")
    public ResponseVO loadDatalist(@RequestBody PaperQuery query) throws BusinessException {
        PaginationResultVO<Paper> result = paperService.loadDatalist(query);
        return getSuccessResponseVO(result);
    }


    /**
     * 批量新增
     */
    @RequestMapping("addBatch")
    public ResponseVO addBatch(@RequestBody List<Paper> listBean) {
        return getSuccessResponseVO(this.paperService.addBatch(listBean));
    }

    /**
     * 批量新增或修改
     */
    @RequestMapping("addOrUpdateBatch")
    public ResponseVO addOrUpdateBatch(@RequestBody List<Paper> listBean) {
        return getSuccessResponseVO(this.paperService.addOrUpdateBatch(listBean));
    }

    /**
     * 根据Id查询
     */

    @RequestMapping("getPaperById")
    public ResponseVO getPaperById(String id) {
        return getSuccessResponseVO(this.paperService.getPaperById(id));
    }

    /**
     * 获取试卷总数
     */

    @RequestMapping("paperCount")
    public ResponseVO getPaperCount(@RequestBody PaperQuery paperQuery) throws BusinessException {
        Integer result = paperService.getPaperCount(paperQuery);
        return getSuccessResponseVO(result);
    }


}