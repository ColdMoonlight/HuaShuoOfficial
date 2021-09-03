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
import com.atguigu.bean.MarketSensationDetailOutput;
import com.atguigu.common.Const;
import com.atguigu.common.Msg;
import com.atguigu.service.MarketSensationDetailOutputService;
import com.atguigu.utils.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/MarketSensationDetailOutput")
public class MarketSensationDetailOutputController {
	
	@Autowired
	MarketSensationDetailOutputService marketSensationDetailOutputService;
	
	
	/**
	 * 20210903
	 * MarketSensationDetailOutput 首页
	 * */
	@RequestMapping("/ToMarketSensationDetailOutputPage")
	public String toMarketSensationDetailOutputPage(HttpSession session) throws Exception{
		
		CrmAdmin mlbackAdmin =(CrmAdmin) session.getAttribute(Const.ADMIN_USER);
		if(mlbackAdmin==null){
			//SysUsers对象为空
			return "back/crmAdminLogin";
		}else{
			return "back/marketSensationDetailOutputPage";
		}
	}
	
	/**
	 * 2.0
	 * @author 20210903
	 * @param MarketSensationDetailOutput
	 * @exception 创建单条信息
	 * */
	@RequestMapping(value="/Add",method=RequestMethod.POST)
	@ResponseBody
	public Msg insertSelective(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody MarketSensationDetailOutput marketSensationDetailOutputReq){
		//接收参数信息 
		String nowTime = DateUtil.strTime14s();
		marketSensationDetailOutputReq.setSensationdetailoutputCreatetime(nowTime);
		marketSensationDetailOutputService.insertSelective(marketSensationDetailOutputReq);
		
		if(marketSensationDetailOutputReq.getSensationdetailoutputId() != null){
			return Msg.success().add("resMsg", "创建成功");
		}else{
			return Msg.fail().add("resMsg", "系统错误，请联系管理员");
		}
	}
	
	/**
	 * 4.0
	 * @author 20210903
	 * @param MarketSensationDetailOutput
	 * @exception 删除单条信息
	 * */
	@RequestMapping(value="/Delete",method=RequestMethod.POST)
	@ResponseBody
	public Msg delete(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody MarketSensationDetailOutput marketSensationDetailOutputReq){
		
		//通过id 查询单个用户详情
		marketSensationDetailOutputService.deleteByPrimaryKey(marketSensationDetailOutputReq.getSensationdetailoutputId());
		return Msg.success().add("resMsg", "删除成功");
		
	}
	
	/**
	 * 2.0
	 * @author 20210903
	 * @param MarketSensationDetailOutput
	 * @exception 更新单条信息
	 * */
	@RequestMapping(value="/Update",method=RequestMethod.POST)
	@ResponseBody
	public Msg updateByPrimaryKeySelective(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody MarketSensationDetailOutput marketSensationDetailOutputReq){
		//接收参数信息 
		String nowTime = DateUtil.strTime14s();
		marketSensationDetailOutputReq.setSensationdetailoutputUpdatetime(nowTime);
		marketSensationDetailOutputService.updateByPrimaryKeySelective(marketSensationDetailOutputReq);
		return Msg.success().add("resMsg", "修改成功");
	}
	
	/**
	 * 2.0
	 * @author 20210903
	 * @param MarketSensationDetailOutput
	 * @exception 查看单个渠道
	 * */
	@RequestMapping(value="/GetOneMarketSensationDetailOutputDetailById",method=RequestMethod.POST)
	@ResponseBody
	public Msg getOneMarketSensationDetailOutputDetailById(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody MarketSensationDetailOutput marketSensationDetailOutputReq){
		
		//通过id 查询单个渠道详情
		MarketSensationDetailOutput marketSensationDetailOutputRes = marketSensationDetailOutputService.selectByPrimaryKey(marketSensationDetailOutputReq.getSensationdetailoutputId());
		return Msg.success().add("marketSensationDetailOutput", marketSensationDetailOutputRes);
		
	}
	
	/**2.0	20210903
	 * 后台MarketSensationDetailOutput列表分页list数据 
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/GetMarketSensationDetailOutputByPage")
	@ResponseBody
	public Msg getMarketSensationDetailOutputByPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session) {

		int PagNum = Const.PAGE_NUM_DEFAULT;
		PageHelper.startPage(pn, PagNum);
		List<MarketSensationDetailOutput> marketSensationDetailOutputList = marketSensationDetailOutputService.selectMarketSensationDetailOutputByPage();
		PageInfo<MarketSensationDetailOutput> page = new PageInfo<MarketSensationDetailOutput>(marketSensationDetailOutputList, PagNum);
		return Msg.success().add("pageInfo", page);
	}
	
	/**
	 * 2.0
	 * @author 202109030
	 * @param MarketSensationDetailOutput
	 * @exception 按条件查询
	 * */
	@RequestMapping(value="/GetMarketSensationDetailOutputByParameterByPage")
	@ResponseBody
	public Msg getMarketSensationDetailOutputByParameterByPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session,
			@RequestBody MarketSensationDetailOutput crmMarketSensationDetailOutputReq){
		
		int PagNum = Const.PAGE_NUM_DEFAULT;
		PageHelper.startPage(pn, PagNum);
		//根据条件查询信息
		List<MarketSensationDetailOutput> crmMarketSensationDetailOutputList = marketSensationDetailOutputService.selectMarketSensationDetailOutputByParameter(crmMarketSensationDetailOutputReq);
		PageInfo<MarketSensationDetailOutput> page = new PageInfo<MarketSensationDetailOutput>(crmMarketSensationDetailOutputList, PagNum);
		return Msg.success().add("pageInfo", page);
	}
	
}
