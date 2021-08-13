package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.CrmDepartment;

public interface CrmDepartmentMapper {

    int insert(CrmDepartment record);
    int updateByPrimaryKey(CrmDepartment record);
    
    /****************以下使用********************/
    
    int insertSelective(CrmDepartment record);
    
    int deleteByPrimaryKey(Integer departmentId);
    
    int updateByPrimaryKeySelective(CrmDepartment record);

    CrmDepartment selectByPrimaryKey(Integer departmentId);
    
    List<CrmDepartment> selectCrmDepartmentByParameter(CrmDepartment crmDepartment);
    
    List<CrmDepartment> selectDepartmentInfoAll();
}