package com.atguigu.controller;

import java.math.BigDecimal;
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
	   * 20210812
	   * CrmWebanalytics 首页
	   * */
	  @RequestMapping("/ToCrmWebanalyticsDetailPage")
	  public String ToCrmWebanalyticsDetailPage(HttpSession session) throws Exception{
	    
	    CrmAdmin mlbackAdmin =(CrmAdmin) session.getAttribute(Const.ADMIN_USER);
	    if(mlbackAdmin==null){
	      //SysUsers对象为空
	      return "back/crmAdminLogin";
	    }else{
	      return "back/crmWebanalyticsDetailPage";
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
		//crmWebanalyticsReg.setWebanalyticsCreatetime(nowTime);
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
	
	/**
	 * 2.0
	 * @author 20210812
	 * @param CrmWebanalytics
	 * @exception 按时间查询
	 * */
	@RequestMapping(value="/GetCrmWebanalyticsInfoByRangeTimeAndBrand",method=RequestMethod.POST)
	@ResponseBody
	public Msg GetCrmWebanalyticsInfoByRangeTimeAndBrand(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmWebanalytics crmWebanalyticsReq){
		
		//选查询渠道总数
		String BrandName = crmWebanalyticsReq.getWebanalyticsBrandname();
		
		CrmWebanalytics crmWebanalyticsBrand = new CrmWebanalytics();
		crmWebanalyticsBrand.setWebanalyticsBrandname(BrandName);
		
		List<CrmWebanalytics> crmWebanalyticsBrandList = crmWebanalyticsService.selectCrmWebanalyticsByBrand(crmWebanalyticsBrand);
		
		/**
		 * 
		 * 准备遍历,
		 * 取出品牌名，网站名，时间参数，查询全部，
		 * */
		List<CrmWebanalytics> CrmWebanalyticsAllList =new ArrayList<CrmWebanalytics>();
		for(CrmWebanalytics crmWebanalyticsOne:crmWebanalyticsBrandList){
			CrmWebanalytics crmWebanalyticsOneRes = new CrmWebanalytics();
			String brandnameOne="";
			String channelnameOne="";
			brandnameOne= crmWebanalyticsOne.getWebanalyticsBrandname();
			channelnameOne = crmWebanalyticsOne.getWebanalyticsChannelname();
			
			crmWebanalyticsOneRes.setWebanalyticsBrandname(brandnameOne);
			crmWebanalyticsOneRes.setWebanalyticsChannelname(channelnameOne);
			crmWebanalyticsOneRes.setWebanalyticsCreatetime(crmWebanalyticsReq.getWebanalyticsCreatetime());
			crmWebanalyticsOneRes.setWebanalyticsMotifytime(crmWebanalyticsReq.getWebanalyticsMotifytime());
			List<CrmWebanalytics> crmWebanalyticsOneBrandAndChannelList = crmWebanalyticsService.selectCrmWebanalyticsByParameter(crmWebanalyticsOneRes);
			if(crmWebanalyticsOneBrandAndChannelList.size()>0){
				
				BigDecimal webanalyticsChannelinvestmoney = new BigDecimal(0.00);
				Integer webanalyticsChannelintousernum = 0;
				Integer webanalyticsChannelintousernewnum = 0;
				Integer webanalyticsChannelflowlnum = 0;
				Integer webanalyticsChannelsellnum = 0;
				BigDecimal webanalyticsChannelsellmoney = new BigDecimal(0.00);
				for(CrmWebanalytics CrmWebanalyticsaa :crmWebanalyticsOneBrandAndChannelList){
					
					webanalyticsChannelinvestmoney = webanalyticsChannelinvestmoney.add(CrmWebanalyticsaa.getWebanalyticsChannelinvestmoney());
					webanalyticsChannelintousernum = webanalyticsChannelintousernum+CrmWebanalyticsaa.getWebanalyticsChannelintousernum();
					webanalyticsChannelintousernewnum = webanalyticsChannelintousernewnum+CrmWebanalyticsaa.getWebanalyticsChannelintousernewnum();
					webanalyticsChannelflowlnum = webanalyticsChannelflowlnum+CrmWebanalyticsaa.getWebanalyticsChannelflowlnum();
					webanalyticsChannelsellnum = webanalyticsChannelsellnum+CrmWebanalyticsaa.getWebanalyticsChannelsellnum();
					webanalyticsChannelsellmoney = webanalyticsChannelsellmoney.add(CrmWebanalyticsaa.getWebanalyticsChannelsellmoney());
					
				}
				crmWebanalyticsOneRes.setWebanalyticsChannelinvestmoney(webanalyticsChannelinvestmoney);
				crmWebanalyticsOneRes.setWebanalyticsChannelintousernum(webanalyticsChannelintousernum);
				crmWebanalyticsOneRes.setWebanalyticsChannelintousernewnum(webanalyticsChannelintousernewnum);
				crmWebanalyticsOneRes.setWebanalyticsChannelflowlnum(webanalyticsChannelflowlnum);
				crmWebanalyticsOneRes.setWebanalyticsChannelsellnum(webanalyticsChannelsellnum);
				crmWebanalyticsOneRes.setWebanalyticsChannelsellmoney(webanalyticsChannelsellmoney);
				
				System.out.println(crmWebanalyticsOneRes.toString());
				CrmWebanalyticsAllList.add(crmWebanalyticsOneRes);
				
			}
		}

		//查询全部渠道详情
		return Msg.success().add("crmWebanalyticsBrandList", crmWebanalyticsBrandList).add("CrmWebanalyticsAllList", CrmWebanalyticsAllList);
		
	}
	
	/**
	 * 2.0
	 * @author 20210908
	 * @param CrmWebanalytics
	 * @exception 按时间查询
	 * */
	@RequestMapping(value="/GetCrmWebanalyticsInfoByBrandAndRangeTime",method=RequestMethod.POST)
	@ResponseBody
	public Msg getCrmWebanalyticsInfoByBrandAndRangeTime(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody CrmWebanalytics crmWebanalyticsReq){
		
		//选查询渠道总数
		String brandName = crmWebanalyticsReq.getWebanalyticsBrandname();
		CrmWebanalytics crmWebanalyticsBrand = new CrmWebanalytics();
		crmWebanalyticsBrand.setWebanalyticsBrandname(brandName);
		crmWebanalyticsBrand.setWebanalyticsCreatetime(crmWebanalyticsReq.getWebanalyticsCreatetime());
		crmWebanalyticsBrand.setWebanalyticsMotifytime(crmWebanalyticsReq.getWebanalyticsMotifytime());
		
		List<CrmWebanalytics> crmWebanalyticsBrandList = crmWebanalyticsService.selectCrmWebanalyticsByParameter(crmWebanalyticsBrand);
		
		List<CrmWebanalytics> crmWebanalyticsChannelList = null;;
		List<List<CrmWebanalytics>> crmWebanalyticsFinallList = null;
		
		if(crmWebanalyticsBrandList.size()>0){
			crmWebanalyticsChannelList = new ArrayList<CrmWebanalytics>();
			crmWebanalyticsFinallList = new ArrayList<List<CrmWebanalytics>>();
			//将查询出来的网站渠道  按渠道排序
			crmWebanalyticsBrandList.sort(new Comparator<CrmWebanalytics>(){
				@Override
				public int compare(CrmWebanalytics o1, CrmWebanalytics o2) {
					return o1.getWebanalyticsChannelname().compareTo(o2.getWebanalyticsChannelname());
				}
			});
			String channelName = crmWebanalyticsBrandList.get(0).getWebanalyticsChannelname();
			for(int i = 0; i < crmWebanalyticsBrandList.size();i++){
				CrmWebanalytics webanalytics = crmWebanalyticsBrandList.get(i);
				String cn = webanalytics.getWebanalyticsChannelname();
				//将相同渠道下的合并为一个list
				if(cn.equals(channelName)){
					crmWebanalyticsChannelList.add(webanalytics);
					
				}else{
					//对上一个crmWebanalyticsChannelList进行排序，按时间倒序排序
					crmWebanalyticsChannelList.sort(new Comparator<CrmWebanalytics>(){
						@Override
						public int compare(CrmWebanalytics o1, CrmWebanalytics o2) {
							return o2.getWebanalyticsCreatetime().compareTo(o1.getWebanalyticsCreatetime());
						}
					});
					crmWebanalyticsFinallList.add(crmWebanalyticsChannelList);
					crmWebanalyticsChannelList = new ArrayList<CrmWebanalytics>();
					crmWebanalyticsChannelList.add(webanalytics);
					channelName = cn;
				}
				if(i==crmWebanalyticsBrandList.size()-1){
					//对上一个crmWebanalyticsChannelList进行排序，按时间倒序排序
					crmWebanalyticsChannelList.sort(new Comparator<CrmWebanalytics>(){
						@Override
						public int compare(CrmWebanalytics o1, CrmWebanalytics o2) {
							return o2.getWebanalyticsCreatetime().compareTo(o1.getWebanalyticsCreatetime());
						}
					});
					crmWebanalyticsFinallList.add(crmWebanalyticsChannelList);
				}
			}
		}
		
		if(crmWebanalyticsFinallList != null && crmWebanalyticsFinallList.size()>0){
			crmWebanalyticsFinallList.sort(new Comparator<List<CrmWebanalytics>>(){
				@Override
				public int compare(List<CrmWebanalytics> o1, List<CrmWebanalytics> o2) {
					
					return o2.size() - o1.size();
				}
			});
		}
		//返回各渠道数量汇总
//		List<Integer> crmWebanalyticsFinallNumList = new ArrayList<Integer>();
//		if(crmWebanalyticsFinallList != null && crmWebanalyticsFinallList.size()>0){
//			for(List<CrmWebanalytics> f : crmWebanalyticsFinallList){
//				crmWebanalyticsFinallNumList.add(f.size());
//			}
//		}
		return Msg.success().add("resMsg", "返回某网站下，各渠道汇总，按渠道数量降序排序；相同渠道内按创建时间降序排序；")
				.add("crmWebanalyticsFinallList", crmWebanalyticsFinallList);
	}

}
