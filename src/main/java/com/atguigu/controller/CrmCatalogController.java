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
			crmCatalogList = crmCatalogService.selectCrmCatalogGetAll();
		}
		
		return Msg.success().add("crmCatalogList", crmCatalogList);
	}
	
	/**3.0	20200703
	 * CrmCatalog	save
	 * @param CrmCatalog
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public Msg initializaCrmCatalog(HttpServletResponse rep,HttpServletRequest res,CrmCatalog CrmCatalog){
		
		
		Integer catalogId = CrmCatalog.getCatalogId();
		String nowTime = DateUtil.strTime14s();
		CrmCatalog.setCatalogMotifytime(nowTime);
		if(catalogId!=null){
			//老数据,走更新
			crmCatalogService.updateByPrimaryKeySelective(CrmCatalog);
		}else{
			//新数据,走插入
			CrmCatalog.setCatalogCreatetime(nowTime);
			crmCatalogService.insertSelective(CrmCatalog);
		}
		
		CrmCatalog.setCatalogStatus(0);//0未上架1上架中
		return Msg.success().add("resMsg", "Catalog保存成功").add("CrmCatalog", CrmCatalog);
	}
	
	/**4.0	20200703
	 * CrmCatalog	update
	 * @param CrmCatalog
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveSelective(HttpServletResponse rep,HttpServletRequest res,@RequestBody CrmCatalog CrmCatalog){
		//接受参数信息
		//获取类名
		String CatalogName = CrmCatalog.getCatalogName();
		//获取归属类名
		Integer CatalogParentId = CrmCatalog.getCatalogParentId();
		CrmCatalog CrmCatalogParentNameReq = new CrmCatalog();
		CrmCatalogParentNameReq.setCatalogId(CatalogParentId);
		List<CrmCatalog> CrmCatalogList = crmCatalogService.selectCrmCatalog(CrmCatalogParentNameReq);
		String CatalogParentName="";
		String CatalogDesc="";
		if(CrmCatalogList.size()>0){
			CrmCatalog CrmCatalogParentNameRes = CrmCatalogList.get(0);
			CatalogParentName = CrmCatalogParentNameRes.getCatalogName();
			CatalogDesc = CrmCatalogParentNameRes.getCatalogDesc();
		}else{
			CatalogParentName ="---none---";
		}
		//判断归属是否为none
		if(CatalogParentName.equals("---none---")){
			CrmCatalog.setCatalogDesc(CatalogName);
		}else{
			CrmCatalog.setCatalogDesc(CatalogDesc+">"+CatalogName);
		}
		String nowTime = DateUtil.strTime14s();
		CrmCatalog.setCatalogMotifytime(nowTime);
		CrmCatalog.setCatalogParentName(CatalogParentName);
		
		return Msg.success().add("resMsg", "Catalog保存成功");
	}
	
	/**5.0	20200703
	 * CrmCatalog	delete
	 * @param CrmCatalog-CatalogId
	 * @return 
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public Msg delete(@RequestBody CrmCatalog CrmCatalog){
		//接收id信息
		int CatalogIdInt = CrmCatalog.getCatalogId();
		crmCatalogService.deleteByPrimaryKey(CatalogIdInt);
		return Msg.success().add("resMsg", "Catalog delete  success");
	}
	
	/**
	 * 6.0	20200703
	 * 查单条CrmCatalog详情
	 * @param CrmCatalog-CatalogId
	 * @return 
	 */
	@RequestMapping(value="/getOneCrmCatalogDetail",method=RequestMethod.POST)
	@ResponseBody
	public Msg getOneCrmCatalogDetail(@RequestBody CrmCatalog CrmCatalog){
		
		//接受CatalogId
		Integer CatalogId = CrmCatalog.getCatalogId();
		CrmCatalog CrmCatalogReq = new CrmCatalog();
		CrmCatalogReq.setCatalogId(CatalogId);
		//查询本条
		List<CrmCatalog> CrmCatalogResList =crmCatalogService.selectCrmCatalog(CrmCatalogReq);
		CrmCatalog CrmCatalogOne =CrmCatalogResList.get(0);
		return Msg.success().add("resMsg", "查CatalogOne完毕").add("CrmCatalogOne", CrmCatalogOne);
	}
	
	
	
}
