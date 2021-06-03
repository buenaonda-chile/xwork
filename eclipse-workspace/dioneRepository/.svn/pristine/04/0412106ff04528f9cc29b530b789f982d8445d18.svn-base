package com.globaldenso.dnkr.presentation.controller;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.JsonView;
import com.globaldenso.dnkr.business.service.SalaryUserService;
import com.globaldenso.dnkr.constant.CommandMap;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.google.gson.Gson;

/**
 * 
 * @파일명		: SalaryuserController.java 
 * @프로젝트	: DNKR
 * @날짜		: 2019. 9. 20. 
 * @작성자		: Cho HeumJun
 * @설명
 * <pre>
 * 		사용자 교육 Controller
 * </pre>
 */
@Controller
@RequestMapping(value = "/salary")
@ViewId(value = "SALARY")
public class SalaryUserController {
	
	@Autowired
    private SalaryUserService salaryUserService;
	
	/**
	 * 
	 * @메소드명	: salary
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명
	 * <pre>
	 *		사용자 교육화면 호출
	 * </pre>
	 * @param request
	 * @param response
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/salaryUser.do", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView salary(HttpServletRequest request, HttpServletResponse response, 
        @CookieValue("locallocale") Optional<String> locale)  throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		CommandMap commandMap = new CommandMap();
		request.setCharacterEncoding("utf-8");
		Enumeration<?> enumeration = request.getParameterNames();
		
		// 모든 파라미터를 commandMap에 담는다.
		String key = null;
		String[] values = null;
		while (enumeration.hasMoreElements())
		{
			key = (String) enumeration.nextElement();
			values = request.getParameterValues(key);
			if (values != null)
			{
				commandMap.put(key, (values.length > 1) ? values : values[0]);
			}
		}
		
		//세션 저장된 데이터 불러오기
		EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String userId = empInfo.getEmpNumber();
		
		Map<String, Object> eduMap = salaryUserService.getSalaryUser(commandMap);
		
		mv.addObject("userId", userId);
		mv.addObject("empNumber", empInfo.getEmpNumber());
		mv.addObject("edu_subject", eduMap.get("EDU_SUBJECT"));
		mv.addObject("edu_content", eduMap.get("EDU_CONTENT"));
		mv.addObject("start_date", eduMap.get("START_DATE"));
		mv.addObject("time", eduMap.get("TIME"));
		mv.addObject("org_att_name", eduMap.get("ORG_ATT_NAME"));
		mv.addObject("att_name", eduMap.get("ATT_NAME"));
		mv.addObject("instructor", eduMap.get("INSTRUCTOR"));
		mv.addObject("description_use", eduMap.get("DESCRIPTION_USE"));
		mv.addObject("edu_descript", eduMap.get("EDU_DESCRIPT"));
		mv.addObject("edu_pk", commandMap.get("edu_pk") );

		//mv.addObject("queList", salaryUserService.userQueList(commandMap));
		//mv.addObject("ansList", salaryUserService.userAnsList(commandMap));
	
        mv.setViewName("/dnkr/salary/salaryUser");   
        
        return mv;
	}
	
	/**
     * @메소드명 : searchFileDataList
	 * @날짜		: 2020. 07. 25.
	 * @작성자	: Kim GyeongJa
     * @설명 : 첨부파일 검색
     *
     *     <pre>
     *			첨부파일 검색
     *     </pre>
     *
     * @param request
     * @param response
     * @param edu_pk
     * @throws Exception
     */
	@RequestMapping(value = "/searchFileDataList.do", method = {RequestMethod.GET, RequestMethod.POST})
	public JsonView searchFileDataList(HttpServletRequest request, HttpServletResponse response, String edu_pk) throws ApplicationException, UnsupportedEncodingException
	{
		String rtnJson;	//return Json
		
		CommandMap commandMap = new CommandMap();
		request.setCharacterEncoding("utf-8");
		Enumeration<?> enumeration = request.getParameterNames();
		
		// 모든 파라미터를 commandMap에 담는다.
		String key = null;
		String[] values = null;
		while (enumeration.hasMoreElements())
		{
			key = (String) enumeration.nextElement();
			values = request.getParameterValues(key);
			if (values != null)
			{
				commandMap.put(key, (values.length > 1) ? values : values[0]);
			}
		}
		
		// 저장된 세션 데이터 불러오기
		EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String userId = empInfo.getEmpNumber();
        commandMap.put("user_id", userId);
		
		Map map = new HashMap();
		
		map.put("list", salaryUserService.getFileDataList(edu_pk));
		
		rtnJson = new Gson().toJson(map);
		
		JsonView jv = new JsonView();
        jv.addStaticAttribute("jsonString", rtnJson);
        
		return jv;
		
	}
	
	/**
	 * 
	 * @메소드명	: salaryUserSave
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명
	 * <pre>
	 *		교육에 대한 사용자 답안지 제출
	 * </pre>
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "salaryUserSave.do")
	//public JsonView salaryUserSave(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception
	public JsonView salaryUserSave(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		String rtnJson;
		
		CommandMap commandMap = new CommandMap();
		request.setCharacterEncoding("utf-8");
		Enumeration<?> enumeration = request.getParameterNames();
		
		// 모든 파라미터를 commandMap에 담는다.
		String key = null;
		String[] values = null;
		while (enumeration.hasMoreElements())
		{
			key = (String) enumeration.nextElement();
			values = request.getParameterValues(key);
			if (values != null)
			{
				commandMap.put(key, (values.length > 1) ? values : values[0]);
			}
		}

		//세션 저장된 데이터 불러오기
		EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String userId = empInfo.getEmpNumber();
        String userName = empInfo.getEmpName();
        
        commandMap.put("user_id", userId);
        commandMap.put("user_name", userName);
        
		rtnJson = new Gson().toJson(salaryUserService.salaryUserSave(commandMap));
		
		JsonView jv = new JsonView();
        jv.addStaticAttribute("jsonString", rtnJson);
		
		return jv;
		
	}
	
	/**
	 * 
	 * @메소드명	: salaryUserAgree
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명
	 * <pre>
	 *		사용자 동의서 화면 호출
	 * </pre>
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "salaryUserAgree.do", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView salaryUserAgree(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		CommandMap commandMap = new CommandMap();
		request.setCharacterEncoding("utf-8");
		Enumeration<?> enumeration = request.getParameterNames();
		
		// 모든 파라미터를 commandMap에 담는다.
		String key = null;
		String[] values = null;
		while (enumeration.hasMoreElements())
		{
			key = (String) enumeration.nextElement();
			values = request.getParameterValues(key);
			if (values != null)
			{
				commandMap.put(key, (values.length > 1) ? values : values[0]);
			}
		}
		
		//세션 저장된 데이터 불러오기
		EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String userId = empInfo.getEmpId();
        String signId = empInfo.getEmpNumber();
        
        Map<String, Object> eduAgree = salaryUserService.getSalaryAgree(commandMap);
        
        mv.addObject("edu_pk", commandMap.get("edu_pk"));
        mv.addObject("userId", userId);
        mv.addObject("signId", signId);
        mv.addObject("emp_number", signId);
        mv.addObject("agree_title", eduAgree.get("AGREE_TITLE"));
        
        Map<String, Object> eduMap = salaryUserService.getSalaryUser(commandMap);
		
		mv.addObject("edu_subject", eduMap.get("EDU_SUBJECT"));
		mv.addObject("start_date", eduMap.get("START_DATE"));
		mv.addObject("emp_type_promotion", eduMap.get("EMP_TYPE_PROMOTION"));
		
		commandMap.put("emp_number", signId);
		Map<String, Object> eduDtlMap = salaryUserService.getSalaryUserInfo(commandMap);
		
		mv.addObject("salary_amt", toNumFormat(checkNulltoString(eduDtlMap.get("SALARY_AMT"))));
		mv.addObject("salary_kr",  checkNulltoString(eduDtlMap.get("SALARY_KR")));
		mv.addObject("capacity_rt",  checkNulltoString(eduDtlMap.get("CAPACITY_RT")));
		mv.addObject("capacity_amt",  toNumFormat(checkNulltoString(eduDtlMap.get("CAPACITY_AMT"))));
		mv.addObject("perfor_rt", checkNulltoString(eduDtlMap.get("PERFOR_RT")));
		mv.addObject("perfor_amt", toNumFormat(checkNulltoString(eduDtlMap.get("PERFOR_AMT"))));

		//오늘 날짜 표시
		SimpleDateFormat format2 = new SimpleDateFormat ("yyyy년  MM월  dd일");	
		String format_time2 = format2.format (System.currentTimeMillis());
		
		// 연봉 정보 변환
				String agree = eduAgree.get("AGREE").toString();
				agree = agree.replace("$성명$", eduDtlMap.get("REG_USER").toString());
				agree = agree.replace("$연봉한글$", eduDtlMap.get("SALARY_KR").toString());
				agree = agree.replace("$연봉$", toNumFormat(eduDtlMap.get("SALARY_AMT").toString()));
				agree = agree.replace("$날짜$", format_time2);
				agree = agree.replace("$서명$", "서명 : " + eduDtlMap.get("REG_USER").toString() + "<img src='/images/sign/"+signId+".gif' style='height:50px'/>");
				mv.addObject("agree", agree);
		
		/*
		 * agree = agree.replace("$성명$", eduDtlMap.get("REG_USER").toString()); agree =
		 * agree.replace("$연봉한글$", eduDtlMap.get("SALARY_KR").toString()); agree =
		 * agree.replace("$연봉$", toNumFormat(eduDtlMap.get("SALARY_AMT").toString()));
		 * agree = agree.replace("$날짜$", format_time2);
		 */
        	
        mv.addObject("agree", agree);
	        
        mv.setViewName("/dnkr/salary/salaryUserAgree");
        
        return mv;
	}
	
	private String checkNulltoString (Object temp){
		String rlt = "";
		
		if(temp != null) {
			rlt = temp.toString();
		}
		return rlt;
	}
	
	/**
	 * 숫자에 천단위마다 콤마 넣기
	 * 
	 * @param int
	 * @return String
	 */
	public static String toNumFormat(String num) {

		// 연봉 콤마 처리
		String returnAmt = "0";
		DecimalFormat df = new DecimalFormat("#,###");
		try {
			if(num != null) {
				returnAmt = df.format(Integer.parseInt(num));
			}
		} catch (NumberFormatException e) {
		}
		return returnAmt;
	}

	/**
	 * 
	 * @메소드명	: agreeConfirm
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명
	 * <pre>
	 *		사용자 동의서 제출
	 * </pre>
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "agreeConfirm.do", method = {RequestMethod.GET, RequestMethod.POST})
    public JsonView agreeConfirm(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		
		String rtnJson;
		
		CommandMap commandMap = new CommandMap();
		request.setCharacterEncoding("utf-8");
		Enumeration<?> enumeration = request.getParameterNames();
		
		// 모든 파라미터를 commandMap에 담는다.
		String key = null;
		String[] values = null;
		while (enumeration.hasMoreElements())
		{
			key = (String) enumeration.nextElement();
			values = request.getParameterValues(key);
			if (values != null)
			{
				commandMap.put(key, (values.length > 1) ? values : values[0]);
			}
		}
		
		rtnJson = new Gson().toJson(salaryUserService.agreeConfirm(commandMap));
		
		JsonView jv = new JsonView();
        jv.addStaticAttribute("jsonString", rtnJson);
		
		return jv;
		
	}
	
	/**
	 * 
	 * @메소드명	: salaryUserEnd
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명
	 * <pre>
	 *		사용자 종료화면 호출
	 * </pre>
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "salaryUserEnd.do", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView salaryUserEnd(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		
		ModelAndView mv = new ModelAndView();

        mv.setViewName("/dnkr/salary/salaryUserEnd");
        
        return mv;
	}
	
	/**
	 * 
	 * @메소드명	: userHeader
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명
	 * <pre>
	 *		사용자화면 상단 header Include 화면 호출
	 * </pre>
	 * @param request
	 * @param response
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userHeader", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView userHeader(HttpServletRequest request, HttpServletResponse response, 
        @CookieValue("locallocale") Optional<String> locale)  throws Exception {
				
		ModelAndView mv = new ModelAndView();
		
        mv.setViewName("/dnkr/salary/userHeader");   // 대상자 지정 팝업
        
        return mv;
	}
	
	@RequestMapping(value = "/salaryUserList.do", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView salary(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		CommandMap commandMap = new CommandMap();
		request.setCharacterEncoding("utf-8");
		Enumeration<?> enumeration = request.getParameterNames();
		
		// 모든 파라미터를 commandMap에 담는다.
		String key = null;
		String[] values = null;
		while (enumeration.hasMoreElements())
		{
			key = (String) enumeration.nextElement();
			values = request.getParameterValues(key);
			if (values != null)
			{
				commandMap.put(key, (values.length > 1) ? values : values[0]);
			}
		}
		
		//세션 저장된 데이터 불러오기
		EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String userId = empInfo.getEmpId();

        String empInfo1 = request.getSession().getAttribute("ACCOUNT").toString();

        JSONParser parser = new JSONParser();
        Object empInfoObj = parser.parse(empInfo1);
        JSONObject empJsonObj = (JSONObject)empInfoObj;
        String teamCode = (String)empJsonObj.get("teamCode"); //사용자명
        
		mv.addObject("userId", userId);
		mv.addObject("empNumber", empInfo.getEmpNumber());
		mv.addObject("teamCode", teamCode);
        mv.setViewName("/dnkr/salary/salaryUserList");   //외부업체용
        
        return mv;
	}
	
	/**
	 * 
	 * @메소드명	: getSalaryList
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명
	 * <pre>
	 *		문제목록 리스트
	 * </pre>
	 * @param request
	 * @param response
	 * @return
	 * @throws ApplicationException
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/getSalarySelectList", method = {RequestMethod.GET, RequestMethod.POST}, headers="Accept=application/json" )
	public JsonView getSalarySelectList(HttpServletRequest request, HttpServletResponse response) throws ApplicationException, UnsupportedEncodingException
	{
		String rtnJson;	//return Json
		
		CommandMap commandMap = new CommandMap();
		request.setCharacterEncoding("utf-8");
		Enumeration<?> enumeration = request.getParameterNames();
		
		// 모든 파라미터를 commandMap에 담는다.
		String key = null;
		String[] values = null;
		while (enumeration.hasMoreElements())
		{
			key = (String) enumeration.nextElement();
			values = request.getParameterValues(key);
			if (values != null)
			{
				commandMap.put(key, (values.length > 1) ? values : values[0]);
			}
		}
		
		// 저장된 세션 데이터 불러오기
		EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String userId = empInfo.getEmpNumber();
        commandMap.put("user_id", userId);
        
		try {
			
			Map<String, Object> map = salaryUserService.getSalarySelectList(commandMap);
			//Object temp = map.get("DEPT");
			//map.put("DEPT", String.valueOf(temp));
			
			rtnJson = new Gson().toJson(map);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		JsonView jv = new JsonView();
        jv.addStaticAttribute("jsonString", rtnJson);
		
		return jv;
		
	}
	

}


