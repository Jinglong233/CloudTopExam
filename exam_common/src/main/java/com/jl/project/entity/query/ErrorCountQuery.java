package com.jl.project.entity.query;

import com.jl.project.annotation.VerifyParam;

/**
 * @Description 错题统计查询对象
 * @Author huawei
 * @Date 2024-06-01 12:21
 **/
public class ErrorCountQuery extends BaseQuery{
    /**
     * 部门编码
     */
    @VerifyParam(require = true)
    private String deptCode;

    public ErrorCountQuery() {
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }


}
