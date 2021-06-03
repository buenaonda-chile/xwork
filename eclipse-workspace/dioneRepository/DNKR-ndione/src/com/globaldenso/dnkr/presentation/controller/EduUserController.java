package com.globaldenso.dnkr.presentation.controller;

import java.io.UnsupportedEncodingException;
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
import com.globaldenso.dnkr.JsonView;
import com.globaldenso.dnkr.business.service.EduUserService;
import com.globaldenso.dnkr.constant.CommandMap;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.google.gson.Gson;

/**
 * 
 * @파일명		: EduUserController.java 
 * @프로젝트	: DNKR
 * @날짜		: 2019. 9. 20. 
 * @작성자		: Cho HeumJun
 * @설명
 * <pre>
 * 		사용자 교육 Controller
 * </pre>
 */
@Controller
public class EduUserController {
	
	@Autowired
    private EduUserService eduUserService;
	
	/**
	 * 
	 * @메소드명	: edu
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
	@RequestMapping(value = "/eduUser.do", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView edu(HttpServletRequest request, HttpServletResponse response, 
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
        String userId = empInfo.getEmpId();
		
		Map<String, Object> eduMap = eduUserService.getEduUser(commandMap);
		
		mv.addObject("userId", userId);
		
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

		mv.addObject("queList", eduUserService.userQueList(commandMap));
		mv.addObject("ansList", eduUserService.userAnsList(commandMap));
	
        mv.setViewName("/dnkr/edu/eduUser");   //외부업체용
        
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
        String userId = empInfo.getEmpId();
        commandMap.put("user_id", userId);
		
		Map map = new HashMap();
		
		map.put("list", eduUserService.getFileDataList(edu_pk));
		
		rtnJson = new Gson().toJson(map);
		
		JsonView jv = new JsonView();
        jv.addStaticAttribute("jsonString", rtnJson);
        
		return jv;
		
	}
	
	/**
	 * 
	 * @메소드명	: eduUserSave
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
	@RequestMapping(value = "eduUserSave.do")
	//public JsonView eduUserSave(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception
	public JsonView eduUserSave(HttpServletRequest request, HttpServletResponse response) throws Exception
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
        String userId = empInfo.getEmpId();
        String userName = empInfo.getEmpName();
        
        commandMap.put("user_id", userId);
        commandMap.put("user_name", userName);
        
		rtnJson = new Gson().toJson(eduUserService.eduUserSave(commandMap));
		
		JsonView jv = new JsonView();
        jv.addStaticAttribute("jsonString", rtnJson);
		
		return jv;
		
	}
	
	/**
	 * 
	 * @메소드명	: eduUserAgree
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
	@RequestMapping(value = "eduUserAgree.do", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView eduUserAgree(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		
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
        String signId = "";
        if(userId != null) {
        	signId = userId.substring(1,userId.length());
        }
        
        Map<String, Object> eduAgree = eduUserService.getEduAgree(commandMap);
        
        mv.addObject("edu_pk", commandMap.get("edu_pk"));
        mv.addObject("userId", userId);
        
        mv.addObject("signId", signId);
        mv.addObject("agree", eduAgree.get("AGREE"));
        mv.addObject("agree_title", eduAgree.get("AGREE_TITLE"));

        mv.setViewName("/dnkr/edu/eduUserAgree");
        
        return mv;
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
		
		rtnJson = new Gson().toJson(eduUserService.agreeConfirm(commandMap));
		
		JsonView jv = new JsonView();
        jv.addStaticAttribute("jsonString", rtnJson);
		
		return jv;
		
	}
	
	/**
	 * 
	 * @메소드명	: eduUserEnd
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
	@RequestMapping(value = "eduUserEnd.do", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView eduUserEnd(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		
		ModelAndView mv = new ModelAndView();

        mv.setViewName("/dnkr/edu/eduUserEnd");
        
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
		
        mv.setViewName("/dnkr/edu/userHeader");   // 대상자 지정 팝업
        
        return mv;
	}
	
	@RequestMapping(value = "/eduUserList.do", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView edu(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		
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
		mv.addObject("teamCode", teamCode);
        mv.setViewName("/dnkr/edu/eduUserList");   //외부업체용
        
        return mv;
	}
	
	/**
	 * 
	 * @메소드명	: getEduList
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
	@RequestMapping(value = "/getEduSelectList", method = {RequestMethod.GET, RequestMethod.POST}, headers="Accept=application/json" )
	public JsonView getEduSelectList(HttpServletRequest request, HttpServletResponse response) throws ApplicationException, UnsupportedEncodingException
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
        String userId = empInfo.getEmpId();
        commandMap.put("user_id", userId);
        
		try {
			
			Map<String, Object> map = eduUserService.getEduSelectList(commandMap);
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


