package com.atguigu.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
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
import org.springframework.web.multipart.MultipartFile;

import com.atguigu.bean.CrmAdmin;
import com.atguigu.common.Const;
import com.atguigu.utils.DateUtil;

@Controller
@RequestMapping("/excleImport")
public class ExcleImportController {
		
	
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
	 * 下载review模板
	 * */
	@RequestMapping(value="/exportReviewsImportDemo",method=RequestMethod.GET)
	public void exportReviewsImportDemo(HttpServletResponse rep,HttpServletRequest res,HttpSession session){
		
		rep.setContentType("application/octet-stream");
		String nowTime = DateUtil.strTime14();
		rep.setHeader("Content-Disposition", "attachment;filename="+nowTime+"reviewDemo.xls");
		
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet0");
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		
		cell.setCellValue("ReviewUname");
	    cell = row.createCell(1);
	    cell.setCellValue("ReviewPid");
	    cell = row.createCell(2);
	    cell.setCellValue("ReviewCreatetime");
	    cell = row.createCell(3);
	    cell.setCellValue("ReviewMotifytime");
	    cell = row.createCell(4);
	    cell.setCellValue("ReviewPseoname");
	    cell = row.createCell(5);
	    cell.setCellValue("ReviewStatus");
	    cell = row.createCell(6);
	    cell.setCellValue("ReviewDetailstr");
	    cell = row.createCell(7);
	    cell.setCellValue("ReviewProstarnum");
	    cell = row.createCell(8);
	    cell.setCellValue("ReviewFrom");
	    cell = row.createCell(9);
	    
        row = sheet.createRow(1);
        row.createCell(0).setCellValue("MegaLookCustomer");//ReviewUname
        row.createCell(1).setCellValue(252);//ReviewPid
        row.createCell(2).setCellValue("2019-07-02 15:23:43");//ReviewCreatetime
        row.createCell(3).setCellValue("2019-07-02 15:23:43");//ReviewMotifytime
        row.createCell(4).setCellValue("613-Color-13x4-Body-Wave-Lace-Wig");//ReviewPseoname
        row.createCell(5).setCellValue("0不展示/1展示");//ReviewStatus
        row.createCell(6).setCellValue("i like megalook's hair,very like");//ReviewDetailstr
        row.createCell(7).setCellValue("1/2/3/4/5星评论");//ReviewProstarnum
        row.createCell(8).setCellValue("0-self/1-customer/2-ins瀑布流/3-ins首页");//ReviewFrom
        
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
     * inportReviews
     * @param request
     * @param response
     */
	/*@RequestMapping(value="/inportReviews",method=RequestMethod.POST)
	public void inportReviews(@RequestParam(value = "file", required = false) MultipartFile multipartFile,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		try {
			InputStream is = multipartFile.getInputStream();
			if(is!=null){
				HSSFWorkbook wb = new HSSFWorkbook(is);
				List<MlfrontReview> reviewList = new ArrayList<MlfrontReview>();
				int rowCount = 0;
				try {
					HSSFSheet st = wb.getSheetAt(0);
					int rowNum = st.getLastRowNum(); //获取Excel最后一行索引，从零开始，所以获取到的是表中最后一行行数减一
					int colNum = st.getRow(0).getLastCellNum();//获取Excel列数
					for(int r=1;r<=rowNum;r++){//读取每一行，第一行为标题，从第二行开始
						rowCount = r;
						HSSFRow row = st.getRow(r);
						MlfrontReview reviewOne = new MlfrontReview();
						HSSFCell getCell = null;
						getCell = row.getCell(0);
						if (getCell != null) {
		                    getCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		                    reviewOne.setReviewUname(getCell.getStringCellValue());
		                    
		                    String reviewUname = reviewOne.getReviewUname();
		                    String UimgUrl = getReviewImgUrl(request,response,reviewUname);
		                    reviewOne.setReviewUimgurl(UimgUrl);
		                    
		                    //做特殊字符转移处理
		            		String afterReviewUname = reviewUname.replaceAll("[^\\u0000-\\uFFFF]", "");
		            		reviewOne.setReviewUname(afterReviewUname);
		                }
						getCell = row.getCell(1);
						if (getCell != null) {
		                    getCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		                    reviewOne.setReviewPid(Integer.parseInt(getCell.getStringCellValue()));
		                }
						getCell = row.getCell(2);
						if (getCell != null) {
		                    getCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		                    reviewOne.setReviewCreatetime(getCell.getStringCellValue());
		                }
						getCell = row.getCell(3);
						if (getCell != null) {
		                    getCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		                    reviewOne.setReviewMotifytime(getCell.getStringCellValue());
		                    reviewOne.setReviewConfirmtime(getCell.getStringCellValue());
		                    reviewOne.setReviewSupercateidstr("1");
		                }
						getCell = row.getCell(4);
						if (getCell != null) {
		                    getCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		                    reviewOne.setReviewPseoname(getCell.getStringCellValue());
		                }
						getCell = row.getCell(5);
						if (getCell != null) {
		                    getCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		                    reviewOne.setReviewStatus(Integer.parseInt(getCell.getStringCellValue()));
		                }
						getCell = row.getCell(6);
						if (getCell != null) {
		                    getCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		                    String intoReviewMessage = getCell.getStringCellValue();
		                    String afterMessage = intoReviewMessage.replaceAll("[^\\u0000-\\uFFFF]", "");
		                    reviewOne.setReviewDetailstr(afterMessage);
		                }
						getCell = row.getCell(7);
						if (getCell != null) {
		                    getCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		                    reviewOne.setReviewProstarnum(Integer.parseInt(getCell.getStringCellValue()));
		                }
						getCell = row.getCell(8);
						if (getCell != null) {
		                    getCell.setCellType(HSSFCell.CELL_TYPE_STRING);
		                    reviewOne.setReviewFrom(Integer.parseInt(getCell.getStringCellValue()));
		                }
						reviewList.add(reviewOne);
					}
					is.close();
					for(MlfrontReview mlfrontReview:reviewList){
						mlfrontReviewService.insertSelective(mlfrontReview);
					}
				}catch (Exception e) {
					System.out.println("第行出错");
					e.printStackTrace();
				}
			}
		}catch (Exception e) {
			System.out.println("第行出错");
			e.printStackTrace();
		}
	}
	
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
