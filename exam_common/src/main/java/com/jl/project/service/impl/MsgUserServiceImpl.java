package com.jl.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.jl.project.entity.po.Msg;
import com.jl.project.entity.po.MsgUser;
import com.jl.project.entity.query.MsgQuery;
import com.jl.project.entity.query.MsgUserQuery;
import com.jl.project.entity.query.SimplePage;
import com.jl.project.entity.vo.LoginResponseVo;
import com.jl.project.entity.vo.MsgVO;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.enums.MsgType;
import com.jl.project.enums.PageSize;
import com.jl.project.exception.BusinessException;
import com.jl.project.mapper.MsgMapper;
import com.jl.project.mapper.MsgUserMapper;
import com.jl.project.service.MsgUserService;
import com.jl.project.utils.CommonUtil;
import com.jl.project.utils.UserInfoUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    private StringRedisTemplate stringRedisTemplate;

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
            BeanUtil.copyProperties(msg, msgVO);
            msgVO.setMsgUser(msgUser);
            resultList.add(msgVO);
        }
        resultVO.setList(resultList);

        return resultVO;
    }

    @Override
    public Integer getMyUnreadCount() throws BusinessException {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginResponseVo loginUserInfo = UserInfoUtil.getLoginUserInfo(stringRedisTemplate);
        MsgQuery msgQuery = new MsgQuery();
        msgQuery.setMsgType(MsgType.NOTIFICATION.getValue());
        List<Msg> msgList = msgMapper.selectList(msgQuery);
        int totalUnReadCount = 0;
        if (msgList.size() == 0) {
            return totalUnReadCount;
        }

        for (Msg msg : msgList) {
            MsgUserQuery msgUserQuery = new MsgUserQuery();
            msgUserQuery.setMsgId(msg.getId());
            msgUserQuery.setUserId(loginUserInfo.getId());
            // 未读状态
            msgUserQuery.setState(0);
            Integer count = msgUserMapper.selectCount(msgUserQuery);
            totalUnReadCount += count;
        }
        return totalUnReadCount;
    }

    @Override
    public PaginationResultVO<MsgVO> getNotification(SimplePage simplePage) {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginResponseVo loginUserInfo = UserInfoUtil.getLoginUserInfo(stringRedisTemplate);

        List<MsgVO> result = new ArrayList<>();

        MsgUserQuery msgUserQuery = new MsgUserQuery();
        msgUserQuery.setUserId(loginUserInfo.getId());
        List<MsgUser> msgUserList = msgUserMapper.selectList(msgUserQuery);
        if (msgUserList != null && msgUserList.size() != 0) {
            // 遍历关联信息
            for (MsgUser msgUser : msgUserList) {
                String msgId = msgUser.getMsgId();
                MsgQuery msgQuery = new MsgQuery();
                msgQuery.setId(msgId);
                // 设置通知类型
                msgQuery.setMsgType(MsgType.NOTIFICATION.getValue());
                // 查询关联的消息
                List<Msg> msgList = msgMapper.selectList(msgQuery);
                if (msgList.size() != 0) {
                    MsgVO msgVO = new MsgVO();
                    msgVO.setMsgUser(msgUser);
                    // 只有一个
                    BeanUtil.copyProperties(msgList.get(0), msgVO);
                    result.add(msgVO);
                }
            }
        }
        // 按照时间降序排序
        Collections.sort(result, (o1, o2) -> o2.getSendTime().compareTo(o1.getSendTime()));

        return CommonUtil.paginate(result,simplePage);
    }

    @Override
    public List<Msg> getAnnouncement() {
        MsgQuery msgQuery = new MsgQuery();
        msgQuery.setMsgType(MsgType.ANNOUNCEMENT.getValue());
        List<Msg> result = msgMapper.selectList(msgQuery);
        // 按照时间降序排序
        Collections.sort(result, (o1, o2) -> o2.getSendTime().compareTo(o1.getSendTime()));
        return result;
    }

    @Override
    public PaginationResultVO<MsgVO> getUnReadNotification(SimplePage simplePage) {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginResponseVo loginUserInfo = UserInfoUtil.getLoginUserInfo(stringRedisTemplate);

        List<MsgVO> result = new ArrayList<>();

        MsgUserQuery msgUserQuery = new MsgUserQuery();
        msgUserQuery.setUserId(loginUserInfo.getId());
        // 设置未读状态
        msgUserQuery.setState(0);
        List<MsgUser> msgUserList = msgUserMapper.selectList(msgUserQuery);
        if (msgUserList != null && msgUserList.size() != 0) {
            // 遍历关联信息
            for (MsgUser msgUser : msgUserList) {
                String msgId = msgUser.getMsgId();
                MsgQuery msgQuery = new MsgQuery();
                msgQuery.setId(msgId);
                // 设置通知类型
                msgQuery.setMsgType(MsgType.NOTIFICATION.getValue());
                // 查询关联的消息
                List<Msg> msgList = msgMapper.selectList(msgQuery);
                if (msgList.size() != 0) {
                    MsgVO msgVO = new MsgVO();
                    msgVO.setMsgUser(msgUser);
                    // 只有一个
                    BeanUtil.copyProperties(msgList.get(0), msgVO);
                    result.add(msgVO);
                }
            }
        }
        // 按照时间降序排序
        Collections.sort(result, (o1, o2) -> o2.getSendTime().compareTo(o1.getSendTime()));
        return CommonUtil.paginate(result,simplePage);
    }

    @Override
    public PaginationResultVO<MsgVO> getReadNotification(SimplePage simplePage) {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginResponseVo loginUserInfo = UserInfoUtil.getLoginUserInfo(stringRedisTemplate);

        List<MsgVO> result = new ArrayList<>();

        MsgUserQuery msgUserQuery = new MsgUserQuery();
        msgUserQuery.setUserId(loginUserInfo.getId());
        // 设置未读状态
        msgUserQuery.setState(1);
        List<MsgUser> msgUserList = msgUserMapper.selectList(msgUserQuery);
        if (msgUserList != null && msgUserList.size() != 0) {
            // 遍历关联信息
            for (MsgUser msgUser : msgUserList) {
                String msgId = msgUser.getMsgId();
                MsgQuery msgQuery = new MsgQuery();
                msgQuery.setId(msgId);
                // 设置通知类型
                msgQuery.setMsgType(MsgType.NOTIFICATION.getValue());
                // 查询关联的消息
                List<Msg> msgList = msgMapper.selectList(msgQuery);
                if (msgList.size() != 0) {
                    MsgVO msgVO = new MsgVO();
                    msgVO.setMsgUser(msgUser);
                    // 只有一个
                    BeanUtil.copyProperties(msgList.get(0), msgVO);
                    result.add(msgVO);
                }
            }
        }
        // 按照时间降序排序
        Collections.sort(result, (o1, o2) -> o2.getSendTime().compareTo(o1.getSendTime()));
        return CommonUtil.paginate(result,simplePage);
    }

}