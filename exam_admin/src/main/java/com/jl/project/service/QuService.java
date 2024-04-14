package com.jl.project.service;

import java.io.IOException;
;
import com.jl.project.entity.dto.AddQuAndAnswerDTO;
import com.jl.project.entity.dto.RandomSelectQuDTO;
import com.jl.project.entity.dto.UpdateQuAndAnswerDTO;
import com.jl.project.entity.query.QuExcludeQuery;
import com.jl.project.entity.vo.QuAndAnswerVo;
import com.jl.project.exception.BusinessException;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.po.Qu;
import com.jl.project.entity.query.QuQuery;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
/**
 * @Description:题目表Service
 * @author:jingLong
 * @date:2023/11/22
 */
public interface QuService {

	/**
	 * 根据条件查询列表
	 */
	List<Qu> findListByParam(QuQuery query);

	/**
	 * 根据条件查询数量
	 */
	Integer findCountByParam(QuQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<Qu> findListByPage(QuQuery query);

	/**
	 * 新增
	 */
	Boolean add(AddQuAndAnswerDTO bean) throws BusinessException;

	/**
	 * 批量新增
	 */
	Integer addBatch(List<Qu> listBean);

	/**
	 * 批量新增或修改
	 */
	Integer addOrUpdateBatch(List<Qu> listBean);

	/**
	 * 根据Id查询
	 */
	QuAndAnswerVo getQuById(String id) throws BusinessException;

	/**
	 * 根据Id更新
	 */
	Boolean updateQuById(UpdateQuAndAnswerDTO bean) throws BusinessException;

	/**
	 * 根据Id删除
	 */
	Boolean deleteQuById(String id) throws BusinessException;

	/**
	 * 随机抽题
	 * @param selectQuDTO
	 * @return
	 * @throws BusinessException
	 */
	List<QuAndAnswerVo> randomSelectQu(RandomSelectQuDTO selectQuDTO) throws BusinessException;

	/**
	 * 获取详细题目列表
	 * @param query
	 * @return
	 */
    List<QuAndAnswerVo> loadDetailDataList(QuQuery query);

	/**
	 * 获取详细题目列表(排除之后的)
	 * @param query
	 * @return
	 */
	List<QuAndAnswerVo> loadExcludeDataList(QuExcludeQuery query);

	/**
	 * 获取题目总数
	 * @param query
	 * @return
	 */
	Integer getQuCount(QuQuery query);

	/**
	 * 导出
	 * @param response
	 */
    void export(HttpServletResponse response) throws IOException;

	/**
	 * 导入题目
	 * @param file
	 */
	Boolean importQuestions(MultipartFile file,String repoId);
}