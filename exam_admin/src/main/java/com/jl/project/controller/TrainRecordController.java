package com.jl.project.controller;

import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.po.TrainRecord;
import com.jl.project.entity.query.TrainRecordQuery;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.service.TrainRecordService;
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
@RestController
@RequestMapping("/trainRecord")
public class TrainRecordController extends ABaseController{

	@Resource
	private TrainRecordService trainRecordService;

	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("loadDataList")
	@GlobalInterceptor(checkLogin = true,checkParams = true)
	public ResponseVO loadDatalist(@RequestBody @VerifyParam TrainRecordQuery query) {
		return getSuccessResponseVO(trainRecordService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("add")
	@GlobalInterceptor(checkLogin = true,checkParams = true)
	public ResponseVO add(@VerifyParam TrainRecord bean) {
		return getSuccessResponseVO(this.trainRecordService.add(bean));
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("addBatch")
	@GlobalInterceptor(checkLogin = true,checkParams = true)
	public ResponseVO addBatch(@RequestBody List<TrainRecord> listBean) {
		return getSuccessResponseVO(this.trainRecordService.addBatch(listBean));
	}

	/**
	 * 批量新增或修改
	 */
	@RequestMapping("addOrUpdateBatch")
	@GlobalInterceptor(checkLogin = true,checkParams = true)
	public ResponseVO addOrUpdateBatch(@RequestBody List<TrainRecord> listBean) {
		return getSuccessResponseVO(this.trainRecordService.addOrUpdateBatch(listBean));
	}

	/**
	 * 根据Id查询
	 */

	@RequestMapping("getTrainRecordById")
	@GlobalInterceptor(checkLogin = true,checkParams = true)
	public ResponseVO getTrainRecordById(String id) {
		return getSuccessResponseVO(this.trainRecordService.getTrainRecordById(id));
	}

	/**
	 * 根据Id更新
	 */
	@RequestMapping("updateTrainRecordById")
	@GlobalInterceptor(checkLogin = true,checkParams = true)
	public ResponseVO updateTrainRecordById(TrainRecord bean, String id) {
		return getSuccessResponseVO(this.trainRecordService.updateTrainRecordById(bean, id));
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("deleteTrainRecordById")
	@GlobalInterceptor(checkLogin = true,checkParams = true)
	public ResponseVO deleteTrainRecordById(String id) {
		this.trainRecordService.deleteTrainRecordById(id);
		return getSuccessResponseVO(null);
	}

}