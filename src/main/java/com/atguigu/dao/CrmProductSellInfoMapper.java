package com.atguigu.dao;

import java.util.List;
import java.util.Map;

import com.atguigu.bean.CrmProductSellInfo;
import com.atguigu.vo.CrmProductSellInfoVo;

public interface CrmProductSellInfoMapper {
   

    int insert(CrmProductSellInfo record);
    
    int updateByPrimaryKey(CrmProductSellInfo record);
    

    int insertSelective(CrmProductSellInfo record);

    int deleteByPrimaryKey(Integer productsellinfoId);

    int updateByPrimaryKeySelective(CrmProductSellInfo record);
    
    CrmProductSellInfo selectByPrimaryKey(Integer productsellinfoId);
    
    List<CrmProductSellInfo> selectCrmProductSellInfoByParameter(CrmProductSellInfo record);

    List<CrmProductSellInfo> selectCrmProductSellInfoAll();
    //独立站 后台分页
    List<CrmProductSellInfo> selectCrmProductSellInfoByPage();
    
    //速卖通 后台分页
    List<CrmProductSellInfo> selectCrmProductSellInfoAliExpressByPage();
    
    //国际站 后台分页
    List<CrmProductSellInfo> selectCrmProductSellInfoAlibabaByPage();
    
    
    //按时间范围查询全部数据
    List<CrmProductSellInfo> selectCrmProductSellInfoAllByRangeTime(CrmProductSellInfo record);
    //按时间范围、平台名称、网站名称 查询全部数据
    List<CrmProductSellInfo> selectCrmProductSellInfoByRangeTimePlatformBrandName(CrmProductSellInfo record);
    
    List<Map<String,Object>> selectAllCrmProductSellInfoByRangeTime(CrmProductSellInfo record);
    
   //按时间范围、平台名称、网站名称 查询全部数据
    List<CrmProductSellInfoVo> selectCrmProductSellInfoVoByRangeTimePlatformBrandName(CrmProductSellInfo record);
    
}