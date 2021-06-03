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
import com.globaldenso.dnkr.business.service.db2.ManagementInfomationService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.db2.DataWarehouseFileDomain;
import com.globaldenso.dnkr.domain.db2.ImportDressingHistoryDomain;
import com.globaldenso.dnkr.domain.db2.ImportsTradeDomain;
import com.globaldenso.dnkr.presentation.form.dwh.WAE011ImportDressingHistoryForm;
import com.globaldenso.dnkr.presentation.form.dwh.WAE012ImportsTradeForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KO] 진매상OCEAN LIST Controller.<br>
 * [JP] <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAE011ImportDressingHistorySearch")
@ViewId(value = "WAE011")
public class WAE011ImportDressingHistoryController {

	/**
	 * [KR] 경영관리 서비스 <br>
	 */
	@Autowired
	private ManagementInfomationService mifService;

	/**
	 * [EN] Default constructor.<br>
	 * [JP] デフォルトコンストラクタ。<br>
	 */
	public WAE011ImportDressingHistoryController() {
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
	public ModelAndView initImportsTradeController(HttpServletRequest request,
			@ModelAttribute("WAE011ImportDressingHistoryForm") WAE011ImportDressingHistoryForm form)
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
		mv.addObject("url", "WAE011ImportDressingHistory.jsp");
		mv.setViewName(".tiles.page.WAE011ImportDressingHistory");
		return mv;
	}

	/**
	 * OCEANS LIST
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAE004ProductShippingReceivingSearchForm
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/ajaxSearch", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView importsTradeSearch(HttpServletRequest request,
			@ModelAttribute("WAE011ImportDressingHistoryForm") WAE011ImportDressingHistoryForm form)
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

		UxisCmmUtil.getCompsLib(form);	// 라이브러리 comps 셋팅

		List<ImportDressingHistoryDomain> importDressingHistoryList = null;
		try {
			importDressingHistoryList = mifService.searchByImportDressingHistory(form);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (importDressingHistoryList != null) {
			result = DnkrConstans.RESULT_Y;
			jsonObj.put("list", importDressingHistoryList);
		}
		
		jsonObj.put("result", result);

		model.addObject("jsonString", jsonObj.toString());
		return model;
	}
	
}
