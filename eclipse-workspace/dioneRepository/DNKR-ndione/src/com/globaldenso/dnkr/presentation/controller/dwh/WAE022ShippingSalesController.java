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
import com.globaldenso.dnkr.domain.db2.DataWarehouseFileDomain;
import com.globaldenso.dnkr.domain.db2.ShippingSalesDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAE001MngSearchForm;
import com.globaldenso.dnkr.presentation.form.dwh.WAE022ShippingSalesForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KO] [종합관리]-[판매정보]-출하매출현황 Controller.<br>
 * [JP] <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAE022ShippingSalesSearch")
@ViewId(value = "WAE022")
public class WAE022ShippingSalesController {

	/**
	 * [KR] 종합관리 서비스 <br>
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
	public WAE022ShippingSalesController() {
		// no process
	}

	/**
	 * [종합관리] - [판매정보] - 출하매출현황  초기화면[KR] <br>
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAE022ShippingSalesForm
	 * @return ModelAndView
	 * @throws Exception Exception
	 */
	@RequestMapping(value = "/init", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView initShippingSales(HttpServletRequest request,
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
		codeDomain.setCoded1(empInfo.getCompany());

		List<CodeDb2Domain> codeList = null;	//사업부코드
		try {
			codeList = codeService.comCode(codeDomain);			
		} catch (Exception e) {
			System.out.println("데이터가 없습니다.");
		}
 		*/
		UxisCmmUtil.getSessionLoc(request, mv);	// 사업부


		mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
		mv.addObject("tabId", tabId);
		mv.addObject("menu", menu);
		//mv.addObject("codeList", codeList);
		mv.addObject("year", "");
		mv.addObject("paraDomain", form);
		mv.addObject("url", "WAE022ShippingSales.jsp");
		mv.setViewName(".tiles.page.WAE022ShippingSales");
		return mv;
	}

	/**
	 * [종합관리] - [판매정보] - 출하매출현황 데이터 조회
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAE022ShippingSalesForm
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/ajaxSearch", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView shippingSalesSearch(HttpServletRequest request,
			@ModelAttribute("WAE022ShippingSalesForm") WAE022ShippingSalesForm form)
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
		//처리년월
		DataWarehouseFileDomain dwhDomain = new DataWarehouseFileDomain();
		dwhDomain.setLib2(form.getLib2());
		dwhDomain.setJobFileName(form.getJobFileName());
		DataWarehouseFileDomain dwhDomain2 = null;	//처리년월
		try {
			dwhDomain2 = mifService.searchByDwhCount(dwhDomain);			
		} catch (Exception e) {
			System.out.println("데이터가 없습니다.");
		}

		String year="";
		List<ShippingSalesDomain> shippingSalesList = null;
		
		if(dwhDomain2 != null){
			year =dwhDomain2.getJyymm();
			jsonObj.put("year", year);
			try {
				shippingSalesList = mifService.searchByShippingSales(form);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (shippingSalesList != null) {
				result = DnkrConstans.RESULT_Y;
				jsonObj.put("list", shippingSalesList);
			}
		}
		
		jsonObj.put("result", result);

		model.addObject("jsonString", jsonObj.toString());
		return model;
	}
	
}
