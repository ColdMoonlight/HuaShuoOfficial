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
import com.atguigu.bean.CrmShopRoom;
import com.atguigu.common.Const;
import com.atguigu.common.Msg;
import com.atguigu.service.CrmShopRoomService;
import com.atguigu.utils.DateUtil;

@Controller
@RequestMapping("/CrmShopRoom")
public class CrmShopRoomController {
	
	@Autowired
	CrmShopRoomService crmShopRoomService;
	
	/**
	 * 20210813
	 * ShopRoom首页
	 * */
	@RequestMapping("/ToCrmShopRoomPage")
	public String toCrmShopRoomPage(HttpSession session) throws Exception{
		
		CrmAdmin crmAdmin =(CrmAdmin) session.getAttribute(Const.ADMIN_USER);
		if(crmAdmin==null){
			//SysUsers对象为空
			return "back/crmAdminLogin";
		}else{
			return "back/crmShopRoomPage";
		}
	}
	
	/**
	 * 2.0
	 * @author 20210813
	 * @param CrmShopRoom
	 * @exception 创建新店铺
	 * */
	@RequestMapping(value="/Add",method=RequestMethod.POST)
	@ResponseBody
	public Msg insertSelective(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmShopRoom crmShopRoomReg){
		//接收参数信息 
		String nowTime = DateUtil.strTime14s();
		crmShopRoomReg.setShoproomCreatetime(nowTime);
		crmShopRoomReg.setShoproomMotifytime(nowTime);
		crmShopRoomService.insertSelective(crmShopRoomReg);
		
		if(crmShopRoomReg.getShoproomId() != null){
			return Msg.success().add("resMsg", "创建成功");
		}else{
			return Msg.fail().add("resMsg", "系统错误，请联系管理员");
		}
	}
	
	/**
	 * 2.0
	 * @author 20210813
	 * @param CrmShopRoom
	 * @exception 创建新店铺
	 * */
	@RequestMapping(value="/Delete",method=RequestMethod.POST)
	@ResponseBody
	public Msg delete(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmShopRoom crmShopRoomReg){
		//接收参数信息 
		crmShopRoomService.deleteByPrimaryKey(crmShopRoomReg);
		return Msg.success().add("resMsg", "删除成功");
	}
	
	/**
	 * 2.0
	 * @author 20210813
	 * @param CrmShopRoom
	 * @exception 更新店铺信息
	 * */
	@RequestMapping(value="/Update",method=RequestMethod.POST)
	@ResponseBody
	public Msg updateByPrimaryKeySelective(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmShopRoom crmShopRoomReg){
		//接收参数信息 
		String nowTime = DateUtil.strTime14s();
		crmShopRoomReg.setShoproomMotifytime(nowTime);
		crmShopRoomService.updateByPrimaryKeySelective(crmShopRoomReg);
		return Msg.success().add("resMsg", "修改成功");
	}
	
	/**
	 * 2.0
	 * @author 20210813
	 * @param CrmShopRoom
	 * @exception 查看单个店铺
	 * */
	@RequestMapping(value="/GetOneShopRoomDetailById",method=RequestMethod.POST)
	@ResponseBody
	public Msg GetOneShopRoomDetailById(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmShopRoom crmShopRoomReg){
		
		//通过id 查询单个店铺详情
		CrmShopRoom crmShopRoomRes = crmShopRoomService.selectByPrimaryKey(crmShopRoomReg.getShoproomId());
		return Msg.success().add("crmShopRoom", crmShopRoomRes);
		
	}
	
	/**
	 * 2.0
	 * @author 20210813
	 * @param CrmShopRoom
	 * @exception 查看全部店铺
	 * */
	@RequestMapping(value="/GetAllShopRoomInfo",method=RequestMethod.GET)
	@ResponseBody
	public Msg GetAllShopRoomInfo(HttpServletResponse rep,HttpServletRequest res,HttpSession session){
		
		//通过全部店铺详情
		List<CrmShopRoom> crmShopRoomList = crmShopRoomService.selectShopRoomInfoAll();
		return Msg.success().add("crmShopRoomList", crmShopRoomList);
		
	}
	
	/**
	 * 2.0
	 * @author 20210813
	 * @param CrmShopRoom
	 * @exception 获取店铺分页列表
	 * */
	/*@RequestMapping(value="/GetShopRoomByPage",method=RequestMethod.POST)
	@ResponseBody
	public Msg getcrmCatalogByPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session) {

		int PagNum = Const.PAGE_NUM_DEFAULT;
		PageHelper.startPage(pn, PagNum);
		List<CrmShopRoom> crmShopRoomList = crmShopRoomService.selectCrmShopRoomByPage();
		PageInfo page = new PageInfo(crmShopRoomList, PagNum);
		return Msg.success().add("pageInfo", page);
	}*/
}
