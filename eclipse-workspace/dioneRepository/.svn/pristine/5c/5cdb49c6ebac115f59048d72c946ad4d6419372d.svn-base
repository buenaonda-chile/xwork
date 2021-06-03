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
import com.globaldenso.dnkr.domain.db2.CodeDb2Domain;
import com.globaldenso.dnkr.domain.db2.ProductStockShippingReceivingDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAE001MngSearchForm;
import com.globaldenso.dnkr.presentation.form.dwh.WAE015ProductStockShippingReceivingForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KO] 제품입출고 조회 Controller.<br>
 * [JP] <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAE015ProductStockShippingReceivingSearch")
@ViewId(value = "WAE015")
public class WAE015ProductStockShippingReceivingController {

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
	public WAE015ProductStockShippingReceivingController() {
		// no process
	}

	/**
	 * 제품입출고조회 초기화면[KR] <br>
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAE004ProductShippingReceivingSearchForm
	 * @return ModelAndView
	 * @throws Exception Exception
	 */
	@RequestMapping(value = "/init", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView initProductStockShippingReceiving(HttpServletRequest request,
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

		// 세션 저장된 데이터 불러오기
		EmpDb2Domain empInfo = (EmpDb2Domain) request.getSession().getAttribute("ACCOUNT_DB2");

		//사업부 코드
		CodeDb2Domain codeDomain = new CodeDb2Domain();
		codeDomain.setDb2class("PLNT");
		codeDomain.setCoded1(empInfo.getCompany());

		List<CodeDb2Domain> codeList = null;	//사업부코드
		try {
			codeList = codeService.comCode(codeDomain);			
		} catch (Exception e) {
			System.out.println("데이터가 없습니다.");
		}
		//창고코드
		CodeDb2Domain codeHouseDomain = new CodeDb2Domain();
		codeHouseDomain.setDb2class("HSCD");
		codeHouseDomain.setCoded1(empInfo.getCompany());

		List<CodeDb2Domain> codeHouseList = null;	//사업부코드
		try {
			codeHouseList = codeService.comCode(codeHouseDomain);			
		} catch (Exception e) {
			System.out.println("데이터가 없습니다.");
		}		
				
		mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
		mv.addObject("tabId", tabId);
		mv.addObject("menu", menu);
		mv.addObject("codeList", codeList);
		mv.addObject("codeHouseList", codeHouseList);
		mv.addObject("paraDomain", form);
		mv.addObject("url", "WAE015ProductStockShippingReceiving.jsp");
		mv.setViewName(".tiles.page.WAE015ProductStockShippingReceiving");
		return mv;
	}

	/**
	 * 제품입출고 데이터 조회
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAE004ProductShippingReceivingSearchForm
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/ajaxSearch", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView productStockShippingReceivingSearch(HttpServletRequest request,
			@ModelAttribute("WAE01ProductStockShippingReceivingForm") WAE015ProductStockShippingReceivingForm form)
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

		
		System.out.println(form.getComps()+form.getYear()+form.getHouse());
		// 세션 저장된 데이터 불러오기
		EmpDb2Domain empInfo = (EmpDb2Domain) request.getSession().getAttribute("ACCOUNT_DB2");
		//form.setComps(empInfo.getPlantCd());
		form.setLib1(empInfo.getLib1());
		form.setLib2(empInfo.getLib2());

		if (form.getYear() == null) {
			SimpleDateFormat datafmt = new SimpleDateFormat("yyyy");
			Calendar calendar = Calendar.getInstance();
			String thisYear = datafmt.format(calendar.getTime());
			form.setStartDate(thisYear + "0101");
		} else {
			form.setStartDate(form.getYear() + "0101");
		}

		List<ProductStockShippingReceivingDomain> productShippingReceivingList = null;
		//List<CommonDb2Domain> vnameList = null;
		try {
			productShippingReceivingList = mifService.searchByProductStockShippingReceiving(form);
			//vnameList = mifService.searchByVennam(form);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (productShippingReceivingList != null) {
		//if (productShippingReceivingList != null && vnameList != null) {
			result = DnkrConstans.RESULT_Y;
			jsonObj.put("list", productShippingReceivingList);
			//jsonObj.put("vnameList", vnameList);
		}

		jsonObj.put("result", result);

		model.addObject("jsonString", jsonObj.toString());
		return model;
	}
	
}
