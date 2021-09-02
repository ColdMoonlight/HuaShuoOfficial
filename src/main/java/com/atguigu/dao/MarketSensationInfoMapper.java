package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.MarketSensationInfo;

public interface MarketSensationInfoMapper {
	
    int insert(MarketSensationInfo record);
    
    int updateByPrimaryKey(MarketSensationInfo record);
    
    /****************以下使用********************/
    
    int insertSelective(MarketSensationInfo record);
    
    int deleteByPrimaryKey(Integer sensationinfoId);
    
    int updateByPrimaryKeySelective(MarketSensationInfo record);

    MarketSensationInfo selectByPrimaryKey(Integer sensationinfoId);
    
    //根据条件查询
    List<MarketSensationInfo> selectMarketSensationInfoByParameter(MarketSensationInfo record);
    
    //查询全部
    List<MarketSensationInfo> selectMarketSensationInfoAll();

    //分页查询
    List<MarketSensationInfo> selectMarketSensationInfoByPage();
    
}