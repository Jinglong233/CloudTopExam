package com.jl.project.mapper;

import com.jl.project.entity.po.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:部门表商品Mapper
 * @author:jingLong
 * @date:2023/11/22
 */
public interface DepartmentMapper<T, P> extends BaseMapper {
    /**
     * 根据Id查询
     */
    T selectById(@Param("id") String id);

    /**
     * 根据Id更新
     */
    Integer updateById(@Param("bean") T t, @Param("id") String id);

    /**
     * 根据Id删除
     */
    Integer deleteById(@Param("id") String id);

    /**
     * 获取当前层级下最大的序号
     *
     * @param parentCode
     * @return
     */
    List<Department> getCurrentLevelNumList(@Param("parentCode") String parentCode,
                                            @Param("length") String length);

}