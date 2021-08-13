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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.atguigu.bean.CrmAdmin;
import com.atguigu.bean.CrmCatalog;
import com.atguigu.common.Const;
import com.atguigu.common.Msg;
import com.atguigu.common.TokenCache;
import com.atguigu.service.CrmAdminService;
import com.atguigu.utils.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/CrmAdmin")
public class CrmAdminController {
	
	@Autowired
	CrmAdminService crmAdminService;
	
	/**
	 * 1.0
	 * @author 
	 * @param CrmAdmin
	 * @exception 帐号退出
	 * 20200810
	 * */
	@RequestMapping("/ExitIndex")
	public String exitindex(HttpSession session) throws Exception{
		session.removeAttribute(Const.ADMIN_USER);
		session.invalidate();
		return "back/crmAdminLogin";
	}
	
	/**
	 * 20210812
	 * admin首页
	 * */
	@RequestMapping("/ToCrmAdminPage")
	public String toCrmAdminPage(HttpSession session) throws Exception{
		
		CrmAdmin mlbackAdmin =(CrmAdmin) session.getAttribute(Const.ADMIN_USER);
		if(mlbackAdmin==null){
			//SysUsers对象为空
			return "back/crmAdminLogin";
		}else{
			return "back/crmAdminPage";
		}
	}
	
	/**
	 * 2.0
	 * @author 20210810
	 * @param CrmAdmin
	 * @exception 创建新用户
	 * */
	@RequestMapping(value="/Add",method=RequestMethod.POST)
	@ResponseBody
	public Msg insertSelective(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmAdmin crmAdminReg){
		//接收参数信息 
		String nowTime = DateUtil.strTime14s();
		crmAdminReg.setAdminCreatetime(nowTime);
		crmAdminReg.setAdminMotifytime(nowTime);
		crmAdminService.insertSelective(crmAdminReg);
		
		if(crmAdminReg.getAdminId() != null){
			return Msg.success().add("resMsg", "创建成功");
		}else{
			return Msg.fail().add("resMsg", "系统错误，请联系管理员");
		}
	}
	
	/**
	 * 2.0
	 * @author 20210810
	 * @param CrmAdmin
	 * @exception 创建新用户
	 * */
	@RequestMapping(value="/Delete",method=RequestMethod.POST)
	@ResponseBody
	public Msg delete(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmAdmin crmAdminReg){
		//接收参数信息 
		String nowTime = DateUtil.strTime14s();
		
		CrmAdmin crmAdminUpdate = new CrmAdmin();
		crmAdminUpdate.setAdminMotifytime(nowTime);
		crmAdminUpdate.setAdminStatus(0);//失效
		crmAdminUpdate.setAdminId(crmAdminReg.getAdminId());
		crmAdminService.updateByPrimaryKeySelective(crmAdminUpdate);
		
		return Msg.success().add("resMsg", "删除成功");
	}
	
	/**
	 * 2.0
	 * @author 20210810
	 * @param CrmAdmin
	 * @exception 更新用户信息
	 * */
	@RequestMapping(value="/Update",method=RequestMethod.POST)
	@ResponseBody
	public Msg updateByPrimaryKeySelective(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmAdmin crmAdminReg){
		//接收参数信息 
		String nowTime = DateUtil.strTime14s();
		crmAdminReg.setAdminMotifytime(nowTime);
		crmAdminService.updateByPrimaryKeySelective(crmAdminReg);
		return Msg.success().add("resMsg", "修改成功");
	}
	
	/**
	 * 2.0
	 * @author 20210810
	 * @param CrmAdmin
	 * @exception 查看单个用户
	 * */
	@RequestMapping(value="/GetOneAdminDetailById",method=RequestMethod.POST)
	@ResponseBody
	public Msg GetOneAdminDetailById(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmAdmin crmAdminReg){
		
		//通过id 查询单个用户详情
		CrmAdmin crmAdminRes = crmAdminService.selectByPrimaryKey(crmAdminReg.getAdminId());
		return Msg.success().add("crmAdmin", crmAdminRes);
		
	}
	
	/**
	 * 2.0
	 * @author 20210810
	 * @param CrmAdmin
	 * @exception 查看全部用户
	 * */
	@RequestMapping(value="/GetAllAdminInfo",method=RequestMethod.GET)
	@ResponseBody
	public Msg GetAllAdminInfo(HttpServletResponse rep,HttpServletRequest res,HttpSession session){
		
		//通过全部用户详情
		List<CrmAdmin> crmAdminList = crmAdminService.selectAdminInfoAll();
		return Msg.success().add("crmAdminList", crmAdminList);
		
	}
	
	/**
	 * 2.0
	 * @author 20210810
	 * @param CrmAdmin
	 * @exception 获取用户分页列表
	 * */
	@RequestMapping(value="/GetAdminByPage",method=RequestMethod.GET)
	@ResponseBody
	public Msg getcrmCatalogByPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session) {

		int PagNum = Const.PAGE_NUM_DEFAULT;
		PageHelper.startPage(pn, PagNum);
		List<CrmAdmin> crmAdminList = crmAdminService.selectCrmAdminByPage();
		PageInfo page = new PageInfo(crmAdminList, PagNum);
		return Msg.success().add("pageInfo", page);
	}
	
	/**
	 * 2.0
	 * @author 20210810
	 * @param CrmAdmin
	 * @exception 管理员帐号登陆
	 * */
	@RequestMapping(value="/CheakAdminUser",method=RequestMethod.POST)
	@ResponseBody
	public Msg checkuser(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmAdmin crmAdminReg){
		//接收参数信息 
		CrmAdmin crmAdminGet = new CrmAdmin();
		crmAdminGet.setAdminAccount(crmAdminReg.getAdminAccount());
		List<CrmAdmin> CrmAdminGetresList = crmAdminService.selectCrmAdminByParameter(crmAdminGet);
		if(!(CrmAdminGetresList.size()>0)){
			return Msg.fail().add("resMsg", "账号不存在");
		}
		crmAdminGet.setAdminPassword(crmAdminReg.getAdminPassword());
		List<CrmAdmin> crmAdminListNameAndPwd = crmAdminService.selectCrmAdminByParameter(crmAdminGet);
		if(crmAdminListNameAndPwd.size()>0){
			//将登陆状态放入session对象
			session.setAttribute(Const.ADMIN_USER, crmAdminListNameAndPwd.get(0));
			System.out.println("CheakAdminUser--CrmAdminGet:"+crmAdminListNameAndPwd.get(0).toString());
			TokenCache.setKey(Const.TOKEN_PREFIX+crmAdminReg.getAdminAccount(), "String");
			
			return Msg.success().add("resMsg", "登陆成功");
		}else{
			return Msg.fail().add("resMsg", "登录失败,密码错误");
		}
	}
	
	
	/**
	 * 3.0
	 * @author 20210810
	 * @param CrmAdmin
	 * @exception 管理员帐号修改密码
	 * 20200429
	 * */
	@RequestMapping(value="/UpdateAdminPassword",method=RequestMethod.POST)
	@ResponseBody
	public Msg updateAdminPassword(HttpServletResponse rep,HttpServletRequest res,HttpSession session,@RequestBody CrmAdmin crmAdminReq){
		//1接收参数
		//2用账户+旧密码查账户(查到,update新密码,没查到,旧密码不对)
		//新密码
		String psdNew = crmAdminReq.getAdminCreatetime().trim();
		
		CrmAdmin crmAdminGet = new CrmAdmin();
		crmAdminGet.setAdminAccount(crmAdminReq.getAdminAccount());
		List<CrmAdmin> crmAdminGetresList = crmAdminService.selectCrmAdminByParameter(crmAdminGet);
		if(!(crmAdminGetresList.size()>0)){
			return Msg.fail().add("resMsg", "账号不存在");
		}
		crmAdminGet.setAdminPassword(crmAdminReq.getAdminPassword());
		List<CrmAdmin> crmAdminListNameAndPwd = crmAdminService.selectCrmAdminByParameter(crmAdminGet);
		if(crmAdminListNameAndPwd.size()>0){
			//修改密码
			if(StringUtils.isEmpty(psdNew)){
				return Msg.success().add("resMsg", "新密码不能为空");
			}
			crmAdminGet.setAdminPassword(psdNew);
			crmAdminGet.setAdminId(crmAdminListNameAndPwd.get(0).getAdminId());
			crmAdminService.updateByPrimaryKeySelective(crmAdminGet);
			
			//获取修改后的用户信息
			crmAdminListNameAndPwd = crmAdminService.selectCrmAdminByParameter(crmAdminGet);
			System.out.println("UpdateAdminUserInfo--CrmAdminGet:" + crmAdminListNameAndPwd.get(0).toString());
			session.setAttribute(Const.ADMIN_USER, crmAdminListNameAndPwd.get(0));
			 
			return Msg.success().add("resMsg", "密码修改成功");
		}else{
			return Msg.fail().add("resMsg", "旧密码错误");
		}
	}

	/**
	 * 4.0
	 * @author 20210810
	 * @param CrmAdmin
	 * @exception adminIfLogin
	 * */
	@RequestMapping(value="/AdminIfLogin",method=RequestMethod.POST)
	@ResponseBody
	public Msg adminIfLogin(HttpServletResponse rep,HttpServletRequest res,HttpSession session){
		
		CrmAdmin CrmAdmin =(CrmAdmin) session.getAttribute(Const.ADMIN_USER);
		if(CrmAdmin!=null){
			System.out.println("CrmAdmin:"+CrmAdmin.toString());
			return Msg.success().add("resMsg", "登陆中"+CrmAdmin.toString());
		}else{
			return Msg.fail().add("resMsg", "无登录信息");
		}
	}
	
}
