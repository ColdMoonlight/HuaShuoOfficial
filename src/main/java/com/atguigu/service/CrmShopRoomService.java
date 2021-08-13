package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atguigu.bean.CrmShopRoom;
import com.atguigu.dao.CrmShopRoomMapper;

@Service
public class CrmShopRoomService {
	
	@Autowired
	CrmShopRoomMapper crmShopRoomMapper;

	
	/**
	 * @author Shinelon
	 * @param CrmShopRoom
	 * @exception 新增单条信息
	 * 
	 * */
	public int insertSelective(CrmShopRoom crmShopRoom) {
		int intReslut = crmShopRoomMapper.insertSelective(crmShopRoom);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 更新信息
	 * 
	 * */
	public int deleteByPrimaryKey(CrmShopRoom crmShopRoom) {
		int id = crmShopRoom.getShoproomId();
		int intReslut = crmShopRoomMapper.deleteByPrimaryKey(id);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 更新信息
	 * 
	 * */
	public int updateByPrimaryKeySelective(CrmShopRoom crmShopRoom) {
		int intReslut = crmShopRoomMapper.updateByPrimaryKeySelective(crmShopRoom);
		return intReslut;
	}
	/**
	 * @author Shinelon
	 * @param CrmShopRoom
	 * @exception 根据条件查询信息
	 * 
	 * */
	public List<CrmShopRoom> selectCrmShopRoomByParameter(CrmShopRoom crmShopRoom) {
		List<CrmShopRoom> crmShopRoomList = crmShopRoomMapper.selectCrmShopRoomByParameter(crmShopRoom);
		return crmShopRoomList;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查询单条信息
	 * 
	 * */
	public CrmShopRoom selectByPrimaryKey(Integer id) {
		CrmShopRoom crmShopRoom = crmShopRoomMapper.selectByPrimaryKey(id);
		return crmShopRoom;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查询全部信息
	 * 
	 * */
	public List<CrmShopRoom> selectShopRoomInfoAll() {
		List<CrmShopRoom> crmShopRoomList = crmShopRoomMapper.selectShopRoomInfoAll();
		return crmShopRoomList;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 获取分页信息
	 * 
	 * *//*
	public List<CrmShopRoom> selectCrmShopRoomByPage() {
		List<CrmShopRoom> crmShopRoomList = crmShopRoomMapper.selectCrmShopRoomByPage();
		return crmShopRoomList;
	}*/
	
}
