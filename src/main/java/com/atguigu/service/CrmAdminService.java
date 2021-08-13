package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atguigu.bean.CrmAdmin;
import com.atguigu.dao.CrmAdminMapper;

@Service
public class CrmAdminService {
	
	@Autowired
	CrmAdminMapper crmAdminMapper;

	
	/**
	 * @author Shinelon
	 * @param CrmAdmin
	 * @exception 新增单条用户信息
	 * 
	 * */
	public int insertSelective(CrmAdmin crmAdmin) {
		int intReslut = crmAdminMapper.insertSelective(crmAdmin);
		return intReslut;
	}
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 更新用户信息
	 * 
	 * */
	public int updateByPrimaryKeySelective(CrmAdmin crmAdmin) {
		int intReslut = crmAdminMapper.updateByPrimaryKeySelective(crmAdmin);
		return intReslut;
	}
	/**
	 * @author Shinelon
	 * @param CrmAdmin
	 * @exception 根据条件查询用户信息
	 * 
	 * */
	public List<CrmAdmin> selectCrmAdminByParameter(CrmAdmin crmAdmin) {
		List<CrmAdmin> crmAdminList = crmAdminMapper.selectCrmAdminByParameter(crmAdmin);
		return crmAdminList;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查询单条用户信息
	 * 
	 * */
	public CrmAdmin selectByPrimaryKey(Integer id) {
		CrmAdmin crmAdmin = crmAdminMapper.selectByPrimaryKey(id);
		return crmAdmin;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查询全部用户信息
	 * 
	 * */
	public List<CrmAdmin> selectAdminInfoAll() {
		List<CrmAdmin> crmAdminList = crmAdminMapper.selectAdminInfoAll();
		return crmAdminList;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 获取用户分页信息
	 * 
	 * */
	public List<CrmAdmin> selectCrmAdminByPage() {
		List<CrmAdmin> crmAdminList = crmAdminMapper.selectCrmAdminByPage();
		return crmAdminList;
	}
	
}
