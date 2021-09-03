package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atguigu.bean.MarketSensationDetailOutput;
import com.atguigu.dao.MarketSensationDetailOutputMapper;

@Service
public class MarketSensationDetailOutputService {
	
	@Autowired
	MarketSensationDetailOutputMapper marketSensationDetailOutputMapper;

	
	/**
	 * @author Shinelon
	 * @param MarketSensationDetailOutput
	 * @exception 新增单条信息
	 * 
	 * */
	public int insertSelective(MarketSensationDetailOutput marketSensationDetailOutput) {
		int intReslut = marketSensationDetailOutputMapper.insertSelective(marketSensationDetailOutput);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 更新信息
	 * 
	 * */
	public int deleteByPrimaryKey(Integer id) {
		int intReslut = marketSensationDetailOutputMapper.deleteByPrimaryKey(id);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 更新信息
	 * 
	 * */
	public int updateByPrimaryKeySelective(MarketSensationDetailOutput marketSensationDetailOutput) {
		int intReslut = marketSensationDetailOutputMapper.updateByPrimaryKeySelective(marketSensationDetailOutput);
		return intReslut;
	}
	
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查询单条信息
	 * 
	 * */
	public MarketSensationDetailOutput selectByPrimaryKey(Integer id) {
		MarketSensationDetailOutput marketSensationDetailOutput = marketSensationDetailOutputMapper.selectByPrimaryKey(id);
		return marketSensationDetailOutput;
	}
	
	/**
	 * @author Shinelon
	 * @param MarketSensationDetailOutput
	 * @exception 根据条件查询信息
	 * 
	 * */
	public List<MarketSensationDetailOutput> selectMarketSensationDetailOutputByParameter(MarketSensationDetailOutput marketSensationDetailOutput) {
		List<MarketSensationDetailOutput> marketSensationDetailOutputList = marketSensationDetailOutputMapper.selectMarketSensationDetailOutputByParameter(marketSensationDetailOutput);
		return marketSensationDetailOutputList;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查询全部信息
	 * 
	 * */
	public List<MarketSensationDetailOutput> selectMarketSensationDetailOutputAll() {
		List<MarketSensationDetailOutput> marketSensationDetailOutputList = marketSensationDetailOutputMapper.selectMarketSensationDetailOutputAll();
		return marketSensationDetailOutputList;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 获取分页信息
	 * 
	 * */
	public List<MarketSensationDetailOutput> selectMarketSensationDetailOutputByPage() {
		List<MarketSensationDetailOutput> marketSensationDetailOutputList = marketSensationDetailOutputMapper.selectMarketSensationDetailOutputByPage();
		return marketSensationDetailOutputList;
	}
	
}
