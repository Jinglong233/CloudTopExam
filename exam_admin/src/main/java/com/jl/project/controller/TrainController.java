package com.jl.project.controller;

import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.po.Train;
import com.jl.project.entity.query.TrainQuery;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.service.TrainService;
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
public class TrainController extends ABaseController{

	@Resource
	private TrainService trainService;

	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("loadDataList")
	@GlobalInterceptor(checkLogin = true,checkParams = true)
	public ResponseVO loadDatalist(TrainQuery query) {
		return getSuccessResponseVO(trainService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("add")
	@GlobalInterceptor(checkLogin = true,checkParams = true)
	public ResponseVO add(Train bean) {
		return getSuccessResponseVO(this.trainService.add(bean));
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("addBatch")
	@GlobalInterceptor(checkLogin = true,checkParams = true)
	public ResponseVO addBatch(@RequestBody List<Train> listBean) {
		return getSuccessResponseVO(this.trainService.addBatch(listBean));
	}

	/**
	 * 批量新增或修改
	 */
	@RequestMapping("addOrUpdateBatch")
	@GlobalInterceptor(checkLogin = true,checkParams = true)
	public ResponseVO addOrUpdateBatch(@RequestBody List<Train> listBean) {
		return getSuccessResponseVO(this.trainService.addOrUpdateBatch(listBean));
	}

	/**
	 * 根据Id查询
	 */

	@RequestMapping("getTrainById")
	@GlobalInterceptor(checkLogin = true,checkParams = true)
	public ResponseVO getTrainById(String id) {
		return getSuccessResponseVO(this.trainService.getTrainById(id));
	}

	/**
	 * 根据Id更新
	 */
	@RequestMapping("updateTrainById")
	@GlobalInterceptor(checkLogin = true,checkParams = true)
	public ResponseVO updateTrainById(Train bean, String id) {
		return getSuccessResponseVO(this.trainService.updateTrainById(bean, id));
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("deleteTrainById")
	@GlobalInterceptor(checkLogin = true,checkParams = true)
	public ResponseVO deleteTrainById(@RequestBody @VerifyParam(require = true) String id) {
		this.trainService.deleteTrainById(id);
		return getSuccessResponseVO(null);
	}

}