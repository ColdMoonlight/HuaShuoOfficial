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
import com.atguigu.common.Const;
import com.atguigu.common.Msg;
import com.atguigu.common.TokenCache;
import com.atguigu.service.CrmAdminService;
import com.atguigu.service.CrmCatalogService;
import com.atguigu.utils.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
	
}
