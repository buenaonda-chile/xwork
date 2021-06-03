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
import org.json.simple.parser.JSONParser;
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
import com.globaldenso.dnkr.domain.db2.WipReportDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAE001MngSearchForm;
import com.globaldenso.dnkr.presentation.form.dwh.WAE032WipReportForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KO] 자재입출고 재고현황 조회 Controller.<br>
 * [JP] <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAE032WipReportSearch")
@ViewId(value = "WAE032")
public class WAE032WipReportController {

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
	public WAE032WipReportController() {
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
	public ModelAndView initWipReport(HttpServletRequest request,
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

		UxisCmmUtil.getSessionLoc(request, mv);	// 사업부(공장)
		//UxisCmmUtil.getSessionCls(request, mv);// 사업부
		//System.out.println("CLS CODE : "+form.getClsCode());
		//System.out.println("LOC CODE : "+form.getLocCode());
		
        String empInfo = request.getSession().getAttribute("ACCOUNT").toString();
        JSONParser parser = new JSONParser();
        Object empInfoObj       = parser.parse(empInfo);
        JSONObject empJsonObj   = (JSONObject)empInfoObj;
        String empCls        = (String)empJsonObj.get("clsCode");        //사용자 사업부
        String empLoc        = (String)empJsonObj.get("locCode");        //사용자 공장
        
        form.setClsCode(empCls);
        form.setLocCode(empLoc);
		//System.out.println("LOC CODE : "+empLoc);
		//System.out.println("CLS CODE : "+form.getClsCode());
		//System.out.println("LOC CODE : "+form.getLocCode());

		mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
		mv.addObject("tabId", tabId);
		mv.addObject("menu", menu);
		mv.addObject("year", "");
		mv.addObject("paraDomain", form);
		mv.addObject("url", "WAE032WipReport.jsp");
		mv.setViewName(".tiles.page.WAE032WipReport");
		return mv;
	}

	/**
	 * 자재입출고 재고현황 데이터 조회
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAE019MaterialInventoryForm
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/ajaxSearch", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView wipReportSearch(HttpServletRequest request,
			@ModelAttribute("WAE032WipReportForm") WAE032WipReportForm form)
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
		List<WipReportDomain> wipReportList = null;
		
		if(dwhDomain2 != null){
			year =dwhDomain2.getJyymm();
			jsonObj.put("year", year);
			try {
				wipReportList = mifService.searchByWipReport(form);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (wipReportList != null) {
				result = DnkrConstans.RESULT_Y;
				jsonObj.put("list", wipReportList);
			}
		}
		
		jsonObj.put("result", result);

		model.addObject("jsonString", jsonObj.toString());
		return model;
	}
	
}
