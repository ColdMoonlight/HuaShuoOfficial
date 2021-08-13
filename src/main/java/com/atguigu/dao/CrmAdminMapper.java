package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.CrmAdmin;

public interface CrmAdminMapper {

    int insert(CrmAdmin record);

    int updateByPrimaryKey(CrmAdmin record);
    
    /****************以下使用********************/
    int insertSelective(CrmAdmin record);
    
    int deleteByPrimaryKey(Integer adminId);
    
    int updateByPrimaryKeySelective(CrmAdmin record);
    
    CrmAdmin selectByPrimaryKey(Integer adminId);
    
    //查询全部用户
    List<CrmAdmin> selectAdminInfoAll();
    
    //根据条件查询用户
    List<CrmAdmin> selectCrmAdminByParameter(CrmAdmin record);
    
    //获取用户分页列表
    List<CrmAdmin> selectCrmAdminByPage();
}