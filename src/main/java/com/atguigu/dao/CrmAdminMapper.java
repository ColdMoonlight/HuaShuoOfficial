package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.CrmAdmin;

public interface CrmAdminMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(CrmAdmin record);

    int insertSelective(CrmAdmin record);

    CrmAdmin selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(CrmAdmin record);

    int updateByPrimaryKey(CrmAdmin record);
    
    //查询全部用户
    List<CrmAdmin> selectAdminInfoAll();
    
    //根据条件查询用户
    List<CrmAdmin> selectCrmAdminByParameter(CrmAdmin record);
}