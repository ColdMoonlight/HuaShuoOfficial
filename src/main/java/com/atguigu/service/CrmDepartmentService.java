package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atguigu.bean.CrmDepartment;
import com.atguigu.dao.CrmDepartmentMapper;

@Service
public class CrmDepartmentService {
	
	@Autowired
	CrmDepartmentMapper crmDepartmentMapper;

	
	/**
	 * @author Shinelon
	 * @param CrmDepartment
	 * @exception 新增单条信息
	 * 
	 * */
	public int insertSelective(CrmDepartment crmDepartment) {
		int intReslut = crmDepartmentMapper.insertSelective(crmDepartment);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 更新信息
	 * 
	 * */
	public int deleteByPrimaryKey(CrmDepartment crmDepartment) {
		int id = crmDepartment.getDepartmentId();
		int intReslut = crmDepartmentMapper.deleteByPrimaryKey(id);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 更新信息
	 * 
	 * */
	public int updateByPrimaryKeySelective(CrmDepartment crmDepartment) {
		int intReslut = crmDepartmentMapper.updateByPrimaryKeySelective(crmDepartment);
		return intReslut;
	}
	/**
	 * @author Shinelon
	 * @param CrmDepartment
	 * @exception 根据条件查询信息
	 * 
	 * */
	public List<CrmDepartment> selectCrmDepartmentByParameter(CrmDepartment crmDepartment) {
		List<CrmDepartment> crmDepartmentList = crmDepartmentMapper.selectCrmDepartmentByParameter(crmDepartment);
		return crmDepartmentList;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查询单条信息
	 * 
	 * */
	public CrmDepartment selectByPrimaryKey(Integer id) {
		CrmDepartment crmDepartment = crmDepartmentMapper.selectByPrimaryKey(id);
		return crmDepartment;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查询全部信息
	 * 
	 * */
	public List<CrmDepartment> selectDepartmentInfoAll() {
		List<CrmDepartment> crmDepartmentList = crmDepartmentMapper.selectDepartmentInfoAll();
		return crmDepartmentList;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 获取分页信息
	 * 
	 * *//*
	public List<CrmDepartment> selectCrmDepartmentByPage() {
		List<CrmDepartment> crmDepartmentList = crmDepartmentMapper.selectCrmDepartmentByPage();
		return crmDepartmentList;
	}*/
	
}
