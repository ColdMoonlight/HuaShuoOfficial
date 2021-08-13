package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.CrmCatalog;

public interface CrmCatalogMapper {

    int insert(CrmCatalog record);

    CrmCatalog selectByPrimaryKey(Integer catalogId);
    
    int updateByPrimaryKey(CrmCatalog record);
    
    /****************以下使用********************/
    
    int insertSelective(CrmCatalog record);
    
    int deleteByPrimaryKey(Integer catalogId);
    
    int updateByPrimaryKeySelective(CrmCatalog record);

	List<CrmCatalog> selectCrmCatalogInfoAll();
	
	List<CrmCatalog> selectCrmCatalogSuper();
	
	List<CrmCatalog> selectCrmCatalogByParameter(CrmCatalog crmCatalog);

	List<CrmCatalog> selectDownListAll();
	
	List<CrmCatalog> selectCrmCatalogByPage();
}