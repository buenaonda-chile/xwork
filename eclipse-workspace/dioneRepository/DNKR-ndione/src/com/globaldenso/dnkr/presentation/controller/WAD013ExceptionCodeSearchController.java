/*
 * Project : NEW DIONE PROJECT
 *
 * $Id$
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.presentation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.JsonView;
import com.globaldenso.dnkr.business.service.CodeService;
import com.globaldenso.dnkr.business.service.RelationTeamService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.ExceptionCodeDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAD013ExceptionCodeMngSearchForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KO] 뉴디오네 예외부서코드 관리 Controller.<br>
 * [JP] <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAD013ExceptionCodeMngSearch")
@ViewId(value = "WAD013")
public class WAD013ExceptionCodeSearchController {

    /**
     * [KR] 부서(팀) 서비스 <br>     
     */
    @Autowired
    private RelationTeamService relationTeamService;

	/**
	 * [KR] 공통코드관리 서비스 <br>
	 */
	@Autowired
	private CodeService codeService;

	/**
	 * [EN] Default constructor.<br>
	 * [JP] デフォルトコンストラクタ。<br>
	 */
	public WAD013ExceptionCodeSearchController() {
		// no process
	}

	/**
	 * 자재입출고 재고현황 초기화면[KR] <br>
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAE019MaterialInventoryForm
	 * @return ModelAndView
	 * @throws Exception Exception
	 */
	@RequestMapping(value = "/init", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView initExceptionCodeMng(HttpServletRequest request,
			@ModelAttribute("WAD013ExceptionCodeMngSearchForm") WAD013ExceptionCodeMngSearchForm form)
			throws Exception {
		/**
		 * <pre>
		 *             
		 * 1.[JP]           
		 *   [EN] Screen initialization processing.         
		 *   [EN]   I acquire Log information and display it to a screen
		 * </pre>
		 */
		
		// Tab, 메뉴 기본 처리
		String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
		String menu = ServletRequestUtils.getStringParameter(request, "menu");

		ModelAndView mv = new ModelAndView();

		UxisCmmUtil.getSessionLoc(request, mv);	// 사업부
		
		form.setpCodeType("A");//코드타입 -기본값 : A-부서코드
		mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
		mv.addObject("tabId", tabId);
		mv.addObject("menu", menu);
		mv.addObject("paraDomain", form);
		mv.addObject("url", "WAD013ExceptionCodeMng.jsp");
		mv.setViewName(".tiles.page.WAD013ExceptionCodeMng");
		return mv;
	}

	/**
	 * 예외부서코드 조회
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAE019MaterialInventoryForm
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/ajaxSearch", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView exceptionCodeMngSearch(HttpServletRequest request,
			@ModelAttribute("WAD013ExceptionCodeMngSearchForm") WAD013ExceptionCodeMngSearchForm form)
			throws Exception {

		/**
		 * <pre>
		 *             
		 * 1.[JP]           
		 *   [EN] Screen initialization processing.         
		 *   [EN]   I acquire Log information and display it to a screen
		 * </pre>
		 */

		ModelAndView model = new ModelAndView(new JsonView());
		JSONObject jsonObj = new JSONObject();
		String result = DnkrConstans.RESULT_N;

		// 라이브러리 comps 셋팅
		//UxisCmmUtil.getCompsLib(form); 
		form.setCmcLangCode(DensoContext.get().getLocale().getLanguage());	//언어
		System.out.println(form.getpCodeType()+form.getCmcLangCode());
		
		List<ExceptionCodeDomain> exceptionCodeList = null;
		
		try {
			exceptionCodeList = codeService.searchByExceptionDeptCode(form);			
		} catch (Exception e) {
			System.out.println("데이터가 없습니다.");
		}
		//if (exceptionCodeList != null) {
		if (exceptionCodeList.size() > 0) {
			result = DnkrConstans.RESULT_Y;
			jsonObj.put("list", exceptionCodeList);
		}
		jsonObj.put("result", result);

		model.addObject("jsonString", jsonObj.toString());
		return model;
	}
	
	@RequestMapping(value = "/saveAction", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    //@ErrorBack(viewName = ".tiles.page.WAD013ExceptionCodeMng")
    public void saveAction(@RequestBody List<ExceptionCodeDomain> ajaxParams,
    		HttpServletRequest request, HttpServletResponse response)  
        throws Exception {

   	 	//세션 저장된 데이터 불러오기
    	String empInfo = request.getSession().getAttribute("ACCOUNT").toString();
    	System.out.println(empInfo);
    	JSONParser parser = new JSONParser();
    	Object empInfoObj       = parser.parse(empInfo);
    	JSONObject empJsonObj   = (JSONObject)empInfoObj;
    	String empNo        = (String)empJsonObj.get("uid");        //사용자 ID
    	
    	
    	System.out.println(ajaxParams);
    	
        JSONObject jsonObj = new JSONObject();
        String result = DnkrConstans.RESULT_N;
        
    	for(ExceptionCodeDomain exceptionCodeDomain : ajaxParams) {
    		exceptionCodeDomain.setCreateUser(empNo);
    		exceptionCodeDomain.setUpdateUser(empNo);
            
            int count=0;
            int rltCount=0;
            	count = codeService.searchByExceptionDeptCodeCount(exceptionCodeDomain);
            String transacionFlag="";
            		transacionFlag = exceptionCodeDomain.getTrProcCode();
            		System.out.println(transacionFlag);
            if("Y".equals(transacionFlag)) {	//insert, update
            	 if(count==0) {
                       	rltCount= codeService.createExceptionDeptCode(exceptionCodeDomain);
                   }else {
                	   rltCount = codeService.updateExceptionDeptCode(exceptionCodeDomain);
                   }
            }else {	//delete
            	rltCount= codeService.deleteExceptionDeptCode(exceptionCodeDomain);
            }
            System.out.println("count : "+ count+" rltCount : "+ rltCount);
            if(rltCount < 0) {
               	result = DnkrConstans.RESULT_OK;
            }
            if(result == DnkrConstans.RESULT_N) {
            	break;
            }
        }
    	jsonObj.put("result", result);
        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
        return;
    }
	
}
