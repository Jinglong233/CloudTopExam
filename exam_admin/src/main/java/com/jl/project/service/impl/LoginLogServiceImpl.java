package com.jl.project.service.impl;

import com.jl.project.entity.po.LoginLog;
import com.jl.project.entity.query.LoginLogQuery;
import com.jl.project.entity.query.SimplePage;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.enums.PageSize;
import com.jl.project.exception.BusinessException;
import com.jl.project.mapper.LoginLogMapper;
import com.jl.project.service.LoginLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

;

/**
 * @Description:登录日志表Service
 * @author:jingLong
 * @date:2024/05/13
 */
@Service("loginLogService")
public class LoginLogServiceImpl implements LoginLogService {

    @Resource
    private LoginLogMapper<LoginLog, LoginLogQuery> loginLogMapper;

    /**
     * 根据条件查询列表
     */
    public List<LoginLog> findListByParam(LoginLogQuery query) {
        return this.loginLogMapper.selectList(query);
    }

    /**
     * 根据条件查询数量
     */
    public Integer findCountByParam(LoginLogQuery query) {
        return this.loginLogMapper.selectCount(query);
    }

    /**
     * 分页查询
     */
    public PaginationResultVO<LoginLog> findListByPage(LoginLogQuery query) {
        Integer count = this.findCountByParam(query);
        Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
        SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
        query.setSimplePage(page);
        List<LoginLog> list = this.findListByParam(query);
        PaginationResultVO<LoginLog> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
        return result;
    }

    /**
     * 新增
     */
    public Integer add(LoginLog bean) {
        return this.loginLogMapper.insert(bean);
    }

    /**
     * 批量新增
     */
    public Integer addBatch(List<LoginLog> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.loginLogMapper.insertBatch(listBean);
    }

    /**
     * 批量新增或修改
     */
    public Integer addOrUpdateBatch(List<LoginLog> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.loginLogMapper.insertOrUpdateBatch(listBean);
    }

    /**
     * 根据Id查询
     */
    public LoginLog getLoginLogById(Integer id) {
        return this.loginLogMapper.selectById(id);
    }

    /**
     * 根据Id更新
     */
    public Integer updateLoginLogById(LoginLog bean, Integer id) {
        return this.loginLogMapper.updateById(bean, id);
    }

    /**
     * 根据Id删除
     */
    public Integer deleteLoginLogById(Integer id) {
        return loginLogMapper.deleteById(id);
    }

    @Override
    public Boolean deleteLoginLogBatchById(List<Integer> deleteList) {
        if (deleteList == null || deleteList.size() == 0) {
            throw new BusinessException("参数为空");
        }
        Integer result = loginLogMapper.deleteLoginLogBatchById(deleteList);
        return result > 0;
    }

    @Override
    public void test(Integer deleteList) {
        System.out.println(deleteList);
    }

}