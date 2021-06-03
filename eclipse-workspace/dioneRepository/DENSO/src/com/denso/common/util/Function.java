package com.denso.common.util;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Function {
	/**
	 * <pre>
	 * 현재 날짜 얻어오기.
	 * 형식: YYYYMMDD
	 * </pre>
	 * @return 8자리 날짜표기 문자열
	 */
	public static String getCurrentDate() {

		// 캘린더 인스턴스 얻어오기
		java.util.Calendar currentdate = java.util.Calendar.getInstance();

		int currentYear  = currentdate.get(java.util.Calendar.YEAR);         // 년
		int currentMonth = currentdate.get(java.util.Calendar.MONTH) + 1;    // 월
		int currentDay   = currentdate.get(java.util.Calendar.DAY_OF_MONTH); // 일

		String getYear   = Integer.toString(currentYear).substring(0,4);
		String getMonth  = currentMonth < 10 ? "0" + Integer.toString(currentMonth) : Integer.toString(currentMonth);
		String getDay    = currentDay   < 10 ? "0" + Integer.toString(currentDay)   : Integer.toString(currentDay);

		return getYear+getMonth+getDay;

	}
	
	/**
	 * <pre>
	 * 현재 년도
	 * 형식: YYYY
	 * </pre>
	 * @return 4자리 년도
	 */
	public static String getYear() {

		// 캘린더 인스턴스 얻어오기
		java.util.Calendar currentdate = java.util.Calendar.getInstance();
		int currentYear  = currentdate.get(java.util.Calendar.YEAR);         // 년
		String getYear   = Integer.toString(currentYear).substring(0,4);
		return getYear;

	}
	/**
	 * <pre>
	 * 현재 월
	 * 형식: MM
	 * </pre>
	 * @return 2자리 월
	 */
	public static String getMonth() {

		// 캘린더 인스턴스 얻어오기
		java.util.Calendar currentdate = java.util.Calendar.getInstance();
		int currentMonth = currentdate.get(java.util.Calendar.MONTH) + 1;    // 월
		String getMonth  = currentMonth < 10 ? "0" + Integer.toString(currentMonth) : Integer.toString(currentMonth);
		return getMonth;

	}
	/**
	 * <pre>
	 * 현재 날짜
	 * 형식: DD
	 * </pre>
	 * @return 2자리 날짜
	 */
	public static String getDay() {

		// 캘린더 인스턴스 얻어오기
		java.util.Calendar currentdate = java.util.Calendar.getInstance();
		int currentDay   = currentdate.get(java.util.Calendar.DAY_OF_MONTH); // 일
		String getDay    = currentDay   < 10 ? "0" + Integer.toString(currentDay)   : Integer.toString(currentDay);
		return getDay;

	}

	/**
	 * <pre>
	 * 현재 시간 얻어오기.
	 * 형식: HHMMSS
	 * </pre>
	 * @return 6자리 시간표기 문자열
	 */
	public static String getCurrentTime() {

		// 캘린더 인스턴스 얻어오기
		java.util.Calendar currentdate = java.util.Calendar.getInstance();

		int currentHour  = currentdate.get(java.util.Calendar.HOUR_OF_DAY);  // 시간
		int currentMinute= currentdate.get(java.util.Calendar.MINUTE);       // 분
		int currentSecond= currentdate.get(java.util.Calendar.SECOND);       // 초

		String getHour   = currentHour  < 10 ? "0" + Integer.toString(currentHour)  : Integer.toString(currentHour);
		String getMinute = currentMinute< 10 ? "0" + Integer.toString(currentMinute): Integer.toString(currentMinute);
		String getSecond = currentSecond< 10 ? "0" + Integer.toString(currentSecond): Integer.toString(currentSecond);

		return getHour+getMinute+getSecond;

	}
	
	/**
	 * <pre>
	 * 파일사이즈를 문자열 형태로 표시.
	 * 숫자로 된 파일 사이즈를 받아서 디스플레이 포맷에 맞춘 문자열 리턴.
	 * 사용방법: SizeToStr("1024") -> return "1KB"
	 * </pre>
	 * @param String file_size : 파일사이즈
	 * @return 문자표기 파일 사이즈
	 */
	public static String SizeToStr(String file_size) { 

		return SizeToStr( Long.parseLong(file_size) );
	}

	/**
	 * <pre>
	 * 파일사이즈를 문자열 형태로 표시.
	 * 숫자로 된 파일 사이즈를 받아서 디스플레이 포맷에 맞춘 문자열 리턴.
	 * 사용방법: SizeToStr(1024) -> return "1KB"
	 * </pre>
	 * @param long file_size : 파일사이즈
	 * @return 문자표기 파일 사이즈
	 */
	public static String SizeToStr(long file_size) { 
		int allot = 0;
		int mod   = 0;
		String result = "0";

		if (file_size > 1024*1024*1024) {
			allot = (int) ( file_size / (1024*1024*1024) );
			if (allot >= 100) {
				result = Integer.toString(allot) + "GB";
			} else if (allot >= 10) {
				mod = (int) Math.floor( (file_size % (1024*1024*1024) * 100 / 10 / (1024*1024*1024) ) );
				result = Integer.toString(allot) + "." + Integer.toString(mod) + "GB";
			} else {
				mod = (int) Math.floor( (file_size % (1024*1024*1024) * 100 / (1024*1024*1024)));
				if (mod > 9) {
					result = Integer.toString(allot) + "." + Integer.toString(mod) + "GB";
				} else {
					result = Integer.toString(allot) + ".0" + Integer.toString(mod) + "GB";
				}
			}

		} else if (file_size > 1024*1024) {
			allot = (int) ( file_size / (1024*1024) );
			if (allot >= 100) {
				result = Integer.toString(allot) + "MB";
			} else if (allot >= 10) {
				mod = (int) Math.floor( (file_size % (1024*1024) * 100 / 10 / (1024*1024)) );
				result = Integer.toString(allot) + "." + Integer.toString(mod) + "MB";
			} else {
				mod = (int) Math.floor( (file_size % (1024*1024) * 100 / (1024*1024)) );
				if (mod > 9) {
					result = Integer.toString(allot) + "." + Integer.toString(mod) + "MB";
				} else {
					result = Integer.toString(allot) + ".0" + Integer.toString(mod) + "MB";
				}
			}

		} else if (file_size > 1024) {
			result = Integer.toString( (int)(file_size / 1024) ) + "KB";

		} else {
			result = Long.toString(file_size);
		}


		return result;
	}

	public static String nvl(Object obj ) {
		if (obj==null) {
			return "";
		} else {
			return obj.toString();
		}
	}
	
	public static String nvl(Object obj, Object str) {
		if (obj==null) {
			return str.toString();
		} else {
			return obj.toString();
		}
	}
		
	/**  
	 * <pre>
	 * 날짜+시간 포맷 변환.
	 * yyyy-MM-dd HH:mm:ss
	 * </pre>
	 * @return 포맷에 맞춰진 문자열
	 */
	
	public static String formatDateTime(String format_str) throws Exception {	
		
		if (format_str==null||format_str.trim().equals("")) return "";

		SimpleDateFormat dateFormatter = new SimpleDateFormat ("yyyyMMddHHmmss"); 
		Date sourceDate = dateFormatter.parse(format_str);      
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String result = df.format(sourceDate);
		return result;  
	}

	/**  
	 * <pre>
	 * 날짜 포맷 변환.
	 * yyyy-MM-dd
	 * </pre>
	 * @return 포맷에 맞춰진 문자열
	 */
	
	public static String formatDate(String format_str) throws Exception {	
		
		if (format_str==null||format_str.trim().equals("")) return "";

		SimpleDateFormat dateFormatter = new SimpleDateFormat ("yyyyMMdd"); 
		Date sourceDate = dateFormatter.parse(format_str);      
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String result = df.format(sourceDate);
		return result;  
	}

	/**  
	 * <pre>
	 * 시간 포맷 변환.
	 * 예제: format(120000)  => 12:00:00
	 * </pre>
	 * @return 포맷에 맞춰진 문자열
	 */
	
	public static String formatTime(String format_str) throws Exception {	
		
		if (format_str==null||format_str.equals("")) return "";

		String str = "19700202"+format_str;                 
		SimpleDateFormat dateFormatter = new SimpleDateFormat ("yyyyMMddHHmmss"); 
		Date sourceDate = dateFormatter.parse(str);      
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		String result = df.format(sourceDate);
		return result;  
	}

	/**  
	 * <pre>
	 * 요일 얻어오기
	 * 일요일,월요일,화요일..
	 * </pre>
	 * @return 요일 String[]배열
	 */
	
	public static String [] day() throws Exception {
		DateFormatSymbols symbols_Kor= new DateFormatSymbols(Locale.KOREA);
		String [] days=	symbols_Kor.getWeekdays();
		return days;	
	}
	
	public static String addDays(String s, int day)	throws java.text.ParseException {
		return addDays(s, day, "yyyyMMdd");
	}
		
	public static String addDays(String s, int day, String format) throws java.text.ParseException {
	
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(
				format, java.util.Locale.KOREA);
	
		java.util.Date date = check(s, format);
	
		date.setTime(date.getTime() + ((long) day * 1000 * 60 * 60 * 24));
	
		return formatter.format(date);
	}
	
	 
	public static java.util.Date check(String s, String format) throws java.text.ParseException {	
		if (s == null) {
			throw new java.text.ParseException("date string to check is null",
					0);
		}
		if (format == null) {
			throw new java.text.ParseException(
					"format string to check date is null", 0);
		}
		
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(
				format, java.util.Locale.KOREA);
		
		java.util.Date date = null;
		
		try {
			date = formatter.parse(s);
		} catch (java.text.ParseException e) {
			throw new java.text.ParseException(" wrong date:\"" + s
					+ "\" with format \"" + format + "\"", 0);
		}
		
		
		if (!formatter.format(date).equals(s)) {
			throw new java.text.ParseException("Out of bound date:\"" + s
					+ "\" with format \"" + format + "\"", 0);
		}
		
		return date;
	}	
	
	// E-Mail 검사
    public static boolean isEmail(String email) {
        if (email==null) return false;
        boolean b = Pattern.matches(
            "[\\w\\~\\-\\.]+@[\\w\\~\\-]+(\\.[\\w\\~\\-]+)+", 
            email.trim());
        return b;
    }

	public static String getBtnHtml(HttpServletRequest request, String mode, String name, String id){
		return getBtnHtml(request, mode, name, id, "", "50", "");
	}   
	public static String getBtnHtml(HttpServletRequest request, String mode, String name, String id, String onClick){
		return getBtnHtml(request, mode, name, id, onClick, "50", "");	
	}
	public static String getBtnHtml(HttpServletRequest request, String mode, String name, String id, String onClick, String width){
		return getBtnHtml(request, mode, name, id, onClick, width, "");	
	}
	/**
	 * 
	 * @param request
	 * @param mode 		"I"=등록, "U"=수정, "D"=삭제, 권한관계없는 버튼은 ""
	 * @param name
	 * @param id
	 * @param onClick
	 * @param width
	 * @param option
	 * @return
	 */
	public static String getBtnHtml(HttpServletRequest request, String mode, String name, String id, String onClick, String width, String option){
		String cp = request.getContextPath();
		HttpSession session = request.getSession();
		String btn = "";
		
		if(true){
			btn += "<table id='"+id+"' width='"+width+"' border='0' cellpadding='0' cellspacing='0' style='cursor:hand;' onClick=\""+onClick+"\" "+option+">\n";
			btn += "	<tr>\n";
			btn += "		<td width='10'><img src='"+cp+"/images/btn_left.gif'></td>\n";
			btn += "		<td align=\"center\" background='"+cp+"/images/btn_bg.gif' class='table_black'>"+name+"</td>\n";
			btn += "		<td width='10'><img src='"+cp+"/images/btn_right.gif'></td>\n";
			btn += "	</tr>\n";
			btn += "</table>\n";
		}else{
			btn += "&nbsp;";
		}
		btn = btn.replace("${cp}", cp);
		btn = btn.replace("${cp }", cp);
		return btn;		
	}

}
