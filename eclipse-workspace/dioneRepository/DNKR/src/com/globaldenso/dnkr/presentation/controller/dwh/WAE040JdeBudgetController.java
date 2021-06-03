/*
 * Project : NEW DIONE PROJECT
 *
 * $Id$
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.presentation.controller.dwh;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.JsonView;
import com.globaldenso.dnkr.business.service.CodeService;
import com.globaldenso.dnkr.business.service.db2.ManagementInfomationService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.db2.CodeDb2Domain;
import com.globaldenso.dnkr.domain.db2.JdeBudgetDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAE001MngSearchForm;
import com.globaldenso.dnkr.presentation.form.dwh.WAE040JdeBudgetForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KO] 월적상 CheckList 조회 Controller.<br>
 * [JP] <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAE040JdeBudgetSearch")
@ViewId(value = "WAE040")
public class WAE040JdeBudgetController {

	/**
	 * [KR] 경영관리 서비스 <br>
	 */
	@Autowired
	private ManagementInfomationService mifService;

	/**
	 * [KR] 공통코드관리 서비스 <br>
	 */
	@Autowired
	private CodeService codeService;

	/**
	 * [EN] Default constructor.<br>
	 * [JP] デフォルトコンストラクタ。<br>
	 */
	public WAE040JdeBudgetController() {
		// no process
	}

	/**
	 * 월적상 CheckList 초기화면[KR] <br>
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAE019MaterialInventoryForm
	 * @return ModelAndView
	 * @throws Exception Exception
	 */
	@RequestMapping(value = "/init", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView initJdeBudget(HttpServletRequest request,
			@ModelAttribute("WAE001MngSearchForm") WAE001MngSearchForm form)
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
		
		//계정과목
		CodeDb2Domain codeF0006LBDomain = new CodeDb2Domain();
		codeF0006LBDomain.setLib4("CLTDTA");	//통합JDE라이브러리
/*		codeF0006LBDomain.setMcstyl("EX");
		codeF0006LBDomain.setMcrp11("001");*/
		
		List<CodeDb2Domain> codeF0006LBList = null;
		try {
			codeF0006LBList = codeService.comCodeJdeF0006LB(codeF0006LBDomain);			
		} catch (Exception e) {
			System.out.println("데이터가 없습니다.");
		}

		//부서코드
		CodeDb2Domain codeMst650PFDomain = new CodeDb2Domain();
		//codeMst650PFDomain.setLib2(UxisCmmUtil.get);	//통합JDE라이브러리

		List<CodeDb2Domain> codeMst650PFList = null;
		try {
			codeMst650PFList = codeService.comCodeMst650PF(codeMst650PFDomain);			
		} catch (Exception e) {
			System.out.println(e+"데이터가 없습니다.");
		}		

		mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
		mv.addObject("tabId", tabId);
		mv.addObject("menu", menu);
		mv.addObject("paraDomain", form);
		mv.addObject("codeF0006LBList", codeF0006LBList);
		mv.addObject("codeMst650PFList", codeMst650PFList);
		mv.addObject("url", "WAE040JdeBudget.jsp");
		mv.setViewName(".tiles.page.WAE040JdeBudget");
		return mv;
	}

	/**
	 * 월적상 CheckList 데이터 조회
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAE035MonthlyShipmentCheckListForm
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/ajaxSearch", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView jdeBudgetSearch(HttpServletRequest request,
			@ModelAttribute("/WAE040JdeBudgetForm") WAE040JdeBudgetForm form)
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
		//System.out.println(form.getLocCode()+"=="+form.getpStartDate()+"=="+form.getpEndDate()+"=="+form.getpGlobj());
		String locCode = form.getLocCode();
		if("LOC000001".equals(locCode)){	//구KA환경
			form.setLib4("CLTDTAS");
		}else if("LOC000004".equals(locCode)){	//구KE환경
			form.setLib4("CLTDTAE");
		}else if("LOC000000".equals(locCode)){	//통합JDE라이브러리
			form.setLib4("CLTDTA");
		}
				
		List<JdeBudgetDomain> jdeBudgetList = null;

		try {
			jdeBudgetList = mifService.searchByJdeBudget(form);
			System.out.println(jdeBudgetList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (jdeBudgetList != null) {
			result = DnkrConstans.RESULT_Y;
			jsonObj.put("list", jdeBudgetList);
		}

		jsonObj.put("result", result);
		model.addObject("jsonString", jsonObj.toString());
		return model;
	}

	@RequestMapping(value = "/ajaxCodeSearch", method = {RequestMethod.POST, RequestMethod.GET})
	@Token(save = true)
	public void ajaxCodeSearch(HttpServletRequest request, HttpServletResponse response) throws Exception{
		/**
         * [KO] 업무분류 조회.<br>
         * [EN] <br>
         * [JP] <br>
         * 
         * @throws Exception Exception
         */

        //System.out.println("ajaxWorkSort/init.do");


        JSONObject jsonObj = new JSONObject();
		String result = DnkrConstans.RESULT_N;
		
        String locCode = ServletRequestUtils.getStringParameter(request, "locCode");
		//System.out.println(locCode);

		CodeDb2Domain criteria = new CodeDb2Domain();
		if("LOC000001".equals(locCode)){	//구KA환경
			criteria.setLib4("CLTDTAS");
		}else if("LOC000004".equals(locCode)){	//구KE환경
			criteria.setLib4("CLTDTAE");
		}else if("LOC000000".equals(locCode)){	//통합JDE라이브러리
			criteria.setLib4("CLTDTA");
		}
		criteria.setMcstyl("EX");
		criteria.setMcrp11("001");
		
		List<CodeDb2Domain> codeF0006LBList = null;
		try {
			codeF0006LBList = codeService.comCodeJdeF0006LB(criteria);
			//System.out.println(codeF0901List);
		} catch (Exception e) {
			System.out.println("데이터가 없습니다.");
		}			
		if (codeF0006LBList != null) {
			result = DnkrConstans.RESULT_Y;
			//jsonObj.put("result", result);
			jsonObj.put("list", codeF0006LBList);
		}
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }
}
