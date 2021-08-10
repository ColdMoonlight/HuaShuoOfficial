package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.CrmCatalog;

public interface CrmCatalogMapper {
    int deleteByPrimaryKey(Integer catalogId);

    int insert(CrmCatalog record);

    int insertSelective(CrmCatalog record);

    CrmCatalog selectByPrimaryKey(Integer catalogId);

    int updateByPrimaryKeySelective(CrmCatalog record);

    int updateByPrimaryKey(CrmCatalog record);

	List<CrmCatalog> selectCrmCatalogInfoAll();

	List<CrmCatalog> selectCrmCatalogByParameter(CrmCatalog crmCatalog);
}