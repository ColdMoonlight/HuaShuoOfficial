package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.MarketSensationDetailOutput;

public interface MarketSensationDetailOutputMapper {
    
    int insert(MarketSensationDetailOutput record);
    
    int updateByPrimaryKey(MarketSensationDetailOutput record);
    
    /****************以下使用********************/

    int insertSelective(MarketSensationDetailOutput record);
    
    int deleteByPrimaryKey(Integer sensationdetailoutputId);

    int updateByPrimaryKeySelective(MarketSensationDetailOutput record);
    
    MarketSensationDetailOutput selectByPrimaryKey(Integer sensationdetailoutputId);

    //根据条件查询
    List<MarketSensationDetailOutput> selectMarketSensationDetailOutputByParameter(MarketSensationDetailOutput record);
    
    //查询全部
    List<MarketSensationDetailOutput> selectMarketSensationDetailOutputAll();

    //分页查询
    List<MarketSensationDetailOutput> selectMarketSensationDetailOutputByPage();
    
    
}