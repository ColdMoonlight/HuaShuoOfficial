package com.atguigu.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* ******************DateUtil*********************
 * class       :  DateUtil
 * @author     :  zhoushaohua
 * @version    :  1.0  
 * description :  
 * @see        :                        
 * ************************************************/

public class DateUtil {

	public static String formatDay8Str = "yyyyMMdd";
	
	public static String strDateTime(String paramString, Date paramDate) {
		String str = null;
		SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(paramString);
		if (paramDate == null)
			paramDate = new Date();

		return str = localSimpleDateFormat.format(paramDate);
	}

	public static String strGsmTime() {
		return strDateTime("yyMMddHHmmss") + "08+";
	}

	public static String strTime14() {
		return strDateTime("yyyyMMddHHmmss");
	}
	
	public static String strTime14s() {
		return strDateTime("yyyy-MM-dd HH:mm:ss");
	}

	public static String strTime6() {
		return strDateTime("HHmmss");
	}

	public static String strTimeMSec() {
		return strDateTime("[HH:mm:ss.SSS] ");
	}

	public static String strDate8() {
		return strDateTime("yyyyMMdd");
	}

	public static String strDateTime(String paramString) {
		return strDateTime(paramString, null);
	}
	
	/*
	 * ********************************************
	 * method name   : str2Date 
	 * description   : 
	 * @return       : Date
	 * @param        : @param str
	 * @param		 : @patternStr
	 * @param        : @return
	 * @param        : @throws Exception
	 * modified      : lizhibin ,  2013-12-3
	 * @see          : 
	 * *******************************************
	 */
	public static Date str2Date(String str, String patternStr) throws Exception{
		SimpleDateFormat sf = new SimpleDateFormat(patternStr);
		return sf.parse(str);
	}
	/** 
     * ��String�͸�ʽ��,������Ҫ��2011-11-11��ʽ����2011��11��11��,��StringPattern("2011-11-11","yyyy-MM-dd","yyyy��MM��dd��").
     * @param date String ��Ҫ��ʽ��������
     * @param oldPattern String ��Ҫ��ʽ�������ڵ����и�ʽ
     * @param newPattern String ��Ҫ��ʽ����ʲô��ʽ
     * @return String 
     */ 
    public static String StringPattern(String date,  String newPattern) { 
        if (StringUtil.isEmpty(date)||StringUtil.isEmpty(newPattern)){
        	return ""; 
        }
        SimpleDateFormat sdf = new SimpleDateFormat(newPattern) ;        // ʵ��ģ�����  
        Date d = null ;  
        try{  
            d = sdf.parse(date) ;   // ������ַ��е�������ȡ����  
        }catch(Exception e){            // ����ṩ���ַ��ʽ�д���������쳣����  
        	e.printStackTrace();
        }  
        return sdf.format(d);
    } 
    
    public static String addMonth (String source ,String formats,String formatd,int addMonth)  throws Exception{
            SimpleDateFormat sdfs = new SimpleDateFormat (formats);
            SimpleDateFormat sdfd = new SimpleDateFormat (formatd);
            Date date = sdfs.parse (source);
            Calendar calendar = Calendar.getInstance ();
            calendar.setTime (date);
            calendar.add (Calendar.MONTH, addMonth);
            return sdfd.format (calendar.getTime ());
    }
 
	/**
	 * �ж������Ƿ���key�������Ƿ����������������ڷ�Χ��
	 * @param date String ��Ҫ��ʽ��������
	 * startDate yyyy-MM-dd
	 * @throws ParseException 
	 */
	public static boolean isBetweenDate(String nowDate,String startDate,String endDate) throws ParseException{
		
		SimpleDateFormat fm_reqDate = new SimpleDateFormat("yyyyMMdd");
		Date fromat_reqDate = fm_reqDate.parse(nowDate);
		Date fromat_startDate = fm_reqDate.parse(startDate);
		Date fromat_endDate = fm_reqDate.parse(endDate);
		
		boolean flag = (fromat_reqDate.compareTo(fromat_startDate)>=0)&&(fromat_reqDate.compareTo(fromat_endDate)<=0);
		
		return flag;
	}

	/**
	 * ת������ʱ���ʽ
	 * @param String:yyyyMMddHHmmss
	 * @return yyyy-MM-dd HH:mm:ss
	 * @throws ParseException 
	 */
	public static String dateAndTimeFormat(String nowDate,String nowTime) {
		String s = nowDate.substring(0, 4) + "-"
				+ nowDate.substring(4, 6) + "-"
				+ nowDate.substring(6, 8) + " "
				+ nowTime.substring(0, 2) + ":"
				+ nowTime.substring(2, 4) + ":"
				+ nowTime.substring(4, 6);
		return s;
	}
	
	/**
	 * ���ڸ�ʽת��
	 * @param dateString yyyy-MM-dd
	 * @return dateString yyyyMMdd
	 */
	public static String dateStringFormat (String dateStr){
		String date = StringUtil.trim(dateStr).replace("-", "");
		return date;
	}
	
	/**
	 * ��ȡ�����ʱ��
	 * @return
	 */
	public static String getYesterday(){
		return getYesterday(formatDay8Str);
	}
	public static String getYesterday(String format){
		Date yesterday = addDay(new Date(), -1);
		String date8 = formatDate(yesterday.getTime(), format);
		return date8;
	}
	
	/**
	 * 
	 * description: ��now��������amount����
	 * @param endDate
	 * @param amount
	 * @return
	 */
	public static Date addDay(Date now, int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.DATE, amount);
		return cal.getTime();
	}
	
	/**
     *  ʱ��ĸ�ʽת������.
     * @param time long���͵�ʱ���﷽ʽ
     * @param format  ����Ҫ��ʽ���ɵ���ʽ
     * @return ���ڵ��ַ������ʽ.
     */
    public static String formatDate(long time, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        //����Ϊ������,�������Сʱ
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return sdf.format(new Date(time));
    }
    
    /**
     * desription : �����ַ����ڸ�ʽתΪ�����ټ���Ӧ�����ٸ�ʽ��ָ����ʽ
     * @param source
     * @param formats �ַ�����Ҫ��ʽ���ɵ���ʽ
     * @param format  ����Ҫ��ʽ���ɵ��ַ���ʽ
     * @param addDay  ���ӻ���ٵ�����
     * @return 
     */
    public static String addDay (String source ,String formats,String formatd,int addDay)  throws Exception{
        SimpleDateFormat sdfs = new SimpleDateFormat (formats);
        SimpleDateFormat sdfd = new SimpleDateFormat (formatd);
        Date date = sdfs.parse (source);
        Calendar calendar = Calendar.getInstance ();
        calendar.setTime (date);
        calendar.add (Calendar.DAY_OF_MONTH, addDay);
        return sdfd.format (calendar.getTime ());
	}
    
    public static String date8(Date date) {
		return new SimpleDateFormat(formatDay8Str).format(date);
	}
    
    /**
	 * ��ȡϵͳʱ��
	 * @return
	 */
	public static String getDateTime(){
		return new SimpleDateFormat("yyyyMMdd").format(new Date());
	}
	
	/**
	 * 获取倒计时计时数ֵ
	 * @return
	 */
	public static int getFreeTimes(Long earryTime){
		//获取当前系统时间
		long nowTime = System.currentTimeMillis();
		long Xtime = nowTime  - earryTime;
		
		int XtimeRes = 0;
		//Xtime - nowTime
		Long AllFree = (long) (30*60*1000);
		//判断信息
		if(Xtime>AllFree){
			XtimeRes = -1;
		}else{
			XtimeRes = (int) (AllFree - Xtime)/1000;
		}
		return XtimeRes;
	}
	
	
	/**
	 * @author zsh
	 * 获取当前时间前N小时的时间
	 * @return
	 * */
	public static String dateRoll(int ihour) {
	      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	      //（1）获取当前时间
	      LocalDateTime date = LocalDateTime.now();
	      //（2）获取当前时间的前几小时时间
	      LocalDateTime localDateTime = date.minusHours(ihour);
	      
	      date.minusMinutes(ihour);

	      return dateTimeFormatter.format(localDateTime);
	  }
	
	/**
	 * @author zsh
	 * 获取当前时间前N小时的时间
	 * @return
	 * */
	public static String dateRollMinus(int iminute) {
	      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	      //（1）获取当前时间
	      LocalDateTime date = LocalDateTime.now();
	      //（2）获取当前时间的前几小时时间
	      LocalDateTime localDateTime = date.minusMinutes(iminute);

	      return dateTimeFormatter.format(localDateTime);
	  }
}
