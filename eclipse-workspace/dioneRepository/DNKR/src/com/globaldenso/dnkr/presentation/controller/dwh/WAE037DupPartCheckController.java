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
import com.globaldenso.dnkr.domain.db2.DuplicationPartDomain;
import com.globaldenso.dnkr.presentation.form.dwh.WAE037DupPartCheckForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KO] [종합관리]-[생산정보]-품번 중복 리스트 Controller.<br>
 * [JP] <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAE037DupPartCheck")
@ViewId(value = "WAE037")
public class WAE037DupPartCheckController {

	/**
	 * [KR] 종합관리 서비스 <br>
	 */
	@Autowired
	private ManagementInfomationService mifService;

	/**
	 * [EN] Default constructor.<br>
	 * [JP] デフォルトコンストラクタ。<br>
	 */
	public WAE037DupPartCheckController() {
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
			@ModelAttribute("WAE037DupPartCheckForm") WAE037DupPartCheckForm form)
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
		mv.addObject("year", "");
		mv.addObject("paraDomain", form);
		mv.addObject("url", "WAE037DupPartCheck.jsp");
		mv.setViewName(".tiles.page.WAE037DupPartCheck");
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
			@ModelAttribute("WAE037DupPartCheckForm") WAE037DupPartCheckForm form)
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

		List<DuplicationPartDomain> duplicationPartList = null;
		
			try {
				duplicationPartList = mifService.searchByDupPartCheck(form);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (duplicationPartList != null) {
				result = DnkrConstans.RESULT_Y;
				jsonObj.put("list", duplicationPartList);
			}
		
		jsonObj.put("result", result);

		model.addObject("jsonString", jsonObj.toString());
		return model;
	}
	
}
