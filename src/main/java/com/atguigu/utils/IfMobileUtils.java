package com.atguigu.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IfMobileUtils {
	
	/**
	 * 返回信息
	 * */
	public static String  isMobileOrPc(HttpServletResponse reponse,HttpServletRequest request){
		String nowTime = DateUtil.strTime14s();
		String requestHeader = request.getHeader("user-agent");
		if(isMobileDevice(requestHeader)){
			System.out.println("nowTime:"+nowTime+"使用手机浏览器");
			return "1";
		}else{
			System.out.println("nowTime:"+nowTime+"使用web浏览器");
			return "0";//真实PC首页
		}
	}
	
	/**
	 * 判断设备型号
	 * */
	public static boolean  isMobileDevice(String requestHeader){
        /**
         * android :所有android设备
         * mac os : iphone ipad
         * windows phone:Nokia等windows系统的手机
         */
        String[] deviceArray = new String[]{"android","mac os","windows phone"};
        if(requestHeader == null)
            return false;//pc
        requestHeader = requestHeader.toLowerCase();
        for(int i=0;i<deviceArray.length;i++){
        	//System.out.println("deviceArray[i]:"+deviceArray[i]);
            if(requestHeader.indexOf(deviceArray[i])>0){
                return true;//移动
            }
        }
        return false;
	}

}
