package com.atguigu.controller;

import java.util.ArrayList;
import java.util.Comparator;
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
import com.atguigu.bean.CrmProductSellInfo;
import com.atguigu.common.Const;
import com.atguigu.common.Msg;
import com.atguigu.service.CrmProductSellInfoService;
import com.atguigu.utils.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;

@Controller
@RequestMapping("/CrmProductSellInfo")
public class CrmProductSellInfoController {
	
	@Autowired
	CrmProductSellInfoService crmProductSellInfoService;
	
	/**
	 * 2.0	20210818
	 * CrmProductSellInfo首页
	 * */
	@RequestMapping("/ToCrmProductSellInfoPage")
	public String toCrmProductSellInfoPage(HttpSession session) throws Exception{
		
		CrmAdmin crmAdmin =(CrmAdmin) session.getAttribute(Const.ADMIN_USER);
		if(crmAdmin==null){
			//SysUsers对象为空
			return "back/crmAdminLogin";
		}else{
			return "back/crmProductSellInfoPage";
		}
	}
	
	/**
	 * 2.0	20210818
	 * CrmProductSellInfo首页
	 * */
	@RequestMapping("/ToCrmProductSellInfoAnalysePage")
	public String toCrmProductSellInfoAnalysePage(HttpSession session) throws Exception{
		
		CrmAdmin crmAdmin =(CrmAdmin) session.getAttribute(Const.ADMIN_USER);
		if(crmAdmin==null){
			//SysUsers对象为空
			return "back/crmAdminLogin";
		}else{
			return "back/crmProductSellInfoAnalysePage";
		}
	}
	/**
	 * 2.0
	 * @author 20210818
	 * @param CrmProductSellInfo
	 * @exception 新增
	 * */
	@RequestMapping(value="/Add",method=RequestMethod.POST)
	@ResponseBody
	public Msg insertSelective(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmProductSellInfo crmProductSellInfoReq){
		//接收参数信息 
		String nowTime = DateUtil.strTime14s();
		crmProductSellInfoReq.setProductsellinfoMotifytime(nowTime);
		crmProductSellInfoService.insertSelective(crmProductSellInfoReq);
		
		if(crmProductSellInfoReq.getProductsellinfoId() != null){
			return Msg.success().add("resMsg", "创建成功");
		}else{
			return Msg.fail().add("resMsg", "系统错误，请联系管理员");
		}
	}
	
	/**
	 * 3.0
	 * @author 20210818
	 * @param CrmProductSellInfo
	 * @exception 删除
	 * */
	@RequestMapping(value="/Delete",method=RequestMethod.POST)
	@ResponseBody
	public Msg delete(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmProductSellInfo crmProductSellInfoReq){
		//接收参数信息 
		crmProductSellInfoService.deleteByPrimaryKey(crmProductSellInfoReq);
		return Msg.success().add("resMsg", "删除成功");
	}
	
	/**
	 * 4.0
	 * @author 20210818
	 * @param CrmProductSellInfo
	 * @exception 更新信息
	 * */
	@RequestMapping(value="/Update",method=RequestMethod.POST)
	@ResponseBody
	public Msg updateByPrimaryKeySelective(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmProductSellInfo crmProductSellInfoReq){
		//接收参数信息 
		String nowTime = DateUtil.strTime14s();
		crmProductSellInfoReq.setProductsellinfoMotifytime(nowTime);
		crmProductSellInfoService.updateByPrimaryKeySelective(crmProductSellInfoReq);
		return Msg.success().add("resMsg", "修改成功");
	}
	
	/**
	 * 5.0
	 * @author 20210818
	 * @param CrmProductSellInfo
	 * @exception 查看单个
	 * */
	@RequestMapping(value="/GetOneProductSellInfoDetailById",method=RequestMethod.POST)
	@ResponseBody
	public Msg getOneProductSellInfoDetailById(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmProductSellInfo crmProductSellInfoReq){
		
		//通过id 查询单个部门详情
		CrmProductSellInfo crmProductSellInfoRes = crmProductSellInfoService.selectByPrimaryKey(crmProductSellInfoReq.getProductsellinfoId());
		return Msg.success().add("crmProductSellInfo", crmProductSellInfoRes);
		
	}
	
	/**2.0	20210818
	 * 后台列表分页list数据
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/GetProductSellInfoByPage")
	@ResponseBody
	public Msg getProductSellInfoByPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session) {

		int PagNum = Const.PAGE_NUM_DEFAULT;
		PageHelper.startPage(pn, PagNum);
		List<CrmProductSellInfo> crmProductSellInfoList = crmProductSellInfoService.selectCrmProductSellInfoByPage();
		PageInfo<CrmProductSellInfo> page = new PageInfo<CrmProductSellInfo>(crmProductSellInfoList, PagNum);
		return Msg.success().add("pageInfo", page);
	}
	
	/**
	 * 6.0
	 * @author 20210818
	 * @param CrmProductSellInfo
	 * @exception 根据条件查询信息
	 * */
	@RequestMapping(value="/GetProductSellInfoByParameterByPage")
	@ResponseBody
	public Msg getProductSellInfoByParameterByPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session,
			@RequestBody CrmProductSellInfo crmProductSellInfoReq){
		
		int PagNum = Const.PAGE_NUM_DEFAULT;
		PageHelper.startPage(pn, PagNum);
		//根据条件查询信息
		List<CrmProductSellInfo> crmProductSellInfoList = crmProductSellInfoService.selectCrmProductSellInfoByParameter(crmProductSellInfoReq);
		PageInfo<CrmProductSellInfo> page = new PageInfo<CrmProductSellInfo>(crmProductSellInfoList, PagNum);
		return Msg.success().add("pageInfo", page);
	}
	
	/**
	 * 6.0
	 * @author 20210818
	 * @param CrmProductSellInfo
	 * @exception 查看全部
	 * */
	@RequestMapping(value="/GetAllProductSellInfo",method=RequestMethod.GET)
	@ResponseBody
	public Msg getAllProductSellInfo(HttpServletResponse rep,HttpServletRequest res,HttpSession session){
		
		//查看全部
		List<CrmProductSellInfo> crmProductSellInfoList = crmProductSellInfoService.selectCrmProductSellInfoAll();
		return Msg.success().add("crmProductSellInfoList", crmProductSellInfoList);
	}
	
	/**
	 * 6.0
	 * @author 20210904
	 * @param CrmProductSellInfo
	 * @exception 按时间查询 
	 * */
	@RequestMapping(value="/GetProductSellInfoByRangeTime",method=RequestMethod.POST)
	@ResponseBody
	public Msg getProductSellInfoByRangeTime(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmProductSellInfo crmProductSellInfoReq){
		
		if(StringUtil.isEmpty(crmProductSellInfoReq.getProductsellinfoProductselltime())){
			return Msg.fail().add("returnMsg", "查询失败，初始时间不能为空");
		}
		
		if(StringUtil.isEmpty(crmProductSellInfoReq.getProductsellinfoMotifytime())){
			return Msg.fail().add("returnMsg", "查询失败，结束时间不能为空");
		}
		
		//按时间范围查询
		CrmProductSellInfo productSellInfoGet = new CrmProductSellInfo();
		productSellInfoGet.setProductsellinfoProductselltime(crmProductSellInfoReq.getProductsellinfoProductselltime());
		productSellInfoGet.setProductsellinfoMotifytime(crmProductSellInfoReq.getProductsellinfoMotifytime());
		List<CrmProductSellInfo> crmProductSellInfoList = crmProductSellInfoService.selectCrmProductSellInfoByRangeTime(productSellInfoGet);
		if(crmProductSellInfoList.size() > 0){
			//将相同sku合并为一个list
			String sku = crmProductSellInfoList.get(0).getProductsellinfoProductsku();
			//最终返回List
			List<List<CrmProductSellInfo>> productSellInfoFinallList = new ArrayList<List<CrmProductSellInfo>>();
			//二级List:相同sku的一个list,不同的sku新建list
			List<CrmProductSellInfo> productSellInfoSameSkuList = new ArrayList<CrmProductSellInfo>();
			for(int i = 0;i < crmProductSellInfoList.size();i++)
			{
				CrmProductSellInfo p = crmProductSellInfoList.get(i);
				if(sku.equals(p.getProductsellinfoProductsku())){
					productSellInfoSameSkuList.add(p);
					
				}else{
					//对上一个skuList进行排序，按时间降叙排序
					productSellInfoSameSkuList.sort(new Comparator<CrmProductSellInfo>(){
						@Override
						public int compare(CrmProductSellInfo o1, CrmProductSellInfo o2) {
							if(StringUtil.isEmpty(o1.getProductsellinfoProductselltime()) || StringUtil.isEmpty(o2.getProductsellinfoProductselltime())){
								return 0;
							}
							return o2.getProductsellinfoProductselltime().compareTo(o1.getProductsellinfoProductselltime());
						}
						
					});
					
					//排序后添加到最终返回的List中
					productSellInfoFinallList.add(productSellInfoSameSkuList);
					//获取新的sku,list,重新进行存储
					sku = p.getProductsellinfoProductsku();
					productSellInfoSameSkuList = new ArrayList<CrmProductSellInfo>();
					productSellInfoSameSkuList.add(p);
				}
				if(i==crmProductSellInfoList.size()-1){
					//最后一个skuList添加到最终返回的List中
					productSellInfoFinallList.add(productSellInfoSameSkuList);
				}
			}
			if(productSellInfoFinallList.size() > 0){
				//将最终返回的List按其中每个list的数量降序排序
				productSellInfoFinallList.sort(new Comparator<List<CrmProductSellInfo>>(){
					@Override
					public int compare(List<CrmProductSellInfo> o1, List<CrmProductSellInfo> o2) {
						return o2.size() - o1.size();
					}
				});
			}
			return Msg.success().add("returnMsg", productSellInfoFinallList);
		}else{
			return Msg.success().add("returnMsg", crmProductSellInfoList);
		}
	}
	/**
	 * 6.0
	 * @author 20210904
	 * @param CrmProductSellInfo
	 * @exception 查询传入数据的当天的sku
	 * */
	@RequestMapping(value="/GetProductSellInfoByDate",method=RequestMethod.POST)
	@ResponseBody
	public Msg getProductSellInfoByDate(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmProductSellInfo crmProductSellInfoReq){
		
		if(StringUtil.isEmpty(crmProductSellInfoReq.getProductsellinfoProductselltime())){
			return Msg.fail().add("returnMsg", "查询失败，时间不能为空");
		}
		//查询当天
		CrmProductSellInfo productSellInfoGet = new CrmProductSellInfo();
		productSellInfoGet.setProductsellinfoProductselltime(crmProductSellInfoReq.getProductsellinfoProductselltime());
		List<CrmProductSellInfo> crmProductSellInfoList = crmProductSellInfoService.selectCrmProductSellInfoByDate(productSellInfoGet);
		if(crmProductSellInfoList.size() > 0){
			//将相同sku合并为一个list
			String sku = crmProductSellInfoList.get(0).getProductsellinfoProductsku();
			//最终返回List
			List<List<CrmProductSellInfo>> productSellInfoFinallList = new ArrayList<List<CrmProductSellInfo>>();
			//二级List:相同sku的一个list,不同的sku新建list
			List<CrmProductSellInfo> productSellInfoSameSkuList = new ArrayList<CrmProductSellInfo>();
			for(int i = 0;i < crmProductSellInfoList.size();i++)
			{
				CrmProductSellInfo p = crmProductSellInfoList.get(i);
				if(sku.equals(p.getProductsellinfoProductsku())){
					productSellInfoSameSkuList.add(p);
					
				}else{
					//对上一个skuList进行排序，按时间降叙排序
					productSellInfoSameSkuList.sort(new Comparator<CrmProductSellInfo>(){
						@Override
						public int compare(CrmProductSellInfo o1, CrmProductSellInfo o2) {
							if(StringUtil.isEmpty(o1.getProductsellinfoProductselltime()) || StringUtil.isEmpty(o2.getProductsellinfoProductselltime())){
								return 0;
							}
							return o2.getProductsellinfoProductselltime().compareTo(o1.getProductsellinfoProductselltime());
						}
						
					});
					
					//排序后添加到最终返回的List中 
					productSellInfoFinallList.add(productSellInfoSameSkuList);
					//获取新的sku,list,重新进行存储
					sku = p.getProductsellinfoProductsku();
					productSellInfoSameSkuList = new ArrayList<CrmProductSellInfo>();
					productSellInfoSameSkuList.add(p);
				}
				if(i==crmProductSellInfoList.size()-1){
					//最后一个skuList添加到最终返回的List中
					productSellInfoFinallList.add(productSellInfoSameSkuList);
				}
			}
			if(productSellInfoFinallList.size() > 0){
				//将最终返回的List按其中每个list的数量降序排序
				productSellInfoFinallList.sort(new Comparator<List<CrmProductSellInfo>>(){
					@Override
					public int compare(List<CrmProductSellInfo> o1, List<CrmProductSellInfo> o2) {
						return o2.size() - o1.size();
					}
				});
			}
			return Msg.success().add("returnMsg", productSellInfoFinallList);
		}else{
			return Msg.success().add("returnMsg", crmProductSellInfoList);
		}
		
	}
}
