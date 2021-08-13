package com.atguigu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atguigu.bean.CrmCatalog;
import com.atguigu.dao.CrmCatalogMapper;

@Service
public class CrmCatalogService {
	
	@Autowired
	CrmCatalogMapper crmCatalogMapper;

	/**
	 * @author Shinelon
	 * @param CrmCatalog
	 * @exception 新增单条用户信息
	 * 
	 * */
	public int insertSelective(CrmCatalog crmCatalog) {
		int intReslut = crmCatalogMapper.insertSelective(crmCatalog);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param CrmCatalog
	 * @exception 新增单条用户信息
	 * 
	 * */
	public int deleteByPrimaryKey(Integer catalogId) {
		int intReslut = crmCatalogMapper.deleteByPrimaryKey(catalogId);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 更新用户信息
	 * 
	 * */
	public int updateByPrimaryKeySelective(CrmCatalog crmCatalog) {
		int intReslut = crmCatalogMapper.updateByPrimaryKeySelective(crmCatalog);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查询单条用户信息
	 * 
	 * */
	public CrmCatalog selectByPrimaryKey(Integer id) {
		CrmCatalog crmCatalog = crmCatalogMapper.selectByPrimaryKey(id);
		return crmCatalog;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查询全部用户信息
	 * 
	 * */
	public List<CrmCatalog> selectCrmCatalogInfoAll() {
		List<CrmCatalog> crmCatalogList = crmCatalogMapper.selectCrmCatalogInfoAll();
		return crmCatalogList;
	}
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查询全部用户信息
	 * 
	 * */
	public List<CrmCatalog> selectCrmCatalogSuper() {
		List<CrmCatalog> crmCatalogList = crmCatalogMapper.selectCrmCatalogSuper();
		return crmCatalogList;
	}
	
	/**
	 * @author Shinelon
	 * @param CrmCatalog
	 * @exception 根据条件查询用户信息
	 * 
	 * */
	public List<CrmCatalog> selectCrmCatalogByParameter(CrmCatalog crmCatalog) {
		List<CrmCatalog> crmCatalogList = crmCatalogMapper.selectCrmCatalogByParameter(crmCatalog);
		return crmCatalogList;
	}

	public List<CrmCatalog> selectDownListAll() {
		List<CrmCatalog> crmCatalogList = crmCatalogMapper.selectDownListAll();
		return crmCatalogList;
	}
	/**
	 * @author Shinelon
	 * @param CrmCatalog
	 * @exception 分页查询全部
	 * 
	 * */
	public List<CrmCatalog> selectCrmCatalogByPage() {
		List<CrmCatalog> crmCatalogList = crmCatalogMapper.selectCrmCatalogByPage();
		return crmCatalogList;
	}
	
}
