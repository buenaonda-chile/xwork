package com.globaldenso.dnkr.uxis;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 

/**
 * 
 * String 관련 함수 유틸 모음
 * 
 * <p>
 * 문자열 공백 및 비교 관련 메소드 모음
 * </p>
 *
 * @author $Author$
 * @version $Revision$
 */
public class UxisStringUtil {
    /**
     * 생성자
     * Constructor.
     *
     */
    public UxisStringUtil() {}
    
    /**
     * 
     * <pre>String이 비어 있거나 혹은 null일 경우 true,</pre> 
     * <pre>아닐 경우 false 리턴</pre> 
     * @param str       String 오브젝트  null을 허용함
     * @return          boolean - 입력받은 String이  빈 문자열 도는 null일 경우 true
     */
    public static boolean isEmpty(String str){
        return str == null || str.length() == 0;
    }
    
    
    /**
     * 
     * 문자열 중 null 또는 공백데이터 존재 여부 확인
     * 
     * <p>
     * 해당 문자열을 확인하여 공백또는 null이 있을 경우 true를 없으면 false 값을 리턴 
     * </p>
     * 
     * @param str       String
     * @param strs      String 
     * @return          boolean
     */
    public static boolean isEmpty(String str, String... strs){
        for(String tempStr : strs){
            if(tempStr == null || tempStr.length() == 0){
                return true;
            }
        }
        return str == null || str.length() == 0;
    }

    /**
     * <pre>String[]이 비어 있거나 혹은 null일 경우 true,</pre> 
     * <pre>아닐 경우 false 리턴</pre> 
     * @param str       String[]
     * @return          boolean
    */
    public static boolean isEmpty(String[] str){
        return str == null || str.length == 0;
    }

    /**
     * <pre>ArrayList가 데이터가 없거나 혹은 null일 경우 true</pre>
     * <pre>아닐 경우 false 리턴</pre>
     * @param ary       List 오브젝트 null을 허용함
     * @return          boolean - 입력받은 ArrayList가 빈 데이터 또는 null일 경우 true
     */
    public static boolean isEmpty(ArrayList ary){
        return ary == null || ary.size() == 0;
    }

    /**
     * <pre>ArrayList가 데이터가 없거나 혹은 null일 경우 true</pre>
     * <pre>아닐 경우 false 리턴</pre>
     * @param ary       List 오브젝트 null을 허용함
     * @return          boolean - 입력받은 ArrayList가 빈 데이터 또는 null일 경우 true
     */
    public static boolean isEmpty(List ary){
        return ary == null || ary.size() == 0;
    }

    /**
     * <pre>HashMap이 데이터가 없거나 혹은 null일 경우 true</pre>
     * <pre>아닐 경우 false 리턴</pre>
     * @param map   HashMap
     * @return      boolean - 입력받은HashMap가 빈 데이터 또는 null일 경우 true
     */
    public static boolean isEmpty(HashMap map){
        return map == null || map.size() == 0;
    }


    /**
     * <pre>객체가 null인지 확인하고 null인 경우 "" 로 바꾸는 메서드</pre>
     * @param object 원본 객체
     * @return resultVal 문자열
     */
    public static String isNullToString(Object object) {
        String string = "";

        if (object != null) {
            string = object.toString().trim();
        }

        return string;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param strLst            String[]
     * @param cnt               int
     * @return                  String 
     */
    public static String isNullToString(String[] strLst, int cnt){
        if(strLst != null && strLst.length > cnt){
            try{
                return strLst[cnt];
            }catch(Exception e){
                return "";
            }
        }
        return "";
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param object            Object
     * @param defualt           String
     * @return                  String
     */
    public static String isNullToString(Object object, String defualt) {
        String string = "";

        if (object != null) {
            string = object.toString().trim();
        }

        if(string.equals("")){
            string = defualt;
        }

        return string;
    }

    /**
     * <pre>객체가 null인지 확인하고 null인 경우 0으로 바꾸고</pre>
     * <pre>객체가 int타입 아닐 경우 0으로 바꾸는 메서드</pre>
     * @param object            원본객체
     * @return  resultVal        숫자
     */
    public static int isNullToInt(Object object){
        if(object != null){
            try{
                return (int)object;
            }catch(Exception e){
                try{
                    return Integer.parseInt(object.toString().trim());
                }catch(Exception e2){
                    return 0;
                }
            }
        }else{
            return 0;
        }
    }

    /**
     * <pre>객체가 null인지 확인하고 null인 경우 0으로 바꾸고</pre>
     * <pre>객체가 double타입 아닐 경우 0으로 바꾸는 메서드</pre>
     * @param object            원본객체
     * @return  resultVal        숫자
     */
    public static double isNullToDouble(Object object){
        if(object != null){
            try{
                return (double)object;
            }catch(Exception e){
                try{
                    return Double.parseDouble(object.toString().trim());
                }catch(Exception e2){
                    return 0;
                }
            }
        }else{
            return 0;
        }
    }


    /**
     * <pre>객체가 null인지 확인하고 null인 경우 defualt으로 바꾸고</pre>
     * <pre>객체가 int타입 아닐 경우 defualt으로 바꾸는 메서드</pre>
     * @param object                Object
     * @param defualt               int
     * @return                      int
     */
    public static int isNullToInt(Object object, int defualt){
        if(object != null){
            try{
                return (int)object;
            }catch(Exception e){
                try{
                    return Integer.parseInt(object.toString().trim());
                }catch(Exception e2){
                    return defualt;
                }
            }
        }else{
            return defualt;
        }
    }
    
    /**
     * 
     * Describe the outline of the function for this method.
     *
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param fileName         String
     * @return                 String
     */
    public static String getExt(String fileName){
        int pos = fileName.lastIndexOf(".");
        return fileName.substring(pos + 1);
    }

    
    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param _map  HashMap<String, String>
     */
    public static void printHashMap(HashMap<String, String> _map){
        
        for(Map.Entry<String, String> elem : _map.entrySet()){
            System.out.println("키 : " + elem.getKey() + ", 값 : " + elem.getValue());
        }
    }
    
    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param strSource         String
     * @param iLength           int
     * @param cPadder           char
     * @return                  String
     */
    public static String lpad(String strSource, int iLength, char cPadder){
        StringBuffer sbBuffer = null;
        if(!isEmpty(strSource)){
            int iByteSize = getByteSize(strSource);
            if (iByteSize > iLength){
                return strSource.substring(0, iLength);
            }else if (iByteSize == iLength){
                return strSource;
            }else{
                int iPadLength = iLength - iByteSize;
                sbBuffer = new StringBuffer();
                for (int j = 0; j < iPadLength; j++){
                    sbBuffer.append(cPadder);
                }
                sbBuffer.append(strSource);
                return sbBuffer.toString();
            }
        }

        sbBuffer = new StringBuffer();
        for (int j = 0; j < iLength; j++){
            sbBuffer.append(cPadder);
        }

        return sbBuffer.toString();
    }
    
    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param str           String
     * @return              int
     */
    public static int getByteSize(String str){
        if (str == null || str.length() == 0){
            return 0;
        }
        byte[] byteArray = null;
        try{
            byteArray = str.getBytes("UTF-8");
        }catch (UnsupportedEncodingException ex){}
        if (byteArray == null){
            return 0;
        }
        return byteArray.length;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param target            String
     * @param lst               String ...
     * @return                  boolean
     */
    public static boolean stringEquals(String target, String ... lst){
        if(isEmpty(target)){
            return false;
        }
        for(String str : lst){
            if(target.equals(str)){
                return true;
            }
        }

        return false;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @return              String
     */
    public static String getTodayYString(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return sdf.format(new Date());
    }

    /**
     * [KO] 현재 월를 yyyy-MM 포맷으로 리턴</br>
     * 
     * @return              String
     */
    public static String getTodayYMString(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        return sdf.format(new Date());
    }


    /**
     * [KO] 오늘날짜를 yyyy-MM-dd 포맷으로 리턴</br>
     * 
     * @return              String
     */
    public static String getTodayYMDString(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }
    
    /**
     * [KO] 현재시각을 HH:mm 포맷으로 리턴</br>
     * 
     * @return              String
     */
    public static String getNowTimeHMString(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(new Date());
    }
    
    /**
     * [KO] 현재시각을 HH:mm:ss 포맷으로 리턴</br>
     * 
     * @return              String
     */
    public static String getNowTimeHMSString(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date());
    }
    
    /**
     * 
     * @param today String
     * @return String
     * @throws ParseException Exception
     */
    public static String getWeekOfYear(String today) throws ParseException{
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(today);
        cal.setTime(date);
        
        //System.out.println("today : " + today + "  year: " + cal.get(Calendar.YEAR) + "  month " + cal.get(Calendar.MONTH) + "  day " + cal.get(Calendar.DATE) + "  WEEK_OF_YEAR : " + cal.get(Calendar.WEEK_OF_YEAR));
        return String.valueOf(cal.get(Calendar.WEEK_OF_YEAR));
    }
}
