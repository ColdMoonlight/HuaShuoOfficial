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
import com.atguigu.bean.CrmAdmin;
import com.atguigu.bean.CrmProductSellEcpp;
import com.atguigu.common.Const;
import com.atguigu.common.Msg;
import com.atguigu.service.CrmProductSellEcppService;
import com.atguigu.utils.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/CrmProductSellEcpp")
public class CrmProductSellEcppController {
	
	@Autowired
	CrmProductSellEcppService crmProductSellEcppService;
	
	/**
	 * 1.0
	 * 20210813
	 * crmProductSellEcppPage首页
	 * */
	@RequestMapping("/ToCrmProductSellEcppPage")
	public String toCrmProductSellEcppPage(HttpSession session) throws Exception{
		
		CrmAdmin crmAdmin =(CrmAdmin) session.getAttribute(Const.ADMIN_USER);
		if(crmAdmin==null){
			//SysUsers对象为空
			return "back/crmAdminLogin";
		}else{
			return "back/crmProductSellEcppPage";
		}
	}
	
	/**
	 * 2.0
	 * @author 20210813
	 * @param CrmProductSellEcpp
	 * 创建新
	 * */
	@RequestMapping(value="/Add",method=RequestMethod.POST)
	@ResponseBody
	public Msg insertSelective(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmProductSellEcpp crmProductSellEcppReq){
		//接收参数信息 
		String nowTime = DateUtil.strTime14s();
		crmProductSellEcppReq.setProductsellecppCreatetime(nowTime);
		crmProductSellEcppReq.setProductsellecppModifytime(nowTime);
		crmProductSellEcppService.insertSelective(crmProductSellEcppReq);
		
		if(crmProductSellEcppReq.getProductsellecppId() != null){
			return Msg.success().add("resMsg", "创建成功");
		}else{
			return Msg.fail().add("resMsg", "系统错误，请联系管理员");
		}
	}
	
	/**
	 * 3.0
	 * @author 20210813
	 * @param CrmProductSellEcpp
	 * 删除信息
	 * */
	@RequestMapping(value="/Delete",method=RequestMethod.POST)
	@ResponseBody
	public Msg delete(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmProductSellEcpp crmProductSellEcppReq){
		//接收参数信息 
		crmProductSellEcppService.deleteByPrimaryKey(crmProductSellEcppReq);
		return Msg.success().add("resMsg", "删除成功");
	}
	
	/**
	 * 4.0
	 * @author 20210813
	 * @param CrmProductSellEcpp
	 * 更新信息
	 * */
	@RequestMapping(value="/Update",method=RequestMethod.POST)
	@ResponseBody
	public Msg updateByPrimaryKeySelective(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmProductSellEcpp crmProductSellEcppReq){
		//接收参数信息 
		String nowTime = DateUtil.strTime14s();
		crmProductSellEcppReq.setProductsellecppModifytime(nowTime);
		crmProductSellEcppService.updateByPrimaryKeySelective(crmProductSellEcppReq);
		return Msg.success().add("resMsg", "修改成功");
	}
	
	/**
	 * 5.0
	 * @author 20210813
	 * @param CrmProductSellEcpp
	 *  查看单个详情
	 * */
	@RequestMapping(value="/GetOneProductSellEcppDetailById",method=RequestMethod.POST)
	@ResponseBody
	public Msg getOneProductSellEcppDetailById(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmProductSellEcpp crmProductSellEcppReq){
		
		//通过id 查询单个店铺详情
		CrmProductSellEcpp crmProductSellEcppRes = crmProductSellEcppService.selectByPrimaryKey(crmProductSellEcppReq.getProductsellecppId());
		return Msg.success().add("crmProductSellEcpp", crmProductSellEcppRes);
		
	}
	
	/**
	 * 6.0
	 * @author 20210813
	 * @param CrmProductSellEcpp
	 * 查询分页信息
	 * */
	@RequestMapping(value="/GetCrmProductSellEcppByPage",method=RequestMethod.POST)
	@ResponseBody
	public Msg getCrmProductSellEcppByPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session){
		
		int PagNum = Const.PAGE_NUM_DEFAULT;
		PageHelper.startPage(pn, PagNum);
		List<CrmProductSellEcpp> crmProductSellEcpp = crmProductSellEcppService.selectCrmProductSellEcppByPage();
		PageInfo<CrmProductSellEcpp> page = new PageInfo<CrmProductSellEcpp>(crmProductSellEcpp, PagNum);
		return Msg.success().add("pageInfo", page);
		
	}
}
