package com.atguigu.dao;

import com.atguigu.bean.CrmDepartment;

public interface CrmDepartmentMapper {
    int deleteByPrimaryKey(Integer departmentId);

    int insert(CrmDepartment record);

    int insertSelective(CrmDepartment record);

    CrmDepartment selectByPrimaryKey(Integer departmentId);

    int updateByPrimaryKeySelective(CrmDepartment record);

    int updateByPrimaryKey(CrmDepartment record);
}