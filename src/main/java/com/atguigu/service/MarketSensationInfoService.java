package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atguigu.bean.MarketSensationInfo;
import com.atguigu.dao.MarketSensationInfoMapper;

@Service
public class MarketSensationInfoService {
	
	@Autowired
	MarketSensationInfoMapper marketSensationInfoMapper;

	
	/**
	 * @author Shinelon
	 * @param MarketSensationInfo
	 * @exception 新增单条信息
	 * 
	 * */
	public int insertSelective(MarketSensationInfo marketSensationInfo) {
		int intReslut = marketSensationInfoMapper.insertSelective(marketSensationInfo);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 更新信息
	 * 
	 * */
	public int deleteByPrimaryKey(Integer id) {
		int intReslut = marketSensationInfoMapper.deleteByPrimaryKey(id);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 更新信息
	 * 
	 * */
	public int updateByPrimaryKeySelective(MarketSensationInfo marketSensationInfo) {
		int intReslut = marketSensationInfoMapper.updateByPrimaryKeySelective(marketSensationInfo);
		return intReslut;
	}
	
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查询单条信息
	 * 
	 * */
	public MarketSensationInfo selectByPrimaryKey(Integer id) {
		MarketSensationInfo marketSensationInfo = marketSensationInfoMapper.selectByPrimaryKey(id);
		return marketSensationInfo;
	}
	
	/**
	 * @author Shinelon
	 * @param MarketSensationInfo
	 * @exception 根据条件查询信息
	 * 
	 * */
	public List<MarketSensationInfo> selectMarketSensationInfoByParameter(MarketSensationInfo marketSensationInfo) {
		List<MarketSensationInfo> marketSensationInfoList = marketSensationInfoMapper.selectMarketSensationInfoByParameter(marketSensationInfo);
		return marketSensationInfoList;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查询全部信息
	 * 
	 * */
	public List<MarketSensationInfo> selectMarketSensationInfoAll() {
		List<MarketSensationInfo> marketSensationInfoList = marketSensationInfoMapper.selectMarketSensationInfoAll();
		return marketSensationInfoList;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 获取分页信息
	 * 
	 * */
	public List<MarketSensationInfo> selectMarketSensationInfoByPage() {
		List<MarketSensationInfo> marketSensationInfoList = marketSensationInfoMapper.selectMarketSensationInfoByPage();
		return marketSensationInfoList;
	}
	
}
