package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.CrmProductSellInfo;

public interface CrmProductSellInfoMapper {
   

    int insert(CrmProductSellInfo record);
    
    int updateByPrimaryKey(CrmProductSellInfo record);
    

    int insertSelective(CrmProductSellInfo record);

    int deleteByPrimaryKey(Integer productsellinfoId);

    int updateByPrimaryKeySelective(CrmProductSellInfo record);
    
    CrmProductSellInfo selectByPrimaryKey(Integer productsellinfoId);
    
    List<CrmProductSellInfo> selectCrmProductSellInfoByParameter(CrmProductSellInfo record);

    List<CrmProductSellInfo> selectCrmProductSellInfoAll();
    
    List<CrmProductSellInfo> selectCrmProductSellInfoByPage();
    
    List<CrmProductSellInfo> selectCrmProductSellInfoByRangeTime(CrmProductSellInfo record);
    
    List<CrmProductSellInfo> selectCrmProductSellInfoByDate(CrmProductSellInfo record);
}