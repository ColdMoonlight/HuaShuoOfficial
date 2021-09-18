package com.atguigu.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
import com.atguigu.vo.CrmProductSellInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;

@Controller
@RequestMapping("/CrmProductSellInfo")
public class CrmProductSellInfoController {
	
	@Autowired
	CrmProductSellInfoService crmProductSellInfoService;
	
	/**
	 * 20210818
	 * CrmProductSellInfo页
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
	 * 20210818
	 * crmProductSellInfoAnalysePage页
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
	 * 20210916
	 * 速卖通产品销售情况导入导出
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ToCrmProductSellInfoAliExpressPage")
	public String toCrmProductSellInfoAliExpressPage(HttpSession session) throws Exception{
		
		CrmAdmin crmAdmin =(CrmAdmin) session.getAttribute(Const.ADMIN_USER);
		if(crmAdmin==null){
			//SysUsers对象为空
			return "back/crmAdminLogin";
		}else{
			return "back/crmProductSellInfoAliExpressPage";
		}
	}
	
	/**
	 * 20210916
	 * 速卖通产品销售图表
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ToCrmProductSellInfoAliExpressAnalysePage")
	public String toCrmProductSellInfoAliExpressAnalysePage(HttpSession session) throws Exception{
		
		CrmAdmin crmAdmin =(CrmAdmin) session.getAttribute(Const.ADMIN_USER);
		if(crmAdmin==null){
			//SysUsers对象为空
			return "back/crmAdminLogin";
		}else{
			return "back/crmProductSellInfoAliExpressAnalysePage";
		}
	}
	
	/**
	 * 20210918
	 * 国际站产品销售图表
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ToCrmProductSellInfoAlibabaAnalysePage")
	public String toCrmProductSellInfoAlibabaAnalysePage(HttpSession session) throws Exception{
		
		CrmAdmin crmAdmin =(CrmAdmin) session.getAttribute(Const.ADMIN_USER);
		if(crmAdmin==null){
			//SysUsers对象为空
			return "back/crmAdminLogin";
		}else{
			return "back/crmProductSellInfoAlibabaAnalysePage";
		}
	}
	
	/**
	 * 20210918
	 * 国际站产品销售情况导入导出
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ToCrmProductSellInfoAlibabaPage")
	public String toCrmProductSellInfoAlibabaPage(HttpSession session) throws Exception{
		
		CrmAdmin crmAdmin =(CrmAdmin) session.getAttribute(Const.ADMIN_USER);
		if(crmAdmin==null){
			//SysUsers对象为空
			return "back/crmAdminLogin";
		}else{
			return "back/crmProductSellInfoAlibabaPage";
		}
	}
	
	/**
	 * @author 20210818
	 * 新增
	 * @param CrmProductSellInfo
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
			return Msg.fail().add("resMsg", "系统错误,请联系管理员");
		}
	}
	
	/**
	 * @author 20210818
	 * 删除
	 * @param CrmProductSellInfo
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
	 * @author 20210818
	 *  更新信息
	 * @param CrmProductSellInfo
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
	 * @author 20210818
	 * 查看单个
	 * @param CrmProductSellInfo
	 * */
	@RequestMapping(value="/GetOneProductSellInfoDetailById",method=RequestMethod.POST)
	@ResponseBody
	public Msg getOneProductSellInfoDetailById(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmProductSellInfo crmProductSellInfoReq){
		
		//通过id 查询单个部门详情
		CrmProductSellInfo crmProductSellInfoRes = crmProductSellInfoService.selectByPrimaryKey(crmProductSellInfoReq.getProductsellinfoId());
		return Msg.success().add("crmProductSellInfo", crmProductSellInfoRes);
		
	}
	
	/**
	 * 20210818
	 * 独立站后台列表分页list数据
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
	 * 20210916
	 * 速卖通 后台列表分页list数据
	 * @param pn
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/GetProductSellInfoAliExpressByPage")
	@ResponseBody
	public Msg getProductSellInfoAliExpressByPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session) {

		int PagNum = Const.PAGE_NUM_DEFAULT;
		PageHelper.startPage(pn, PagNum);
		List<CrmProductSellInfo> crmProductSellInfoList = crmProductSellInfoService.selectCrmProductSellInfoAliExpressByPage();
		PageInfo<CrmProductSellInfo> page = new PageInfo<CrmProductSellInfo>(crmProductSellInfoList, PagNum);
		return Msg.success().add("pageInfo", page);
	}
	
	/**
	 * 20210918
	 * 国际站后台列表分页list数据
	 * @param pn
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/GetProductSellInfoAlibabaByPage")
	@ResponseBody
	public Msg getProductSellInfoAlibabaByPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session) {

		int PagNum = Const.PAGE_NUM_DEFAULT;
		PageHelper.startPage(pn, PagNum);
		List<CrmProductSellInfo> crmProductSellInfoList = crmProductSellInfoService.selectCrmProductSellInfoAlibabaByPage();
		PageInfo<CrmProductSellInfo> page = new PageInfo<CrmProductSellInfo>(crmProductSellInfoList, PagNum);
		return Msg.success().add("pageInfo", page);
	}
	
	
	/**
	 * @author 20210818
	 * 根据条件查询信息
	 * @param CrmProductSellInfo
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
	 * @author 20210818
	 * 查看全部
	 * @param CrmProductSellInfo
	 * */
	@RequestMapping(value="/GetAllProductSellInfo",method=RequestMethod.GET)
	@ResponseBody
	public Msg getAllProductSellInfo(HttpServletResponse rep,HttpServletRequest res,HttpSession session){
		
		//查看全部
		List<CrmProductSellInfo> crmProductSellInfoList = crmProductSellInfoService.selectCrmProductSellInfoAll();
		return Msg.success().add("crmProductSellInfoList", crmProductSellInfoList);
	}
	
	/**
	 * @author 20210904
	 *  按时间范围,平台名称,网站名称查询 查询每天的sku
	 * 1,按时间范围,平台名称,网站名称查询,获取数据List,按sku排序
	 * 2,将各个相同sku,添加到一个list中,最终按此list.size排序
	 * @param CrmProductSellInfo
	 * */
	@RequestMapping(value="/GetProductSellInfoByRangeTimePlatformBrandName",method=RequestMethod.POST)
	@ResponseBody
	public Msg getProductSellInfoByRangeTimePlatformBrandName(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmProductSellInfo crmProductSellInfoReq){
		
		if(StringUtil.isEmpty(crmProductSellInfoReq.getProductsellinfoProductselltime())){
			return Msg.fail().add("returnMsg", "查询失败,初始时间不能为空");
		}
		
		if(StringUtil.isEmpty(crmProductSellInfoReq.getProductsellinfoMotifytime())){
			return Msg.fail().add("returnMsg", "查询失败,结束时间不能为空");
		}
		
		//按时间范围查询
		CrmProductSellInfo productSellInfoGet = new CrmProductSellInfo();
		productSellInfoGet.setProductsellinfoProductselltime(crmProductSellInfoReq.getProductsellinfoProductselltime());
		productSellInfoGet.setProductsellinfoMotifytime(crmProductSellInfoReq.getProductsellinfoMotifytime());
		//平台名称
		if(StringUtil.isNotEmpty(crmProductSellInfoReq.getProductsellinfoPlatformName())){
			productSellInfoGet.setProductsellinfoPlatformName(crmProductSellInfoReq.getProductsellinfoPlatformName());
		}
		//网站名称
		if(StringUtil.isNotEmpty(crmProductSellInfoReq.getProductsellinfoBrandname())){
			productSellInfoGet.setProductsellinfoBrandname(crmProductSellInfoReq.getProductsellinfoBrandname());
		}
		List<CrmProductSellInfo> crmProductSellInfoList = crmProductSellInfoService.selectCrmProductSellInfoByRangeTimePlatformBrandName(productSellInfoGet);
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
					//对上一个skuList进行排序,按时间降叙排序
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
	 * @author 20210907
	 * @param CrmProductSellInfo
	 * 按时间范围,平台名称,网站名称查询 查询每天的sku
	 * 1,按时间范围,平台名称,网站名称查询,获取数据List,按销售日期升序排序
	 * 2,获取相同日期的销售数据List--->相同日期内的按sku排序--->获取相同skuList
	 * 3,将各个相同skuList,添加到一个list中(此list为相同日期),此list按list.size排序,只保留数量最多的三个skuList
	 * @throws Exception 
	 * @exception 
	 * */
	@RequestMapping(value="/GetProductSellInfoByDatePlatformBrandName",method=RequestMethod.POST)
	@ResponseBody
	public Msg getProductSellInfoByDatePlatformBrandName(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmProductSellInfo crmProductSellInfoReq) throws Exception{
		
		if(StringUtil.isEmpty(crmProductSellInfoReq.getProductsellinfoProductselltime())){
			return Msg.fail().add("returnMsg", "查询失败,初始时间不能为空");
		}
		
		if(StringUtil.isEmpty(crmProductSellInfoReq.getProductsellinfoMotifytime())){
			return Msg.fail().add("returnMsg", "查询失败,结束时间不能为空");
		}
		
		//查询一段时间内 的数据
		CrmProductSellInfo productSellInfoGet = new CrmProductSellInfo();
		productSellInfoGet.setProductsellinfoProductselltime(crmProductSellInfoReq.getProductsellinfoProductselltime());
		productSellInfoGet.setProductsellinfoMotifytime(crmProductSellInfoReq.getProductsellinfoMotifytime());
		//平台名称
		if(StringUtil.isNotEmpty(crmProductSellInfoReq.getProductsellinfoPlatformName())){
			productSellInfoGet.setProductsellinfoPlatformName(crmProductSellInfoReq.getProductsellinfoPlatformName());
		}
		//网站名称
		if(StringUtil.isNotEmpty(crmProductSellInfoReq.getProductsellinfoBrandname())){
			productSellInfoGet.setProductsellinfoBrandname(crmProductSellInfoReq.getProductsellinfoBrandname());
		}
		List<CrmProductSellInfo> crmProductSellInfoList = crmProductSellInfoService.selectCrmProductSellInfoByRangeTimePlatformBrandName(productSellInfoGet);
		
		//最终返回List
		List<List<List<CrmProductSellInfo>>> productSellInfoFinallList=null;
		if(crmProductSellInfoList.size() > 0){
			//将数据按日期升序排序
			crmProductSellInfoList.sort(new Comparator<CrmProductSellInfo>(){
				@Override
				public int compare(CrmProductSellInfo o1, CrmProductSellInfo o2) {
					if(StringUtil.isEmpty(o1.getProductsellinfoProductselltime()) || StringUtil.isEmpty(o2.getProductsellinfoProductselltime())){
						return 0;
					}
					return o1.getProductsellinfoProductselltime().compareTo(o2.getProductsellinfoProductselltime());
				}
			});
			//将相同日期的合并为一个list
			Date date1 = DateUtil.str2Date(crmProductSellInfoList.get(0).getProductsellinfoProductselltime(), "yyyy-MM-dd");
			
			//最终返回List
			productSellInfoFinallList = new ArrayList<List<List<CrmProductSellInfo>>>();
			//临时list,用来合并相同日期下相同sku
			List<CrmProductSellInfo> productSellInfoTempList = new ArrayList<CrmProductSellInfo>();
			//二级List:相同date的一个list,不同的date新建list
			List<List<CrmProductSellInfo>> productSellInfoDateList  = new ArrayList<List<CrmProductSellInfo>>();
			//相同sku的一个list,不同的sku新建list
			List<CrmProductSellInfo> productSellInfoSameSkuList = new ArrayList<CrmProductSellInfo>();
			for(int i = 0;i < crmProductSellInfoList.size();i++)
			{
				CrmProductSellInfo p = crmProductSellInfoList.get(i);
				Date date2 = DateUtil.str2Date(p.getProductsellinfoProductselltime(), "yyyy-MM-dd");
				
				if(date1.compareTo(date2)==0){
					productSellInfoTempList.add(p);
				}else{
					//对上一个tempList进行排序,按sku降序排序
					productSellInfoTempList.sort(new Comparator<CrmProductSellInfo>(){
						@Override
						public int compare(CrmProductSellInfo o1, CrmProductSellInfo o2) {
							return o2.getProductsellinfoProductsku().compareTo(o1.getProductsellinfoProductsku());
						}
						
					});
					//将相同sku合并为一个list
					String sku = productSellInfoTempList.get(0).getProductsellinfoProductsku();
					//排序后 统计相同日期下相同sku合并为一个list
					for(int j = 0;j < productSellInfoTempList.size();j++){
						if(sku.equals(productSellInfoTempList.get(j).getProductsellinfoProductsku())){
							productSellInfoSameSkuList.add(productSellInfoTempList.get(j));
							
						}else{
							//排序后添加到最终返回的List中
							productSellInfoDateList.add(productSellInfoSameSkuList);
							//获取新的sku,list,重新进行存储
							sku = productSellInfoTempList.get(j).getProductsellinfoProductsku();
							productSellInfoSameSkuList = new ArrayList<CrmProductSellInfo>();
							productSellInfoSameSkuList.add(productSellInfoTempList.get(j));
						}
						if(j==productSellInfoTempList.size()-1){
							//最后一个skuList添加到最终返回的List中
							productSellInfoDateList.add(productSellInfoSameSkuList);
						}
					}
					
					//对上一个dateList进行排序, 按数量进行降序排序
					productSellInfoDateList.sort(new Comparator<List<CrmProductSellInfo>>(){
						@Override
						public int compare(List<CrmProductSellInfo> o1, List<CrmProductSellInfo> o2) {
							return o2.size()-o1.size();
						}
					});
					
					productSellInfoSameSkuList = new ArrayList<CrmProductSellInfo>();
					
					//获取排序后 只获取每个dateList最多的三个返回  添加到最终返回的List中
					List<List<CrmProductSellInfo>> productSellInfoDateListThree =  new ArrayList<List<CrmProductSellInfo>>();
					for(int m=0;m<productSellInfoDateList.size();m++){
						if(m<3){
							productSellInfoDateListThree.add(productSellInfoDateList.get(m));
						}else{
							continue;
						}
					}
					productSellInfoFinallList.add(productSellInfoDateListThree);
					//获取新的sku,list,重新进行存储
					date1 = date2;
					productSellInfoTempList = new ArrayList<CrmProductSellInfo>();
					productSellInfoTempList.add(p);
					productSellInfoDateList = new ArrayList<List<CrmProductSellInfo>>();
				}
				if(i==crmProductSellInfoList.size()-1){
					//最后一个dateList添加到最终返回的List中
					
					//对上一个tempList进行排序,按sku降序排序
					productSellInfoTempList.sort(new Comparator<CrmProductSellInfo>(){
						@Override
						public int compare(CrmProductSellInfo o1, CrmProductSellInfo o2) {
							return o2.getProductsellinfoProductsku().compareTo(o1.getProductsellinfoProductsku());
						}
					});
					//将相同sku合并为一个list
					String sku = productSellInfoTempList.get(0).getProductsellinfoProductsku();
					//排序后 统计相同日期下相同sku合并为一个list
					for(int j = 0;j < productSellInfoTempList.size();j++){
						if(sku.equals(productSellInfoTempList.get(j).getProductsellinfoProductsku())){
							productSellInfoSameSkuList.add(productSellInfoTempList.get(j));
							
						}else{
							//添加到最终返回的List中
							productSellInfoDateList.add(productSellInfoSameSkuList);
							//获取新的sku,list,重新进行存储
							sku = productSellInfoTempList.get(j).getProductsellinfoProductsku();
							productSellInfoSameSkuList = new ArrayList<CrmProductSellInfo>();
							productSellInfoSameSkuList.add(productSellInfoTempList.get(j));
						}
						if(j==productSellInfoTempList.size()-1){
							//最后一个skuList添加到最终返回的List中
							productSellInfoDateList.add(productSellInfoSameSkuList);
						}
					}
					//对上一个dateList进行排序, 按数量进行降序排序
					productSellInfoDateList.sort(new Comparator<List<CrmProductSellInfo>>(){
						@Override
						public int compare(List<CrmProductSellInfo> o1, List<CrmProductSellInfo> o2) {
							return o2.size()-o1.size();
						}
					});
					//获取排序后 只获取每个dateList最多的三个返回  添加到最终返回的List中
					List<List<CrmProductSellInfo>> productSellInfoDateListThree =  new ArrayList<List<CrmProductSellInfo>>();
					for(int m=0;m<productSellInfoDateList.size();m++){
						if(m<3){
							productSellInfoDateListThree.add(productSellInfoDateList.get(m));
						}else{
							continue;
						}
					}
					productSellInfoFinallList.add(productSellInfoDateListThree);
				}
			}
		}
		List<String> productSellInfoFinallDateList = null;
		//获取每天日期
		if(productSellInfoFinallList != null){
			productSellInfoFinallDateList = new ArrayList<String>();
			if(productSellInfoFinallList.size() > 0){
				for(List<List<CrmProductSellInfo>> list :productSellInfoFinallList){
					productSellInfoFinallDateList.add(list.get(0).get(0).getProductsellinfoProductselltime().substring(0,10));
				}
			}
		}
		return Msg.success().add("resMsg","按 时间范围,网站名称,平台名称 查询数据,返回某平台,某网站按天统计相同sku集合,只返回每天三个数量最多sku集合,并返回查询日期集合")
				.add("productSellInfoFinallDateList", productSellInfoFinallDateList)
				.add("returnMsg", productSellInfoFinallList);
		
	}
	
	/**
	 * @author 20210916
	 *  按时间范围,查询所有数据,查询每天的sku
	 * 1,按时间范围查询,获取数据List,按sku排序
	 * 2,将各个相同sku,添加到一个list中,最终按此list.size排序
	 * @param CrmProductSellInfo
	 * */
	@RequestMapping(value="/GetProductSellInfoAllByRangeTime",method=RequestMethod.POST)
	@ResponseBody
	public Msg getProductSellInfoAllByRangeTime(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmProductSellInfo crmProductSellInfoReq){
		
		if(StringUtil.isEmpty(crmProductSellInfoReq.getProductsellinfoProductselltime())){
			return Msg.fail().add("returnMsg", "查询失败,初始时间不能为空");
		}
		
		if(StringUtil.isEmpty(crmProductSellInfoReq.getProductsellinfoMotifytime())){
			return Msg.fail().add("returnMsg", "查询失败,结束时间不能为空");
		}
		
		//按时间范围查询
		CrmProductSellInfo productSellInfoGet = new CrmProductSellInfo();
		productSellInfoGet.setProductsellinfoProductselltime(crmProductSellInfoReq.getProductsellinfoProductselltime());
		productSellInfoGet.setProductsellinfoMotifytime(crmProductSellInfoReq.getProductsellinfoMotifytime());
		List<CrmProductSellInfo> crmProductSellInfoList = crmProductSellInfoService.selectCrmProductSellInfoAllByRangeTime(productSellInfoGet);
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
					//对上一个skuList进行排序,按时间降叙排序
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
	 * @author 20210916
	 * @param CrmProductSellInfo
	 * 按时间范围查询(不分平台、网站),查询每天的sku
	 * 1,按时间范围(不分平台、网站)查询,获取数据List,按销售日期升序排序
	 * 2,获取相同日期的销售数据List--->相同日期内的按sku排序--->获取相同skuList
	 * 3,将各个相同skuList,添加到一个list中(此list为相同日期),此list按list.size排序,只保留数量最多的三个skuList
	 * @throws Exception 
	 * @exception 
	 * */
	@RequestMapping(value="/GetProductSellInfoAllByDate",method=RequestMethod.POST)
	@ResponseBody
	public Msg getProductSellInfoAllByDate(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmProductSellInfo crmProductSellInfoReq) throws Exception{
		
		if(StringUtil.isEmpty(crmProductSellInfoReq.getProductsellinfoProductselltime())){
			return Msg.fail().add("returnMsg", "查询失败,初始时间不能为空");
		}
		
		if(StringUtil.isEmpty(crmProductSellInfoReq.getProductsellinfoMotifytime())){
			return Msg.fail().add("returnMsg", "查询失败,结束时间不能为空");
		}
		
		//查询一段时间内 的数据
		CrmProductSellInfo productSellInfoGet = new CrmProductSellInfo();
		productSellInfoGet.setProductsellinfoProductselltime(crmProductSellInfoReq.getProductsellinfoProductselltime());
		productSellInfoGet.setProductsellinfoMotifytime(crmProductSellInfoReq.getProductsellinfoMotifytime());
		List<CrmProductSellInfo> crmProductSellInfoList = crmProductSellInfoService.selectCrmProductSellInfoAllByRangeTime(productSellInfoGet);
		
		//最终返回List
		List<List<List<CrmProductSellInfo>>> productSellInfoFinallList=null;
		if(crmProductSellInfoList.size() > 0){
			//将数据按日期升序排序
			crmProductSellInfoList.sort(new Comparator<CrmProductSellInfo>(){
				@Override
				public int compare(CrmProductSellInfo o1, CrmProductSellInfo o2) {
					if(StringUtil.isEmpty(o1.getProductsellinfoProductselltime()) || StringUtil.isEmpty(o2.getProductsellinfoProductselltime())){
						return 0;
					}
					return o1.getProductsellinfoProductselltime().compareTo(o2.getProductsellinfoProductselltime());
				}
			});
			//将相同日期的合并为一个list
			Date date1 = DateUtil.str2Date(crmProductSellInfoList.get(0).getProductsellinfoProductselltime(), "yyyy-MM-dd");
			
			//最终返回List
			productSellInfoFinallList = new ArrayList<List<List<CrmProductSellInfo>>>();
			//临时list,用来合并相同日期下相同sku
			List<CrmProductSellInfo> productSellInfoTempList = new ArrayList<CrmProductSellInfo>();
			//二级List:相同date的一个list,不同的date新建list
			List<List<CrmProductSellInfo>> productSellInfoDateList  = new ArrayList<List<CrmProductSellInfo>>();
			//相同sku的一个list,不同的sku新建list
			List<CrmProductSellInfo> productSellInfoSameSkuList = new ArrayList<CrmProductSellInfo>();
			for(int i = 0;i < crmProductSellInfoList.size();i++)
			{
				CrmProductSellInfo p = crmProductSellInfoList.get(i);
				Date date2 = DateUtil.str2Date(p.getProductsellinfoProductselltime(), "yyyy-MM-dd");
				
				if(date1.compareTo(date2)==0){
					productSellInfoTempList.add(p);
				}else{
					//对上一个tempList进行排序,按sku降序排序
					productSellInfoTempList.sort(new Comparator<CrmProductSellInfo>(){
						@Override
						public int compare(CrmProductSellInfo o1, CrmProductSellInfo o2) {
							return o2.getProductsellinfoProductsku().compareTo(o1.getProductsellinfoProductsku());
						}
						
					});
					//将相同sku合并为一个list
					String sku = productSellInfoTempList.get(0).getProductsellinfoProductsku();
					//排序后 统计相同日期下相同sku合并为一个list
					for(int j = 0;j < productSellInfoTempList.size();j++){
						if(sku.equals(productSellInfoTempList.get(j).getProductsellinfoProductsku())){
							productSellInfoSameSkuList.add(productSellInfoTempList.get(j));
							
						}else{
							//排序后添加到最终返回的List中
							productSellInfoDateList.add(productSellInfoSameSkuList);
							//获取新的sku,list,重新进行存储
							sku = productSellInfoTempList.get(j).getProductsellinfoProductsku();
							productSellInfoSameSkuList = new ArrayList<CrmProductSellInfo>();
							productSellInfoSameSkuList.add(productSellInfoTempList.get(j));
						}
						if(j==productSellInfoTempList.size()-1){
							//最后一个skuList添加到最终返回的List中
							productSellInfoDateList.add(productSellInfoSameSkuList);
						}
					}
					
					//对上一个dateList进行排序, 按数量进行降序排序
					productSellInfoDateList.sort(new Comparator<List<CrmProductSellInfo>>(){
						@Override
						public int compare(List<CrmProductSellInfo> o1, List<CrmProductSellInfo> o2) {
							return o2.size()-o1.size();
						}
					});
					
					productSellInfoSameSkuList = new ArrayList<CrmProductSellInfo>();
					
					//获取排序后 只获取每个dateList最多的三个返回  添加到最终返回的List中
					List<List<CrmProductSellInfo>> productSellInfoDateListThree =  new ArrayList<List<CrmProductSellInfo>>();
					for(int m=0;m<productSellInfoDateList.size();m++){
						if(m<3){
							productSellInfoDateListThree.add(productSellInfoDateList.get(m));
						}else{
							continue;
						}
					}
					productSellInfoFinallList.add(productSellInfoDateListThree);
					//获取新的sku,list,重新进行存储
					date1 = date2;
					productSellInfoTempList = new ArrayList<CrmProductSellInfo>();
					productSellInfoTempList.add(p);
					productSellInfoDateList = new ArrayList<List<CrmProductSellInfo>>();
				}
				if(i==crmProductSellInfoList.size()-1){
					//最后一个dateList添加到最终返回的List中
					
					//对上一个tempList进行排序,按sku降序排序
					productSellInfoTempList.sort(new Comparator<CrmProductSellInfo>(){
						@Override
						public int compare(CrmProductSellInfo o1, CrmProductSellInfo o2) {
							return o2.getProductsellinfoProductsku().compareTo(o1.getProductsellinfoProductsku());
						}
					});
					//将相同sku合并为一个list
					String sku = productSellInfoTempList.get(0).getProductsellinfoProductsku();
					//排序后 统计相同日期下相同sku合并为一个list
					for(int j = 0;j < productSellInfoTempList.size();j++){
						if(sku.equals(productSellInfoTempList.get(j).getProductsellinfoProductsku())){
							productSellInfoSameSkuList.add(productSellInfoTempList.get(j));
							
						}else{
							//添加到最终返回的List中
							productSellInfoDateList.add(productSellInfoSameSkuList);
							//获取新的sku,list,重新进行存储
							sku = productSellInfoTempList.get(j).getProductsellinfoProductsku();
							productSellInfoSameSkuList = new ArrayList<CrmProductSellInfo>();
							productSellInfoSameSkuList.add(productSellInfoTempList.get(j));
						}
						if(j==productSellInfoTempList.size()-1){
							//最后一个skuList添加到最终返回的List中
							productSellInfoDateList.add(productSellInfoSameSkuList);
						}
					}
					//对上一个dateList进行排序, 按数量进行降序排序
					productSellInfoDateList.sort(new Comparator<List<CrmProductSellInfo>>(){
						@Override
						public int compare(List<CrmProductSellInfo> o1, List<CrmProductSellInfo> o2) {
							return o2.size()-o1.size();
						}
					});
					//获取排序后 只获取每个dateList最多的三个返回  添加到最终返回的List中
					List<List<CrmProductSellInfo>> productSellInfoDateListThree =  new ArrayList<List<CrmProductSellInfo>>();
					for(int m=0;m<productSellInfoDateList.size();m++){
						if(m<3){
							productSellInfoDateListThree.add(productSellInfoDateList.get(m));
						}else{
							continue;
						}
					}
					productSellInfoFinallList.add(productSellInfoDateListThree);
				}
			}
		}
		List<String> productSellInfoFinallDateList = null;
		//获取每天日期
		if(productSellInfoFinallList != null){
			productSellInfoFinallDateList = new ArrayList<String>();
			if(productSellInfoFinallList.size() > 0){
				for(List<List<CrmProductSellInfo>> list :productSellInfoFinallList){
					productSellInfoFinallDateList.add(list.get(0).get(0).getProductsellinfoProductselltime().substring(0,10));
				}
			}
		}
		return Msg.success().add("resMsg","按 时间范围 查询数据(不分平台网站),返回按天统计相同sku集合,只返回每天三个数量最多sku集合,并返回查询日期集合")
				.add("productSellInfoFinallDateList", productSellInfoFinallDateList)
				.add("returnMsg", productSellInfoFinallList);
		
	}
	
	/**
	 * @author 20210917
	 * 按时间范围,查询所有数据,查询每天的sku
	 * 1,按时间范围查询,获取数据List,按sku排序
	 * 2,将各个相同sku,添加到一个list中,最终按此list.size排序,只返回查询指定字段
	 * @param rep
	 * @param res
	 * @param session
	 * @param crmProductSellInfoReq
	 * @return
	 */
	@RequestMapping(value="/GetAllProductSellInfoByRangeTime",method=RequestMethod.POST)
	@ResponseBody
	public Msg getProductSellInfoByRangeTimeAll(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmProductSellInfo crmProductSellInfoReq){
		
		if(StringUtil.isEmpty(crmProductSellInfoReq.getProductsellinfoProductselltime())){
			return Msg.fail().add("returnMsg", "查询失败,初始时间不能为空");
		}
		
		if(StringUtil.isEmpty(crmProductSellInfoReq.getProductsellinfoMotifytime())){
			return Msg.fail().add("returnMsg", "查询失败,结束时间不能为空");
		}
		
		//按时间范围查询
		CrmProductSellInfo productSellInfoGet = new CrmProductSellInfo();
		productSellInfoGet.setProductsellinfoProductselltime(crmProductSellInfoReq.getProductsellinfoProductselltime());
		productSellInfoGet.setProductsellinfoMotifytime(crmProductSellInfoReq.getProductsellinfoMotifytime());
		List<Map<String,Object>> crmProductSellInfoList = crmProductSellInfoService.selectAllCrmProductSellInfoByRangeTime(productSellInfoGet);
		if(crmProductSellInfoList.size() > 0){
			//最终返回List
			List<List<Map<String,Object>>> productSellInfoFinallList = new ArrayList<List<Map<String,Object>>>();
			//将相同sku合并为一个list
			String sku = crmProductSellInfoList.get(0).get("productsellinfoProductsku").toString();
			//二级List:相同sku的一个list,不同的sku新建list
			List<Map<String,Object>> productSellInfoSameSkuList = new ArrayList<Map<String,Object>>();
			for(int i = 0;i < crmProductSellInfoList.size();i++){
				String sku2 = crmProductSellInfoList.get(i).get("productsellinfoProductsku").toString();
				if(sku.equals(sku2)){
					productSellInfoSameSkuList.add(crmProductSellInfoList.get(i));
				}else{
					productSellInfoSameSkuList.sort(new Comparator<Map<String,Object>>(){
						@Override
						public int compare(Map<String, Object> o1, Map<String, Object> o2) {
							if(StringUtil.isEmpty(o1.get("productsellinfoProductselltime").toString()) || StringUtil.isEmpty(o2.get("productsellinfoProductselltime").toString())){
								return 0;
							}
							return o2.get("productsellinfoProductselltime").toString().compareTo(o1.get("productsellinfoProductselltime").toString());
						}
					});
					//排序后添加到最终返回的List中
					productSellInfoFinallList.add(productSellInfoSameSkuList);
					//获取新的sku,list,重新进行存储
					sku = sku2;
					productSellInfoSameSkuList = new ArrayList<Map<String,Object>>();
					productSellInfoSameSkuList.add(crmProductSellInfoList.get(i));
				}
				if(i==crmProductSellInfoList.size()-1){
					//最后一个skuList添加到最终返回的List中
					productSellInfoFinallList.add(productSellInfoSameSkuList);
				}
			}
			if(productSellInfoFinallList.size() > 0){
				//将最终返回的List按其中每个list的数量降序排序
				productSellInfoFinallList.sort(new Comparator<List<Map<String,Object>>>(){
					@Override
					public int compare(List<Map<String,Object>> o1, List<Map<String,Object>> o2) {
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
	 * @author 20210904
	 *  按时间范围,平台名称,网站名称查询 查询每天的sku
	 * 1,按时间范围,平台名称,网站名称查询,获取数据List,按sku排序
	 * 2,将各个相同sku,添加到一个list中,最终按此list.size排序
	 * @param CrmProductSellInfo
	 * */
	@RequestMapping(value="/GetProductSellInfoVoByRangeTimePlatformBrandName",method=RequestMethod.POST)
	@ResponseBody
	public Msg getProductSellInfoVoByRangeTimePlatformBrandName(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmProductSellInfo crmProductSellInfoReq){
		
		if(StringUtil.isEmpty(crmProductSellInfoReq.getProductsellinfoProductselltime())){
			return Msg.fail().add("returnMsg", "查询失败,初始时间不能为空");
		}
		
		if(StringUtil.isEmpty(crmProductSellInfoReq.getProductsellinfoMotifytime())){
			return Msg.fail().add("returnMsg", "查询失败,结束时间不能为空");
		}
		
		//按时间范围查询
		CrmProductSellInfo productSellInfoGet = new CrmProductSellInfo();
		productSellInfoGet.setProductsellinfoProductselltime(crmProductSellInfoReq.getProductsellinfoProductselltime());
		productSellInfoGet.setProductsellinfoMotifytime(crmProductSellInfoReq.getProductsellinfoMotifytime());
		//平台名称
		if(StringUtil.isNotEmpty(crmProductSellInfoReq.getProductsellinfoPlatformName())){
			productSellInfoGet.setProductsellinfoPlatformName(crmProductSellInfoReq.getProductsellinfoPlatformName());
		}
		//网站名称
		if(StringUtil.isNotEmpty(crmProductSellInfoReq.getProductsellinfoBrandname())){
			productSellInfoGet.setProductsellinfoBrandname(crmProductSellInfoReq.getProductsellinfoBrandname());
		}
		List<CrmProductSellInfoVo> crmProductSellInfoList = crmProductSellInfoService.selectCrmProductSellInfoVoByRangeTimePlatformBrandName(productSellInfoGet);
		if(crmProductSellInfoList.size() > 0){
			//将相同sku合并为一个list
			String sku = crmProductSellInfoList.get(0).getProductsellinfoProductsku();
			//最终返回List
			List<List<CrmProductSellInfoVo>> productSellInfoFinallList = new ArrayList<List<CrmProductSellInfoVo>>();
			//二级List:相同sku的一个list,不同的sku新建list
			List<CrmProductSellInfoVo> productSellInfoSameSkuList = new ArrayList<CrmProductSellInfoVo>();
			for(int i = 0;i < crmProductSellInfoList.size();i++)
			{
				CrmProductSellInfoVo p = crmProductSellInfoList.get(i);
				if(sku.equals(p.getProductsellinfoProductsku())){
					productSellInfoSameSkuList.add(p);
					
				}else{
					//对上一个skuList进行排序,按时间降叙排序
					productSellInfoSameSkuList.sort(new Comparator<CrmProductSellInfoVo>(){
						@Override
						public int compare(CrmProductSellInfoVo o1, CrmProductSellInfoVo o2) {
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
					productSellInfoSameSkuList = new ArrayList<CrmProductSellInfoVo>();
					productSellInfoSameSkuList.add(p);
				}
				if(i==crmProductSellInfoList.size()-1){
					//最后一个skuList添加到最终返回的List中
					productSellInfoFinallList.add(productSellInfoSameSkuList);
				}
			}
			if(productSellInfoFinallList.size() > 0){
				//将最终返回的List按其中每个list的数量降序排序
				productSellInfoFinallList.sort(new Comparator<List<CrmProductSellInfoVo>>(){
					@Override
					public int compare(List<CrmProductSellInfoVo> o1, List<CrmProductSellInfoVo> o2) {
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
