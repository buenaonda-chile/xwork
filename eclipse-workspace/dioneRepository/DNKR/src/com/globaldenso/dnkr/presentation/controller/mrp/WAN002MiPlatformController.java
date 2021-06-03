/*
 * Project : NEW DIONE PROJECT
 *
 * $Id$
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.presentation.controller.mrp;

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
import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;
import com.globaldenso.dnkr.domain.db2.MaterialReceivingDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAE001MngSearchForm;
import com.globaldenso.dnkr.presentation.form.basic.WAE007MaterialReceivingSearchForm;
import com.globaldenso.dnkr.presentation.form.basic.WAN001DioneViewForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KO] 구 디오네 변환 Controller.<br>
 * [JP] <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAN002MiPlatform")
@ViewId(value = "WAN002")
public class WAN002MiPlatformController {

	/**
	 * [EN] Default constructor.<br>
	 * [JP] デフォルトコンストラクタ。<br>
	 */
	public WAN002MiPlatformController() {
		// no process
	}

	/**
	 * 구디오네 변환 Viewing 로직 <br>
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAN001MiPlatform
	 * @return ModelAndView
	 * @throws Exception Exception
	 */
	@RequestMapping(value = "/init", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView dioneEmbedde(HttpServletRequest request,
			@ModelAttribute("WAN001DioneViewForm") WAN001DioneViewForm form)
			throws Exception {
		
		request.getSession().setAttribute(DnkrConstans.ATTRIB_KEY_MIPLATFORM_SETUP, "INITIALIZE");
		/**
		 * <pre>
		 *             
		 * 1.[JP]           
		 *   [EN] Screen initialization processing.         
		 *   [EN]   I acquire Log information and display it to a screen
		 * </pre>
		 */
		String forwardTabId = ServletRequestUtils.getStringParameter(request, "tabId");
		String forwardMenu =ServletRequestUtils.getStringParameter(request, "menu");
		
		// Tab, 메뉴 기본 처리
		String tabId = "tabDiv0";//ServletRequestUtils.getStringParameter(request, "tabId");
		String menu = "1129";// ServletRequestUtils.getStringParameter(request, "menu");
		
		
		ModelAndView mv = new ModelAndView();
		String bb = request.getSession().getAttribute(DnkrConstans.ATTRIB_KEY_MIPLATFORM_PGM_ID).toString();		
		String mode = request.getSession().getAttribute(DnkrConstans.ATTRIB_KEY_MIPLATFORM_PGM_MODE).toString();//마이플렛폼 기본컨텐츠와 팝업컨텐츠 분계 - 2019.05.08 JHB
		
		//System.out.println("WAN001DioneViewForm");
		mv.addObject("pgmID", request.getSession().getAttribute(DnkrConstans.ATTRIB_KEY_MIPLATFORM_PGM_ID));
		mv.addObject("company", request.getSession().getAttribute(DnkrConstans.ATTRIB_KEY_MIPLATFORM_COMPANY_CODE));
		mv.addObject("mode", request.getSession().getAttribute(DnkrConstans.ATTRIB_KEY_MIPLATFORM_PGM_MODE)); //마이플렛폼 기본컨텐츠와 팝업컨텐츠 분계 - 2019.05.08 JHB
		mv.addObject("tabId", tabId);
		mv.addObject("menu", menu);		
		mv.addObject("paraDomain", form);
		mv.addObject("url", "WAN002DioneInstaller.jsp");
		mv.setViewName(".tiles.page.WAN002DioneInstaller");
		return mv;
	}
	
	/**
	 * Miplatform Setting 성공 확인
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAE001MaterialReceivingSearchForm
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/ajaxSuccess", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView ajaxSuccess(HttpServletRequest request,
			@ModelAttribute("WAN001DioneViewForm") WAN001DioneViewForm form)
			throws Exception {

		/**
		 * <pre>
		 *     1. Miplatform 셋팅이 완료 되면 Request Session Class 에 값을 넣어준다.   
		 * </pre>
		 */

		ModelAndView model = new ModelAndView(new JsonView());
		JSONObject jsonObj = new JSONObject();
		
		request.getSession().setAttribute(DnkrConstans.ATTRIB_KEY_MIPLATFORM_SETUP, "SUCCESS");
		//System.out.println(request.getSession().getAttribute(DnkrConstans.ATTRIB_KEY_MIPLATFORM_SETUP));
		jsonObj.put("result", DnkrConstans.RESULT_Y);

		model.addObject("jsonString", jsonObj.toString());
		return model;
	}
	
}
