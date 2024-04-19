package com.jl.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.jl.project.entity.po.Msg;
import com.jl.project.entity.po.MsgUser;
import com.jl.project.entity.query.MsgQuery;
import com.jl.project.entity.query.MsgUserQuery;
import com.jl.project.entity.query.SimplePage;
import com.jl.project.entity.vo.MsgVO;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.enums.PageSize;
import com.jl.project.exception.BusinessException;
import com.jl.project.mapper.MsgMapper;
import com.jl.project.mapper.MsgUserMapper;
import com.jl.project.service.MsgUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:用户消息关联表Service
 * @author:jingLong
 * @date:2023/11/22
 */
@Service("msgUserService")
public class MsgUserServiceImpl implements MsgUserService {

    @Resource
    private MsgUserMapper<MsgUser, MsgUserQuery> msgUserMapper;

    @Resource
    private MsgMapper<Msg, MsgQuery> msgMapper;

    /**
     * 根据条件查询列表
     */
    public List<MsgUser> findListByParam(MsgUserQuery query) {
        return this.msgUserMapper.selectList(query);
    }

    /**
     * 根据条件查询数量
     */
    public Integer findCountByParam(MsgUserQuery query) {
        return this.msgUserMapper.selectCount(query);
    }

    /**
     * 分页查询
     */
    public PaginationResultVO<MsgUser> findListByPage(MsgUserQuery query) {
        Integer count = this.findCountByParam(query);
        Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
        SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
        query.setSimplePage(page);
        List<MsgUser> list = this.findListByParam(query);
        PaginationResultVO<MsgUser> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
        return result;
    }

    /**
     * 新增
     */
    public Integer add(MsgUser bean) {
        return this.msgUserMapper.insert(bean);
    }

    /**
     * 批量新增
     */
    public Integer addBatch(List<MsgUser> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.msgUserMapper.insertBatch(listBean);
    }

    /**
     * 批量新增或修改
     */
    public Integer addOrUpdateBatch(List<MsgUser> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.msgUserMapper.insertOrUpdateBatch(listBean);
    }

    /**
     * 根据Id查询
     */
    public MsgUser getMsgUserById(String id) {
        return this.msgUserMapper.selectById(id);
    }

    /**
     * 根据Id更新
     */
    public Integer updateMsgUserById(MsgUser bean, String id) {
        return this.msgUserMapper.updateById(bean, id);
    }

    /**
     * 根据Id删除
     */
    public Integer deleteMsgUserById(String id) {
        return this.msgUserMapper.deleteById(id);
    }

    @Override
    public PaginationResultVO loadDatalist(MsgUserQuery query) throws BusinessException {
        if (query == null) {
            throw new BusinessException("缺少查询参数");
        }
        PaginationResultVO resultVO = new PaginationResultVO();

        PaginationResultVO<MsgUser> page = findListByPage(query);
        BeanUtil.copyProperties(page, resultVO);

        List<MsgUser> msgUsers = page.getList();
        if (msgUsers == null || msgUsers.isEmpty()) {
            resultVO.setList(Collections.emptyList());
            return resultVO;
        }

        List<MsgVO> resultList = new ArrayList<>();
        for (MsgUser msgUser : msgUsers) {
            String msgId = msgUser.getMsgId();
            Msg msg = msgMapper.selectById(msgId);
            MsgVO msgVO = new MsgVO();
            BeanUtil.copyProperties(msg,msgVO);
            msgVO.setMsgUser(msgUser);
            resultList.add(msgVO);
        }
        resultVO.setList(resultList);

        return resultVO;
    }

    @Override
    public Integer getMyUnreadCount(MsgUserQuery query) throws BusinessException {
        if (query == null) {
            throw new BusinessException("缺少参数");
        }
        // 这里必须给定userId
        String userId = query.getUserId();
        if(userId==null || "".equals(userId.trim())){
            throw new BusinessException("缺少必要参数");
        }
        return findCountByParam(query);
    }

}