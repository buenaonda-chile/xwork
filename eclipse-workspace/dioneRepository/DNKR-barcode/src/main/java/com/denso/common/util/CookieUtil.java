package com.denso.common.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {
	/**
  	 * 쿠키 에서 name 에 해당하는 value가져 오기
  	 * @param name
  	 * @param request
  	 * @return
  	 * @throws Exception
  	 */
  	public static String getCookieVal(String name, HttpServletRequest request) throws Exception{
  		String resultVal = null;
  		
  		Cookie[] cookies = request.getCookies();
  		if (cookies != null && cookies.length > 0) {
    		for (Cookie cookie : cookies) {
    			if (name.equals(cookie.getName())) {
    				resultVal = cookie.getValue();
    				break;
    			}
    		}
    	}
  		
  		return nvl(resultVal, "");
  	}
  	
  	/**
     * <PRE>
     * src가 null거나 ""이면 tgt값으로 치환하여 return한다.
     *
     * @param String 입력받은 String
     * @return 치환된 String
     *         </PRE>
     */
    public static String nvl(String src, String tgt) {
        String res = tgt;
        if (tgt == null) res = "";
        if (src == null) return res;
        else if (src.equals("")) return res;
        else return src;
    }
    
    public static String nvl(String src) {
        String res = "";
        if (src == null) return res;
        else if (src.equals("")) return res;
        else return src;
    }  
}
