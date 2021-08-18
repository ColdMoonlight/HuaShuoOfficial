package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.CrmProductSellInfo;

public interface CrmProductSellInfoMapper {
    
    int insert(CrmProductSellInfo record);
    int updateByPrimaryKey(CrmProductSellInfo record);
    
    /****************以下使用********************/
    int insertSelective(CrmProductSellInfo record);
    
    int deleteByPrimaryKey(Integer productsellinfoId);

    int updateByPrimaryKeySelective(CrmProductSellInfo record);
    
    CrmProductSellInfo selectByPrimaryKey(Integer productsellinfoId);

    //查询全部
    List<CrmProductSellInfo> selectCrmProductSellInfoAll();
    
    //根据条件查询
    List<CrmProductSellInfo> selectCrmProductSellInfoByParameter(CrmProductSellInfo record);
    
    //获取分页列表
    List<CrmProductSellInfo> selectCrmProductSellInfoByPage();
    

    
}