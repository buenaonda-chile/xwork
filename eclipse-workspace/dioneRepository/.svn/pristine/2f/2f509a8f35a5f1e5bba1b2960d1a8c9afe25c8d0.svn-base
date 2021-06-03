package com.globaldenso.dnkr.uxis;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.constant.DnkrDb2Constans;
import com.globaldenso.dnkr.domain.RelationLocDomain;
import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;
 
/**
 * 
 * <p>
 * Describe the detail of this class.
 * </p>
 *
 * @author GBS
 * @version 1.0
 */
public class UxisCmmUtil {
    
    /**
     * 쿠키 만료일 
     */
    private static final int COOKIE_EXPIRATION_DATE = 60 * 60 * 24 * 30;
    
    /**
     * Constructor.
     */
    public UxisCmmUtil() {
    }

/** 날짜 관련 함수 모음 */

    /**
     * 오늘 년도를 가져온다.
     * @return  int Type의 년도
     */
    public static int getYear(){
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR);
    }

    /**
     * 오늘 달를 가져온다.
     * @return      int Type의 달
     */
    public static int getMonth(){
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * 오늘 일자를 가져온다.
     * @return  int Type의 일
     */
    public static int getDay(){
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.DAY_OF_MONTH);
    }
    
    /**
     * 현제 시간을 가져온다.
     * @return  int Type의 시간
     */
    public static int getTime(){
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 오늘 달의 마지막 날짜를 가져온다.
     * @return  int Type의 날짜
     */
    public static int getMaxDay(){
        return getMaxDay(getMonth());
    }
    
    /**
     * 해당 달의 마지막 날짜를 가져온다.
     * @param _month  int Type의 달
     * @return  int Type의 날짜
     */
    public static int getMaxDay(int _month){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, _month - 1, 1);

        return cal.getActualMaximum(Calendar.DATE);
    }

    /**
     * php mktime 메소드 구현
     * @param second        int Type의 초
     * @param minute        int Type의 분
     * @param hourOfDay     int Type의 시
     * @param date          int Type의 날짜
     * @param month         int Type의 달
     * @param year          int Type의 년
     * @return              long Type의 UNIX Time값
     */
    public static long mktime(int second, int minute, int hourOfDay, int date, int month, int year){
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, date, hourOfDay, minute , second);
        return cal.getTime().getTime() / 1000;
    }
    
    /**
     * 오늘 날자를 UNIX TIME 값으로 넘겨준다.
     * @return  long Type의 UNIX Time 값
     */
    public static long todayMktime(){
        return mktime(0, 0, 0, getDay(), getMonth() , getYear());
    }

    /**
     * php time() 메소드
     * @return  long Type의 UNIX Time 값
     */
    public static long time(){
        Calendar cal = Calendar.getInstance();
        return cal.getTime().getTime() / 1000;
    }

    /**
     * UNIX Time 값을 Type에 따라 요일(w), 날짜(m), 달(d), 년(Y) 값을 되돌려준다. 
     * @param type      String Type 처리 타입 값 (w,m,d,Y)
     * @param time      long Type UNIX Time
     * @return          int
     */
    public static int date(String type, long time){
        time *= 1000;
        if(type.equals("w")){
            return dateWeek(time);
        }else if(type.equals("m")){
            return dateMonth(time);
        }else if(type.equals("d")){
            return dateDay(time);
        }else if(type.equals("Y")){
            return dateYear(time);
        }else{
            return 0;
        }
    }

    /**
     * UNIX Time 값을 요일 명(한글)으로 변경
     * @param time  long Type의 UNIX Time
     * @return      String Type의 요일 명
     */
    public static String weekStr(long time){
        time *= 1000;
        int weekInt = dateWeek(time);
        
        if(weekInt == 1){
            return "일";
        }else if(weekInt == 2){
            return "월";
        }else if(weekInt == 3){
            return "화";
        }else if(weekInt == 4){
            return "수";
        }else if(weekInt == 5){
            return "목";
        }else if(weekInt == 6){
            return "금";
        }else if(weekInt == 7){
            return "토";
        }else{
            return "";
        }
    }

    /**
     * UNIX Time 값을 요일 명(영문)으로 변경 
     * @param time  long Type의 UNIX Time
     * @return      String Type의 요일 명
     */
    public static String weekEng(long time){
        time *= 1000;
        int weekInt = dateWeek(time);
        if(weekInt == 1){
            return "Sunday";
        }else if(weekInt == 2){
            return "Monday";
        }else if(weekInt == 3){
            return "Tuesday";
        }else if(weekInt == 4){
            return "Wednesday";
        }else if(weekInt == 5){
            return "Thursday";
        }else if(weekInt == 6){
            return "Friday";
        }else if(weekInt == 7){
            return "Saturday";
        }else{
            return "";
        }
    }

    /**
     * UNIX Time 값을  요일 값으로 변경 
     * @param time  long Type의 UNIX Time
     * @return      int 요일(일요일은 1, 토요일은 7)
     */
    public static int dateWeek(long time){
        Date nDate = new Date(time);

        Calendar cal = Calendar.getInstance();
        cal.setTime(nDate);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * UNIX Time 값을 년도 값으로 변경
     * @param time  long Type의 UNIX Time
     * @return      int 년도
     */
    private static int dateYear(long time){
        Date nDate = new Date(time);

        Calendar cal = Calendar.getInstance();
        cal.setTime(nDate);
        return cal.get(Calendar.YEAR);
    }
    
    /**
     * UNIX Time 값을 월(달) 값으로 변경
     * @param time  long Type의 UNIX Time
     * @return      int 월(달)
     */
    private static int dateMonth(long time){
        Date nDate = new Date(time);

        Calendar cal = Calendar.getInstance();
        cal.setTime(nDate);
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * UNIX Time 값을 일 값으로 변경
     * @param time  long Type의 UNIX Time
     * @return      int 일
     */
    private static int dateDay(long time){
        Date nDate = new Date(time);

        Calendar cal = Calendar.getInstance();
        cal.setTime(nDate);
        return cal.get(Calendar.DAY_OF_MONTH);
    }
    
    /**
     * 4월기준으로 1년치 월 리스트 
     * @param time  년도
     * @return      List<String> ex:) 201804~201904
     */
    public static List<String> yearAprilBase(int paramYear){
    	List<String> rltList = new ArrayList<String>();
		Calendar cld = Calendar.getInstance();
		cld.set(paramYear, 2, 1);		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyMM");	
		
		for(int i=0; i<12; i++) {
			cld.add(Calendar.MONTH, 1);
			rltList.add(sdf.format(cld.getTime()));
		}
		return rltList;
    }


    /**
     * php MD5 함수
     * @param str   String Type의 문자열
     * @return      String Type의 MD5로 변형된 문자열
     */
    public static String MD5(String str){
        if(str == null || str.trim().equals("")){
            return "";
        }
        
        String encData = "";
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = str.getBytes();
            md.update(bytes);
            byte[] digest = md.digest();

            for(int i = 0; i < digest.length; i++){
                encData += Integer.toHexString(digest[i] & 0xff);
            }
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        return encData;
    }


    /**
     * 
     * @param _volume   long Type의 용량
     * @return  String  String Type의 용량 값
     */
    public static String changSize(long _volume){
        long cd = _volume;
        long changeSize = 1;
        int gubnkey = 0;
        String[] gubn = {"Byte", "KB", "MB" , "GB", "TB"};
        
        for(int x = 0; (_volume / (double)1024) > 0; x++, _volume /= (double)1024){
            gubnkey = x;
            changeSize *= 1024;
        }
        
        changeSize /= 1024;
        
        return (Math.round(( cd / ( (double)changeSize )) * 100) / 100.0) + gubn[gubnkey];
    }

    /**
     * 
     * @param _volume   long Type의 용량
     * @param _gubn     int Type의 변환 단계 값 (Byte[0], KB[1], MB[2], GB[3], TB[4])
     * @return          String Type의 용량 값
     */
    public static String changSize(long _volume, int _gubn){
        long cd = _volume;
        long changeSize = 1;
        int gubnkey = 0;
        String[] gubn = {"Byte", "KB", "MB" , "GB", "TB"} ;
        
        for(int x = 0; (_volume / (double)1024) > 0; x++, _volume /= (double)1024){
            gubnkey = x;
            changeSize *= 1024;
            if(x == _gubn){
                break;
            }
        }
        changeSize /= 1024;
        return (Math.round(( cd / ( (double)changeSize )) * 100) / 100.0) + gubn[gubnkey];
    }

    /**
     * 
     * @param _volume   long Type의 용량
     * @param _gubn     String Type의 변환 단계 값(Byte, KB, MB, GB, TB)
     * @return          float Type의 용량 값
     */
    public static float changSizeInt(long _volume, String _gubn){
        long cd = _volume;
        long changeSize = 1;
        String[] gubn = {"Byte", "KB", "MB" , "GB", "TB"};
        
        for(int x = 0; (_volume / (double)1024) > 0; x++, _volume /= (double)1024){
            changeSize *= 1024;
            if(gubn[x].equals(_gubn)){
                break;
            }
        }
        changeSize /= 1024;
        return Math.round( cd /  (double)changeSize  );
    }
    
    /**
     * 
     * @param _volume   long Type의 용량
     * @return          String Type의 용량 단위 값
     */
    public static String changSizeType(long _volume){
        String[] gubn = {"Byte", "KB", "MB" , "GB", "TB"};
        int gubnkey = 0;
        
        for(int x = 0; (_volume / (double)1024) > 0; x++, _volume /= (double)1024){
            gubnkey = x;
        }
        return gubn[gubnkey];
    }
    
    /**
     * 문자열을 구분자에 따라 분리하여 년,월,일 값으로 long Type의 UNIX Time을 생성
     * ex) changeDate('1999-01-01','-')
     * @param dateStr       String Type의 날짜
     * @param splitKey      String Type의 구분자
     * @return              long Type의 UNIX Time
     */
    public static long changeDate(String dateStr, String splitKey){
        if(!UxisStringUtil.isEmpty(dateStr)){

            String[] dates = dateStr.split(splitKey);
            
            try{
                if(!UxisStringUtil.isEmpty(dates) && dates.length >= 3){
                    return mktime(0, 0, 0, 
                            UxisStringUtil.isNullToInt(dates[2]), 
                            UxisStringUtil.isNullToInt(dates[1]), 
                            UxisStringUtil.isNullToInt(dates[0]));
                }else if(dateStr.length() == 8){
                    return mktime(0, 0, 0, 
                            UxisStringUtil.isNullToInt(dateStr.substring(0, 3)), 
                            UxisStringUtil.isNullToInt(dateStr.substring(4, 5)), 
                            UxisStringUtil.isNullToInt(dateStr.substring(6, 7)));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return 0;
    }

    /**
     * 문자열을 구분자에 따라 분리하여 시간,분 값으로 long Type의 UNIX Time을 생성
     * ex) changeTimeDate('12:00',':')
     * @param dateStr       String Type의 시간
     * @param splitKey      String Type의 구분자
     * @return              long Type의 UNIX Time
     */
    public static long changeTimeDate(String dateStr, String splitKey){
        if(!UxisStringUtil.isEmpty(dateStr)){
            String[] dates = dateStr.split(splitKey);

            try{
                if(!UxisStringUtil.isEmpty(dates) && dates.length >= 2){
                    return mktime(0, UxisStringUtil.isNullToInt(dates[1]), 
                            UxisStringUtil.isNullToInt(dates[0]), 
                            0, 0, 0);
                }else if(dateStr.length() == 5){
                    return mktime(0, UxisStringUtil.isNullToInt(dateStr.substring(2, 3)), 
                            UxisStringUtil.isNullToInt(dateStr.substring(0, 1)), 
                            0, 0, 0);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        return 0;
    }

    /**
     * 대상 문자열과 문자열을 비교하여 같은 문자열이 존재 여부 
     * @param object        String Type의 비교대상 문자열
     * @param targets       String Type의 비교 문자열
     * @return              boolean Type의 문자열 동일 여부
     */
    public static boolean equals(String object, String... targets){
        for(String target : targets){
            if(object.equals(target)){
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param value     String
     * @return          String
     */
    public static String filePathBlackList(String value) {
        String returnValue = value;
        if (returnValue == null || returnValue.trim().equals("")) {
            return "";
        }

        returnValue = returnValue.replaceAll("\\.\\./", ""); // ../
        returnValue = returnValue.replaceAll("\\.\\.\\\\", ""); // ..\

        return returnValue;
    }

    /**
     * 인자로 주어진 문자열을 Key값으로 하는 프로퍼티 값을 반환한다(Globals.java 전용)
     * @param keyName String
     * @return String
     */
    public static String getProperty(String keyName) {
        String value = "";
        //property파일의 경로에 공백이 있으면 톰캣에러발생
        String propertiesPath = UxisCmmUtil.class.getResource("").getPath().substring(0, UxisCmmUtil.class.getResource("").getPath().lastIndexOf("com")) 
            + "jdbc-miyabi.properties";

        FileInputStream fis = null;
        try {
            Properties props = new Properties();

            fis = new FileInputStream(filePathBlackList(propertiesPath));

            props.load(new BufferedInputStream(fis));
            if (props.getProperty(keyName) == null) {
                return "";
            }
            value = props.getProperty(keyName).trim();
        } catch (FileNotFoundException fne) {
            throw new RuntimeException("Property file not found", fne);
        } catch (IOException ioe) {
            throw new RuntimeException("Property file IO exception", ioe);
        } finally {
            close(fis);
        }

        return value;
    }

    /**
     * Resource close 처리.
     * @param resources     Closeable Type
     */
    public static void close(Closeable  ... resources) {
        for (Closeable resource : resources) {
            if (resource != null) {
                try {
                    resource.close();
                } catch (Exception ignore) {
                }
            }
        }
    }

    /**
     * 세션에 저장되어있는 데이터를 받아온다. 
     * @param request           HttpServletRequest
     * @param name              String
     * @return                  String
     * @throws ParseException   
     */
    public static String getSessionData(HttpServletRequest request, String name) throws ParseException{
        /*세션에 저장된 아이디 받아오기 */
        String empInfo = request.getSession().getAttribute("ACCOUNT").toString();

        JSONParser parser = new JSONParser();
        Object empInfoObj = parser.parse(empInfo);
        JSONObject empJsonObj = (JSONObject)empInfoObj;
        String data = (String)empJsonObj.get(name);

        return data;
    }

    /**
     * 개인권한 가져오기
     * 세션에 팀별권한, 개인권한 구분해서 담아져 있는 map 을 받아서
     * 해당 메뉴코드로 구분하여 이전법을 변환하여 string 4자리로 반환
     * @param request   HttpServletRequest
     * @param menuCode  String
     * @return          String
     * @throws ParseException 
     */
    public static String getSessionAuthData(HttpServletRequest request, String menuCode) throws ParseException{

        Map<String, Integer> map = (Map)request.getSession().getAttribute("menuMap");
        int authNum = 0;
        if(map == null || map.size() < 1){
            authNum = 0;
        }else{
            authNum = map.get(menuCode);
        }

        StringBuffer sBuffer = new StringBuffer(); 

        if(authNum > 0){
            for(int i = 0; i < Integer.numberOfLeadingZeros(authNum) - 28; i++) {
                sBuffer.append(0);
            }
            sBuffer.append(Integer.toBinaryString(authNum));
        }else {
            sBuffer.append("0000");
        }

        return sBuffer.toString();
    }

    /**
     * [EN] I will create a Cookie .
     * [JP] 指定された名前、値のCookieを作成します。
     * 
     * @param request [EN] HTTP request [JP] HTTPリクエスト
     * @param name [EN] The name of the Cookie [JP] Cookieの名前
     * @param newvalue [EN] The value of the Cookie [JP] Cookieの値
     * @return [EN] Cookie object you created [JP] 作成したCookieオブジェクト
     */
    public static Cookie makeCookie(
            HttpServletRequest request, 
            String name, 
            String newvalue) {
        
        Cookie cookie = null;
        
        /**
         * <pre>
         * 1.[EN] Cookie making processing.
         *   [EN]   I make a cookie with the appointed name, value. 
         *   [JP] クッキー作成処理
         *   [JP]   ・指定された名前、値でクッキーを作成する
         *   [JP]   ・作成したクッキーに有効期限を設定する
         *   [JP]   ・作成したクッキーのパスを設定する
         * </pre>
         */
        
        try {
            cookie = new Cookie(name, URLEncoder.encode(newvalue, request.getCharacterEncoding()));
            cookie.setMaxAge(COOKIE_EXPIRATION_DATE);
            //System.out.println(" cookie path  : " + request.getContextPath());
            cookie.setPath("/");
        } catch (UnsupportedEncodingException e) {
            throw new SystemException(e);
        }
        
        return cookie;
        
    }
    
    /**
     * [KO] 세션에 사업부 정보를 담는다.
     * [JP] 
     * 
     * @param request [EN] HTTP request [JP] HTTPリクエスト
     * @param mv ModelAndView
     */
    public static void getSessionCls (HttpServletRequest request, ModelAndView mv){
        HttpSession session = request.getSession(false);
        if (session != null) {
            mv.addObject("clsList", session.getAttribute(DnkrConstans.CLS_TYPE));
        }
    }
    
    /**
     * [KO] 세션에 사업부 정보를 담는다.
     * [JP] 
     * 
     * @param request [EN] HTTP request [JP] HTTPリクエスト
     * @param mv ModelAndView
     */
    public static void getSessionLoc (HttpServletRequest request, ModelAndView mv){
        HttpSession session = request.getSession(false);
        if (session != null) {
            mv.addObject("locList", session.getAttribute(DnkrConstans.LOC_TYPE));
        }
    }
    
    /**
     * [KO] 세션에 사업부(마산,창원,화성) 정보를 담는다.
     * [JP] 
     * 
     * @param request [EN] HTTP request [JP] HTTPリクエスト
     * @param mv ModelAndView
     */
    public static void getSessionLocToCls (HttpServletRequest request, ModelAndView mv){
        HttpSession session = request.getSession(false);
        if (session != null) {
        	ArrayList list = (ArrayList) session.getAttribute(DnkrConstans.LOC_TYPE);
        	for(int i = 0; i < list.size(); i++) {
        		RelationLocDomain relationLocDomain = (RelationLocDomain)list.get(i);
        		String locCode = relationLocDomain.getRelationCode(); //공장코드
        		
        		if(locCode.equals("LOC000004")) {
        			relationLocDomain.setRelationCode("E1"); //마산
         			relationLocDomain.setClsCode("E1"); //마산        			
        		}else if(locCode.equals("LOC000001")) {
        			relationLocDomain.setRelationCode("C1"); //  
        			relationLocDomain.setClsCode("C1"); //        			
        		}else if(locCode.equals("LOC000002")) {
        			relationLocDomain.setRelationCode("H1"); //
        			relationLocDomain.setClsCode("H1"); //        			
        		}else if(locCode.equals("LOC000003")) {
        			relationLocDomain.setRelationCode("S1"); //       			
        			relationLocDomain.setClsCode("S1"); //        			
        		}else if(locCode.equals("LOC000005")) {
        			relationLocDomain.setRelationCode("R1"); //        			
        			relationLocDomain.setClsCode("R1"); //       			
        		}
        	}
        	
//            mv.addObject("locList", session.getAttribute(DnkrConstans.LOC_TYPE));
            mv.addObject("locList", list);            
        }
    }    
    
    /**
     * [KO] 세션에 DB2 사업부 정보를 담는다.
     * [JP] 
     * 
     * @param request [EN] HTTP request [JP] HTTPリクエスト
     * @param mv ModelAndView
     */
    public static void getSessionComCode (HttpServletRequest request, ModelAndView mv){
        HttpSession session = request.getSession(false);
        if (session != null) {
            mv.addObject("codeList", session.getAttribute(DnkrDb2Constans.COM_CODE));
        }
    }
    /**
     * [KO] 세션에 사업부 정보를 담는다.
     * [JP] 
     * 
     * @param request [EN] HTTP request [JP] HTTPリクエスト
     * @param mv ModelAndView
     */
    public static void getCompsLib(CommonDb2Domain cdc){
    	String locCode = cdc.getLocCode();
    	// 사업부 코드 셋팅
    	if(locCode.equals("")) {
    		cdc.setComps(null);
    	} else if(locCode.equals(DnkrConstans.LOC_MASAN)){
        	cdc.setComps(DnkrConstans.COMPS_MASAN);
    	} else if(locCode.equals(DnkrConstans.LOC_CHANGWON)){
        	cdc.setComps(DnkrConstans.COMPS_CHANGWON);
    	} else if(locCode.equals(DnkrConstans.LOC_HONGSUNG)){
        	cdc.setComps(DnkrConstans.COMPS_HONGSUNG);
    	}else if(locCode.equals(DnkrConstans.LOC_HWASUNG)){
        	cdc.setComps(DnkrConstans.COMPS_HWASUNG);
    	}
    	
    	// LIB 셋팅
    	if(locCode.equals(DnkrConstans.LOC_MASAN)) {
        	cdc.setLib1(DnkrConstans.DNKE_LIB1);
        	cdc.setLib2(DnkrConstans.DNKE_LIB2);
    	} else {
        	cdc.setLib1(DnkrConstans.DNKA_LIB1);
        	cdc.setLib2(DnkrConstans.DNKA_LIB2);
    	}
    	// KE/KA 셋팅
    	if(locCode.equals(DnkrConstans.LOC_MASAN)) {
        	cdc.setCompany(DnkrConstans.COMPS_DNKE);
    	} else {
        	cdc.setCompany(DnkrConstans.COMPS_DNKA);
    	}
    }
    
    /**
     * [KO] 사업자 코드값 변경
     * [JP] 
     * 
     * @param request [EN] HTTP request [JP] HTTPリクエスト
     * @param mv ModelAndView
     */    
    public static String getChangeCls(String locCode) {
		if(locCode.equals("LOC000004")) {
			return "E1"; //마산
		}else if(locCode.equals("LOC000001")) {
			return"C1"; //창원  
		}else if(locCode.equals("LOC000002")) {
			return"H1"; //홍성
		}else if(locCode.equals("LOC000003")) {
			return "S1"; //화성       			
		}else if(locCode.equals("LOC000005")) {
			return "R1"; //의왕        			
		}    
		return null;
    }  
    
    /**
     * 날짜 계산
     * @param strDate
     * @param year
     * @param month
     * @param day
     * @return
     * @throws Exception
     */
    public static String addDate(String strDate, int year,int month,int day) throws Exception{
    	SimpleDateFormat dtFormat = new SimpleDateFormat("yyyyMMdd");
    	Calendar cal =Calendar.getInstance();
    	
    	Date dt = dtFormat.parse(strDate);
    	
    	cal.setTime(dt);
    	cal.add(Calendar.YEAR, year);
    	cal.add(Calendar.MONTH, month);
    	cal.add(Calendar.DATE, day);
    	
    	return dtFormat.format(cal.getTime());
    }
        
}
