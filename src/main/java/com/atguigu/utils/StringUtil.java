package com.atguigu.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.Map;

/**
 * 字符串工具类
 * @author 任水
 *
 */
public class StringUtil{
	
	public static final String STR_FRONT = "front"; //字符串前面
	public static final String STR_BACK = "back"; //字符串后面
	/** 空字符串。 */
	public static final String EMPTY_STRING = "";
	/**
	 * 
	 * description: 去除字符串前后的空格，若<code>str</code>为<code>null</code>,返回空串
	 * @param str
	 * @return
	 */ 
    public static String trim(String str) {
        return str == null ? "" : str.trim();
    }
    /**
     * 
     * description:去除字符串对象空格
     * @param str
     * @return
     */ 
    public static String trim(Object obj) {
    	return obj == null ? "" : trim(obj.toString());
    }
    /**
     * 
     * description: 判断<code>str</code>是否为空串或<code>null</code>
     * @param str
     * @return 若为空串或<code>null</code>返回<code>true</code>,否则返回<code>false</code>
     */
    public static boolean isEmpty(String str){
    	str = trim(str);
    	if("".equals(str))
    		return true;
    	else
    		return false;
    }
    /**
     * 
     * description: 判断<code>str</code>是否为空串或<code>null</code>
     * @param str
     * @return 若为空串或<code>null</code>返回<code>false</code>,否则返回<code>true</code>
     */
    public static boolean isNotEmpty(String str){
    	return !isEmpty(str);
    }
    /**
     * 
     * description: 去掉obj中string类型字段值的空格，若obj为String,则将obj去空格后返回
     * @param obj
     * @return
     */
    @SuppressWarnings("unchecked")
	public static Object trimObjectFields(Object obj){
    	if(obj == null )
    		return "";
    	Class cls = obj.getClass();
    	if(obj instanceof String)
    		return trim(obj.toString());
    	Field[] fields = cls.getDeclaredFields();
    	try{
	    	for(Field field : fields){
	    		field.setAccessible(true);
	    		if (!Modifier.isStatic(field.getModifiers()) && Modifier.isPrivate(field.getModifiers())) {
	    			Object value = field.get(obj);
	    			if(value instanceof String && null != value){
		    			String resultStr = StringUtil.trim((String)value);
		    			String name = field.getName();
		    			String setMethodName = "set"+name.substring(0, 1).toUpperCase()+name.substring(1);
		    			Method setMethod = obj.getClass().getMethod(setMethodName, String.class);
		    		    setMethod.setAccessible(true);
		    			setMethod.invoke(obj, resultStr);
		    		}
				}
	    		
	    	}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return obj;
    }
    /**
     * 
     * description: 去掉obj中string类型字段值的空格，若obj为String,则将obj去空格后返回
     * @param obj
     * @return
     */
    @SuppressWarnings("unchecked")
	public static Object trimObjectFieldsOptional(Object obj){
    	if(obj == null )
    		return "";
    	Class cls = obj.getClass();
    	if(obj instanceof String)
    		return trim(obj.toString());
    	Field[] fields = cls.getDeclaredFields();
    	try{
	    	for(Field field : fields){
	    		String type = field.getType().getSimpleName().toString();
	    		String name = field.getName();
	    		if("String".equals(type)){
	    			try {
	    				String getMethod = "get"+name.substring(0, 1).toUpperCase()+name.substring(1);
	    				Method get = cls.getMethod(getMethod);
	    				String value = "";
	    				Object objvalue = get.invoke(obj);
	    				if(null!=objvalue){
	    					value = trim(objvalue.toString());
	    				}
	    				String setMethod = "set"+name.substring(0, 1).toUpperCase()+name.substring(1);
	    				Method set = cls.getMethod(setMethod,String.class);
	    				set.invoke(obj, value);
	    			} catch (Exception e) {
	    				
	    			}
	    		}
	    	}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return obj;
    }
    /**
     * 去掉map中string类型字段值的空格，若value为String,则将obj去空格后返回
     * @param obj
     * @return
     */
	@SuppressWarnings("unchecked")
	public static Map trimMap(Map map){
    	if(map == null )
    		return null;
    	try{
    		Iterator it = map.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				Object key = entry.getKey();
				Object value = entry.getValue();
				if (value instanceof String) {
					String valueStr = StringUtil.trim((String)value);
					map.put(key, valueStr);
				} else {
					if (value instanceof Map) {
						value = trimMap((Map)value);
					} else {
						value = StringUtil.trimObjectFields(value);
						map.put(key, value);
					}
				}
			} 
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return map;
    }
	/**
	 * 在原串的前面或者后面添加字符
	 * @param str 原字符串
	 * @param len 生产的字符串长度
	 * @param fillChar 填充的字符
	 * @param position 填充的位置，默认为原串的前面
	 * @return
	 * @see:
	 */
	public static String replenish(String str, int len, char fillChar, String position){
		str = trim(str);
		if (str.length() >= len) {
			return str;
		}
		
		String addStr = "";
		for (int i = str.length(); i < len; i++) {
			addStr += fillChar;
		}
		
		if (position.equals(STR_FRONT)) {
			str = addStr + str;
		} else {
			str = str + addStr;
		}
		
		return str;
		
	}
	/**
	 * 填充字符串为16位
	 * @param str 原字符串
	 * @param fillChar 填充的字符
	 * @return
	 * @see:
	 */
	public static String fillThString16(String str,  String fillChar){
		int len=16;
		str = trim(str);
		if (str.length() >= 16) {
			return str.substring(0,16);
		}
		
		String addStr = "";
		for (int i = str.length(); i < len; i++) {
			addStr += fillChar;
		}
			str = str + addStr;
		
		return str;
		
	}
	public static String subString(String str,int maxLength){
		return str.substring(0,maxLength);
	}
	 /**
     * 判断字符串长度是否大于某个值
     */
    public static boolean isOverMaxLength(String str,int maxLength){
    	if(str.getBytes().length>maxLength){
    		return true;
    	}
    	return false;
    }
    
    /**
     * 根据路径获取文件名
     * @param path
     * @return
     */
    public static String getFileName(String path){
    	path = trim(path);
		if("".equals(path)){
			return path;
		}
		String srcFileName="";
		int post1 = path.lastIndexOf("/");
		int post2 = path.lastIndexOf("\\");
		if(post1<post2){
			srcFileName = path.substring(post2+1);
		}else{
			srcFileName = path.substring(post1+1);
		}
		return srcFileName;
    }
    
	/**
	 * 使用java正则表达式去掉多余的.与0
	 * @param s
	 * @return 
	 */
	public static String subZeroAndDot(String s){
		if(s.indexOf(".") > 0){
			s = s.replaceAll("[0]*$", "");//去掉多余的0
			if (String.valueOf(s.charAt(s.length() - 1)).equals(".")) {
				s = s.substring(0, s.length() - 1);
			}
			//s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
		}
		return s;
	}
	/**
	 * desc:过滤特殊字符，例如%，<
	 * <p>创建人：chengliuyun , Feb 21, 2013 4:30:42 PM</p>
	 * @param input
	 * @return
	 */
	public static String filterString(String input) {
		if (input == null || "".equals(input.trim()) || "null".equals(input.trim())) {
			return "";
		}
		// 去掉所有html元素, sql 元素
		String ret = input.replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>",
				"").replaceAll("[(/>)<]", "").replace("%", "").
				replaceAll(" and ", "").replaceAll(" AND ", "").replaceAll(" or ", "").replaceAll(" OR ", "");
		return ret;
	}
	/**
     * 判断一个字符是Ascill字符还是其它字符（如汉，日，韩文字符）
     * @param char c, 需要判断的字符
     * @return boolean, 返回true,Ascill字符
     */
    public static boolean isLetter(char c) {
        int k = 0x80;
        return c / k == 0 ? true : false;
    }
    /**
     * 得到一个字符串的长度,显示的长度,一个汉字或日韩文长度为2,英文字符长度为1
     * @param String s ,需要得到长度的字符串
     * @return int, 得到的字符串长度
     */
    public static int length(String s) {
        if (s == null)
            return 0;
        char[] c = s.toCharArray();
        int len = 0;
        for (int i = 0; i < c.length; i++) {
            len++;
            if (!isLetter(c[i])) {
                len++;
            }
        }
        return len;
    }
    /**
     * 截取混合字符的长度,不区分中英文,如果数字不正好，则少取一个字符位
     * @author patriotlml
     * @param String origin, 原始字符串
     * @param int len, 截取长度(一个汉字长度按2算的)
     * @return String, 返回的字符串
     * @throws Exception 
     */
    public static String subMultString(String origin, int len) throws Exception {
        if (origin == null || origin.equals("")||len<1)
            return "";
        byte[] strByte = new byte[len];
        if (len > length(origin)){
            return origin;}
        System.arraycopy(origin.getBytes("GBK"), 0, strByte, 0, len);
        int count = 0;
        for (int i = 0; i < len; i++) {
            int value = (int) strByte[i];
            if (value < 0) {
                count++;
            }
        }
        if (count % 2 != 0) {
            len = (len == 1) ? ++len : --len;
        }
        return new String(strByte, 0, len, "GBK");
    }
    
	/**
	 * 关键字用* 替换
	 * 规则：  value >= 15 位     前6位保留  中间*  后4位保留    
	 * @param value
	 * @return 
	 */
    public static String replaceChar(String value){
		if(StringUtil.isEmpty(value)){
			return "";
		}else{
			if(value.length() >= 15){ //前6位保留  中间*  后4位保留 
		    	String replaceHeadStr = value.substring(0,6);
		    	String replaceTailStr = value.substring(value.length()-4);
		    	String dimStr = lStr("",'*',value.length()-10);
		    	return replaceHeadStr+dimStr+ replaceTailStr;
			}else{
				return "";
			}
		}
	}
	/**
	 * 左补长char
	 */
    public static String lStr(String s, char ch, int width) {
        if (s.length() < width) { // 需要前面补'0'
            while (s.length() < width)
                s = ch + s;
        } else { // 需要将高位丢弃
            s = s.substring(s.length() - width, s.length());
        }
        return s;
    }
    
    /**                                                                                                            
      * 取指定字符串的子串（截取字符串） 
      * 负的索引代表从尾部开始计算。如果字符串为<code>null</code>，则返回<code>null</code>。                              
      * StringUtil.substring(null, *)   = null                                                                            
      * StringUtil.substring("", *)     = ""                                                                              
      * StringUtil.substring("abc", 0)  = "abc"                                                                           
      * StringUtil.substring("abc", 2)  = "c"                                                                             
      * StringUtil.substring("abc", 4)  = ""                                                                              
      * StringUtil.substring("abc", -2) = "bc"                                                                            
      * StringUtil.substring("abc", -4) = "abc"                                                                           
      * @author renjie
      * @param str 字符串                                                                                                 
      * @param start 起始索引，如果为负数，表示从尾部查找                                                                 
      * @return 子串，如果原始串为<code>null</code>，则返回<code>null</code>                                              
      */                                                                                                                  
     public static String substring(String str, int start) {                                                              
         if (str == null) {                                                                                               
             return null;                                                                                                 
         }                                                                                                                
                                                                                                                          
         if (start < 0) {     
        	 if((str.length()+start)>=0){
        		 start = str.length() + start;
        	 }else {
        		 return str;   
			}
         }                                                                                                                
                                                                                                                          
         if (start == 0) {                                                                                                 
             start = 0;                                                                                                   
         }                                                                                                                
                                                                                                                          
         if (start > str.length()) {                                                                                      
             return EMPTY_STRING;                                                                                         
         }                                                                                                                
                                                                                                                          
         return str.substring(start);                                                                                     
     }                                                                                                                    
                                                                                                                          
     /**                                                                                                                  
      * 取指定字符串的子串（截取字符串）
      * 负的索引代表从尾部开始计算。如果字符串为<code>null</code>，则返回<code>null</code>。                                                                                                                                        
      * StringUtil.substring(null, *, *)    = null                                                                        
      * StringUtil.substring("", * ,  *)    = "";                                                                         
      * StringUtil.substring("abc", 0, 2)   = "ab"                                                                        
      * StringUtil.substring("abc", 2, 0)   = ""                                                                          
      * StringUtil.substring("abc", 2, 4)   = "c"                                                                         
      * StringUtil.substring("abc", 4, 6)   = ""                                                                          
      * StringUtil.substring("abc", 2, 2)   = ""                                                                          
      * StringUtil.substring("abc", -2, -1) = "b"                                                                         
      * StringUtil.substring("abc", -4, 2)  = "ab"                                                                        
      * @author renjie                                                                                                              
      * @param str 字符串                                                                                                 
      * @param start 起始索引，如果为负数，表示从尾部计算                                                                 
      * @param end 结束索引（不含），如果为负数，表示从尾部计算                                                           
      * @return 子串，如果原始串为<code>null</code>，则返回<code>null</code>                                              
      */                                                                                                                  
     public static String substring(String str, int start, int end) {                                                     
         if (str == null) {                                                                                               
             return null;                                                                                                 
         }                                                                                                                
                                                                                                                          
         if (end < 0) {                                                                                                   
             end = str.length() + end;                                                                                    
         }                                                                                                                
                                                                                                                          
         if (start < 0) {                                                                                                 
             start = str.length() + start;                                                                                
         }                                                                                                                
                                                                                                                          
         if (end > str.length()) {                                                                                        
             end = str.length();                                                                                          
         }                                                                                                                
                                                                                                                          
         if (start > end) {                                                                                               
             return EMPTY_STRING;                                                                                         
         }                                                                                                                
                                                                                                                          
         if (start == 0) {                                                                                                 
             start = 0;                                                                                                   
         }                                                                                                                
                                                                                                                          
         if (end == 0) {                                                                                                   
             end = 0;                                                                                                     
         }                                                                                                                
                                                                                                                          
         return str.substring(start, end);                                                                                
     }                                                                                                                    

    
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
//		Map reqMap = new HashMap();
//		reqMap.put(XmlData.ACCOUNTID, "02000000040507            ");
//		reqMap.put(XmlData.USERID, 123);
//		Map mediaItems = new HashMap();
//		mediaItems.put(XmlData.ACCOUNTID, "1     ");
//		mediaItems.put(XmlData.NAME, "hello1");
//		reqMap.put("mediaItems", mediaItems);
//		System.out.println(reqMap);
//		
//		reqMap = StringUtil.trimMap(reqMap);
//		System.out.println(reqMap);
		//0001259968
//		String str = "1259968";
		String str = "125";
		int len = -4; 
//		char fillChar = '0';
//		String position = STR_FRONT;
//		String resultStr = replenish(str, len, fillChar, position);
		String resultStr = substring(str, len);
		System.out.println(resultStr);
		
	}
}