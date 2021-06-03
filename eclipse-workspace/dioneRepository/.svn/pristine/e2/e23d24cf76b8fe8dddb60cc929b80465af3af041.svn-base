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
import com.globaldenso.dnkr.domain.db2.ProductInventoryDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAE001MngSearchForm;
import com.globaldenso.dnkr.presentation.form.dwh.WAE020ProductInventoryCostForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KO] 제품입출고 조회 Controller.<br>
 * [JP] <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAE020ProductInventoryCostSearch")
@ViewId(value = "WAE020")
public class WAE020ProductInventoryCostController {

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
	public WAE020ProductInventoryCostController() {
		// no process
	}

	/**
	 * 제품입출고조회 초기화면[KR] <br>
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAE001MngSearchForm
	 * @return ModelAndView
	 * @throws Exception Exception
	 */
	@RequestMapping(value = "/init", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView initProductInventoryCost(HttpServletRequest request,
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
		/*
		// 세션 저장된 데이터 불러오기
		EmpDb2Domain empInfo = (EmpDb2Domain) request.getSession().getAttribute("ACCOUNT_DB2");

		//사업부 코드
		CodeDb2Domain codeDomain = new CodeDb2Domain();
		codeDomain.setDb2class("PLNT");
		codeDomain.setCoded1("PS");
		codeDomain.setCoded1(empInfo.getCompany());

		List<CodeDb2Domain> codeList = null;	//사업부코드
		try {
			codeList = codeService.comCode(codeDomain);			
		} catch (Exception e) {
			System.out.println("데이터가 없습니다.");
		}
		*/
		UxisCmmUtil.getSessionLoc(request, mv);	// 사업부

		
		//창고코드
		CodeDb2Domain codeHouseDomain = new CodeDb2Domain();
		codeHouseDomain.setDb2class("HSCD");
		codeHouseDomain.setCoded1("PE");	//PS전용
		//codeHouseDomain.setCoded1(empInfo.getCompany());

		List<CodeDb2Domain> codeHouseList = null;
		try {
			codeHouseList = codeService.comCode(codeHouseDomain);
		} catch (Exception e) {
			System.out.println("데이터가 없습니다.");
		}
		//차고 전체 추가
		if("PE".equals(codeHouseDomain.getCode1())){
			CodeDb2Domain codeHouseAddDomain = new CodeDb2Domain();
			codeHouseAddDomain.setCode2("0");
			codeHouseAddDomain.setCode_name("전체");
			codeHouseList.add(codeHouseAddDomain);				
		}
				
		mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
		mv.addObject("tabId", tabId);
		mv.addObject("menu", menu);
		//mv.addObject("codeList", codeList);
		mv.addObject("codeHouseList", codeHouseList);
		mv.addObject("paraDomain", form);
		mv.addObject("url", "WAE020ProductInventoryCost.jsp");
		mv.setViewName(".tiles.page.WAE020ProductInventoryCost");
		return mv;
	}

	/**
	 * 제품입출고 데이터 조회
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAE020ProductInventoryCostForm
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/ajaxSearch", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView productInventoryCostSearch(HttpServletRequest request,
			@ModelAttribute("WAE020ProductInventoryCostForm") WAE020ProductInventoryCostForm form)
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
		/*
		// 세션 저장된 데이터 불러오기
		EmpDb2Domain empInfo = (EmpDb2Domain) request.getSession().getAttribute("ACCOUNT_DB2");
		
		form.setCompany(empInfo.getCompany());	//사업부코드
		form.setLib1(empInfo.getLib1());	//라이브러리1
		form.setLib2(empInfo.getLib2());	//라이브러리2
		*/
		// 라이브러리 comps 셋팅
		UxisCmmUtil.getCompsLib(form);
		if("E1".equals(form.getComps())){
			form.setCompany("PE");
		}else{
			form.setCompany("PS");
		}

		SimpleDateFormat datafmt = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		String thisYear = datafmt.format(calendar.getTime());
		System.out.println(thisYear);
		form.setStartDate(thisYear);
				
		List<ProductInventoryDomain> productInventoryList = null;
		try {
			productInventoryList = mifService.searchByProductInventoryCost(form);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (productInventoryList != null) {
			result = DnkrConstans.RESULT_Y;
			jsonObj.put("list", productInventoryList);
		}

		jsonObj.put("result", result);

		model.addObject("jsonString", jsonObj.toString());
		return model;
	}
	
}
