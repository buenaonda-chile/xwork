/*
 * Project : NEW DIONE PROJECT
 *
 * $Id$
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.presentation.controller.dwh;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;
import com.globaldenso.dnkr.domain.db2.MaterialReceivingDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAE001MngSearchForm;
import com.globaldenso.dnkr.presentation.form.basic.WAE007MaterialReceivingSearchForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KO] 부품입고현황의 조회 Controller.<br>
 * [JP] <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAE001MaterialReceivingSearch")
@ViewId(value = "WAE001")
public class WAE001MaterialReceivingSearchController {

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
	public WAE001MaterialReceivingSearchController() {
		// no process
	}

	/**
	 * 부품입고현황초기화면[KR] <br>
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAE001MaterialReceivingSearchForm
	 * @return ModelAndView
	 * @throws Exception Exception
	 */
	@RequestMapping(value = "/init", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView initMaterialReceiving(HttpServletRequest request,
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

		// 사업부
		UxisCmmUtil.getSessionLoc(request, mv);
		
		mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
		mv.addObject("tabId", tabId);
		mv.addObject("menu", menu);
		mv.addObject("paraDomain", form);
		mv.addObject("url", "WAE001MaterialReceiving.jsp");
		mv.setViewName(".tiles.page.WAE001MaterialReceiving");
		return mv;
	}

	/**
	 * 부품입고현황 데이터 조회
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAE001MaterialReceivingSearchForm
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/ajaxSearch", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView materialReceivingSearch(HttpServletRequest request,
			@ModelAttribute("WAE007MaterialReceivingSearchForm") WAE007MaterialReceivingSearchForm form)
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
		UxisCmmUtil.getCompsLib(form);

		if (form.getYear() == null) {
			SimpleDateFormat datafmt = new SimpleDateFormat("yyyy");
			Calendar calendar = Calendar.getInstance();
			String thisYear = datafmt.format(calendar.getTime());
			form.setStartDate(thisYear + "0101");
			form.setEndDate(thisYear + "1231");
		} else {
			form.setStartDate(form.getYear() + "0101");
			form.setEndDate(form.getYear() + "1231");
		}

		List<MaterialReceivingDomain> materialReceivingList = null;
		List<CommonDb2Domain> vnameList = null;
		try {
			materialReceivingList = mifService.searchByMaterialReceiving(form);
			vnameList = mifService.searchByVennam(form);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (materialReceivingList != null && vnameList != null) {
			result = DnkrConstans.RESULT_Y;
			jsonObj.put("list", materialReceivingList);
			jsonObj.put("vnameList", vnameList);
		}

		jsonObj.put("result", result);

		model.addObject("jsonString", jsonObj.toString());
		return model;
	}
	
}
