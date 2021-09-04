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
import com.atguigu.bean.MarketSensationInfo;
import com.atguigu.common.Const;
import com.atguigu.common.Msg;
import com.atguigu.service.MarketSensationInfoService;
import com.atguigu.utils.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/MarketSensationInfo")
public class MarketSensationInfoController {
	
	@Autowired
	MarketSensationInfoService marketSensationInfoService;
	
	
	/**
	 * 20210902
	 * MarketSensationInfo 首页
	 * */
	@RequestMapping("/ToMarketSensationInfoPage")
	public String toMarketSensationInfoPage(HttpSession session) throws Exception{
		
		CrmAdmin mlbackAdmin =(CrmAdmin) session.getAttribute(Const.ADMIN_USER);
		if(mlbackAdmin==null){
			//SysUsers对象为空
			return "back/crmAdminLogin";
		}else{
			return "back/marketSensationInfoPage";
		}
	}
	
	/**
	 * 2.0
	 * @author 20210902
	 * @param MarketSensationInfo
	 * @exception 创建单条信息
	 * */
	@RequestMapping(value="/Add",method=RequestMethod.POST)
	@ResponseBody
	public Msg insertSelective(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody MarketSensationInfo marketSensationInfoReq){
		//接收参数信息 
		String nowTime = DateUtil.strTime14s();
		marketSensationInfoReq.setSensationinfoCreatetime(nowTime);
		marketSensationInfoService.insertSelective(marketSensationInfoReq);
		
		if(marketSensationInfoReq.getSensationinfoId() != null){
			return Msg.success().add("resMsg", "创建成功");
		}else{
			return Msg.fail().add("resMsg", "系统错误，请联系管理员");
		}
	}
	
	/**
	 * 4.0
	 * @author 20210902
	 * @param MarketSensationInfo
	 * @exception 删除单条信息
	 * */
	@RequestMapping(value="/Delete",method=RequestMethod.POST)
	@ResponseBody
	public Msg delete(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody MarketSensationInfo marketSensationInfoReq){
		
		//通过id 查询单个用户详情
		marketSensationInfoService.deleteByPrimaryKey(marketSensationInfoReq.getSensationinfoId());
		return Msg.success().add("resMsg", "删除成功");
		
	}
	
	/**
	 * 2.0
	 * @author 20210902
	 * @param MarketSensationInfo
	 * @exception 更新单条信息
	 * */
	@RequestMapping(value="/Update",method=RequestMethod.POST)
	@ResponseBody
	public Msg updateByPrimaryKeySelective(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody MarketSensationInfo marketSensationInfoReq){
		//接收参数信息 
		String nowTime = DateUtil.strTime14s();
		marketSensationInfoReq.setSensationinfoUpdatetime(nowTime);
		marketSensationInfoService.updateByPrimaryKeySelective(marketSensationInfoReq);
		return Msg.success().add("resMsg", "修改成功");
	}
	
	/**
	 * 2.0
	 * @author 20210902
	 * @param MarketSensationInfo
	 * @exception 查看单个渠道
	 * */
	@RequestMapping(value="/GetOneMarketSensationInfoDetailById",method=RequestMethod.POST)
	@ResponseBody
	public Msg getOneMarketSensationInfoDetailById(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody MarketSensationInfo marketSensationInfoReq){
		
		//通过id 查询单个渠道详情
		MarketSensationInfo marketSensationInfoRes = marketSensationInfoService.selectByPrimaryKey(marketSensationInfoReq.getSensationinfoId());
		return Msg.success().add("marketSensationInfo", marketSensationInfoRes);
		
	}
	
	/**2.0	20210902
	 * 后台MarketSensationInfo列表分页list数据 
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/GetMarketSensationInfoByPage")
	@ResponseBody
	public Msg getMarketSensationInfoByPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			HttpSession session) {

		int PagNum = Const.PAGE_NUM_DEFAULT;
		PageHelper.startPage(pn, PagNum);
		List<MarketSensationInfo> marketSensationInfoList = marketSensationInfoService.selectMarketSensationInfoByPage();
		
		//先按销售单数降序排序，再按id降序排序 这种方法不能排除空段
		//marketSensationInfoList.sort(Comparator.comparing(MarketSensationInfo::getSensationinfoSalesnum).thenComparing(MarketSensationInfo::getSensationinfoId).reversed());
		/*marketSensationInfoList.sort(new Comparator<MarketSensationInfo>(){
            @Override
            public int compare(MarketSensationInfo arg0 , MarketSensationInfo arg1) {
                 //这里是根据ID来排序，所以它为空的要剔除掉
                 if (arg0.getSensationinfoId()== null || arg1.getSensationinfoId()== null) return 0;
                
                 return arg0.getSensationinfoId().compareTo( arg1.getSensationinfoId()); //这是顺序
           }               
		});*/ 
		PageInfo<MarketSensationInfo> page = new PageInfo<MarketSensationInfo>(marketSensationInfoList, PagNum);
		return Msg.success().add("pageInfo", page);
	}
	
	/**
	 * 2.0
	 * @author 20210902
	 * @param MarketSensationInfo
	 * @exception 按条件查询
	 * */
	@RequestMapping(value="/GetMarketSensationInfoByParameterByPage")
	@ResponseBody
	public Msg getMarketSensationInfoByParameterByPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session,
			@RequestBody MarketSensationInfo crmMarketSensationInfoReq){
		
		int PagNum = Const.PAGE_NUM_DEFAULT;
		PageHelper.startPage(pn, PagNum);
		//根据条件查询信息
		List<MarketSensationInfo> crmMarketSensationInfoList = marketSensationInfoService.selectMarketSensationInfoByParameter(crmMarketSensationInfoReq);
		PageInfo<MarketSensationInfo> page = new PageInfo<MarketSensationInfo>(crmMarketSensationInfoList, PagNum);
		return Msg.success().add("pageInfo", page);
	}
	
}
