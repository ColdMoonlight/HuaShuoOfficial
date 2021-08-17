package com.atguigu.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.atguigu.bean.CrmAdmin;
import com.atguigu.bean.CrmWebanalytics;
import com.atguigu.common.Const;
import com.atguigu.service.CrmWebanalyticsService;
import com.atguigu.utils.DateUtil;

@Controller
@RequestMapping("/ExcelImport")
public class ExcleImportController {
		
	@Autowired
	CrmWebanalyticsService crmWebanalyticsService;
	/**
	 * zsh 200730
	 * 中控台首页
	 * */
	@RequestMapping("/reviewsImportPage")
	public String reviewsImportPage(HttpSession session){
		CrmAdmin crmAdmin =(CrmAdmin) session.getAttribute(Const.ADMIN_USER);
		if(crmAdmin==null){
			//MlbackAdmin对象为空
			return "back/mlbackAdminLogin";
		}else{
			return "back/product/excleintoPage";
		}
	}
	
	/**
	 * 下载Webanalytics模板
	 * */
	@RequestMapping(value="/ExportWebanalyticsImportDemo",method=RequestMethod.GET)
	public void exportWebanalyticsImportDemo(HttpServletResponse rep,HttpServletRequest res,HttpSession session){
		
		String nowTime = DateUtil.strTime14();
		rep.setContentType("application/octet-stream");
		rep.setHeader("Content-Disposition", "attachment;filename="+nowTime+"WebanalyticsDemo.xls");
		
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet0");
		HSSFRow row = sheet.createRow(0);
		
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("webanalytics_channelName");
		
	    cell = row.createCell(1);
	    cell.setCellValue("webanalytics_channelInvestMoney");
	    
	    cell = row.createCell(2);
	    cell.setCellValue("webanalytics_channelintoUserNum");
	    
	    cell = row.createCell(3);
	    cell.setCellValue("webanalytics_channelintoUserNewNum");
	    
	    cell = row.createCell(4);
	    cell.setCellValue("webanalytics_channelflowlNum");
	    
	    cell = row.createCell(5);
	    cell.setCellValue("webanalytics_channelSellNum");
	    
	    cell = row.createCell(6);
	    cell.setCellValue("webanalytics_channelSellMoney");
	    
	    cell = row.createCell(7);
	    cell.setCellValue("webanalytics_brandName");
	    
	    cell = row.createCell(8);
	    cell.setCellValue("webanalytics_createTime");
	    
        row = sheet.createRow(1);
        row.createCell(0).setCellValue("channelName");//
        row.createCell(1).setCellValue(266.32);//
        row.createCell(2).setCellValue(1000);//
        row.createCell(3).setCellValue(100);//
        row.createCell(4).setCellValue(6523);//
        row.createCell(5).setCellValue(16);//
        row.createCell(6).setCellValue(66.32);//
        row.createCell(7).setCellValue("哪个网站");//
        
        //设置导出excel 日期格式为文本
        HSSFCellStyle textStyle = wb.createCellStyle();
        HSSFDataFormat format = wb.createDataFormat();
        textStyle.setDataFormat(format.getFormat("@"));
        cell = row.createCell(8);
        cell.setCellStyle(textStyle);
        cell.setCellType(CellType.STRING);
        cell.setCellValue("2021-08-13 10:56:49");//
        
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
     * inportWebanalytics
     * @param request
     * @param response
     */
	@RequestMapping(value="/ImportWebanalytics",method=RequestMethod.POST)
	public void importWebanalytics(@RequestParam(value = "file", required = false) MultipartFile multipartFile,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		try {
			InputStream is = multipartFile.getInputStream();
			if(is!=null){
				String nowTime = DateUtil.strTime14s();
				HSSFWorkbook wb = new HSSFWorkbook(is);
				List<CrmWebanalytics> crmWebanalyticsList = new ArrayList<CrmWebanalytics>();
				int rowCount = 0;
				try {
					HSSFSheet st = wb.getSheetAt(0);
					int rowNum = st.getLastRowNum(); //获取Excel最后一行索引，从零开始，所以获取到的是表中最后一行行数减一
					int colNum = st.getRow(0).getLastCellNum();//获取Excel单行列数 
					for(int r=1;r<=rowNum;r++){//读取每一行，第一行为标题，从第二行开始
						rowCount = r;
						HSSFRow row = st.getRow(r);
						CrmWebanalytics crmWebanalytics = new CrmWebanalytics();
						crmWebanalytics.setWebanalyticsMotifytime(nowTime);//创建时间
						HSSFCell getCell = null;
						getCell = row.getCell(0);
						if(getCell != null) {
		                    crmWebanalytics.setWebanalyticsChannelname(getCell.getStringCellValue());
		                    
		                    //做特殊字符转移处理
		            		//String afterReviewUname = reviewUname.replaceAll("[^\\u0000-\\uFFFF]", "");
		            		
		                }
						getCell = row.getCell(1);
						if(getCell != null) {
		                    crmWebanalytics.setWebanalyticsChannelinvestmoney(new BigDecimal(getCell.getNumericCellValue()));
		                }
						getCell = row.getCell(2);
						if(getCell != null) {
		                    crmWebanalytics.setWebanalyticsChannelintousernum((int)getCell.getNumericCellValue());
		                }
						getCell = row.getCell(3);
						if(getCell != null) {
		                    crmWebanalytics.setWebanalyticsChannelintousernewnum((int)getCell.getNumericCellValue());
		                }
						getCell = row.getCell(4);
						if(getCell != null) {
		                    crmWebanalytics.setWebanalyticsChannelflowlnum((int)getCell.getNumericCellValue());
		                }
						getCell = row.getCell(5);
						if(getCell != null) {
		                    crmWebanalytics.setWebanalyticsChannelsellnum((int)getCell.getNumericCellValue());
		                }
						getCell = row.getCell(6);
						if(getCell != null) {
		                    crmWebanalytics.setWebanalyticsChannelsellmoney(new BigDecimal(getCell.getNumericCellValue()));
		                }
						getCell = row.getCell(7);
						if(getCell != null) {
		                    crmWebanalytics.setWebanalyticsBrandname(getCell.getStringCellValue());
		                }
						getCell = row.getCell(8);
						if(getCell != null) {
		                    crmWebanalytics.setWebanalyticsCreatetime(getCell.getStringCellValue());
		                }
						crmWebanalyticsList.add(crmWebanalytics);
					}
					is.close();
					for(CrmWebanalytics crmWebanalytics:crmWebanalyticsList){
						crmWebanalyticsService.insertSelective(crmWebanalytics);
					}
				}catch (Exception e) {
					System.out.println("第"+rowCount+"行出错");
					e.printStackTrace();
				}
			}
		}catch (Exception e) {
			System.out.println("第行出错");
			e.printStackTrace();
		}
	}
	/*
	private String getReviewImgUrl(HttpServletRequest res,HttpServletResponse response,String reviewUname) {
		
        String realPathStr = res.getSession().getServletContext().getRealPath("/");    
        System.out.println("realPathStr:"+realPathStr);
        
        String basePathStr = URLLocationUtils.getbasePathStr(response,res);	//出来是真实的服务器域名
        System.out.println("basePathStr:"+basePathStr);
		
		String pathBig = basePathStr;
		String path="static/upload/img/ReviewUImg/";
		String returnReaUrl = "";
		
		String firstName = reviewUname.substring(0, 1);
		String firstNameUp = firstName.toUpperCase();
		if(firstNameUp.equals("A")){
			returnReaUrl="A.png";
		}else if(firstNameUp.equals("B")){
			returnReaUrl="B.png";
		}else if(firstNameUp.equals("C")){
			returnReaUrl="C.png";
		}else if(firstNameUp.equals("D")){
			returnReaUrl="D.png";
		}else if(firstNameUp.equals("E")){
			returnReaUrl="E.png";
		}else if(firstNameUp.equals("F")){
			returnReaUrl="F.png";
		}else if(firstNameUp.equals("G")){
			returnReaUrl="G.png";
		}else if(firstNameUp.equals("H")){
			returnReaUrl="H.png";
		}else if(firstNameUp.equals("I")){
			returnReaUrl="I.png";
		}else if(firstNameUp.equals("J")){
			returnReaUrl="J.png";
		}else if(firstNameUp.equals("K")){
			returnReaUrl="K.png";
		}else if(firstNameUp.equals("L")){
			returnReaUrl="L.png";
		}else if(firstNameUp.equals("M")){
			returnReaUrl="M.png";
		}else if(firstNameUp.equals("N")){
			returnReaUrl="N.png";
		}else if(firstNameUp.equals("O")){
			returnReaUrl="O.png";
		}else if(firstNameUp.equals("P")){
			returnReaUrl="P.png";
		}else if(firstNameUp.equals("Q")){
			returnReaUrl="Q.png";
		}else if(firstNameUp.equals("R")){
			returnReaUrl="R.png";
		}else if(firstNameUp.equals("S")){
			returnReaUrl="S.png";
		}else if(firstNameUp.equals("T")){
			returnReaUrl="T.png";
		}else if(firstNameUp.equals("U")){
			returnReaUrl="U.png";
		}else if(firstNameUp.equals("V")){
			returnReaUrl="V.png";
		}else if(firstNameUp.equals("W")){
			returnReaUrl="W.png";
		}else if(firstNameUp.equals("X")){
			returnReaUrl="X.png";
		}else if(firstNameUp.equals("Y")){
			returnReaUrl="Y.png";
		}else if(firstNameUp.equals("Z")){
			returnReaUrl="Z.png";
		}
		String returnReaUrlAll = pathBig+path+returnReaUrl;
		return returnReaUrlAll;
	}
	*/
}
