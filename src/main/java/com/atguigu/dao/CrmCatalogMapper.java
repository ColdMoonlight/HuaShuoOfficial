package com.atguigu.dao;

import com.atguigu.bean.CrmCatalog;

public interface CrmCatalogMapper {
    int deleteByPrimaryKey(Integer catalogId);

    int insert(CrmCatalog record);

    int insertSelective(CrmCatalog record);

    CrmCatalog selectByPrimaryKey(Integer catalogId);

    int updateByPrimaryKeySelective(CrmCatalog record);

    int updateByPrimaryKey(CrmCatalog record);
}