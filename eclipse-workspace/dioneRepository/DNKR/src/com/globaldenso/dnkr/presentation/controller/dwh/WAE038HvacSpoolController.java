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
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.JsonView;
import com.globaldenso.dnkr.business.service.CodeService;
import com.globaldenso.dnkr.business.service.db2.ManagementInfomationService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.db2.CodeDb2Domain;
import com.globaldenso.dnkr.domain.db2.HvacSpoolDomain;
import com.globaldenso.dnkr.presentation.form.dwh.WAE038HvacSpoolForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KO] [종합관리]- HVAC Spool Controller.<br>
 * [JP] <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAE038HvacSpool")
@ViewId(value = "WAE038")
public class WAE038HvacSpoolController {

	/**
	 * [KR] 공통코드관리 서비스 <br>
	 */
	@Autowired
	private CodeService codeService;
	
	/**
	 * [KR] 종합관리 서비스 <br>
	 */
	@Autowired
	private ManagementInfomationService mifService;

	/**
	 * [EN] Default constructor.<br>
	 * [JP] デフォルトコンストラクタ。<br>
	 */
	public WAE038HvacSpoolController() {
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
			@ModelAttribute("WAE038HvacSpoolForm") WAE038HvacSpoolForm form)
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

		//System.out.println(form.getCompany());
		//제품코드
		CodeDb2Domain codePrdcdDomain = new CodeDb2Domain();
		codePrdcdDomain.setComps("C1"); //구KA전용
		codePrdcdDomain.setLib2("PSCDBLIB");	//TEST용
		codePrdcdDomain.setGrpcd("PRD");//제풐
		codePrdcdDomain.setMstgu("$");//제외코드
		List<CodeDb2Domain> codePrdcdList = null;
		try {
			codePrdcdList = codeService.comCodeMst050(codePrdcdDomain);	
		} catch (Exception e) {
			System.out.println("데이터가 없습니다.");
		}
		mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
		mv.addObject("tabId", tabId);
		mv.addObject("menu", menu);
		mv.addObject("year", "");
		mv.addObject("codePrdcdList", codePrdcdList);
		mv.addObject("paraDomain", form);
		mv.addObject("url", "WAE038HvacSpool.jsp");
		mv.setViewName(".tiles.page.WAE038HvacSpool");
		return mv;
	}

	/**
	 * [종합관리] - [판매정보] - 출하매출현황 데이터 조회
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAE038HvacSpoolForm
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/ajaxSearch", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView hvacSpool(HttpServletRequest request,
			@ModelAttribute("WAE038HvacSpoolForm") WAE038HvacSpoolForm form)
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
		List<HvacSpoolDomain> hvacSpoolList = null;
		
			try {
				hvacSpoolList = mifService.searchByHvacSpool(form);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (hvacSpoolList != null) {
				result = DnkrConstans.RESULT_Y;
				jsonObj.put("list", hvacSpoolList);
			}
		
		jsonObj.put("result", result);

		model.addObject("jsonString", jsonObj.toString());
		return model;
	}
	
	@RequestMapping(value = "/ajaxCodeSearch", method = {RequestMethod.POST, RequestMethod.GET})
	@Token(save = true)
	public void ajaxCodeSearch(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("WAE038HvacSpoolForm") WAE038HvacSpoolForm form) throws Exception{
		/**
         * [KO] 업무분류 조회.<br>
         * [EN] <br>
         * [JP] <br>
         * 
         * @throws Exception Exception
         */

        JSONObject jsonObj = new JSONObject();
		String result = DnkrConstans.RESULT_N;
				
		//제품코드
		CodeDb2Domain criteria = new CodeDb2Domain();
		
		UxisCmmUtil.getCompsLib(form);
        //System.out.println(form.getLocCode()+"=="+form.getComps()+"=="+form.getLib2()+"=="+form.getSearchHouse()+"=="+ form.getSearchPrdcd());

		criteria.setComps(form.getComps());
		criteria.setLib2(form.getLib2());
		criteria.setGrpcd("PRD");//제풐
		criteria.setMstgu("$");//제외코드

		List<CodeDb2Domain> codePrdcdList = null;
		try {
			codePrdcdList = codeService.comCodeMst050(criteria);	
		} catch (Exception e) {
			System.out.println("데이터가 없습니다.");
		}
		//if (codePrdcdList != null) {	//없는 공장도 있음.
			result = DnkrConstans.RESULT_Y;
			//jsonObj.put("result", result);
			jsonObj.put("list", codePrdcdList);
		//}
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }
	
}
