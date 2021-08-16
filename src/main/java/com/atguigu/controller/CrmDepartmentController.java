package com.atguigu.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.atguigu.bean.CrmAdmin;
import com.atguigu.bean.CrmDepartment;
import com.atguigu.common.Const;
import com.atguigu.common.Msg;
import com.atguigu.service.CrmDepartmentService;
import com.atguigu.utils.DateUtil;

@Controller
@RequestMapping("/CrmDepartment")
public class CrmDepartmentController {
	
	@Autowired
	CrmDepartmentService crmDepartmentService;
	
	/**
	 * 2.0	20210813
	 * Department首页
	 * */
	@RequestMapping("/ToCrmDepartmentPage")
	public String toCrmDepartmentPage(HttpSession session) throws Exception{
		
		CrmAdmin crmAdmin =(CrmAdmin) session.getAttribute(Const.ADMIN_USER);
		if(crmAdmin==null){
			//SysUsers对象为空
			return "back/crmAdminLogin";
		}else{
			return "back/crmDepartmentPage";
		}
	}
	
	/**
	 * 2.0
	 * @author 20210813
	 * @param CrmDepartment
	 * @exception 创建新部门
	 * */
	@RequestMapping(value="/Add",method=RequestMethod.POST)
	@ResponseBody
	public Msg insertSelective(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmDepartment crmDepartmentReg){
		//接收参数信息 
		String nowTime = DateUtil.strTime14s();
		crmDepartmentReg.setDepartmentCreatetime(nowTime);
		crmDepartmentReg.setDepartmentMotifytime(nowTime);
		crmDepartmentService.insertSelective(crmDepartmentReg);
		
		if(crmDepartmentReg.getDepartmentId() != null){
			return Msg.success().add("resMsg", "创建成功");
		}else{
			return Msg.fail().add("resMsg", "系统错误，请联系管理员");
		}
	}
	
	/**
	 * 3.0
	 * @author 20210813
	 * @param CrmDepartment
	 * @exception 创建新部门
	 * */
	@RequestMapping(value="/Delete",method=RequestMethod.POST)
	@ResponseBody
	public Msg delete(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmDepartment crmDepartmentReg){
		//接收参数信息 
		crmDepartmentService.deleteByPrimaryKey(crmDepartmentReg);
		return Msg.success().add("resMsg", "删除成功");
	}
	
	/**
	 * 4.0
	 * @author 20210813
	 * @param CrmDepartment
	 * @exception 更新部门信息
	 * */
	@RequestMapping(value="/Update",method=RequestMethod.POST)
	@ResponseBody
	public Msg updateByPrimaryKeySelective(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmDepartment crmDepartmentReg){
		//接收参数信息 
		String nowTime = DateUtil.strTime14s();
		crmDepartmentReg.setDepartmentMotifytime(nowTime);
		crmDepartmentService.updateByPrimaryKeySelective(crmDepartmentReg);
		return Msg.success().add("resMsg", "修改成功");
	}
	
	/**
	 * 5.0
	 * @author 20210813
	 * @param CrmDepartment
	 * @exception 查看单个部门
	 * */
	@RequestMapping(value="/GetOneDepartmentDetailById",method=RequestMethod.POST)
	@ResponseBody
	public Msg GetOneDepartmentDetailById(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmDepartment crmDepartmentReg){
		
		//通过id 查询单个部门详情
		CrmDepartment crmDepartmentRes = crmDepartmentService.selectByPrimaryKey(crmDepartmentReg.getDepartmentId());
		return Msg.success().add("crmDepartment", crmDepartmentRes);
		
	}
	
	/**
	 * 6.0
	 * @author 20210813
	 * @param CrmDepartment
	 * @exception 查看全部部门
	 * */
	@RequestMapping(value="/GetAllDepartmentInfo",method=RequestMethod.GET)
	@ResponseBody
	public Msg GetAllDepartmentInfo(HttpServletResponse rep,HttpServletRequest res,HttpSession session){
		
		//通过全部部门详情
		List<CrmDepartment> crmDepartmentList = crmDepartmentService.selectDepartmentInfoAll();
		return Msg.success().add("crmDepartmentList", crmDepartmentList);
	}
	
}
