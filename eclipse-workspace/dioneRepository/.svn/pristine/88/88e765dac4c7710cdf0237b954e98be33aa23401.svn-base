/*
 * Project : NEW DIONE PROJECT
 *
 * $Id$
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.presentation.controller.mrp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.CodeService;
import com.globaldenso.dnkr.business.service.db2.ManagementInfomationService;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.db2.CodeDb2Domain;
import com.globaldenso.dnkr.presentation.form.basic.WAE001MngSearchForm;
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
@RequestMapping(value = "/WAN003MiPlatform")
@ViewId(value = "WAN003")
public class WAN003MiPlatformController {

	/**
	 * [EN] Default constructor.<br>
	 * [JP] デフォルトコンストラクタ。<br>
	 */
	public WAN003MiPlatformController() {
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

		
		
		mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
		mv.addObject("tabId", tabId);
		mv.addObject("menu", menu);		
		mv.addObject("paraDomain", form);
		mv.addObject("url", "WAN003DioneInstaller.jsp");
		mv.setViewName(".tiles.page.WAN003DioneInstaller");
		return mv;
	}
	

	@RequestMapping(value = "/install", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView dioneInstall(HttpServletRequest request,
			@ModelAttribute("WAN001DioneViewForm") WAN001DioneViewForm form)
			throws Exception {
		
		/**
		 * <pre>
		 *             
		 * 1.[JP]           
		 *   [EN] Screen initialization processing.         
		 *   [EN]   I acquire Log information and display it to a screen
		 * </pre>
		 */
		System.out.println("wan003");
		

		ModelAndView mv = new ModelAndView();

		mv.addObject("paraDomain", form);
		mv.addObject("url", "WAN003DioneInstallerPop.jsp");
		mv.setViewName(".tiles.page.WAN003DioneInstallerPop");
		return mv;
	}
}
