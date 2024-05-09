package com.jl.project.service.impl;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.StrUtil;
import com.jl.project.entity.dto.SendMessageDTO;
import com.jl.project.entity.po.Msg;
import com.jl.project.entity.po.MsgUser;
import com.jl.project.entity.po.User;
import com.jl.project.entity.query.MsgQuery;
import com.jl.project.entity.query.MsgUserQuery;
import com.jl.project.entity.query.SimplePage;
import com.jl.project.entity.query.UserQuery;
import com.jl.project.entity.vo.LoginResponseVo;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.enums.MsgType;
import com.jl.project.enums.PageSize;
import com.jl.project.enums.SendType;
import com.jl.project.exception.BusinessException;
import com.jl.project.mapper.MsgMapper;
import com.jl.project.mapper.MsgUserMapper;
import com.jl.project.mapper.UserMapper;
import com.jl.project.service.EmailService;
import com.jl.project.service.MsgService;
import com.jl.project.utils.CommonUtil;
import com.jl.project.utils.UserInfoUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

;

/**
 * @Description:消息表Service
 * @author:jingLong
 * @date:2023/11/22
 */
@Service("msgService")
public class MsgServiceImpl implements MsgService {

    @Resource
    private MsgMapper<Msg, MsgQuery> msgMapper;

    @Resource
    private MsgUserMapper<MsgUser, MsgUserQuery> msgUserMapper;

    @Resource
    private UserMapper<User, UserQuery> userMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private EmailService emailService;

    /**
     * 根据条件查询列表
     */
    public List<Msg> findListByParam(MsgQuery query) {
        return this.msgMapper.selectList(query);
    }

    /**
     * 根据条件查询数量
     */
    public Integer findCountByParam(MsgQuery query) {
        return this.msgMapper.selectCount(query);
    }

    /**
     * 分页查询
     */
    public PaginationResultVO<Msg> findListByPage(MsgQuery query) {
        Integer count = this.findCountByParam(query);
        Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
        SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
        query.setSimplePage(page);
        List<Msg> list = this.findListByParam(query);
        PaginationResultVO<Msg> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
        return result;
    }

    @Override
    @Transactional
    public Boolean sendMessage(SendMessageDTO sendMessageDTO) {

        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginResponseVo loginUserInfo = UserInfoUtil.getLoginUserInfo(request, stringRedisTemplate);

        // 获取消息类型
        List<Integer> msgType = sendMessageDTO.getMsgType();


        Msg msg = new Msg();
        msg.setCreateUser(loginUserInfo.getId());
        msg.setCreateUserText(loginUserInfo.getUserName());
        msg.setSendTime(new Date());
        msg.setTitle(sendMessageDTO.getMsgTitle());
        msg.setContent(sendMessageDTO.getMsgContent());
        msg.setState(1);


        // 注意：公告，邮件不统计已读未读人数
        // 如果是公告，直接存储到msg表中即可
        if (msgType.contains(MsgType.ANNOUNCEMENT.getValue())) {
            String msgId = CommonUtil.getRandomId();
            msg.setId(msgId);
            msg.setMsgType(MsgType.ANNOUNCEMENT.getValue());
            Integer insert = msgMapper.insert(msg);
            return insert > 0;
        }


        // 根据发送类型获取用户类型
        List<User> userList = new ArrayList<>();
        Integer sendType = sendMessageDTO.getSendType();
        if (sendType == null) {
            throw new BusinessException("缺少发送类型");
        }
        if (SendType.FULLOPEN.getValue() == sendType) { // 完全开放
            UserQuery userQuery = new UserQuery();
            userList = userMapper.selectList(userQuery);
        } else if (SendType.MEMBER.getValue() == sendType) { // 指定成员
            List<String> userIdList = sendMessageDTO.getUserList();
            if (userIdList == null || userIdList.size() == 0) {
                throw new BusinessException("指定成员为空");
            }
            for (String userId : userIdList) {
                User user = userMapper.selectById(userId);
                if (user != null) {
                    userList.add(user);
                }
            }
        } else if (SendType.DEPARTMENT.getValue() == sendType) { // 指定部门
            String deptCode = sendMessageDTO.getDeptCode();
            if (StrUtil.isEmpty(deptCode)) {
                throw new BusinessException("指定部门为空");
            }
            UserQuery userQuery = new UserQuery();
            userQuery.setDeptCodeFuzzy(deptCode);
            userList = userMapper.selectList(userQuery);
            if (userList.size() == 0) {
                throw new BusinessException("指定部门的成员为空");
            }
        }

        // 邮件类型
        if (msgType.contains(MsgType.EMAIL.getValue())) {
            String msgId = CommonUtil.getRandomId();
            msg.setId(msgId);
            msg.setMsgType(MsgType.EMAIL.getValue());
            int total = 0;
            if (userList != null && userList.size() != 0) {
                for (User user : userList) {
                    MsgUser msgUser = new MsgUser();
                    msgUser.setId(CommonUtil.getRandomId());
                    msgUser.setMsgId(msgId);
                    msgUser.setUserId(user.getId());
                    String email = user.getEmail();
                    if (!StrUtil.isEmpty(email)) {
                        // 异步发送邮件
                        ThreadUtil.execAsync(() -> {
                            emailService.sendNotification(email, msg);
                        });
                    } else {
                        // 邮件只记录关联，只在异常的时候记录异常状态，不统计已读未读状态
                        msgUser.setState(-1);
                    }
                    // 插入
                    Integer msgUserInsert = msgUserMapper.insert(msgUser);
                    if (msgUserInsert <= 0) {
                        throw new BusinessException("发送邮件失败");
                    }
                    total++;
                }

                msg.setSendCount(total);
                Integer insert = msgMapper.insert(msg);
                if (insert <= 0) {
                    throw new BusinessException("创建邮件类型消息记录失败");
                }
            }
        }


        // 通知类型
        if (msgType.contains(MsgType.NOTIFICATION.getValue())) {
            String msgId = CommonUtil.getRandomId();
            msg.setId(msgId);
            msg.setMsgType(MsgType.NOTIFICATION.getValue());
            int total = 0;
            if (userList != null && userList.size() != 0) {
                for (User user : userList) {
                    MsgUser msgUser = new MsgUser();
                    msgUser.setId(CommonUtil.getRandomId());
                    msgUser.setMsgId(msgId);
                    msgUser.setUserId(user.getId());
                    msgUser.setState(0);

                    // 插入
                    Integer msgUserInsert = msgUserMapper.insert(msgUser);
                    if (msgUserInsert <= 0) {
                        throw new BusinessException("发送邮件失败");
                    }
                    total++;
                }
            }

            msg.setSendCount(total);
            msg.setReadCount(0);
            Integer insert = msgMapper.insert(msg);
            if (insert <= 0) {
                throw new BusinessException("创建通知类型消息记录失败");
            }
        }


        return true;
    }

    /**
     * 批量新增
     */
    public Integer addBatch(List<Msg> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.msgMapper.insertBatch(listBean);
    }

    /**
     * 批量新增或修改
     */
    public Integer addOrUpdateBatch(List<Msg> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.msgMapper.insertOrUpdateBatch(listBean);
    }

    /**
     * 根据Id查询
     */
    public Msg getMsgById(String id) {
        return this.msgMapper.selectById(id);
    }

    /**
     * 根据Id更新
     */
    public Integer updateMsgById(Msg bean, String id) {
        return this.msgMapper.updateById(bean, id);
    }

    /**
     * 根据Id删除
     */
    public Integer deleteMsgById(String id) {
        return this.msgMapper.deleteById(id);
    }

}