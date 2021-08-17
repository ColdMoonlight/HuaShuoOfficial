package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.CrmWebanalytics;

public interface CrmWebanalyticsMapper {

    int insert(CrmWebanalytics record);
    int updateByPrimaryKey(CrmWebanalytics record);
    
    /****************以下使用********************/
    
    int insertSelective(CrmWebanalytics record);
    
    int deleteByPrimaryKey(Integer webanalyticsId);

    int updateByPrimaryKeySelective(CrmWebanalytics record);
    
    CrmWebanalytics selectByPrimaryKey(Integer webanalyticsId);
    
    //查询全部用户
    List<CrmWebanalytics> selectCrmWebanalyticsInfoAll();
    
    //根据条件查询用户
    List<CrmWebanalytics> selectCrmWebanalyticsByParameter(CrmWebanalytics record);
    
    //分页查询
    List<CrmWebanalytics> selectCrmWebanalyticsByPage();
    
	List<CrmWebanalytics> selectCrmWebanalyticsByBrand(CrmWebanalytics crmWebanalyticsBrand);
}