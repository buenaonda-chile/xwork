/*
 * Project : NEW DIONE PROJECT
 *
 * $Id$
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.presentation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.db2.ImportInventoryPopDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAE001MngSearchForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KO] Mainpage Popup Controller.<br>
 * [JP] <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAA001MainPopup")
@ViewId(value = "WAA001")
public class WAA001MainPopupController {

	
	/**
	 * [KR] 공통코드관리 서비스 <br>
	 */
	@Autowired
	private CodeService codeService;

	/**
	 * [EN] Default constructor.<br>
	 * [JP] デフォルトコンストラクタ。<br>
	 */
	public WAA001MainPopupController() {
		// no process
	}

	/**
	 * DisplaySession ID선택  초기화면[KR] <br>
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAE001MngSearchForm
	 * @return ModelAndView
	 * @throws Exception Exception
	 */
	@RequestMapping(value = "/sessionIdSelectPop", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView initFakeSalesCheckList(HttpServletRequest request,
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
		
		ModelAndView mv = new ModelAndView();
		
		String userIdPantCd = ServletRequestUtils.getStringParameter(request, "userIdPantCd");
		//dioneId::E030191!plantCd::E1,dioneId::S030191!plantCd::S1,
		
		String[] arrayStr= userIdPantCd.split(",");
		List<HashMap> idList = new ArrayList();
		HashMap<String, String> map = new HashMap<String, String>();
		//System.out.println(arrayStr.length);
		String[] arrayStr2 = null;
		for(String gArrayStr: arrayStr){
			arrayStr2 = gArrayStr.split("!");
			map = new HashMap<String, String>();
			for(String gArrayStr2: arrayStr2){
				//System.out.println(gArrayStr2.split("::")[0].trim()+"=="+ gArrayStr2.split("::")[1].trim());
				map.put(gArrayStr2.split("::")[0].trim(), gArrayStr2.split("::")[1].trim());
            }
			idList.add(map);
		}
		//System.out.println(idList);

		//UxisCmmUtil.getSessionLoc(request, mv);	// 사업부

		mv.addObject("paraDomain", form);
		mv.addObject("idList", idList);
		mv.addObject("url", "WAA001SessionIdSelectPop.jsp");
		mv.setViewName(".tiles.page.WAA001SessionIdSelectPop");
		return mv;
	}	
}
