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

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.JsonView;
import com.globaldenso.dnkr.business.service.CodeService;
import com.globaldenso.dnkr.business.service.db2.ManagementInfomationService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.db2.DailyDepartmentCostDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAE001MngSearchForm;
import com.globaldenso.dnkr.presentation.form.dwh.WAE036DailyDepartmentCostForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KO] 월적상 CheckList 조회 Controller.<br>
 * [JP] <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAE036DailyDepartmentCostSearch")
@ViewId(value = "WAE036")
public class WAE036DailyDepartmentCostController {

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
	public WAE036DailyDepartmentCostController() {
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
	public ModelAndView initMonthlyShipmentCheckList(HttpServletRequest request,
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

		mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
		mv.addObject("tabId", tabId);
		mv.addObject("menu", menu);
		mv.addObject("paraDomain", form);
		mv.addObject("url", "WAE036DailyDepartmentCost.jsp");
		mv.setViewName(".tiles.page.WAE036DailyDepartmentCost");
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
	public ModelAndView dailyDepartmentCostSearch(HttpServletRequest request,
			@ModelAttribute("WAE036DailyDepartmentCostForm") WAE036DailyDepartmentCostForm form)
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
		/*
		String company = form.getCompany();
		if("PE".equals(company)){
			form.setLib1("PERESLIB");
			form.setLib2("PSEDBLIB");
		}else{
			form.setLib1("PSRESLIB");
			form.setLib2("PSCDBLIB");
		}		
		*/
		//System.out.println(form.getpYear()+form.getpMonth());
		List<DailyDepartmentCostDomain> dailyDepartmentCostList = null;
		
		try {
			dailyDepartmentCostList = mifService.searchByDailyDepartmentCost(form);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dailyDepartmentCostList != null) {
			result = DnkrConstans.RESULT_Y;
			jsonObj.put("list", dailyDepartmentCostList);
		}
		
		jsonObj.put("result", result);

		model.addObject("jsonString", jsonObj.toString());
		return model;
	}
	
}
