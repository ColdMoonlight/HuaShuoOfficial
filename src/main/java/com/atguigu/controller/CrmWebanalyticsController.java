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
import com.atguigu.bean.CrmWebanalytics;
import com.atguigu.common.Const;
import com.atguigu.common.Msg;
import com.atguigu.service.CrmWebanalyticsService;
import com.atguigu.utils.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/CrmWebanalytics")
public class CrmWebanalyticsController {
	
	@Autowired
	CrmWebanalyticsService crmWebanalyticsService;
	
	
	/**
	 * 20210812
	 * CrmWebanalytics 首页
	 * */
	@RequestMapping("/ToCrmWebanalyticsPage")
	public String toCrmWebanalyticsPage(HttpSession session) throws Exception{
		
		CrmAdmin mlbackAdmin =(CrmAdmin) session.getAttribute(Const.ADMIN_USER);
		if(mlbackAdmin==null){
			//SysUsers对象为空
			return "back/crmAdminLogin";
		}else{
			return "back/crmWebanalyticsPage";
		}
	}
	
	/**
	 * 2.0
	 * @author 20210812
	 * @param CrmWebanalytics
	 * @exception 创建新渠道
	 * */
	@RequestMapping(value="/Add",method=RequestMethod.POST)
	@ResponseBody
	public Msg insertSelective(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmWebanalytics crmWebanalyticsReg){
		//接收参数信息 
		String nowTime = DateUtil.strTime14s();
		crmWebanalyticsReg.setWebanalyticsCreatetime(nowTime);
		crmWebanalyticsReg.setWebanalyticsMotifytime(nowTime);
		crmWebanalyticsService.insertSelective(crmWebanalyticsReg);
		
		if(crmWebanalyticsReg.getWebanalyticsId() != null){
			return Msg.success().add("resMsg", "创建成功");
		}else{
			return Msg.fail().add("resMsg", "系统错误，请联系管理员");
		}
	}
	
	/**
	 * 4.0
	 * @author 20210812
	 * @param CrmWebanalytics
	 * @exception 查看单个渠道
	 * */
	@RequestMapping(value="/Delete",method=RequestMethod.POST)
	@ResponseBody
	public Msg delete(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmWebanalytics crmWebanalyticsReg){
		
		//通过id 查询单个用户详情
		crmWebanalyticsService.deleteByPrimaryKey(crmWebanalyticsReg.getWebanalyticsId());
		return Msg.success().add("resMsg", "删除成功");
		
	}
	
	/**
	 * 2.0
	 * @author 20210812
	 * @param CrmWebanalytics
	 * @exception 更新渠道信息
	 * */
	@RequestMapping(value="/Update",method=RequestMethod.POST)
	@ResponseBody
	public Msg updateByPrimaryKeySelective(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmWebanalytics crmWebanalyticsReg){
		//接收参数信息 
		String nowTime = DateUtil.strTime14s();
		crmWebanalyticsReg.setWebanalyticsMotifytime(nowTime);
		crmWebanalyticsService.updateByPrimaryKeySelective(crmWebanalyticsReg);
		return Msg.success().add("resMsg", "修改成功");
	}
	
	/**2.0	20210812
	 * 后台CrmWebanalytics列表分页list数据
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/GetCrmWebanalyticsByPage")
	@ResponseBody
	public Msg getCrmWebanalyticsByPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session) {

		int PagNum = Const.PAGE_NUM_DEFAULT;
		PageHelper.startPage(pn, PagNum);
		List<CrmWebanalytics> crmWebanalyticsList = crmWebanalyticsService.selectCrmWebanalyticsByPage();
		PageInfo page = new PageInfo(crmWebanalyticsList, PagNum);
		return Msg.success().add("pageInfo", page);
	}
	
	/**
	 * 2.0
	 * @author 20210812
	 * @param CrmWebanalytics
	 * @exception 查看单个渠道
	 * */
	@RequestMapping(value="/GetOneCrmWebanalyticsDetailById",method=RequestMethod.POST)
	@ResponseBody
	public Msg getOneCrmWebanalyticsDetailById(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmWebanalytics crmWebanalyticsReg){
		
		//通过id 查询单个渠道详情
		CrmWebanalytics crmWebanalyticsRes = crmWebanalyticsService.selectByPrimaryKey(crmWebanalyticsReg.getWebanalyticsId());
		return Msg.success().add("crmWebanalytics", crmWebanalyticsRes);
		
	}
	
	/**
	 * 2.0
	 * @author 20210812
	 * @param CrmWebanalytics
	 * @exception 按时间查询
	 * */
	@RequestMapping(value="/GetCrmWebanalyticsInfoByRangeTime",method=RequestMethod.POST)
	@ResponseBody
	public Msg getCrmWebanalyticsInfoByRangeTime(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmWebanalytics crmWebanalyticsReg){
		
		//查询全部渠道详情
		List<CrmWebanalytics> crmWebanalyticsList = crmWebanalyticsService.selectCrmWebanalyticsByParameter(crmWebanalyticsReg);
		return Msg.success().add("crmWebanalyticsList", crmWebanalyticsList);
		
	}

}
