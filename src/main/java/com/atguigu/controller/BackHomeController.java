package com.atguigu.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.atguigu.bean.CrmAdmin;
import com.atguigu.common.Const;

@Controller
@RequestMapping("/BackHome")
public class BackHomeController {
	
	/**
	 * zsh 200730
	 * 中控台首页
	 * */
	@RequestMapping("/tologin")
	public String tologin(HttpSession session) throws Exception{
		
		return "back/crmAdminLogin";
	}
	
	/**
	 * zsh 200730
	 * 中控台首页
	 * */
	@RequestMapping("/BackHomePage")
	public String backHome(HttpSession session) throws Exception{
		
		CrmAdmin mlbackAdmin =(CrmAdmin) session.getAttribute(Const.ADMIN_USER);
		if(mlbackAdmin==null){
			//SysUsers对象为空
			return "back/crmAdminLogin";
		}else{
			return "back/crmHomePage";
		}
	}
	
}
