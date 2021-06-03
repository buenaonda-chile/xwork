package com.globaldenso.dnkr.presentation.controller;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.JsonView;
import com.globaldenso.dnkr.business.service.EduService;
import com.globaldenso.dnkr.constant.CommandMap;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.google.gson.Gson;

/**
 * 
 * @파일명		: EduController.java 
 * @프로젝트	: DNKR
 * @날짜		: 2019. 9. 20. 
 * @작성자		: Cho HeumJun
 * @설명
 * <pre>
 * 		관리자 교육 Controller
 * </pre>
 */
@Controller
public class EduController {
	
	@Autowired
    private EduService eduService;
	
	/**
	 * 
	 * @메소드명	: edu
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명
	 * <pre>
	 *		문제목록 화면으로 이동
	 * </pre>
	 * @param request
	 * @param response
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/edu", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView edu(HttpServletRequest request, HttpServletResponse response, 
        @CookieValue("locallocale") Optional<String> locale)  throws Exception {
				
		ModelAndView mv = new ModelAndView();
		
		HttpSession session = request.getSession();
		String lang = String.valueOf(session.getAttribute("org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE"));
		mv.addObject("lang", lang);
		
		// 저장된 세션 데이터 불러오기
		EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String userId = empInfo.getEmpId();
        String userName = empInfo.getEmpName();
        
        mv.addObject("user_id", userId);
        mv.addObject("user_name", userName);
        
		mv.setViewName("/dnkr/edu/eduList");
        
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
	@RequestMapping(value = "/eduList", method = {RequestMethod.GET, RequestMethod.POST}, headers="Accept=application/json" )
	public JsonView getEduList(HttpServletRequest request, HttpServletResponse response) throws ApplicationException, UnsupportedEncodingException
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
		
		rtnJson = new Gson().toJson(eduService.getEduList(commandMap));
		
		JsonView jv = new JsonView();
        jv.addStaticAttribute("jsonString", rtnJson);
		
		return jv;
		
	}
	
	/**
	 * 
	 * @메소드명	: eduDetail
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명
	 * <pre>
	 *		교육 상세 화면 이동
	 * </pre>
	 * @param request
	 * @param response
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/eduDetail", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView eduDetail(HttpServletRequest request, HttpServletResponse response, 
        @CookieValue("locallocale") Optional<String> locale)  throws Exception {

		ModelAndView mv = new ModelAndView();
		
		CommandMap commandMap = new CommandMap();
		
		if(request.getParameter("edu_pk") == null) {
			commandMap.put("edu_pk", "");
		} else {
			commandMap.put("edu_pk", request.getParameter("edu_pk"));
		}
		
		if(!commandMap.get("edu_pk").equals("")) {
			
			// 교육에 대한 상세 정보 호출
			Map<String, Object> resultMap = eduService.getEdu(commandMap);
			
			mv.addObject("subject", resultMap.get("SUBJECT"));
			mv.addObject("content", resultMap.get("CONTENT"));
			mv.addObject("agree", resultMap.get("AGREE"));
			mv.addObject("time", resultMap.get("TIME"));
			mv.addObject("start_date", resultMap.get("START_DATE"));
			mv.addObject("end_date", resultMap.get("END_DATE"));
			mv.addObject("org_att_name", resultMap.get("ORG_ATT_NAME"));
			mv.addObject("att_name", resultMap.get("ATT_NAME"));
			mv.addObject("dept", resultMap.get("DEPT"));
			mv.addObject("dept_nm", resultMap.get("DEPT_NM"));
			mv.addObject("instructor", resultMap.get("INSTRUCTOR"));
			mv.addObject("agree_title", resultMap.get("AGREE_TITLE"));
			mv.addObject("description_use", resultMap.get("DESCRIPTION_USE"));
			mv.addObject("descript", resultMap.get("DESCRIPT"));
		}
		
		mv.addObject("edu_pk", commandMap.get("edu_pk"));
        
		HttpSession session = request.getSession();
		String lang = String.valueOf(session.getAttribute("org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE"));		
		mv.addObject("lang", lang);
		
		mv.setViewName("/dnkr/edu/eduDetail");
		
        
        return mv;
	}
	
	/**
	 * 
	 * @메소드명	: eduSave
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명
	 * <pre>
	 *		교육 상세화면에서 저장
	 * </pre>
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "eduSave.do")
	public JsonView eduSave(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception
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
		
		// 저장된 세션 데이터 불러오기
		EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String userId = empInfo.getEmpId();
        String userName = empInfo.getEmpName();
        
        commandMap.put("user_id", userId);
        commandMap.put("user_name", userName);
		
		rtnJson = new Gson().toJson(eduService.eduSave(commandMap, request, response));
		
		JsonView jv = new JsonView();
        jv.addStaticAttribute("jsonString", rtnJson);
		
		return jv;
		
	}
	
	/**
	 * 
	 * @메소드명	: eduDel
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명
	 * <pre>
	 *		교육상세 화면에서 교육 삭제 
	 * </pre>
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "eduDel.do")
	public JsonView eduDel(HttpServletRequest request, HttpServletResponse response) throws Exception
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
		
		rtnJson = new Gson().toJson(eduService.eduDel(commandMap));
		
		JsonView jv = new JsonView();
        jv.addStaticAttribute("jsonString", rtnJson);
		
		return jv;
	}
	
	/**
	 * 
	 * @메소드명	: que
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명
	 * <pre>
	 *		문제목록 화면으로 이동
	 * </pre>
	 * @param request
	 * @param response
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/que", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView que(HttpServletRequest request, HttpServletResponse response, 
        @CookieValue("locallocale") Optional<String> locale)  throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("edu_pk", request.getParameter("edu_pk"));
        mv.setViewName("/dnkr/edu/queList");
        
        return mv;
	}
	
	/**
	 * 
	 * @메소드명	: getQueList
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명
	 * <pre>
	 *		문제목록 화면 리스트
	 * </pre>
	 * @param request
	 * @param response
	 * @return
	 * @throws ApplicationException
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/queList", method = {RequestMethod.GET, RequestMethod.POST}, headers="Accept=application/json" )
	public JsonView getQueList(HttpServletRequest request, HttpServletResponse response) throws ApplicationException, UnsupportedEncodingException
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
		for (String key2 : commandMap.keySet()) {
			System.out.println(" CommandMap Data \t:  " + key2 + " = " + commandMap.get(key2));
		}
		
		rtnJson = new Gson().toJson(eduService.getQueList(commandMap));
		
		JsonView jv = new JsonView();
        jv.addStaticAttribute("jsonString", rtnJson);
		
		return jv;
		
	}
	
	/**
	 * 
	 * @메소드명	: queDetail
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명
	 * <pre>
	 *		문제상세 화면으로 이동
	 * </pre>
	 * @param request
	 * @param response
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queDetail", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView queDetail(HttpServletRequest request, HttpServletResponse response, 
        @CookieValue("locallocale") Optional<String> locale)  throws Exception {

		ModelAndView mv = new ModelAndView();
		
		CommandMap commandMap = new CommandMap();
		
		if(request.getParameter("que_pk") == null) {
			commandMap.put("que_pk", "");
		} else {
			commandMap.put("que_pk", request.getParameter("que_pk"));
		}
		
		if(!commandMap.get("que_pk").equals("")) {
			Map<String, Object> resultMap = eduService.getQue(commandMap);
			mv.addObject("subject", resultMap.get("SUBJECT"));
			mv.addObject("answer", resultMap.get("ANSWER"));
			mv.addObject("answerList", eduService.getAnsList(commandMap));
		}
		
		mv.addObject("edu_pk", request.getParameter("edu_pk"));
		mv.addObject("que_pk", commandMap.get("que_pk"));
        mv.setViewName("/dnkr/edu/queDetail");   //외부업체용
        
        return mv;
	}
	
	/**
	 * 
	 * @메소드명	: queSave
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명
	 * <pre>
	 *		문제상세 화면에서 문제 및 답안지 저장
	 * </pre>
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "queSave.do")
	public JsonView queSave(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		//return Json
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
		for (String key2 : commandMap.keySet())
		{
			//log.debug(" CommandMap Data \t:  " + key2 + " = " + commandMap.get(key2));
			System.out.println(" CommandMap Data \t:  " + key2 + " = " + commandMap.get(key2));
		}
		
		//세션 저장된 데이터 불러오기
		EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String userId = empInfo.getEmpId();
        String userName = empInfo.getEmpName();
        
        commandMap.put("user_id", userId);
        commandMap.put("user_name", userName);
        
		rtnJson = new Gson().toJson(eduService.queSave(commandMap));
		
		JsonView jv = new JsonView();
        jv.addStaticAttribute("jsonString", rtnJson);
		
		return jv;
		
	}
	
	/**
	 * 
	 * @메소드명	: eduPopup
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명
	 * <pre>
	 *		교육상세 화면에서 교육대상 팝업호출
	 * </pre>
	 * @param request
	 * @param response
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/eduPopup", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView eduPopup(HttpServletRequest request, HttpServletResponse response, 
        @CookieValue("locallocale") Optional<String> locale)  throws Exception {
				
		ModelAndView mv = new ModelAndView();
		
        mv.setViewName("/dnkr/edu/eduPopup");   // 대상자 지정 팝업
        
        return mv;
	}
	
	/**
	 * 
	 * @메소드명	: queDel
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명
	 * <pre>
	 *		문제상세 화면 문제 삭제기능
	 * </pre>
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "queDel.do")
	public JsonView queDel(HttpServletRequest request, HttpServletResponse response) throws Exception
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
		
		rtnJson = new Gson().toJson(eduService.queDel(commandMap));
		
		JsonView jv = new JsonView();
        jv.addStaticAttribute("jsonString", rtnJson);
		
		return jv;
	}
	
	/**
	 * 
	 * @메소드명	: eduHeader
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명
	 * <pre>
	 *		페이지 별 상단 header Include 화면 호출
	 * </pre>
	 * @param request
	 * @param response
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/eduHeader", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView eduHeader(HttpServletRequest request, HttpServletResponse response, 
        @CookieValue("locallocale") Optional<String> locale)  throws Exception {
				
		ModelAndView mv = new ModelAndView();
		
		HttpSession session = request.getSession();
		String lang = String.valueOf(session.getAttribute("org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE"));
		
		mv.addObject("lang", lang);
		mv.setViewName("/dnkr/edu/header");
		
        return mv;
	}
	
	/**
	 * 
	 * @메소드명	: getClsCodeList
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명
	 * <pre>
	 *		교육대상에서 사업부 리스트
	 * </pre>
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getClsCodeList", method = {RequestMethod.GET, RequestMethod.POST}, headers="Accept=application/json" )
	public JsonView getClsCodeList(HttpServletRequest request, HttpServletResponse response) throws Exception
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
		
		commandMap.put("cmcLangCode", DensoContext.get().getLocale().getLanguage());
		
		rtnJson = new Gson().toJson(eduService.getClsCodeList(commandMap));
		
		JsonView jv = new JsonView();
        jv.addStaticAttribute("jsonString", rtnJson);
		
		return jv;
		
	}
	
	/**
	 * 
	 * @메소드명	: getLocCodeList
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명
	 * <pre>
	 *		교육대상에서 사업장 리스트
	 * </pre>
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getLocCodeList", method = {RequestMethod.GET, RequestMethod.POST}, headers="Accept=application/json" )
	public JsonView getLocCodeList(HttpServletRequest request, HttpServletResponse response) throws Exception
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
		
		commandMap.put("cmcLangCode", DensoContext.get().getLocale().getLanguage());
		
		rtnJson = new Gson().toJson(eduService.getLocCodeList(commandMap));
		
		JsonView jv = new JsonView();
        jv.addStaticAttribute("jsonString", rtnJson);
		
		return jv;
		
	}
	
	/**
	 * 
	 * @메소드명	: getTeamCodeList
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명
	 * <pre>
	 *		교육대상에서 부서별(팀) 리스트
	 * </pre>
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getTeamCodeList", method = {RequestMethod.GET, RequestMethod.POST}, headers="Accept=application/json" )
	public JsonView getTeamCodeList(HttpServletRequest request, HttpServletResponse response) throws Exception
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
		
		commandMap.put("cmcLangCode", DensoContext.get().getLocale().getLanguage());
		
		rtnJson = new Gson().toJson(eduService.getTeamCodeList(commandMap));
		
		JsonView jv = new JsonView();
        jv.addStaticAttribute("jsonString", rtnJson);
		
		return jv;
		
	}
	
}


