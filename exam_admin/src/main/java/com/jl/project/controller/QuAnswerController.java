package com.jl.project.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.util.SaResult;
import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.po.QuAnswer;
import com.jl.project.entity.query.QuAnswerQuery;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.service.QuAnswerService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:题目答案表Controller
 * @author:jingLong
 * @date:2023/11/22
 */
@RestController
@RequestMapping("/quAnswer")
@SaCheckLogin
@SaCheckRole("admin")
public class QuAnswerController {

    @Resource
    private QuAnswerService quAnswerService;

    /**
     * 根据条件分页查询
     */
    @RequestMapping("loadDataList")
    @GlobalInterceptor(checkParams = true)
public SaResult loadDatalist(@RequestBody QuAnswerQuery query) {
        PaginationResultVO<QuAnswer> result = quAnswerService.findListByPage(query);
        return SaResult.ok().setData(result);
    }

    /**
     * 新增
     */
    @RequestMapping("add")
    @GlobalInterceptor(checkParams = true)
public SaResult add(@RequestBody QuAnswer bean) {
        Integer result = this.quAnswerService.add(bean);
        return SaResult.ok(result > 0 ? "添加成功" : "添加失败").setData(result);
    }

    /**
     * 批量新增
     */
    @RequestMapping("addBatch")
    @GlobalInterceptor(checkParams = true)
public SaResult addBatch(@RequestBody List<QuAnswer> listBean) {
        Integer result = this.quAnswerService.addBatch(listBean);
        return SaResult.ok(result > 0 ? "批量添加成功" : "批量添加失败").setData(result);

    }

    /**
     * 批量新增或修改
     */
    @RequestMapping("addOrUpdateBatch")
    @GlobalInterceptor(checkParams = true)
public SaResult addOrUpdateBatch(@RequestBody List<QuAnswer> listBean) {
        Integer result = this.quAnswerService.addOrUpdateBatch(listBean);
        return SaResult.ok(result > 0 ? "批量添加/更新成功" : "批量添加/更新失败").setData(result);
    }

    /**
     * 根据Id查询
     */

    @RequestMapping("getQuAnswerById")
    @GlobalInterceptor(checkParams = true)
public SaResult getQuAnswerById(String id) {
        QuAnswer result = this.quAnswerService.getQuAnswerById(id);
        return SaResult.ok().setData(result);
    }

    /**
     * 根据Id更新
     */
    @RequestMapping("updateQuAnswerById")
    @GlobalInterceptor(checkParams = true)
public SaResult updateQuAnswerById(QuAnswer bean, String id) {
        Integer result = this.quAnswerService.updateQuAnswerById(bean, id);
        return SaResult.ok(result > 0 ? "更新成功" : "更新失败");
    }

    /**
     * 根据Id删除
     */
    @RequestMapping("deleteQuAnswerById")
    @GlobalInterceptor(checkParams = true)
public SaResult deleteQuAnswerById(@RequestBody @VerifyParam(require = true) String id) {
        Integer result = this.quAnswerService.deleteQuAnswerById(id);
        return SaResult.ok(result > 0 ? "删除成功" : "删除失败");

    }

}