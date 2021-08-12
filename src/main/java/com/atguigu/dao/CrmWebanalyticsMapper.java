package com.atguigu.dao;

import com.atguigu.bean.CrmWebanalytics;

public interface CrmWebanalyticsMapper {
    int deleteByPrimaryKey(Integer webanalyticsId);

    int insert(CrmWebanalytics record);

    int insertSelective(CrmWebanalytics record);

    CrmWebanalytics selectByPrimaryKey(Integer webanalyticsId);

    int updateByPrimaryKeySelective(CrmWebanalytics record);

    int updateByPrimaryKey(CrmWebanalytics record);
}