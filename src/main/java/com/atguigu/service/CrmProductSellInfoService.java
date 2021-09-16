package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atguigu.bean.CrmProductSellInfo;
import com.atguigu.dao.CrmProductSellInfoMapper;

@Service
public class CrmProductSellInfoService {
	
	@Autowired
	CrmProductSellInfoMapper crmProductSellInfoMapper;

	
	/**
	 * @author Shinelon
	 * @param CrmProductSellInfo
	 * @exception 新增单条 信息
	 * 
	 * */
	public int insertSelective(CrmProductSellInfo crmProductSellInfo) {
		int intReslut = crmProductSellInfoMapper.insertSelective(crmProductSellInfo);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 更新信息
	 * 
	 * */
	public int deleteByPrimaryKey(CrmProductSellInfo crmProductSellInfo) {
		int id = crmProductSellInfo.getProductsellinfoId();
		int intReslut = crmProductSellInfoMapper.deleteByPrimaryKey(id);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 更新信息
	 * 
	 * */
	public int updateByPrimaryKeySelective(CrmProductSellInfo crmProductSellInfo) {
		int intReslut = crmProductSellInfoMapper.updateByPrimaryKeySelective(crmProductSellInfo);
		return intReslut;
	}
	/**
	 * @author Shinelon
	 * @param CrmProductSellInfo
	 * @exception 根据条件查询信息
	 * 
	 * */
	public List<CrmProductSellInfo> selectCrmProductSellInfoByParameter(CrmProductSellInfo crmProductSellInfo) {
		List<CrmProductSellInfo> crmProductSellInfoList = crmProductSellInfoMapper.selectCrmProductSellInfoByParameter(crmProductSellInfo);
		return crmProductSellInfoList;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查询单条信息
	 * 
	 * */
	public CrmProductSellInfo selectByPrimaryKey(Integer id) {
		CrmProductSellInfo crmProductSellInfo = crmProductSellInfoMapper.selectByPrimaryKey(id);
		return crmProductSellInfo;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查询全部信息
	 * 
	 * */
	public List<CrmProductSellInfo> selectCrmProductSellInfoAll() {
		List<CrmProductSellInfo> crmProductSellInfoList = crmProductSellInfoMapper.selectCrmProductSellInfoAll();
		return crmProductSellInfoList;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 独立站获取分页信息
	 * 
	 * */
	public List<CrmProductSellInfo> selectCrmProductSellInfoByPage() {
		List<CrmProductSellInfo> crmProductSellInfoList = crmProductSellInfoMapper.selectCrmProductSellInfoByPage();
		return crmProductSellInfoList;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 速卖通获取分页信息
	 * 
	 * */
	public List<CrmProductSellInfo> selectCrmProductSellInfoAliExpressByPage() {
		List<CrmProductSellInfo> crmProductSellInfoList = crmProductSellInfoMapper.selectCrmProductSellInfoAliExpressByPage();
		return crmProductSellInfoList;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 按时间查询按sku排序
	 * 
	 * */
	public List<CrmProductSellInfo> selectCrmProductSellInfoByRangeTime(CrmProductSellInfo crmProductSellInfo) {
		List<CrmProductSellInfo> crmProductSellInfoList = crmProductSellInfoMapper.selectCrmProductSellInfoByRangeTime(crmProductSellInfo);
		return crmProductSellInfoList;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查询当天
	 * 
	 * */
	public List<CrmProductSellInfo> selectCrmProductSellInfoByDate(CrmProductSellInfo crmProductSellInfo) {
		List<CrmProductSellInfo> crmProductSellInfoList = crmProductSellInfoMapper.selectCrmProductSellInfoByDate(crmProductSellInfo);
		return crmProductSellInfoList;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 按时间查询按sku排序
	 * 
	 * */
	public List<CrmProductSellInfo> selectCrmProductSellInfoByRangeTimePlatformBrandName(CrmProductSellInfo crmProductSellInfo) {
		List<CrmProductSellInfo> crmProductSellInfoList = crmProductSellInfoMapper.selectCrmProductSellInfoByRangeTimePlatformBrandName(crmProductSellInfo);
		return crmProductSellInfoList;
	}
}
