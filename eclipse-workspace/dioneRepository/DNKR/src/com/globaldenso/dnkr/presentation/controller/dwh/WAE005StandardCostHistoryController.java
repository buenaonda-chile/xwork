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
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.db2.CodeDb2Domain;
import com.globaldenso.dnkr.domain.db2.MaterialCostByPeriodDomain;
import com.globaldenso.dnkr.domain.db2.PurchasePriceDomain;
import com.globaldenso.dnkr.domain.db2.SalesPlanMaterialCostDomain;
import com.globaldenso.dnkr.presentation.form.dwh.WAE002PurchasePriceForm;
import com.globaldenso.dnkr.presentation.form.dwh.WAE003SalesPlanMaterialCostForm;
import com.globaldenso.dnkr.presentation.form.dwh.WAE005StandardCostHistoryForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KO] Standard Cost 이력현황 Controller.<br>
 * [JP] <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAE005StandardCostHistory")
@ViewId(value = "WAE005")
public class WAE005StandardCostHistoryController {

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
	public WAE005StandardCostHistoryController() {
		// no process
	}

	/**
	 * Standard Cost 이력현황 초기화면[KR] <br>
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAE001MaterialReceivingSearchForm
	 * @return ModelAndView
	 * @throws Exception Exception
	 */
	@RequestMapping(value = "/init", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView initStandardCostHistory(HttpServletRequest request,
			@ModelAttribute("WAE005StandardCostHistoryForm") WAE005StandardCostHistoryForm form)
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

		// 세션 저장된 데이터 불러오기
		EmpDb2Domain empInfo = (EmpDb2Domain) request.getSession().getAttribute("ACCOUNT_DB2");

		CodeDb2Domain codeDomain = new CodeDb2Domain();
		codeDomain.setDb2class("PLNT");
		codeDomain.setCoded1(empInfo.getCompany());

		List<CodeDb2Domain> codeList = null;
		// 사업부 정보
		try {
			codeList = codeService.comCode(codeDomain);			
		} catch (Exception e) {
			System.out.println("데이터가 없습니다.");
		}
		
		mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
		mv.addObject("tabId", tabId);
		mv.addObject("menu", menu);
		mv.addObject("codeList", codeList);
		mv.addObject("paraDomain", form);
		mv.addObject("url", "WAE005StandardCostHistory.jsp");
		mv.setViewName(".tiles.page.WAE005StandardCostHistory");
		return mv;
	}

	/**
	 * Standard Cost 이력현황 조회
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAE001MaterialReceivingSearchForm
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/ajaxSearch", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView standardCostHistorySearch(HttpServletRequest request,
			@ModelAttribute("WAE005StandardCostHistoryForm") WAE005StandardCostHistoryForm form)
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

		// 세션 저장된 데이터 불러오기
		EmpDb2Domain empInfo = (EmpDb2Domain) request.getSession().getAttribute("ACCOUNT_DB2");
		form.setComps(empInfo.getPlantCd());
		form.setLib1(empInfo.getLib1());
		form.setLib2(empInfo.getLib2());
		
		List<MaterialCostByPeriodDomain> standardCostHistoryList = null;
		try {
				standardCostHistoryList = mifService.standardCostHistoryList(form);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (standardCostHistoryList != null ) {
			result = DnkrConstans.RESULT_Y;
			jsonObj.put("list", standardCostHistoryList);
		}

		jsonObj.put("result", result);

		model.addObject("jsonString", jsonObj.toString());
		return model;
	}
	
}
