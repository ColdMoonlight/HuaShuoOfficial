package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.CrmProductSellEcpp;

public interface CrmProductSellEcppMapper {
	
    int insert(CrmProductSellEcpp record);
    
    int updateByPrimaryKey(CrmProductSellEcpp record);
    
    /****************以下使用********************/
    
    int insertSelective(CrmProductSellEcpp record);
    
    int deleteByPrimaryKey(Integer productsellecppId);
    
    int updateByPrimaryKeySelective(CrmProductSellEcpp record);

    CrmProductSellEcpp selectByPrimaryKey(Integer productsellecppId);
    
    
    List<CrmProductSellEcpp> selectCrmProductSellEcppByParameter(CrmProductSellEcpp record);
    
    List<CrmProductSellEcpp> selectCrmProductSellEcppByPage();

    
}