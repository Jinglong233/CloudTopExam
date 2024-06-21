package com.jl.project.saTokenStpInter;

import cn.dev33.satoken.stp.StpInterface;
import com.jl.project.entity.po.User;
import com.jl.project.entity.query.UserQuery;
import com.jl.project.mapper.UserMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 自定义权限加载接口实现类
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    @Resource
    private UserMapper<User, UserQuery> userMapper;

    /**
     * 返回一个账号所拥有的权限码集合 
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {

        // 本系统没有细分的路由等权限
        return Collections.emptyList();
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        User user = userMapper.selectById(loginId.toString());
        List<String> list = new ArrayList<String>();
        list.add(user.getRole());
        return list;
    }

}
