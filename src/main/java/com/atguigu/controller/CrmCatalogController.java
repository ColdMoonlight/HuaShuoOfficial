package com.atguigu.controller;

import java.util.ArrayList;
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
import com.atguigu.bean.CrmCatalog;
import com.atguigu.common.Msg;
import com.atguigu.service.CrmAdminService;
import com.atguigu.service.CrmCatalogService;
import com.atguigu.utils.DateUtil;

@Controller
@RequestMapping("/CrmCatalog")
public class CrmCatalogController {
	
	@Autowired
	CrmAdminService crmAdminService;
	
	@Autowired
	CrmCatalogService crmCatalogService;
	
	
	/**
	 * 1通过登录账号--查询权限--获取该账号下的菜单
	 * 2add单条菜单信息
	 * 3删除单条菜单信息
	 * 4编辑单条菜单信息
	 * */
	
	/**
	 * 1.0
	 * @author 
	 * @param CrmAdmin
	 * @exception 帐号退出
	 * 20200810
	 * */
	@RequestMapping("/ExitIndex")
	public String exitindex(HttpSession session) throws Exception{
		session.removeAttribute("AdminUser");
		session.invalidate();
		return "back/crmAdminLogin";
	}
	
	/**2.0	20200703
	 * 后台CrmCatalog列表分页list数据
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/getCrmCatalogByAdminId")
	@ResponseBody
	public Msg getCrmCatalogByAdminId(HttpSession session) {
		
		CrmAdmin nowCrmAdmin = (CrmAdmin) session.getAttribute("AdminUser");
		
		List<CrmCatalog> crmCatalogList = new ArrayList<CrmCatalog>();
		
		Integer departmentId = nowCrmAdmin.getAdminDepartmentId();
		if(departmentId==99){
			//这个是超级用户
			crmCatalogList = crmCatalogService.selectCrmCatalogSuper();
		}
		
		List<CrmCatalog> CrmCatalogdownFirst =new ArrayList<CrmCatalog>();
		for(CrmCatalog CrmCatalogOne :crmCatalogList){
			Integer CatalogParentId = CrmCatalogOne.getCatalogParentId();
			if(CatalogParentId>0){
				//System.out.println("CatalogParentId:"+CatalogParentId);
			}else{
				//筛选出一级菜单(patentId=-1)的类，//第一级别的导航
				//存到list中，存一下这些ids,这些是一级类
				CrmCatalogdownFirst.add(CrmCatalogOne);//一级类list;
			}
		}
		
		List<List<CrmCatalog>> CrmCatalogSuperList =new ArrayList<List<CrmCatalog>>();
		for(CrmCatalog CatalogFirstOne :CrmCatalogdownFirst){
			Integer CatalogFirstId = CatalogFirstOne.getCatalogId();
			CrmCatalog CrmCatalogSecReq = new CrmCatalog();
			CrmCatalogSecReq.setCatalogParentId(CatalogFirstId);
			
			List<CrmCatalog> CrmCatalogNowSecondList = crmCatalogService.selectCrmCatalogByParameter(CrmCatalogSecReq);
			//System.out.println("操作说明:客户查询-本二级的菜单完毕Catalog-菜单");
			
			CrmCatalogSuperList.add(CrmCatalogNowSecondList);
		}
			
		return Msg.success().add("CrmCatalogdownFirst", CrmCatalogdownFirst).add("CrmCatalogSuperList", CrmCatalogSuperList);
	}
	
	/**
	 * 2.0
	 * @author 20210810
	 * @param CrmCatalog
	 * @exception 创建新用户
	 * */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public Msg save(HttpServletResponse rep,HttpServletRequest res,HttpSession session,@RequestBody CrmCatalog crmCatalogReg){
		//接收参数信息 
		
		Integer cId = crmCatalogReg.getCatalogId();
		String nowTime = DateUtil.strTime14s();
		crmCatalogReg.setCatalogMotifytime(nowTime);
		if(cId==null){
			crmCatalogReg.setCatalogCreatetime(nowTime);
			crmCatalogService.insertSelective(crmCatalogReg);
			
		}else{
			crmCatalogService.updateByPrimaryKeySelective(crmCatalogReg);
		}
		
		return Msg.success().add("resMsg", "创建成功");
		
	}
	
	/**
	 * 3.0
	 * @author 20210810
	 * @param CrmAdmin
	 * @exception 查看单个用户
	 * */
	@RequestMapping(value="/GetOneCrmCatalogDetail",method=RequestMethod.POST)
	@ResponseBody
	public Msg GetOneCrmCatalogDetail(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmCatalog crmCatalogReg){
		
		//通过id 查询单个用户详情
		CrmCatalog crmCatalogRes = crmCatalogService.selectByPrimaryKey(crmCatalogReg.getCatalogId());
		return Msg.success().add("crmCatalog", crmCatalogRes);
		
	}
	
	/**
	 * 4.0
	 * @author 20210810
	 * @param CrmAdmin
	 * @exception 查看单个用户
	 * */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public Msg delete(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmCatalog crmCatalogReg){
		
		//通过id 查询单个用户详情
		crmCatalogService.deleteByPrimaryKey(crmCatalogReg.getCatalogId());
		return Msg.success().add("resMsg", "删除成功");
		
	}
	
	/**
	 * 4.0
	 * @author 20210810
	 * @param CrmAdmin
	 * @exception 获取下拉菜单
	 * */
//	@RequestMapping(value="/getDownList")
//	@ResponseBody
//	public Msg getDownList(HttpServletResponse rep,HttpServletRequest res,HttpSession session){
//		
//		//通过id 查询单个用户详情
//		crmCatalogService.deleteByPrimaryKey(crmCatalogReg.getCatalogId());
//		return Msg.success().add("resMsg", "创建成功");
//		
//	}
	
}
