package com.atguigu.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.bean.CrmAdmin;
import com.atguigu.bean.CrmWebanalytics;
import com.atguigu.common.Const;
import com.atguigu.service.CrmWebanalyticsService;
import com.atguigu.utils.DateUtil;

@Controller
@RequestMapping("/ExcleDownload")
public class ExcleDownloadController {
		
	@Autowired
	CrmWebanalyticsService crmWebanalyticsService;
	
	/**
	 * zsh 201103
	 * 中控台DownloadPage
	 * */
	@RequestMapping("/DownloadPage")
	public String DownloadPage(HttpSession session) throws Exception{
		
		CrmAdmin crmAdmin =(CrmAdmin) session.getAttribute(Const.ADMIN_USER);
		if(crmAdmin==null){
			//SysUsers对象为空
			return "back/crmAdminLogin";
		}else{
			return "back/download/downloadPage";
		}
	}
	
	/**
	 * 下载渠道数据
	 * */
	@RequestMapping(value="/exportWebanalyticsInfo",method=RequestMethod.GET)
	public void exportPayInfoIF(HttpServletResponse rep,HttpServletRequest res,
			@RequestParam(value = "webanalyticsCreatetime") String webanalyticsCreatetime,
			@RequestParam(value = "webanalyticsMotifytime") String webanalyticsMotifytime,
			HttpSession session){
		
		String nowTime = DateUtil.strTime14();
		rep.setContentType("application/octet-stream");
		rep.setHeader("Content-Disposition", "attachment;filename="+nowTime+"WebanalyticsInfo.xls");
		
		CrmWebanalytics crmWebanalyticsReq = new CrmWebanalytics();
		crmWebanalyticsReq.setWebanalyticsCreatetime(webanalyticsCreatetime);
		crmWebanalyticsReq.setWebanalyticsMotifytime(webanalyticsMotifytime);
		List<CrmWebanalytics> crmWebanalyticsList= crmWebanalyticsService.selectCrmWebanalyticsByParameter(crmWebanalyticsReq);
		
		System.out.println("crmWebanalyticsList.size():" + crmWebanalyticsList.size());
		//Excel 文档对象
		HSSFWorkbook wb = new HSSFWorkbook();
		//Excel 表
		HSSFSheet sheet = wb.createSheet("sheet0");
		//Excel 行
		HSSFRow row = sheet.createRow(0);
		
		//Excel 格子单元
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("序号");
		
	    cell = row.createCell(1);
		cell.setCellValue("webanalytics_id");
		
	    cell = row.createCell(2);
		cell.setCellValue("webanalytics_channelName");
		
	    cell = row.createCell(3);
	    cell.setCellValue("webanalytics_channelInvestMoney");
	    
	    cell = row.createCell(4);
	    cell.setCellValue("webanalytics_channelintoUserNum");
	    
	    cell = row.createCell(5);
	    cell.setCellValue("webanalytics_channelintoUserNewNum");
	    
	    cell = row.createCell(6);
	    cell.setCellValue("webanalytics_channelflowlNum");
	    
	    cell = row.createCell(7);
	    cell.setCellValue("webanalytics_channelSellNum");
	    
	    cell = row.createCell(8);
	    cell.setCellValue("webanalytics_channelSellMoney");
	    
	    cell = row.createCell(9);
	    cell.setCellValue("webanalytics_brandName");
	    
	    cell = row.createCell(10);
	    cell.setCellValue("webanalytics_createTime");
	    
	    cell = row.createCell(11);
	    cell.setCellValue("webanalytics_motifyTime");
	    
	    CrmWebanalytics crmWebanalyticsOne = new CrmWebanalytics();
	    for (int i = 0; i < crmWebanalyticsList.size(); i++) {
	    	crmWebanalyticsOne = crmWebanalyticsList.get(i);
	        row = sheet.createRow(i+1);
	        row.createCell(0).setCellValue(i+1);
	        row.createCell(1).setCellValue(crmWebanalyticsOne.getWebanalyticsId());
	        row.createCell(2).setCellValue(crmWebanalyticsOne.getWebanalyticsChannelname());
	        row.createCell(3).setCellValue(crmWebanalyticsOne.getWebanalyticsChannelinvestmoney()+"");
	        row.createCell(4).setCellValue(crmWebanalyticsOne.getWebanalyticsChannelintousernum());
	        row.createCell(5).setCellValue(crmWebanalyticsOne.getWebanalyticsChannelintousernewnum());
	        row.createCell(6).setCellValue(crmWebanalyticsOne.getWebanalyticsChannelflowlnum());
	        row.createCell(7).setCellValue(crmWebanalyticsOne.getWebanalyticsChannelsellnum());
	        row.createCell(8).setCellValue(crmWebanalyticsOne.getWebanalyticsChannelsellmoney()+"");
	        row.createCell(9).setCellValue(crmWebanalyticsOne.getWebanalyticsBrandname());
	        row.createCell(10).setCellValue(crmWebanalyticsOne.getWebanalyticsCreatetime());
	        row.createCell(11).setCellValue(crmWebanalyticsOne.getWebanalyticsMotifytime());
	    }
		try {
			OutputStream out =rep.getOutputStream();
			wb.write(out);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 下载注册客户email,telphone数据
	 * */
	/*@RequestMapping(value="/exportUserEmailBydate",method=RequestMethod.GET)
	public void exportUserEmailBydate(HttpServletResponse rep,HttpServletRequest res,@RequestParam(value = "userCreatetime") String userCreatetime,
			@RequestParam(value = "userMotifytime") String userMotifytime,HttpSession session){
		
		rep.setContentType("application/octet-stream");
		
		String nowTime = DateUtil.strTime14();
		rep.setHeader("Content-Disposition", "attachment;filename="+nowTime+"userEmail.xls");
		
		HSSFWorkbook wb = new HSSFWorkbook();
		
		HSSFSheet sheet = wb.createSheet("sheet0");
		
		HSSFRow row = sheet.createRow(0);
		
		HSSFCell cell = row.createCell(0);
		
		MlfrontUser mlfrontUserReq = new MlfrontUser();
		mlfrontUserReq.setUserCreatetime(userCreatetime);
		mlfrontUserReq.setUserMotifytime(userMotifytime);
		
		List<MlfrontUser> mlfrontUserList= mlfrontUserService.selectMlfrontUserSimpleByDate(mlfrontUserReq);
		System.out.println("下载注册客户的邮箱mlfrontUserList.size():"+mlfrontUserList.size());
		
		//user_id, user_email,user_telephone, user_createTime
		
		cell.setCellValue("num_id");
	    cell = row.createCell(1);
		cell.setCellValue("user_id");
	    cell = row.createCell(2);
		cell.setCellValue("user_email");
	    cell = row.createCell(3);
	    cell.setCellValue("user_telephone");
	    cell = row.createCell(4);
	    cell.setCellValue("user_createTime");
	    cell = row.createCell(5);
	    
	    MlfrontUser mlfrontUserOne = new MlfrontUser();
	    for (int i = 0; i < mlfrontUserList.size(); i++) {
	    	mlfrontUserOne = mlfrontUserList.get(i);
	        row = sheet.createRow(i+1);
	        row.createCell(0).setCellValue(i+1);
	        row.createCell(1).setCellValue(mlfrontUserOne.getUserId());
	        row.createCell(2).setCellValue(mlfrontUserOne.getUserEmail()+"");
	        row.createCell(3).setCellValue(mlfrontUserOne.getUserTelephone()+"");
	        row.createCell(4).setCellValue(mlfrontUserOne.getUserCreatetime());
	    }
		try {
			OutputStream out =rep.getOutputStream();
			wb.write(out);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	*//**
	 * 下载注册客户email,telphone数据
	 * *//*
	@RequestMapping(value="/exportProUpdateWithInSomeDay",method=RequestMethod.GET)
	public void exportProUpdateWithInSomeDay(HttpServletResponse rep,HttpServletRequest res,@RequestParam(value = "productMotifytime") String productMotifytime,HttpSession session){
		
		rep.setContentType("application/octet-stream");
		
		String nowTime = DateUtil.strTime14();
		rep.setHeader("Content-Disposition", "attachment;filename="+nowTime+"ProductUpdateWithIn24Hour.xls");
		
		HSSFWorkbook wb = new HSSFWorkbook();
		
		HSSFSheet sheet = wb.createSheet("sheet0");
		
		HSSFRow row = sheet.createRow(0);
		
		HSSFCell cell = row.createCell(0);
		
		MlbackProduct mlbackProductReq = new MlbackProduct();
		mlbackProductReq.setProductMotifytime(productMotifytime);
		
		List<MlbackProduct> mlbackProductList= mlbackProductService.selectMlbackProductBeforeTime(mlbackProductReq);
		System.out.println("下载注册客户的邮箱mlbackProductList.size():"+mlbackProductList.size());
		
		//user_id, user_email,user_telephone, user_createTime
		
		cell.setCellValue("number");
	    cell = row.createCell(1);
		cell.setCellValue("product_id");
	    cell = row.createCell(2);
		cell.setCellValue("product_name");
	    cell = row.createCell(3);
		cell.setCellValue("product_meta_title");
	    cell = row.createCell(4);
	    cell.setCellValue("product_meta_desc");
	    cell = row.createCell(5);
	    cell.setCellValue("product_seo");
	    cell = row.createCell(6);
	    cell.setCellValue("product_Price");
	    cell = row.createCell(7);
	    cell.setCellValue("product_status");
	    cell = row.createCell(8);
	    cell.setCellValue("product_mainimgurl");
	    cell = row.createCell(9);
	    cell.setCellValue("product_category_namesStr");
	    cell = row.createCell(10);
	    cell.setCellValue("product_motifyTime");
	    cell = row.createCell(11);
	    
	    MlbackProduct mlbackProductOne = new MlbackProduct();
	    DecimalFormat df1 = new DecimalFormat("0.00");
	    
	    for (int i = 0; i < mlbackProductList.size(); i++) {
	    	mlbackProductOne = mlbackProductList.get(i);
	        row = sheet.createRow(i+1);
	        row.createCell(0).setCellValue(i+1);
	        row.createCell(1).setCellValue(mlbackProductOne.getProductId());
	        row.createCell(2).setCellValue(mlbackProductOne.getProductName()+"");
	        row.createCell(3).setCellValue(mlbackProductOne.getProductMetaTitle()+"");
	        row.createCell(4).setCellValue(mlbackProductOne.getProductMetaDesc()+"");
	        row.createCell(5).setCellValue("https://www.megalook.com/"+mlbackProductOne.getProductSeo()+".html");
	        
	        BigDecimal oneTotalprice = new BigDecimal(0);
	        oneTotalprice=oneTotalprice.add(mlbackProductOne.getProductOriginalprice());
	        oneTotalprice = oneTotalprice.multiply(new BigDecimal(mlbackProductOne.getProductActoffoff()));//05乘本品的折扣
	        oneTotalprice = oneTotalprice.multiply(new BigDecimal(0.01));//06还原本品+sku集合的最终价
	        String oneTotalpriceStr = df1.format(oneTotalprice);
	        
	        row.createCell(6).setCellValue(oneTotalpriceStr+"");
	        row.createCell(7).setCellValue(mlbackProductOne.getProductStatus());
	        row.createCell(8).setCellValue(mlbackProductOne.getProductMainimgurl()+"");
	        row.createCell(9).setCellValue(mlbackProductOne.getProductCategoryNamesstr()+"");
	        row.createCell(10).setCellValue(mlbackProductOne.getProductMotifytime()+"");
	    }
	    *//**
	     * product_id, product_name, product_meta_title, product_meta_desc, product_seo, product_originalPrice, product_actoffOff, 
	     * product_status, product_mainimgurl, product_category_namesStr, 
	     * product_motifyTime, product_meta_keyWords
	     * *//*
		try {
			OutputStream out =rep.getOutputStream();
			wb.write(out);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
*/
}
