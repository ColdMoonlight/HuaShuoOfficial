package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atguigu.bean.CrmProductSellEcpp;
import com.atguigu.dao.CrmProductSellEcppMapper;

@Service
public class CrmProductSellEcppService {
	
	@Autowired
	CrmProductSellEcppMapper crmProductSellEcppMapper;

	
	/**
	 * @author Shinelon
	 * @param CrmProductSellEcpp
	 * @exception 新增单条 信息
	 * 
	 * */
	public int insertSelective(CrmProductSellEcpp crmProductSellEcpp) {
		int intReslut = crmProductSellEcppMapper.insertSelective(crmProductSellEcpp);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 更新信息
	 * 
	 * */
	public int deleteByPrimaryKey(CrmProductSellEcpp crmProductSellEcpp) {
		int id = crmProductSellEcpp.getProductsellecppId();
		int intReslut = crmProductSellEcppMapper.deleteByPrimaryKey(id);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 更新信息
	 * 
	 * */
	public int updateByPrimaryKeySelective(CrmProductSellEcpp crmProductSellEcpp) {
		int intReslut = crmProductSellEcppMapper.updateByPrimaryKeySelective(crmProductSellEcpp);
		return intReslut;
	}
	/**
	 * @author Shinelon
	 * @param CrmProductSellEcpp
	 * @exception 根据条件查询信息
	 * 
	 * */
	public List<CrmProductSellEcpp> selectCrmProductSellEcppByParameter(CrmProductSellEcpp crmProductSellEcpp) {
		List<CrmProductSellEcpp> crmProductSellEcppList = crmProductSellEcppMapper.selectCrmProductSellEcppByParameter(crmProductSellEcpp);
		return crmProductSellEcppList;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查询单条信息
	 * 
	 * */
	public CrmProductSellEcpp selectByPrimaryKey(Integer id) {
		CrmProductSellEcpp crmProductSellEcpp = crmProductSellEcppMapper.selectByPrimaryKey(id);
		return crmProductSellEcpp;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 获取分页信息
	 * 
	 * */
	public List<CrmProductSellEcpp> selectCrmProductSellEcppByPage() {
		List<CrmProductSellEcpp> crmProductSellEcppList = crmProductSellEcppMapper.selectCrmProductSellEcppByPage();
		return crmProductSellEcppList;
	}
}
