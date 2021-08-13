package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.CrmShopRoom;

public interface CrmShopRoomMapper {
    
    int insert(CrmShopRoom record);
    
    int updateByPrimaryKey(CrmShopRoom record);
    
    /****************以下使用********************/

    int insertSelective(CrmShopRoom record);
    
    int deleteByPrimaryKey(Integer shoproomId);
    
    int updateByPrimaryKeySelective(CrmShopRoom record);

    CrmShopRoom selectByPrimaryKey(Integer shoproomId);

    List<CrmShopRoom> selectCrmShopRoomByParameter(CrmShopRoom crmShopRoom);
    
    List<CrmShopRoom> selectShopRoomInfoAll();
    
}