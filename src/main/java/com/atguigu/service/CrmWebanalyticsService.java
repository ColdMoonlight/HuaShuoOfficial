package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.CrmWebanalytics;
import com.atguigu.dao.CrmWebanalyticsMapper;

@Service
public class CrmWebanalyticsService {
	
	@Autowired
	CrmWebanalyticsMapper crmWebanalyticsMapper;

	
	/**
	 * @author Shinelon
	 * @param CrmWebanalytics
	 * @exception 新增单条渠道信息
	 * 
	 * */
	public int insertSelective(CrmWebanalytics CrmWebanalytics) {
		int intReslut = crmWebanalyticsMapper.insertSelective(CrmWebanalytics);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param CrmCatalog
	 * @exception 新增单条用户信息
	 * 
	 * */
	public int deleteByPrimaryKey(Integer catalogId) {
		int intReslut = crmWebanalyticsMapper.deleteByPrimaryKey(catalogId);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 更新渠道信息
	 * 
	 * */
	public int updateByPrimaryKeySelective(CrmWebanalytics CrmWebanalytics) {
		int intReslut = crmWebanalyticsMapper.updateByPrimaryKeySelective(CrmWebanalytics);
		return intReslut;
	}
	/**
	 * @author Shinelon
	 * @param CrmWebanalytics
	 * @exception 根据条件查询渠道信息
	 * 
	 * */
	public List<CrmWebanalytics> selectCrmWebanalyticsByParameter(CrmWebanalytics CrmWebanalytics) {
		List<CrmWebanalytics> CrmWebanalyticsList = crmWebanalyticsMapper.selectCrmWebanalyticsByParameter(CrmWebanalytics);
		return CrmWebanalyticsList;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查询单条渠道信息
	 * 
	 * */
	public CrmWebanalytics selectByPrimaryKey(Integer id) {
		CrmWebanalytics CrmWebanalytics = crmWebanalyticsMapper.selectByPrimaryKey(id);
		return CrmWebanalytics;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查询全部渠道信息
	 * 
	 * */
	public List<CrmWebanalytics> selectCrmWebanalyticsInfoAll() {
		List<CrmWebanalytics> CrmWebanalyticsList = crmWebanalyticsMapper.selectCrmWebanalyticsInfoAll();
		return CrmWebanalyticsList;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 分页查询
	 * 
	 * */
	public List<CrmWebanalytics> selectCrmWebanalyticsByPage() {
		List<CrmWebanalytics> CrmWebanalyticsList = crmWebanalyticsMapper.selectCrmWebanalyticsByPage();
		return CrmWebanalyticsList;
	}

	public List<CrmWebanalytics> selectCrmWebanalyticsByBrand(CrmWebanalytics crmWebanalyticsBrand) {
		List<CrmWebanalytics> CrmWebanalyticsList = crmWebanalyticsMapper.selectCrmWebanalyticsByBrand(crmWebanalyticsBrand);
		return CrmWebanalyticsList;
	}
	
}
